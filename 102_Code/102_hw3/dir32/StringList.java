
public interface StringList 
{
	   void addToEnd(String element);
	   void add(int index, String element);
	   void remove(int index);
	   String get(int index);
	   int indexOf(String element);
	   int size();
	   StringList toLowerCase();
	   StringList toUpperCase();
	   StringList startsWith(String prefix);
	   StringList hasSubstring(String substring);
}
