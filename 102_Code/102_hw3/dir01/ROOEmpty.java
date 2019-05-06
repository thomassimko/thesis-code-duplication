
public class ROOEmpty implements RecursiveOONode {

	@Override
	public String str() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public RecursiveOONode next() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNext(RecursiveOONode n) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RecursiveOONode allLowered() {
		// TODO Auto-generated method stub
		return new ROOEmpty();
	}

	@Override
	public RecursiveOONode allUppered() {
		// TODO Auto-generated method stub
		return new ROOEmpty();
	}

	@Override
	public RecursiveOONode statsWith(String prefix) {
		// TODO Auto-generated method stub
		return new ROOEmpty();
	}

	@Override
	public RecursiveOONode hasSubStr(String substring) {
		// TODO Auto-generated method stub
		return new ROOEmpty();
	}

	@Override
	public int find(String element,int n) {
		// TODO Auto-generated method stub
		throw new IndexOutOfBoundsException();
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		throw new IndexOutOfBoundsException();
	}

	@Override
	public String remove(int index) {
		// TODO Auto-generated method stub
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		throw new IndexOutOfBoundsException();
	}

	@Override
	public void addEnd(String element,RecursiveOONode n) {
		// TODO Auto-generated method stub
		n.setNext(new ROONode(element));
	}
}
