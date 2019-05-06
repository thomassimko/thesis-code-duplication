
public interface RecursiveOONode
{
	RecursiveOONode addToEnd(String element);
	RecursiveOONode add(int index, String element);
	int size();
	String get(int index);
	RecursiveOONode remove(int index);
	int indexOf(String element);
	RecursiveOONode toLowerCase();
	RecursiveOONode toUpperCase();
	RecursiveOONode startsWith(String prefix);
	RecursiveOONode hasSubstring(String substring);
}
