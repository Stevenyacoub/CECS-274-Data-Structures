import java.util.EventListener;
import java.util.Scanner;

/** 
 * A guessing game in which a random number from
 * the range of 1-100 is generated and the user must
 * input a positive integer, trying to guess which number
 * was generated.
 * 
 * If any not-positive, non-integer, data is entered, the
 * program will ask the user to guess again
 * 
 * Once the user guesses the generated number, the program
 * will let the user know how many valid guesses it took them
 * to reach the result
 *
 * @author Steven Yacoub 2020
 */
public class CECS274SpringLab1{
    public static void main(String[] args){
        //instance and holder variables
        int answer = (int)(Math.random()*(100) + 1);
        int guessCounter = 0;
        int currentGuess = 0;
        
        System.out.print("I'm thinking of a number. Guess a value (1-100): ");
        
        //the loop that handles all the guessing
        while(currentGuess != answer){
            currentGuess = CheckInput.getIntRange(1, 100);
            guessCounter++;
            if(currentGuess > answer){
                System.out.println("Too High. Guess again:"); 
            }else if(currentGuess == answer){
                System.out.println("Correct! You guessed it in " + guessCounter + " tries.");
            }
            else{
                System.out.println("Too Low. Guess again:");
            }
        } 
    }
}

