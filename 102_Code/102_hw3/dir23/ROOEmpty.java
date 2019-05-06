
public class ROOEmpty implements RecursiveOONode {
	
	@Override
	public RecursiveOONode add(int index, String element) {
		// TODO Auto-generated method stub
		if(index != 0) {
			throw new IndexOutOfBoundsException();
		}
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}

	@Override
	public RecursiveOONode addToEnd(String element) {
		// TODO Auto-generated method stub
		RecursiveOONode n = new ROONode(element, this);
		return n;
	}

	@Override
	public RecursiveOONode remove(int index) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RecursiveOONode toLowerCase() {
		// TODO Auto-generated method stub
		RecursiveOONode n = new ROOEmpty();
		return n;
	}

	@Override
	public RecursiveOONode toUpperCase() {
		// TODO Auto-generated method stub
		RecursiveOONode n = new ROOEmpty();
		return n;
	}

	@Override
	public RecursiveOONode startsWith(String prefix) {
		// TODO Auto-generated method stub
		RecursiveOONode n = new ROOEmpty();
		return n;
	}

	@Override
	public RecursiveOONode hasSubstring(String substring) {
		// TODO Auto-generated method stub
		RecursiveOONode n = new ROOEmpty();
		return n;
	}

}
