package Maze;

public class Location {

	/**
	 * Represents a tile's location in the maze.
	 *
	 * @author Scott Jacobs
	 */

	// Fields
	private int x;
	private int y;

	/**
	 * Constructor for location.
	 *
	 * @param x X position
	 * @param y Y position
	 */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter for X.
	 *
	 * @return X position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter for Y.
	 *
	 * @return Y postion
	 */
	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if (o.getClass() == Location.class) {
			Location l = (Location) o;
			if (l.x == x && l.y == y) {
				return true;
			}
		}
		return false;
	}
}
