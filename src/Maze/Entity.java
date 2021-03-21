package Maze;

public interface Entity {

	/**
	 * Interface for moving entities, such as Chip or other actors as introduced in level 2.
	 *
	 * @author Scott Jacobs
	 * */

	/**
	 * The entity attempts to pick up a key.
	 *
	 * @args key The key to be picked up.
	 * */
	void pickUp(Key key);

	/**
	 * Returns true if the entity has the specified key.
	 *
	 * @param key The key to check for.
	 * @return True if the entity has the right key.
	 */
	boolean hasKey(Key key);

	/**
	 * The entity picks up a piece of treasure.
	 */
	void addTreasure();

	/**
	 * Getter for this entity's picked up treasure
	 *
	 * @return The amount of treasure that this entity has picked up
	 */
	int getTreasure();

	/**
	 * Checks if the entity can move in a given direction.
	 *
	 * @param d The direction to check
	 * @return True if the move is valid
	 */
	boolean canMove(Direction d);

	/**
	 * Moves the entity in a given direction.
	 * Assumes canMove has already been checked.
	 *
	 * @param d The direction to move in
	 */
	void move(Direction d);

	/**
	 * Getter for the entity's location.
	 *
	 * @return The entity's location in the maze
	 */
	Location getLocation();
}
