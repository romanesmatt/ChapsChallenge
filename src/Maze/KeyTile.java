package Maze;

public class KeyTile implements Tile {

	/**
	 * Class representing a tile containing a key.
	 * Has an unwieldy name to avoid conflicts with the key items.
	 *
	 * @author Scott Jacobs
	 * */

	// Fields
	private Key key;
	private Maze maze;
	private Location location;

	/**
	 * Constructor for a tile containing a key.
	 *
	 * @param m The maze this tile is a part of.
	 * @param l The tile's location in the maze.
	 * @param k The key that spawns on this tile.
	 * */
	public KeyTile(Location l, Key k) {
		this.location = l;
		this.key = k;
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
		if (e.getClass() == Chip.class) {
			if (key != null) {
				e.pickUp(key);
			}
			maze.setFree(location);
		}

	}

	@Override
	public void setMaze(Maze maze) {
		this.maze = maze;
	}

}
