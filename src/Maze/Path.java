package Maze;

public class Path {
	
	private Location start;
	private Location end;
	
	public Path(Location l1, Location l2) {
		start = l1;
		end = l2;
	}
	
	Location getStart() {
		return start;
	}
	
	Location getEnd() {
		return end;
	}
}
