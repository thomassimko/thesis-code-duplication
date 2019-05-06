//programmed by Michael Olivarez
public interface Recursive00Node
{
  //return the string that the node contains
  String getString();
  //returns reference to the next node
  Recursive00Node getNext();
  //for empty nodes, throw UnsupportedOperationException
  void setNext(Recursive00Node n);
  //from StringList...
  void addToEnd(String element);
  void add(int index, String element);
  String remove(int index);
  String get(int index);
  int indexOf(String element);
  int size();
  StringList toLowerCase();
  StringList toUpperCase();
  StringList startsWith(String prefix);
  StringList hasSubstring(String substring);
  
}
