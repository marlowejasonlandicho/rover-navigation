package exam.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exam.rover.exception.InputValidationException;

class RoverNavigationTest {
	private RoverNavigation roverNavigation;

	@BeforeEach
	void setUp() throws Exception {
		roverNavigation = new RoverNavigation();
	}

	@Test
	void testNavigateSampleInput() {
		String result = roverNavigation.navigate("LMLMLMLMLM");
		assertEquals("-1, 0, W", result);
	}

	@Test
	void testNavigateMove() {
		String result = roverNavigation.navigate("M");
		assertEquals("0, 1, N", result);
	}

	@Test
	void testNavigateMoveTwice() {
		String result = roverNavigation.navigate("MM");
		assertEquals("0, 2, N", result);
	}

	@Test
	void testNavigateLeft() {
		String result = roverNavigation.navigate("LM");
		assertEquals("-1, 0, W", result);
	}

	@Test
	void testNavigateLeftTwice() {
		String result = roverNavigation.navigate("LMLM");
		assertEquals("-1, -1, S", result);
	}

	@Test
	void testNavigateRight() {
		String result = roverNavigation.navigate("RM");
		assertEquals("1, 0, E", result);
	}

	@Test
	void testNavigateRightTwice() {
		String result = roverNavigation.navigate("RMRM");
		assertEquals("1, -1, S", result);
	}

	@Test
	void testNavigateInvalidInput() {
		InputValidationException inputValidationException = assertThrows(InputValidationException.class, () -> {
			roverNavigation.navigate("AAA");
		});

		String expectedMessage = "Invalid Input. Only L-Left, R-Right, M-Move characters are allowed";
		String exceptionMessage = inputValidationException.getMessage();

		assertEquals(exceptionMessage, expectedMessage);
	}

}
