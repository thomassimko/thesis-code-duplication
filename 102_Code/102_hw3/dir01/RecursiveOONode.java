
public interface RecursiveOONode {
	String str();
	RecursiveOONode next();
	void setNext(RecursiveOONode n);
	int size();
	RecursiveOONode allLowered();
	RecursiveOONode allUppered();
	RecursiveOONode statsWith(String prefix);
	RecursiveOONode hasSubStr(String substring);
	int find(String element,int n);
	String get(int index);
	String remove(int index);
	void add(int index, String element);
	void addEnd(String element,RecursiveOONode n);
}
