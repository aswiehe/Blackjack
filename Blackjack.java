package csc439team7.blackjack;

import java.util.logging.*;

/**
 * Description: Blackjack class to be used later on.
 * Author: Joseph Linneman
 *
 * @version 1
 */
public class Blackjack {

    private static final Logger logger = Logger.getLogger(Blackjack.class.getName());

    /**
     * Description: Main method for Blackjack class
     * Author: Joseph Linneman
     *
     * @version 1
     * @param args Typical String array for JVM to find main
     */
    public static void main(String[] args) {
        /* getClass() cannot be referenced from a static context
        logger.entering(getClass().getName(), "main");
         */
        // LOG CLASS DEPRECATED // Log.writeLog("\n\n\n{{{  STARTING MAIN METHOD  }}}\n\n\n");
        View.CLIView view = new View.CLIView();
        Controller controller = new Controller(view);
        controller.playBlackJack();
        // LOG CLASS DEPRECATED // Log.writeLog("\n\n\n{{{  ENDING OF MAIN METHOD  }}}\n\n\n");
        // LOG CLASS DEPRECATED // Log.printLog();

        /* getClass() cannot be referenced from a static context
        logger.entering(getClass().getName(), "main");
         */
        System.exit(0);
    }
}

