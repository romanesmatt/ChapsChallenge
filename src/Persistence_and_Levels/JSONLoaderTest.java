package Persistence_and_Levels;

import Maze.*;
import Persistence_and_Levels.JSONLoader;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.MapperFeature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class will handle the unit testing for the JSONLoader class.
 *
 * @author Matt Romanes
 */
class JSONLoaderTest {

    /* Testing the loading of the files. */

    @Test
    public void LoadJSONFileTest_01() throws JsonMappingException {
        ObjectMapper objectMapper = new ObjectMapper();
        assertTrue(objectMapper.getDeserializationConfig().isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
    }

    @Test
    public void LoadJSONFileTest_02() throws JsonMappingException {
        ObjectMapper objectMapper = new ObjectMapper();
        assertTrue(objectMapper.getDeserializationConfig().isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
    }

    @Test
    public void LoadJSONFileTest_03() throws JsonMappingException {
        ObjectMapper objectMapper = new ObjectMapper();
        assertTrue(objectMapper.getDeserializationConfig().isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
    }

    /* Testing the performance of loading the files. */

    @Test
    public void performanceTest_01() {
        //should be timing the performance of the method at this point.
    }

    @Test
    public void performanceTest_02() {
        //should be timing the performance of the method at this point.
    }

    @Test
    public void performanceTest_03() {
        //should be timing the performance of the method at this point.
    }


}