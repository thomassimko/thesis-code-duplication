
public interface RecursiveOONode 
{
	RecursiveOONode addToEnd(String element);
	RecursiveOONode add(int index, String element);
	RecursiveOONode remove(int index);
	String get(int index);
	int indexOf(String element);
	int size();
	RecursiveOONode toLowerCase();
	RecursiveOONode toUpperCase();
	RecursiveOONode startsWith(String prefix);
	RecursiveOONode hasSubstring(String substring);
	RecursiveOONode getNext();
	String getData();
}
