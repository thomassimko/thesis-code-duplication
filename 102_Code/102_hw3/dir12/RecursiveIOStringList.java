
public class RecursiveIOStringList implements StringList {

	RecursiveIONode head;
	
	public RecursiveIOStringList(){
		head = new RIOEmpty();
	}
	
	public void addToEnd(String element) {
		if (head instanceof RIOEmpty)
			head = addToEndHelper(element, head);
		else
			addToEndHelper(element, head);
	}

	public void add(int index, String element) {
		
		if(this.size()<index)
			throw new IndexOutOfBoundsException();
		if(head instanceof RIOEmpty){
			if(index==0)
				this.head = addHelper(index, element, head);
			else
				throw new IndexOutOfBoundsException();
		}
		else{
			if(index==0)
				this.head = addHelper(index, element, head);
			else{
				addHelper(index, element, head);
				}			
		}
	}

	public String remove(int index) {
		
		return null;
	}

	public String get(int index) {
		
		if (index<0)
			throw new IndexOutOfBoundsException();
		return getHelper(index, head);
	}

	public int indexOf(String element) {

		return 0;
	}

	public int size() {

		return sizeHelper(0,head);
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
	
	private RecursiveIONode addToEndHelper(String element, RecursiveIONode n){
		if(n instanceof RIOEmpty)
			return new RIONode(element, n);
		return addToEndHelper(element,n.getNext()); 
	}
	
	private RecursiveIONode addHelper(int index ,String element, RecursiveIONode n){
		if (n instanceof RIOEmpty)
			throw new IndexOutOfBoundsException();
		if(index==0){
			return new RIONode(element, n);
		}
		return addHelper(index-1,element,n.getNext());
	}
	
	private String getHelper(int index, RecursiveIONode n){
		if (n instanceof RIOEmpty)
			throw new IndexOutOfBoundsException();
		if(index==0){
			return n.getString();
		}
		return getHelper(index-1,n.getNext());
	}
	
	private int sizeHelper(int i,RecursiveIONode n){
		if(n instanceof RIOEmpty)
			return i;
		return sizeHelper(i++,n.getNext());
	}

}

