
public class LinearSearch {

	public static<E extends Comparable<E>> int linearSearch(E[] list, E key) {
		for(int i = 0; i < list.length; i++) {
			if (list[i].compareTo(key) == 0) return i;
		}
		return -1;
	}
	
	public static void main (String[]args) {
		Integer [] test = {5, 9, 10, 200, 60, 50, 30, 70, 80, 90};
		System.out.println(linearSearch(test, 60));
	}
	
}
