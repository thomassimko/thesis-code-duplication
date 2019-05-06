public interface StringList
{
   /**
      Adds the specified String to the end of the list.
      @param element String to add to list.
   */
   void addToEnd(String element);

   /**
      Adds the specified String at index position in the list.
      The element previously at that position is now after this new element.
      @param index Position at which to add the element.
      @param element String to add to list.
   */
   void add(int index, String element);

   /**
      Removes the element at position index. Returns the element that
      was removed.
      @param index Position of element to remove.
      @return String removed from list.
   */
   String remove(int index);

   /**
      Returns the element at position index.
      @param index Position from which to retrieve String.
      @return String at index position in list.
   */
   String get(int index);

   /**
      Returns the index at which the element appears in the list.
      @param element Value to search for.
      @return Position of element.
   */
   int indexOf(String element);

   /**
      Number of elements in the list.
      @return Number of elements in the list.
   */
   int size();

   /**
      Returns a newly constructed list (in the same order) with the strings
      from the original list converted to lowercase. Does not modify original
      list.
      @return Lowercase copy of the list.
   */
   StringList toLowerCase();

   /**
      Returns a newly constructed list (in the same order) with the strings
      from the original list converted to uppercase. Does not modify original
      list.
      @return Uppercase copy of the list.
   */
   StringList toUpperCase();

   /**
      Returns a newly constructed list (in the same order) containing
      strings from the original list that begin with the specified
      prefix.  Does not modify original list.
      @return New list with strings containing prefix.
   */
   StringList startsWith(String prefix);

   /**
      Returns a newly constructed list (in the same order) containing
      strings from the original list that contains the specified substring.
      Does not modify original list.
      @return New list with strings containing substring.
   */
   StringList hasSubstring(String substring);
}
