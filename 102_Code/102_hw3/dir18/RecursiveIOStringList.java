import java.util.NoSuchElementException;

public class RecursiveIOStringList
    implements StringList
{
    private RecursiveIONode head;
    public RecursiveIOStringList()
    {
	this.head = new RIOEmpty();
    }
    public void addToEnd(String element)
    {
        head = addToEndHelper(element, head);
    }
    public RecursiveIONode addToEndHelper(String element, RecursiveIONode cur)
    {
        if(cur instanceof RIOEmpty){
            RecursiveIONode added = new RIONode(element, cur);
            return added;
        }
        else{
	    RecursiveIONode n = addToEndHelper(element, ((RIONode)cur).getNext());
	    ((RIONode)cur).setNext(n);
	    return cur;
        }
    }
    public void add(int index, String element)
    {
        head = addHelper(index, element, head);
    }
    private RecursiveIONode addHelper(int index, String element, RecursiveIONode cur)
    {
        if(cur instanceof RIOEmpty && index == 0){
            RecursiveIONode added = new RIONode(element, cur);
            return added;
        }
        else if(cur instanceof RIONode){
            if(index==0){
                RecursiveIONode added = new RIONode(element, cur);
                return added;
            }
            else{
                RecursiveIONode added = addHelper(index - 1, element, ((RIONode)cur).getNext());
                cur.setNext(added);
                return cur;
           }
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }
    public void remove(int index)
    {
	head = removeHelper(index, head);
    }
    private RecursiveIONode removeHelper(int index, RecursiveIONode cur)
    {
	if(cur instanceof RIOEmpty){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    if(index == 0){
		return cur.getNext();
	    }
	    else{
		RecursiveIONode n = removeHelper(index - 1, ((RIONode)cur).getNext());
		cur.setNext(n);
		return cur;
	    }
	}
    }
    public String get(int index)
    {
	return getHelper(index, head).getString();
    }
    private RecursiveIONode getHelper(int index, RecursiveIONode cur)
    {
	if(cur instanceof RIOEmpty){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    if(index == 0){
		return cur;
	    }
	    else{
		RecursiveIONode n = getHelper(index-1, ((RIONode)cur).getNext());
		return n;
	    }
	}	
    }
    public int indexOf(String element)
    {
	return indexOfHelper(element, head);
    }
    private int indexOfHelper(String element, RecursiveIONode cur)
    {
	if(cur instanceof RIOEmpty){
	    throw new NoSuchElementException();
	}
	else{
	    if(cur.getString().equals(element)){
		return 0;
	    }
	    else{
		return 1 + indexOfHelper(element, cur.getNext());
	    }
	}
    }
    public int size()
    {
	return sizeHelper(head);
    }
    public int sizeHelper(RecursiveIONode cur)
    {
	if(cur instanceof RIOEmpty){
	    return 0;
	}
	else{
	    RecursiveIONode n = cur.getNext();
	    return 1 + sizeHelper(n);
	}
    }
    public StringList toLowerCase()
    {
	return toLowerCaseHelper(head);
    }
    public StringList toLowerCaseHelper(RecursiveIONode cur)
    {
	if(cur instanceof RIOEmpty){
	    StringList newList = new RecursiveIOStringList();
	    return newList;
	}
	else{
	    StringList newList = toLowerCaseHelper(cur.getNext());
	    newList.add(0, cur.getString().toLowerCase());
	    return newList;
	}
    }
    public StringList toUpperCase()
    {
	return toUpperCaseHelper(head);
    }
    private StringList toUpperCaseHelper(RecursiveIONode cur)
    {
	if(cur instanceof RIOEmpty){
	    StringList newList = new RecursiveIOStringList();
	    return newList;
	}
	else{
	    StringList newList = toUpperCaseHelper(cur.getNext());
	    newList.add(0, cur.getString().toUpperCase());
	    return newList;
	}

    }
    public StringList startsWith(String prefix)
    {
	return startsWithHelper(prefix, head);
    }
    private StringList startsWithHelper(String prefix, RecursiveIONode cur)
    {
	if(cur instanceof RIOEmpty){
	    StringList newList = new RecursiveIOStringList();
	    return newList;
	}
	else{
	    StringList newList = startsWithHelper(prefix, cur.getNext());
	    if(cur.getString().startsWith(prefix)){
		newList.add(0, cur.getString());
	    }
	    return newList;
	}
    }
    public StringList hasSubstring(String substring)
    {
	return hasSubstringHelper(substring, head);
    }
    private StringList hasSubstringHelper(String substring, RecursiveIONode cur)
    {
	if(cur instanceof RIOEmpty){
	    StringList newList = new RecursiveIOStringList();
	    return newList;
	}
	else{
	    StringList newList = hasSubstringHelper(substring, cur.getNext());
	    if(cur.getString().contains(substring)){
		newList.add(0, cur.getString());
	    }
	    return newList;
	}
    }
}