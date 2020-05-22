package LAB1.mod;

public class Position {
	// INSTANCE VARIABLES
	public static final int pp = (int) (Math.random() * 3);
	private int _row;
	private int _col;

	// GETTERS
	public int getRow() {
		return _row;
	}

	public int getCol() {
		return _col;
	}

	// CONSTRUCTOR
	public Position(int r, int c) {
		_row = r;
		_col = c;
	}

	// SETTERS
	public void setRow(int r) {
		_row = r;
	}

	public void setCol(int c) {
		_col = c;
	}

}
