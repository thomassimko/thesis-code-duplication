public interface RecursiveOONode
{
    public String getString();
    public RecursiveOONode getNext();
    public void setNext(RecursiveOONode next);
    
    public RecursiveOONode addToEnd(String element);
    public RecursiveOONode add(int index, String element);
    public RecursiveOONode remove(int index);
    public String get(int index);
    public int indexOf(String element);
    public int size();
    public StringList toLowerCase();
    public StringList toUpperCase();
    public StringList startsWith(String prefix);
    public StringList hasSubstring(String substring);
}