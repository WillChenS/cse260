import java.util.ArrayList;
import java.util.Scanner;

public class GenericStackExtendsArrayList<E> extends ArrayList<E> {
	
	public int getSize() {
		return size();
	}
	
	public E peek() {
		return get(size()-1);
	}
	
	public void push(E o) {
		add(o);
	}
	
	public E pop() {
		return remove(size()-1);
	}
	
	@Override
	public String toString() {
		return "stack: " + super.toString();
	}
	
	public static void main (String[]args) {
		Scanner input = new Scanner(System.in);
		GenericStackExtendsArrayList<String> test = new GenericStackExtendsArrayList<String>();
		System.out.println("Input 5 strings");
		for(int i = 0; i < 5; i++) {
			if(input.hasNext()) test.push(input.next());
		}
		for(int j = 0; j < 5; j++) System.out.println(test.pop());
	}
	
}
