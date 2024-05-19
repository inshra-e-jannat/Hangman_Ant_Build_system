package oata;

import java.util.Scanner;

public class Hangman {
    private static final String[] WORDS = {"java", "python", "javascript", "ruby", "cplusplus"};
    private static final int MAX_TRIES = 6;

    private String secretWord;
    private char[] guessedLetters;
    private int triesLeft;

    public Hangman() {
        secretWord = WORDS[(int) (Math.random() * WORDS.length)];
        guessedLetters = new char[secretWord.length()];
        triesLeft = MAX_TRIES;
        for (int i = 0; i < secretWord.length(); i++) {
            guessedLetters[i] = '_';
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (triesLeft > 0) {
            System.out.println("\nSecret word: " + new String(guessedLetters));
            System.out.println("Tries left: " + triesLeft);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            if (!updateGuessedLetters(guess)) {
                triesLeft--;
                System.out.println("Incorrect guess!");
            } else {
                System.out.println("Correct guess!");
            }

            if (isWordGuessed()) {
                System.out.println("Congratulations! You guessed the word: " + secretWord);
                return;
            }
        }

        System.out.println("You ran out of tries! The word was: " + secretWord);
    }

    private boolean updateGuessedLetters(char guess) {
        boolean found = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess) {
                guessedLetters[i] = guess;
                found = true;
            }
        }
        return found;
    }

    private boolean isWordGuessed() {
        for (char c : guessedLetters) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    class Game{
        public static void main(String[] args) {
            System.out.println("Welcome to Hangman!");
            Hangman hangman = new Hangman();
            hangman.play();
        }
    }    
}
