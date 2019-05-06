public class ROONode
  implements RecursiveOONode
{
  private String string;
  private RecursiveOONode next;

  public ROONode(String string, RecursiveOONode next)
  {
    this.string = string;
    this.next = next;
  }

  public String getString()
  {
    return this.string;
  }

  public RecursiveOONode getNext()
  {
    return this.next;
  }


  public RecursiveOONode addToEnd(String element)
  {
    next = next.addToEnd(element);
    return this;
  }

  public RecursiveOONode add(int index, String element)
  {
    if(index != 0)
    {
      next = next.add(index-1, element);
      return this;
    }
    else
      return new ROONode(element, this);
  }

  public RecursiveOONode remove(int index)
  {
    if( index == 0 )
    {
      return next;
    }
    else
    {
      this.next = next.remove( index -1 );
      return this;
    }
  }

  public String get(int index)
  {
    if(index != 0)
      return next.get(index-1);
    else
      return this.getString();
  }

  public int indexOf(String element)
  {
    if(element.equals(this.getString()) )
      return 0;
    else
      return 1 + next.indexOf(element);
  }

  public int size()
  {
    return 1 + next.size();
  }

  public StringList addLowerCase()
  {
    StringList newList = next.addLowerCase();
    newList.add(0, this.getString().toLowerCase() );
    return newList;
  }

  public StringList addUpperCase()
  {
    StringList newList = next.addUpperCase();
    newList.add(0, this.getString().toUpperCase() );
    return newList;
  }

  public StringList addStartsWith(String str)
  {
    StringList newList = next.addStartsWith(str);
    if( this.getString().startsWith(str) )
    {
      newList.add(0, this.getString() );
    }
    return newList;
  }

  public StringList addHasSubstring(String str)
  {
    StringList newList = next.addHasSubstring(str);
    if( this.getString().contains(str) )
    {
      newList.add(0, this.getString() );
    }
    return newList;
  }
}
