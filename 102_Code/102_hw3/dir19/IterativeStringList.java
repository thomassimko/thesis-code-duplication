public class IterativeStringList
	implements StringList
{
	private IterativeNode headNode;
	
	public IterativeStringList(IterativeNode headNode)
	{
		this.headNode = headNode;
	}

	public void addToEnd(String element)
	{
		IterativeNode current;
		current = this.headNode;
		if (current == null)
		{
			headNode = new IterativeNode(element,null);
		}
		else
		{
			while (current.toNode() != null)
			{
				current = current.toNode();
			}
			IterativeNode addThisNode = new IterativeNode(element,null);
			current.setNext(addThisNode);
		}
	}

	public void add(int index, String element)
	{
		IterativeNode current;
		current = this.headNode;
		int count = 0;
		if ((current == null) || (index == 0))
		{
			addToEnd(element);	
		}
		else
		{
			while (count < index)
			{
				current = current.toNode();
			}
			IterativeNode addThisNode = new IterativeNode(element,null);
			current.setNext(addThisNode);
		}
	}

	public String remove(int index)
	{
		IterativeNode current;
		current = headNode;
		IterativeNode temp;
		temp = current;
		int count = 0;
		if (index == 0)
		{
			headNode = headNode.toNode().toNode();
		}
		else
		{
			while (count < index)
			{
				current = current.toNode();
				temp = current;
			}
			current.setNext(current.toNode().toNode());
		}
		return temp.toString();			
	}

	public String get(int index)
	{
		IterativeNode current;
		current = headNode;
		int count = 0;
		while (count < index)
		{
			current = current.toNode();
		}
		return current.toString();
	}

	public int indexOf(String element)
	{
		IterativeNode current;
		current = headNode;
		int count = 0;
		while (true)
		{
			current = current.toNode();
			if (current.toString().equals(element))
			{
				return count;
			}
			count++;
		}		
	}

	public int size()
	{
		IterativeNode current;
		current = headNode;
		int count = 0;
		while (current != null)
		{
			current = current.toNode();
			count++;
		}
		return count;
	}

	public StringList toLowerCase()
	{
		IterativeNode current;
		current = headNode;
		String str;
		String newStr;
		StringList linkList = new IterativeStringList(headNode);
		while (current != null)
		{
			str = current.toString();
			newStr = str.toLowerCase();
			linkList.addToEnd(newStr);
		}
		return linkList;
	}

	public StringList toUpperCase()
	{
		IterativeNode current;
		current = headNode;
		String str;
		String newStr;
		StringList linkList = new IterativeStringList(headNode);
		while (current != null)
		{
			str = current.toString();
			newStr = str.toUpperCase();
			linkList.addToEnd(newStr);
		}
		return linkList;
	}

	public StringList startsWith(String prefix)
	{
		IterativeNode current;
		current = headNode;
		String str;
		StringList linkList = new IterativeStringList(headNode);
		while (current != null)
		{
			str = current.toString();
			if (str.startsWith(prefix))
			{
				linkList.addToEnd(str);
			}
		}
		return linkList;
	}
	
	public StringList hasSubstring(String substring)
	{
		IterativeNode current;
		current = headNode;
		String str;
		StringList linkList = new IterativeStringList(headNode);
		while (current != null)
		{
			str = current.toString();
			if (str.contains(substring))
			{
				linkList.addToEnd(str);
			}
		}
		return linkList;
	}
}


































