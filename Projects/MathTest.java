import javax.swing.*; //package that has all the GUI classes
import javax.swing.border.*;
import java.awt.*; //package for classes like Container
import java.awt.event.*; //package for action listeners

/*
 * BY: SHAHOOD MIRZA
 *
 * SIMPLE MATH GAME/PROGRAM FOR AN INTRODUCTION TO GUIs AND JAVA SWING
 * A RANDOM MATH PROBLEM IS GENERATED AND CORRECT/INCORRECT ANSWERS ARE LOGGED
 */

public class MathTest extends JFrame implements ActionListener
{
	//create variables for gui elements
    Container c;
    Border brdrRaised = BorderFactory.createRaisedBevelBorder();
    JLabel lblQues, lblNum1, lblNum2, lblOper, lblEqual, lblComment, lblCorr, lblWrng, lblRightNum, lblWrongNum;
    JButton btnNext, btnAnswer;
    JTextField txtAnswer;
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    JPopupMenu popup;

	//variables for the main program logic
    boolean nextButtonOn = false;
    float right = 0, wrong = 0, quesCount = 0;
    int num1 = 0, num2 = 0;
    int ans = 0;

    public MathTest()
    {
		//set window title
        super("Math Trainer - v. 3.21");
        c = this.getContentPane();

		//other layouts can be used to compare and contrast the differences
        BorderLayout main = new BorderLayout();
        c.setLayout(main);

        JPanel northP = new JPanel();
        northP.setLayout(new GridLayout(5, 1));

        JPanel topP = new JPanel();
        topP.setLayout(new FlowLayout());

        lblQues = new JLabel("How much is:");

        topP.add(lblQues);

        JPanel quesP = new JPanel();
        quesP.setLayout(new GridLayout(1, 5));
		
		//generate random numbers
        num1 = (int)(Math.random() * 11);
        lblNum1 = new JLabel(String.valueOf(num1), SwingConstants.CENTER);

		//for now we will use only addition to show the concept
        lblOper = new JLabel("+", SwingConstants.CENTER);

        num2 = (int)(Math.random() * 11);
        lblNum2 = new JLabel(String.valueOf(num2), SwingConstants.CENTER);

        lblEqual = new JLabel("=", SwingConstants.CENTER);
        txtAnswer = new JTextField(10);
		
		//add the labels to the panel
        quesP.add(lblNum1);
        quesP.add(lblOper);
        quesP.add(lblNum2);
        quesP.add(lblEqual);
        quesP.add(txtAnswer);

        JPanel commentP = new JPanel();
        commentP.setLayout(new FlowLayout());

        lblComment = new JLabel("Lets see if you can get a perfect result!");

        commentP.add(lblComment);

        JPanel buttonP = new JPanel();
        GridLayout a = new GridLayout(1, 2);
        a.setHgap(10);
        a.setVgap(10);
        buttonP.setLayout(a);

        btnNext = new JButton("Next Question");
        btnNext.setEnabled(false);
        btnNext.setBorder(brdrRaised);

        btnAnswer = new JButton("Answer");
        btnAnswer.setBorder(brdrRaised);
		
		//add the main buttons to the panel
        buttonP.add(btnNext);
        buttonP.add(btnAnswer);

        JPanel bottomP = new JPanel();
        bottomP.setLayout(new GridLayout(2, 2));

        lblCorr = new JLabel("# of Correct Answers: ", SwingConstants.CENTER);
        lblWrng = new JLabel("# of Wrong Answers: ", SwingConstants.CENTER);

        lblRightNum = new JLabel(String.valueOf((int)right), SwingConstants.CENTER);
        lblWrongNum = new JLabel(String.valueOf((int)wrong), SwingConstants.CENTER);
        lblRightNum.setForeground(Color.green);
        lblWrongNum.setForeground(Color.red);
		
		//add remaining elements to the panel
        bottomP.add(lblCorr);
        bottomP.add(lblWrng);
        bottomP.add(lblRightNum);
        bottomP.add(lblWrongNum);

        northP.add(topP);
        northP.add(quesP);
        northP.add(commentP);
        northP.add(buttonP);
        northP.add(bottomP);
        c.add(northP, BorderLayout.NORTH);

        btnNext.addActionListener(this);
        btnAnswer.addActionListener(this);
    }
	

	//action listener method to handle all user interactions
    public void actionPerformed(ActionEvent e)
    {
		//generate next question when next button is clicked
        if (e.getSource() == btnNext)
        {
            num1 = (int)(Math.random() * 11);
            lblNum1.setText(String.valueOf(num1));

            num2 = (int)(Math.random() * 11);
            lblNum2.setText(String.valueOf(num2));

            nextButtonOn = false;
            btnNext.setEnabled(false);
        }
		
		//handling user inputs
        else if(e.getSource() == btnAnswer && nextButtonOn == false)
        {
			//basic error checking of incorrect inputs
            boolean error;
            try
            {
                ans = Integer.parseInt(txtAnswer.getText());
                error = false;
            }
            catch(Exception a)
            {
                lblComment.setText("Please enter a whole number for your answer!");
                error = true;
            }
			
			//handling a correct answer (increase correct count, update label)
            if (ans == num1 + num2)
            {
                right++;
                lblRightNum.setText(String.valueOf((int)right));

                lblComment.setText("Correct!     " + num1 + " + " + num2 + " equals " + (num1 + num2) + ".");

                nextButtonOn = true;
                btnNext.setEnabled(true);
				txtAnswer.setText("");
	            quesCount++;
            }

			//handling an incorrect answer (increase incorrect count, update label)
            else if (ans != num1 + num2 && error == false)
            {
                wrong++;
                lblWrongNum.setText(String.valueOf((int)wrong));

                lblComment.setText("Incorrect!     " + num1 + " + " + num2 + " equals " + (num1 + num2) + ".");

                nextButtonOn = true;
                btnNext.setEnabled(true);
				txtAnswer.setText("");
	            quesCount++;
            }
        }
		
		//display results after 10 questions
        if(quesCount >= 10)
        {
            btnAnswer.setEnabled(false);
            txtAnswer.setEnabled(false);
            btnNext.setEnabled(false);

            float fltRatio = (right / quesCount) * 100;
            int ratio = (int)fltRatio;
			
			//different responses if majority of answers are correct
            if(ratio >= 70)
            {
                lblComment.setText("Good Job! You got " + ratio + "% of the questions right.");
            }
            else
                lblComment.setText("Better Luck Next Time! You got " + ratio + "% of the questions right.");
        }
    }
	
	//general settings for the GUI window
    public static void main(String[] args)
    {
        MathTest app = new MathTest();
        app.setSize(400, 200);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}