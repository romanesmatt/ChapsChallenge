package Maze;

public class Wall implements Tile {

	/**
	 * Class representing an impassable wall tile.
	 *
	 * @author Scott Jacobs
	 * */

	// Fields
	private Maze maze;
	private Location location;

	/**
	 * Constructor for a wall tile.
	 *
	 * @param m The maze this tile is a part of
	 * @param l The tile's location in hte maze
	 * */
	public Wall(Location l) {
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
		return false;
	}

	/**
	 * Triggers any events that occur when chip steps into the tile.
	 * Assumes that isPassable has been checked.
	 *
	 * @param e The entity that entered the tile.
	 * */
	@Override
	public void onEntry(Entity e) {
		// Nothing can enter a wall tile, so nothing will ever trigger off that occuring
		return;
	}

	@Override
	public void setMaze(Maze maze) {
		this.maze = maze;
	}

}
