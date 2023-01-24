/**Four recursive problems. 
 * Add your two facade functions.
 * Add your code to the four functions given below.
 * Do not change any part of the function headers (name, parameters, or return type).
 * Do not change any part of the main.
 */
public class Recursion2 {
	public static void main( String[] args ) {
		int [] array = { 46, 22, 7, 58, 91, 55, 31, 84, 12, 78 };
		if( findMax( array ) == 91 ) {
			System.out.println( "findMax is correct!" );
		}
		if( reverseStr( "Hello" ).equals( "olleH" ) ) {
			System.out.println( "reverseString1 is correct!" );
		}	
		if( charFrequency( "The quick brown fox jumps over the lazy dog.", 'o' ) == 4 ) {
			System.out.println( "charFrequency1 is correct!" );
		}
		if( findMin( array ) == 7 ) {
			System.out.println( "findMin is correct!" );
		}
		if( reverseStr( "pupils" ).equals( "slipup" ) ) {
			System.out.println( "reverseString2 is correct!" );
		}	
		if( charFrequency( "The quick brown fox jumps over the lazy dog.", 'e' ) == 3 ) {
			System.out.println( "charFrequency2 is correct!" );
		}
	}
	//Write your facade functions here
	/** 
	* facade function that calls maxArray
	* @param array, the array that will get
	* passed through maxArray
	*/
	private static int findMax(int[] array){
		int i = 0;
		int max = array[0];
		return maxArray(array, i, max);
	}

	/** 
	* facade function that calls minArray
	* @param array, the array that will get
	* passed through minArray
	*/
	private static int findMin(int[] array){
		int i = 0;
		int min = array[0];
		return minArray(array, i, min);
	}

	/** Finds the maximum value in an array
	 * @param array array of values (sorted or unsorted)
	 * @param i iterator
	 * @param max maximum value found so far
	 * @return maximum value
	 */
	private static int maxArray( int [] array, int i, int max ) {
		if(i == array.length){
			return max;
		}else if(array[i] > max){
			max = array[i];
		}
		
		return maxArray(array, i+1, max);
	}
	/** Finds the maximum value in an array
	 * @param array array of values (sorted or unsorted)
	 * @param i iterator
	 * @param min maximum value found so far
	 * @return minimum value
	 */
	private static int minArray( int [] array, int i, int min ) {
		if(i == array.length){
			return min;
		}else if(array[i] < min){
			min = array[i];
		}
		
		return minArray(array, i+1, min);
	}
	/** Reverses a string
	 * @param s the string to reverse
	 * @return the reversed string
	 */
	public static String reverseStr( String s ) {
		if(s.length() == 0){
			return "";
		}
		return s.substring(s.length()-1, s.length()) + reverseStr(s.substring(0,s.length()-1));
	}
	/** Returns the number of times c appears in the string str
	 * @param str string to test
	 * @param c character to find
	 * @return number of times the character appeared in the string
	 */
	public static int charFrequency( String str, char c ) {	
		
		if(str.length() == 0){
			return 0;
		}else{
			if(str.substring(0,1).equals(Character.toString(c))){
				return charFrequency(str.substring(1), c) + 1;
			}
		}
		return charFrequency(str.substring(1), c);
	}
}
