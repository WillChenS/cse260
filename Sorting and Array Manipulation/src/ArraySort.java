import java.util.ArrayList;
public class ArraySort {
	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		for(int i = 0; i < list.size(); i++) {
			for(int j = i+1; j < list.size(); j++) {
				if ((list.get(i).compareTo(list.get(j)) >= 0)){
					E temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
	}
	
	public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		E max = list.get(0);
		for(E element:list) {
			if (element.compareTo(max) > 1) max = element;
		}
		return max;
	}
	
}
