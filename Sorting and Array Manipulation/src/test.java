import java.util.LinkedList;

public class test {
	
	public test() {
	}
	
	public static void blah(){
		
		Object o = (Object) new String("sa");
		LinkedList<Object> objects = (LinkedList<Object>) new LinkedList<String>();
		int[] ints = new int [10];
		ints[0] = 5;
		char[] chars = new char[10];
		chars[0] = new Character('c');
		
		Node<Circle> circleNode = new Node<>();
		Node<Shape> shapeNode = circleNode;
	}
	
	class Shape{/*...*/}

	class Circle extends Shape{/*...*/}

	class Rectangle extends Shape{/*...*/}

	class Node<T> {/*...*/}
	
	public class Pair<K,V>{

		private K key;

		private V value;

		public Pair(K key,V value){

		this.key=key;

		this.value=value;

		}

		public K getKey(){return key;}

		public V getValue(){return value;}

		public void setKey(K key) {this.key=key;}

		public void setValue(V value){this.value=value;}

		}
	
	public final class Algorithm{

		public Algorithm() {}
		
		public static <T> T max(T x,T y) {

		return x>y ? x : y;

		}

}
