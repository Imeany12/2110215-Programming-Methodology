package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class ChangeColorCard extends EffectCard {
	// TODO Implement here
	public ChangeColorCard() {
		super(null, CardSymbol.CHANGE_COLOR);
	}

	public String toString() {
		if (this.getColor() == null) {
			return "CHANGE COLOR";
		} else {
			return "CHANGE COLOR (" + this.getColor() + " color selected)";
		}
	}

	public boolean canPlay() {
		return true;
	}

	public String performEffect() {
		ArrayList<BaseCard> currentHand = GameLogic.getInstance().getCurrentPlayerHand();
		currentHand.remove(this);
		if (currentHand.isEmpty()) {
			this.setColor(CardColor.RED);
		} else if (currentHand.get(0).getColor()==null) {
			this.setColor(CardColor.RED);
		} else {
			this.setColor(currentHand.get(0).getColor());
		}
		return "Set color to " + this.getColor();

	}

}
