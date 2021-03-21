package Maze;

public class TreasureTile implements Tile {

	/**
	 * Class representing a tile where treasure spawns.
	 * Has unwieldy name to avoid conflicting with the potential existance of treasure object - if they get added in the future
	 *
	 * @author Scott Jacobs
	 */

	// Fields
	private Maze maze;
	private Location location;

	/**
	 * Constructor for treasure tiles.
	 *
	 * @param m The maze this tile is a part of
	 * @param l This tile's location in the maze
	 */

	public TreasureTile(Location l) {
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
		if (e.getClass() == Chip.class) {
			e.addTreasure();
			maze.setFree(location);
		}

	}

	@Override
	public void setMaze(Maze maze) {
		this.maze = maze;
	}

}
