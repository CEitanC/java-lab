package LOGNET;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


public class logNet {
	private TreeMap<String,logicGate> net;
	private LinkedList<logicGate> edges;
	private LinkedList<output> outs; 			

	public void activateNet() {
		for(output i : outs) {
			logicGate CurrentGate = i.getInput1();
					CurrentGate.calculateOutput();	
			
		}
	}
	
	public void printNet() {
		for (Map.Entry<String,logicGate> entry : net.entrySet()) { 
			System.out.println(entry.getKey() + " output: " + entry.getValue().getOutput()); 
		}
	}
	
	public logNet() {
		this.net = new TreeMap<String,logicGate>();
		this.edges = new LinkedList<logicGate>();
		this.outs = new LinkedList<output>();
	}
	
	
	public void parser(String filename) throws IOException{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				//ignore empty lines
				if(line.trim().length() > 0) {
					// read next line
					// split the line 
					String[] arr = line.split(" ");
					switch(arr[0]) {
					case "AND":
						and newAnd = new and();
						this.net.put(arr[1],newAnd);
						break;
					case "OR":
						or newOr = new or();
						this.net.put(arr[1],newOr);
						break;
					case "NOT":
						not newNot = new not();
						this.net.put(arr[1],newNot);
						break;
					case "XOR":
						xor newXor = new xor();
						this.net.put(arr[1],newXor);
						break;
					default:
						String[] arg1 = arr[0].split("\\.");
						String[] arg2 = arr[1].split("\\.");
						String[] arg3 = arg2[1].split("\\[");
						if(arg1[0].equals("1")) {
							one newOne = new one();
							edges.add(newOne);
							if(arg2[0].equals("output")) {
								output newOutput = new output();
							///	edges.add(newOutput);
								outs.add(newOutput); 					
								newOutput.connect1(newOne);
							}else {
								logicGate g = this.net.get(arg2[0]);
								if(arg3[1].charAt(0)=='0') {
									g.connect1(newOne);
								}else {
									g.connect2(newOne);
								}
							}
						}
						else if(arg1[0].equals("0")) {
							zero newZero = new zero();
							edges.add(newZero);
							if(arg2[0].equals("output")) {
								output newOutput = new output();
								//edges.add(newOutput);
								outs.add(newOutput); 					
	
								newOutput.connect1(newZero);
							}else {
								logicGate g = this.net.get(arg2[0]);
								if(arg3[1].charAt(0)=='0') {
									g.connect1(newZero);
								}else {
									g.connect2(newZero);
								}
							}
						}else {
							logicGate in_g = this.net.get(arg1[0]);
							if(arg2[0].equals("output")) {
								output newOutput = new output();
								//edges.add(newOutput);
								outs.add(newOutput); 					
	
								newOutput.connect1(in_g);
							}else {
								logicGate g = this.net.get(arg2[0]);
								if(arg3[1].charAt(0)=='0') {
									g.connect1(in_g);
								}else {
									g.connect2(in_g);
								}
							}
						}
						break;
						
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
		logNet ln = new logNet();
		try {
			ln.parser("testlog.txt");
		    System.out.println("Test1 - loaded:");
		    ln.activateNet();
		    ln.printNet();
		} catch (IOException e) {
		    System.out.println(e);
		    return;
		}

	}
}
