//Programmed by Michael Olivarez
public class Recursive00StringList implements StringList
{
  private Recursive00Node head;
  public Recursive00StringList(Recursive00Node nod)
  {
    this.head = nod;
  }
/*
  public Recursive00Node getHead()
  {
    return this.head;
  }
  public void setHead(Recursive00Node n)
  {
    this.head = n;
  }
*/
  public void addToEnd(String element)
  {
    this.head.addToEnd(element);
  }
  public void add(int index, String element)
  {
    this.head.add(index,element);
  }
  public String remove(int index)
  {
    return this.head.remove(index);
  }
  public String get(int index)
  {
    return this.head.get(index);
  }
  public int indexOf(String element)
  {
    return this.head.indexOf(element);
  }
  public int size()
  {
    return this.head.size();
  }
  public StringList toUpperCase()
  {
    return this.head.toUpperCase();
  }
  public StringList toLowerCase()
  {
    return this.head.toLowerCase();
  }
  public StringList startsWith(String prefix)
  {
    return this.head.startsWith(prefix);
  }
  public StringList hasSubstring(String substring)
  {
    return this.head.hasSubstring(substring);
  }

}
