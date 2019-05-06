public interface RecursiveOONode
{
   public RecursiveOONode addToEnd(String element);
   public RecursiveOONode add(int index, String element);
   public String remove(int index);
   public String get(int index);
   public int indexOf(String element);
   public int size();
   public RecursiveOOStringList toLowerCase();
   public RecursiveOOStringList toUpperCase();
   public RecursiveOOStringList startsWith(String prefix);
   public RecursiveOOStringList hasSubstring(String substring);
   public RecursiveOONode getNext();
   public String getValue();
   public RecursiveOONode setNext(RecursiveOONode n);
}