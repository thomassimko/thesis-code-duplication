import java.util.NoSuchElementException;

public class IterativeStringList
implements StringList
{
    private IterativeNode head;
    public IterativeStringList()
    {
	this.head=null;
    }

    public void addToEnd(String element)
    {
	IterativeNode n= new IterativeNode(element, null);
	if (this.head==null)
	    this.head=n;
	else
	    {
		IterativeNode cur=this.head;
		while (cur.getNext() != null)
		    {
			cur=cur.getNext();
		    }
		cur.setNext(n);
	    }
    }

    public void add(int index, String element)
    {
	if(this.head==null)
	    {
		if(index==0)
		    {
			this.head= new IterativeNode(element, null);
		    }
		else
		    {
			throw new IndexOutOfBoundsException();
		    }
	    }
	else
	    {
		if(index==0)
		    this.head=new IterativeNode(element,this.head.getNext());
		else if(index<0)
		    throw new IndexOutOfBoundsException();
		else
		    {
			IterativeNode cur=head;
			for(int i=0; i<index; i++)
			    {
				cur=cur.getNext();
			    }
			if (cur==null)
			    {
				throw new IndexOutOfBoundsException();
			    }
			else
			    {
			        IterativeNode node = new IterativeNode(element, cur.getNext());
				cur.setNext(node);
			    }
		  
		    }
	    }
    }

public void remove(int index);
{
    if(index==0)
	this.head=this.head.getNext();
    else if(index<0)
	throw new IndexOutOfBoundsException();
    else
        {
            IterativeNode cur=head;
            for(int i=0; i<index; i++)
		{
		    cur=cur.getNext();
		}
	    if (cur==null)
		{
		    throw new IndexOutOfBoundsException();
		}
	    else
		{
		    cur.setNext(cur.getNext().getNext());
	       
		}
	}
}
    public String get(int index)
    {
        if(index==0)
	    return this.head.getValue();
        else if(index<0||head==null)
            throw new IndexOutOfBoundsException();
        else
	    {
		IterativeNode cur=head;
		for(int i=0; i<index; i++)
		    {
			cur=cur.getNext();
		    }
		if (cur==null)
		    {
			throw new IndexOutOfBoundsException();
		    }
		else
		    {
			return cur.getValue();
		    }

	    }
    }
	public int indexOf(String element)
	{
	    int i=0;
	    IterativeNode cur=head;
	    for (int i=0; i<this.size(); i++)
		{
		    if(cur.getValue().equals(element))
			{
			    return i;
			}
		    if (cur==null)
			{
			    throw new IndexOutOfBoundsException();
			}
		    else
			{
			    cur=cur.getNext();
			}

		}
	}

	    public int size()
	    {
		int i=0;
		IterativeNode cur=head;
		while(cur.getNext!= null)
		    {
			cur=cur.getNext();
			i++;
		    }
		return i;
	    }

	    public StringList toLowerCase()
	    {
		StringList lowercaselist = new StringList();
		IterativeNode cur=head;
		while(cur!= null)
		    { 
			lowercaselist.addToEnd(cur.getValue().toLowerCase());
			cur=cur.getNext();
		    }
		return lowercaselist;
	    }

	    public StringList toUpperCase()
	    {
		StringList uppercaselist = new StringList();
		IterativeNode cur=head;
		while(cur!= null)
		    { 
			uppercaselist.addToEnd(cur.getValue().toUpperCase());
			cur=cur.getNext();
		    }
		return uppercaselist;
	    }

	    public StringList startsWith(String prefix)
	    {
		StringList startswithlist = new StringList();
		IterativeNode cur=head;
		while(cur!= null)
		    { 
			if(cur.getValue().startsWith(prefix))
			    {
				startswithlist.addToEnd(cur.getValue());
			    }
			cur=cur.getNext();
		    }
		return uppercaselist;
	    }

	    public StringList hasSubstring(String substring)
	    {
		StringList containslist = new StringList();
		IterativeNode cur=head;
		while(cur!= null)
		    { 
			if(cur.getValue().contains(prefix))
			    {
				containslist.addToEnd(cur.getValue());
			    }
			cur=cur.getNext();
		    }
		return containslist;
	    }
}
