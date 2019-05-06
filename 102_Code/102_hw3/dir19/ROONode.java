import java.lang.UnsupportedOperationException;
import java.lang.IndexOutOfBoundsException;

public class ROONode
	implements RecursiveOONode
{
	private String myString;
	private RecursiveOONode nextNode;

	public ROONode(String myString, RecursiveOONode nextNode)
	{
		this.myString = myString;
		this.nextNode = nextNode;
	}	

	public String thisString()
	{
		return this.myString;
	}

	public RecursiveOONode nextNode()
	{
		return this.nextNode;
	}

	public RecursiveOONode addToEnd(String element)
	{
		RecursiveOONode n = this.nextNode.addToEnd(element);
		nextNode = n;
		return this;
	}

   public RecursiveOONode add(int index, String element)
	{
		if (index == 0)
		{
			ROONode n = new ROONode(element,this);
			return n;
		}
		else
		{
			this.nextNode = this.nextNode.add(index-1,element);
			return this;
		}
	}
			
   public RecursiveOONode remove(int index)
	{
		if (index == 0)
		{
			return nextNode;
		}
		else if (this.size() > index)
		{
			nextNode = this.nextNode.remove(index-1);
			return this;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

   public String get(int index)
	{
		if (index == 0)
		{
			return nextNode.thisString();
		}
		else if (this.size() > index)
		{
			myString = nextNode.get(index-1);
			return nextNode.thisString();
		}
		else
		{
			throw new IndexOutOfBoundsException();
	}

   public int indexOf(String element)
	{
		if (this.myString.equals(element))
		{
			return 0;
		}
		else
		{
			return 1 + this.nextNode.indexOf(element);
		}
	}

   public int size()
	{
		if (this.nextNode == null)
		{
			return 0;
		}
		else
		{
			return 1 + this.nextNode.size();
		}
	}

   public StringList toLowerCase()
	{
		if (this.nextNode == null)
		{
			return (StringList)this;
		}
		else
		{
			StringList lowerList = nextNode.toLowerCase();
			lowerList.addToEnd(myString.toLowerCase());
			return lowerList;
		}	
	}

   public StringList toUpperCase()
	{
		if (this.nextNode == null)
		{
			return (StringList)this;
		}
		else
		{
			StringList upperList = nextNode.toUpperCase();
			upperList.addToEnd(myString.toUpperCase());
			return upperList;
		}	
	}

   public StringList startsWith(String prefix)
	{
		if (this.nextNode == null)
		{
			return (StringList)this;
		}
		else
		{
			StringList starts = nextNode.startsWith(prefix);
			if (myString.startsWith(prefix))
			{
				starts.addToEnd(myString);
			}
			return starts;
		}	
	}

   public StringList hasSubstring(String substring)
	{
		if (this.nextNode == null)
		{
			return (StringList)this;
		}
		else
		{
			StringList subs = nextNode.hasSubstring(substring);
			if (myString.contains(substring))
			{
				subs.addToEnd(myString);
			}
			return subs;
		}	
	}
}















