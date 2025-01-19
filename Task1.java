import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Game!");
        int score = 0; // Tracks rounds won
        int roundNumber = 1;

        while (true) {
            System.out.println("\n--- Round " + roundNumber + " ---");
            int targetNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attemptsLeft = 5; // Set number of attempts
            boolean roundWon = false;

            System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess;

                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                if (guess < 1 || guess > 100) {
                    System.out.println("Your guess is out of range! Please guess a number between 1 and 100.");
                    continue;
                }

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    score++;
                    roundWon = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!roundWon) {
                System.out.println("You've run out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.println("Your current score: " + score + " rounds won.");

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Final score: " + score);
                break;
            }

            roundNumber++;
        }

        scanner.close();
    }
}
