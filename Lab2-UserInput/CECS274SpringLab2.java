import java.util.EventListener;
import java.util.Scanner;
       
/**    
 * A program that asks the user to give 10 integer values
 * which then get stored in an array. After that, the user
 * has several options to choose from a menu of tasks they
 * can have done to the array 
 * @author Steven Yacoub - February 5, 2020
 */    
public class CECS274SpringLab2{
    public static void main(String[] args){
        int[] nums = new int[10];
        populateArray(nums);
        int menuSelection = 0;
        while(menuSelection != 8){
            displayMenu();
            menuSelection = CheckInput.getIntRange(1,8);
            switch(menuSelection){
                case(1):
                    displayValues(nums);
                break;
                case(2):
                    displayReversed(nums);
                break;
                case(3):
                    System.out.println("The sum is " + computeSum(nums));
                break;
                case(4):
                    System.out.println("The max value is " + maxValue(nums));
                break;
                case(5):
                    System.out.println("Enter a number to search for");
                    int numSearch = CheckInput.getInt();
                    int valueFound = findValue(nums, numSearch); 
                    if( valueFound == -1){
                        System.out.println("Value not found");
                    }else{
                        System.out.println("The value is at index number " + valueFound);
                    }

                break;
                case(6):
                    System.out.println("Enter the insertion index");
                    int insertIndex = CheckInput.getIntRange(1,10);                
                    System.out.println("Enter the value to insert");
                    int insertionVal = CheckInput.getInt();
                    insertValue(nums, insertIndex-1, insertionVal);
                break;
                case(7):
                    populateArray(nums);
                break;
                case(8):
                    System.out.println("Bye bye!");
                break;
            }
        }
    }  

    /**
	 * Asks the user to input 10 values and then 
     * stores them in the array passed through the
     * parameter
     * @param arr is array to be filled
	 * @return the newly filled array
	 */
    public static int[] populateArray(int[] arr){
        int newVal = 0;
        System.out.println("Enter 10 values, individually:");
        for(int i = 0; i < arr.length; i++){
            newVal = CheckInput.getInt();
            arr[i] = newVal;
        }
        return arr;
    }

    /**
	 * Displays all values in the
     * array which the user filled
     * @param arr is array to be printed
	 */
    public static void displayValues(int arr[]){
        for(int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i] + "," + " ");
        }
        System.out.print(arr[arr.length-1]);
        System.out.println("");
    }

    /**
	 * Displays all values in the
     * array which the user filled
     * but in reversed order
     * @param arr is the array to be printed
	 */
    public static void displayReversed(int arr[]){
        for(int i = arr.length-1; i > 0; i--){
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[0]);
        System.out.println("");
    }

    
    /**
	 * A user enters a value that they would like
     * to search the array for
     * @param arr is the array to be searched
     * @param val is the value to be found
     * @return the index at which the value is found
     * or alternatively, -1, if it's not found
	 */
    public static int findValue(int arr[], int val){
        boolean valFound = false;
        for(int i = 0; i < arr.length-1; i++){
            if(val == arr[i] && valFound == false){
                i++;
                return i;
            }
        }
        return -1;
    }
    

    /**
	 * The user inputs a new value which will
     * replace the one at the index they enter
     * @param arr is the array to be searched
     * @param index is the location where the
     * new value will take over
     * @param newVal is the new value that will
     * take over the one at index
	 */
    public static void insertValue(int arr[], int index, int newVal){
        arr[index] = newVal;
    }

    /**
	 * The array is searched for its maximum
     * mathematical value
     * @param arr is the array to be searched
     * @return the highest value in the array
     */
    public static int maxValue(int arr[]){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    /**
	 * All the values that are in the array
     * are added up and totaled 
     * @param arr is the array to be summed up
     * @return the sum of all the values in the array
	 */
    public static int computeSum(int arr[]){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }

    
    /**
	 * Prints out all the menu options
     * that the user can choose from
	 */
    public static void displayMenu(){
        System.out.println("");
        System.out.println("-----MENU-----");
        System.out.println("1. Display Values");
        System.out.println("2. Display Reversed");
        System.out.println("3. Display Sum");
        System.out.println("4. Display Maximum");
        System.out.println("5. Search for a Value");
        System.out.println("6. Insert new Value");
        System.out.println("7. Reset Values");
        System.out.println("8. Quit");
        System.out.println("Menu Selection:");
    }
}     