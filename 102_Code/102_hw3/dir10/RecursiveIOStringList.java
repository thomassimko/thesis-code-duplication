import java.util.NoSuchElementException;


public class RecursiveIOStringList implements StringList {
	private RecursiveIONode head;
	
	public RecursiveIOStringList () {
		head = new RIOEmpty();
	}
	
	private RecursiveIONode addToEndHelper (String element, RecursiveIONode cur) {
		if (cur instanceof RIOEmpty) {
			RecursiveIONode n = new RIONode(element, cur);
			return n;
		}
		else {
			RecursiveIONode n = addToEndHelper(element, cur.getNext());
			cur.setNext(n);
			return cur;
		}
	}
	
	public void addToEnd(String element) {
		head = addToEndHelper(element, head);

	}
	
	private RecursiveIONode addHelper (int index, String element, RecursiveIONode cur) {
		if (cur instanceof RIOEmpty && index == 0) {
			RIONode n = new RIONode(element, cur); /*CHANGE BACK TO CUR FOR RIONODE'S LAST PARAM*/
			return n;
		}
		else if (cur instanceof RIONode) {
			if (index == 0) {
				return new RIONode(element, cur);
			}
			else {
				RecursiveIONode n = addHelper(index-1, element, cur.getNext());
				cur.setNext(n); /* COULD BE GET NEXT*/
				return cur;
			}
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public void add(int index, String element) {
		head = addHelper(index, element, head);

	}
	private RecursiveIONode removeHelper(int index, RecursiveIONode cur) {
		if (cur instanceof RIOEmpty) {
			throw new IndexOutOfBoundsException();
		}
		else {
			if (index > 0) {
				RecursiveIONode n = removeHelper(index-1, cur.getNext());
				cur.setNext(n);
				return cur;
			}
			else if (index == 0) {
				return cur = cur.getNext();
			}
			else {
				throw new IndexOutOfBoundsException();
			}
		}
	}
	
	@Override
	public String remove(int index) {
		return removeHelper(index, head).getString();
	}

	private RecursiveIONode getHelper(int index, RecursiveIONode cur) {
		if (cur instanceof RIOEmpty) {
			throw new IndexOutOfBoundsException();
		}
		else {
			if (index == 0) {
				return cur;
			}
			else {
				return getHelper(index-1, cur.getNext());
			}
		}
	}
	
	public String get (int index) {
		RecursiveIONode n = getHelper(index, head);
		if (n instanceof RIOEmpty) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return n.getString();
		}
	}
	
	private int indexOfHelper (String element, RecursiveIONode cur) {
		if (cur instanceof RIOEmpty) {
			throw new NoSuchElementException();
		}
		else {
			if (cur.getString().equals(element) ==  true) {
				return 0;
			}
			else {
				cur = cur.getNext();
				return 1 + indexOfHelper(element, cur);
			}
		}
	}
	
	@Override
	public int indexOf(String element) {
		return indexOfHelper(element, head);
	}

	private int sizeHelper(RecursiveIONode cur) {
		int i = 0;
		while (cur instanceof RIONode) {
			i++;
			cur = cur.getNext();
		}
		return i;
	}
	public int size() {
		return sizeHelper(head);
	}

	private RecursiveIOStringList toLowerCaseHelper(RecursiveIONode cur, RecursiveIOStringList newList) {
		if (cur instanceof RIONode) {
			newList.addToEnd(cur.getString().toLowerCase());
			 return toLowerCaseHelper(cur.getNext(), newList);
		}
		else {
			return newList;
		}
	}
	
	@Override
	public StringList toLowerCase() {
		RecursiveIOStringList newList = new RecursiveIOStringList();
		RecursiveIOStringList newList1 = toLowerCaseHelper(head, newList);
		return newList1;
	}

	private RecursiveIOStringList toUpperCaseHelper(RecursiveIONode cur, RecursiveIOStringList newList) {
		if (cur instanceof RIONode) {
			newList.addToEnd(cur.getString().toUpperCase());
			 return toUpperCaseHelper(cur.getNext(), newList);
		}
		else {
			return newList;
		}
	}
	
	@Override
	public StringList toUpperCase() {
		RecursiveIOStringList newList = new RecursiveIOStringList();
		RecursiveIOStringList newList1 = toUpperCaseHelper(head, newList);
		return newList1;
	}

	private RecursiveIOStringList startsWithHelper(String prefix, RecursiveIONode cur, RecursiveIOStringList newList) {
		if (cur instanceof RIONode) {
			if (cur.getString().startsWith(prefix) == true) {
				newList.addToEnd(cur.getString());
			}
			return startsWithHelper(prefix, cur.getNext(), newList);
		}
		else {
			return newList;
		}
	}
	
	@Override
	public StringList startsWith(String prefix) {
		RecursiveIOStringList newList = new RecursiveIOStringList();
		RecursiveIOStringList newList1 = startsWithHelper(prefix, head, newList);
		return newList1;
	}

	private RecursiveIOStringList hasSubstringHelper(String substring, RecursiveIONode cur, RecursiveIOStringList newList) {
		if (cur instanceof RIONode) {
			if (cur.getString().indexOf(substring) > 0) {
				newList.addToEnd(cur.getString());
			}
			return hasSubstringHelper(substring, cur.getNext(), newList);
		}
		else {
			return newList;
		}
	}
	
	@Override
	public StringList hasSubstring(String substring) {
		RecursiveIOStringList newList = new RecursiveIOStringList();
		RecursiveIOStringList newList1 = hasSubstringHelper(substring, head, newList);
		return newList1;
	}

}
