package SpaceGame;

import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

//GUI for displaying scores from file
public class ShowScores extends JFrame {
	private JButton btn;
    private JTable table;
    private JScrollPane jScrollPane1;
    private JLabel lblGameLogo;
    private JPanel pnlList, pnlBtn;

    public ShowScores() {
        super("Space Game - Top Highscores");
        this.setLocation(500, 200);
        this.setSize(335, 350);
        sortFile(); //when the GUI is called, it will sort the file in descending order
        initComponents();
    }

    private void initComponents() {
        lblGameLogo = new JLabel();

        pnlList = new JPanel();
        pnlList.setLayout(new GridLayout(1, 1, 0, 20));
        pnlList.setBorder(new EmptyBorder(10, 30, 10, 30));

        pnlBtn = new JPanel();
        pnlBtn.setBorder(new EmptyBorder(10, 30, 10, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        
        //logo on top of GUI pane
        lblGameLogo.setIcon(new ImageIcon("\\SpaceGame\\SpaceGameLogo.png"));
        
        //columns to sort by
        String columns[] = {
            "Name",
            "Score"
        };
        
        table = new JTable(); //show scores in a tabulated format
        DefaultTableModel tableModel;

        tableModel = new DefaultTableModel(0, 2); // specify number of columns
        tableModel.setColumnIdentifiers(columns);
        table.setModel(tableModel);
        
        //read the file using ',' delimeter
        String line;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("\\SpaceGame\\Highscores.txt"));
            while ((line = reader.readLine()) != null) {
                tableModel.addRow(line.split(", "));
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }

        jScrollPane1 = new JScrollPane(table);
        btn = new JButton("Return to Main");

        pnlList.add(jScrollPane1);
        pnlBtn.add(btn);

        add(lblGameLogo, BorderLayout.NORTH);
        add(pnlList, BorderLayout.CENTER);
        add(pnlBtn, BorderLayout.SOUTH);

        ActionHandler handler = new ActionHandler();
        btn.addActionListener(handler);
    }

    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == btn) {
                StartScreen SS = new StartScreen();
                SS.setVisible(true); //returning to main screen

                Frame frame = JOptionPane.getFrameForComponent((Component) event.getSource());
                frame.dispose();
            }
        }
    }

    private void sortFile() {
        String line = null;

        TreeMap < Integer, List < String >> highestScores = new TreeMap < Integer, List < String >> ();
        
        BufferedReader reader;
        
        //sort the scores in descending order
        try {
            reader = new BufferedReader(new FileReader(new File("\\SpaceGame\\Highscores.txt")));

            while ((line = reader.readLine()) != null) {
                String[] playerScores = line.split(", ");
                Integer score = Integer.valueOf(playerScores[1]);
                List < String > playerList = null;

                // check if a player with this score already exists
                if ((playerList = highestScores.get(score)) == null) { // if NOT,
                    playerList = new ArrayList < String > (1); // CREATE a new list
                    playerList.add(playerScores[0]);
                    highestScores.put(Integer.valueOf(playerScores[1]), playerList);
                } else // if YES, ADD to the existing list
                    playerList.add(playerScores[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //overwrite the unsorted scores file with the sorted data
        try {
            File file = new File("\\SpaceGame\\Highscores.txt");
            FileWriter fw = new FileWriter(file, false); //boolean value false for overwriting file
            PrintWriter pw = new PrintWriter(fw);

            for (Integer score: highestScores.descendingKeySet()) {
                for (String player: highestScores.get(score)) { // iterate over player list
                    pw.println(player + ", " + score);
                }
            }
            pw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "File Could Not Be Opened");
        }
    }

    public static void main(String args[]) {
        ShowScores screen = new ShowScores();
        screen.setSize(335, 350);
        screen.setVisible(true);
    }
}