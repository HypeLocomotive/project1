package LAB1.mod;

public class Rat {

	// INSTANCE VARIABLES
	private Position _curPosa;
	private Position _curPosb;
	private Position _curPosi;
	private boolean _facingLeft = true;
	private boolean _facingDown = true;

	/*
	 * Establish the general starting positions for all the rats
	 */
	private static Position[] ratStart = { new Position(11, 14), new Position(15, 3), new Position(4, 5),
			new Position(9, 8),

			new Position(11, 5), new Position(11, 12), new Position(0, 11), new Position(7, 16),

			new Position(18, 6), new Position(6, 1), new Position(13, 9), new Position(16, 11) };

	// These variables are used to specify the positions
	private static int RAT1_START_ROW = ratStart[Position.pp].getRow();
	private static int RAT1_START_COL = ratStart[Position.pp].getCol();

	private static int RAT2_START_ROW = ratStart[(Position.pp) + 4].getRow();
	private static int RAT2_START_COL = ratStart[(Position.pp) + 4].getCol();

	private static int RAT3_START_ROW = ratStart[(Position.pp) + 8].getRow();
	private static int RAT3_START_COL = ratStart[(Position.pp) + 8].getCol();

	// GETTERS
	public Position getRat1Position() {
		return _curPosa;
	}

	public Position getRat2Position() {
		return _curPosb;
	}

	public Position getRat3Position() {
		return _curPosi;
	}

	private boolean _isAlive = true;

	// CHECK METHODS
	public boolean isAlive() {
		return _isAlive;
	}

	public void killRat() {
		_isAlive = false;
	}

	// CONSTRUCTOR
	public Rat(Maze z) {
		_curPosa = new Position(RAT1_START_ROW, RAT1_START_COL);
		_curPosb = new Position(RAT2_START_ROW, RAT2_START_COL);
		_curPosi = new Position(RAT3_START_ROW, RAT3_START_COL);
	}

	/*
	 * Method to move the a mouse horizontally specifically
	 */
	public void amoveHoriz(Maze z) {
		if (_facingLeft) {
			if (_curPosi.getCol() - 1 >= 0 && !z.getMaze()[_curPosa.getRow()][_curPosa.getCol() - 1]) {
				_curPosa = new Position(_curPosa.getRow(), _curPosa.getCol() - 1);
			} else {
				_curPosa = new Position(_curPosa.getRow(), _curPosa.getCol() + 1);
				_facingLeft = false;
			}
		} else {
			if (_curPosi.getCol() + 1 < z.getMaze()[_curPosi.getRow()].length
					&& !z.getMaze()[_curPosa.getRow()][_curPosa.getCol() + 1]) {
				_curPosa = new Position(_curPosa.getRow(), _curPosa.getCol() + 1);
			} else {
				_curPosa = new Position(_curPosa.getRow(), _curPosa.getCol() - 1);
				_facingLeft = true;
			}

		}
	}

	/*
	 * Method to move the i mouse horizontally specifically
	 */
	public void imoveHoriz(Maze z) {
		if (_facingLeft) {
			if (_curPosi.getCol() - 1 >= 0 && !z.getMaze()[_curPosi.getRow()][_curPosi.getCol() - 1]) {
				_curPosi = new Position(_curPosi.getRow(), _curPosi.getCol() - 1);
			} else {
				_curPosi = new Position(_curPosi.getRow(), _curPosi.getCol() + 1);
				_facingLeft = false;
			}
		} else {
			if (_curPosi.getCol() + 1 < z.getMaze()[_curPosi.getRow()].length
					&& !z.getMaze()[_curPosi.getRow()][_curPosi.getCol() + 1]) {
				_curPosi = new Position(_curPosi.getRow(), _curPosi.getCol() + 1);
			} else {
				_curPosi = new Position(_curPosi.getRow(), _curPosi.getCol() - 1);
				_facingLeft = true;
			}

		}
	}

	/*
	 * Method to move the b mouse vertically specifically
	 */
	public void bmoveVert(Maze z) {
		if (_facingDown) {
			if (_curPosb.getRow() + 1 < z.getMaze().length && !z.getMaze()[_curPosb.getRow() + 1][_curPosb.getCol()]) {
				_curPosb = new Position(_curPosb.getRow() + 1, _curPosb.getCol());
			} else {
				_curPosb = new Position(_curPosb.getRow() - 1, _curPosb.getCol());
				_facingDown = false;
			}
		} else {
			if (_curPosb.getRow() - 1 >= 0 && !z.getMaze()[_curPosb.getRow() - 1][_curPosb.getCol()]) {
				_curPosb = new Position(_curPosb.getRow() - 1, _curPosb.getCol());
			} else {
				_curPosb = new Position(_curPosb.getRow() + 1, _curPosb.getCol());
				_facingDown = true;
			}

		}
	}
}
