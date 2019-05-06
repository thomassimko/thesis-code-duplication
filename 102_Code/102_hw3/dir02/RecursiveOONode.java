public interface RecursiveOONode
{
   String getString();
   RecursiveOONode getNext();
   RecursiveOONode addToEnd(String element);
   RecursiveOONode add(int index, String element);
   RecursiveOONode remove(int index);
   String get(int index);
   int indexOf(String element);
   int size();
   StringList toLowerCase();
   StringList toUpperCase(); 
   StringList startsWith(String prefix);
   StringList hasSubstring(String substring);
}
