import java.util.NoSuchElementException;


public class IterativeStringList
		implements StringList
{
	private IterativeNode head = null;

	
	public void addToEnd(String element) 
	{
		IterativeNode tempNode, previousNode;
		tempNode = head;
		previousNode = head;
		while(tempNode != null)
		{
			previousNode = tempNode;
			tempNode = tempNode.getNext(); 
		}
		if(head == null)
		{
			head = new IterativeNode(element, null);
		}
		else
		{
			previousNode.setNext(new IterativeNode(element, null));
		}
		
	}
		
	
	public void add(int index, String element) 
	{
		IterativeNode tempNode, previousNode;
		int ind = 0;
		tempNode = head;
		previousNode= head;
		while(tempNode != null && ind < index)
		{
			ind++;
			previousNode = tempNode;
			tempNode = tempNode.getNext();
		}
		if(head == null)
		{
			head = new IterativeNode(element, null);
		}
		if(index == 0)
		{
			head = new IterativeNode(element, previousNode);
		}
		else if(ind < index)
		{
			throw new NoSuchElementException();
		}
		else
		{
			previousNode.setNext(new IterativeNode(element, tempNode));
		}
		
	}

	public String remove(int index) 
	{
		IterativeNode tempNode, previousNode;
		int ind = 0;
		tempNode = head;
		previousNode= head;
		while(tempNode != null && ind < index)
		{
			ind++;
			previousNode = tempNode;
			tempNode = tempNode.getNext();
		}
		if(head == null || ind < index)
		{
			throw new NoSuchElementException();
		}
		else if(index == 0)
		{
			head = tempNode.getNext();
			return previousNode.getVal();
		}
		else
		{
			previousNode.setNext(tempNode.getNext());
			return tempNode.getVal();
		}
	}


	public String get(int index) 
	{
		IterativeNode tempNode;
		int ind = 0;
		tempNode = head;
		while(tempNode != null && ind < index)
		{
			ind++;
			tempNode = tempNode.getNext();
		}
		if(ind < index || head == null)
		{
			throw new NoSuchElementException();
		}
		else if(index == 0)
		{
			return head.getVal();
		}
		else
			return tempNode.getVal();
		
	}

	public int indexOf(String element)
	{
		IterativeNode tempNode;
		tempNode = head;
		int index = 0;
		while(tempNode != null)
		{
			if(tempNode.getVal().equals(element))
			{
				return index;
			}
			index++;
			tempNode = tempNode.getNext();			
		}
		return -1;
	}

	public int size() {
		IterativeNode tempNode;
		tempNode = head;
		int index = 0;
		while(tempNode != null)
		{
			index++;
			tempNode = tempNode.getNext();			
		}
		return index;
	}

	public StringList toLowerCase() 
	{
		IterativeNode tempNode;
		tempNode = head;
		StringList list = new IterativeStringList();
		while(tempNode != null)
		{
			list.addToEnd(tempNode.getVal().toLowerCase());
			tempNode = tempNode.getNext(); 
		}
		return list;
	}

	public StringList toUpperCase() {
		IterativeNode tempNode;
		tempNode = head;
		StringList list = new IterativeStringList();
		while(tempNode != null)
		{
			list.addToEnd(tempNode.getVal().toUpperCase());
			tempNode = tempNode.getNext(); 
		}
		return list;
	}

	public StringList startsWith(String prefix) {
		IterativeNode tempNode;
		tempNode = head;
		StringList list = new IterativeStringList();
		while(tempNode != null)
		{
			if(tempNode.getVal().startsWith(prefix))
			{
				list.addToEnd(tempNode.getVal());
			}
			tempNode = tempNode.getNext(); 
		}
		return list;
	}

	public StringList hasSubstring(String substring) {
		IterativeNode tempNode;
		tempNode = head;
		StringList list = new IterativeStringList();
		while(tempNode != null)
		{
			if(tempNode.getVal().contains(substring))
			{
				list.addToEnd(tempNode.getVal());
			}
			tempNode = tempNode.getNext(); 
		}
		return list;
	}

}
