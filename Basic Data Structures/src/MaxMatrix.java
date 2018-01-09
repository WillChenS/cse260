
public class MaxMatrix {

	public static <E extends Comparable<E>> E max(E[][] list) {
		if(list.length == 0) return null;
		E max = list[0][0];
		for (int row = 0; row < list.length; row++) {
			for(int col = 0; col < list.length; col++) {
				if(max.compareTo(list[row][col]) < 0) max = list[row][col];
			}
		}
		return max;
	}
	
	public static void main (String[]args) {
		Integer [][] test = {{5, 90, 20},{100, 67, 19}};		
		System.out.println(max(test));
	}
}
