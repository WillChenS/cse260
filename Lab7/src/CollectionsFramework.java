import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsFramework {
	
	public static void main (String[]args) {
		linkedIterationTest((int)(Math.pow(10, 2)*5));
	}

	public static void linkedIterationTest(int count) {
		
		//generate list
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < count; i++) {
			list.add((int)(Math.random()*100));
		}
		
		//time get()
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < count; i++) {
			list.get(i);
			System.out.println("ping");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("The get() method took: " + (endTime-startTime) + " ms.");
		
		//time iterator()
		startTime = System.currentTimeMillis();
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			it.next();
		}
		endTime = System.currentTimeMillis();
		System.out.println("The iterator method took: " + (endTime-startTime) + " ms.");
	}
	
	public static void collectionComparison(int count) {
		
		//generate collections
		LinkedList<Integer> linked = new LinkedList<Integer>();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		int [] arr = new int [count];
		for(int i = 0; i < count; i++) {
			linked.add((int)(Math.random()*100));
			arrList.add((int)(Math.random()*100));
			arr[i] = (int)(Math.random()*100);
		}
		
		//insert, traverse and delete
		long startTime = System.currentTimeMillis();
		int
		long endTime = System.currentTimeMillis();
		System.out.println("Array insertion: " + (endTime-startTime) + " ms.");
	}
	

	
}
