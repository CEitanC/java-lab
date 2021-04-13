package TenCounter;

public class TenCounter {
	private static int classCounter = 0;
	private int objectCounter = 0;
	
	public void next10() {
		int initial = classCounter*100 + objectCounter*10 +1;
		for(int counter = initial; counter<initial + 10; counter++) {
			if(counter>99) {
				System.out.print(counter + " ");
			}else if(counter > 9) {
				System.out.print("0" + counter + " ");
			}else {
				System.out.print("00" + counter + " ");
			}
		}
		System.out.println();
		classCounter++;
		objectCounter++;
	}
	
	public static void main(String[] args) {			
		TenCounter A = new TenCounter(); 
		TenCounter B = new TenCounter(); 
		TenCounter C = new TenCounter(); 
		
		A.next10(); 
		B.next10(); 
		C.next10(); 
		A.next10(); 
		A.next10(); 
	}
	
	
	
}
