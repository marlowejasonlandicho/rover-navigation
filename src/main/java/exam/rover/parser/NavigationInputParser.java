package exam.rover.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import exam.rover.exception.InputValidationException;

public class NavigationInputParser {

	private static final String ALLOWED_COMMANDS = "[LRM]*|quit";

	public List<String> parseInput(String inputCommands) {

		final Optional<String> optionalInput = Optional.ofNullable(inputCommands);

		if (!optionalInput.orElse("").matches(ALLOWED_COMMANDS)) {
			throw new InputValidationException("Invalid Input. Only L-Left, R-Right, M-Move characters are allowed");
		}

		final String[] inputArray = optionalInput.orElse("").split("");
		final List<String> result = new ArrayList<>(Arrays.asList(inputArray));

		return result;

	}

}
