package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public class SkipCard extends EffectCard {
    // TODO Implement here
	public SkipCard(CardColor color) {
		super(color,CardSymbol.SKIP);
	}
	public String toString() {
		return this.getColor()+" "+ this.getSymbol();
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
		GameLogic.getInstance().goToNextPlayer();
		while(GameLogic.getInstance().getCurrentPlayerHand().isEmpty()) {
			GameLogic.getInstance().goToNextPlayer();	
		}
		return "Skipped player "+GameLogic.getInstance().getCurrentPlayer();
	}


}
