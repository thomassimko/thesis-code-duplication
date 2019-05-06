import java.util.NoSuchElementException;

public class RecursiveIOStringList
  implements StringList
{
  private RecursiveIONode head;

  public RecursiveIOStringList()
  {
    this.head = new RIOEmpty();
  }

  public void addToEnd(String element)
  {
    head = addToEnd(head, element);
  }

  private RecursiveIONode addToEnd(RecursiveIONode n, String str)
  {
    if( n instanceof RIOEmpty )
      return new RIONode(n, str);
    else
    {
      n.setNext( addToEnd(n.getNext(), str) );
      return n;
    }
  }

  public void add(int index, String element)
  {
    if( index < 0 )
      throw new IndexOutOfBoundsException();
    head = add(index, element, head);
  }

  private RecursiveIONode add(int index, String element, 
    RecursiveIONode n)
  {
    if( index == 0 )
    {
      return new RIONode(n, element);
    }
    else
    {
      if( n instanceof RIOEmpty )
      {
	throw new IndexOutOfBoundsException();
      }
      else
      {
        n.setNext( add(index-1, element, n.getNext()) );
        return n;
      }
    }
  }

  public String remove(int index)
  {
    RecursiveIONode rmvd = get( index );

    if( index < 0 )
      throw new IndexOutOfBoundsException();
    head = remove( index, head ).getString();

    return rmvd.getString();
  }

  private RecursiveIONode remove(int index, RecursiveIONode n)
  {
    if( n instanceof RIOEmpty )
    {
      throw new IndexOutOfBoundsException();
    }
    else
    {
      if( index == 0 )
        return n;
      else
      {
        n.setNext( remove( index -1, n.getNext() );
        return n;
      }        
    }
  }

  public String get(int index)
  {
    if( index < 0 )
      throw new IndexOutOfBoundsException();
    return get(index, head).getString();
  }

  private RecursiveIONode get(int index, RecursiveIONode n)
  {
    if( index == 0 )
      return n;
    else
    {
      if( n instanceof RIOEmpty )
        throw new IndexOutOfBoundsException();
      else
        return get( index-1, n.getNext() );
    }
  }

  public int indexOf(String element)
  {
    return indexOf(element, head);
  }

  private int indexOf(String element, RecursiveIONode n)
  {
    if( n instanceof RIOEmpty )
      throw new NoSuchElementException();
    else
    {
      if( element.equals(n.getString()) )
        return 1;
      else
        return 1 + indexOf(element, n.getNext() );
    }
  }

  public int size()
  {
    return size(head);
  }

  private int size(RecursiveIONode n)
  {
    if( n instanceof RIOEmpty )
      return 0;
    else
      return 1 + size( n.getNext() );
  }

  public StringList toLowerCase()
  {
    return toLowerCase(head);
  }

  private StringList toLowerCase(RecursiveIONode n)
  {
    StringList newList;

    if( n instanceof RIONode )
    {
      newList = toLowerCase( n.getNext() );
      newList.add( 0, n.getString().toLowerCase() );
      return newList;
    }
    else
      return new RecursiveIOStringList();
  }

  public StringList toUpperCase()
  {
    return toLowerCase(head);
  } 

  private StringList toUpperCase(RecursiveIONode n)
  {
    StringList newList;

    if( n instanceof RIONode )
    {
      newList = toUpperCase( n.getNext() );
      newList.add( 0, n.getString().toUpperCase() );
      return newList;
    }
    else
      return new RecursiveIOStringList();
  }

  public StringList startsWith(String prefix)  
  {
    return startsWith(head, prefix);
  }

  private StringList startsWith(RecursiveIONode n, String str)
  {
    StringList newList;

    if( n instanceof RIONode )
    {
      newList = startsWith( n.getNext(), str );

      if( n.getString().startsWith(str) )
        newList.add( 0, n.getString() );

      return newList;
    }
    else
      return new RecursiveIOStringList();
  }

  public StringList hasSubstring(String substring)
  {
    return hasSubstring(head, substring);
  }

  private StringList hasSubstring(RecursiveIONode n, String str)
  {
    StringList newList;

    if( n instanceof RIONode )
    {
      newList = hasSubstring( n.getNext(), str );

      if( n.getString().contains(str) )
        newList.add( 0, n.getString() );

      return newList;
    }
    else
      return new RecursiveIOStringList();
  }
}
