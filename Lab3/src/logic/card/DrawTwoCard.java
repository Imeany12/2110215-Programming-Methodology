package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

import java.util.ArrayList;

//You CAN modify the first line
public class DrawTwoCard extends EffectCard  {
    // TODO Implement here
	public DrawTwoCard(CardColor color) {
		super(color ,CardSymbol.DRAW_TWO);
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
		GameLogic.getInstance().incrementDrawAmount(2);
		GameLogic.getInstance().goToNextPlayer();
		String message = "";
		while(GameLogic.getInstance().getCurrentPlayerHand().isEmpty()) {
			GameLogic.getInstance().goToNextPlayer();	
		}
		
		for (BaseCard c : GameLogic.getInstance().getCurrentPlayerHand()) {
			if (c.getSymbol().equals(CardSymbol.DRAW_FOUR)||c.getSymbol().equals(CardSymbol.DRAW_TWO) ){
				message +="Player " +GameLogic.getInstance().getCurrentPlayer() + " played " +c.toString()+". "+ (GameLogic.getInstance().getCurrentPlayerHand().size() - 1) + " cards remaining.\n"+c.play();
				return message;
			} 
			
		}
		GameLogic.getInstance().draw(GameLogic.getInstance().getDrawAmount());
		message += "Player " +GameLogic.getInstance().getCurrentPlayer() + " drew " +GameLogic.getInstance().getDrawAmount()+" cards. "+ (GameLogic.getInstance().getCurrentPlayerHand().size()) + " cards remaining.";
		GameLogic.getInstance().setDrawAmount(0);
		return message;
		

//		
		
		
	}


}
