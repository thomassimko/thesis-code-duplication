//programmed by Michael Olivarez
public class RecursiveI0StringList implements StringList
{
  private RecursiveI0Node head;
  public RecursiveI0StringList(RecursiveI0Node n)
  {
    this.head = n;
  }
  public void addToEnd(String element)
  {
    RecursiveI0Node temp = new RI0Empty();
    RecursiveI0Node n = new RI0Node(element,temp);
    if(this.head instanceof RI0Empty)
    {
      this.head = n;
    }
    else
    {
      RecursiveI0Node ref = this.head;
      while(ref.getNext() instanceof RI0Node) 
      {
        ref = ref.getNext();
      }
      ref.setNext(n);
    }
  }
  public void add(int index, String element)
  {
    if(this.head instanceof RI0Empty)
    {
      if(index == 0)
      {
        RecursiveI0Node temp = new RI0Empty();
        this.head = new RI0Node(element,temp);
      }
    }
    else
    {
      if(index == 0)
      {
        this.head = new RI0Node(element, this.head);
      }
      else if(index < 0)
      {
        throw new IndexOutOfBoundsException("Index: " + index);
      }
      else
      {
        RecursiveI0Node ref = this.head;
        int count = 1;
        while(count < index)
        {
          ref = ref.getNext();
          count++;
        }
        if(ref instanceof RI0Empty)
        {
          throw new IndexOutOfBoundsException("Index: " + index);
        }
        else
        {
          RecursiveI0Node n = new RI0Node(element, ref.getNext());
          ref.setNext(n);
        }
      }
    }
  }
  public String remove(int index)
  {
    if(index == 0)
    {
      RecursiveI0Node ref = this.head;
      this.head = this.head.getNext();
      return ref.getString();
    }
    else if(index < 0)
    {
      throw new IndexOutOfBoundsException("Index: " + index);
    }
    else
    {
      RecursiveI0Node ref = this.head;
      int count = 1;
      while(count < index)
      {
        ref = ref.getNext();
        count++;
      }
      if(ref instanceof RI0Empty)
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
    if(this.head instanceof RI0Empty)
    {
      throw new IndexOutOfBoundsException("Index: " + index);
    }
    else
    {
      if(index == 0)
      {
        return this.head.getString();
      }
      else if(index < 0)
      {
        throw new IndexOutOfBoundsException("Index: " + index);
      }
      else
      {
        RecursiveI0Node ref = this.head;
        int count = 1;
        while(count < index)
        {
          ref = ref.getNext();
          count++;
        }
        if(ref instanceof RI0Empty)
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
    if(this.head instanceof RI0Empty)
    {
      System.out.println("ERROR: only empty node");
      System.exit(-1);
      return -1;
    }
    else
    {
      int index = 0;
      RecursiveI0Node ref = this.head; 
      while(ref.getNext() instanceof RI0Node)
      {
        if(ref.getString().equals(element))
        {
          return index;
        }
        ref = ref.getNext();
        index++;
      }
      if(ref.getNext() instanceof RI0Empty)
      {
        System.out.println("ERROR: STRING NOT FOUND!");
        return -1;
      }
      return index;
    }
  }
  public int size()
  {
    int size = 0;
    if(this.head instanceof RI0Empty)
    {
      return size;
    }
    else
    { 
      RecursiveI0Node ref = this.head;
      while(ref.getNext() instanceof RI0Node)
      {
        ref = ref.getNext();
        size ++;
      }
      return size;
    } 
  }

  public StringList toLowerCase()
  {
    if(this.head instanceof RI0Empty)
    {
      return this;
    }
    else
    {
      RecursiveI0Node ref = this.head;
      RecursiveI0Node temp = new RI0Empty();
      RecursiveI0Node result = new RI0Node(ref.getString().toLowerCase(),temp);
      StringList LC = new RecursiveI0StringList(result);
      while(ref.getNext() instanceof RI0Node)
      {
        ref = ref.getNext();
        LC.addToEnd(ref.getString().toLowerCase());
      }
      return LC;
    }
  }
  public StringList toUpperCase()
  {
    if(this.head instanceof RI0Empty)
    {
      return this;
    }
    else
    {
      RecursiveI0Node ref = this.head;
      RecursiveI0Node temp = new RI0Empty();
      RecursiveI0Node result = new RI0Node(ref.getString().toUpperCase(),temp);
      StringList UC = new RecursiveI0StringList(result);
      while(ref.getNext() instanceof RI0Node) 
      {
        ref = ref.getNext();
        UC.addToEnd(ref.getString().toUpperCase());
      }
      return UC;
    }
  }
  public StringList startsWith(String prefix)
  {
    if(this.head instanceof RI0Empty)
    {
      return this;
    }
    else
    {
      RecursiveI0Node ref = this.head;
      RecursiveI0Node temp = new RI0Empty();
      StringList matches = new RecursiveI0StringList(temp);
      while(ref.getNext() instanceof RI0Node)
      {
        if(ref.getString().startsWith(prefix))
        { 
          matches.addToEnd(ref.getString());
        }
          ref = ref.getNext();
        
      }
      return matches;
    }
  }

  public StringList hasSubstring(String substring)
  {
    if(this.head instanceof RI0Empty)
    {
      return this;
    }
    else
    {
      RecursiveI0Node ref = this.head;
      RecursiveI0Node temp = new RI0Empty();
      StringList matches = new RecursiveI0StringList(temp);
      while(ref.getNext() instanceof RI0Node)
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
}
