package wordleClone;

public class Letter {

	private String lt;
	private int count;

	public Letter(String ltr) {
		lt = ltr;
		count = 1;
	}

	public String getLetter() {
		return lt;
	}

	public void incrementCount() {
		count++;
	}

	public int getCount() {
		return count;
	}
}