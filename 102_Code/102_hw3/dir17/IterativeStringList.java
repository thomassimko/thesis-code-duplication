public class IterativeStringList
  implements StringList
{
  private IterativeNode head;

  public IterativeStringList()
  {
    this.head = null;
  }

  public void addToEnd(String element)
  {
    IterativeNode n = new IterativeNode(element, null);

    if(head == null)
      this.head = n;
    else
    {
      IterativeNode cur = this.head;

      while(cur.getNext() != null)
      {
	cur = cur.getNext();
      }

      cur.setNext(n);
    }
  }

  public void add(int index, String element)
  {
    IterativeNode n = head;

    if( index < 0 )
      throw new IndexOutOfBoundsException();
    else if( index == 0 )
    {
      head = new IterativeNode( element, head );
    }
    else
    {
      IterativeNode cur = head;

      for( int i = 1; i < index && cur != null; i++)
      {
        cur = cur.getNext();
      }

      if( cur == null )
        throw new IndexOutOfBoundsException();
      else
        cur.setNext( new IterativeNode(element, cur.getNext()) );
    }
  }

  public String remove(int index)
  {
    if( index < 0 )
      throw new IndexOutOfBoundsException();
    else if( index == 0 )
    {
      if( head == null )
        throw new IndexOutOfBoundsException();
      else
      {
        String rmvd = head.getString();
        head = head.getNext();
        return rmvd;
      }
    }
    else
    {
      IterativeNode cur = head;

      for( int i = 0; i < index-1 && cur != null; i++)
      {
        cur = cur.getNext();
      }

      if( cur == null )
        throw new IndexOutOfBoundsException();
      else
      {
        IterativeNode rmvd = cur.getNext();

        cur.setNext( rmvd.getNext() );

        return rmvd.getString();
      }
    }
  }

  public String get(int index)
  {
    if( index < 0 )
      throw new IndexOutOfBoundsException();
    else if( index == 0 )
      return this.head.getString();
    else
    {
      IterativeNode cur = head;

      for( int i = 0; i < index && cur != null; i++)
      {
        cur = cur.getNext();
      }

      if( cur == null )
        throw new IndexOutOfBoundsException();
      else
        return cur.getString();
    }
  }

  public int indexOf(String element)
  {
    IterativeNode cur = head;

    for( int i = 0; cur != null; i++)
    {
      if( element.equals(cur) )
        return i;
      else
        cur = cur.getNext();
    }
    return -1;
  }

  public int size()
  {
    IterativeNode cur = head;
    int i;

    for(i = 0; cur != null; i++)
    {
      cur = cur.getNext();
    }

    return i;
  }

  public StringList toLowerCase()
  {
    StringList newList = new IterativeStringList();
    IterativeNode cur = head;

    while(cur != null)
    {
      newList.addToEnd( cur.getString().toLowerCase() );
      cur = cur.getNext();
    }

    return newList;
  }

  public StringList toUpperCase()
  {
    StringList newList = new IterativeStringList();
    IterativeNode cur = head;

    while( cur != null )
    {
      newList.addToEnd( cur.getString().toUpperCase() );
      cur = cur.getNext();
    }

    return newList;
  }

  public StringList startsWith(String prefix)
  {
    StringList newList = new IterativeStringList();
    IterativeNode cur = head;

    while( cur != null )
    {
      String curStr = cur.getString();

      if( curStr.startsWith(prefix) )
        newList.addToEnd(curStr);

      cur = cur.getNext();
    }

    return newList;
  }

  public StringList hasSubstring(String substring)
  {
    StringList newList = new IterativeStringList();
    IterativeNode cur = head;

    while( cur != null )
    {
      String curStr = cur.getString();

      if( curStr.contains(substring) )
        newList.addToEnd(curStr);

      cur = cur.getNext();
    }

    return newList;
  }
}
