package exam.rover.model;

public enum Direction {

	NORTH("N"), SOUTH("S"), WEST("W"), EAST("E");

	private String direction;

	Direction(String direction) {

		this.direction = direction;
	}

	@Override
	public String toString() {
		return this.direction;
	}

}
