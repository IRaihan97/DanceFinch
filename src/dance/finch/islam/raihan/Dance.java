package dance.finch.islam.raihan;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.util.Random;

public class Dance extends Conversion{
	private int red;
	private int green;
	private int blue;
	private int speed;
	Dance(String input)
	{
		super(input);//Inheriting values from Conversion
		red = decimal;//Assigning decimal value from parent class to red
		green = red % 80 + 60;
		blue = (red + green)/2;
		speed = calSpeed(octal); 
	}
	
	
	
	
	//Method to calculate the speed of the finch
	private int calSpeed(int oct)
	{
		int spd = 0;
        if(oct <= 60) 
        {
    		spd = oct + 30;//adds 30 if the speed is less than 60
    	}
        
        else if (oct >= 255)
        {
        	spd = 255;//sets the speed to 255 if the octal value goes over 255
        }
        
        else 
        {
        	spd = oct;
        }
        return spd;
	}
	
	
	
	
	public void danceRobot(Finch robot)
	{
		robot.setLED(red, green, blue);//sets LED of the robot
		String[] clips = new String[5];
		//Adding clips to the clips array using a loop
        for(int i = 0; i < clips.length; i++)
        {
        	clips[i] = "clip" + i + ".wav";
        }
        
        
        //randomizing clips from array
        String clip = clips[new Random().nextInt(clips.length)];
        robot.playClip(clip);//plays randomized clip
        
		//loops based on the size of "binary" arraylist which is inherited from conversion
		for(int i = 0; i < binary.size(); i++)
		{
        	if(binary.get(i) == 0) //if value of "binary" list is 0, move backwards
        	{
        		//Sets speed and direction of wheels. Negative speed means the robot will go backwards
        		System.out.println("Value is 0 - Moving Backwards");
        		robot.setWheelVelocities(-speed, -speed, 1000);
        		robot.setWheelVelocities( -speed, 0, 500);
        		robot.setWheelVelocities( 0, -speed, 500);
        		
        	}
        	
        	else if(binary.get(i) == 1)//if is 1, move forward 
        	{
        		//Sets speed and direction of wheels
        		System.out.println("Value is 1 - Moving Forward");
        		robot.setWheelVelocities(speed, speed, 1000);
        		robot.setWheelVelocities( 0, -speed, 500);
        		robot.setWheelVelocities( -speed, 0, 500);
        		
        	}
        	
        	
        	else 
        	{
        		System.out.println("Operation Failed");//if is not 0 or 1, it means that there has been an error during the conversion
        	}
        }
		
		//Pauses the program and plays an end clip
		System.out.println("Please Wait...");
        robot.sleep(10000);
        robot.playClip("end.wav");
		
	}
	
	
	
	
	//Displays values
	public void DisplayValues()
	{
		System.out.println("Here are all the values used for your finch");
		System.out.println("Your Input: " + hexadecimal);
		System.out.println("Conversion to Decimal: " + decimal);
		System.out.println("Conversion to Octal: " + octal); 
		System.out.println("Conversion to Binary: " + r_binary);
		System.out.println("Value used for Red in the LED Mixer: " + red); 
		System.out.println("Value used for Green in the LED Mixer: " + green );
		System.out.println("Value used for Blue in the LED Mixer: " + blue);
		System.out.println("Value used for the Robot's Speed: " + speed);
		System.out.println();
	}
	
	//Methods to allow other methods to access private values of the constructor
	public int getRed(){
		return(red);
	}
	
	public int getGreen(){
		return(green);
	}
	
	public int getBlue(){
		return(blue);
	}
	
	public int getSpeed(){
		return(speed);
	}
	
	
		
}
