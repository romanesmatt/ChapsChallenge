package Maze;

public class ExitLock extends Wall {

	/**
	 * Class representing an exit lock.
	 * Extends wall on account of the overlapping functionality
	 *
	 * @author Scott Jacobs
	 */

	// Fields
	private Maze maze;

	/**
	 * Constructor for an exit lock tile.
	 *
	 * @param m The Maze this tile is a part of
	 * @param l This tile's location in the maze
	 */

	public ExitLock(Location l) {
		super(l);
	}

	/**
	 * Checks if Chip can move through the tile.
	 *
	 * @param The entity trying to enter the tile
	 * @return True if chip can walk on the tile
	 * */
	@Override
	public boolean isPassable(Entity e) {
		if (maze.getTotalTreasure() == e.getTreasure()) {
			return true;
		}
		return false;
	}

}
