public class RecursiveOOStringList
  implements StringList
{
  private RecursiveOONode head;

  public RecursiveOOStringList()
  {
    this.head = new ROOEmpty();
  }

  public void addToEnd(String element)
  {
    this.head = head.addToEnd(element);
  }

  public void add(int index, String element)
  {
    this.head = head.add(index, element);
  }

  public String remove(int index)
  {
    String rmvd = head.get( index );

    head = head.remove(index);

    return rmvd;
  }

  public String get(int index)
  {
    return head.get(index);
  }

  public int indexOf(String element)
  {
    return indexOf(element);
  }

  public int size()
  {
    return head.size();
  }

  public StringList toLowerCase()
  {
    return head.addLowerCase();
  }

  public StringList toUpperCase()
  {
    return head.addUpperCase();
  }

  public StringList startsWith(String str)
  {
    return head.addStartsWith(str);
  }

  public StringList hasSubstring(String str)
  {
    return head.addHasSubstring(str);
  }
}
