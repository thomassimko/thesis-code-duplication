public class IterativeList
implements StringList
{ public Node head;
  
  public IterativeList()
  { head=null;  }
  
  public void addToEnd(String v)
  { Node n=new Node(v,null);
    if(head==null)
	{ head=n;   }
	else
	{ Node cur=head;
	  while(cur.getNext()!=null)
	  { cur=cur.getNext();  }
	  cur.setNext(n);
	}
  }
  
  public void add(int index, String v)
  { if(index==0)
    { if(head==null)
	  { head=new Node(v,null);  }
	  else
	  { head=new Node(v,head);  }
	}
	
	else
	{ Node cur=head;
	  while(cur.getNext()!=null)
	  { for(int i=0;i<index;i++)
	    { cur=cur.getNext();  }
	  }
	  Node get=new Node(v,cur.getNext());
	  cur.setNext(get);
	}
	throw new IndexOutOfBoundsException();
  }
  
  public String remove(int index)
  { Node cur=head;
    if(index==0)
	{ if(head!=null)
	  { head=head.getNext();
	    return head;
	  }
	}
	else
	{ while(cur.getNext()!=null)
	  { for(int i=0;i<index;i++)
	    { n=n.getNext();  }
	    n.setNext(n.getNext().getNext());
	  }
	}
	throw new IndexOutOfBoundsException();
  }
  
  public String get(int index)
  { Node cur;
    cur=head;
    if(index==0)
    { if(head!=null)
	  { return head.getStr();  }
	}
	else
	{ while(cur.getNext()!=null)
	  { for(int i=0;i<index;i++)
	    { cur=cur.getNext();  }
	  }
	  cur.getStr();
	}
	throw new IndexOutOfBoundsException();
  }
  
  public int indexOf(String element)
  { int val=0;
    Node cur;
	cur=head;
    while(val<this.size())
	{ if(cur.getStr().equals(element))
	  { return val;  }
	  val++;
	}
  }
  
  public int size()
  { int val=0;
    Node cur=head;
	while(cur.getNext()!=null)
	{ cur=cur.getNext();
	  val++;
	}
	return val;
  }
  
  public StringList toLowerCase()
  { StringList link=new IterativeList();
    Node cur=head;
    for(int i=0;i<this.size();i++)
    { link.addToEnd(cur.getStr().toLowerCase());  }
	return link;
  }
  
  public StringList toUpperCase()
  { StringList link=new IterativeList();
    Node cur=head;
    for(int i=0;i<this.size();i++)
    { link.addToEnd(cur.getStr().toLowerCase());  }
	return link;
  }
  
  public StringList startsWith(String prefix)
  { StringList link=new IterativeList();
    Node cur=head;
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
    Node cur=head;
	for(int i=0;i<this.size();i++)
	{ if(cur.getStr().contains(substring.toCharArray()))
	  { link.addToEnd(cur.getStr());  }
	  cur=cur.getNext();
	}
  }
}