package csc439team7.blackjack;

/**
 * Description: StoryLog class to be used for logging interaction between user and computer, and documenting when certain events transpire. This class is solely for easier code tracing.
 * Author: Joseph Linneman
 *
 * @version 1
 */
public class DeprecatedLog {

    private static String log = "VO stands for 'View Output' and VI stands for 'View Input'. The former indicates what is printed to the users screen/terminal while the latter indicates what input the user has supplied.\n-----------------------------\n-----------------------------\n-----------------------------\n\n\n";

    public static void outOfScope() {
        System.out.println("Something has transpired that is beyond the scope of this program");
    }

    public static void writeLog(String logMsg) {
        String lineDivider = "\n";
        log = log + lineDivider + logMsg + lineDivider;
    }

    public static void printLog() {
        System.out.println("\n\n\n[BEGIN LOG]\n\n\n" + log + "\n\n\n[END LOG]\n\n\n");
    }

    public static void logExit() {
        System.out.println(log);
        System.exit(0);
    }
}
