
public class RecursiveIOStringList implements StringList {
	private RIO head;

	public RecursiveIOStringList()
	{
		head = new RIOEmpty();
		
	}
	@Override
	public void addToEnd(String element) {
		// TODO Auto-generated method stub
		head = addToEndHelper(element, head);

	}
	private RIO addToEndHelper(String element, RIO cur)
	{
		if ( cur instanceof RIOEmpty )
		{
			RIO n = new RIONode(element, cur);
			return n;
		}
		else
		{
			RIO n = addToEndHelper(element, ((RIONode)cur).getNext());
			((RIONode)cur).setNext(n);
			return cur;
		}
	}


	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		head = add(index, element, head);
	}
	
	private RIO add(int index, String element, RIO cur)
	{
		if (cur instanceof RIOEmpty && index==0)
		{
			RIO n = new RIONode(element, cur);
			return n;
		}
		else if (cur instanceof RIONode)
		{
			if (index==0)
			{
				RIO n = new RIONode(element, cur);
				return n;
			}
			else 
			{
				RIO n = add(index-1, element, ((RIONode)cur).getNext());
				((RIONode)cur).setNext(n);
				return cur;
			}
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
		
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		if ( index == 0)
		{
			head = head.getNext();
		}
		else
		{
			remove(index, head);
		}

	}
	private void remove(int index, RIO cur)
	{
		if ( cur instanceof RIOEmpty )
		{
			throw new IndexOutOfBoundsException();
		}
		else if ( cur instanceof RIONode)
		{
			if ( index == 1)
			{
				cur.setNext(cur.getNext().getNext());
			}
			remove(index-1, cur.getNext());
		}

		
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		if ( index == 0)
		{
			return head.getValue();
		}
		return get(index, head);
	}
	
	private String get(int index, RIO cur)
	{
		String value;
		if (cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		else if ( cur instanceof RIONode)
		{
			if ( index == 0 )
			{
				value = cur.getValue();
				return value;
			}
		}
		value = get(index-1, cur.getNext());
		return get(index-1, cur.getNext());
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		if ( element == head.getValue())
		{
			return 0;
		}
		return indexOf(element, head, 0);
	}
	private int indexOf(String element, RIO cur, int count)
	{

		if ( cur instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		else if ( cur instanceof RIONode )
		{
			if ( cur.getValue().equals(element))
			{
				return count;
			}
		}
		return indexOf(element, cur.getNext(), count+1);
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size(head);
	}
	
	private int size(RIO cur)
	{
		int count = 0;
		if ( cur instanceof RIOEmpty)
		{
			return 0;
		}
		else
		{
			count = size(cur.getNext()) + 1;
			return count;
		}
	}

	@Override
	public StringList toLowerCase() {
		// TODO Auto-generated method stub
		return toLowerCaseHelper(head);
		
	}
	
	private StringList toLowerCaseHelper(RIO cur)
	{
		if ( cur instanceof RIOEmpty)
		{
			return (StringList) new RecursiveIOStringList();
		}

			StringList knew = toLowerCaseHelper(cur.getNext());
			knew.add(0, cur.getValue().toLowerCase());
			return knew;		
	}

	@Override
	public StringList toUpperCase() {
		// TODO Auto-generated method stub
		return toUpperCaseHelper(head);
	}
	private StringList toUpperCaseHelper(RIO cur)
	{
		if ( cur instanceof RIOEmpty)
		{
			return (StringList) new RecursiveIOStringList();
		}

			StringList knew = toUpperCaseHelper(cur.getNext());
			knew.add(0, cur.getValue().toUpperCase());
			return knew;	
	}

	@Override
	public StringList startsWith(String prefix) {
		// TODO Auto-generated method stub
		return startsWithHelper(prefix, head);
	}
	private StringList startsWithHelper(String prefix, RIO cur)
	{
		if ( cur instanceof RIOEmpty)
		{
			return (StringList) new RecursiveIOStringList();
		}

			StringList knew = startsWithHelper(prefix, cur.getNext());
			if ( cur.getValue().startsWith(prefix)) 
			{
				knew.add(0, cur.getValue());
			}
			return knew;	
	}

	@Override
	public StringList hasSubstring(String substring) {
		// TODO Auto-generated method stub
		return hasSubstringHelper(substring, head);
	}
	
	private StringList hasSubstringHelper(String substring, RIO cur)
	{
		if ( cur instanceof RIOEmpty)
		{
			return (StringList) new RecursiveIOStringList();
		}
		StringList knew = startsWithHelper(substring, cur.getNext());
		if ( cur.getValue().contains(substring) )
		{
			knew.add(0, cur.getValue());
		}
		return knew;
	}
}
