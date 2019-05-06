
public class RecursiveIOStringList implements StringList {
	
	private RecursiveIONode cur, head;
	
	public RecursiveIOStringList() {
		head = new RIOEmpty();
	}
	
	private RecursiveIONode addToEndHelper(String element, RecursiveIONode cur) {
		if(cur instanceof RIOEmpty) {
			RecursiveIONode n = new RIONode(element, cur);
			return n;
		}
		else {
			RecursiveIONode n = addToEndHelper(element, cur.getNode());
			cur.setNext(n);
			return cur;
		}
	}
	
	private RecursiveIONode addHelper(int index, String element, RecursiveIONode cur) {
		if(cur instanceof RIOEmpty && index == 0) {
			RecursiveIONode n = new RIONode(element, cur);
			return n;
		}
		else if(cur instanceof RIONode) {
			if(index == 0) {
				RecursiveIONode n = new RIONode(element, cur);
				return n;
			}
			else {
				RecursiveIONode n = addHelper(index-1, element, cur.getNode());
				cur.setNext(n);
				return cur;
			}
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}

	private RecursiveIONode removeHelper(int index, RecursiveIONode cur) {
		if(cur instanceof RIOEmpty) {
			throw new UnsupportedOperationException();
		}
		else {
			if(index == 0) {
				return cur.getNode();
			}
			if(index > 0){
				RecursiveIONode n;
				n = removeHelper(index-1, cur.getNode());
				cur.setNext(n);
				return cur;
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
	}

	private RecursiveIONode getHelper(int index, RecursiveIONode cur) {
		if(cur instanceof RIOEmpty) {
			throw new UnsupportedOperationException();
		}
		else {
			if(index == 0) {
				return cur;
			}
			if(index > 0) {
				cur = getHelper(index-1, cur.getNode());
				return cur;
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
	}
	
	private int indexOfHelper(String element, RecursiveIONode cur) {
		if(cur instanceof RIOEmpty) {
			throw new UnsupportedOperationException();
		}
		else {
			if(cur.getElement().equals(element)) {
				return 0;
			}
			else {
				return 1 + indexOfHelper(element, cur.getNode());
			}
		}
	}
	
	private int sizeHelper(RecursiveIONode cur) {
		if(cur instanceof RIOEmpty) {
			return 0;
		}
		else {
			return 1 + sizeHelper(cur.getNode());
		}
	}

	private RecursiveIONode toLowerCaseHelper(RecursiveIONode cur) {
		if(cur instanceof RIOEmpty) {
			RecursiveIONode n = new RIOEmpty();
			return n;
		}
		else {
			RecursiveIONode temp = toLowerCaseHelper(cur.getNode());
			RecursiveIONode n = new RIONode(cur.getElement().toLowerCase(), temp);
			return n;
		}
	}
	
	private RecursiveIONode toUpperCaseHelper(RecursiveIONode cur) {
		if(cur instanceof RIOEmpty) {
			RecursiveIONode n = new RIOEmpty();
			return n;
		}
		else {
			RecursiveIONode temp = toUpperCaseHelper(cur.getNode());
			RecursiveIONode n = new RIONode(cur.getElement().toUpperCase(), temp);
			return n;
		}
	}
	
	private RecursiveIONode startsWithHelper(String prefix, RecursiveIONode cur) {
		if(cur instanceof RIOEmpty) {
			RecursiveIONode n = new RIOEmpty();
			return n;
		}
		else {
			RecursiveIONode n;
			if(cur.getElement().startsWith(prefix)) {
				n = new RIONode(cur.getElement(), startsWithHelper(prefix, cur.getNode()));
			}
			else {
				return startsWithHelper(prefix, cur.getNode());
			}
			return n;
		}
	}
	
	private RecursiveIONode hasSubstringHelper(String substring, RecursiveIONode cur) {
		if(cur instanceof RIOEmpty) {
			RecursiveIONode n = new RIOEmpty();
			return n;
		}
		else {
			RecursiveIONode n;
			if(cur.getElement().indexOf(substring) > 0) {
				n = new RIONode(cur.getElement(), hasSubstringHelper(substring, cur.getNode()));
			}
			else {
				return hasSubstringHelper(substring, cur.getNode());
			}
			return n;
		}
	}
	
	@Override
	public void addToEnd(String element) {
		// TODO Auto-generated method stub
		head = addToEndHelper(element, head);
	}

	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		head = addHelper(index, element, head);
	}

	@Override
	public String remove(int index) {
		// TODO Auto-generated method stub
		head = removeHelper(index, head);
		return head.getElement();
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		cur = getHelper(index, head);
		return cur.getElement();
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		return indexOfHelper(element, head);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return sizeHelper(head);
	}

	@Override
	public StringList toLowerCase() {
		// TODO Auto-generated method stub
		RecursiveIOStringList newList = new RecursiveIOStringList();
		newList.changeHead(toLowerCaseHelper(head));
		return (StringList) newList;
	}

	@Override
	public StringList toUpperCase() {
		// TODO Auto-generated method stub
		RecursiveIOStringList newList = new RecursiveIOStringList();
		newList.changeHead(toUpperCaseHelper(head));
		return (StringList) newList;
	}

	@Override
	public StringList startsWith(String prefix) {
		// TODO Auto-generated method stub
		RecursiveIOStringList newList = new RecursiveIOStringList();
		newList.changeHead(startsWithHelper(prefix, head));
		return (StringList) newList;
	}

	@Override
	public StringList hasSubstring(String substring) {
		// TODO Auto-generated method stub
		RecursiveIOStringList newList = new RecursiveIOStringList();
		newList.changeHead(hasSubstringHelper(substring, head));
		return (StringList) newList;
	}
	
	public void changeHead(RecursiveIONode n) {
		head = n;
	}

}
