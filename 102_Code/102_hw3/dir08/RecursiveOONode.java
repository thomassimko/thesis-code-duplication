public interface RecursiveOONode
{
   String toString();
   RecursiveOONode next();
   RecursiveOONode addToEnd(String element);
   RecursiveOONode add(int index, String element);
   RecursiveOONode remove(int index, StringObj s);
   String get(int index);
   int indexOf(int c, String element);
   int size();
   StringList toLowerCase();
   StringList toUpperCase();
   StringList startsWith(String prefix);
   StringList hasSubstring(String substring);
}
