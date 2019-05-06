
public class RecursiveOOStringList implements StringList {

	private RecursiveOONode node;
	public RecursiveOOStringList()
	{
		node = new ROOEmpty();
	}
	@Override
	public void addToEnd(String element) {
		// TODO Auto-generated method stub
		node.addEnd(element, node);
	}

	@Override
	public void add(int index, String element) {
		// TODO Auto-generated method stub
		if(index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index == 0)
		{
			RecursiveOONode temp = new ROONode(element);
			temp.setNext(node);
			node = temp;
		}
		else
		{
			node.add(index,element);
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
		return node.remove(index);
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		if(index<0)
		{
			throw new IndexOutOfBoundsException();
		}
		return node.get(index);
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		return node.find(element, -1);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return node.size();
	}

	@Override
	public StringList toLowerCase() {
		// TODO Auto-generated method stub
		StringList L = new RecursiveOOStringList();
		((RecursiveOOStringList)L).node = node.allLowered();
		return L;
	}

	@Override
	public StringList toUpperCase() {
		// TODO Auto-generated method stub
		StringList L = new RecursiveOOStringList();
		((RecursiveOOStringList)L).node = node.allUppered();
		return L;
	}

	@Override
	public StringList startsWith(String prefix) {
		StringList L = new RecursiveOOStringList();
		((RecursiveOOStringList)L).node = node.statsWith(prefix);
		return L;
	}

	@Override
	public StringList hasSubstring(String substring) {
		StringList L = new RecursiveOOStringList();
		((RecursiveOOStringList)L).node = node.hasSubStr(substring);
		return L;
	}

}
