package exam.rover;

import java.util.List;
import exam.rover.control.NavigationController;
import exam.rover.parser.NavigationInputParser;

public class RoverNavigation {

	private final NavigationInputParser navigationInputParser = new NavigationInputParser();

	private final NavigationController navigationController = new NavigationController();

	public String navigate(String inputCommands) {
		List<String> commandList = this.navigationInputParser.parseInput(inputCommands);
		return this.navigationController.move(commandList);
	}

}
