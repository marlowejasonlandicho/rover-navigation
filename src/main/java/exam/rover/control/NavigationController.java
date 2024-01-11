package exam.rover.control;

import java.util.List;

import exam.rover.model.Direction;
import exam.rover.model.Position;

public class NavigationController {

	private final Position position = new Position();

	public String move(List<String> navCommands) {
		for (String navCommand : navCommands) {
			switch (navCommand) {
				case "L":
					moveLeft();
					break;
				case "R":
					moveRight();
					break;
				case "M":
					moveForward();
					break;
			}
		}

		return position.toString();
	}

	private void moveForward() {
		switch (position.getDirection()) {
			case NORTH:
				position.setY(position.getY() + 1);
				break;
			case SOUTH:
				position.setY(position.getY() - 1);
				break;
			case WEST:
				position.setX(position.getX() - 1);
				break;
			case EAST:
				position.setX(position.getX() + 1);
				break;
		}
	}

	private void moveLeft() {
		switch (position.getDirection()) {
			case NORTH:
				position.setDirection(Direction.WEST);
				break;
			case SOUTH:
				position.setDirection(Direction.EAST);
				break;
			case WEST:
				position.setDirection(Direction.SOUTH);
				break;
			case EAST:
				position.setDirection(Direction.NORTH);
				break;
		}
	}

	private void moveRight() {
		switch (position.getDirection()) {
			case NORTH:
				position.setDirection(Direction.EAST);
				break;
			case SOUTH:
				position.setDirection(Direction.WEST);
				break;
			case WEST:
				position.setDirection(Direction.NORTH);
				break;
			case EAST:
				position.setDirection(Direction.SOUTH);
				break;
		}
	}

}
