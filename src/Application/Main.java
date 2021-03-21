package Application;

import Maze.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.HashSet;

/**
 * Main class for Chap's Challenge and all the application functions
 * in the game
 * @author francesjulaton
 * */

public class Main extends JFrame implements KeyListener{

    GameTimer gameTimer;
    SideBar sideBar;

    private int levelNumber;

    private File loadFile;
    private File saveFile;

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    public Direction direction;
    private HashSet<Integer> activeKeys;
    public boolean isGamePaused;
    public boolean isTimesUp;

    private DisplayMode displayMode;


    /**
     * Main class constructor for Chap's challenge
     * Initialises Key listener and Initiate side menu bar for game
     * */
    public Main(){

//        GraphicsEnvironment graphicsEnvironment= GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
//        displayMode = graphicsDevices[0].getDisplayMode();

        //executeOpening();

        //new active key sets for each new game started
        activeKeys = new HashSet<>();

        sideBar = new SideBar();

        this.setFocusable(true);
        this.requestFocus();

        executeGame();
    }


    //---------------------------------------------------------------------------------
    //Executing components
    //---------------------------------------------------------------------------------


    /**
     * Runs the game section when displayGame = true
     *
     * @author francesjulaton
     * */
    public void executeGame(){
        //isGameDisplayed = true;
        //isGamePaused = false;
        displayGame();
    }



    //---------------------------------------------------------------------------------
    //Opening Frame display components
    //---------------------------------------------------------------------------------

    /**
     * dispGame handles the display of the Game panel when displayGame = true
     * Also displays upper JMenu bar when game window is up
     * @author francesjulaton
     * */
    public void displayGame(){

//            //add key listener
//            addKeyListener(this);

        //-------------------------
        //Game + Options Menu
        //-------------------------

        //Add Menu bar at top
        JMenuBar menu = new JMenuBar();

        //JMenu game option
        JMenu game = new JMenu("Game");
        JMenuItem newGame = new JMenuItem("New Game");
        JMenuItem exitGame = new JMenuItem("Exit Game");
        JMenuItem pause = new JMenuItem("Pause Game");
        JMenuItem resume = new JMenuItem("Resume Saved Game");


        //game+options menu
        game.add(newGame);
        game.add(exitGame);
        game.add(pause);
        game.add(resume);


        //JMenu option
        JMenu option = new JMenu("Options");
        JMenuItem resetLevel = new JMenuItem("Reset Game");
        JMenuItem saveLevel = new JMenuItem("Save Game");
        JMenuItem howToPlay = new JMenuItem("How To Play");

        option.add(resetLevel);
        option.add(saveLevel);
        option.add(howToPlay);

        //add action listener when buttons are pressed
        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new game
                if (e.getSource() == newGame) {
                    int temp = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to start new game?",
                            "Start new game?", JOptionPane.YES_NO_OPTION);
                    if (temp == JOptionPane.YES_OPTION) {
                        executeGame();
                    }
                }
                //exit game
                if (e.getSource() == exitGame) {
                    int temp = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to exit game? ",
                            "Exit current game:", JOptionPane.YES_NO_OPTION);
                    if (temp == JOptionPane.YES_OPTION) {
                        isTimesUp = true;
                    }

                }
            }
        };

        newGame.addActionListener(a);
        exitGame.addActionListener(a);
        pause.addActionListener(a);


        menu.add(game);
        menu.add(option);
        setJMenuBar(menu);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome to Chap's Challenge!");
        setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        setResizable(false);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation((this.getWidth()/2) - (getSize().width/2),(this.getHeight()/2) - (getSize().height/2));
        setVisible(true);

    }



    /**
     * How to play content shows the instructions for how to play
     * Chap's challenge
     *
     * @author francesjulaton
     * */
    public void displayHowToPlay(){
        //put text on how to play the game
    }


    //---------------------------------------------------------------------------------
    //Key Event components
    //---------------------------------------------------------------------------------


    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Contains key press events for when game starts
     *
     * @param e key event
     * */
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            //ctrl-x. Exit no save
            case KeyEvent.VK_X:
                //ctrl-s
            case KeyEvent.VK_S:
                if (e.isControlDown()) {
                    exitGameS(true);
                }
                //ctrl-r
            case KeyEvent.VK_R:
                //ctrl-p
            case KeyEvent.VK_P:
                //ctrl-1
            case KeyEvent.VK_1:
                //space
            case KeyEvent.VK_SPACE:
                pause();
                break;
            //esc
            case KeyEvent.VK_ESCAPE:
                resume();
                break;
            //up
            case KeyEvent.VK_UP:
                //Direction.NORTH;
                //down
            case KeyEvent.VK_DOWN:
                //left
            case KeyEvent.VK_LEFT:
                //right
            case KeyEvent.VK_RIGHT:
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {
        activeKeys.clear();
    }


    /**
     * Records current direction of player
     * */
    public Direction direction (Enum dir){
        return (Direction) dir;
    }

    /**
     * Pause Chap's Challenge game
     * */
    public void pause(){
        isGamePaused = true;
        gameTimer.pause();
    }

    /**
     * Resume Chap's Challenge game
     * */
    public void resume(){
        isGamePaused = false;
    }

    /**
     * Exits Chap's Challenge game, the current state will be lost, the next time the
     * game is started, it will resume from the last unfinished level
     * */
    public void exitGameX(){
        int reply = JOptionPane.showConfirmDialog(null,"Would you like to quit?",
                "Quit Game", JOptionPane.YES_NO_OPTION);
        if(reply == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        else{
            getRootPane().requestFocus();
        }
    }


    /**
     * Exits the gmae with saving the game state, game will resume next time the application will be started
     * */
    public void exitGameS(boolean saveGame){
        if(saveGame){

        }
    }

    /**
     * Loads Chap's Challenge game
     * */
    public void load(){
        isGamePaused = true;
    }

    /**
     * Save the current Chap's Challenge game.
     * */
    public void save(){
    }


    /**
     * Gets the Chip's current direction based in the keyPressed
     * input.
     *
     * @author francesjulaton
     * */
    public void playerDirection(Direction d){
        direction = d;
        //update for render people when moving the chip
    }

    /**
     * Gets time remaining in the timer
     *
     * @return String of time remaining.
     */
    public String getTimeLeft() {
        if(this.gameTimer.getSeconds() < 10) {
            return ("0" + this.gameTimer.getMinutes() + ":0" + this.gameTimer.getSeconds());
        }
        return ( "0" + this.gameTimer.getMinutes() + ":" + this.gameTimer.getSeconds());
    }





    public static void main(String[] args){new Main();}
}
