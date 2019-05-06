import java.util.NoSuchElementException;


public class ROOEmpty 
	implements RecursiveOONode
{


	public RecursiveOONode addToEnd(String element) 
	{
		RecursiveOONode n = new ROONode(element,this);
		return n;
	}


	public RecursiveOONode add(int index, String element, RecursiveOONode cur) 
	{
		if(index == 0)
		{
			RecursiveOONode n = new ROONode(element, cur);
			return n;
		}
		else throw new IndexOutOfBoundsException();
	}

	public RecursiveOONode remove(int index, RecursiveOONode cur)
	{
		throw new NoSuchElementException();
	}

	public RecursiveOONode get(int index,RecursiveOONode node) {
		throw new NoSuchElementException();
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		return -1;
	}


	public int size() {
		return 0;
	}



	public RecursiveOOStringList startsWith() {
		// TODO Auto-generated method stub
		return null;
	}


	public RecursiveOOStringList hasSubstring() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}


	@Override
	public RecursiveOONode getNext() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}



	public void setNext(RecursiveOONode n) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public String get(int index) {
		throw new IndexOutOfBoundsException();
	}


	@Override
	public RecursiveOONode toLowerCase() {
	
		return new ROOEmpty();
	}


	@Override
	public RecursiveOONode toUpperCase() {
		
		return new ROOEmpty();
	}


	@Override
	public RecursiveOONode startsWith(String prefix) {
		// TODO Auto-generated method stub
		return new ROOEmpty();
	}


	@Override
	public RecursiveOONode hasSubstring(String substring) {
		// TODO Auto-generated method stub
		return new ROOEmpty();
	}




}
