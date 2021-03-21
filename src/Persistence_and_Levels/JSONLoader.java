package Persistence_and_Levels;

import Maze.*;

import java.io.*;
import java.lang.*;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;


/**
 * This class loads information from the given JSON file and sets up the game accordingly.
 * It does this by converting JSON strings into Java objects.
 * This class utilizes the Jackson JSON library.
 *
 * @author Matt Romanes
 */
public class JSONLoader {
    /* Fields */
    private ObjectMapper mapper;
    private boolean isReadyToGo = false;


    /**
     * Loads the defined level based on data from the given file.
     * @param path - directory of given file
     * @param maze -
     * @param level - level number
     * @return new Maze
     */
    public Maze loadGame(String path, Maze maze, int level){

        //Setting up fundamental parts of the game before loading the file
        Tile[][] levelArray = new Tile[32][32];
        Location location = null;

        //Initialise array with empty tiles
        for (int i = 0; i < levelArray.length; i++) {
            Arrays.fill(levelArray[i], null);
        }


        try {
            mapper = new ObjectMapper();
            BufferedReader fileReader = new BufferedReader(new FileReader(path));
            Maze maze1 = mapper.readValue(fileReader, Maze.class); //this is the new maze that will be set up from the data given by the file

            System.out.println("Reading of level - " + level + ".json was successful.");

            setIsReadyToGo(true);


        } catch (JsonMappingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }catch (Throwable t){
            t.printStackTrace();
        }

        return new Maze(levelArray, location);

    }



    /* Helper methods */

    public boolean isReadyToGo() {
        return this.isReadyToGo;
    }

    public void setIsReadyToGo(boolean isReadyToGo) {
        this.isReadyToGo = isReadyToGo;
    }

}
