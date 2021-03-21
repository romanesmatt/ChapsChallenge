package Maze;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Color;

import org.junit.Test;

public class Tests {

    // Keys
    Key keyOne = new Key(Color.RED);

    // Boards
    // 2x2 free tiles
    Tile tinyBoard[][] = {{new Free(new Location(0, 0)), new Free(new Location(0, 1))}, {new Free(new Location(1, 0)), new Free(new Location(1, 1))}};
    // 3x3 free tiles
    Tile smallBoard[][] = {{new Free(new Location(0, 0)), new Free(new Location(0, 1)), new Free(new Location(0, 2))}, {new Free(new Location(1, 0)), new Free(new Location(1, 1)), new Free(new Location(1, 2))}, {new Free(new Location(2, 0)), new Free(new Location(2, 1)), new Free(new Location(2, 2))}};
    // 3x3 free tile surrounded by walls
    Tile smallWalled[][] = {{new Wall(new Location(0, 0)), new Wall(new Location(0, 1)), new Wall(new Location(0, 2))}, {new Wall(new Location(1, 0)), new Free(new Location(1, 1)), new Wall(new Location(1, 2))}, {new Wall(new Location(2, 0)), new Wall(new Location(2, 1)), new Wall(new Location(2, 2))}};
    // 3x3 key tile surrounded by free tiles
    Tile smallKey[][] = {{new Free(new Location(0, 0)), new Free(new Location(0, 1)), new Free(new Location(0, 2))}, {new Free(new Location(1, 0)), new KeyTile(new Location(1, 1), keyOne), new Free(new Location(1, 2))}, {new Free(new Location(2, 0)), new Free(new Location(2, 1)), new Free(new Location(2, 2))}};
    // 3x3 locked door, surrounded by free tiles
    Tile smallDoor[][] = {{new Free(new Location(0, 0)), new Free(new Location(0, 1)), new Free(new Location(0, 2))}, {new Free(new Location(1, 0)), new Door(new Location(1, 1), keyOne), new Free(new Location(1, 2))}, {new Free(new Location(2, 0)), new Free(new Location(2, 1)), new Free(new Location(2, 2))}};

    /**
     * Tests 01 - 04
     *
     * Tests moving between free tiles
     */

    // Valid move east
    @Test
    public void test_01() {
        Maze maze = new Maze(tinyBoard, new Location(0,0));
        maze.moveChip(Direction.EAST);
        assertTrue(maze.getChipLocation().equals(new Location(1, 0)));
    }

    // Valid move south
    @Test
    public void test_02() {
        Maze maze = new Maze(tinyBoard, new Location(0,0));
        maze.moveChip(Direction.SOUTH);
        assertTrue(maze.getChipLocation().equals(new Location(0, 1)));
    }

    // Valid move west
    @Test
    public void test_03() {
        Maze maze = new Maze(tinyBoard, new Location(1,1));
        maze.moveChip(Direction.WEST);
        assertTrue(maze.getChipLocation().equals(new Location(0, 1)));
    }

    // Valid move north
    @Test
    public void test_04() {
        Maze maze = new Maze(tinyBoard, new Location(1,1));
        maze.moveChip(Direction.NORTH);
        assertTrue(maze.getChipLocation().equals(new Location(1, 0)));
    }

    /**
     * Tests 05 - 08
     *
     * Tests invalid moving off the board
     */

    // Invalid move north
    @Test
    public void test_05() {
        Maze maze = new Maze(tinyBoard, new Location(0, 0));
        maze.moveChip(Direction.NORTH);
        assertTrue(maze.getChipLocation().equals(new Location(0, 0)));
    }

    // Invalid move west
    @Test
    public void test_06() {
        Maze maze = new Maze(tinyBoard, new Location(0, 0));
        maze.moveChip(Direction.WEST);
        assertTrue(maze.getChipLocation().equals(new Location(0, 0)));
    }

    // Invalid move south
    @Test
    public void test_07() {
        Maze maze = new Maze(tinyBoard, new Location(1, 1));
        maze.moveChip(Direction.SOUTH);
        assertTrue(maze.getChipLocation().equals(new Location(1, 1)));
    }

    // Invalid move east
    @Test
    public void test_08() {
        Maze maze = new Maze(tinyBoard, new Location(1, 1));
        maze.moveChip(Direction.EAST);
        assertTrue(maze.getChipLocation().equals(new Location(1, 1)));
    }

    /**
     * Tests 09 - 12
     *
     * Tests moving more than once
     */

    // Valid moves east
    @Test
    public void test_09() {
        Maze maze = new Maze(smallBoard, new Location(0, 0));
        maze.moveChip(Direction.EAST);
        maze.moveChip(Direction.EAST);
        assertTrue(maze.getChipLocation().equals(new Location(2, 0)));
    }

    // Valid moves south
    @Test
    public void test_10() {
        Maze maze = new Maze(smallBoard, new Location(0, 0));
        maze.moveChip(Direction.SOUTH);
        maze.moveChip(Direction.SOUTH);
        assertTrue(maze.getChipLocation().equals(new Location(0, 2)));
    }

    // Valid move west
    @Test
    public void test_11() {
        Maze maze = new Maze(smallBoard, new Location(2, 2));
        maze.moveChip(Direction.WEST);
        maze.moveChip(Direction.WEST);
        assertTrue(maze.getChipLocation().equals(new Location(0, 2)));
    }

    // Valid move north
    @Test
    public void test_12() {
        Maze maze = new Maze(smallBoard, new Location(2, 2));
        maze.moveChip(Direction.NORTH);
        maze.moveChip(Direction.NORTH);
        assertTrue(maze.getChipLocation().equals(new Location(2, 0)));
    }

    /**
     * Tests 13 - 16
     *
     * Tests moving into walls
     */

    // Move into wall north
    @Test
    public void test_13() {
        Maze maze = new Maze(smallWalled, new Location(1, 1));
        maze.moveChip(Direction.NORTH);
        assertTrue(maze.getChipLocation().equals(new Location(1, 1)));
    }

    // Move into wall east
    @Test
    public void test_14() {
        Maze maze = new Maze(smallWalled, new Location(1, 1));
        maze.moveChip(Direction.EAST);
        assertTrue(maze.getChipLocation().equals(new Location(1, 1)));
    }

    // Move into wall south
    @Test
    public void test_15() {
        Maze maze = new Maze(smallWalled, new Location(1, 1));
        maze.moveChip(Direction.SOUTH);
        assertTrue(maze.getChipLocation().equals(new Location(1, 1)));
    }

    // Move into wall west
    @Test
    public void test_16() {
        Maze maze = new Maze(smallWalled, new Location(1, 1));
        maze.moveChip(Direction.WEST);
        assertTrue(maze.getChipLocation().equals(new Location(1, 1)));
    }

    /**
     * Tests 17 - 20
     *
     * Moving into key tiles.
     *
     * Chip should move into the tile, pick up the key, and the tile should change to Free
     */

    // North to key
    @Test
    public void test_17() {
        Maze maze = new Maze(smallKey, new Location(1, 2));
        maze.moveChip(Direction.NORTH);
        assertTrue(maze.getChipLocation().equals(new Location(1, 1)));
        assertTrue(maze.getChip().hasKey(keyOne));
        assertTrue(maze.getTile(new Location(1, 1)).getClass() == Free.class);
    }

    // East to key
    @Test
    public void test_18() {
        Maze maze = new Maze(smallKey, new Location(0, 1));
        maze.moveChip(Direction.EAST);
        assertTrue(maze.getChipLocation().equals(new Location(1, 1)));
        assertTrue(maze.getChip().hasKey(keyOne));
        assertTrue(maze.getTile(new Location(1, 1)).getClass() == Free.class);
    }

    // South to key
    @Test
    public void test_19() {
        Maze maze = new Maze(smallKey, new Location(1, 0));
        maze.moveChip(Direction.SOUTH);
        assertTrue(maze.getChipLocation().equals(new Location(1, 1)));
        assertTrue(maze.getChip().hasKey(keyOne));
        assertTrue(maze.getTile(new Location(1, 1)).getClass() == Free.class);
    }

    // West to key
    @Test
    public void test_20() {
        Maze maze = new Maze(smallKey, new Location(2, 1));
        maze.moveChip(Direction.WEST);
        assertTrue(maze.getChipLocation().equals(new Location(1, 1)));
        assertTrue(maze.getChip().hasKey(keyOne));
        assertTrue(maze.getTile(new Location(1, 1)).getClass() == Free.class);
    }

    /**
     * Tests 21 - 24
     *
     * Attempting to move into a locked door (Without a key)
     */

    // North to door
    @Test
    public void test_21() {
        Maze maze = new Maze(smallDoor, new Location(1, 2));
        maze.moveChip(Direction.NORTH);
        assertTrue(maze.getChipLocation().equals(new Location(1, 2)));
        assertTrue(maze.getTile(new Location(1, 1)).getClass() == Door.class);
    }

    // East to door
    @Test
    public void test_22() {
        Maze maze = new Maze(smallDoor, new Location(0, 1));
        maze.moveChip(Direction.EAST);
        assertTrue(maze.getChipLocation().equals(new Location(0, 1)));
        assertTrue(maze.getTile(new Location(1, 1)).getClass() == Door.class);
    }

    // South to door
    @Test
    public void test_23() {
        Maze maze = new Maze(smallDoor, new Location(1, 0));
        maze.moveChip(Direction.SOUTH);
        assertTrue(maze.getChipLocation().equals(new Location(1, 0)));
        assertTrue(maze.getTile(new Location(1, 1)).getClass() == Door.class);
    }

    // West to door
    @Test
    public void test_24() {
        Maze maze = new Maze(smallDoor, new Location(2, 1));
        maze.moveChip(Direction.WEST);
        assertTrue(maze.getChipLocation().equals(new Location(2, 1)));
        assertTrue(maze.getTile(new Location(1, 1)).getClass() == Door.class);
    }

    /**
     * Tests 25 - 28
     *
     * Unlocking a door (Moving into it with the correct key)
     */

}
