
public class R00Empty implements Node {

	private String string;
	private Node next;
	
	public R00Empty(){
		this.string = null;
		this.next = null;
	}
	
	public String getString() {
		return string;
	}

	public Node getNext() {
		return next;
	}

	public Node addToEnd(String element) {
		return new R00Node(element,this);
	}

	public void add(String element) {
		new R00Node(element,this);
	}

	public String remove(int index) {
		
		return null;
	}

	public String get(int index) {

		return null;
	}

	public int indexOf(String element) {

		return 0;
	}

	@Override
	public int size() {

		return 0;
	}

	public StringList toLowerCase() {

		return null;
	}

	public StringList toUpperCase() {

		return null;
	}

	public StringList startsWith(String prefix) {

		return null;
	}

	public StringList hasSubstring(String substring) {
	
			 return null;
	}

	public void setNext(Node n) { 
		
	}

}
