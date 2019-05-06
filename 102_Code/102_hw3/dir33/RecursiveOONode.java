
public interface RecursiveOONode 
{
	
	RecursiveOONode addToEnd(String element);
	RecursiveOONode add(int index, String element, RecursiveOONode cur);
	RecursiveOONode remove(int index, RecursiveOONode cur);
	String get(int index);
	int indexOf(String element);
	int size();
	RecursiveOONode toLowerCase();
	RecursiveOONode toUpperCase();
	RecursiveOONode startsWith(String prefix);
	RecursiveOONode hasSubstring(String substring);
	void setNext(RecursiveOONode n);
	String getValue();
	RecursiveOONode getNext();
}
