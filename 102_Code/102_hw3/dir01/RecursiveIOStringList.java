
public class RecursiveIOStringList implements StringList {

	private RecursiveIONode node;
	public RecursiveIOStringList()
	{
		node = new RIOEmpty();
	}
	public void addToEnd(String element) {
		// TODO Auto-generated method stub
		if (node instanceof RIOEmpty)
		{
			node = new RIONode(element);
		}
		else
		{
			addToEnd(element,node);
		}
	}
	private void addToEnd(String element,RecursiveIONode n) {
		if (n.next() instanceof RIOEmpty)
		{
			n.setNext(new RIONode(element));
		}
		else
		{
			addToEnd(element,n.next());
		}
	}
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		if(index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index == 0)
		{
			RecursiveIONode temp = new RIONode(element);
			temp.setNext(node);
			node = temp;
		}
		else if(index == 1)
		{
			RecursiveIONode temp = new RIONode(element);
			temp.setNext(node.next());
			node.setNext(temp);
		}
		else
		{
			add(index-1,element,node.next());
		}
	}
	private void add(int index, String element,RecursiveIONode n) {
		if(index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		if((n instanceof RIOEmpty)&&(index == 1))
		{
			RecursiveIONode temp = new RIONode(element);
			temp.setNext(n.next());
			n.setNext(temp);
		}
		else if(index == 1)
		{
			RecursiveIONode temp = new RIONode(element);
			temp.setNext(n.next());
			n.setNext(temp);
		}
		else
		{
			add(index-1,element,n.next());
		}
	}
	@Override
	public String remove(int index) {
		// TODO Auto-generated method stub
		if(index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index == 0)
		{
			String temp = node.str();
			node = node.next();
			return temp;
		}
		return remove(index,node);
	}
	public String remove(int index,RecursiveIONode n) {
		if(index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index == 1)
		{
			String temp = n.next().str();
			n.setNext(n.next().next());
			return temp;
		}
		return remove(index-1,n.next());
	}

	@Override
	public String get(int index) {
		if(index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		// TODO Auto-generated method stub
		return get(index,node);
	}
	private String get(int index,RecursiveIONode n) {
		if(n instanceof RIOEmpty)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index == 0)
		{
			return n.str();
		}
		return get(index-1,n.next());
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		return indexOf(element, -1,node);
	}
	private int indexOf(String element,int ind,RecursiveIONode n) {
		if(n.str().equals(element))
		{
			return ind+1;
		}
		return indexOf(element,ind+1,n.next());
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size(node);
	}
	private int size(RecursiveIONode n) {
		if (n instanceof RIOEmpty)
		{
			return 0;
		}
		else
		{
			return 1+size(n.next());
		}
	}

	@Override
	public StringList toLowerCase() {
		// TODO Auto-generated method stub
		StringList L = new RecursiveIOStringList();
		((RecursiveIOStringList)L).node = allLowered(node);
		return L;
	}
	private RecursiveIONode allLowered(RecursiveIONode n)
	{
		if(n instanceof RIOEmpty)
		{
			return new RIOEmpty();
		}
		RecursiveIONode temp = new RIONode(n.str().toLowerCase());
		temp.setNext(allLowered(n.next()));
		return temp;
	}
	
	@Override
	public StringList toUpperCase() {
		// TODO Auto-generated method stub
		StringList L = new RecursiveIOStringList();
		((RecursiveIOStringList)L).node = allUppered(node);
		return L;
	}
	private RecursiveIONode allUppered(RecursiveIONode n)
	{
		if(n instanceof RIOEmpty)
		{
			return new RIOEmpty();
		}
		RecursiveIONode temp = new RIONode(n.str().toUpperCase());
		temp.setNext(allUppered(n.next()));
		return temp;
	}
	@Override
	public StringList startsWith(String prefix) {
		StringList L = new RecursiveIOStringList();
		((RecursiveIOStringList)L).node = statsWith(prefix,node);
		return L;
	}
	private RecursiveIONode statsWith(String prefix,RecursiveIONode n)
	{
		if(n instanceof RIOEmpty)
		{
			return new RIOEmpty();
		}
		else if(n.str().startsWith(prefix))
		{
			RecursiveIONode temp = new RIONode(n.str());
			temp.setNext(statsWith(prefix,n.next()));
			return temp;
		}
		else
		{
			return statsWith(prefix,n.next());
		}
	}

	@Override
	public StringList hasSubstring(String substring) {
		StringList L = new RecursiveIOStringList();
		((RecursiveIOStringList)L).node = hasSubStr(substring,node);
		return L;
	}
	private RecursiveIONode hasSubStr(String substring,RecursiveIONode n)
	{
		if(n instanceof RIOEmpty)
		{
			return new RIOEmpty();
		}
		else if(n.str().contains(substring))
		{
			RecursiveIONode temp = new RIONode(n.str());
			temp.setNext(hasSubStr(substring,n.next()));
			return temp;
		}
		else
		{
			return hasSubStr(substring,n.next());
		}
	}

}
