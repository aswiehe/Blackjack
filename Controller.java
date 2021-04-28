package csc439team7.blackjack;

import java.util.logging.Logger;

public class Controller {

    private static final Logger logger = Logger.getLogger(Controller.class.getName());

    private static View view;
    private static Player player;
    private static Dealer dealer;

    /**
     * Description: Constructor for cli view
     * Author: Group 7
     *
     * version: 1.0
     * @param cliView
     */
    public Controller(View.CLIView cliView) {
        logger.entering(getClass().getName(), "Controller");

        view = cliView;
        player = new Player();
        dealer = new Dealer();

        logger.exiting(getClass().getName(), "Controller");
    }

    /**
     * Description: Constructor for testView
     * Author: Group 7
     *
     * version: 1.0
     * @param testView
     */
    public Controller(View.TestView testView) {
        logger.entering(getClass().getName(), "Controller");

        view = testView;
        player = new Player();
        dealer = new Dealer();

        logger.exiting(getClass().getName(), "Controller");
    }

    /**
     * Description: Method that plays the Blackjack game
     * Author: Group 7
     *
     * version: 1.0
     */
    public void playBlackJack() {
        logger.entering(getClass().getName(), "playBlackJack");

        // LOG CLASS DEPRECATED // Log.writeLog("Player has arrived at the CSino (get it???)");
        int chipsPurchasedByPlayer = playerBuysChips();
        player.givePlayerMoreChips(chipsPurchasedByPlayer);

        // LOG CLASS DEPRECATED // Log.writeLog("Player has sat down at the blackjack table");
        while(player.getNumChips() > 0) {
            playRound();
        }

        logger.exiting(getClass().getName(), "playBlackJack");
    }

    /**
     * Description: Method to play a  round of Blackjack
     * Author: Group 7
     *
     * version: 1.0
     */
    public void playRound() {
        logger.entering(getClass().getName(), "playRound");

        // Currently unused, but will be used when we start implementing functionality to increase or decrease chips after rounds
        int playersBet = playerBets();

        // "Shuffle" deck by creating a new one
        Deck deck = new Deck();

        // Need to make sure this is actually how dealing works in a real world game of blackjack
        dealer.dealFirstCard(deck.pick());
        player.dealCard(deck.pick());
        dealer.dealSecondCard(deck.pick());
        player.dealCard(deck.pick());


        /* NOTE ABOUT (PLANNED) INFINITE LOOP OF THIS function
            Later, starting at this line in the code's execution, we will actually play rest of the
            game which will include the player's hand being assessed and he actually has the chance
            to lose money.

            It is at that point the function that called this one can reassess the players number of
            chips with there actually being the possibility that they have run out of chips. Without
            that possibility, this will loop forever, because the player is allowed the chance to play
            a round as long as they have coins to bet.

            Since the scope of this assignment is just to deal the cards, we could just call System.exit(0);
            to stop the program. However, we will not do that so that we continue to demonstrate that
            the player can keep playing rounds and also that they can enter 'quit' to quit.
         */

        // Uncomment the line below to have game stop after one round
        // System.exit(0);

        logger.exiting(getClass().getName(), "playRound");
    }

    /**
     * Description: Method to add get the player bets for the round of Blackjack
     * Author: Group 7
     *
     * version: 1.0
     * @return returns the acceptable bet for the round of Blackjack
     */
    public int playerBets() {
        logger.entering(getClass().getName(), "playerBets");

        String betOffered = "";
        int betAcceptable = 0;
        do {
            betOffered = scanResponse(view.promptForBet());
            try {
                betAcceptable = Integer.parseInt(betOffered);
            } catch(NumberFormatException e) {
                // LOG CLASS DEPRECATED // Log.writeLog("Number format error from players response");
                betOffered = "0";
            }
        } while(!validatePositiveDigitInput(betOffered) && !validateInBetRange(betOffered));
        view.confirmChipsBet(betAcceptable);
        // LOG CLASS DEPRECATED // Log.writeLog("Player bets " + betAcceptable + " chips");

        logger.exiting(getClass().getName(), "playerBets");
        return betAcceptable;
    }

    /**
     * Description: Method  to have the player buy chips before the round starts
     * Author: Group 7
     *
     * version: 1.0
     * @return returns the number of chips the player purchased
     */
    public int playerBuysChips() {
        logger.entering(getClass().getName(), "playerBuysChips");

        String chipsRequested = "";
        int numberChipsPurchased = 0;
        do {
            chipsRequested = scanResponse(view.promptForChipsRequested());
            try {
                numberChipsPurchased = Integer.parseInt(chipsRequested);
            } catch(NumberFormatException e) {
                // LOG CLASS DEPRECATED // Log.writeLog("Number format error from players response");
                chipsRequested = "0";
            }
        } while(!validatePositiveDigitInput(chipsRequested));
        view.confirmChipsPurchased(numberChipsPurchased);
        // LOG CLASS DEPRECATED // Log.writeLog("Player purchased " + numberChipsPurchased + " chips");

        logger.exiting(getClass().getName(), "playerBuysChips");
        return numberChipsPurchased;
    }

    /**
     * Description: Validates that the input the player inputs is a digit greater than 0
     * Author: Group 7
     *
     * version: 1.0
     * @param input
     * @return returns the validated input that the user inputed
     */
    public boolean validatePositiveDigitInput(String input) {
        logger.entering(getClass().getName(), "validatePositiveDigitInput");

        boolean isPositiveDigit = true;
        for(int i = 0; i < input.length(); i++) {
            char thisChar = input.charAt(i);
            if(!Character.isDigit(thisChar)) {
                isPositiveDigit = false;
                // LOG CLASS DEPRECATED // Log.writeLog(input + " rejected as purchasable amount of coins because it contains the character [ " + input.charAt(i) + " ] which is not a digit (only digits allowed in input string, and the input as an integer must be positive, so no (-) sign)");
                break;
            }
            else {
                if(Integer.parseInt(input) == 0) {
                    // LOG CLASS DEPRECATED // Log.writeLog(input + " rejected as purchasable amount of coins because it is either outside of range or is equal to zero (neither amounts are amounts player can purchase)");
                    isPositiveDigit = false;
                    break;
                }
            }
        }

        logger.exiting(getClass().getName(), "validatePositiveDigitInput");
        return isPositiveDigit;
    }

    /**
     * Description: Validates whether the user input a valid bet range for the round
     * Author: Group 7
     *
     * version: 1.0
     * @param input
     * @return returns the validated bet that the user inputed
     */
    public boolean validateInBetRange(String input) {
        logger.entering(getClass().getName(), "validateInBetRange");

        boolean isInBetRange = true;
        for(int i = 0; i < input.length(); i++) {
            char thisChar = input.charAt(i);
            if(!Character.isDigit(thisChar)) {
                isInBetRange = false;
                // LOG CLASS DEPRECATED // Log.writeLog(input + " rejected as amount of coins that can be bet because it contains the character [ " + input.charAt(i) + " ] which is not a digit (only digits allowed in input string, and the input as an integer must be positive, so no (-) sign)");
                break;
            }
            else {
                if(Integer.parseInt(input) < 10 || Integer.parseInt(input) > 500) {
                    // LOG CLASS DEPRECATED // Log.writeLog(input + " rejected as amount of coins that can be bet because it falls outside of the range 10 and 500");
                    isInBetRange = false;
                    break;
                }
            }
        }

        logger.exiting(getClass().getName(), "validateInBetRange");
        return isInBetRange;
    }

    /**
     * Description: Checks to see if the user wants to quit the game
     * Author: Group 7
     *
     * version: 1.0
     * @param response
     * @return returns the response that the user input 'quit' will exit the game
     */
    public String scanResponse(String response) {
        logger.entering(getClass().getName(), "scanResponse");

        if(response.equals("quit")) {
            quitGame();
        }

        logger.exiting(getClass().getName(), "scanResponse");
        return response;
    }

    /**
     * Description: Method the output a goodbye message and to quit the game for the user
     * Author: Group 7
     *
     * version: 1.0
     */
    public void quitGame() {
        logger.entering(getClass().getName(), "quitGame");

        view.printLine("Leaving game and exiting program. Thanks for playing!");
        // LOG CLASS DEPRECATED // Log.writeLog("User requested to exit game by entering 'quit' in CLI");
        // LOG CLASS DEPRECATED // Log.printLog();

        logger.exiting(getClass().getName(), "quitGame");
        System.exit(0);
    }


}
