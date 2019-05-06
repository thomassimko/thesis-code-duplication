import java.util.*;

public class RecursiveIOStringList
   implements StringList
{
   private RecursiveIONode head;
	
	public RecursiveIOStringList()
	{
	   head = new RIOEmpty();
	}
	
	public void addToEnd(String element)
	{
	   head = addToEnd(element, head);
	}
	
	private RecursiveIONode addToEnd(String element, RecursiveIONode node)
	{
	   if(node instanceof RIOEmpty)
		{
		   RecursiveIONode n = new RIONode(element, node);
			return n;
		}
		else
		{
		   RecursiveIONode n = addToEnd(element, ((RIONode)node).getNext());
			((RIONode)node).setNext(n);
			return node;
		}
	}
	
	public void add(int index, String element)
	{
	   head = add(index, element, head);
	}
	
	private RecursiveIONode add(int index, String element, RecursiveIONode node)
	{
	   if(node instanceof RIOEmpty && index == 0)
		{
		   RecursiveIONode n = new RIONode(element, node);
			return n;
		}
		else if(node instanceof RIONode)
		{
		   if(index == 0)
			{
			   RecursiveIONode n = new RIONode(element, node);
				return n;
			}
			else
			{
			   RecursiveIONode n = add(index-1, element, ((RIONode)node).getNext());
				((RIONode)node).setNext(n);
				return node;
			}
		}
		throw new IndexOutOfBoundsException();
	}
	
	public void remove(int index)
	{
	   head = remove(index, head);
	}
	
	private RecursiveIONode remove(int index, RecursiveIONode node)
	{
	   if(node instanceof RIOEmpty)
		{
		   throw new IndexOutOfBoundsException();
		}
		else
		{
		   if(index == 0) return node.getNext();
			else
			{
			   RecursiveIONode n = remove(index-1, ((RIONode)node).getNext());
				((RIONode)node).setNext(n);
				return node;
			}
		}
	}
	
	public String get(int index)
	{
	   return get(index, head);
	}
	
	private String get(int index, RecursiveIONode node)
	{
	   if(node instanceof RIOEmpty)
		{
		   throw new IndexOutOfBoundsException();
		}
		else
		{
		   if(index == 0) return node.getString();
			else
			{
			   String string = get(index-1, ((RIONode)node).getNext());
				return string;
			}
		}
	}
	
	public int indexOf(String element)
	{
	   return indexOf(element, head);
	}
	
	private int indexOf(String element, RecursiveIONode node)
	{
	   if(node instanceof RIOEmpty)
		{
		   throw new NoSuchElementException();
		}
		else
		{
		   if(((RIONode)node).getString().equals(element)) return 0;
			else return 1 + indexOf(element, (((RIONode)node).getNext()));
		}
	}
	
	public int size()
	{
	   return size(head);
	}
	
	private int size(RecursiveIONode node)
	{
	   if(node instanceof RIOEmpty) return 0;
	   else return 1 + size(((RIONode)node).getNext());
	}
	
	public StringList toLowerCase()
	{
	   return toLowerCase(head, new RecursiveIOStringList());
	}
	
	private StringList toLowerCase(RecursiveIONode node, StringList list)
	{
	   if(node instanceof RIOEmpty) return list;
		else
		{
		   list = toLowerCase(((RIONode)node).getNext(), list);
		   list.add(0, ((RIONode)node).getString().toLowerCase());
			return list;
		}
	}
	
	public StringList toUpperCase()
	{
	   return toUpperCase(head, new RecursiveIOStringList());
	}
	
	private StringList toUpperCase(RecursiveIONode node, StringList list)
	{
	   if(node instanceof RIOEmpty) return list;
		else
		{
		   list = toUpperCase(((RIONode)node).getNext(), list);
			list.add(0, ((RIONode)node).getString().toUpperCase());
			return list;
		}
	}
	
	public StringList startsWith(String prefix)
	{
	   return startsWith(head, prefix, new RecursiveIOStringList());
	}
	
	private StringList startsWith(RecursiveIONode node, String prefix, StringList list)
	{
	   if(node instanceof RIOEmpty) return list;
		else
		{
		   list = startsWith(((RIONode)node).getNext(), prefix, list);
			if(((RIONode)node).getString().startsWith(prefix)) list.add(0, ((RIONode)node).getString());
			return list;
		}
	}
	
	public StringList hasSubstring(String substring)
	{
	   return hasSubstring(head, substring, new RecursiveIOStringList());
	}
	
	private StringList hasSubstring(RecursiveIONode node, String substring, StringList list)
	{
	   if(node instanceof RIOEmpty) return list;
		else
		{
		   list = hasSubstring(((RIONode)node).getNext(), substring, list);
			if(((RIONode)node).getString().contains(substring)) list.add(0, ((RIONode)node).getString());
			return list;
		}
	}
}
