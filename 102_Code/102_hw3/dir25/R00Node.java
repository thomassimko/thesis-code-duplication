
public class R00Node implements R00 {


	private String value;
	private R00 next;
	public R00Node (String value, R00 next)
	{
		this.value = value;
		this.next = next;
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public R00 getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public void setNext(R00 n) {
		// TODO Auto-generated method stub
		next = n;

	}

	@Override
	public R00 addToEnd(String element) {
		// TODO Auto-generated method stub
		this.next = this.next.addToEnd(element);
		return this;
	}

	@Override
	public R00 add(int index, String element) {
		// TODO Auto-generated method stub
		if (index==0)
		{
			R00 n = new R00Node(element, this);
			return n;
		}
		else
		{
			next = next.add(index-1, element);
		}
		return this;
	}

	@Override
	public R00 remove(int index) {
		// TODO Auto-generated method stub

		if ( index == 0 )
		{
			return this.next;
		}

		this.next = this.next.remove(index);
		return this;
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		String  name;
		if ( index == 0)
		{
			name = this.getValue();
		}
		else
		{
			name = next.get(index-1);
		}
	
		return name;
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		int index;
		if ( this.getValue().equals(element))
		{
			return 0;
		}
		index = next.indexOf(element) + 1;
		return index;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int count = 0;
		count = next.size();
		return count+1;
	}

	@Override
	public StringList toLowerCase() {
		// TODO Auto-generated method stub
		StringList knew = next.toLowerCase();
		knew.add(0, this.value.toLowerCase());
		return knew;
		
	}

	@Override
	public StringList toUpperCase() {
		// TODO Auto-generated method stub
		StringList knew = next.toUpperCase();
		knew.add(0, this.value.toUpperCase());
		return knew;
	}

	@Override
	public StringList startsWith(String prefix) {
		// TODO Auto-generated method stub
		StringList knew = next.startsWith(prefix);
		if (this.value.startsWith(prefix) )
		{
			knew.add(0, this.value);
		}
		return knew;
	}

	@Override
	public StringList hasSubstring(String substring) {
		// TODO Auto-generated method stub
		StringList knew = next.hasSubstring(substring);
		if (this.value.contains(substring) )
		{
			knew.add(0, this.value);
		}
		return knew;
	}

}
