// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW1-JavaIntro
// Resources Used:

import java.util.Random;

public class JavaIntro {

    public static void main(String[] args) {

    }

    public static int hilo(int max, int target) {
        int trials = 0;
        int highGuess = max;
        int lowGuess = 1;
        int guess = 0;


        Random random = new Random();
        while (guess != target) {
            trials++;

            guess = random.nextInt(highGuess - lowGuess + 1) + lowGuess;
            if (guess > target) {
                highGuess = guess - 1;
            }
            if (guess < target) {
                lowGuess = guess + 1;
            }


        }
        return trials;

    }


    public static int rpsls(String userChoice, String computerChoice) {

        int result = 0;

        String lowerUserChoice = userChoice.toLowerCase();
        String lowerComputerChoice = computerChoice.toLowerCase();

        if (lowerUserChoice.equals(lowerComputerChoice)) {
            result = -1;
        } else if (lowerUserChoice.equals("scissors")) {
            if (lowerComputerChoice.equals("paper") || lowerComputerChoice.equals("lizard")) {
                result = 1;
            } else {
                result = 0;
            }

        } else if (lowerUserChoice.equals("paper")) {
            if (lowerComputerChoice.equals("rock") || lowerComputerChoice.equals("spock")) {
                result = 1;
            } else {
                result = 0;
            }

        } else if (lowerUserChoice.equals("rock")) {
            if (lowerComputerChoice.equals("lizard") || lowerComputerChoice.equals("scissors")) {
                result = 1;
            } else {
                result = 0;
            }

        } else if (lowerUserChoice.equals("lizard")) {
            if (lowerComputerChoice.equals("spock") || lowerComputerChoice.equals("paper")) {
                result = 1;
            } else {
                result = 0;
            }

        } else if (lowerUserChoice.equals("spock")) {
            if (lowerComputerChoice.equals("scissors") || lowerComputerChoice.equals("rock")) {
                result = 1;
            } else {
                result = 0;
            }

        }
        return result;
    }


    public static String fuzzbizz(int one, int two, int input) {
        String result = "none";

        if (input % one == 0 && input % two == 0) {
            result = "fuzzbizz";
        } else if (input % one == 0) {
            result = "fuzz";
        } else if (input % two == 0) {
            result = "bizz";
        }

        return result;
    }

    public static int countRuns(int[] numbers) {
        int count = 0;
        boolean inRun = false;

        for (int i = 1; i < numbers.length; i++) {
            if (!inRun && numbers[i] == numbers[i - 1]) {
                inRun = true;
                count++;
            }
            if (inRun && numbers[i] != numbers[i - 1]) {
                inRun = false;
            }

        }
        return count;


    }


}