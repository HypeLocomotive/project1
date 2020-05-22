package LAB1.mod;

public class Player {

	// Instance variables
	private Position _curPos;

	private boolean _isAlive = true;

	// GETTER
	public Position getPlayerPosition() {
		return _curPos;
	}

	// Used to perform actions of the player is still alive
	public boolean isAlive() {
		return _isAlive;
	}

	// SETTER
	public void setPosition(Position p) {
		_curPos = p;
	}

	// Method to end the player's life if hit
	public void killPlayer() {
		_isAlive = false;
	}

	public boolean inInventory = false;

	// Performs the actual action of inputting the sword into the inventory
	public void pickUpSword(Sword t) {
		if (getPlayerPosition().getRow() == t.getSwordPosition().getRow()
				&& getPlayerPosition().getCol() == t.getSwordPosition().getCol()) {
			inInventory = true;
		}
	}

	// Check method to see whether the player has obtained the sword object
	public boolean hasSword(Sword t) {
		return inInventory;
	}

	// CONSTRUCTOR
	public Player(Maze z) {
		_curPos = new Position(z.getStart().getRow(), z.getStart().getCol());
	}

	/*
	 * This method is used to move the player in relation to which button is pressed
	 * using the enums established in the Directions class
	 */
	public boolean move(Direction d, Maze z) {
		if (d == Direction.North) {
			if (_curPos.getRow() - 1 >= 0 && !z.getMaze()[_curPos.getRow() - 1][_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() - 1, _curPos.getCol());
				return true;
			}
		} else if (d == Direction.South) {
			if (_curPos.getRow() + 1 < z.getMaze().length && !z.getMaze()[_curPos.getRow() + 1][_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() + 1, _curPos.getCol());
				return true;
			}
		} else if (d == Direction.East) {
			if (_curPos.getCol() + 1 < z.getMaze()[_curPos.getRow()].length
					&& !z.getMaze()[_curPos.getRow()][_curPos.getCol() + 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
				return true;
			}
		} else {
			if (_curPos.getCol() - 1 >= 0 && !z.getMaze()[_curPos.getRow()][_curPos.getCol() - 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
				return true;
			}
		}

		return false;
	}
}
