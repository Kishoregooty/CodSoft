import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int rounds = 0;
        
        System.out.println("Welcome to the Guess the Number Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int guess;
            int attempts = 0;
            final int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("\nI'm thinking of a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1;  // Higher score for fewer attempts
                    hasGuessedCorrectly = true;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            rounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("\nGame over! You played " + rounds + " rounds and your total score is: " + totalScore);
        scanner.close();
    }
}
