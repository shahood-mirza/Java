package SpaceGame;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

//main Space Game window where the game is played
public class SpaceGame extends JPanel {
    double x = screenX*0.47; //initial starting point for ship
    double y = screenY*0.47; //approximately the center of the screen
    
    double angle = 0;
    double theta = 0;

    double deltaX = 0;
    double deltaY = 0;

    int shipRadius = 30;
    int astRadius = 50;

    long startTime = System.currentTimeMillis(); // Get start time
    long elpsdTimeMilli;
    long elpsdTimeSec;
    int timeBtwnAst; //seconds between asteroids determined by level

    int totalAst = 100;
    int numAst = 0;
    boolean createAst = true;
    double[] astX = new double[totalAst];
    double[] astY = new double[totalAst];
    double[] astDirX = new double[totalAst];
    double[] astDirY = new double[totalAst];
    double[] angleAst = new double[totalAst];
    Image[] asteroid = new Image[totalAst];

    Image background;
    Image spaceShip;
    Image spaceShipF;

    boolean engineOn = false;
    boolean crashed = false;

    boolean upHeld = false;
    boolean leftHeld = false;
    boolean rightHeld = false;

    int score = 0;
    int check = 0;
    
    static int level;

    static Frame f;
    static SpaceGame SG;
    
    //screen window size (change for different resolutions)
    static int screenX = 1100;
    static int screenY = 650;
   
    //music/sound thread objects
    PlayBackgroundMusic PBM = new PlayBackgroundMusic();
    PlayContinuousRumble PCR = new PlayContinuousRumble();

    public SpaceGame(int level) {
        this.level = level;
        timeBtwnAst = level;
    }

    public static void main(String[] args) //application settings
    {
            f = new Frame();
            SG = new SpaceGame(level);

            f.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                };
            });

            f.add(SG);
            f.pack();
            SG.setFocusable(true); //for key input
            SG.init();
            f.setTitle("Space Game - Play");
            //f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setSize(screenX, screenY);
            f.setLocation(150, 40);
            f.setVisible(true);
            f.setResizable(false);
    }

    //picture initializations and starting threads
    public void init() {
    	int j = (int)(Math.random() * 6) + 1; //random background image
        
    	//load and initialize images
    	background = getToolkit().getImage(String.format("\\SpaceGame\\Space%d.jpg", j));
        spaceShip = getToolkit().getImage("\\SpaceGame\\SpaceShip.png");
        spaceShipF = getToolkit().getImage("\\SpaceGame\\SpaceShipFlame.png");
        
        //initialize asteroid array with asteroid images
        for (int i = 0; i < totalAst; i++)
            asteroid[i] = getToolkit().getImage("\\SpaceGame\\Asteroid.png");
        
        //timer used for key inputs, this is required to avoid OS delays on key presses
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                getKeyInput();
            }
        }, 0, 20); //check key inputs manually every few milliseconds

        PBM.play = true;
        PBM.start(); //start playing background music
        PCR.start(); //start checking for engine on sounds
    }

    public void getKeyInput()
        {
            if (!crashed) {
            	//see if a key is held down, multiple keys can be pressed at the same time
                if (IsKeyPressed.isUpPressed()) {
                    upHeld = true;
                } else {
                    engineOn = false;
                    PCR.engineOn = false; //change threaded value as well
                    upHeld = false;
                }
                if (IsKeyPressed.isLeftPressed()) {
                    leftHeld = true;
                } else
                    leftHeld = false;
                if (IsKeyPressed.isRightPressed()) {
                    rightHeld = true;
                } else
                    rightHeld = false;

                if (upHeld) {
                    engineOn = true;
                    PCR.engineOn = true; //change threaded value as well
                    deltaX = Math.sin(Math.toRadians(theta)); //sin and cos functions recognize only radian values
                    deltaY = Math.cos(Math.toRadians(theta));
                    if ((x + deltaX * 10) > 0 && (x + deltaX * 10) < screenX-70) //stop ship from going beyond margins
                        x += deltaX * 1; //round values to the nearest integer
                    if ((y - deltaY * 10) > 0 && (y - deltaY * 10) < screenY-90) //stop ship from going beyond margins
                        y -= deltaY * 1; //multiply by 10 to increase ship speed
                }
                if (leftHeld) {
                    angle -= 0.1 * 1; //allow for 360 rotations on the ship
                    theta = angle * (360 / 6.3); //convert angle from decimals to degrees
                    if (theta >= 360 || theta <= -360) //keep the angle within the boundary of 360 degrees
                        angle = 0;
                    if (theta < 0)
                        theta += 360; //always using a positive angle on a circular plane from 0-360 degrees
                }
                if (rightHeld) {
                    angle += 0.1 * 1; //allow for 360 rotations on the ship
                    theta = angle * (360 / 6.3); //convert angle from decimals to degrees
                    if (theta >= 360 || theta <= -360) //keep the angle within the boundary of 360 degrees
                        angle = 0;
                    if (theta < 0)
                        theta += 360; //always using a positive angle on a circular plane from 0-360 degrees
                }

                repaint();
            }
        }

    public void ASTupdate(Graphics g) //method for moving the asteroids
        {
            elpsdTimeMilli = System.currentTimeMillis() - startTime; //calculate elapsed time (in milliseconds)
            elpsdTimeSec = elpsdTimeMilli / 1000; //convert to seconds

            if ((elpsdTimeSec == timeBtwnAst) && (numAst < totalAst - 1)) //create an asteroid every 3 seconds
            {
                timeBtwnAst += level; //time check increase by level (easy-3 normal-2 hard-1) (keeps consistent time between asteroids)
                createAst = true;
                numAst++;
                score++; //score increases by one for every asteroid survived
            }

            if (createAst) {
                //asteroids are created outside the playing field
                //they can be created in four areas: on the top, left, right or bottom of the playing field
                switch ((int)(Math.random() * 4) + 1) //random integer between 1 and 4
                {
                    case 1: //create asteroid on the right of playing field
                        astX[numAst] = Math.round((Math.random() * 10) + (screenX+10)); //make asteroid within 10 pixels to the right of the box
                        astY[numAst] = Math.round((Math.random() * (screenY-10))); //keep asteroid within the height of the box
                        astDirX[numAst] = -1; //asteroid moving left
                        astDirY[numAst] = Math.round(((Math.random() * 2) - 1)); //random direction between -1 and 1
                        break;
                    case 2: //create asteroid on the bottom of playing field
                        astX[numAst] = Math.round((Math.random() * (screenX+10))); //keep asteroid within the width of the box
                        astY[numAst] = Math.round((Math.random() * 10) + (screenY-10)); //make asteroid within 10 pixels below the box
                        astDirY[numAst] = -1; //asteroid moving upwards
                        astDirX[numAst] = Math.round(((Math.random() * 2) - 1)); //random direction between -1 and 1
                        break;
                    case 3: //create asteroid on the left of playing field
                        astX[numAst] = Math.round((Math.random() * -10) - 50); //make asteroid within 50 pixels to the left of the box
                        astY[numAst] = Math.round((Math.random() * (screenY-10))); //keep asteroid within the height of the box
                        astDirX[numAst] = 1; //asteroid moving right
                        astDirY[numAst] = Math.round(((Math.random() * 2) - 1)); //random direction between -1 and 1
                        break;
                    case 4: //create asteroid on the top of playing field
                        astX[numAst] = Math.round((Math.random() * (screenX+10))); //keep asteroid within the width of the box
                        astY[numAst] = Math.round((Math.random() * -10) - 50); //make asteroid within 50 pixels above the box
                        astDirY[numAst] = 1; //asteroid moving downwards
                        astDirX[numAst] = Math.round(((Math.random() * 2) - 1)); //random direction between -1 and 1
                        break;
                }
                createAst = false;
            }

            for (int i = 0; i < numAst; i++) {
                Graphics2D g2d = (Graphics2D) g.create(); //using .create(), a copy of g is used

                g2d.rotate(angleAst[i], astX[i] + 58, astY[i] + 58); //rotate from centre of picture
                g2d.translate(astX[i], astY[i]); //move asteroid
                g2d.drawImage(asteroid[i], 0, 0, this);

                astX[i] += astDirX[i];
                astY[i] += astDirY[i];
                angleAst[i] += 0.03; //asteroid rotation speed

                g2d.dispose();

                if (collision()) {
                    engineOn = false; //turn of engine flame in the case of a crash
                    PCR.engineOn = false; //change threaded value as well
                    crashed = true;
                }
            }

            //once the ship starts moving it has a velocity
            if ((x + deltaX * 10) > 0 && (x + deltaX * 10) < screenX-70) //stop ship from going beyond margins
                x += deltaX * 5; //round values to the nearest integer
            if ((y - deltaY * 10) > 0 && (y - deltaY * 10) < screenY-90) //stop ship from going beyond margins
                y -= deltaY * 5; //multiply by 10 to increase ship speed

            if (!crashed) //only repaint if the ship has NOT crashed
                repaint();

            try {
                Thread.sleep(20); //this delay controls the speed of the asteroid movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create(); //using .create(), a copy of g is used

        g.drawImage(background, 0, 0, this);
        g.setColor(Color.white);
        g.drawRect(10, 10, screenX-30, screenY-50); //draw marginal rectangle at 10 pixels in
        											//with h/w slightly smaller than the applet size
        g.drawString("Score: " + score, 9, 9);	//show current score ontop of barrier 

        g2d.rotate(angle, x + 33, y + 34); //rotate from centre of picture
        if (engineOn) {
            g2d.translate(x, y); //move the ship
            g2d.drawImage(spaceShipF, 0, 0, this);
        } else if (!engineOn) {
            g2d.translate(x, y); //move the ship
            g2d.drawImage(spaceShip, 0, 0, this);
        }
        g2d.dispose();

        ASTupdate(g); //update asteroid pictures
    }

    //collision are checked by assuming the asteroids and ships are circular and a check is done to see if they
    //come within (asteroid radius + ship radius) of each other;  if they do, then the ship crashes and the game is over
    //a bit of overlap is allowed to prevent from too much error
    public boolean collision() {
        String name = "";
        double radiiSquared = Math.pow(astRadius + shipRadius, 2);

        for (int i = 0; i < numAst; i++) {
            double dxSquared = Math.pow(astX[i] - x, 2);
            double dySquared = Math.pow(astY[i] - y, 2);

            if (dxSquared + dySquared < radiiSquared) {
                if (check == 0) {
                    check++; //because of the keyboard input and repaint loops, some loops can still
                    		 //be continuing, after the collision, in the background
                    		 //this variable will make sure the code below  only runs once
                    PBM.play = false;
                    JOptionPane.showMessageDialog(this, "YOU CRASHED!!  Score: " + score, "BOOM", 2);

                    try {
                        while (name.equals(""))
                            name = JOptionPane.showInputDialog(this, "Please Enter Your Name:", "Highscores Entry", 1); //enter name for highscores
                    } catch (Exception e) {
                        name = "N/A";
                    }

                    f.dispose(); //try to clean up as many resources as possible
                    SG.removeAll();
                    this.removeAll();

                    StartScreen SS;

                    if (name.equals("N/A"))
                        SS = new StartScreen();
                    else
                        SS = new StartScreen(name, score);


                    SS.setVisible(true); //reopen the start screen
                }
                return true; //return true if collision occurred
            }
        }
        return false;
    }
}