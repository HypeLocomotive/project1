package LAB1.mod;

import LAB1.mod.Position;

public class Maze {
	//INSTANCE VARIABLES
	private boolean[][] _maze;
	private Position _start;
	private Position _end;
	
	/*
	 * This method is used to get the starting position of the player
	 */
	private static Position[] playerStart = { 
											  new Position (18,2),
											  new Position (19,19),
											  new Position (0,19),
											  new Position (0,11)
											};
	
	/*
	 * This method is used to get the end position of the player, at least what is 
	 * supposed to be the end
	 */
	private static Position[] playerEnd = {
											new Position (0,19),
											new Position (6,1),
											new Position (19,6),
											new Position (17,18)
										  };
	//Setting positions to be manipulated
	private static int PLAYER_START_ROW = playerStart [Position.pp].getRow();
	private static int PLAYER_START_COL = playerStart [Position.pp].getCol(); 
	private static int PLAYER_END_ROW = playerEnd [Position.pp].getRow(); 
	private static int PLAYER_END_COL = playerEnd [Position.pp].getCol(); 
	
	//GETTERS
	public Position getStart() { return _start; }
	public Position getEnd() { return _end; }
	
	public boolean[][] getMaze() { return _maze; }
	
	//constructor builds the actual structure of the maze
	public Maze() {
		// true is a wall.
		boolean[][] maze = {
				{true, 	true, 	true,	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true,	false, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	false}, 
				{true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	false, 	false, 	false, 	false},
				{true, 	true, 	true, 	true, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	true, 	true, 	true, 	false, 	true},
				{true, 	true, 	true, 	true, 	true, 	false, 	true, 	true, 	true, 	false, 	true, 	false, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
				{true,	false, 	false, 	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true, 	true, 	true, 	true, 	false, 	false, 	false, 	true},
				{true, 	false, 	true, 	false, 	true, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, 	true},
				{true,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	true, 	false, 	false, 	true},
				{true, 	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	true, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	true, 	false, 	true},
				{true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, 	true},
				{true, 	true, 	false, 	true, 	true, 	true, 	true, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true, 	true, 	true},
				{true, 	true, 	true,	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true,	true, 	true, 	true, 	false, 	true, 	false, 	true, 	true, 	true}, 
				{true, 	true, 	true, 	true, 	true, 	false, 	false, 	false, 	true, 	false, 	true, 	true, 	false, 	true, 	false, 	false, 	false, 	false, 	false, 	true},
				{true, 	true, 	true, 	true, 	true, 	false, 	true, 	false, 	true, 	false, 	true, 	true, 	false, 	true, 	true, 	false, 	true, 	true, 	true, 	true},
				{true, 	true, 	true, 	true, 	true, 	false, 	false, 	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true, 	true, 	true, 	true},
				{true,	true, 	true, 	true, 	true, 	false, 	true, 	false, 	true, 	false, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	true, 	true, 	true},
				{true, 	true, 	true, 	false, 	false, 	false, 	false, 	false, 	true, 	false, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	true, 	true, 	true},
				{true,	true, 	true, 	false, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, 	true, 	true},
				{true, 	true, 	true, 	false, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	false, 	true, 	true, 	false, 	true, 	true, 	true, 	false, 	true},
				{true, 	true, 	false, 	false, 	true, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	true, 	true, 	false, 	false, 	true, 	true, 	false, 	true},
				{true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, 	true, 	false, 	true, 	true, 	true, 	true, 	true, 	false, 	false, 	false, 	false, 	false},
				};
		_maze = maze;
		_start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
		_end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
	}
}
