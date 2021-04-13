package ANIMAL_LIST;
import java.util.*;


public class Animal implements Comparable<Animal>{
	private String type;
	private String name;
	
	Animal(String type, String name){
		this.type = type;
		this.name = name;
	}
	
	public int compareTo(Animal A) {
		if(type.compareTo(A.type) != 0) {
			return type.compareTo(A.type);
		}else {
			return name.compareTo(A.name);
		}
	}
	
	public String toString() {
		return name + " the " + type;
	}
	
	public static void main(String[] args) {			
		Animal A = new Animal("donkey", "A");
		Animal B = new Animal("donkey", "B");
		Animal C = new Animal("dog", "C");
		Animal D = new Animal("cat", "D");
		Animal E = new Animal("cat", "E");
		Animal F = new Animal("fish", "F");
		
		TreeSet<Animal> animals = new TreeSet<Animal>();
		animals.add(A);
		animals.add(B);
		animals.add(C);
		animals.add(D);
		animals.add(E);
		animals.add(F);
		
		for(Animal i : animals) {
			System.out.println(i);
		}
		
	}
}
