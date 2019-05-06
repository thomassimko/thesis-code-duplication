public class RecursiveIOList
implements StringList
{ public OONode head;
  
  public IterativeList()
  { head= new ROOEmpty();  }
  
  public void addToEnd(String v)
  { head.addToEnd(v);   }
  
  public void add(int index, String v)
  { if(index<this.size())
    { if(index==0)
	  { head=new ROONode(v,head);  }
	  else if(index==this.size())
	  { this.addToEnd(v);  }
	  else
	  { int val=0;
	    OONode cur=head;
	    while(val<index-1)
		{ cur=cur.getNext();
		  val++;
		}
		OONode get=new ROONode(v,cur.getNext());
		cur.setNext(get);
	  }
	}
	throw IndexOutOfBoundsException();
  }
  
  public String remove(int index)
  { OONode cur=head;
    if(index==0)
    { head=head.getNext();
	  return head;
	}
	else if(index<this.size())
	{ for(int i=0;i<index-1;i++)
	  { n=n.getNext();  }
	  n.setNext(n.getNext().getNext());
	}
	throw IndexOutOfBoundsException();
  }
  
  public String get(int index)
  { OONode cur;
    cur=head;
    if(index==0)
    { return head.getStr();  }
	else if(index<this.size())
	{ for(int i=0;i<index;i++)
	  { n=n.getNext();  }
	  n.getStr();
	}
	throw IndexOutOfBoundsException();
  }
  
  public int indexOf(String element)
  { int val=0;
    OONode cur;
	cur=head;
    while(val<this.size())
	{ if(cur.getStr().equals(element))
	  { return val;  }
	  val++;
	}
  }
  
  public int size()
  { int val=0;
    OONode cur=head;
	while(!cur.isEnd())
	{ cur=cur.getNext();
	  val++;
	}
	return val;
  }
  
  public StringList toLowerCase()
  { StringList link=new IterativeList();
    OONode cur=head;
    for(int i=0;i<this.size();i++)
    { link.addToEnd(cur.getStr().toLowerCase());  }
	return link;
  }
  
  public StringList toUpperCase()
  { StringList link=new IterativeList();
    OONode cur=head;
    for(int i=0;i<this.size();i++)
    { link.addToEnd(cur.getStr().toLowerCase());  }
	return link;
  }
  
  public StringList startsWith(String prefix)
  { StringList link=new IterativeList();
    OONode cur=head;
	int val=0;
    while(val<this.size())
	{ if(cur.getStr().startsWith(prefix))
	  { link.addToEnd(cur.getStr());  }
	  cur=cur.getNext();
	  val++;
	}
  }
  
  public StringList hasSubstring(String substring)
  { StringList link=new IterativeList();
    OONode cur=head;
	for(int i=0;i<this.size();i++)
	{ if(cur.getStr().contains(substring.toCharArray()))
	  { link.addToEnd(cur.getStr());  }
	  cur=cur.getNext();
	}
  }
}