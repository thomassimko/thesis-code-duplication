public class NonEmptyNode
implements Node
{ public String value;
  public Node next;
  
  public NonEmptyNode(String v,Node next)
  { this.value=v;
	this.next=next;
  }
  
  public Node addToEnd(String v)
  { this.next=this.next.addToEnd(v);
    return this;
  } 
  
  public boolean isEnd()
  { return false;  }
  
  public void setNext(Node newnext)
  { this.next=newnext;  }
   
  public Node getNext()
  { return this.next;  }
  
  public String getStr()
  { return this.value;  }
}