package csc439team7.blackjack;

import java.util.logging.Logger;

public class Dealer {

    private static final Logger logger = Logger.getLogger(Dealer.class.getName());

    private static Card faceUpCard;
    private static Card faceDownCard;

    /**
     * Description: Method to deal the first card 'face down'
     * Author: Group 7
     *
     * @version: 1.0
     * @param card
     */
    public void dealFirstCard(Card card) {
        logger.entering(getClass().getName(), "dealFirstCard");

        faceDownCard = card;

        logger.exiting(getClass().getName(), "dealFirstCard");
    }

    /**
     * Description: Method to deal the second card 'face up'
     * Author: Group 7
     *
     * version: 1.0
     * @param card
     */
    public void dealSecondCard(Card card) {
        logger.entering(getClass().getName(), "dealSecondCard");

        faceUpCard = card;

        logger.exiting(getClass().getName(), "dealSecondCard");
    }

    /**
     * Description: Method to add the face up and face down card to hand
     * Author: Group 7
     *
     * version: 1.0
     * @return
     */
    public Hand assessHand() {
        logger.entering(getClass().getName(), "assessHand");

        Hand hand = new Hand();
        hand.addCard(faceUpCard);
        hand.addCard(faceDownCard);

        logger.exiting(getClass().getName(), "assessHand");
        return hand;
    }

}
