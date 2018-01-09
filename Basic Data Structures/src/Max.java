
public class Max {
	
	public static <E extends Comparable<E>> E max(E[] list) {
		if(list.length == 0) return null;
		E max = list[0];
		for (E element:list) {
			if(max.compareTo(element) < 0) max = element;
		}
		return max;
	}
	
	public static void main (String[]args) {
		Integer [] test = {5, 9, 10, 200, 60, 50, 30, 70, 80, 90};
		System.out.println(max(test));
	}

}
