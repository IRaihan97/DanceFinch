package dance.finch.islam.raihan;
import java.util.ArrayList;
import java.util.Scanner;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException
    {
		String choice = "yes";//value used to loop the entire program
		Scanner scan = new Scanner(System.in);
		ArrayList<String> toFile = new ArrayList<String>();//List used to store every value used. Will be used to write into a text file
		do
		{
	        boolean checkIn;//value used to validate user input
			String input;//variable that stores user input 
	        
			//Loop to validate the user input
	        do 
	        {
	        	System.out.print("Enter a Hexadecimal Number Of Maximum Two Digits: ");
	        	input = scan.nextLine();//Ask the user to input
	        	//initialising validation object to validate user input
	        	Validation validate = new Validation(input);
	        	checkIn = validate.check();//returns true or false depending on the input entered
	        }while(checkIn == false);//will keep on looping as long as check returns false
	        
	        
	        
	        //Initialising a Dance object
	        Dance doit = new Dance(input);   
	        doit.DisplayValues();//gets method from Dance class and executes it
	        
	        //Initialising a Finch Object
	        Finch finch = new Finch();
	        Validation validate = new Validation(input);
	        validate.check(finch);//validates the positioning of the finch
	        doit.danceRobot(finch);//gets method from Dance class and executes it
	        finch.quit();//Stops the finch
	        //Adding the following String to one value of the array list.
	        toFile.add("\nYour Input: " + doit.hexadecimal +
					"\nConversion to Decimal: " + doit.decimal +
					"\nConversion to Octal: " + doit.octal + 
					"\nConversion to Binary: " + doit.r_binary +
					"\nValue used for Red in the LED Mixer: " + doit.getRed() + 
					"\nValue used for Green in the LED Mixer: " + doit.getGreen() +
					"\nValue used for Blue in the LED Mixer: " + doit.getBlue() +
					"\nValue used for the Robot's Speed: " + doit.getSpeed());
	        System.out.println("Would you like to enter another value? y/n: ");
	        choice = scan.nextLine();//User inputs for the choice of entering a new hexadecimal value
	        choice = choice.toUpperCase();
	        
    	}while(choice.equals("YES") || choice.equals("Y"));
		scan.close();
		TextFile txt = new TextFile("src\\dance\\finch\\islam\\raihan\\file.txt", toFile);//Initialising textfile object
		txt.writeToFile();//gets method from TextFile and writes values passed into a text file
		System.out.println("Opening Text File with all Inputs and Outputs");
		System.out.println("Please Minimize all Windows if you don't see any Prompts"); 
		txt.openFile();//opens the text file using a method from the TextFile class
    }
}