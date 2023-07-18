package logic.card;

import logic.game.CardSymbol;

import java.util.ArrayList;

import logic.game.CardColor;
import logic.game.GameLogic;

//You CAN modify the first line
public class NumberCard extends BaseCard{
    // TODO Implement here
	public NumberCard(CardColor color,CardSymbol symbol) {
		super(color,symbol);
		
	}
	public String toString(){
		return this.getColor() +" "+ this.getSymbol();
	}
	public boolean canPlay() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		if (this.getColor().equals(topCard.getColor())||this.getSymbol().equals(topCard.getSymbol())) {
			return true;
		}else {
			return false;
		}
		
	}
	public String play() {
		GameLogic.getInstance().setTopCard(this);
		ArrayList<BaseCard> currentHand = GameLogic.getInstance().getCurrentPlayerHand();
		currentHand.remove(this);
		return null;
		
	}
	
	


}
