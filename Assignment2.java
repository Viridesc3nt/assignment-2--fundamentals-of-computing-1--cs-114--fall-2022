import java.util.*;

/*
 * NOTE:
 * I'm logical enough to know how terrible this code is, but in the end it get's the job done.
 * I will very likely look back at this code in the distant future, and future me, I apologize
 * for being a very sub-optimal programmer/algorithmic thinker at this point in time, and I hope you
 * are at the stage in your programming career where you are able to fix this junk.
 * Sincerely - past you
 */


public class Assignment2 {
    static int inputNumber;
    static Scanner input = new Scanner(System.in);
    static boolean isEven;
    static boolean isOdd;
    static int middleNumber;
    static int spaces;
    static String color;
    static String characterForDiamond;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001b[0m";


    public static void calculateSpaces(int number) {
        if(isOdd) {
            if(number <= 3 || number <= 5 || number <= 7) {
                spaces = (number / 2);
            }
            if(number > 7) {
                spaces = (number/8);
            }
            for(int i=0; i < spaces; i++) {
                System.out.print("\t");
            }
        }

        if(isEven) {
            if(number <= 2 || number <= 4 || number <= 6) {
                spaces = (number / 2);
            }
            if(number > 8) {
                spaces = (number/4);
            }
            for(int i=0; i < spaces; i+=2) {
                System.out.print("\t");
            }
        }
    }

    public static void calculateBackspaces(int number) {
        if(isOdd) {
            for(int i = 0; i < number; i+=2) {
                System.out.print("\b");
             }
        }

        if(isEven) {
            for(int i = 0; i < number; i+=1) {
                System.out.print("\b");
             }
        }
    }

    public static void printAsterisks(int numOfAsterisks) {
        if(isOdd) {
            for(int i = 0; i < numOfAsterisks; i++) {
                if(color != null) {
                    System.out.print(color + characterForDiamond);
                } else {
                    System.out.print(characterForDiamond);
                }
            }
        }

        if(isEven) {
            for(int i = 0; i < numOfAsterisks; i++) {
                if(color != null) {
                    System.out.print(color + characterForDiamond + " ");
                } else {
                    System.out.print(characterForDiamond + " ");
            }
        }
    }
}

    public static void evenDiamond(int inputNumber) {
        middleNumber = inputNumber;
        calculateSpaces(middleNumber);
        System.out.print(" " + color + characterForDiamond);
        for(int numAsterisks = 0; numAsterisks < middleNumber + 2; numAsterisks+=2) {
            calculateSpaces(middleNumber + 1);
            calculateBackspaces(numAsterisks - 2);
            printAsterisks(numAsterisks);
            System.out.println();
        }

        for(int numAsterisks = middleNumber - 2; numAsterisks > 0; numAsterisks-=2) {
            calculateSpaces(middleNumber+ 1);
            calculateBackspaces(numAsterisks - 2);
            printAsterisks(numAsterisks);
            System.out.println();

        }
        calculateSpaces(middleNumber);
        System.out.print(" " + color + characterForDiamond);

    }

    public static void oddDiamond(int inputNumber) {
        middleNumber = inputNumber;

        for(int numAsterisks = 1; numAsterisks < middleNumber + 2; numAsterisks+=2) {
            calculateSpaces(middleNumber);
            calculateBackspaces(numAsterisks - 2);
            printAsterisks(numAsterisks);
            System.out.println();
        }

        for(int numAsterisks = middleNumber - 2; numAsterisks > 0; numAsterisks-=2) {
            calculateSpaces(middleNumber);
            calculateBackspaces(numAsterisks - 2);
            printAsterisks(numAsterisks);
            System.out.println();

        }
    }

    public static void main(String args[]) {
        System.out.println("Please enter a number: ");
        int number = input.nextInt();
        System.out.println("Would you like your Diamond to have a color? (Red, Green, Blue, White, Black, None)");
        System.out.println("^ This will work for Mac/Linux users ONLY!");
        String colorInput = input.next();
        System.out.println("Please input the character you'd like to use for your Diamond (Ex: +, *, -, 1, e): ");
        characterForDiamond = input.next();

        switch(colorInput) {
            case "Red":
                color = ANSI_RED;
                break;
            case "Blue":
                color = ANSI_BLUE;
                break;
            case "Black":
                color = ANSI_BLACK;
                break;
            case "White":
                color = ANSI_WHITE;
                break;
            case "Green":
                color = ANSI_GREEN;
                break;
            case "None":
                color = null;
                break;
            default:
                System.out.println("Color not recognized, generating anyways...");
                color = null;
                break;
        }

        if(number % 2 == 0) {
            calculateSpaces(number);
            isEven = true;
            System.out.println("Generating an even Diamond...");
            evenDiamond(number);
        } else if(number % 2 == 1) {
            isOdd = true;
            System.out.println("Generating an odd Diamond...");
            oddDiamond(number);
        }
    }
}
