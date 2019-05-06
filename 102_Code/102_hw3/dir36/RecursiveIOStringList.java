
public class RecursiveIOStringList
implements StringList
{
	private RecursiveIONode head;
	private RecursiveIONode temp;
	
	public RecursiveIOStringList()
	{
		head = new RIOEmpty();
	}
	public void addToEnd(String element)
	{
		head = addToEndHelper(element, head);
	}
	public RecursiveIONode addToEndHelper(String element, RecursiveIONode temp)
	{
		if(temp instanceof RIOEmpty)
		{
			RecursiveIONode n = new RIONode(element, temp);
			return n;
		}
		else
		{
			RecursiveIONode n = addToEndHelper(element, temp.next());
			temp.setNext(n);
			return temp;
		}
	}
	public void add(int index, String element)
	{
		head = add(index, element, head);
	}
	public RecursiveIONode add(int index, String element, RecursiveIONode temp)
	{
		if(temp instanceof RIOEmpty && index ==0)
		{
			RecursiveIONode n = new RIONode(element, temp);
			return n;
		}
		else
		{
			if(temp instanceof RIONode)
			{
				if(index==0)
				{
					RecursiveIONode n = new RIONode(element, temp);
					return n;
				}
				else
				{
					RecursiveIONode n = add(index-1, element, temp.next());
					temp.setNext(n);
					return temp;
				}	
			}
			else
			{
				throw new IndexOutOfBoundsException("Index Out Of Bounds: " + index);
			}
		}
	}
	
	public String remove(int index)
	{
		String s = get(index);
		head = removeHelper(index, head);
		return s;
	}
	public RecursiveIONode removeHelper(int index, RecursiveIONode temp)
	{
		if(temp instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		}
		else
		{
			if(index > 0)
			{
				RecursiveIONode n = removeHelper(index-1, temp.next());
				temp.setNext(n);
				return temp;
			}
			if(index==0)
			{
				return temp.next();
			}
			else
			{
				throw new IndexOutOfBoundsException("Index Out Of Bounds: " + index);
			}
		}
	}

	public String get(int index)
	{
		temp = getHelper(index, head);
		return temp.getValue();
	}
	private RecursiveIONode getHelper(int index, RecursiveIONode temp)
	{
		if(index > 0)
		{
			temp = getHelper(index -1, temp.next());
			return temp;
		}
		if(index == 0)
		{
			return temp;
		}
		else
		{
			throw new IndexOutOfBoundsException("Index Out Of Bounds: " + index);
		}
	}

	public int indexOf(String element)
	{
		return indexOfHelper(element, head);
	}
	private int indexOfHelper(String element, RecursiveIONode temp)
	{
		if(temp instanceof RIONode)
		{
			if(temp.getValue().equals(element))
			{
				return 0;
			}
			else
			{
				return  1 + indexOfHelper(element, temp.next());
			}
		}
		else
		{
			throw new UnsupportedOperationException("No Such Element");
		}
	}
	public int size()
	{
		return size(head);
	}
	private int size (RecursiveIONode temp)
	{
		if(temp instanceof RIOEmpty)
		{
			return 0;
		}
		else
		{
			return 1 + size(temp.next());
		}
	}

	public StringList toLowerCase()
	{
		RecursiveIOStringList r = new RecursiveIOStringList();
		r.changeHead(toLowerCaseHelper(head)); 
		return r;
	}
	private RecursiveIONode toLowerCaseHelper(RecursiveIONode temp)
	{
		if(temp instanceof RIONode)
		{
			RecursiveIONode t = toLowerCaseHelper(temp.next());
			RecursiveIONode n = new RIONode(temp.getValue().toLowerCase(), t);
			return n;
		}
		else
		{
			RecursiveIONode n = new RIOEmpty();
			return n;
		}
	}

	public StringList toUpperCase()
	{
		RecursiveIOStringList r = new RecursiveIOStringList();
		r.changeHead(toUpperCaseHelper(head)); 
		return r;
	}
	
	private RecursiveIONode toUpperCaseHelper(RecursiveIONode temp)
	{
		if(temp instanceof RIONode)
		{
			RecursiveIONode t = toUpperCaseHelper(temp.next());
			RecursiveIONode n = new RIONode(temp.getValue().toUpperCase(), t);
			return n;
		}
		else
		{
			RecursiveIONode n = new RIOEmpty();
			return n;
		}
	}

	public StringList startsWith(String prefix)
	{
		RecursiveIOStringList r = new RecursiveIOStringList();
		r.changeHead(startsWithHelper(prefix, head));
		return r;
	}
	private RecursiveIONode startsWithHelper(String prefix, RecursiveIONode temp)
	{
		if(temp instanceof RIONode)
		{
			RecursiveIONode n;
			if(temp.getValue().startsWith(prefix))
			{
				n = new RIONode(temp.getValue(), startsWithHelper(prefix, temp.next()));
			}
			else
			{
				return startsWithHelper(prefix, temp.next());
			}
			return n;
		}
		else
		{
			RecursiveIONode n = new RIOEmpty();
			return n;
		}
	}
	public void changeHead(RecursiveIONode h)
	{
		head = h;
	}
	public StringList hasSubstring(String substring) 
	{
		RecursiveIOStringList r = new RecursiveIOStringList();
		r.changeHead(hasSubstringHelper(substring, head));
		return r;
	}
	private RecursiveIONode hasSubstringHelper(String substring, RecursiveIONode temp)
	{
		if(temp instanceof RIONode)
		{
			RecursiveIONode n;
			if(temp.getValue().indexOf(substring) > 0)
			{
				n = new RIONode(temp.getValue(), hasSubstringHelper(substring, temp.next()));
			}
			else
			{
				return hasSubstringHelper(substring, temp.next());
			}
			return n;
		}
		else
		{
			RecursiveIONode n = new RIOEmpty();
			return n;
		}
	}

}
