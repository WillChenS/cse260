
public class GenericStackWithArray<E> {
	
	private Object [] list = new Object [1];
	
	public int getSize() {
		int count = 0;
		for(Object o:list) {
			if (o != null) count++;
		}
		return count;
	}
	
	long l = 345l;
	
	public E peek() {
		for(int i = list.length-1; i >= 0; i--) {
			if (list[i] != null) return (E)list[i];
		}
		return null;
	}
	
	public void push(E o) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == null) {
				list[i] = o;
				return;
			}
		}
		Object[] newList = new Object[list.length*2];
		for(int i = 0; i < list.length; i++) {
			newList[i]=list[i];
		}
		newList[list.length] = o;
		list = newList;
	}
	
	public E pop() {
		E result = null;
		for(int i = list.length-1; i >= 0; i--) {
			if (list[i] != null) {
				result = (E)list[i] ;
				list[i] = null;
				break;
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		String result = "Stack: ";
		for (Object o:list) {
			if (o != null) result += o.toString() + " ";
		}
		return result;
	}
	
	//a single line comment.
	
	public static void main (String[]args) {
		GenericStackWithArray<String> test = new GenericStackWithArray<String>();
		test.push("One");
		test.push("Two");
		test.push("Three");
		System.out.println(test.peek() + " Expected:Three");
		System.out.println(test.getSize() + " Expected:3");
		System.out.println(test.pop() + " Expected: Three");
		System.out.println(test.getSize() + " Expected:2");
		System.out.println(test.toString() + " Expected: stack: (objectstring)");
	}
	
	/* this is a bracketed comment.
	it encompasses multiple lines
	and should end on this one. */
	
}
