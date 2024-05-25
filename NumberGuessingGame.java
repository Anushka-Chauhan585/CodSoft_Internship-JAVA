import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        // Create a Random object to generate random numbers
        Random random = new Random();
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            // Generate a random number between 1 and 100
            int targetNumber = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 10; // Maximum number of attempts allowed

            // Start a new round
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have chosen a number between 1 and 100. Try to guess it!");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            while (guess != targetNumber && attempts < maxAttempts) {
                // Prompt the user to enter their guess
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                // Provide feedback based on the user's guess
                if (guess > targetNumber) {
                    System.out.println("Your guess is too high. Try again.");
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                }

                // Inform the user of remaining attempts
                if (guess != targetNumber && attempts < maxAttempts) {
                    System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
                }
            }

            // Check if the user has exhausted all attempts
            if (attempts == maxAttempts && guess != targetNumber) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + targetNumber);
            }

            // Ask if the user wants to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

            // Print a newline for better readability
            System.out.println();
        }

        // Close the scanner
        scanner.close();
        System.out.println("Thank you for playing! Goodbye!");
    }
}
