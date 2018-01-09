public class BinarySearch {
	
	public static<E extends Comparable<E>> int binarySearch(E[] list, E key) {
		
		//sort the array
		for (int i = 0; i < list.length; i++) {
			for(int j = i+1; j < list.length; j++) {
				if (list[i].compareTo(list[j]) > 0) {
					E temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
		
		//binary search
				int low = 0;
				int high = list.length-1;
				int mid = (low+high)/2;
				boolean done = false;
				while(!done) {
					if(list[mid] == key) return mid;
					else if (list[mid].compareTo(key)>0) {
						high = mid-1;
						mid = (low+high)/2;
					}
					else if (list[mid].compareTo(key)<0) {
						low = mid+1;
						mid = (low+high)/2;
					}
					else done = true;
				}
				return -1;
			}

		
	
	public static void main (String[]args) {
		Integer [] test = {5, 9, 10, 200, 60, 50, 30, 70, 80, 90};
		System.out.println(binarySearch(test, 60));
	}

	
}
