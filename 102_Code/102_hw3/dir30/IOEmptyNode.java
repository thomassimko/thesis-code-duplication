public class IOEmptyNode
implements IONode
{ public IONode addToEnd(String v)
  { IONode n=new IONonEmptyNode(v,this);
    return n;
  }
  
  public boolean isEnd()
  { return true;  }
  
  public String getStr()
  { return "";  }
}