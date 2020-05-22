package LAB1.mod;

public class Sword {
	// Instance variables
	private Position _curPos;

	// Array to specify the possible sword starting positions
	private static Position[] swordStart = { new Position(9, 15), new Position(13, 6), new Position(6, 2),
			new Position(13, 12) };

	// Establishes the starting row and col for the sword object
	private static int SWORD_START_ROW = swordStart[Position.pp].getRow();
	private static int SWORD_START_COL = swordStart[Position.pp].getCol();

	// GETTER
	public Position getSwordPosition() {
		return _curPos;
	}

	// CONSTRUCTOR
	public Sword(Maze z) {
		_curPos = new Position(SWORD_START_ROW, SWORD_START_COL);
	}
}