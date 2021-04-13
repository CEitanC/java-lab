package CHAR_FREQ;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class CharFreq {	
	private TreeMap<Character,Integer> alphabet;
	private int total_count = 0;
	
	public CharFreq() {
		this.alphabet = new TreeMap<Character,Integer>();
		//initiate all letters to have 0 count
		for(char i = 'a'; i <='z'; i++) {
			this.alphabet.put(i,0);
		}
	}
	
	public void addSample(Character c) {
		//search for the letter in the map
		Integer count = alphabet.get(c);
		//increase its count
		alphabet.put(c,  count +1);
	}
	
	public void printStatistics() {
		//iterate over the map
		for (Map.Entry<Character,Integer> entry : alphabet.entrySet()) {
			//print the frequencies
			double num = 100*(entry.getValue());
			num = num/total_count;
			String pattern = "###.###";
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			String format = decimalFormat.format(num);
			System.out.println("The frequency for " + entry.getKey() + " is " 
					 + format + "%");
		}
	}
	
	public void readFile(String filename) throws IOException{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				// read next line
				// split the line and leave only english letters
				String[] chars_array = line.split("\\P{Alpha}+");
				//add +1 to each letter that is found in the string
				//to its entry in the map
				for (int i = 0; i < chars_array.length; i++) {
					String chars = chars_array[i].toLowerCase();
					for(int j = 0; j <chars.length(); j++) {
						char c = chars.charAt(j);
						addSample(c);
						total_count++;
					}
				}
				//advance the line iterator
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
		}
	}
	public static void main(String[] args) {
		CharFreq cf1 = new CharFreq();
		try {
			//9 As and 3 Bs
			cf1.readFile("test_text.txt");
		    System.out.println("Test1 - loaded:");
		    cf1.printStatistics();
		} catch (IOException e) {
		    System.out.println(e);
		    return;
		}
		CharFreq cf2 = new CharFreq();
		try {
			cf2.readFile("std17.txt");
		    System.out.println("Test2 - loaded:");
		    cf2.printStatistics();
		} catch (IOException e) {
		    System.out.println(e);
		    return;
		}

	}

}
