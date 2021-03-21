package Record_and_Play;

import Application.Main;
import Maze.Direction;

import java.util.ArrayList;

public class RecordAndPlay {
    private static String name;	//name of save
    private static ArrayList<Direction> moveList = new ArrayList<>();
    private static boolean record;
    private static String state;
    private static ArrayList<Integer> a = new ArrayList<>();

    private static boolean recording;

    public static void saveGame(Main game, String s) {	//should take state of game and a name for the save
        name = s;
        recording = true;
        moveList.clear();
        //need to get the game state of "game", and store it in "state"


    }

    //FIXME unfinished
    public static void addAction(Direction dir) {
        if (recording) {
            moveList.add(dir);
        }
    }


}
