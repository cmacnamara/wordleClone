package wordleClone;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		// Initializing stuff
		printWelcome();

		// Make method to choose random 5-letter word from file (or list?)
		String secretWord = "elden";
		ArrayList<Letter> charCounts = new ArrayList<>();
		initCharCounts(charCounts, secretWord);

		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter number of attempts (Press \'Enter\' for default of 6): ");
		String initialAttemptsString = scan.nextLine();
		int initialAttempts = parseAttempts(initialAttemptsString);
		Board board = new Board(initialAttempts);

		int attemptsTaken = 0;
		board.printBoard();

		String guess = "";

		// MAIN WHILE LOOP
		while (!guess.equals(secretWord) && attemptsTaken < initialAttempts) {
			System.out.println("Enter guess: ");
			guess = scan.nextLine();
			board.setWord(attemptsTaken, assemble(guess, secretWord, board));
			board.printBoard();
			attemptsTaken++;
		} // END GAME

		// Print winning message
		if (guess.equals(secretWord)) {
			for (int i = 0; i < 20; i++) {
				System.out.println("YOU WIN!!!");
			}
		}
		// Print losing message
		else {
			System.out.println("\n\n\n");
			System.out.println("¯\\_('u')_/¯ Better luck next time... ");
			System.out.println("\n\n\n");
		}
	}// End main method

	// Updates board with current guess and hints
	public static String assemble(String guess, String secretW, Board b) {
		String result = "";
		for (int i = 0; i < 5; i++) {
			if (guess.charAt(i) == secretW.charAt(i)) {
				result += " [   " + guess.charAt(i) + "** ]";
			} else if (existsInWord(guess.substring(i, i + 1), secretW)) {
				result += " [   " + guess.charAt(i) + "*  ]";
			} else {
				result += " [   " + guess.charAt(i) + "   ]";
			}
		}
		return result;
	}

	// Returns true if given letter exists in word
	public static boolean existsInWord(String letter, String secretWord) {
		for (int i = 0; i < secretWord.length(); i++) {
			if (letter.equals(secretWord.substring(i, i + 1)))
				return true;
		}
		return false;
	}

	// Helper method to set number of attempts
	public static int parseAttempts(String s) {
		int six = 6;
		if (s.equals(""))
			return six;
		else
			return Integer.parseInt(s);
	}

	// Initializes Letter array to count the number of each character in the secret
	// word
	public static void initCharCounts(ArrayList<Letter> charCounts, String word) {
		charCounts.add(new Letter(word.substring(0, 1)));
		for (int i = 1; i < word.length(); i++) {
			int idx = alreadyExists(charCounts, word.substring(i, i + 1));
			if (idx < 0) {
				charCounts.add(new Letter(word.substring(i, i + 1)));
			} else {
				charCounts.get(idx).incrementCount();
			}
		}
		/*
		 * for(Letter l: charCounts){ System.out.println(l.getLetter() + " Count: " +
		 * l.getCount()); }
		 */
	}

	// Returns -1 if its a new character, else returns index of pre-existing letter
	// object
	public static int alreadyExists(ArrayList<Letter> charCounts, String word) {
		for (int i = 0; i < charCounts.size(); i++) {
			if (charCounts.get(i).getLetter().equals(word.substring(0, 1))) {
				return i;
			}
		}
		return -1;
	}

	public static void printWelcome() {
		System.out.println("\n**************************************************");
		System.out.println("*                                                *");
		System.out.println("*           Welcome to...                        *");
		System.out.println("*                                                *");
		System.out.println("*               W O R D L E   C L O N E          *");
		System.out.println("*                                                *");
		System.out.println("**************************************************");
		System.out.println();

	
	}

}// End Main Class
