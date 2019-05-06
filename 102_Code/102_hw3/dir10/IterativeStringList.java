import java.util.NoSuchElementException;

public class IterativeStringList implements StringList {
	private IterativeNode head;
	private IterativeNode next;
	
	public IterativeStringList(){
		this.head = null;
	}
	
	@Override
	public void addToEnd(String element) {
		IterativeNode n = new IterativeNode(element, null);
		if(this.head == null){
			this.head = n;
		}
		else{
			IterativeNode cur = this.head;
			while(cur.getNext() != null){
				cur = cur.getNext();
			}
			cur.setNext(n);
		}
		
	}
	
	@Override
	public void add(int index, String element) {
		if (this.head == null){
			if (index == 0) {
				this.head = new IterativeNode(element, null);
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
		else {
			if (index == 0){
				this.head = new IterativeNode(element, this.head);
			}
			else if (index < 0) {
				throw new IndexOutOfBoundsException();
			}
			else {
				IterativeNode cur = this.head;
				for (int i=0; i<index && cur != null; i++){
					cur = cur.getNext();
					if (cur == null) {
						throw new IndexOutOfBoundsException();
					}
					else {
						IterativeNode n = new IterativeNode(element, cur.getNext());
						cur.setNext(n);
					}
				}
			}
		}

	}

	@Override
	public String remove(int index) {
		IterativeNode temp;
		IterativeNode cur = this.head;
		if (index == 0){
			temp = head;
			head = head.getNext();
			return temp.getString();
		}
		else if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			
			for (int i = 0; i < index - 1; i++) {
				if (cur == null) {
					throw new IndexOutOfBoundsException();
				}
				cur = cur.getNext();
			}
			if (cur.getNext() == null) {
				cur.setNext(null);
				return cur.getString();
			}
			
			temp = cur.getNext();
			cur.setNext(cur.getNext().getNext());
			return temp.getString();
		}
	}

	@Override
	public String get(int index) {
		IterativeNode cur = this.head;
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0) {
			return head.getString();
		}
		else {
			for (int i = 0; i < index; i++) {
				cur = cur.getNext();
			}
			if (cur == null) {
				throw new IndexOutOfBoundsException();
			}
			else {
				return cur.getString();
			}
		}
	}

	@Override
	public int indexOf(String element) {
		IterativeNode cur = this.head;
		for (int i = 0; cur != null; i++) {
			if (cur.getString().equalsIgnoreCase(element) == true) {
				return i;
			}
			cur = cur.getNext();
		}
		throw new NoSuchElementException();
	}

	@Override
	public int size() {
		IterativeNode cur = this.head;
		int i = 0;
		while (cur != null){
			i++;
			cur = cur.getNext();
		}
		return i;
	}

	@Override
	public IterativeStringList toLowerCase() {
		IterativeStringList newList = new IterativeStringList();
		IterativeNode cur;
		for (cur = head; cur != null; cur = cur.getNext()) {
			newList.addToEnd(cur.getString().toLowerCase());
		}
		return newList;
	}

	@Override
	public IterativeStringList toUpperCase() {
		IterativeStringList newList = new IterativeStringList();
		IterativeNode cur;
		for (cur = head; cur != null; cur = cur.getNext()) {
			newList.addToEnd(cur.getString().toUpperCase());
		}
		return newList;
	}

	@Override
	public IterativeStringList startsWith(String prefix) {
		IterativeStringList prefixList = new IterativeStringList();
		IterativeNode cur;
		for (cur = head; cur != null; cur = cur.getNext()) {
			if (cur.getString().startsWith(prefix) == true) {
				prefixList.addToEnd(cur.getString());
			}
		}
		return prefixList;
	}

	@Override
	public IterativeStringList hasSubstring(String substring) {
		IterativeStringList subStringList = new IterativeStringList();
		IterativeNode cur;
		for (cur = head; cur != null; cur = cur.getNext()) {
			if (cur.getString().indexOf(substring) > 0) {
				subStringList.addToEnd(cur.getString());
			}
		}
		return subStringList;
	}

}
