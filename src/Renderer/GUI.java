package Renderer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

/**
 * Overall GUI Class
 * @author River Rivera 300443477
 */

public abstract class GUI {

    protected JFrame frame;
    private JPanel buttons;
    private MazeCanvas mazeCanvas;
    private StatsCanvas statsCanvas;

    //constructor
    public GUI() {
        initialise();
    }

    /*
     * Initialises GUI
     * Sets up buttons and display area
     * Called on class creation
     */
    private void initialise(){

        //=================================================================================
        //BUTTON METHODS
        //=================================================================================

        //---------------------------------------------------------------------------------
        //Start Game Button
        //---------------------------------------------------------------------------------
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        //---------------------------------------------------------------------------------
        //Quit Button
        //---------------------------------------------------------------------------------
        JButton quit = new JButton("Quit");
        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                quit();
            }
        });
        //---------------------------------------------------------------------------------
        //Pause Button
        //---------------------------------------------------------------------------------
        JButton pause = new JButton("Pause");
        pause.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        //---------------------------------------------------------------------------------
        //Resume Button
        //---------------------------------------------------------------------------------
        JButton resume = new JButton("Resume");
        resume.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        //---------------------------------------------------------------------------------
        //Save Button
        //---------------------------------------------------------------------------------
        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        //---------------------------------------------------------------------------------
        //Save Button
        //---------------------------------------------------------------------------------
        JButton load = new JButton("Load");
        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        //---------------------------------------------------------------------------------
        //Step Replay Button
        //---------------------------------------------------------------------------------
        JButton stepReplay = new JButton("Step Replay");
        stepReplay.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });

        //---------------------------------------------------------------------------------
        //Automatic Replay Button
        //---------------------------------------------------------------------------------
        JButton autoReplay = new JButton("Auto Replay");
        autoReplay.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });


        //=================================================================================
        //WINDOW LAYOUT
        //=================================================================================
        //Create grid layout
        buttons = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Set border
        Border border = BorderFactory.createEmptyBorder(5,5,5,5);
        buttons.setBorder(border);

        //---------------------------------------------------------------------------------
        //BUTTONS
        //---------------------------------------------------------------------------------


        buttons.add(start,constraints);
        buttons.add(quit,constraints);
        buttons.add(pause,constraints);
        buttons.add(resume,constraints);
        buttons.add(save,constraints);
        buttons.add(load,constraints);
        buttons.add(stepReplay,constraints);
        buttons.add(autoReplay,constraints);

        //Replay speed slider
        int sliderMin=1, sliderMax=3, sliderInitial = 2;
        JSlider replaySpeedSlider = new JSlider(JSlider.HORIZONTAL, sliderMin, sliderMax, sliderInitial);
        replaySpeedSlider.setPaintTicks(true); //show axis ticks
        replaySpeedSlider.setPaintTrack(true); //show axis line
        replaySpeedSlider.setPaintLabels(true); //show tick labels
        replaySpeedSlider.setSnapToTicks(true); //snap slider to nearest whole value
        replaySpeedSlider.setMajorTickSpacing(1);
        replaySpeedSlider.setMinorTickSpacing(1);

        JLabel sliderLabel = new JLabel();
        replaySpeedSlider.addChangeListener(e -> sliderChanged(replaySpeedSlider.getValue(), sliderLabel) ); //listener for change in slider and calls method
        buttons.add(replaySpeedSlider,constraints);
        //setslider to speed depending on number ie: if =1 display speed = 0.5x

        //---------------------------------------------------------------------------------
        //GRAPHICS AREAS
        //---------------------------------------------------------------------------------

        //Maze
        mazeCanvas = new MazeCanvas(){
            protected void paintComponent(Graphics g) {
                redraw(g);
            }
        };
        mazeCanvas.setPreferredSize(new Dimension(500,500)); //each tile is 50x50px 9x9 grid
        mazeCanvas.setVisible(true);

        //Stats
        statsCanvas = new StatsCanvas(){
            protected void paintComponent(Graphics g) {
                redraw(g);
            }
        };
        statsCanvas.setPreferredSize(new Dimension(100,200)); //each stat is 50px tall and 100px wide
        statsCanvas.setVisible(true);

        //---------------------------------------------------------------------------------
        //FRAME
        //---------------------------------------------------------------------------------

        //create frame
        frame = new JFrame("Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(20, 20); //window creation location

        //create sections and add to frame
        JSplitPane buttonStatsPanes = new JSplitPane(JSplitPane.VERTICAL_SPLIT,buttons, statsCanvas); //Split left pane into buttons and stats display
        JSplitPane mazePane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonStatsPanes, mazeCanvas); //split combined left pane from right maze area
        frame.add(mazePane,BorderLayout.NORTH);

        //display frame
        frame.pack();
        frame.setSize(new Dimension(700,500)); //window size 700x500
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    //=================================================================================
    //OTHER CLASS METHODS
    //=================================================================================

    //---------------------------------------------------------------------------------
    //QUIT METHOD
    //---------------------------------------------------------------------------------
    /**
     * Method called on quit
     * Dialogue box confirmation
     */
    public void quit(){

        String quitBoxText = "Are you sure you want to quit?";
        int quitBoxResponse = JOptionPane.showConfirmDialog(frame,quitBoxText,"Quit Game", JOptionPane.YES_NO_OPTION);

        if(quitBoxResponse == JOptionPane.YES_OPTION){
            System.exit(0); //Quit
        }
        if(quitBoxResponse == JOptionPane.NO_OPTION){
            frame.getRootPane().requestFocus(); //Close dialogue box
        }
    }
    //---------------------------------------------------------------------------------
    //SLIDER CHANGE METHOD
    //---------------------------------------------------------------------------------
    /**
     * Called on replay speed slider change
     * Performs slider action
     * @param sliderValue
     */
    public void sliderChanged(int sliderValue, JLabel sliderLabel) {

        //display replay speed based on slider value
        if(sliderValue==1) {
            sliderLabel.setText("Replay Speed = 0.5x");
        }
        else if(sliderValue==2) {
            sliderLabel.setText("Replay Speed = 1.0x");
        }
        else {
            sliderLabel.setText("Replay Speed = 2.0x");
        }
    }

}
