
public class RecursiveOOStringList implements StringList {
	
	Node head;
	
	RecursiveOOStringList(){
		head = new R00Empty();
	}
	
	public void addToEnd(String element) {

		if (head instanceof R00Empty)
			head = head.addToEnd(element);
		else
			head.addToEnd(element);
	}

	public void add(int index, String element) {

		if(this.size()<index)
			throw new IndexOutOfBoundsException();
		if(head instanceof R00Empty){
			if(index==0)
				this.head = new R00Node(element,head);
			else
				throw new IndexOutOfBoundsException();
		}
		else{
			if(index==0)
				head = new R00Node(element, head);
			else{
				Node cur = this.head;
				int i = 0;
				while(i<index-1){
					cur = cur.getNext();			
					i++;
				}			
				cur.add(element);
			}
		}
	}

	public String remove(int index) {
		
		Node cur=this.head;
		if (index<0)
			throw new IndexOutOfBoundsException();
		else if (index==0){
			if(this.head instanceof R00Empty)
				throw new IndexOutOfBoundsException();
			else{
				this.head=this.head.getNext();
				return cur.getString();
			}
		}
		else{
			return head.remove(index);
			
		}
	}

	public String get(int index) {
		
		if (index<0 || index>this.size()-1)
			throw new IndexOutOfBoundsException();
		return head.get(index);

	}

	public int indexOf(String element) {
		
		int index = head.indexOf(element);
		
		return index;
	}

	public int size() {		
		int i = 0;
		Node cur = this.head;
		while(cur instanceof R00Node){
			cur = cur.getNext();
			i++;
		}
		return i;
	}

	public StringList toLowerCase() {
		
		return this.head.toLowerCase();
		
	}

	public StringList toUpperCase() {

		return this.head.toUpperCase();

	}

	public StringList startsWith(String prefix) {

		return this.head.startsWith(prefix);
	}

	
	public StringList hasSubstring(String substring) {
		
		return this.head.hasSubstring(substring);
	}

}

