package logic.card;

import java.util.ArrayList;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public abstract class EffectCard extends BaseCard{
    // TODO Implement here
	public EffectCard(CardColor color, CardSymbol symbol ) {
		super(color,symbol);
	}
	public abstract String performEffect();
	public String play() {
		GameLogic.getInstance().setTopCard(this);
		ArrayList<BaseCard> currentHand = GameLogic.getInstance().getCurrentPlayerHand();
		currentHand.remove(this);
		return this.performEffect();
		
	}
	


}
