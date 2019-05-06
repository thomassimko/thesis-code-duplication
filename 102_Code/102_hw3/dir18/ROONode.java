public class ROONode
    implements RecursiveOONode
{
    private RecursiveOONode next;
    private String str;
    public ROONode(String str, RecursiveOONode next)
    {
	this.next = next;
	this.str = str;
    }
    public String getString()
    {
	return str;
    }
    public RecursiveOONode getNext()
    {
	return next;
    }
    public void setNext(RecursiveOONode next)
    {
	this.next = next;
    }

    public RecursiveOONode addToEnd(String element)
    {
	RecursiveOONode n = next.addToEnd(element);
	next = n;
	return this;
    }
    public RecursiveOONode add(int index, String element)
    {
	if(index == 0){
	    RecursiveOONode added = new ROONode(element, this);
	    return added;
	}
	else{
	    next = next.add(index - 1, element);
	    return this;
	}
    }
    public RecursiveOONode remove(int index)
    {
	if(index == 0){
	    return next;
	}
	else{
	    RecursiveOONode n = next.remove(index - 1);
	    next = n;
	    return this;
	}
    }
    public String get(int index)
    {
	if(index == 0){
	    return str;
	}
	else{
	    return next.get(index-1);
	}
    }
    public int indexOf(String element)
    {
	if(str.equals(element)){
	    return 0;
	}
	else{
	    return 1 + next.indexOf(element);
	}
    }
    public int size()
    {
	return 1 + next.size();
    }
    public StringList toLowerCase()
    {
	StringList newList = next.toLowerCase();
	newList.add(0, str.toLowerCase());
	return newList;
    }
    public StringList toUpperCase()
    {
	StringList newList = next.toUpperCase();
	newList.add(0, str.toUpperCase());
	return newList;
    }
    public StringList startsWith(String prefix)
    {
	StringList newList = next.startsWith(prefix);
	if(str.startsWith(prefix)){
	    newList.add(0, str);
	}
	return newList;
    }
    public StringList hasSubstring(String substring)
    {
	StringList newList = next.hasSubstring(substring);
	if(str.contains(substring)){
	    newList.add(0, str);
	}
	return newList;
    }
}