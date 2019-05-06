import java.lang.IndexOutOfBoundsException;
public class IterativeStringList implements StringList {
	
	private Node head;
	
	public IterativeStringList()
	{
		this.head = null;
	}
	
	@Override
	public void addToEnd(String element) {
		// TODO Auto-generated method stub
		Node n = new Node(element, null);
		Node cursor = head;
		if ( head == null)
		{
			head = n;
		}
		else
		{
			while ( cursor.getNext() != null)
			{
				cursor = cursor.getNext();
				
			}
			cursor.setNext(n);
		}
		
	}

	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		if (this.head == null)
		{
			if ( index == 0)
			{
				this.head = new Node(element,null);
			}
			else
			{
				throw new IndexOutOfBoundsException();
				
			}
		}
		else
		{
			if ( index == 0)
			{
				this.head = new Node(element, this.head);
			}
			else if ( index < 0)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				Node cur = head;
				for ( int i = 1; i < index && cur != null; i++)
				{
					cur = cur.getNext();
				}
				if ( cur == null)
				{
					throw new IndexOutOfBoundsException();
				} 
				else
				{
					Node n = new Node( element, cur.getNext());
					cur.setNext(n);
				}
			}
		}

	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		if ( index < 0 || index > size() )
		{
				throw new IndexOutOfBoundsException();	
		}
		else
		{
			Node cursor = head.getNext();
			for ( int i = 0; i < index-1; i++)
			{
				cursor = cursor.getNext(); /*cursor to be removed */
			}
			cursor.setNext(cursor.getNext().getNext());

			
			
		}
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		Node cursor = head;
		for ( int i = 0; cursor != null; i++)
		{
			if ( i == index)
			{
				return cursor.getValue();
			}
			cursor = cursor.getNext();
		}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		Node cursor = head;
		for ( int i = 0; cursor != null; i++)
		{
			if ( cursor.getValue() == element )
			{
				return i;
			}
			cursor = cursor.getNext();
		}
		throw new IndexOutOfBoundsException();
		
	}
;
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int i;
		Node cursor = head;
		for(i = 0; cursor != null; i++)
		{
			cursor = cursor.getNext();
		}
		return i;
	}

	@Override
	public StringList toLowerCase() {
		// TODO Auto-generated method stub
		IterativeStringList lowerCase = new IterativeStringList();
		Node cursor = head;
		
		while ( cursor != null )
		{
			lowerCase.addToEnd(cursor.getValue().toLowerCase());
			cursor = cursor.getNext();
		}
		return lowerCase;
		
	}

	@Override
	public StringList toUpperCase() {
		// TODO Auto-generated method stub
		IterativeStringList upperCase = new IterativeStringList();
		Node cursor = head;
		while ( cursor != null)
		{
			upperCase.addToEnd(cursor.getValue().toUpperCase());
			cursor = cursor.getNext();
		}
		return upperCase;
	}

	@Override
	public StringList startsWith(String prefix) {
		// TODO Auto-generated method stub
		IterativeStringList startsWith = new IterativeStringList();
		Node cursor = head;
		while ( cursor != null)
		{
			if (cursor.getValue().startsWith(prefix))
			{
				startsWith.addToEnd(prefix);	
			}
			cursor = cursor.getNext();
		}
		return startsWith;
	}

	@Override
	public StringList hasSubstring(String substring) {
		// TODO Auto-generated method stub
		IterativeStringList hasSubString = new IterativeStringList();
		Node cursor = head;
		while ( cursor != null)
		{
			if ( cursor.getValue().contains(substring))
			{
				hasSubString.addToEnd(cursor.getValue());
			}
			cursor = cursor.getNext();
		}
		return hasSubString;
	}

}
