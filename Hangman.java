import java.util.Scanner;
import java.util.Arrays;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

            Scanner scan = new Scanner (System.in);
            boolean playAgain;

            do {
            
                String word = randomWord();

                char[] placeholders = new char[word.length()];
                for (int i =0; i < placeholders.length; i++){
                    placeholders[i] = '_';
                }

                int misses = 0;
                char [] missedGuesses = new char[6];
            

                while (misses < 6) {
                    System.out.println(gallows[misses]);

                    System.out.print("Word: ");
                    printPlaceholders(placeholders);
                    System.out.print("\n");

                    System.out.print("Misses: ");
                    printMissedGuesses(missedGuesses);
                    System.out.print("\n\n");

                    System.out.print("Guess: ");
                    //char guess = scan.nextLine().charAt(0);
                    System.out.print("\n");
                    char guess = ' ';  // Initialize with a default value
                    
                    try {
                        String input = scan.nextLine().trim();

                        // Check if the input is valid
                        if (input.isEmpty() || input.length() > 1 || !Character.isLowerCase(input.charAt(0))) {
                            throw new IllegalArgumentException("Invalid input. Please enter a single lowercase letter.");
                        }

                        guess = input.charAt(0);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;  // Continue to the next iteration without processing the invalid input
                    }
                    //char guess = input.charAt(0);

                        // Check for empty input
                        
                        

                    if (checkGuess(word, guess)){
                        updatePlaceholders(word, placeholders, guess);
                    }else{
                        missedGuesses[misses]= guess;
                        misses++;
                    }

                    if(Arrays.equals(placeholders, word.toCharArray())){
                        System.out.print(gallows[misses]);
                        System.out.print("\nWord: ");
                        printPlaceholders(placeholders);
                        System.out.println("\nGood Work!");
                        break;
                    }
                }
                
            

                    if (misses == 6){
                        System.err.print(gallows[6]);
                        System.out.println("\nRIP");
                        System.out.println("\nThe word was: '"+ word+"'");
                    }

            // Ask the user if they want to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scan.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        
    }while (playAgain);

        scan.close();
        System.out.println("Thanks for playing!");
    



}

    

        public static String randomWord(){
            int numWords = words.length;
            double randomDouble = Math.random();
            int randomIndex = (int) (randomDouble * numWords);
            // selecting an word at random from the array by multiplying a random Num (0.0 = 0.99) * length of the array and type casting to int
            return words [randomIndex];
        }

        public static void printPlaceholders(char[] placeholders){
            for (int i = 0; i <placeholders.length; i++){
                System.out.print(" " + placeholders[i]);//sets out the '_' for each char in the word
            }
            System.out.print("\n");
        }

        public static boolean checkGuess(String word, char guess){
            for (int i = 0; i< word.length(); i++){
                if(word.charAt(i) == guess){//compares the guessed letter to the letters in the word and where in the word the letter is
                    return true;
                }
            }
            return false;
        }

        public static void updatePlaceholders(String word, char[] placeholders, char guess) {

            for (int j = 0; j < word.length(); j++) {

                if (word.charAt(j) == guess) {
                    placeholders[j] = guess;//if a guess is correct, remoces '_' with the correct letter
                }
            }
        }

        public static void printMissedGuesses(char[] misses) {
            for (int i = 0; i < misses.length; i++) {
                System.out.print(misses[i]);// counter to add missed guesses from checkGuess()
            }
        }

}





