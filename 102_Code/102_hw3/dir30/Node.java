public class Node
{ private Node next;
  private String value;
  
  public Node(String val,Node next)
  { this.value=val;
    this.next=next;
  }
  
  public void setNext(Node newnext)
  { this.next=newnext;  }
  
  public String getStr()
  { return this.value;  }
  
  public Node getNext()
  { return this.next;  }
}