package LAB1.view;

import LAB1.mod.Maze;
import LAB1.mod.Minotaur;
import LAB1.mod.Player;
import LAB1.mod.Rat;
import LAB1.mod.Sword;

public class StringMap {
	
	public String _map;
	
	//CONSTRUCTOR
	public StringMap() {
		_map = "";
	}
	
	/*
	 * This method actually puts the letters into the map, so
	 * a sort of low level graphics
	 */
	public String updateMap(Player p, Minotaur m, Rat a, Rat b, Rat i, Maze z, Sword t) {
		_map = "";
		for (int r = 0; r < z.getMaze().length; r++) {
			for (int c = 0; c < z.getMaze()[r].length; c++) {
				if (z.getMaze()[r][c]) {
					_map += "W"; // WALL
					if (c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				} else if (r == p.getPlayerPosition().getRow() && c == p.getPlayerPosition().getCol()) {
					_map += "P"; // PLAYER
					if (c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				} else if (r == m.getMinotaurPosition().getRow() && c == m.getMinotaurPosition().getCol()
						&& m.isAlive() == true) {
					_map += "M"; // MINOTAUR
					if (c != z.getMaze()[r].length - 1) {
						_map += " ";
					} else if (m.isAlive() == false) {
						_map += " ";
					}
				}

				else if (r == z.getEnd().getRow() && c == z.getEnd().getCol()) {
					_map += "E"; // EXIT
					if (c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				} else if (r == a.getRat1Position().getRow() && c == a.getRat1Position().getCol()
						&& a.isAlive() == true) {
					_map += "R"; // RAT1
					if (c != z.getMaze()[r].length - 1) {
						_map += " ";
					} else if (a.isAlive() == false) {
						_map += " ";
					}
				} else if (r == b.getRat2Position().getRow() && c == b.getRat2Position().getCol()
						&& b.isAlive() == true) {
					_map += "R"; // RAT2
					if (c != z.getMaze()[r].length - 1) {
						_map += " ";
					} else if (b.isAlive() == false) {
						_map += " ";
					}
				} else if (r == i.getRat3Position().getRow() && c == i.getRat3Position().getCol()
						&& i.isAlive() == true) {
					_map += "R"; // RAT3
					if (c != z.getMaze()[r].length - 1) {
						_map += " ";
					} else if (i.isAlive() == false) {
						_map += " ";
					}
				} else if (r == t.getSwordPosition().getRow() && c == t.getSwordPosition().getCol()
						&& p.hasSword(t) == false) {
					_map += "S"; // SWORD
					if (c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				} else {
					_map += ":  :"; // PATH
					if (c != z.getMaze()[r].length - 1) {
						_map += " ";
					}
				}
			}
			_map += "\n";
		}

		return _map;
	}

}