package exam.rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exam.rover.exception.InputValidationException;

public class RoverNavigationApp {

	public static void main(String[] args) {
		System.out.println("Type \"quit\" to exit the program");
		final RoverNavigation roverNavigation = new RoverNavigation();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String navigationInput = null;

		try {
			do {
				navigationInput = br.readLine();
				try {
					String movementOutput = roverNavigation.navigate(navigationInput);
					if (!navigationInput.equals("quit")) {
						System.out.println(movementOutput);
					}
				} catch (InputValidationException e) {
					System.out.println(e.getMessage());
				}
			} while (!navigationInput.equals("quit"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
