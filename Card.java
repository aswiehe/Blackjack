package csc439team7.blackjack;

import java.util.logging.*;

/**
 * Description: Playing card object to be used in Blackjack.
 * Author: Joseph Linneman
 *
 * @version 1
 */
public class Card {

    private static final Logger logger = Logger.getLogger(Card.class.getName());

    private char suit;
    private int number;
    /*

     --- WEIGHT CLASS VARIABLE NEEDED ---

     In the future we will need a class variable for the weight of a card. All face cards have a weight of (i.e. are
     worth) ten, though each of their int numbers are different. Similarly, Ace's have only one number (which is 1) but
     they may be have a value of either 1 or 11. Below is a placeholder for this class variable.

     private int weight;

    */

    /**
     * Description: Constructor for the class 'Card'
     * Author: Joseph Linneman
     *
     * @version 1
     * @param mySuit The suit of the card to create
     * @param myNumber The number of the card to create
     */
    public Card(char mySuit, int myNumber){
        logger.entering(getClass().getName(), "Card");

        // Make sure myNumber is in range
        if (myNumber < 1 || myNumber > 13){
            //throw an exception
            throw new IndexOutOfBoundsException();
        }
        else{
            this.number = myNumber;
        }

        // Make sure mySuit is in range
        if (mySuit != 'H' && mySuit != 'D' && mySuit != 'S' && mySuit != 'C'){
            //throw an exception
            throw new IllegalArgumentException();
        }
        else{
            this.suit = mySuit;
        }

        logger.exiting(getClass().getName(), "Card");
    }

    /**
     * Description: return the card's suit
     * Author: Avery Wiehe
     *
     * @version 1
     * @returns Suit of the card (Heart, Diamond, Spade, or Club - represented by char)
     */
    public char getSuit() {
        logger.entering(getClass().getName(), "getSuit");

        logger.exiting(getClass().getName(), "getSuit");
        return this.suit;
    }

    /**
     * Description: return the card's number
     * Author: Avery Wiehe
     *
     * @version 1
     * @returns Number on the card where 1 is Ace, 2 - 10 are normal numbers, 11 is Jack, 12 is Queen, 13 is King
     */
    public int getNumber() {
        logger.entering(getClass().getName(), "getNumber");

        logger.exiting(getClass().getName(), "getNumber");
        return this.number;
    }

}
