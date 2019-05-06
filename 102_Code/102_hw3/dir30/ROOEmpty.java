public class ROOEmpty
implements OONode
{ public OONode addToEnd(String v)
  { OONode n=new OONode(v,this);
    return n;
  }
  
  public boolean isEnd()
  { return true;  }
  
  public String getStr()
  { return "";  }
}