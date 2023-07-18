package test.student;

import logic.card.BaseCard;
import logic.card.ChangeColorCard;
import logic.card.DrawFourCard;
import logic.card.NumberCard;
import logic.card.SkipCard;
import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    ArrayList<BaseCard> hand0;
    ArrayList<BaseCard> hand1;

    NumberCard c1;
    SkipCard c2;
    NumberCard c3;
    ChangeColorCard c4;
    NumberCard c5;
    DrawFourCard c6;

    @BeforeEach
    void setup() {
        c1 = new NumberCard(CardColor.YELLOW, CardSymbol.NINE);
        c2 = new SkipCard(CardColor.YELLOW);
        c3 = new NumberCard(CardColor.RED, CardSymbol.NINE);
        c4 = new ChangeColorCard();
        c5 = new NumberCard(CardColor.GREEN, CardSymbol.ONE);
        c6 = new DrawFourCard();
    }

    @AfterEach
    void tearDown() {
        GameLogic.clearInstance();
    }

    @Test
    void testIsHandPlayableTrue() {
        // TODO Implement here
    	GameLogic gameInstance = GameLogic.getInstance(2);
    	gameInstance.setTopCard(c3);
    	gameInstance.getPlayerHand(0).add(c3);
    	assertTrue(c1.canPlay());

    }

    @Test
    void testIsHandPlayableFalse() {
        // TODO Implement here
    	GameLogic gameInstance = GameLogic.getInstance(2);
    	gameInstance.setTopCard(c5);
    	gameInstance.getPlayerHand(0).add(c2);
    	assertFalse(c1.canPlay());

    }

    @Test
    void testDrawLessThanDeck() {
        // TODO Implement here
    	GameLogic gameInstance = GameLogic.getInstance(1);
    	for (int i=0; i<8; i++)
            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
    	GameLogic.getInstance().draw(6);
    	assertEquals(6, gameInstance.getCurrentPlayerHand().size());
    	


    }

    @Test
    void testDrawMoreThanDeck() {
        // TODO Implement here
    	GameLogic gameInstance = GameLogic.getInstance(1);
    	for (int i=0; i<8; i++)
            gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
    	GameLogic.getInstance().draw(9);
    	assertEquals(8, gameInstance.getCurrentPlayerHand().size());


    }

}
