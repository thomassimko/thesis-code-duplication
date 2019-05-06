import java.util.NoSuchElementException;


public class IterativeStringList implements StringList {
	private IterativeNode node = null;
	@Override
	public void addToEnd(String element) {
		if(node == null)
		{
			node = new IterativeNode(element);
		}
		else{
		IterativeNode n = node;
		while(n.next() != null)
		{
			n = n.next();
		}
		n.setNext(new IterativeNode(element));
	}}

	@Override
	public void add(int index, String element) {
		IterativeNode n = node;
		if(index == 0)
		{
			node = new IterativeNode(element);
			node.setNext(n);
		}
		else
		{
		for(int i = index-1;i>0;i-=1)
		{
			if (n == null) throw new NoSuchElementException();
			n = n.next();
		}
		IterativeNode nn = n.next();
		n.setNext(new IterativeNode(element));
		n.next().setNext(nn);}}

	@Override
	public String remove(int index) {
		// TODO Auto-generated method stub
		if (index == 0)
		{
			IterativeNode n = node;
			node = node.next();
			return n.str();
		}
		IterativeNode n = node;
		for(int i = index;i>1;i-=1)
		{
			n = n.next();
			if (n.next() == null) throw new NoSuchElementException();
		}
		IterativeNode ret;
		IterativeNode nn = n.next().next();
		ret = n.next();
		n.setNext(nn);
		return ret.str();
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		IterativeNode n = node;
		for(int i = index;i>0;i-=1)
		{
			if (n == null)
			{
				throw new NoSuchElementException();
			}
			n = n.next();
		}
		return n.str();
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		IterativeNode n = node;
		int i = 0;
		while(n.str().compareTo(element) != 0)
		{
			n = n.next();
			i++;
			if (n == null)
				throw new NoSuchElementException();
		}
		return i;
	}

	@Override
	public int size() {
		// IterativeNode n = node;
		IterativeNode n = node;
		if(node == null) return 0;
		int i = 1;
		while(n.next() != null)
		{
			n = n.next();
			i++;
		}
		return i;
	}

	@Override
	public StringList toLowerCase() {
		StringList list = new IterativeStringList();
		IterativeNode n = node;
		while(n != null)
		{
			list.addToEnd(n.str().toLowerCase());
			n = n.next();
		}
		return list;
	}

	@Override
	public StringList toUpperCase() {
		StringList list = new IterativeStringList();
		IterativeNode n = node;
		while(n != null)
		{
			list.addToEnd(n.str().toUpperCase());
			n = n.next();
		}
		return list;
	}

	@Override
	public StringList startsWith(String prefix) {
		StringList list = new IterativeStringList();
		IterativeNode n = node;
		while(n.next() != null)
		{
			if(n.str().startsWith(prefix))
			{
				list.addToEnd(n.str());
			}
			n = n.next();
		}
		return list;
	}

	@Override
	public StringList hasSubstring(String substring) {
		StringList list = new IterativeStringList();
		IterativeNode n = node;
		while(n.next() != null)
		{
			if(n.str().contains(substring))
			{
				list.addToEnd(n.str());
			}
			n = n.next();
		}
		return list;
	}
}
