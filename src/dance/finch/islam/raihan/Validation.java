package dance.finch.islam.raihan;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Validation {
	private String value;
	Validation(String input)
	{
		value = input;//value is determined by the input argument which will be the user input when is initialised in the main (Passed as a parameter)
	}
	
	//Checks the user input passed in constructor
	public boolean check(){
		
		boolean check;
		if(value.length() <= 2) 
		{
			
    		//checking the user input through a regular Expression
    		if (value.matches("^[A-Fa-f0-9]+$"))
    		{
    			check = true;//It will stop the loop and will allow the variable "input" to be accepted
    		}
    		
    		else 
    		{
    			//Displays this message if the user input is not hexadecimal
    			System.out.println("Invalid Input - Value entered is not a valid hexadecimal value");
    			check = false;
    		}
    		
    	}
    	
    	//Displays this message if the input is more than two characters
    	else 
    	{
    		System.out.println("Invalid Input - Cannot Exceed two characters");
    		check = false;
    	}
		
		return check;
		
	}
	
	//Checks position of the robot 
	public void check(Finch robot)
	{
		
		if (!robot.isFinchLevel())
		{
			System.out.println("Please make sure that the finch is on the floor before making it dance!");
			//Program will keep pausing as long as the finch is not on floor level
			while(!robot.isFinchLevel())
			{
				robot.sleep(1000);
			}
		}
		
	}
}
