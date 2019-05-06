
public class RecursiveOOStringList implements StringList {
	
	private RecursiveOONode head;
	
	public RecursiveOOStringList() {
		head = new ROOEmpty();
	}

	@Override
	public void addToEnd(String element) {
		// TODO Auto-generated method stub
		head = head.addToEnd(element);
	}
	
	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		head = head.add(index, element);
	}

	@Override
	public String remove(int index) {
		// TODO Auto-generated method stub
		String s = get(index);
		head = head.remove(index);
		return s;
	}
	
	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		return head.get(index);
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		return head.indexOf(element);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return head.size();
	}

	@Override
	public StringList toLowerCase() {
		// TODO Auto-generated method stub
		RecursiveOOStringList newList = new RecursiveOOStringList();
		newList.changeHead(head.toLowerCase());
		return (StringList) newList;
	}

	@Override
	public StringList toUpperCase() {
		// TODO Auto-generated method stub
		RecursiveOOStringList newList = new RecursiveOOStringList();
		newList.changeHead(head.toUpperCase());
		return (StringList) newList;
	}
	
	@Override
	public StringList startsWith(String prefix) {
		// TODO Auto-generated method stub
		RecursiveOOStringList newList = new RecursiveOOStringList();
		newList.changeHead(head.startsWith(prefix));
		return (StringList) newList;
	}
	
	@Override
	public StringList hasSubstring(String substring) {
		// TODO Auto-generated method stub
		RecursiveOOStringList newList = new RecursiveOOStringList();
		newList.changeHead(head.hasSubstring(substring));
		return (StringList) newList;
	}
	
	public void changeHead(RecursiveOONode n) {
		head = n;
	}
}
