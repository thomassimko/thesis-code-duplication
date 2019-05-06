//Programmed by Michael Olivarez
//import java.lang.String ??
public class IterativeStringList implements StringList
{
  private IterativeNode head;
  public IterativeStringList(IterativeNode N)
  {
    this.head = N;
  }
  public void addToEnd(String element)
  {
    IterativeNode n = new IterativeNode(element, null);
    if(this.head == null)
    {
      this.head = n;
    }
    else
    {
      IterativeNode ref = this.head;
      while(ref.getNext() != null)
      {
        ref = ref.getNext();
      }
      ref.setNext(n);
    }
  }
  public void add(int index, String element)
  {
    if(this.head == null)
    {
      if(index == 0)
      {
        this.head = new IterativeNode(element, null);
      }
    }
    else
    {
      if(index == 0)
      {
        this.head = new IterativeNode(element, this.head);
      }
      else if(index < 0)
      {
        throw new IndexOutOfBoundsException("Index: " + index);
      }
      else
      {
        IterativeNode ref = this.head;
        for(int i = 1; i < index; i++)
        {
          ref = ref.getNext();
        }
        if(ref == null)
        {
          throw new IndexOutOfBoundsException("Index: " + index);
        }
        else
        {
          IterativeNode n = new IterativeNode(element, ref.getNext());
          ref.setNext(n);
        }
      }
    }
  }
  public String remove(int index)
  {
    if(index == 0)
    {
      IterativeNode ref = this.head;
      this.head = this.head.getNext();
      return ref.getString();
    }
    else if(index < 0)
    {
      throw new IndexOutOfBoundsException("Index: " + index);
    }
    else
    {
      IterativeNode ref = this.head;
      for(int i=1; i < index; i++)
      {
        ref = ref.getNext();
      } 
      if(ref == null)
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
    if(this.head == null)
    {
      System.out.println("ERROR: There's nothing here...");
      System.exit(-1);
      return null;
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
        IterativeNode ref = this.head;
        for(int i=1; i < index; i++)
        {
          ref = ref.getNext();
        }
        if(ref == null)
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
    if(this.head == null)
    {
      System.out.println("ERROR: There's nothing here...");
      System.exit(-1);
      return -1;
    }
    else
    {
      int index = 0;
      IterativeNode ref = this.head;
      while(ref.getNext() != null)
      {
        if(ref.getString().equals(element))
        {
          return index;
        }
        ref = ref.getNext();
        index ++;
      }
      if(ref.getNext() == null)
      {
        System.out.println("ERROR: STRING NOT FOUND");
        return -1;
      }
      return index;
    }
  }
  public int size()
  {
    int size = 0;
    if(this.head == null)
    {
      return size;
    }
    else
    {
      IterativeNode ref = this.head;
      while(ref.getNext() != null)
      {
        ref = ref.getNext();
        size ++;
      }
      return size;
    }
  }
  public StringList toLowerCase()
  {
    if(this.head == null)
    {
      return this;
    }     
    else
    {
      IterativeNode ref = this.head;
      IterativeNode result = new IterativeNode(ref.getString().toLowerCase(), null);    
      StringList lowered = new IterativeStringList(result);
      while(ref.getNext() != null)
      {
        ref = ref.getNext();
        lowered.addToEnd(ref.getString().toLowerCase());
      }
      return lowered;
    }
  }
  public StringList toUpperCase()
  {
    if(this.head == null)
    {
      return this;
    }
    else
    {
      IterativeNode ref = this.head;
      IterativeNode result = new IterativeNode(ref.getString().toUpperCase(), null);
      StringList raised = new IterativeStringList(result);
      while(ref.getNext() != null)
      {
        ref = ref.getNext();
        raised.addToEnd(ref.getString().toUpperCase());
      }
      return raised;
    }
  }

  public StringList startsWith(String prefix)
  {
    //use boolean startsWith(string prefix)
    //create new list "matches" to store the matching strings found
    //go down old list, everytime a match is found, add it to end of new list
    if(this.head == null)
    {
      return this;
    }
    else
    {
      IterativeNode ref = this.head;
      StringList matches = new IterativeStringList(null);
      while(ref.getNext() != null)
      {
        if(ref.getString().startsWith(prefix))
        {
          matches.addToEnd(ref.getString());
          ref = ref.getNext();
        }
      }
      return matches;
    }
  }
  public StringList hasSubstring(String substring)
  {
    //use boolean contains(CharSequence s)
    //proceed the same manner as method startsWith
    if(this.head == null)
    {
      return this;
    }
    else
    {
      IterativeNode ref = this.head;
      StringList matches = new IterativeStringList(null);
      while(ref.getNext() != null)
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
