package csc439team7.blackjack;

import java.util.logging.Logger;

public class Player {

    private static final Logger logger = Logger.getLogger(Player.class.getName());

    private static int numChips = 0;

    /**
     * Description: Method to get the number of chips
     * Author: Group 7
     *
     * version: 1.0
     * @return returns the number of chips
     */
    public int getNumChips() {
        logger.entering(getClass().getName(), "getNumChips");

        logger.exiting(getClass().getName(), "getNumChips");
        return numChips;
    }

    /**
     * Description: Method to set the number of chips
     * Author: Group 7
     *
     * version: 1.0
     * @param additionalChips
     */
    public void setNumChips(int additionalChips) {
        logger.entering(getClass().getName(), "setNumChips");

        numChips = additionalChips;

        logger.exiting(getClass().getName(), "setNumChips");
    }

    /**
     * Description: Method to give the player more chips
     * Author: Group 7
     *
     * version: 1.0
     * @param numAdditionalChips
     * @return returns the new number of chips the player requested
     */
    public boolean givePlayerMoreChips(int numAdditionalChips) {
        logger.entering(getClass().getName(), "givePlayerMoreChips");

        boolean valChangedSuccessfully = false;
        if(numChips + numAdditionalChips >= -2147483648 && numChips + numAdditionalChips <= 2147483647) {
            setNumChips(numChips + numAdditionalChips);
            valChangedSuccessfully = true;
        }

        logger.exiting(getClass().getName(), "givePlayerMoreChips");
        return valChangedSuccessfully;
    }

    /**
     * Description: Method  that will add the card to the players hand
     * Author: Group 7
     *
     * version: 1.0
     * @param card
     */
    public void dealCard(Card card) {
        logger.entering(getClass().getName(), "dealCard");

        Hand hand = new Hand();
        hand.addCard(card);

        logger.exiting(getClass().getName(), "dealCard");
    }



}
