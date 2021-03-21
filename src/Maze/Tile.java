package Maze;
/**
 * Interface which all tiles are based on.
 *
 * @author Scott Jacobs
 * */
public interface Tile {

	/**
	 * Checks if Chip can move through the tile.
	 *
	 * @param The entity trying to enter the tile
	 * @return True if chip can walk on the tile
	 * */
	boolean isPassable(Entity e);

	/**
	 * Triggers any events that occur when chip steps into the tile.
	 * Assumes that isPassable has been checked.
	 *
	 * @param e The entity that entered the tile.
	 * */
	void onEntry(Entity e);

	/**
	 * Sets what maze the tile is a part of
	 *
	 * @param maze The maze this tile is a part of
	 */
	void setMaze(Maze maze);


}
