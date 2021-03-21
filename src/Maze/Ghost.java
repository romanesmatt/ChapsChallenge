package Maze;

public class Ghost implements Entity {

	// Fields
	
	private Maze maze; // The maze the ghost inhabits
	private Location start; // The start point of the ghosts patrol
	private Location end; // The end point of the ghosts patrol
	private Location location; // The ghosts current location
	private boolean toEnd; // Boolean determining which direction the ghost is travelling on its patrol path
	
	/**
	 * A ghost is an entity that can move through walls and other impassable terrain. If it touches Chip, the level is reset (but not the timer). A ghost moves on its own, patrolling in a straight line between two points.
	 * 
	 * WARNING: THE START AND END POINTS ABSOLUTELY CANNOT BE THE SAME LOCATION
	 * 
	 * @param m The maze the ghost is on
	 * @param start The ghosts spawn point and the start of its patrol. ABSOLUTELY CANNOT BE THE SAME AS END
	 * @param end The end point of the ghosts patrol ABSOLUTELY CANNOT BE THE SAME AS START
	 */
	public Ghost(Maze m, Location start, Location end) {
		this.maze = m;
		this.start = start;
		this.end = end;
		if (start.equals(end)) {
			throw new IllegalArgumentException();
		}
		this.location = start;
		this.toEnd = true;
	}
	
	@Override
	public void pickUp(Key key) {
		// Ghosts can't pick up keys
		return;
	}

	@Override
	public boolean hasKey(Key key) {
		// Ghosts can't have keys
		return false;
	}

	@Override
	public void addTreasure() {
		// Ghosts can't pick up treasure
		return;
	}

	@Override
	public int getTreasure() {
		// Ghosts can't have treasure
		return 0;
	}

	@Override
	public boolean canMove(Direction d) {
		switch (d) {
		case EAST:
			if (location.getX() < maze.getMaxX()) {
				return true;
			}
			break;
		case NORTH:
			if (location.getY() > 0) {
				return true;
			}
			break;
		case SOUTH:
			if (location.getY() < maze.getMaxY()) {
				return true;
			}
			break;
		case WEST:
			if (location.getX() > 0) {
				return true;
			}
			break;
		default:
			return false;
		}
		return false;
	}

	@Override
	public void move(Direction d) {
		switch (d) {
		case EAST:
			location = new Location(location.getX() + 1, location.getY());
			return;
		case NORTH:
			location = new Location(location.getX(), location.getY() - 1);
			return;
		case SOUTH:
			location = new Location(location.getX(), location.getY() + 1);
			return;
		case WEST:
			location = new Location(location.getX() - 1, location.getY());
		default:
			return;
		
		}
	}

	@Override
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Determines which direction the ghost must move next to stay on its path
	 * 
	 * Path order:
	 * 
	 *  - Start at start
	 *  - Line up with ends X
	 *  - Line up with ends Y
	 *  - At end
	 *  - Line up with starts X
	 *  - Line up with starts Y
	 *  - Back at start (repeat)
	 * 
	 * @return The direction to move in
	 */
	public Direction getDirection() {
		if (toEnd) {
			if (location.getX() != end.getX()) {
				if (location.getX() > end.getX()) {
					return Direction.WEST;
				} else {
					return Direction.EAST;
				}
			}
			if (location.getY() != end.getY()) {
				if (location.getY() > end.getY()) {
					return Direction.NORTH;
				} else {
					return Direction.SOUTH;
				}
			}
			toEnd = false;
		}
		if (location.getX() != start.getX()) {
			if (location.getX() > start.getX()) {
				return Direction.WEST;
			} else {
				return Direction.EAST;
			}
		}
		if (location.getY() != start.getY()) {
			if (location.getY() > start.getY()) {
				return Direction.NORTH;
			} else {
				return Direction.SOUTH;
			}
		}
		toEnd = true;
		return getDirection();
	}

}
