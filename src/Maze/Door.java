package Maze;

public class Door implements Tile {

	/**
	 * Class representing a locked door.
	 * An unlocked door is represented by a free tile.
	 *
	 * @author Scott Jacobs
	 * */

	// Fields
	private Maze maze;
	private Key key;
	private Location location;

	/**
	 * Constructor for a Door tile.
	 *
	 * @param m The maze this tile is a part of.
	 * @param l The tile's location in the maze.
	 * @param k The key that unlocks this door.
	 * */
	public Door(Location l, Key k) {
		this.key = k;
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
		if (e.getClass() == Chip.class) {
			if (e.hasKey(key)) {
				return true;
			}
		}
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
		maze.setFree(location);

	}

	@Override
	public void setMaze(Maze maze) {
		this.maze = maze;
	}

}
