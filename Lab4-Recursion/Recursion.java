
/**Three recursive problems.
 * Add your code to the three functions given below.
 * Do not change any part of the function headers (name, parameters, or return type).
 * Do not change any part of main.
 */
public class Recursion {
	public static void main( String[] args ) {
		if( addDigits( 428 ) == 14 ) {
			System.out.println( "addDigits is correct!" );
		}
		if( revFibonacci( 0, 1, 1, 5 ) == 5 ) {
			System.out.println( "revFib1 is correct!" );
		}	
		if( binToDec( "1101100" ) == 108 ) {
			System.out.println( "binToDec1 is correct!" );
		}
		if( addDigits( 321 ) == 6 ) {
			System.out.println( "addDigits2 is correct!" );
		}
		if( revFibonacci( 0, 1, 1, 10 ) == 55 ) {
			System.out.println( "revFib2 is correct!" );
		}	
		if( binToDec( "1011101" ) == 93 ) {
			System.out.println( "binToDec2 is correct!" );
		}
	}
	/**Finds the sum of the digits of num
	 * @param num value to find the sum of
	 * @return the sum of the digits
	 */
	public static int addDigits( int num ) {
		//returns 0, nothing to add
		if(num == 0){
            return 0;
		}
		//adds the last digit then recurs and gets the digits preceding the
		//rightmost one
        return num%10 + addDigits(num/10);
	}
	/**Finds the nth Fibonacci value
	 * @param f1 n-2 Fibonacci value
	 * @param f2 n-1 Fibonacci value
	 * @param c  counter
	 * @param n  the number c should count up to
	 * @return  the nth Fibonacci value 
 	 */
	public static int revFibonacci( int f1, int f2, int c, int n ) {
		//returns the one changing variable
		if( c == n){
			return f2;
		}
		
		int temp = f2; //stores the value to make f1 equal to it
		f2 = f1 + f2; //move f2 up
		f1 = temp; //move f1 up to where f2 was
		return revFibonacci(f1, f2, c+1, n);
	}
	/**Converts a binary string to decimal
	 * @param bin the binary string
	 * @return the decimal value 
	 */
	public static int binToDec( String bin ) {
		//base case, 0 won't affect the sum
		if(bin.length() == 0){
			return 0;
		}
		
		//in order, it gets the leftmost character,
		//then multiplies by 2 to the power of the string length
		//then recurs and chops off the leftmost character
		return (int)(Integer.parseInt(bin.substring(0, 1)))*(int)(Math.pow(2, bin.length()-1)) + binToDec(bin.substring(1, bin.length()));
	}
}
