public interface RecursiveOONode
{
   String getString();
   public RecursiveOONode getNext();
   ROONode addToEnd(String element);
   ROONode add(int index, String element);
   RecursiveOONode remove(int index);
   String get(int index);
   int indexOf(String element);
   int size();
   StringList toLowerCase();
   StringList toUpperCase();
   StringList startsWith(String prefix);
   StringList hasSubstring(String substring);
}
