

public class IterativeStringList implements StringList {
	
	private IterativeNode head;
	
	public IterativeStringList(){
		this.head = null;
	}
	
	public void addToEnd(String element) {
		
		if(this.head == null){
			this.head = new IterativeNode(element, null);
		}
		else{
			IterativeNode cur = this.head;
			while(cur.getNext()!=null){
				cur = cur.getNext();
			}
			cur.setNext(new IterativeNode(element, null));
		}
	}

	public void add(int index, String element) {

		if(this.head==null){
			if(index==0)
				this.head = new IterativeNode(element,null);
			else
				throw new IndexOutOfBoundsException();
		}
		else{
			if(index==0)
				head = new IterativeNode(element, head);
			else{
				IterativeNode cur = this.head;
				int i = 1;
				while(i<index){
					if(cur == null)
						throw new IndexOutOfBoundsException();
					cur = cur.getNext();
					i++;
				}			
				cur.setNext(new IterativeNode(element,cur.getNext()));
			}
		}
	}

	public String remove(int index) {
		IterativeNode cur=this.head;
		if (index<0)
			throw new IndexOutOfBoundsException();
		else if (index==0){
			if(this.head == null)
				throw new IndexOutOfBoundsException();
			else
				this.head=this.head.getNext();
		}
		else{
			int i = 0;
			while(i<index-1){
				cur = cur.getNext();
				i++;
				if(cur == null)
					throw new IndexOutOfBoundsException();
			}
			if (cur.getNext()==null)
				throw new IndexOutOfBoundsException();
			else if(cur.getNext().getNext()==null){
				IterativeNode idk = cur.getNext();
				cur.setNext(null);
				cur = idk;
			}
			else{
				IterativeNode idk = cur.getNext();
				cur.setNext(cur.getNext().getNext());
				cur = idk;
			}
		}
		return cur.getString();
	}

	public String get(int index) {
		if (index<0 || index>this.size()-1)
			throw new IndexOutOfBoundsException();
		IterativeNode cur = this.head;
		for(int i=-1;i<index-1;i++){
			if(cur.getNext()!=null)
				cur=cur.getNext();
		}
		return cur.getString();
	}

	public int indexOf(String element) {
		int i = 0;
		IterativeNode cur = this.head;
		if(element==cur.getString())
			return i;
		while(cur.getNext() != null){
			cur = cur.getNext();
			i++;
			if(element.equals(cur.getString()))
				return i;		
		}
		throw new IndexOutOfBoundsException();
	}

	public int size() {		
		int i = 0;
		IterativeNode cur = this.head;
		while(cur != null){
			cur = cur.getNext();
			i++;
		}
		return i;
	}

	public StringList toLowerCase() {
		IterativeNode cur = this.head;
		StringList n = new IterativeStringList();
		while(cur != null)
		{
			n.addToEnd(cur.getString().toLowerCase());
			cur = cur.getNext();
		}
		return n;
	}

	public StringList toUpperCase() {
		IterativeNode cur = this.head;
		IterativeStringList n = new IterativeStringList();
		while(cur != null){
			n.addToEnd(cur.getString().toUpperCase());
			cur = cur.getNext();
		}
		return n;
	}

	public StringList startsWith(String prefix) {
		IterativeNode cur = this.head;
		IterativeStringList n = new IterativeStringList();
		while(cur != null){
			if(cur.getString().startsWith(prefix))
				n.addToEnd(cur.getString());
			cur = cur.getNext();
		}
		return n;
	}

	public StringList hasSubstring(String substring) {
		IterativeNode cur = this.head;
		IterativeStringList n = new IterativeStringList();
		while(cur != null){
			if(cur.getString().contains(substring))
				n.addToEnd(cur.getString());
			cur = cur.getNext();
		}
		return n;
	}

}

