public class RecursiveOOStringList
   implements StringList
{
   private RecursiveOONode head;
   
   public RecursiveOOStringList()
   {
      head = new ROOEmpty();
   }

   /**
      Adds the specified String to the end of the list.
      @param element String to add to list.
   */
   public void addToEnd(String element)
   {
      this.head = head.addToEnd(element);
   }

   /**
      Adds the specified String at index position in the list.
      The element previously at that position is now after this new element.
      @param index Position at which to add the element.
      @param element String to add to list.
   */
   public void add(int index, String element)
   {
      head.add(index, 0, element);
   }

   /**
      Removes the element at position index. Returns the element that
      was removed.
      @param index Position of element to remove.
      @return String removed from list.
   */
   public void remove(int index)
   {
      return head.remove(index, 0);
   }

   /**
      Returns the element at position index.
      @param index Position from which to retrieve String.
      @return String at index position in list.
   */
   public String get(int index)
   {
      return head.get(index, 0);
   }

   /**
      Returns the index at which the element appears in the list.
      @param element Value to search for.
      @return Position of element.
   */
   public int indexOf(String element)
   {
      return head.indexOf(element, 0);
   }

   /**
      Number of elements in the list.
      @return Number of elements in the list.
   */
   public int size()
   {
      return head.size();
   }

   /**
      Returns a newly constructed list (in the same order) with the strings
      from the original list converted to lowercase. Does not modify original
      list.
      @return Lowercase copy of the list.
   */
   public StringList toLowerCase()
   {
   
   }

   /**
      Returns a newly constructed list (in the same order) with the strings
      from the original list converted to uppercase. Does not modify original
      list.
      @return Uppercase copy of the list.
   */
   public StringList toUpperCase()
   {
   
   }

   /**
      Returns a newly constructed list (in the same order) containing
      strings from the original list that begin with the specified
      prefix.  Does not modify original list.
      @return New list with strings containing prefix.
   */
   public StringList startsWith(String prefix)
   {
   
   }

   /**
      Returns a newly constructed list (in the same order) containing
      strings from the original list that contains the specified substring.
      Does not modify original list.
      @return New list with strings containing substring.
   */
   public StringList hasSubstring(String substring)
   {
   
   }
}
