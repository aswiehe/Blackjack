package csc439team7.blackjack;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.*;

/**
 * Description: Deck object to be used in Blackjack.
 * Author: Group 7
 *
 * @version 1
 */
public class Deck {

    private static final Logger logger = Logger.getLogger(Deck.class.getName());

    ArrayList<Card> cards = new ArrayList<>();

    /**
     * Description: Creates a standard playing card deck as an ArrayList of Card objects
     * Author: Group 7
     *
     * @version 1
     */
    public Deck() {
        logger.entering(getClass().getName(), "Deck");

        char[] suits = {'H','D', 'S', 'C'};
        for(char suit : suits) {
            for(int cardNum = 1; cardNum <= 13; cardNum++) {
                Card thisCard = new Card(suit, cardNum);
                this.cards.add(thisCard);
            }
        }

        logger.exiting(getClass().getName(), "Deck");
    }

    /**
     * Description: Chooses and returns a card from the deck at random (and removes that card from deck).
     * Author: Group 7
     *
     * @version 1
     * @return Randomly selected card from the deck
     */
    public Card pick() {
        logger.entering(getClass().getName(), "pick");

        Card randomCard;
        if(this.cards.size() > 0) {
            Random rand = new Random();
            int randomCardIndex = rand.nextInt(cards.size());
            randomCard = this.cards.get(randomCardIndex);
            // Remove the card chosen at random because it has now been "picked" from the deck
            this.cards.remove(randomCardIndex);
        }
        else {
            throw new IndexOutOfBoundsException();
        }

        logger.exiting(getClass().getName(), "pick");
        return randomCard;
    }

    /**
     * Description: Returns the total number of cards left in the deck
     * Author: Group 7
     *
     * @version 1
     * @return Total number of cards remaining in deck
     */
    public int getSize() {
        logger.entering(getClass().getName(), "getSize");

        int deckSize = this.cards.size();

        logger.exiting(getClass().getName(), "getSize");
        return deckSize;
    }


}
