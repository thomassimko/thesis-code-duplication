public class ROOEmpty
  implements RecursiveOONode
{
  public String getString()
  {
    throw new UnsupportedOperationException();
  }

  public RecursiveOONode getNext()
  {
    throw new UnsupportedOperationException();
  }

  public RecursiveOONode addToEnd(String element)
  {
    return new ROONode(element, this);
  }

  public RecursiveOONode add(int index, String element)
  {
    if(index != 0)
      throw new IndexOutOfBoundsException();
    return new ROONode(element, this);
  }

  public RecursiveOONode remove(int index)
  {
    throw new IndexOutOfBoundsException();
  }

  public String get(int index)
  {
    throw new IndexOutOfBoundsException();
  }

  public int indexOf(String element)
  {
    return -1;
  }

  public int size()
  {
    return 0;
  }

  public StringList addLowerCase()
  {
    return new RecursiveOOStringList();
  }  

  public StringList addUpperCase()
  {
    return new RecursiveOOStringList();
  }

  public StringList addStartsWith(String str)
  {
    return new RecursiveOOStringList();
  }

  public StringList addHasSubstring(String str)
  {
    return new RecursiveOOStringList();
  }
}
