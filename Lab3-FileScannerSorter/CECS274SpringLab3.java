import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
       
/**    
 *  This program will read through a text file containing
 *  numbers and then the user can perform several analytical
 *  tasks with the dataset. First, they're sorted and then
 *  the user can choose to find the, maximum, median, minimum,
 *  average, or just return all the data
 *  @author Steven Yacoub - February 12, 2020
 */    

 public class CECS274SpringLab3{
    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>();
        int menuSelection = 0;
        try {
            Scanner scan = new Scanner(new File("grades.txt"));
            populateGrades(nums, scan);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sortList(nums);
        while(menuSelection != 6){
            displayMenu();
            menuSelection = CheckInput.getIntRange(1,6);
            switch(menuSelection){
                case(1):
                    System.out.println("case 1, display sorted, working!");
                    displayGrades(nums);    
                break;
                case(2):
                    System.out.println("case 2, averages, working!");
                    double total = sumGrades(nums);
                    double size = nums.size();
                    System.out.printf("The average is %.1f", total/size);
                break;
                case(3):
                    System.out.println("case 3, display maximum, working!");
                    System.out.println("The maximum is " + nums.get(nums.size()-1));
                break;
                case(4):
                    System.out.println("case 4, display minimum, working!");
                    System.out.println("The minimum is " + nums.get(0));
                break;
                case(5):
                    System.out.println("case 5, display median, working!"); 
                    System.out.printf("The median is %.1f", findMedian(nums));
                break;
                case(6):
                    System.out.println("Bye bye!");
                break;
            }
        }
    }  

    /**
	 * A text file is read and all the numbers from it
     * are added as elements into an ArrayList
     * 
     * @param arr, the ArrayList to be populated
	 * @return arr, newly filled
	 */
    public static ArrayList<Integer> populateGrades(ArrayList<Integer> arr, Scanner reader){
        while(reader.hasNextInt()){
            arr.add(reader.nextInt());
        }
        return arr;
    }

    /**
     * An ArrayList has its elements displayed
     * specifically in rows of 10
     * @param arr, the ArrayList whose elements will be displayed
	 */
    public static void displayGrades(ArrayList<Integer> arr){
        for(int i = 0; i < arr.size(); i++){
            if(i%10 == 0){ 
                System.out.println("");
            }
            System.out.print(arr.get(i) + " ");
        }
    }

    /**
     * The elements in an ArrayList are sorted by
     * the Selection Sort method, and will end up
     * in numerical order from least to greatest
	 * @param arr the ArrayList to be sorted
	 */
    public static void sortList(ArrayList<Integer> arr){
        for(int i = 0; i < arr.size(); i++){  
            int lowest = i;
            for(int j = i + 1; j < arr.size(); j++){  
                if(arr.get(j) < arr.get(lowest)){
                    lowest = j;
                }
            }
            int swap = arr.get(i);
            arr.set(i, arr.get(lowest));
            arr.set(lowest, swap);
        }
    }

    /**
     * Iterates through an ArrayList and adds
     * up all of the elements within it
	 * @param arr is the ArrayList whose elements
     * will be summed up
     */
    public static int sumGrades(ArrayList<Integer> arr){
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            sum += arr.get(i);
        }
        return sum;
    }    

    /**
     * Finds the element in the middle of an ArrayList object
     * if the amount of elements is even, the average of the
     * middle two elements is taken
     * @param arr is the ArrayList that gets searched
	 */
    public static double findMedian(ArrayList<Integer> arr){
        if(arr.size()%2 == 0){
            double evenMedian = (arr.get(arr.size()/2) + arr.get(arr.size()/2 - 1))/2.0;
            return evenMedian;
        }else{
            double oddMedian = arr.get(arr.size()/2);
            return oddMedian;
        }
    }

    /**
	 * Prints out all the menu options
     * that the user can choose from
	 */
    public static void displayMenu(){
        System.out.println("");
        System.out.println("-----MENU-----");
        System.out.println("1. Display Sorted Grades");
        System.out.println("2. Display Average Grade");
        System.out.println("3. Display Maximum Grade");
        System.out.println("4. Display Minimum Grade");
        System.out.println("5. Display Median Grade");
        System.out.println("6. Quit");
        System.out.println("Menu Selection:");
    }
}     




















































































































































































































































































































































































































































































































































































































































/**    
 *i wonder what danimals crunchers feels like in my mouth
 *ooh like this, smooooooth
 *no, like this, CRUNCHY CRUNCHY CRUNCHY
 *actually??? it's both...
 *danimals crunchers mmmm crunchalicious 
 *ooo ooo oOO AAA AAA AAA (steals danimals crunchers)
 *NNOOOOOO FOLLOW THAT MONKEY AAAA
 */    