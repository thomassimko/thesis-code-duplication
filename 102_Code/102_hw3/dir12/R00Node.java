public class R00Node implements Node {
	
	private String string;
	private Node next;
		
	public R00Node(String word, Node give){
		this.string = word;
		this.next = give;
	}
	
	public String getString() {
		return string;
	}

	public Node getNext() {
		return next;
	}
	
	public void setNext(Node n) {
		next = n;
	}

	public Node addToEnd(String element) {
		Node cur = this;
		while(cur.getNext() instanceof R00Node){
			cur=cur.getNext();
		}
		cur.setNext(new R00Node(element,cur.getNext()));
		return cur.getNext();
	}

	public void add(String element) {
		this.next = new R00Node(element, this.getNext());
	}

	public String remove(int index) {
		Node cur = this;
		Node idk;
		int i = 0;
		while(i<index-1){
			cur = cur.getNext();
			i++;
			if(cur instanceof R00Empty)
				throw new IndexOutOfBoundsException();
		}
		idk = cur.getNext();
		cur.setNext(cur.getNext().getNext());
		cur = idk;
		return idk.getString();
	}

	public String get(int index) {

		Node cur = this;
		for(int i=-1;i<index-1;i++){
			if(cur.getNext() instanceof R00Node)
				cur=cur.getNext();
		}
		return cur.getString();
	}

	public int indexOf(String element) {

		int i = 0;
		Node cur = this;
		if(element.equals(cur.getString()))
			return i;
		while(cur.getNext() instanceof R00Node){
			cur = cur.getNext();
			i++;
			if(element.equals(cur.getString()))
				return i;		
		}
		throw new IndexOutOfBoundsException();
	}

	public int size() {

		return 0;
	}

	public StringList toLowerCase() {
		StringList k = new RecursiveOOStringList();
		Node cur = this;
		
		while(cur instanceof R00Node)
		{
			k.addToEnd(cur.getString().toLowerCase());
			cur = cur.getNext();
		}
	
		return k;
	}

	public StringList toUpperCase() {
		StringList k = new RecursiveOOStringList();
		Node cur = this;
		
		while(cur instanceof R00Node)
		{
			k.addToEnd(cur.getString().toUpperCase());
			cur = cur.getNext();
		}
	
		return k;
	}

	public StringList startsWith(String prefix) {
		StringList k = new RecursiveOOStringList();
		Node cur = this;
		
		while(cur instanceof R00Node)
		{
			if (cur.getString().startsWith(prefix))
				k.addToEnd(cur.getString());
			cur = cur.getNext();
		}
	
		return k;
	}

	public StringList hasSubstring(String substring) {
		StringList k = new RecursiveOOStringList();
		Node cur = this;
		
		while(cur instanceof R00Node)
		{
			if(cur.getString().contains(substring))
				k.addToEnd(cur.getString());
			cur = cur.getNext();
		}
	
		return k;
	}

}
