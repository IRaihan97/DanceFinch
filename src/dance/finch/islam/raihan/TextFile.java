package dance.finch.islam.raihan;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextFile{
	private static String location;
	private static ArrayList<String> inFile;
	TextFile(String file, ArrayList<String> content)
	{
		location = file;
		inFile = content;
	}
	
	//Writes to a file
	public void writeToFile () throws IOException
	{
		FileWriter writehandle = new FileWriter(location);//opens file on a specified file path which is entered as an argument

		BufferedWriter bw = new BufferedWriter(writehandle);
		
		for(int i = 0;i < inFile.size();i++)
		{
			int attempts = i+1;
			bw.write("Attempt Number " + attempts + "- ");
			bw.write(inFile.get(i));//Adds a value from the arrayList "inputs" in each loop
			bw.newLine();
			bw.newLine();//creates a new line
			  
		}
		bw.close();
		writehandle.close();
	}
	
	//Reads from file and returns the text from the file 
	public String readFile() throws IOException
	{
		FileReader readhandle = new FileReader(location);
		BufferedReader br = new BufferedReader(readhandle);
		String line = null;
		String output = "";
		//loop will stop when there are no more line to read in the text file
		while((line = br.readLine()) != null)
		{
		   output += line + "\n";//adds each line of the file into a string variable
		}
		br.close();
		readhandle.close();
		return output;
	}
	
	//Opens the text file
	public void openFile() throws IOException
	{
		JTextArea textArea = new JTextArea(readFile());//set text to display on screen
		JScrollPane scrollPane = new JScrollPane(textArea);//makes scrollable panel by including text  
		//wraps up text area
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 500, 500 ) );//set dimension of the panel
		JOptionPane.showMessageDialog(null, scrollPane, "Text File With All Values Used",  
        JOptionPane.YES_NO_OPTION);//opens up the panel as a message dialog, user will need to click ok to continue
	}
}
