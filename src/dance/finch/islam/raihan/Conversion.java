package dance.finch.islam.raihan;
import java.util.ArrayList;
public class Conversion {
	protected String hexadecimal;
	protected int decimal;
	protected int octal;
	protected ArrayList<Integer> binary;
	protected String r_binary;
	Conversion(String input)
	{
		hexadecimal = input;
		decimal = hexToDecimal(hexadecimal);
		octal = decToOctal(decimal);
		binary = decToBinary(decimal);
		r_binary = reverseArray(binary);
	}
	
	//Converts from hexadecimal to decimal
	private int hexToDecimal(String s)
    {
             String digits = "0123456789ABCDEF";//digits to define value based on position on this string
             s = s.toUpperCase();//changes the parameter value to uppercase
             int val = 0;//value starts with 0
             
             
             //loop for the as many characters as in "s"
             for (int i = 0; i < s.length(); i++)
             {
                 char c = s.charAt(i);//gets character at position i from user input
                                  
                 int d = digits.indexOf(c);//get index value of character from digits
                                
                 val = 16 * val + d;//calculates decimal num. Times 16 with itself each loop and adds the value of the character from digits in decimal form
                 
             }
             return val;
    }
	
	//Converts from decimal to octal
	private int decToOctal(int decimal)
    {
		 ArrayList<Integer> oct_num = new ArrayList<Integer>();
		 int octal= 0;
		 
		 
	     
	     while(decimal != 0)
	     {
	    	 oct_num.add(decimal%8);//remainder represents one digit in octal. Adding it to the arraylist.
	    	 decimal /= 8;//"%" does not divide the number, it only gets the remainder, so it requires this division to reach 0.
	     }
	     
	     
	     
	     //for loop to combine values of each oct_num array into one integer value
	     int unit = 1;//first value of the array list represents unit of 1
	     for(int i = 0; i < oct_num.size(); i++) 
	     {       	
	    	octal = octal + (oct_num.get(i) * unit) ;
	        unit *= 10;//unit is timed by ten after each loop
	        
	      }
		 return octal;
    }
	
	
	//Converts from decimal to binary as an array list for each digit (right to left)
	private ArrayList<Integer> decToBinary(int decimal)
    {
		ArrayList<Integer> bin_num = new ArrayList<Integer>();
		
		while(decimal != 0) 
		{
        	bin_num.add(decimal%2) ;//remainder represents one digit in Binary.
            decimal /= 2;//Keep dividing by 2 to reach 0
        }
		return bin_num;//returns the arraylist
    }
	
	
	//method that returns a string of values from an ArrayList with reversed order.  
	public String reverseArray(ArrayList<Integer> array)
	{
		String num = "";
		for (int i = array.size()-1; i >= 0; i--) 
		{
        	num = num + array.get(i);
        }
		return num;
	}
	
}
