public class EmptyNode
implements Node
{ public Node addToEnd(String v)
  { Node n=new NonEmptyNode(v,this);
    return n;
  }
  
  Node getNext()
  { return null;  }
  
  public boolean isEnd()
  { return true;  }
  
  public String getStr()
  { return "";  }
}