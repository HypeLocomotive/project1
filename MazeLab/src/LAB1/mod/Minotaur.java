package LAB1.mod;

public class Minotaur {
	// INSTANCE VARIABLES
	private Position _curPos;
	private boolean _facingLeft = true;
	private static Position[] minoStart = { new Position(1, 11), new Position(6, 4), new Position(18, 6),
			new Position(19, 19) };
	private static int MINOTAUR_START_ROW = minoStart[Position.pp].getRow();
	private static int MINOTAUR_START_COL = minoStart[Position.pp].getCol();

	// CONSTRUCTOR
	public Minotaur(Maze z) {
		_curPos = new Position(MINOTAUR_START_ROW, MINOTAUR_START_COL);
	}

	// GETTERS
	
	public Position getMinotaurPosition() {
		return _curPos;
	}
	
	public int getMinotaurRow() {
		return _curPos.getRow();
	}

	public int getMinotaurCol() {
		return _curPos.getCol();
	}

	private boolean _isAlive = true;

	// This will be used to track the state of the Minotaur
	public boolean isAlive() {
		return _isAlive;
	}

	// This method will be used to ensure it is no longer in the game
	public void killMinotaur() {
		_isAlive = false;
	}

	/*
	 * This method is a check method to ensure the movement of the minotaur in
	 * the general sense of the whole maze.
	 */
	public void minotaurMove(boolean[][] maze) { // CHECK
		if (_curPos.getCol() - 1 >= 0 && !maze[_curPos.getRow()][_curPos.getCol() - 1] && _facingLeft) {
			_curPos.setCol(_curPos.getCol() - 1);
		} else if (_curPos.getCol() + 1 < maze[0].length && !maze[_curPos.getRow()][_curPos.getCol() + 1]
				&& !_facingLeft) {
			_curPos.setCol(_curPos.getCol() + 1);
		} else {
			_facingLeft = !_facingLeft;
		}
	}
	
	/*
	 * This method is a check method to ensure the movement of the minotaur 
	 * specifically in relation to the player.
	 */
	public void hardMove(boolean[][] maze, Player p) {
		int distRow = _curPos.getRow() - p.getPlayerPosition().getRow();
		int distCol = _curPos.getCol() - p.getPlayerPosition().getCol();
		if (distRow > 0) {
			if (!maze[_curPos.getRow() - 1][_curPos.getCol()]) {
				_curPos.setRow(_curPos.getRow() - 1);
			} else {
				if (distCol > 0 && !maze[_curPos.getRow()][_curPos.getCol() - 1]) {
					_curPos.setCol(_curPos.getCol() - 1);
				} else if (!maze[_curPos.getRow()][_curPos.getCol() + 1]) {
					_curPos.setCol(_curPos.getCol() + 1);
				} else if (!maze[_curPos.getRow()][_curPos.getCol() - 1]) {
					_curPos.setCol(_curPos.getCol() - 1);
				} else {
					_curPos.setRow(_curPos.getRow() - 1);
				}
			}
		} else if (distRow == 0) {
			if (distCol > 0 && !maze[_curPos.getRow()][_curPos.getCol() - 1]) {
				_curPos.setCol(_curPos.getCol() - 1);
			} else if (!maze[_curPos.getRow()][_curPos.getCol() + 1]) {
				_curPos.setCol(_curPos.getCol() + 1);
			} else if (!maze[_curPos.getRow() + 1][_curPos.getCol()]) {
				_curPos.setRow(_curPos.getRow() + 1);
			} else if (!maze[_curPos.getRow() - 1][_curPos.getCol()]) {
				_curPos.setRow(_curPos.getRow() - 1);
			} else {
				_curPos.setCol(_curPos.getCol() - 1);
			}
		}

		else {
			if (!maze[_curPos.getRow() + 1][_curPos.getCol()]) {
				_curPos.setRow(_curPos.getRow() + 1);
			} else {
				if (distCol > 0 && !maze[_curPos.getRow()][_curPos.getCol() - 1]) {
					_curPos.setCol(_curPos.getCol() - 1);
				} else if (!maze[_curPos.getRow()][_curPos.getCol() + 1]) {
					_curPos.setCol(_curPos.getCol() + 1);
				} else if (!maze[_curPos.getRow()][_curPos.getCol() - 1]) {
					_curPos.setCol(_curPos.getCol() - 1);
				} else {
					_curPos.setRow(_curPos.getRow() - 1);
				}
			}
		}
	}
}
