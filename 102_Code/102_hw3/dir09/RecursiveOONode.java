public interface RecursiveOONode
{
   String getString();
   RecursiveOONode getNext();
   RecursiveOONode addToEnd(String element);
   RecursiveOONode add(int index, String element);
   RecursiveOONode remove(int index);
   RecursiveOONode get(int index);
   int indexOf(String element);
   int size();
   StringList toLowerCase(StringList list);
   StringList toUpperCase(StringList list);
   StringList startsWith(StringList list, String prefix);
   StringList hasSubstring(StringList list, String substring);
}
