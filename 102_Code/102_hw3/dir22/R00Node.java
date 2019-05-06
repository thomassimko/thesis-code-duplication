//programmed by Michael Olivarez
public class R00Node implements Recursive00Node
{
  private String str;
  private Recursive00Node next;
  public R00Node(String word, Recursive00Node Next)
  {
    this.str = word;
    this.next = Next;
  }
  
  public String getString()
  {
    return this.str;
  }
  public Recursive00Node getNext()
  {
    return this.next;
  }
  
  public void setNext(Recursive00Node n)
  {
    this.next = n;
  }
  public void addToEnd(String element)
  {
    R00Empty Emp = new R00Empty();
    Recursive00Node n = new R00Node(element, Emp);
    if(this.next instanceof R00Empty)
    {
      this.next = n;
    }
    else
    {
      Recursive00Node ref = this.next;
      while(ref.getNext() instanceof R00Node)
      {
        ref = ref.getNext();
      }
      ref.setNext(n);
    }
  }

  public void add(int index, String element)
  {
    /*if(this instanceof R00Empty)
    {
      if(index == 0)
      {
        R00Empty Emp = new R00Empty();
        this = new R00Node(element, Emp);
      }
    }
    else
    {*/
      if(index == 0)
      {
        R00Node temp = new R00Node(element, this.next);
        this.next = temp;
      }
      else if(index < 0)
      {
        throw new IndexOutOfBoundsException("Index: " + index);
      }
      else
      {
        Recursive00Node ref = this;
        for(int i = 1; i < index; i++)
        {
          ref = ref.getNext();
        
          if(ref instanceof R00Empty)
          {
            throw new IndexOutOfBoundsException("Index: " + index);
          }
        }
        Recursive00Node n = new R00Node(element, ref.getNext());
        ref.setNext(n);
      }
    //}
  }
  public String remove(int index)
  {
    if(index == 0)
    {
      Recursive00Node ref = this;
      ref = this.getNext();

      return ref.getString();
    }
    else if(index < 0)
    {
      throw new IndexOutOfBoundsException("Index: " + index); 
    }
    else
    {
      Recursive00Node ref = this;
      for(int i=1; i < index; i++)
      {
        ref = ref.getNext();
      }
      if(ref instanceof R00Empty)
      {
        throw new IndexOutOfBoundsException("Index: " + index); 
      }
      else
      {
        ref.setNext(ref.getNext().getNext());
      }
      return ref.getString();
    }
  }

  public String get(int index)
  {
    if(this.next instanceof R00Empty)
    {
      return null;
    }
    else
    {
      if(index == 0)
      {
        return this.getString();
      }
      else if(index < 0)
      {  
        throw new IndexOutOfBoundsException("Index: " + index); 
      }
      else
      {
        Recursive00Node ref = this;
        for(int i=1; i < index; i++)
        {
          ref = ref.getNext();
        }
        if(ref instanceof R00Empty)
        {
          throw new IndexOutOfBoundsException("Index: " + index); 
        }
        else
        {
          return ref.getString();
        }
      }
    }
  }
  public int indexOf(String element)
  {
   /* if(this instanceof R00Empty)
    {
      System.out.println("ERROR: Node is empty");
      System.exit(-1);
      return -1;
    }
    else
    {*/
      int index = 0;
      Recursive00Node ref = this;
      while(ref.getNext() instanceof R00Node)
      {
        if(ref.getString().equals(element))
        {
          return index;
        }
        ref = ref.getNext();
        index ++;
      }
      if(ref.getNext() instanceof R00Empty)
      {
        System.out.println("ERROR: Node is empty");
        return -1;
      }
      return index;
   //}
  }
  public int size()
  {
    int size = 0;
      Recursive00Node ref = this;
      while(ref.getNext() instanceof R00Node)
      {
        ref = ref.getNext();
        size ++;
      }
      return size;
  }
  public StringList toLowerCase()
  {
      Recursive00Node ref = this;
      R00Empty Emp = new R00Empty();
      Recursive00Node result = new R00Node(ref.getString().toLowerCase(), Emp);
      StringList LC = new Recursive00StringList(result);
      while(ref.getNext() instanceof R00Node)
      {
        ref = ref.getNext();
        LC.addToEnd(ref.getString().toLowerCase());
      } 
      return LC;
  }

  public StringList toUpperCase()
  {
      Recursive00Node ref = this;
      R00Empty Emp = new R00Empty();
      Recursive00Node result = new R00Node(ref.getString().toUpperCase(), Emp);
      StringList UC = new Recursive00StringList(result);
      while(ref.getNext() instanceof R00Node)
      {
        ref = ref.getNext();
        UC.addToEnd(ref.getString().toUpperCase());
      }
      return UC;
  }
  public StringList startsWith(String prefix)
  {
    Recursive00Node ref = this;
    Recursive00Node temp = new R00Empty();
    StringList matches = new Recursive00StringList(temp);
    while(ref.getNext() instanceof R00Node)
    {
      if(ref.getString().startsWith(prefix))
      {
        matches.addToEnd(ref.getString());
        ref = ref.getNext(); 
      }
    }
    return matches;
  }
  public StringList hasSubstring(String substring)
  {
    Recursive00Node ref = this;
    Recursive00Node temp = new R00Empty();
    StringList matches = new Recursive00StringList(temp);
    while(ref.getNext() instanceof R00Node )
    {
      if(ref.getString().contains(substring))
      {
        matches.addToEnd(ref.getString());
      }
        ref = ref.getNext();
      
    }
    return matches;
  } 
}
