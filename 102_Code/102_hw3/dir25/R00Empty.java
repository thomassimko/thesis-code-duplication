
public class R00Empty implements R00 {

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public R00 getNext() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNext(R00 n) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public R00 addToEnd(String element) {
		// TODO Auto-generated method stub
		R00 n = new R00Node(element, this);
		return n;
	}

	@Override
	public R00 add(int index, String element) {
		// TODO Auto-generated method stub
		if (index!=0)
		{
			throw new IndexOutOfBoundsException();
		}
		R00 n = new R00Node(element, this);
		return n;
	}

	@Override
	public R00 remove(int index) {
		// TODO Auto-generated method stub
		throw new IndexOutOfBoundsException();
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StringList toLowerCase() {
		// TODO Auto-generated method stub
		return new Recursive00StringList();
	}

	@Override
	public StringList toUpperCase() {
		// TODO Auto-generated method stub
		return new Recursive00StringList();
	}

	@Override
	public StringList startsWith(String prefix) {
		// TODO Auto-generated method stub
		return new Recursive00StringList();
	}

	@Override
	public StringList hasSubstring(String substring) {
		// TODO Auto-generated method stub
		return new Recursive00StringList();
	}

}
