
public interface RecursiveOONode {
	String getString();
	RecursiveOONode getNext();
	RecursiveOONode addToEnd(String element);
	RecursiveOONode add(int index, String element);
	RecursiveOONode remove(int index);
	String get(int index);
	int indexOf(String element);
	int size();
	RecursiveOOStringList toLowerCase();
	RecursiveOOStringList toUpperCase();
	RecursiveOOStringList startsWith(String prefix);
	RecursiveOOStringList hasSubstring(String substring);
}
