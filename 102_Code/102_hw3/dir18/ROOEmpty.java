import java.util.NoSuchElementException;

public class ROOEmpty
    implements RecursiveOONode
{
    public String getString()
    {
	throw new UnsupportedOperationException();
    }
    public RecursiveOONode getNext()
    {
	throw new UnsupportedOperationException();
    }
    public void setNext(RecursiveOONode next)
    {
	throw new UnsupportedOperationException();
    }
    public RecursiveOONode addToEnd(String element)
    {
	RecursiveOONode added = new ROONode(element, this);
	return added;
    }
    public RecursiveOONode add(int index, String element)
    {
	if(index == 0){
	    RecursiveOONode added = new ROONode(element, this);	    
	    return added;
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public RecursiveOONode remove(int index)
    {
	throw new IndexOutOfBoundsException();
    }
    public String get(int index)
    {
	throw new IndexOutOfBoundsException();
    }
    public int indexOf(String element)
    {
	throw new NoSuchElementException();
    }
    public int size()
    {
	return 0;
    }
    public StringList toLowerCase()
    {
	RecursiveOOStringList newList = new RecursiveOOStringList();
	return newList;
    }
    public StringList toUpperCase()
    {
	RecursiveOOStringList newList = new RecursiveOOStringList();
	return newList;
    }
    public StringList startsWith(String prefix)
    {
	RecursiveOOStringList newList = new RecursiveOOStringList();
	return newList;
    }
    public StringList hasSubstring(String substring)
    {
	RecursiveOOStringList newList = new RecursiveOOStringList();
	return newList;
    }
}