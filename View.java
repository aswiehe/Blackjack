package csc439team7.blackjack;

import org.junit.Test;

import java.util.Scanner;

public abstract class View {

    protected abstract void printLine(String msg);
    protected abstract String readLine(Scanner input);
    protected abstract String promptForChipsRequested();
    protected abstract void confirmChipsPurchased(int chipsPurchased);
    protected abstract void confirmChipsBet(int chipsBet);
    protected abstract String promptForBet();
    /* Was in last submission but does program does not compile without being defined in CLIView class
    protected abstract void showTableToUser();
     */

    public static class CLIView extends View {
        /**
         * Description: Method that prints various outputs to the user
         * Author: Group 7
         *
         * version: 1.0
         * @param output
         */
        @Override
        public void printLine(String output) {
            // LOG CLASS DEPRECATED // Log.writeLog("VO: " + output);
            System.out.println(output);
        }

        /**
         * Description: Method to read various outputs from the user
         * Author: Group 7
         *
         * version: 1.0
         * @param input
         * @return
         */
        @Override
        public String readLine(Scanner input) {
            String response = input.nextLine();
            // LOG CLASS DEPRECATED // Log.writeLog("VI: " + response);
            return response;
        }

        /**
         * Description: Method to prompt the user for chips
         * Author: Group 7
         *
         * version: 1.0
         * @return
         */
        @Override
        public String promptForChipsRequested() {
            printLine("Enter number between 1 and 2147483647 for the number chips of chips to purchase - enter digits only (no letters or special characters): ");
            Scanner input = new Scanner(System.in);
            String chipsRequested = readLine(input);
            return chipsRequested;
        }

        /**
         * Description: Method to confirm the number of chips
         * Author: Group 7
         *
         * version: 1.0
         * @param chipsPurchased
         */
        @Override
        public void confirmChipsPurchased(int chipsPurchased) {
            printLine("You have purchased " + chipsPurchased + " chips!");
        }

        /**
         * Description: Method to prompt the user for bet
         * Author: Group 7
         *
         * version: 1.0
         * @return
         */
        @Override
        public String promptForBet() {
            printLine("Enter the amount you'd like to bet (must be between 10 and 500): ");
            Scanner input = new Scanner(System.in);
            String decidedBet = readLine(input);
            return decidedBet;
        }

        /**
         * Description: Method to confirm the chips bet
         * Author: Group 7
         *
         * version: 1.0
         * @param chipsBet
         */
        @Override
        public void confirmChipsBet(int chipsBet) {
            printLine("You have bet " + chipsBet + " chips!");
        }

    }

    public static class TestView extends View {

        private String simulatedOutput = "I am simulated input";
        private Scanner simulatedInput = new Scanner("I am simulated output");
        private int simulatedChipAmount = 999;


        // Wrap method bodies in try/catch and throw Exception("There was an error in the test");

        /**
         * Description: Method to output the simulated output
         * Author: Group 7
         *
         * version: 1.0
         * @param simulatedOutput
         */
        @Override
        protected void printLine(String simulatedOutput) {
            // LOG CLASS DEPRECATED // writeLog("VO: " + simulatedOutput);
            System.out.println(simulatedOutput);
        }

        /**
         * Description: Method  to read lines from the user
         * Author: Group 7
         *
         * version: 1.0
         * @param simulatedInput
         * @return
         */
        @Override
        protected String readLine(Scanner simulatedInput) {
            String response = simulatedInput.nextLine();
            // LOG CLASS DEPRECATED // Log.writeLog("VI: " + response);
            return response;
        }

        /**
         * Description: Method to promt the user for requested chips
         * Author: Group 7
         *
         * version: 1.0
         * @return
         */
        @Override
        protected String promptForChipsRequested() {
            printLine("Enter number between 1 and 2147483647 for the number chips of chips to purchase - enter digits only (no letters or special characters): ");
            Scanner input = new Scanner("999");
            String chipsRequested = readLine(input);
            return chipsRequested;
        }

        /**
         * Description: Method to confirm the amount of chips purchased
         * Author: Group 7
         *
         * version: 1.0
         * @param simulatedChipAmount
         */
        @Override
        protected void confirmChipsPurchased(int simulatedChipAmount) {
            printLine("You have purchased " + simulatedChipAmount + " chips!");
        }

        /**
         * Description: Method  to confirm chops bet
         * Author: Group 7
         *
         * version: 1.0
         * @param simulatedChipAmount
         */
        @Override
        protected void confirmChipsBet(int simulatedChipAmount) {
            printLine("You have bet " + simulatedChipAmount + " chips!");
        }

        /**
         * Description:
         * Author:
         *
         * version:
         * @return
         */
        @Override
        protected String promptForBet() {
            printLine("Enter the amount you'd like to bet (must be between 10 and 500): ");
            Scanner input = new Scanner("250");
            String decidedBet = readLine(input);
            return decidedBet;
        }

        /**
         * Description:
         * Author:
         *
         * version:
         */
    /* Was in last submission but does program does not compile without being defined in CLIView class
        @Override
        protected void showTableToUser() {

        }

     */
    }

}
