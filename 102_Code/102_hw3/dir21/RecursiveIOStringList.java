public class RecursiveIOStringList implements StringList {
	private RecursiveIONode head,iter,iterPrev;
	
	public RecursiveIOStringList(){
		head=new RIOEmpty();
		iter=head;
	}
    public void addToEnd(String element) {
		if(iter.next() instanceof RIOEmpty){
			iter.linkNext(new RIONode(element));
			iter=head;
		}
		else{
			iter=iter.next();
			addToEnd(element);
		}
    }
    public void add(int index, String element){
		if(index==1&&!(iter.next() instanceof RIOEmpty)){
			RecursiveIONode tmp=iter;
			RecursiveIONode tmp1=iter.next();
			iter=new RIONode(element);
			iter.linkNext(tmp1);
			tmp.linkNext(iter);
			iter=head;
		}
		else{
			if(iter.next() instanceof RIOEmpty){
				iter.linkNext(new RIONode(element));
				iter=head;
			}
			else{
				iter=iter.next();
				add(index-1,element);
			}
		}
	}
    public void remove(int index){
		if(index==1){
			iter.linkNext(iter.next().next());
			iter=head;
		}
		else{
			iter=iter.next();
			remove(index-1);
		}
	}
    public String get(int index){
		if(index==0){
			iter=head;
			return iter.getVal();
		}
		else{
			iter=iter.next();
			return get(index-1);
		}
	}
    public int indexOf(String element){
		if(iter.getVal().equals(element)){
			iter=head;
			return 1;
		}
		else if(!(iter.next() instanceof RIOEmpty)){
			iter.next();
			return indexOf(element)+1;
		}
		else{
			iter=head;
			throw new IndexOutOfBoundsException();
		}
	}
    public int size(){
		if(!(iter.next() instanceof RIOEmpty)){
			iter=iter.next();
			return size()+1;
		}
		else{
			return 0;
		}
	}
    public StringList toLowerCase(){
		if(iter.equals(head)&&!(iter.next() instanceof RIOEmpty)){
			StringList s=toLowerCase();
			s.add(0,iter.getVal().toLowerCase());
			return s;
		}
		if(!(iter.next() instanceof RIOEmpty)){
			iter=iter.next();
			StringList s=toLowerCase();
			s.add(0,iter.getVal().toLowerCase());
			return s;
		}
		else{
			iter=head;
			return new RecursiveIOStringList();
		}
	}
    public StringList toUpperCase(){
		if(iter.equals(head)&&!(iter.next() instanceof RIOEmpty)){
			StringList s=toUpperCase();
			s.add(0,iter.getVal().toUpperCase());
			return s;
		}
		if(!(iter.next() instanceof RIOEmpty)){
			iter=iter.next();
			StringList s=toUpperCase();
			s.add(0,iter.getVal().toUpperCase());
			return s;
		}
		else{
			iter=head;
			return new RecursiveIOStringList();
		}
	}
    public StringList startsWith(String prefix){
		if(iter.equals(head)&&!(iter.next() instanceof RIOEmpty)){
			if(iter.getVal().indexOf(prefix)==0){
				StringList s=startsWith(prefix);
				s.add(0,iter.getVal());
				return s;
			}
		}
		if(!(iter.next() instanceof RIOEmpty)){
			iter=iter.next();
			if(iter.getVal().indexOf(prefix)==0){
				StringList s=startsWith(prefix);
				s.add(0,iter.getVal());
				return s;
			}
		}
		
		iter=head;
		return new RecursiveIOStringList();
	}
    public StringList hasSubstring(String substring){
		if(iter.equals(head)&&!(iter.next() instanceof RIOEmpty)){
			if(iter.getVal().indexOf(substring)!=-1){
				StringList s=hasSubstring(substring);
				s.add(0,iter.getVal());
				return s;
			}
		}
		if(!(iter.next() instanceof RIOEmpty)){
			iter=iter.next();
			if(iter.getVal().indexOf(substring)!=-1){
				StringList s=hasSubstring(substring);
				s.add(0,iter.getVal());
				return s;
			}
		}
		iter=head;
		return new RecursiveIOStringList();
	}
}