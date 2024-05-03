import java.util.Scanner;
import java.util.Random;

public class NumberGuesser {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomNumberGenerator = new Random();
        int lowerBound = 1;
        int upperBound = 10;
        int attempts = 0;
        int totalScore = 0;

        System.out.println("Welcome to Number Guesser!");

        boolean playAgain = true;
        while (playAgain) {
            int secretNumber = randomNumberGenerator.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("I've selected a number between " + lowerBound + " and " + upperBound + ". Guess it!");

            boolean guessedCorrectly = false;
            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = inputScanner.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += attempts;
                    guessedCorrectly = true;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = inputScanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            } else {
                attempts = 0;
            }
        }

        System.out.println("Your total score is: " + totalScore);
        System.out.println("Thanks for playing!");
        inputScanner.close();
    }
}
