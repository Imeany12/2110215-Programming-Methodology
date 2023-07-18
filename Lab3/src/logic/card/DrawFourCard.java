package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class DrawFourCard extends EffectCard {
	// TODO Implement here
	public DrawFourCard() {
		super(null, CardSymbol.DRAW_FOUR);
	}

	public String toString() {
		if (this.getColor() == null) {
			return "DRAW FOUR";
		} else { 
			return "DRAW FOUR (" + this.getColor() + " color selected)";
		}

	}

	public boolean canPlay() {
		return true;
	}

	public String performEffect() {
		String message = "";
		ArrayList<BaseCard> currentHand = GameLogic.getInstance().getCurrentPlayerHand();
		currentHand.remove(this);
		if (currentHand.isEmpty() || currentHand.get(0).getColor()==null) {
			this.setColor(CardColor.RED);
		} else {
			this.setColor(currentHand.get(0).getColor());
		}
		
		GameLogic.getInstance().incrementDrawAmount(4);
		GameLogic.getInstance().goToNextPlayer();
		
		while (GameLogic.getInstance().getCurrentPlayerHand().isEmpty()) {
			GameLogic.getInstance().goToNextPlayer();
		}
		message+="Set color to " + this.getColor()+"\n";
		for (BaseCard c : GameLogic.getInstance().getCurrentPlayerHand()) {
			if (c.getSymbol().equals(CardSymbol.DRAW_FOUR)) {
				message += "Player " + GameLogic.getInstance().getCurrentPlayer() + " played " + c.toString() + ". "
						+ (GameLogic.getInstance().getCurrentPlayerHand().size() - 1) + " cards remaining.\n"
						+ c.play();
				return message;
			}
		}	
		GameLogic.getInstance().draw(GameLogic.getInstance().getDrawAmount());
		message += "Player " + GameLogic.getInstance().getCurrentPlayer() + " drew "
				+ GameLogic.getInstance().getDrawAmount() + " cards. "
				+ (GameLogic.getInstance().getCurrentPlayerHand().size()) + " cards remaining.";
		GameLogic.getInstance().setDrawAmount(0);
		return message;

	}
}
