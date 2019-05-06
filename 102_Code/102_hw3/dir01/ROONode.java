
public class ROONode implements RecursiveOONode {
	
	private String string;
	private RecursiveOONode next;
	public ROONode(String str)
	{
		this.string = str;
		this.next = new ROOEmpty();
	}
	@Override
	public String str() {
		// TODO Auto-generated method stub
		return this.string;
	}

	@Override
	public RecursiveOONode next() {
		// TODO Auto-generated method stub
		return this.next;
	}

	@Override
	public void setNext(RecursiveOONode n) {
		// TODO Auto-generated method stub
		this.next = n;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 1+this.next.size();
	}

	@Override
	public RecursiveOONode allLowered() {
		// TODO Auto-generated method stub
		RecursiveOONode n = new ROONode(this.string.toLowerCase());
		n.setNext(next.allLowered());
		return n;
	}

	@Override
	public RecursiveOONode allUppered() {
		// TODO Auto-generated method stub
		RecursiveOONode n = new ROONode(this.string.toUpperCase());
		n.setNext(next.allUppered());
		return n;
	}

	@Override
	public RecursiveOONode statsWith(String prefix) {
		// TODO Auto-generated method stub
		if(this.string.startsWith(prefix))
		{
			RecursiveOONode n = new ROONode(this.string);
			n.setNext(this.next.statsWith(prefix));
			return n;
		}
		return this.next.statsWith(prefix);
	}

	@Override
	public RecursiveOONode hasSubStr(String substring) {
		// TODO Auto-generated method stub
		if(this.string.contains(substring))
		{
			RecursiveOONode n = new ROONode(this.string);
			n.setNext(this.next.hasSubStr(substring));
			return n;
		}
		return this.next.hasSubStr(substring);
	}

	@Override
	public int find(String element,int n)
	{
		if (string.compareTo(element)==0)
		{
			return n+1;
		}
		return this.next.find(element, n+1);
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		if (index == 0)
		{
			return this.string;
		}
		return this.next.get(index - 1);
	}

	@Override
	public String remove(int index) {
		if (index == 1)
		{
			RecursiveOONode n = this.next;
			this.next = this.next.next();
			return n.str();
		}
		return this.next.remove(index-1);
	}

	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		if (index == 1)
		{
			RecursiveOONode n = this.next;
			this.next = new ROONode(element);
			this.next.setNext(n);
		}
		else
		{
			this.next.add(index-1, element);
		}
	}

	@Override
	public void addEnd(String element,RecursiveOONode n) {
		// TODO Auto-generated method stub
		this.next.addEnd(element,this);
	}
}
