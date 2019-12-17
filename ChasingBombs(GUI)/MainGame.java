import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class MainGame here.
 *
 * @author George Daskalakis
 * @version 10/3/19
 */
public class MainGame extends JFrame implements ActionListener
{
    private JPanel panel2 = new JPanel();    
    private JPanel panel3 = new JPanel();
    
    private final int ROWS = 2;
    private final int COLS = 5;
    private final int GAP = 1;
    private final int NUM = ROWS * COLS;
    
    private int points = 0;
    private int try1 = 5;
    
    private boolean finished = false;
    
    private JPanel panel1 = new JPanel(new GridLayout(ROWS,COLS, GAP,GAP));
    private JPanel [] panel = new JPanel[NUM];

    private JLabel scoreLabel;
    private JButton button1, button2, button3, buttonA, buttonB;
    private Container contentPane = getContentPane();
    /**
     * Constructor for objects of class MainGame
     */
    public MainGame()
    {
        super("Evade The Bomb");
        setSize(550, 300);
        makeFrame();
        setVisible(true);
    }
    
    
    /**
     * Makes the frame
     */
    public void makeFrame()
    {  
        contentPane.setLayout(new GridLayout());
        
        //Sets the layout of the panel 2 and 3 to flow
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());
        
        //adds the panels to the frame
        add(panel1);
        add(panel2);
        add(panel3);
        
        //the buttons that are in the 2nd panel
        buttonA = new JButton("Play A Game");
        buttonB = new JButton("Exit");
        
        //the buttons that are in the 3rd panel
        button1 = new JButton("Easy");
        button2 = new JButton("Intermidiate");
        button3 = new JButton("Difficult");
        
        //this for loop creates thes panels in panel1
        for(int pan = 0; pan < NUM; pan++) {
            final int paneIndex = pan;
            panel[pan] = new JPanel();
            //sets the background of the panels to red
            panel[pan].setBackground(Color.RED);
            //adds each panel created to panel1
            panel1.add(panel[pan]);
             
            //adds a mouse listener to each panel created
            panel[pan].addMouseListener(new MouseAdapter() {
                JPanel bomb = panel[randomBomb()];
                @Override
                public void mouseClicked(MouseEvent m)
                {
                    //when clicking on a panel it checks if the panel is already selected and if the game hasnt finished 
                    //then it increments the points and sets the background to yellow
                    //once one panel is clicked the buttons for the difficulty are disabled 
                    //then it checks if the player has won according to the difficulty set
                    //last it checks if the player has selected the panel with the bomb.
                    //if the panel with the bomb is pressed then it chagnges color to black and the game finishes
                    if(m.getSource() == panel[paneIndex] && panel[paneIndex].getBackground() != Color.YELLOW && finished != true) {
                        points++;
                        panel[paneIndex].setBackground(Color.YELLOW);
                        scoreLabel.setText("Points: " +points);
                        button1.setEnabled(false);
                        button2.setEnabled(false);
                        button3.setEnabled(false);
                        if(points == try1 && try1 != 0) {
                            scoreLabel.setText("You have won! Score: " + points);
                            finished = true;
                        }
                        if(try1 == 0 && points == 9) {
                            scoreLabel.setText("You have won! Score: " + points);
                            finished = true;
                        }
                        if(m.getSource() == bomb) {
                            bomb.setBackground(Color.BLACK);
                            points--;
                            scoreLabel.setText("You have lost! Score: " + points);
                            finished = true;
                        }
                    }
                }
              });
        }
        
        //the label that portrays the points
        scoreLabel = new JLabel("points: " + points);
        scoreLabel.setForeground(Color.WHITE);
        
        //adds the buttons to the panel
        ((FlowLayout)panel2.getLayout()).setHgap(550);
        panel2.add(buttonA);
        panel2.add(buttonB);
        panel2.add(scoreLabel);        
        ((FlowLayout)panel3.getLayout()).setHgap(550);
        panel3.add(button1);
        panel3.add(button2);
        panel3.add(button3);
        
        //sets the background of the panels
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.BLUE);
        panel3.setBackground(Color.GREEN);
        
        //adds the buttons to the action listener
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        
        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
    }
    
    
    /**
     * Returns a random number between 1 and 9
     * @return the random number
     */
    public int randomBomb() {
        int randomloc = (int) Math.floor(Math.random() * 9);
        randomloc = Math.round(randomloc);
        //provides a random number between 1 and 9 and this is used to put the bomb in a random panel
        return randomloc;
    }
    
    
    
    /**
     * The ActionEvent of the buttons
     */
    public void actionPerformed (ActionEvent a)   
    {
        //sets the tries that a person has according to the difficulty level
        //for Button A it creates a new game and for Button B it exits the program
        Object source = a.getSource();
        
        if (source == button1) {
            try1 = 5;
        }
        else if (source == button2) {
            try1 = 7;
        }
        else if (source == button3) {
            try1 = 0;
        }
        else if (source == buttonA) {
            setVisible(false);
            new MainGame();
        }
        else if (source == buttonB) {
            dispose();
        }
    }
}
