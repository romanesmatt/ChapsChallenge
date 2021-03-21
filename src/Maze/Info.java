package Maze;

public class Info extends Free {

	/**
	 * Class representing an info tile.
	 * Extends Free tile, as it has mostly the same functionality.
	 *
	 * @author Scott Jacobs
	 * */

	// Fields
	String message;

	/**
	 * Constructor for Info tiles.
	 *
	 * @param m The maze this tile is in
	 * @param l This tile's location in the maze
	 * @param message The message that shuold be displayed when this tile is entered
	 */
	public Info(Location l, String message) {
		super(l);
		this.message = message;
	}

	/**
	 * Triggers any events that occur when chip steps into the tile.
	 * Assumes that isPassable has been checked.
	 *
	 * @param e The entity that entered the tile.
	 * */
	@Override
	public void onEntry(Entity e) {
		// TODO: display message.
		return;
	}

}
