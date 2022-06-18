//import java.util.Scanner; // Imports the scanner class which was the first option I had.
import java.io.Console; // Console worked better for this project.
class Game {
    //The start and the finish of the whole program. 
    public static void main(String args[]) {
        generateSpace(1);
        intro();
        generateSpace(0);              
        Boolean result = true;
        //Will start the loop till player is ready to stop playing with the computer.
        while (result == true){
            result = getPlayerAnswer();
            generateSpace(1);
            //If player said no to end the program
            if (result == false) {
                break;
            }
            computerConversation(0);
            int tries = computerGuessing();
            System.out.println("I knew I would get it right. It only took me " + tries + " tries.");
            System.out.println("Would you like to play once more Player?");
            generateSpace(0);
            
        }
        computerConversation(1);
        System.exit(0);
    }
    //Also start with a intro, its nice to know whats going on. 
    public static void intro() {
        //The things that starts the moment the player starts up the program.
        String[] computerIntro = { 
            "Hello Player!",
            "Welcome to my game!",
            "Its going to be a bit different than what you are used to.",
            "Instead of you guessing, I'll be the one guessing this time.",
            "You will pick a number between 1 to 100",
            "You ready to play?"
        };
        //Time to start the conversation
        for (int i = 0; i < computerIntro.length ; i++){
            System.out.println(computerIntro[i]);
        }
    }
    //Called always to get the players yes or no answer. 
    public static Boolean getPlayerAnswer() {
        //Scanner answer = new Scanner(System.in); I tried to use this and had a few problems. 
        Console answer = System.console(); // Worked so I went with it. 
        String yesOrno = answer.readLine();
        boolean playing = false;
        yesOrno = yesOrno.toUpperCase();
        while (!yesOrno.equals("YES") && !yesOrno.equals("NO")) {
            generateSpace(1);
            System.out.println("I don't understand that input, please try again with a yes or no.");
            generateSpace(0);
            yesOrno = answer.readLine();
            yesOrno = yesOrno.toUpperCase();
        }
        if (yesOrno.equals("YES")) {
            playing = true;
        }
        return playing;
    }
    //Used to continue the conversation elsewhere than main. 
    public static void computerConversation(int entered) {
        //I really thought this would have been bigger but its alright. 
        int conversation = entered;
        String[] computerGame = {
            //Starting the game remark
            "Wonderful, I can't wait to guess your number right!",
            "Let's get to the guessing!",
            //The exit remark
            "Oh darn, I guess I will wait till you are ready then. Till next time Player"
        };
        if (entered == 0) {
            conversation = 0;
            System.out.println(computerGame[conversation]);
            conversation += 1;
            System.out.println(computerGame[conversation]);
        }
        if (entered == 1) {
            conversation = 2;
            System.out.println(computerGame[conversation]);;
        }
    }
    //This is where the computer will try to make a guess or guesses.
    public static int computerGuessing() {
        boolean computerRight = false;
        int guesses = 1;
        int max = 101;
        int min = 1;
        int computerGuess;
        //Will keep looping till the computer is right. 
        while (computerRight == false) {
            //I found this online and was able to understand it a bit more. 
            computerGuess = (int)((Math.random() * (max - min) + min));
            System.out.println("My " + guessString(guesses) + " guess is going to be the number...");
            System.out.println("+----------> " + computerGuess + " <----------+ ");
            System.out.println("Was I correct?");
            generateSpace(0);
            computerRight = getPlayerAnswer();
            if (computerRight == false) {
                guesses++;
                generateSpace(1);
                System.out.println("Alright, was I to high or too low?");
                generateSpace(0);
                Boolean highOrLow = computerTestElevation();
                if (highOrLow == true) {
                    //Changing the max to not display this number anymore
                    max = computerGuess;
                }
                if (highOrLow == false) {
                    //Changing the min to not go any lower than this number plus one.
                    min = computerGuess + 1;
                }
            }
            generateSpace(1);
        }
        return guesses;
    }
    //To go with the theme of all guessing games, a high and low feature. 
    //To check from player if their number is higher or lower. 
    public static boolean computerTestElevation() {
        boolean elevation = false;
        Console answer = System.console();
        String highLow = answer.readLine();
        highLow = highLow.toUpperCase();
        while (!highLow.equals("HIGH") && !highLow.equals("LOW")) {
            generateSpace(1);
            System.out.println("I don't understand that input, please try again with high or low.");
            generateSpace(0);
            highLow = answer.readLine();
            highLow = highLow.toUpperCase();
        }
        if (highLow.equals("HIGH")) {
            elevation = true;
        }
        return elevation;
    }
    //A place to break up player turn and computer turn.
    public static void generateSpace(int x) {
        //int chooseLine = (int)(Math.random() * 3);
        int chooseLine = x;
        String line;
        switch(chooseLine) {
            case 0: line = "+-------------------------------------------------->Player's Turn+";
                    break;
            case 1: line = "+------------------------------------------------>Computer's Turn+";
                    break;
            default: line = "";
        }
        System.out.println(line);
    }
    //To change a number variable to the number of guesses.
    public static String guessString(int x) {
        String word;
        switch (x) {
            case 1: word = "first";
                    break;
            case 2: word = "second";
                    break;
            case 3: word = "third";
                    break;
            case 4: word = "fourth";
                    break;
            case 5: word = "fifth";
                    break;
            case 6: word = "sixth";
                    break;
            case 7: word = "seventh";
                    break;
            case 8: word = "eighth";
                    break;
            case 9: word = "nineth";
                    break;
            case 10: word = "tenth";
                    break;
            case 11: word = "eleventh";
                    break;
            case 12: word = "twelveth";
                    break;
            case 13: word = "thirteenth";
                    break;
            case 14: word = "fourteenth";
                    break;
            case 15: word = "fifteenth";
                    break;
            default: word = "maybe last";
        }
        return word;
    }
    //Used code till newer needed still might be helpful later. Its good to never delete code
    /*
    //To generate a new number if the other one matched
    public static int getANewNumber() {
        int newNumber = (int)(Math.random() * 11);
        return newNumber;
    }
    //int[] guesses = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int randomNum = (int)(Math.random() * 11);
            numbers[i] = randomNum;
        }
            int computerGuess = numbers[guess];
            
        System.out.println("My first guess is going to be the number " + numberToWords(first));
        System.out.println("Was I correct?");
        computerRight = getPlayerAnswer();
        if (computerRight == false) {
            System.out.println("Alright, calculating my next guess.");
            System.out.println("My second guess is going to be the number " + numberToWords(second));
            System.out.println("Was I correct?");
            computerRight = getPlayerAnswer();
        }
        if (computerRight == false) {
            System.out.println("Alright, calculating my next guess.");
            System.out.println("My third guess is going to be the number " + numberToWords(third));
            System.out.println("Was I correct?");
            computerRight = getPlayerAnswer();
            int randomNum = 0;
        int first = 0;
        int second = 0;
        while (computerRight == false && guess < 3) {
            if (guess == 0) {
                randomNum = getANewNumber();
                numbers[guess] = randomNum;
                first = randomNum;
            }
            if (guess == 1) {
                if (numbers[0] == randomNum){
                    while (!isADifferentNumber) {
                        randomNum = getANewNumber();
                        if (numbers[0] != randomNum) {
                            numbers[guess] = randomNum;
                            isADifferentNumber = true;
                        }
                    }
                }
            }
            if (guess == 2) {
                while (!isADifferentNumber) {
                    if (numbers[0] == randomNum || numbers[1] == randomNum) {
                        System.out.println("$" + randomNum + "$");
                        randomNum = getANewNumber();
                        if (numbers[0] != randomNum && numbers[1] != randomNum) {
                            numbers[guess] = randomNum;
                            isADifferentNumber = true;
                        }
                    }
                }
            }
            //To change a number variable to a string variable
    public static String numberToWords(int x) {
        String word;
        switch (x) {
            case 0: word = "zero";
                    break;
            case 1: word = "one";
                    break;
            case 2: word = "two";
                    break;
            case 3: word = "three";
                    break;
            case 4: word = "four";
                    break;
            case 5: word = "five";
                    break;
            case 6: word = "six";
                    break;
            case 7: word = "seven";
                    break;
            case 8: word = "eight";
                    break;
            case 9: word = "nine";
                    break;
            default: word = "Not a number?";
        }
        return word;
    }
        }
    */
}