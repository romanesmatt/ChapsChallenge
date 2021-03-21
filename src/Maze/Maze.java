package Maze;

public class Maze {
	/**
	 * Class representing a specific maze
	 *
	 * @author Scott Jacobs
	 * */

	// Fields

	private Tile[][] board;
	private int totalTreasure;
	private Chip chip;

	/**
	 * Constructor for the maze, based on a 2D array of tiles.
	 * Presumed to be called by the Persistance and Levels module
	 *
	 * @param tiles The 2D array of tiles that makes up the maze
	 * @param l Chip's starting location in the maze
	 * */
	public Maze(Tile[][] tiles, Location l) {
		board = tiles;
		for (Tile[] a : board) {
			for (Tile t : a) {
				t.setMaze(this);
			}
		}
		totalTreasure = 0;
		chip = new Chip(this, l);
	}
	/**
	 * Sets a location to be a free tile
	 *
	 * @param l The lcoation to be changed.
	 */
	public void setFree(Location l) {
		board[l.getX()][l.getY()] = new Free(l);
		board[l.getX()][l.getY()].setMaze(this);
	}

	/**
	 * Returns the total amount of treasure in this maze
	 *
	 * @return The amount of treasure in the maze
	 */
	public int getTotalTreasure() {
		return totalTreasure;
	}

	/**
	 * Finishes the level because the exit was found
	 */
	public void finish() {
		// TODO probably needs to call something from another package
	}

	/**
	 * Gets the maximum X value of the board.
	 *
	 * @return The max X value of the board.
	 */
	public int getMaxX() {
		return board.length - 1;
	}

	/**
	 * Gets the max Y value of the board.
	 *
	 * @return The max Y value of the board.
	 */
	public int getMaxY() {
		return board[0].length - 1;
	}

	/**
	 * Returns the tile at the given location.
	 *
	 * @param l Location of the tile
	 * @return The tile at the location
	 */
	public Tile getTile(Location l) {
		return board[l.getX()][l.getY()];
	}

	/**
	 * Attempts to move a given entity in a given direction
	 * If successful, also triggers any entry events for the tile
	 *
	 * @param e The entity to be moved
	 * @param d The direction to move in
	 * @return True if the entity moved
	 */
	public boolean move(Entity e, Direction d) {
		if (e.canMove(d)) {
			e.move(d);
			getTile(e.getLocation()).onEntry(e);
			return true;
		}
		return false;
	}

	/**
	 * Calls move(e, d) on chip.
	 * Exists so other modules may move chip without needing the object itself
	 *
	 * @param d The direction to move chip
	 * @return True if chip moved
	 */
	public boolean moveChip(Direction d) {
		return move(chip, d);
	}

	public Location getChipLocation() {
		return chip.getLocation();
	}

	public Chip getChip() {
		return chip;
	}
}
