
public interface R00 {

	String getValue();
	R00 getNext();
	void setNext(R00 n);
	R00 addToEnd(String element);
	R00 add(int index, String element);
	R00 remove(int index);
	String get(int index);
	int indexOf(String element);
	int size();
	StringList toLowerCase();
	StringList toUpperCase();
	StringList startsWith(String prefix);
	StringList hasSubstring(String substring);
}
