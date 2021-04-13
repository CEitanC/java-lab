package LOGNET;

import LOGNET.logicGate;

abstract class logicGate {
	
	public abstract void connect1(logicGate gate);
	
	public abstract void connect2(logicGate gate);
	
	public abstract int getOutput();
	
	public abstract int getNumOfInputs();
	
	public abstract void calculateOutput();
}

class and extends logicGate{
	private logicGate input1;
	private logicGate input2;
	private int output = -1;
	private int numOfInputs = 2;
	
	public int getNumOfInputs() {
		return numOfInputs;
	};
	
	public void connect1(logicGate gate) {
		input1 = gate;
	};
	public void connect2(logicGate gate) {
		input2 = gate;
	};
	
	public int getOutput() {
		return this.output;
	};
	
	public void calculateOutput(){
		if((this.input1==null) || (this.input2==null)) {
			return;
		}
	/*	if((this.input1.GetOutput()==-1) || (this.input2.GetOutput()==-1)) {
			return;
		}
		*/
		if((this.input1.getOutput()==-1)){
			input1.calculateOutput();
		}
		
		if((this.input2.getOutput()==-1)){
			input2.calculateOutput();
		}
		
		this.output= this.input1.getOutput()&this.input2.getOutput();
	}
	
	public logicGate getInput1() {
		return input1;
	};
	
	public logicGate getInput2() {
		return input1;
	};
}

class or extends logicGate{
	private logicGate input1;
	private logicGate input2;
	private int output = -1;
	private int numOfInputs = 2;
	
	public int getNumOfInputs() {
		return numOfInputs;
	};
	public void connect1(logicGate gate) {
		input1 = gate;
	};
	public void connect2(logicGate gate) {
		input2 = gate;
	};
	
	public int getOutput() {
		return this.output;
	};
	
	public void calculateOutput(){
		if((this.input1==null) || (this.input2==null)) {
			return;
		}
	/*	if((this.input1.GetOutput()==-1) || (this.input2.GetOutput()==-1)) {
			return;
		}
	*/
		if((this.input1.getOutput()==-1)){
			input1.calculateOutput();
		}
		
		if((this.input2.getOutput()==-1)){
			input2.calculateOutput();
		}
		
		this.output= this.input1.getOutput()|this.input2.getOutput();
		
	}
	
	public logicGate getInput1() {
		return input1;
	};
	
	public logicGate getInput2() {
		return input1;
	};
}

class xor extends logicGate{
	private logicGate input1;
	private logicGate input2;
	private int output = -1;
	private int numOfInputs = 2;
	
	public int getNumOfInputs() {
		return numOfInputs;
	};
	
	public void connect1(logicGate gate) {
		input1 = gate;
	};
	public void connect2(logicGate gate) {
		input2 = gate;
	};
	
	public int getOutput() {
		return this.output;
	};
	
	public void calculateOutput(){
		if((this.input1==null) || (this.input2==null)) {
			return;
		}
	/*	if((this.input1.GetOutput()==-1) || (this.input2.GetOutput()==-1)) {
			return;
		}
	*/
		if((this.input1.getOutput()==-1)){
			input1.calculateOutput();
		}
		
		if((this.input2.getOutput()==-1)){
			input2.calculateOutput();
		}
		
		this.output= this.input1.getOutput()^this.input2.getOutput();
		
	}
	
	public logicGate getInput1() {
		return input1;
	};
	
	public logicGate getInput2() {
		return input1;
	};
}

class not extends logicGate{
	private logicGate input;
	private int output = -1;
	private int numOfInputs = 1;
	
	public int getNumOfInputs() {
		return numOfInputs;
	};
	
	public void connect1(logicGate gate) {
		input = gate;
	};
	public void connect2(logicGate gate) {
		return;
	};
	
	public int getOutput() {
		return this.output;
	};
	
	public void calculateOutput(){
		if(this.input==null) {
			return;
		}
	/*	if(this.input1.GetOutput()==-1) {
			return;
		}
	*/
		if((this.input.getOutput()==-1)){
			input.calculateOutput();
		}
		
		if(this.input.getOutput() == 0) {
			this.output = 1;
		}else {
			this.output = 0;
		}
		
		
	}
	
	public logicGate getInput1() {
		return input;
	};

}

class one extends logicGate{
	private int output = 1;
	private int numOfInputs = 0;
	
	public int getNumOfInputs() {
		return numOfInputs;
	};
	
	public void connect1(logicGate gate) {
		return;
	};
	public void connect2(logicGate gate) {
		return;
	};
	
	public int getOutput() {
		return this.output;
	};
	
	public void calculateOutput(){		
		this.output= 1;	
	}
}

class zero extends logicGate{
	private int output = 0;
	private int numOfInputs = 0;
	
	public int getNumOfInputs() {
		return numOfInputs;
	};
	
	public void connect1(logicGate gate) {
		return;
	};
	public void connect2(logicGate gate) {
		return;
	};
	
	public int getOutput() {
		return this.output;
	};
	public void calculateOutput(){		
		this.output= 0;	
	}
}

class output extends logicGate{
	private logicGate input;
	private int numOfInputs = 1;
	public int getNumOfInputs() {
		return numOfInputs;
	};
	
	public void connect1(logicGate gate) {
		input = gate;;
	};
	public void connect2(logicGate gate) {
		return;
	};
	
	public int getOutput() {
		return -1;
	};
	
	public void calculateOutput(){		
		return;	
	}
	
	public logicGate getInput1() {
		return input;
	};
	

}
