
public class IterativeStringList implements StringList {
	
	private IterativeNode head;
	private int counter;
	
	private class IterativeNode {

		private String element;
		private IterativeNode next;
		
		public IterativeNode(String element, IterativeNode next) {
			this.element = element;
			this.next = next;
		}
		
		public String getElement() {
			return element;
		}
		
		public IterativeNode getNode() {
			return next;
		}
		
		public void setNext(IterativeNode n) {
			this.next = n;
		}
	}
	
	public IterativeStringList() {
		head = null;
		counter = 0;
	}
	
	@Override
	public void addToEnd(String element) {
		// TODO Auto-generated method stub
		IterativeNode n = new IterativeNode(element, null);
		if(head == null) {
			this.head = n;
		}
		else {
			IterativeNode cur = this.head;
			
			while(cur.getNode() != null) {
				cur = cur.getNode();
			}
			cur.setNext(n);
		}
		counter++;
	}

	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		if(head == null) {
			if(index == 0) {
				this.head = new IterativeNode(element, null);
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
		else {
			if(index == 0) {
				this.head = new IterativeNode(element, head);
			}
			else if(index > 0) {
				IterativeNode cur = head;
				for(int i=1; i<index && cur != null; i++) {
					cur = cur.getNode();
				}
				if(cur == null) {
					throw new IndexOutOfBoundsException();
				}
				else {
					IterativeNode n = new IterativeNode(element, cur.getNode());
					cur.setNext(n);
				}
			}
		}
		counter++;
	}

	@Override
	public String remove(int index) {
		// TODO Auto-generated method stub
		IterativeNode cur;
		cur = head;
		if(index == 0) {
			head = head.next;
			counter--;
			return cur.getElement();
		}
		else {
			if(index == size()-1) {
				for(int i=0; i<index; i++) {
					cur = cur.next;
				}
				cur.next = null;
				counter--;
				return cur.getElement();
			}
			else {
				for(int i=1; i<index; i++) {
					cur = cur.next;
				}
				IterativeNode temp = cur.next;
				cur.setNext(cur.getNode().getNode());
				counter--;
				return temp.getElement();
			}
		}
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		IterativeNode cur;
		cur = head;
		if(index >=0 && index <= size()) {
			for(int i=0; i<index; i++) {
				cur = cur.next;
			}
		}
		else {
			throw new IndexOutOfBoundsException();
		}
		return cur.getElement();
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		IterativeNode cur;
		cur = head;
		for(int i=0; i<size(); i++) {
			if(cur.element.equals(element)) {
				return i;
			}
			cur = cur.next;
		}
		throw new IndexOutOfBoundsException("Element does not match");
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return counter;
	}

	@Override
	public StringList toLowerCase() {
		// TODO Auto-generated method stub
		IterativeStringList newList = new IterativeStringList();
		IterativeNode cur;
		cur = head;
		while(cur != null) {
			String s = cur.getElement();
			s = s.toLowerCase();
			newList.addToEnd(s);
			cur = cur.next;
		}
		return newList;
	}

	@Override
	public StringList toUpperCase() {
		// TODO Auto-generated method stub
		IterativeStringList newList = new IterativeStringList();
		IterativeNode cur;
		cur = head;
		while(cur != null) {
			String s = cur.getElement();
			s = s.toUpperCase();
			newList.addToEnd(s);
			cur = cur.next;
		}
		return newList;
	}

	@Override
	public StringList startsWith(String prefix) {
		// TODO Auto-generated method stub
		IterativeStringList newList = new IterativeStringList();
		IterativeNode cur;
		cur = head;
		while(cur != null) {
			String s = cur.getElement();
			if(s.startsWith(prefix)) {
				newList.addToEnd(s);
			}
			cur = cur.next;
		}
		return newList;
	}

	@Override
	public StringList hasSubstring(String substring) {
		// TODO Auto-generated method stub
		IterativeStringList newList = new IterativeStringList();
		IterativeNode cur;
		cur = head;
		while(cur != null) {
			String s = cur.getElement();
			if(s.indexOf(substring) > 0) {
				newList.addToEnd(s);
			}
			cur = cur.next;
		}
		return newList;
	}

}
