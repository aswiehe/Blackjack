package csc439team7.blackjack;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.*;

/**
 * Description: Shoe object to be used in Blackjack.
 * Author: Author: Group 7
 *
 * @version 1
 */
public class Shoe {

    private static final Logger logger = Logger.getLogger(Shoe.class.getName());

    ArrayList<Deck> shoe = new ArrayList<>();

    /**
     * Description: Constructor that takes the number of decks to initially include in the shoe
     * Author: Author: Group 7
     *
     * @version 1
     * @param decksInShoe Number of decks to be included in the Shoe being created
     */
    public Shoe(int decksInShoe) {
        logger.entering(getClass().getName(), "Shoe");

        for(int i = 0; i < decksInShoe; i++) {
            Deck thisDeck = new Deck();
            shoe.add(thisDeck);
        }

        logger.exiting(getClass().getName(), "Shoe");
    }

    /**
     * Description:
     * Author: Author: Group 7
     *
     * @version 1
     * @returns Randomly selected card from a randomly selected deck in the Shoe
     */
    public Card pick() {
        logger.entering(getClass().getName(), "pick");

        // Get a random deck from this shoe
        int shoeSize = this.shoe.size();
        Random rand = new Random();
        int randomDeckIndex = rand.nextInt(shoeSize);
        Deck randomDeck = this.shoe.get(randomDeckIndex);
        Card randomCardFromRandomDeck;
        // Get random card from deck and remove it
        try {
            randomCardFromRandomDeck = randomDeck.pick();
        } catch(IndexOutOfBoundsException e) {
            shoe.remove(randomDeck);
            throw new IndexOutOfBoundsException();
        }

        logger.exiting(getClass().getName(), "pick");
        return randomCardFromRandomDeck;
    }

    /**
     * Description: Method that returns the shoe size
     * Author: Author: Group 7
     *
     * @version 1
     * @returns returns the number of decks in the shoe
     */
    public int numDecks() {
        logger.entering(getClass().getName(), "numDecks");

        logger.exiting(getClass().getName(), "numDecks");
        return shoe.size();
    }

    /**
     * Description: Method to get the number of cards in the shoe
     * Author: Author: Group 7
     *
     * @version 1
     * @returns returns the number of cards in the shoe
     */
    public int numCards() {
        logger.entering(getClass().getName(), "numCards");

        int cardsInShoe = 0;
        for(Deck deck : shoe) {
            cardsInShoe += deck.getSize();
        }

        logger.exiting(getClass().getName(), "numCards");
        return cardsInShoe;
    }

    public int size() {
        logger.entering(getClass().getName(), "size");

        int cardsInShoe = 0;
        for(Deck deck : shoe) {
            cardsInShoe += deck.getSize();
        }

        logger.exiting(getClass().getName(), "size");
        return cardsInShoe;
    }
}
