
public class Recursive00StringList implements StringList {

	private R00 head;
	public Recursive00StringList()
	{
		this.head = new R00Empty();
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
	public void remove(int index) {
		// TODO Auto-generated method stub
		head = head.remove(index);
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		String value = head.get(index);
		return value;
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		int value = head.indexOf(element);
		return value;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return head.size();
	}

	@Override
	public StringList toLowerCase() {
		// TODO Auto-generated method stub
		return head.toLowerCase();
	}

	@Override
	public StringList toUpperCase() {
		// TODO Auto-generated method stub
		return head.toUpperCase();
	}

	@Override
	public StringList startsWith(String prefix) {
		// TODO Auto-generated method stub
		return head.startsWith(prefix);
	}

	@Override
	public StringList hasSubstring(String substring) {
		// TODO Auto-generated method stub
		return head.hasSubstring(substring);
	}

}
