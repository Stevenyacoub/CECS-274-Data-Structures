import java.util.Scanner;
import java.io.*;

/**
 * This program is a basic memory game
 * with four options for what will be
 * behind the cards that the user can choose
 * from, including letters, numbers, 
 * animals, and objects.
 * 
 * @author Steven Yacoub 2020
 */

public class YacoubP1 {
   public static void main(String args[]){
       int remainingMatches = 8;
       boolean[][] facingUp = { {false,false,false,false},{false,false,false,false},{false,false,false,false},{false,false,false,false}};
       String firstChoice = null;
       String secondChoice = null;
    
       System.out.println("Memory Game");
       int selection = getFileChoice();
       String[][] cards = readFile(selection);
       for(int i = 0; i<100; i++){
           shuffle(cards);
       }
       displayBoard(cards,facingUp);
       while(remainingMatches != 0) {
           int choice = getChoice();
           boolean flipped = checkedFlipped(choice,facingUp);
           while(flipped == true){
               System.out.print("Already Flipped. ");
               choice = getChoice();
               System.out.println();
               flipped = checkedFlipped(choice,facingUp);
           }
           flipChoice(choice, facingUp);
           displayBoard(cards, facingUp);
           int choice2 = getChoice();
           flipped = checkedFlipped(choice2,facingUp);
           while(flipped == true){
               System.out.print("Already Flipped. ");
               choice2 = getChoice();
               System.out.println();
               flipped = checkedFlipped(choice2,facingUp);
           }
           flipChoice(choice2, facingUp);
           displayBoard(cards, facingUp);
           for( int i = 0; i<=3; i++) {
               for (int j = 0; j <= 3; j++) {
                   if (choice == (i * 4) + j + 1) {
                       firstChoice = cards[i][j];
                   }
                   if (choice2 == (i * 4) + j + 1) {
                       secondChoice = cards[i][j];
                   }
               }
           }
           boolean match = isMatch(firstChoice, secondChoice);
           if(match == false){
               System.out.println("Not A Match");
               flipChoice(choice, facingUp);
               flipChoice(choice2, facingUp);
               System.out.println();
               displayBoard(cards, facingUp);
           } else{
               remainingMatches--;
           }
       }
       System.out.println("You found all the cards!");
       System.out.println("Play Again? (Y/N) ");
       boolean reply = CheckInput.getYesNo();
       for( int i = 0; i<=3; i++) {
           for (int j = 0; j <= 3; j++) {
            facingUp[i][j] = false;
           }
       }
       remainingMatches = 8;
       while(reply == true){
           selection = getFileChoice();
           cards = readFile(selection);
           for(int i = 0; i<100; i++){
               shuffle(cards);
           }
           displayBoard(cards,facingUp);
           while(remainingMatches != 0) {
               int choice = getChoice();
               boolean flipped = checkedFlipped(choice, facingUp);
               while(flipped == true){
                   System.out.print("Already Flipped. ");
                   choice = getChoice();
                   System.out.println();
                   flipped = checkedFlipped(choice, facingUp);
               }
               flipChoice(choice, facingUp);
               displayBoard(cards, facingUp);
               int choice2 = getChoice();
               flipped = checkedFlipped(choice2, facingUp);
               while(flipped == true){
                   System.out.print("Already Flipped.");
                   choice2 = getChoice();
                   System.out.println();
                   flipped = checkedFlipped(choice2, facingUp);
               }
               flipChoice(choice2, facingUp);
               displayBoard(cards, facingUp);
               for( int i = 0; i<=3; i++) {
                   for (int j = 0; j <= 3; j++) {
                       if (choice == (i * 4) + j + 1) {
                           firstChoice = cards[i][j];
                       }
                       if (choice2 == (i * 4) + j + 1) {
                           secondChoice = cards[i][j];
                       }
                   }
               }
               boolean match = isMatch(firstChoice, secondChoice);
               if(match == false){
                   System.out.println("Not A Match");
                   flipChoice(choice, facingUp);
                   flipChoice(choice2, facingUp);
                   System.out.println();
                   displayBoard(cards, facingUp);
               } else{
                   remainingMatches--;
               }
           }

           System.out.println("You found all the cards!");
           System.out.println("Play Again? (Y/N) ");
           reply = CheckInput.getYesNo();
           for( int i = 0; i<=3; i++) {
               for (int j = 0; j <= 3; j++) {
                   facingUp[i][j] = false;
               }
           }
           remainingMatches = 8;
       }
   }

   /**
    * This function will prompt the user for 
    * a choice in what type of cards they'd
    * like to play with
    * @return fileChoice, the number to be returned
    * representing the user's choice of type
    */
   public static int getFileChoice(){
       System.out.println("1. Letters");
       System.out.println("2. Numbers");
       System.out.println("3. Animals");
       System.out.println("4. Objects");
       System.out.print("Enter a Choice Number: ");
       int fileChoice = CheckInput.getIntRange(1,4);
       return fileChoice;
   }

   /**
    * Scans a text file containing several
    * lines of various data to be used in 
    * the sets of cards
    * @param selection a number correlating to 
    * which file will be scanned
    * @return a 2D String Array of all the
    * data found within the file
    */
   public static String[][] readFile(int selection){
       String[][] cards = new String [4][4];
       try {
           switch(selection){
               case(1):
                    Scanner letterReader = new Scanner( new File("letters.txt")); 
                    while(letterReader.hasNext()){
                        for( int i = 0; i<=1; i++){
                            for( int j = 0; j<=3; j++){
                                String line = letterReader.nextLine();

                                cards[i][j]= line;
                                cards[i+2][j]= line;
                             }
                       }

                    }
                    letterReader.close();
               break;
               
               case(2):
                    Scanner numberReader = new Scanner( new File("numbers.txt"));
                    while(numberReader.hasNext()){
                        for( int i = 0; i<=1; i++){
                           for( int j = 0; j<=3; j++){
                               String line = numberReader.nextLine();
                               cards[i][j]= line;
                               cards[i+2][j]= line;
                           }
                        }
                    }
                    numberReader.close();
               break;

               case(3):
                    Scanner animalReader = new Scanner( new File("animals.txt")); 
                    while(animalReader.hasNext()){
                        for( int i = 0; i<=1; i++){
                            for( int j = 0; j<=3; j++){
                                String line = animalReader.nextLine();
                                cards[i][j]= line;
                                cards[i+2][j]= line;
                            }
                        }
                    }
                    animalReader.close();
               break;

               case(4):
                   Scanner objectReader = new Scanner( new File("objects.txt") );
                   while(objectReader.hasNext()){
                       for( int i = 0; i<=1; i++){
                           for( int j = 0; j<=3; j++){
                               String line = objectReader.nextLine();
                               cards[i][j]= line;
                               cards[i+2][j]= line;
                            }
                        }
                    }
                    objectReader.close();
               break;
           }
       }catch(FileNotFoundException f){
           System.out.println("File Not Found");
       }

       return cards;
   }

   /**
    * A function that randomly generates 
    * 4 indexes and uses those to swap two
    * cards' positions
    * @param cards a 2D array of cards of 
    * which 2 cards will have their positions
    * swapped
    */
   public static void shuffle(String[][] cards){
       int i1 = (int)(Math.random()*10);
       int i2 = (int)(Math.random()*10);
       int i3 = (int)(Math.random()*10);
       int i4 = (int)(Math.random()*10);
       while(i1 > 3){
           i1 = (int)(Math.random()*10);
       }
       while(i2 > 3){
           i2 = (int)(Math.random()*10);
       }
       while(i3 > 3){
           i3 = (int)(Math.random()*10);
       }
       while(i4 > 3){
           i4 = (int)(Math.random()*10);
       }

       String tempCard = cards[i1][i2];
       cards[i1][i2] = cards[i3][i4];
       cards[i3][i4] = tempCard;
   }

   /**
    * This is the function that displays all 
    * of the cards so the user can more easily
    * play the game. It also handles whether the
    * selected cards are facing up, facing down, and
    * how to display them accordingly
    * @param cards is the 2D array of values which each
    * respective card represents
    * @param facingUp is the 2D array which keeps track
    * of whether each card at that correlating location
    * is facing up or not 
    */
   public static void displayBoard(String[][] cards, boolean[][] facingUp){
       String[][] faceDown = { {"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
       //row 1
       System.out.println("+------+   +------+   +------+   +------+");
       System.out.println("|      |   |      |   |      |   |      |");
       for(int i = 0; i<3; i++) {
           if(facingUp[0][i] == true) {
               switch(cards[0][i].length()){
                   case(1):
                       System.out.print("|  " + cards[0][i] + "   |   ");
                   break;
                   case(2):
                       System.out.print("|  " + cards[0][i] + "  |   ");
                   break;
                   case(3):
                       System.out.print("|  " + cards[0][i] + " |   ");
                   break;
                   case(4):
                       System.out.print("| " + cards[0][i] + " |   ");
                   break;
               }
           } else{
               if (faceDown[0][i].length() == 1) {
                   System.out.print("|  " + faceDown[0][i] + "   |   ");
               }
               else if (faceDown[0][i].length() == 2) {
                   System.out.print("|  " + faceDown[0][i] + "  |   ");
               }
           }
       }

       //row 1 column 4
       if(facingUp[0][3] == true) {
           switch(cards[0][3].length()){
               case(1):
                   System.out.println("|  " + cards[0][3] + "   |   ");
               case(2):
                   System.out.println("|  " + cards[0][3] + "  |   ");
               case(3):
                   System.out.println("|  " + cards[0][3] + " |   ");
               case(4):
                   System.out.println("| " + cards[0][3] + " |   ");
           }
       } else{
           System.out.println("|  " + faceDown[0][3] + "   |   ");
       }

       System.out.println("|      |   |      |   |      |   |      |");
       System.out.println("+------+   +------+   + -----+   +------+");

       //row 2
       System.out.println("+------+   +------+   +------+   +------+");
       System.out.println("|      |   |      |   |      |   |      |");
       for(int i = 0; i<3; i++) {
           if(facingUp[1][i] == true) {
            switch(cards[1][i].length()){
                case(1):
                    System.out.print("|  " + cards[1][i] + "   |   ");
                break;
                case(2):
                    System.out.print("|  " + cards[1][i] + "  |   ");
                break;
                case(3):
                    System.out.print("|  " + cards[1][i] + " |   ");
                break;
                case(4):
                    System.out.print("| " + cards[1][i] + " |   ");
                break;
            }
           } else{
               if (faceDown[1][i].length() == 1) {
                   System.out.print("|  " + faceDown[1][i] + "   |   ");
               }
               else if (faceDown[1][i].length() == 2) {
                   System.out.print("|  " + faceDown[1][i] + "  |   ");
               }
           }
       }

       //row 2 column 4
       if(facingUp[1][3] == true) {
        switch(cards[1][3].length()){
            case(1):
                System.out.print("|  " + cards[1][3] + "   |   ");
            break;
            case(2):
                System.out.print("|  " + cards[1][3] + "  |   ");
            break;
            case(3):
                System.out.print("|  " + cards[1][3] + " |   ");
            break;
            case(4):
                System.out.print("| " + cards[1][3] + " |   ");
            break;
        }
       } else{
           System.out.println("|  " + faceDown[1][3] + "   |   ");
       }
       System.out.println("|      |   |      |   |      |   |      |");
       System.out.println("+------+   +------+   +------+   +------+");

       //row 3
       System.out.println("+------+   +------+   +------+   +------+");
       System.out.println("|      |   |      |   |      |   |      |");
       for(int i = 0; i<3; i++) {
           if(facingUp[2][i] == true) {
            switch(cards[2][i].length()){
                case(1):
                    System.out.print("|  " + cards[2][i] + "   |   ");
                break;
                case(2):
                    System.out.print("|  " + cards[2][i] + "  |   ");
                break;
                case(3):
                    System.out.print("|  " + cards[2][i] + " |   ");
                break;
                case(4):
                    System.out.print("| " + cards[2][i] + " |   ");
                break;
            }
        } else{
            if (faceDown[2][i].length() == 1) {
               System.out.print("|  " + faceDown[2][i] + "   |   ");
           }
           else if (faceDown[2][i].length() == 2) {
               System.out.print("|  " + faceDown[2][i] + "  |   ");
           }
        }
       }

       //row 3 column 4
       if(facingUp[2][3] == true) {
        switch(cards[2][3].length()){
            case(1):
                System.out.print("|  " + cards[2][3] + "   |   ");
            break;
            case(2):
                System.out.print("|  " + cards[2][3] + "  |   ");
            break;
            case(3):
                System.out.print("|  " + cards[2][3] + " |   ");
            break;
            case(4):
                System.out.print("| " + cards[2][3] + " |   ");
            break;
        }
       } else{
           System.out.println("|  " + faceDown[2][3] + "  |   ");
       }
       System.out.println("|      |   |      |   |      |   |      |");
       System.out.println("+------+   +------+   +------+   +------+");

       //row 4
       System.out.println("+------+   +------+   +------+   +------+");
       System.out.println("|      |   |      |   |      |   |      |");
       for(int i = 0; i<3; i++) {
           if(facingUp[3][i] == true) {
            switch(cards[3][i].length()){
                case(1):
                    System.out.print("|  " + cards[3][i] + "   |   ");
                break;
                case(2):
                    System.out.print("|  " + cards[3][i] + "  |   ");
                break;
                case(3):
                    System.out.print("|  " + cards[3][i] + " |   ");
                break;
                case(4):
                    System.out.print("| " + cards[3][i] + " |   ");
                break;
            }
        } else{
               if (faceDown[3][i].length() == 1) {
                   System.out.print("|  " + faceDown[3][i] + "   |   ");
               }
               else if (faceDown[3][i].length() == 2) {
                   System.out.print("|  " + faceDown[3][i] + "  |   ");
               }
           }
       }

       //row 4 column 4
       if(facingUp[3][3] == true) {
        switch(cards[3][3].length()){
            case(1):
                System.out.print("|  " + cards[3][3] + "   |   ");
            break;
            case(2):
                System.out.print("|  " + cards[3][3] + "  |   ");
            break;
            case(3):
                System.out.print("|  " + cards[3][3] + " |   ");
            break;
            case(4):
                System.out.print("| " + cards[3][3] + " |   ");
            break;
        }
       } else{
           System.out.println("|  " + faceDown[3][3] + "  |   ");
       }
       System.out.println("|      |   |      |   |      |   |      |");
       System.out.println("+------+   +------+   +------+   +------+");

   }

   /**
    * This function prompts the user for a card number
    * and then returns it
    * @return the number of the card which the user chose
    */
   public static int getChoice(){
       System.out.print("Please Enter Card: ");
       int cardNum = CheckInput.getIntRange(1,16);
       System.out.println();

       return cardNum;
   }

   /**
    * This function will "flip" the card which was
    * chosen by the user over. If it was facing down
    * the card would then be facing up after a call
    * of this function.
    * @param choice is the card chosen
    * by the user
    * @param facingUp is the 2D array which keeps track
    * of whether each card at that correlating location
    * is facing up or not
    */
   public static void flipChoice(int choice, boolean[][] facingUp){
        for( int i = 0; i<=3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (choice == (i * 4) + j + 1) {
                    if( facingUp[i][j] == true ){
                        facingUp[i][j] = false;
                    } else{
                        facingUp[i][j] = true;
                    }
                }
            }
        }
    }

   /**
    * This function compares the values between
    * two cards and determines whether they match
    * or not
    * @param card1 the first card to be matched
    * @param card2 the second card to be matched
    * @return true if the cards match, false if
    * they do not
    */ 
   public static boolean isMatch(String card1, String card2){
       boolean matching;
       if(card1 == card2) {
           matching = true;
       }else{
           matching = false;
       }
       return matching;
   }

   /**
    * This function checks whether the card
    * chosen by the user is facing up or not
    * @param choice is the number correlating to
    * the card which the user wishes to check
    * @param facingUp is the 2D array of booleans
    * correlating to the cards' state of being
    * flipped up or not
    * @return true if the respective card
    * is facing up false if it isn't
    */
   public static boolean checkedFlipped(int choice, boolean[][] facingUp){
       switch(choice){
        case(1):
            if(facingUp[0][0] == true){
                return true;
            } else{
                return false;
            }

        case(2):
            if(facingUp[0][1] == true){
                return true;
            } else{
                return false;
            }

        case(3):
            if(facingUp[0][2] == true){
                return true;
            } else{
                return false;
            }
           
        case(4):
            if(facingUp[0][3] == true){
                return true;
            } else{
                return false;
            }

        case(5):
            if(facingUp[1][0] == true){
                return true;
            } else{
                return false;
            }

        case(6):
            if(facingUp[1][1] == true){
                return true;
            } else{
                return false;
            }
           
        case(7):
            if(facingUp[1][2] == true){
                return true;
            } else{
                return false;
            }
           
        case(8):
            if(facingUp[1][3] == true){
                return true;
            } else{
                return false;
            }
        
        case(9):
            if(facingUp[2][0] == true){
                return true;
            } else{
                return false;
            }
        
        case(10):
            if(facingUp[2][1] == true){
                return true;
            } else{
                return false;
            }
           
        case(11):
            if(facingUp[2][2] == true){
                return true;
            } else{
                return false;
            }
           
        case(12):
            if(facingUp[2][3] == true){
                return true;
            } else{
                return false;
            }

        case(13):
            if(facingUp[3][0] == true){
                return true;
            } else{
                return false;
            }
                      
        case(14):
            if(facingUp[3][1] == true){
                return true;
            } else{
                return false;
            }
           
        case(15):
            if(facingUp[3][2] == true){
                return true;
            } else{
                return false;
            }

        case(16):
            if(facingUp[3][3] == true){
                return true;
            } else{
                return false;
            }
        }
        return false;
    }
}