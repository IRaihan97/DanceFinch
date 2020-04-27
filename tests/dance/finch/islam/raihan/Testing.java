package dance.finch.islam.raihan;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class Testing {
	
	private Conversion inputTest;
	private Conversion convTest1;
	private Conversion convTest2;
	private Conversion convTest3;
	
	private Validation valTest1;
	private Validation valTest2;
	private Validation valTest3;
	
	private Dance danceTest1;
	private Dance danceTest2;
	private Dance danceTest3;
	
	private TextFile textTest;
	
	
	Scanner insert = new Scanner(System.in);
	String input;
	
	//Conversion Tests
	@Test
	public void takesInput()
	{
		System.out.println("Insert input: ");
		input = insert.nextLine();
		inputTest = new Conversion(input);
		assertNotNull(inputTest.hexadecimal);
	}
	
	@Test
	public void hexToDecTEST()
	{
		assertEquals(159, convTest1.decimal);
		assertEquals(1, convTest2.decimal);
		assertEquals(94, convTest3.decimal);
	}
	
	@Test
	public void decToOctTEST()
	{
		assertEquals(237, convTest1.octal);
		assertEquals(1, convTest2.octal);
		assertEquals(136, convTest3.octal);
	}
	
	@Test
	public void decToBinTEST()
	{
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(1);arr1.add(1);arr1.add(1);arr1.add(1);arr1.add(1);
		arr1.add(0);arr1.add(0);arr1.add(1);
		assertEquals(arr1, convTest1.binary);
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(1);
		assertEquals(arr2, convTest2.binary);
		
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		arr3.add(0);arr3.add(1);arr3.add(1);arr3.add(1);arr3.add(1);
		arr3.add(0);arr3.add(1);
		assertEquals(arr3, convTest3.binary);
		
	}
	
	@Test
	public void reverseTEST()
	{
		assertEquals("10011111", convTest1.r_binary);
		assertEquals("1", convTest2.r_binary);
		assertEquals("1011110", convTest3.r_binary);
	}
	
	
	
	@Test
	public void validationTEST()
	{
		assertFalse(valTest1.check());
		assertFalse(valTest2.check());
		assertTrue(valTest3.check());
	}
	
	@Test
	public void LEDcolorTest()
	{		
		assertEquals(159, danceTest1.getRed());
		assertEquals(139, danceTest1.getGreen());
		assertEquals(149, danceTest1.getBlue());
		
		assertEquals(1, danceTest2.getRed());
		assertEquals(61, danceTest2.getGreen());
		assertEquals(31, danceTest2.getBlue());
		
		assertEquals(94, danceTest3.getRed());
		assertEquals(74, danceTest3.getGreen());
		assertEquals(84, danceTest3.getBlue());
	}
	
	@Test
	public void speedTEST() 
	{
		assertEquals(237, danceTest1.getSpeed());
		assertEquals(31, danceTest2.getSpeed());
		assertEquals(136, danceTest3.getSpeed());
	}
	
	@Test
	public void txtFileTEST() throws IOException
	{
		textTest.writeToFile();
		assertNotNull(textTest.readFile());
	}
	
	@Before
	public void setup()
	{
		//Conversion Objects
		convTest1 = new Conversion("9f");//highest boundry
		convTest2 = new Conversion("1");//lowest boundry 
		convTest3 = new Conversion("5e");//normal value
		
		//Validation Objects
		valTest1 = new Validation("abcdefgh");
		valTest2 = new Validation("jk");
		valTest3 = new Validation("6a");
		
		//Dance Objects
		danceTest1 = new Dance("9f");//highest boundry
		danceTest2 = new Dance("1");//lowest boundry 
		danceTest3 = new Dance("5e");//normal value
		
		
		ArrayList<String> txt = new ArrayList<String>();
		txt.add("line 1");
		txt.add("line 2");
		
		textTest = new TextFile("test.txt", txt);
		
	}
	

}
