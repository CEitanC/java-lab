package PASSWORDMANAGER;
import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordManager {
	private TreeMap<String,String> lib;
	
	public PasswordManager() {
		this.lib = new TreeMap<String,String>();
	}
	
	public int readFile(String filename) throws IOException{
		BufferedReader reader;
		int counter = 0;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				// read next line
				// split the line using spaces, the result is the user in 0
				String[] first_split = line.split(" ");
				// split the line using #, the result is the password in 0
				String[] second_split = first_split[1].split("#");
				//insert the username and password into the map
				this.lib.put(first_split[0],second_split[0]);
				//advance the line iterator
				line = reader.readLine();
				counter ++;
			}
			reader.close();
		} catch (IOException e) {
		}
		return counter;
	}
	
	public void writeFile(String filename) throws IOException{ 
		FileWriter writer = new FileWriter(new File(filename));
		try {
			//iterate over the map
			for (Map.Entry<String,String> entry : lib.entrySet()) { 
				//write one username and password in every line
	            writer.write(entry.getKey() + " " + entry.getValue() + "\n"); 
			}
			writer.close();
		} catch (IOException e) {
		}
	}
	
	public void add(String name, String password) throws UserExistsException{
		//mix the password up
		String newPassword = calcSHA1(password);
		//check if the username already exists
		String pass = this.lib.get(name);
		if(pass!=null) {
			throw new UserExistsException("User exists");
		}else{
			this.lib.put(name,newPassword);
		}		
	}
	
	boolean checkPassword(String name, String password) {
		//iterate over the map
		for (Map.Entry<String,String> entry : lib.entrySet()) {
			//check if a set of username and password matches
			if(name.equals(entry.getKey()) && (calcSHA1(password)).equals(entry.getValue())){
				return true;
			}
		}
		return false;
	}
	
	public static String calcSHA1(String str) {
	    MessageDigest md;
	    String ret = "";
	    try {
	        md = MessageDigest.getInstance("SHA1");
	        md.update( str.getBytes() );
	        byte[] digest = md.digest();
	        for (byte b : digest) {
	            String hNum = Integer.toHexString(b & 0xFF );
	            if (hNum.length() == 1)
	                hNum = "0" + hNum;
	            ret = ret + hNum;
	        }
	    } catch (NoSuchAlgorithmException e) {
	        return null;
	    }
	    return ret;
	}
	
	public static void main(String[] args) {
		PasswordManager pm1 = new PasswordManager();
		PasswordManager pm2 = new PasswordManager();
		try {
		    pm1.add("user1", "secret1");
		    pm1.add("user2", "secret2");
		    pm1.add("user3", "secret3");
		    pm1.add("user4", "secret4");
		    System.out.println("Test1 - directly added:");
		    System.out.println("Should be " + true + ": " +
		            pm1.checkPassword("user1", "secret1"));
		    System.out.println("Should be " + true + ": " +
		            pm1.checkPassword("user3", "secret3"));
		    System.out.println("Should be " + false + ": " +
		            pm1.checkPassword("user2", "secet2"));
		    System.out.println("Should be " + false + ": " +
		            pm1.checkPassword("uer1", "secret1"));
		    pm1.writeFile("passwords.txt");
		} catch (UserExistsException e) {
		    System.out.println("Error: a user already exists. ");
		} catch (IOException e) {
		    System.out.println(e);
		    return;
		}	
		try {
		    pm2.readFile("passwords.txt");
		    System.out.println("Test2 - loaded:");
		    System.out.println("Should be " + true + ": " +
		            pm2.checkPassword("user1", "secret1"));
		    System.out.println("Should be " + true + ": " +
		            pm2.checkPassword("user3", "secret3"));
		    System.out.println("Should be " + false + ": " +
		            pm2.checkPassword("user2", "secet2"));
		    System.out.println("Should be " + false + ": " +
		            pm2.checkPassword("uer1", "secret1"));
		} catch (IOException e) {
		    System.out.println(e);
		    return;
		}

	}
}
