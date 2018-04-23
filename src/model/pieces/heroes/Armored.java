package model.pieces.heroes;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;

public class Armored extends NonActivatablePowerHero {

	private boolean armorUp;

	public Armored(Player player, Game game, String name) {
		super(player, game, name);
		this.armorUp = true;
		setAllowedDirections(new ArrayList<>(Arrays.asList(Direction.DOWN, Direction.DOWNLEFT, Direction.DOWNRIGHT, Direction.LEFT,
				Direction.RIGHT, Direction.UP, Direction.UPLEFT, Direction.UPRIGHT)));

	}

	public boolean isArmorUp() {
		return armorUp;
	}

	public void setArmorUp(boolean armorUp) {
		this.armorUp = armorUp;
	}
    
	@Override
	public void move(Direction r) throws WrongTurnException, UnallowedMovementException, OccupiedCellException {
		Direction[] allowedMoves = { Direction.DOWN, Direction.DOWNLEFT, Direction.DOWNRIGHT, Direction.LEFT,
				Direction.RIGHT, Direction.UP, Direction.UPLEFT, Direction.UPRIGHT };
		move(1, r, allowedMoves);
	}
	
	@Override
	public String toString() {
		return "A";
	}
}
