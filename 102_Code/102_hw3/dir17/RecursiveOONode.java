public interface RecursiveOONode
{
  public String getString();
  public RecursiveOONode getNext();

  public RecursiveOONode addToEnd(String element);
  public RecursiveOONode add(int index, String element);
  public RecursiveOONode remove(int index);
  public String get(int index);
  public int indexOf(String element);
  public int size();
  public StringList addLowerCase();
  public StringList addUpperCase();
  public StringList addStartsWith(String str);
  public StringList addHasSubstring(String str);
}
