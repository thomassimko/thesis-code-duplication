
public interface RecursiveOONode 
{
	public RecursiveOONode addToEnd(String element);
	
	public RecursiveOONode add(int index, String element);
	
	public RecursiveOONode remove(int index);
	
	public String get(int index);
	
	public int indexOf(String element, int index);
	
	public int size(int curSize);
	
	public StringList toLowerCase();
	
	public StringList toUpperCase();
	
	public StringList startsWith(String prefix);
	
	public StringList hasSubstring(String substring);
}
