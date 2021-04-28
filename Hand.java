package csc439team7.blackjack;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Description: Hand object to be used in Blackjack.
 * Author: Group 7
 *
 * @version 1
 */
public class Hand {

    private static final Logger logger = Logger.getLogger(Hand.class.getName());

    /*

        --- BETTER NAMING OF (ArrayList) hand VARIABLE ---

        A better name for this variable would probably be "cards". Otherwise it sounds like the class has a class variable
        of an instance of itself. When refactoring, be sure that updates are made not only to references in the code but
        also the javadocs

    * */
    ArrayList<Card> hand = new ArrayList<>();

    /**
     * Description: Constructor for instantiating a Hand object that is holding no cards
     * Author: Group 7
     *
     * @version 1
     */
    public Hand() {
        logger.entering(getClass().getName(), "Hand");

        /*

            --- CURRENTLY UNUSED ---

            Currently, this method is only referenced by a @Test in HandTest.java. Typically this would be poor practice
            (defining a namespace without referencing it). However, there are many valid reasons that a hand object may
            need to be created empty (without cards) before cards are added. In a sense, the acceptability of this
            (constructor) method existing without actually being referenced is because the overall goal of the program
            will be to simulate a game of blackjack, which (in a real-world non-simulated version) would include a
            moment where they do have a hand (considering they are at the table) but do not have any cards (for example
            when the dealer has yet to give them their first card). So in a sense, this method is a stub, until the time
            at which this simulated card game comes close enough to simulating an actual card game to be actually be
            considered realistic.

         */

        logger.exiting(getClass().getName(), "Hand");
    }

    /**
     * Description: Han
     * Author: Group 7
     *
     * @version 1
     * @param cards ArrayList of multiple Card objects that will make up the class variable (currently) defined as "hand"
     */
    public Hand(ArrayList<Card> cards) {
        logger.entering(getClass().getName(), "Hand");

        hand.addAll(cards);

        logger.exiting(getClass().getName(), "Hand");
    }

    /**
     * Description: Adds card to the player's hand
     * Author: Group 7
     *
     * @version 1
     * @param
     * @returns returns true if card was successfully added to hand, and false if it failed to be added
     */
    public boolean addCard(Card newCard) {
        logger.entering(getClass().getName(), "addCard");

        boolean cardAddedSuccessfully = hand.add(newCard);
        // return whether or not card was added successfully, similarly to how the add function itself returns when used for generic ArrayLists

        logger.exiting(getClass().getName(), "addCard");
        return cardAddedSuccessfully;
    }

    /**
     * Description: Returns an ArrayList of all the cards in the player's hand
     * Author: Group 7
     *
     * @version 1
     * @returns ArrayList of cards in players
     */
    public ArrayList getCards() {
        logger.entering(getClass().getName(), "getCards");

        logger.exiting(getClass().getName(), "getCards");
        return this.hand;
    }

    /**
     * Description: Returns the number of cards in a player's hand
     * Author: Group 7
     *
     * @version 1
     * @returns Total number of cards in a player's hand
     */
    public int handSize() {
        logger.entering(getClass().getName(), "handSize");

        // Small will need to be made if this class extends ArrayList since the ArrayList class already has a size method
        int size = hand.size();

        logger.exiting(getClass().getName(), "handSize");
        return size;
    }

}
