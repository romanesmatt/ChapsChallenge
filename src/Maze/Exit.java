package Maze;

public class Exit implements Tile {

	/**
	 * Class representing the exit from the maze.
	 *
	 * @author Scott Jacobs
	 */

	// Fields

	Maze maze;
	Location location;

	/**
	 * Constructor for the exit tile.
	 *
	 * @param m The maze this tile is a part of
	 * @param l This tile's location in the maze
	 */
	public Exit(Location l) {
		this.location = l;
	}

	/**
	 * Checks if Chip can move through the tile.
	 *
	 * @param The entity trying to enter the tile
	 * @return True if chip can walk on the tile
	 * */
	@Override
	public boolean isPassable(Entity e) {
		return true;
	}

	/**
	 * Triggers any events that occur when chip steps into the tile.
	 * Assumes that isPassable has been checked.
	 *
	 * @param e The entity that entered the tile.
	 * */
	@Override
	public void onEntry(Entity e) {
		maze.finish();

	}

	@Override
	public void setMaze(Maze maze) {
		this.maze = maze;
	}

}
