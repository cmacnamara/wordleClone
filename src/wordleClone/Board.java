package wordleClone;

public class Board {

	private String[] board;

	public Board(int size) {
		board = new String[size];
		for (int i = 0; i < size; i++) {
			board[i] = " [       ] [       ] [       ] [       ] [       ]";
		}

	}

	public String getWord(int i) {
		return board[i];
	}

	public void setWord(int i, String word) {
		board[i] = word;
	}

	public void printBoard() {
		System.out.println();
		for (String s : board) {
			System.out.println(s + "\n");
		}
	}
}
