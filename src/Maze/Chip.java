package Maze;

import java.util.ArrayList;

public class Chip implements Entity {

	/**
	 * Class representing the player character, Chip.
	 * Used for storing information such as location, treasure, and keys.
	 *
	 * @author Scott Jacobs
	 * */

	// Fields

	private ArrayList<Key> keys;
	private int treasure;
	private Maze maze;
	private Location location;

	/**
	 * Constructor for Chip.
	 *
	 * @param m The maze Chip is in
	 * @param l Chip's starting location
	 */
	public Chip(Maze m, Location l) {
		keys = new ArrayList<Key>();
		treasure = 0;
		maze = m;
		location = l;
	}

	/**
	 * Chip attempts to pick up a key.
	 *
	 * @args key The key to be picked up.
	 * */
	@Override
	public void pickUp(Key key) {
		if (!keys.contains(key)) {
			keys.add(key);
		}
	}

	/**
	 * Returns true if the entity has the specified key.
	 *
	 * @param key The key to check for.
	 * @return True if the entity has the right key.
	 */
	@Override
	public boolean hasKey(Key key) {
		if (keys.contains(key)) {
			return true;
		}
		return false;
	}

	/**
	 * The entity picks up a piece of treasure.
	 */
	public void addTreasure() {
		treasure ++;
	}

	/**
	 * Getter for this entity's picked up treasure
	 *
	 * @return The amount of treasure that this entity has picked up
	 */
	public int getTreasure() {
		return treasure;
	}

	/**
	 * Checks if the entity can move in a given direction.
	 *
	 * @param d The direction to check
	 * @return True if the move is valid
	 */
	public boolean canMove(Direction d) {
		switch (d) {
			case EAST:
				if (location.getX() < maze.getMaxX()) {
					Location l = new Location(location.getX() + 1, location.getY());
					if (maze.getTile(l).isPassable(this)) {
						return true;
					}
				}
				return false;
			case NORTH:
				if (location.getY() > 0) {
					Location l = new Location(location.getX(), location.getY() - 1);
					if (maze.getTile(l).isPassable(this)) {
						return true;
					}
				}
				return false;
			case SOUTH:
				if (location.getY() < maze.getMaxY()) {
					Location l = new Location(location.getX(), location.getY() + 1);
					if (maze.getTile(l).isPassable(this)) {
						return true;
					}
				}
				return false;
			case WEST:
				if (location.getX() > 0) {
					Location l = new Location(location.getX() - 1, location.getY());
					if (maze.getTile(l).isPassable(this)) {
						return true;
					}
				}
				return false;
			default:
				// Doesn't move if uncertain
				return false;

		}
	}

	/**
	 * Moves the entity in a given direction.
	 * Assumes canMove has already been checked.
	 *
	 * @param d The direction to move in
	 */
	public void move(Direction d) {
		switch (d) {
			case EAST:
				location = new Location(location.getX() + 1, location.getY());
				break;
			case NORTH:
				location = new Location(location.getX(), location.getY() - 1);
				break;
			case SOUTH:
				location = new Location(location.getX(), location.getY() + 1);
				break;
			case WEST:
				location = new Location(location.getX() - 1, location.getY());
				break;
			default:
				break;

		}
	}

	/**
	 * Getter for the entity's location.
	 *
	 * @return The entity's location in the maze
	 */
	public Location getLocation() {
		return location;
	}

}
