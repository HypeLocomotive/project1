package LAB1.cont;

import LAB1.mod.*; 

import LAB1.view.*;

public class Overseer {
	
	//INSTANCE VARIABLES
	private Player _p;
	private Minotaur _m;
	private Maze _z;
	private StringMap _s;
	private Window _w;
	private Rat _a;
	private Rat _b;
	private Rat _i;
	private Sword _t;
	private static final String[] BUTTONS = { "NORTH", "SOUTH", "WEST", "EAST", "HELP", "EXIT" };
	private static final String[] REPLAY = {"SLEEP ONCE MORE", "JUST WAKE UP"};
	
	//CONSTRUCTOR
	public Overseer() {
		_w = new Window();
		_w.msg("Today's that day again, the anniversary. Harry spends the day performing mundane tasks around the house, moping around and \n"
				+ "feeling bad for himself. But he soon comes to realize that she wouldn't want him to feel like that, not for her sake.\n"
				+ "On his way out of the house he passes by the plushies she gave him just a few days before the incident, the plushies he \n"
				+ "partially dreaded looking at. They made him sad, that trio of rats and that fluffy minotaur. He only had them out because \n"
				+ "she said she'd haunt him if he ever took them down. He gets up to go spend a night out on the boardwalk, but soon enough \n"
				+ "he has enough of all the painful memories of smiling and laughter with the woman of his dreams, the Ruby he'd always dreamt \n"
				+ "of. She always called him her knight, and he treated her like the Ruby she was properly named after. Having gotten home in \n"
				+ "a dreary state, he noticed the plushies had vanished, and immediately he began to panic. She didn't like to have many things, \n"
				+ "so those were some of the few reminders he had of her. After hours of searching, he gave in, and decided it may have been the \n"
				+ "second shittiest day of his life. He sat back in bed, dried up tears on his cheeks, and went into a deep slumber, one of unrest. \n"
				+ "When he opened his eyes, something peculiar happened, he awoke in a suit of armor, to the sight of her transparent face. She held \n"
				+ "his cheeks and whispered \"come with me\" as she receded back into the darkness. The tears began to flow again, but Harry soon \n"
				+ "came to his senses and realized he was in a dimly lit dungeon, still in his pajamas, only it seems he's not alone... there may be \n"
				+ "some familiar faces in the maze.");
		_z = new Maze();
		_s = new StringMap();
		_p = new Player(_z);
		_m = new Minotaur(_z);
		_a = new Rat(_z);
		_b = new Rat(_z);
		_i = new Rat(_z);
		_t = new Sword(_z);
		getPlayerMovement();
	}
	
	//Getter for the movement of the player
	public void getPlayerMovement() {
		while (true) {
			while (_p.isAlive()) {
				int x = _w.option(BUTTONS, _s.updateMap(_p, _m,_a,_b,_i,_z,_t));
				move(x);
				gamecheck();
			}
			_z = new Maze();
			_s = new StringMap();
			_p = new Player(_z);
			_m = new Minotaur(_z);
			_a = new Rat(_z);
			_b = new Rat(_z);
			_i = new Rat(_z);
			_t = new Sword(_z);
		}

	}

	/*
	 * This method just established to movements of the player in specific
	 */
	public void move(int x) {
		if (!_p.move(getPlayerInput(x), _z)) {
			_w.msg("YOU CAN'T MOVE IN THAT DIRECTION!");
			_m.hardMove(_z.getMaze(),_p);
			_a.amoveHoriz(_z);
			_b.bmoveVert(_z);
			_i.imoveHoriz(_z);
		} else {
			_m.hardMove(_z.getMaze(),_p);
			_a.amoveHoriz(_z);
			_b.bmoveVert(_z);
			_i.imoveHoriz(_z);
		}
	}
	
	/*
	 * This method establishes the movements of all aspects of the project
	 * in relation to the player
	 */
	public void gamecheck() {
		if (_p.getPlayerPosition().getRow() == _t.getSwordPosition().getRow() // P gets S
				&& _p.getPlayerPosition().getCol() == _t.getSwordPosition().getCol() 
				&& _p.inInventory == false) {
			_w.msg("Atta boy Harry, that's the knight in shining armor you always strived to be! (It's really a fork but don't tell him)");
			_p.inInventory = true;
		}
		if (_p.getPlayerPosition().getRow() == _m.getMinotaurPosition().getRow()
				&& _p.getPlayerPosition().getCol() == _m.getMinotaurPosition().getCol() && _p.inInventory == false) {
			_p.killPlayer();
			_w.msg("The minotaur slams his ginormous, terrifying, fluffy, squeaky hands on you! Oh wait, it was just the plushie, musta been a nice nap Harry.");
		}
		if (_p.getPlayerPosition().getRow() == _m.getMinotaurPosition().getRow()
				&& _p.getPlayerPosition().getCol() == _m.getMinotaurPosition().getCol() && _p.inInventory == true) {
			_m.killMinotaur();
			_w.msg("The ginormous beast gets punctured and immediately deflates to the small little furball it once was, I'm glad you kept it Harry.");
			int x = _w.option(REPLAY, "Would you care to dream once more?");
			if(x == 0) {
				L2Main.main(new String [0]);
			}
			else {
				System.exit(0);
			}
		}
		if (_p.getPlayerPosition().getRow() == _a.getRat1Position().getRow()
				&& _p.getPlayerPosition().getCol() == _a.getRat1Position().getCol() && _p.inInventory == false) {
			_p.killPlayer();
			_w.msg("You got killed... by a plushie... not your proudest moment eh Harry?");

		}
		if (_p.getPlayerPosition().getRow() == _b.getRat2Position().getRow()
				&& _p.getPlayerPosition().getCol() == _b.getRat2Position().getCol() && _p.inInventory == false) {
			_p.killPlayer();
			_w.msg("You got killed... by a plushie... not your proudest moment eh Harry?");
		}

		if (_p.getPlayerPosition().getRow() == _i.getRat3Position().getRow()
				&& _p.getPlayerPosition().getCol() == _i.getRat3Position().getCol() && _p.inInventory == false) {
			_p.killPlayer();
			_w.msg("You got killed... by a plushie... not your proudest moment eh Harry?");
		}
		if (_p.getPlayerPosition().getRow() == _a.getRat1Position().getRow()
				&& _p.getPlayerPosition().getCol() == _a.getRat1Position().getCol() && _p.inInventory == true) {
			_a.killRat();
			_p.inInventory = false;
			_w.msg("The rat's fluffy insides flow out until it is nothing but a piece of cloth. Could it be the rat wasn't real?");

		}
		if (_p.getPlayerPosition().getRow() == _b.getRat2Position().getRow()
				&& _p.getPlayerPosition().getCol() == _b.getRat2Position().getCol() && _p.inInventory == true) {
			_b.killRat();
			_p.inInventory = false;
			_w.msg("The rat's fluffy insides flow out until it is nothing but a piece of cloth. Could it be the rat wasn't real?");
		}

		if (_p.getPlayerPosition().getRow() == _i.getRat3Position().getRow()
				&& _p.getPlayerPosition().getCol() == _i.getRat3Position().getCol() && _p.inInventory == true) {
			_i.killRat();
			_p.inInventory = false;
			_w.msg("The rat's fluffy insides flow out until it is nothing but a piece of cloth. Could it be the rat wasn't real?");
		}

		if (_p.getPlayerPosition().getRow() == _z.getEnd().getRow()
				&& _p.getPlayerPosition().getCol() == _z.getEnd().getCol()) {
			_p.killPlayer();
			_w.msg("You've reached one more moment of peace to spend with Ruby.");
			int y = _w.option(REPLAY, "Would you care to dream once more?");
			if(y == 0) {
				L2Main.main(new String [0]);
			}
			else {
				System.exit(0);
			}
		}

	}

	/*
	 * This is the method the returns the direction enum and connects them
	 * to the buttons of the actual game
	 */
	public Direction getPlayerInput(int x) {
        if (x == 0) {
            // NORTH
            return Direction.North;
        } else if (x == 1) {
            // SOUTH
            return Direction.South;
        } else if (x == 2) {
            // EAST
            return Direction.West;
        } else if (x == 3) {
            // WEST
            return Direction.East;
        } else if (x == 4) {
            //HELP
        	_w.msg("Uh, Harry. You know this is YOUR dream right? You really don't need help \n"
        			+ "\n"
        			+ "Fine I'll play along. AHEM - Oh my heavens! It appears Harry is stuck \n"
        			+ "in a maze of creepy crawlies and monsters! His plushies have evolved into \n"
        			+ "REAL sneaky rats and a big, killer Minotaur! \n"
        			+ "\n"
        			+ "Traverse the caverns in search of the legendary Fork sword! Marked by an S on ye ol' map \n"
        			+ "Once you've got the fork of destiny by stepping on it, take it to the raging Minotaur marked by an M\n"
        			+ "and conquer it! Make sure to avoid rats marked by an R because you will waste your weapon should it dig \n"
        			+ "into the fluff of one. \n"
        			+ "Make sure to try to kite around the minotaur as it WILL chase you down! While the rats walk in \n"
        			+ "pre destined patterns. \n"
        			+ "Also, a heads up, if you run into a wall, time still moves along with the monsters. \n"
        			+ "I will be waiting for you at the end of the maze marked by an E, I've been waiting a long time Harr.");
        }
        else {
        	System.exit(0);
            return null;
        }
        return null;
	}

}
