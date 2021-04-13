package NUMLIST;
import java.util.*;

public class NumList {

	private LinkedList<Integer> list;
	
	public NumList() {
		this.list = new LinkedList<Integer>();
	}
	
	public NumList(List<Integer> list) {
		this.list = new LinkedList<Integer>(list);
	}
	
	public void add(int num) {
		list.add(num);
	}
	
	public void add(List<Integer> list) {
		this.list.addAll(list);
	}
	
	public int getSum() {
		int sum = 0;
		for(int i : list) {
			sum += i;
		}
		return sum;
	}
	
	public int getProduct() {
		int product = 1;
		for(int i : list) {
			product *= i;
		}
		return product;
	}
	
	public int getSqrSum() {
		int sqrSum = 0;
		for(int i : list) {
			sqrSum += Math.pow(i, 2);
		}
		return sqrSum;
	}
	
	public static void main(String[] args) {
		Integer[] nums = {1,2};
		Integer[] newNums = {4,5};
		NumList numList = new NumList(Arrays.asList(nums));
		
		numList.add(3);
		numList.add(Arrays.asList(newNums));
		
		System.out.println("Sum: " + numList.getSum());
		System.out.println("Product: " + numList.getProduct());
		System.out.println("Square Sum: " + numList.getSqrSum());
		
	}
	
}
