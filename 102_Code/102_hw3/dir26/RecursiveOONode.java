
public interface RecursiveOONode {
	String getValue();
	RecursiveOONode getNext();
	void setNext(RecursiveOONode next);
	void setValue(String value);
	
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
}
