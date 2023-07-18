package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import logic.game.PlayDirection;

//You CAN modify the first line
public class ReverseCard extends EffectCard {
    // TODO Implement here
	public ReverseCard(CardColor color) {
		super(color,CardSymbol.REVERSE);
	}
	public String toString() {
		return this.getColor()+ " "+ this.getSymbol();
	}
	public boolean canPlay() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		if (this.getColor().equals(topCard.getColor())||this.getSymbol().equals(topCard.getSymbol())) {
			return true;
		}else {
			return false;
		}
	}
	public String performEffect() {
		PlayDirection D =GameLogic.getInstance().getPlayDirection().getOpposite();
		GameLogic.getInstance().setPlayDirection(D);
		return "Set direction to "+D;
		
	}
}
