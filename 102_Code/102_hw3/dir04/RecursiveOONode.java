
public interface RecursiveOONode 
{
	public String getStr();
	public RecursiveOONode getNext();
	public void setNext (RecursiveOONode n);
	public void addToEnd(String element); 
	public void add(int index, String element);
	public String remove(int index);
	public String get(int index);
	public int indexOf(String element);
	public int size();
	public StringList toLowerCase();
	public StringList toUpperCase();
	public StringList startsWith(String prefix);
	public StringList hasSubstring(String substring);
	
}
