import java.util.ArrayList;

public class RemoveDuplicates {
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> newList = new ArrayList<E>();
		newList.addAll(list);
		for(int i = 0; i < newList.size(); i++) {
			for(int j = i+1; j < newList.size(); j++) {
				if(newList.get(i) == newList.get(j)) newList.remove(j);
			}
		}
		return newList;
	}
	
	public static void main (String[]args) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(10);
		test.add(10);
		test.add(20);
		test.add(90);
		test.add(20);
		System.out.println(removeDuplicates(test));
	}
	
}
