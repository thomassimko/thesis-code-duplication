public class IterativeStringList
    implements StringList
{
    private IterativeNode head;
    public IterativeStringList()
    {
	head = null;
    }
    public int size()
    {
	int size=0;
	IterativeNode cur = head;
	while(cur != null){
	    cur = cur.getNext();
	    size++;
	}
	return size;
    }
    public void remove(int index)
    {
	IterativeNode n = head;
	String str;
	int cur = 1;
	if(index == 0){
	    head = head.getNext();
	}
	else{
	    while(cur != index){
		n = n.getNext();
		cur++;
	    }
	    n.setNext(n.getNext().getNext());
	}
    }
    public void addToEnd(String element)
    {
	IterativeNode n = new IterativeNode(element, null);
	if(head == null){
	    head = n;
	}
	else{
	    IterativeNode cur = this.head;
	    while(cur.getNext() != null){
		cur = cur.getNext();
	    }
	    cur.setNext(n);
	}
    }
    public void add(int index, String element)
    {
	IterativeNode cur = head;
	if(this.head == null){
	    if(index == 0){
		this.head = new IterativeNode(element, null);
	    }
	    else{
		throw new IndexOutOfBoundsException();
	    }
	}
	else{
	    if(index == 0){
		this.head = new IterativeNode(element, head);
	    }
	    else if(index < 0){
		throw new IndexOutOfBoundsException();
	    }
	    else{
		for(int i = 1; i < index; i++){
		    cur = cur.getNext();
		}
		if(cur==null){
		    throw new IndexOutOfBoundsException();
		}
		else{
		    IterativeNode n = new IterativeNode(element, cur.getNext());
		    cur.setNext(n);
		}
	    }
	}
    }
    public String get(int index)
    {
	IterativeNode n = head;
	int cur = 0;
	while(cur != index && n != null){
	    n = n.getNext();
	    cur++;
	}
	if(cur == index){
	    return n.getString();
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
    }
    public int indexOf(String element)
    {
	int index = 0;
	IterativeNode n = head;
	while(n != null){
	    if(n.getString().equals(element)){
		return index;
	    }
	    index++;
	    n = n.getNext();
	}
	return -1;
    }
    public StringList toLowerCase()
    {
	StringList newList = new IterativeStringList();
	String str;
	IterativeNode n = head;
	while(n != null){
	    str = n.getString();
	    str.toLowerCase();
	    newList.addToEnd(str);
            n = n.getNext();
	}
	return newList;
	
    }
    public StringList toUpperCase()
    {
	StringList newList = new IterativeStringList();
	String str;
	IterativeNode n = head;
	while(n != null){
	    str = n.getString();
	    str.toUpperCase();
	    newList.addToEnd(str);
	    n = n.getNext();
	}
	return newList;
    }
    public StringList startsWith(String prefix)
    {
	StringList newList = new IterativeStringList();
	String str;
	IterativeNode n = head;
	while(n != null){
	    str = n.getString();
	    if(str.startsWith(prefix)){
		newList.addToEnd(str);
	    }
	    n = n.getNext();
	}
	return newList;
    }
    public StringList hasSubstring(String substring)
    {
	StringList newList = new IterativeStringList();
	String str;
	IterativeNode n = head;
	while(n != null){
	    str = n.getString();
	    if(str.contains(substring)){
		newList.addToEnd(str);
	    }
	    n = n.getNext();
	}
	return newList;
	
    }
}