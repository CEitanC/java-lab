package circle;



public class Circle {
	private double centerX;
	private double centerY;
	private double radius;
		
			
	public Circle(double centerX,double centerY,double radius){
			this.centerX= centerX;
			this.centerY=centerY;
			this.radius=radius;
			}
			
	public String toString() {
				return "o="+this.centerX+","+this.centerY+",r="+this.radius;
			}
	public boolean doesOverlap(Circle A ) {
				double d= Math.sqrt(Math.pow(this.centerX-A.centerX,2)+ Math.pow(this.centerY-A.centerY,2));
				if(d<(this.radius+A.radius)) {return true;}
				return false;
			}
		

public static void main(String[] args) {
	Circle A,B,C;
	A=new Circle(0.,0.,3.);
	B=new Circle(0.,5.,3.);
	C=new Circle(5.,3.,3.);
	
	System.out.println("A: " +A);
	System.out.println("B: " +B);
	System.out.println("C: " +C);
	
	System.out.println("AB: " + A.doesOverlap(B));
	System.out.println("BC: " + B.doesOverlap(C));
	System.out.println("AC: " + A.doesOverlap(C));

	
	
	}
}

