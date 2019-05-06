public class IterativeStringList implements StringList {
	private IterativeNode head;
	
	public IterativeStringList(){
		head=null;
	}
    public void addToEnd(String element) {
		if(head!=null){
			IterativeNode tmp=head;
			while(tmp.next()!=null){
				tmp=tmp.next();
			}
			IterativeNode n=new IterativeNode(element);
			tmp.linkNext(n);
		}
		else{
			head=new IterativeNode(element);
		}
    }
    public void add(int index, String element){
		int i=index-1;
		IterativeNode tmp=head;
		while(i>0){
			tmp=tmp.next();
			if(tmp==null){
				throw new IndexOutOfBoundsException();
			}
			i--;
		}
		IterativeNode second=tmp.next();
		tmp.linkNext(new IterativeNode(element));
		tmp.next().linkNext(second);
	}
    public void remove(int index){
		int i=index;
		IterativeNode tmp0=head,tmp=head.next();
		while(i>0){
			tmp0=tmp;
			tmp=tmp.next();
			i--;
		}
		if(tmp0==null||tmp==null){
			throw new IndexOutOfBoundsException();
		}
		if(tmp.next()==null){
			tmp0.linkNext(null);
		}
		else{
			tmp0.linkNext(tmp.next());
		}
	}
    public String get(int index){
		int i=index;
		IterativeNode tmp=head;
		while(i>0){
			tmp=tmp.next();
			if(tmp==null){
				throw new IndexOutOfBoundsException();
			}
			i--;
		}
		return tmp.getVal();
	}
    public int indexOf(String element){
		IterativeNode tmp=head;
		int index=-1;
		int count=0;
		while(tmp!=null){
			if(tmp.getVal().equals(element)){
				return count;
			}
			tmp=tmp.next();
			count++;
			
		}
		return index;
	}
    public int size(){
		IterativeNode tmp=head;
		int index=0;
		while(tmp!=null){
			tmp=tmp.next();
			index++;
		}
		return index;
	}
    public StringList toLowerCase(){
		IterativeStringList i=new IterativeStringList();
		IterativeNode tmp=head;
		while(tmp!=null){
			i.addToEnd(tmp.getVal().toLowerCase());
			tmp=tmp.next();
		}
		return i;
	}
    public StringList toUpperCase(){
		IterativeStringList i=new IterativeStringList();
		IterativeNode tmp=head;
		while(tmp!=null){
			i.addToEnd(tmp.getVal().toUpperCase());
			tmp=tmp.next();
		}
		return i;
	}
    public StringList startsWith(String prefix){
		IterativeStringList i=new IterativeStringList();
		IterativeNode tmp=head;
		while(tmp!=null){
			if(tmp.getVal().indexOf(prefix)==0){
				i.addToEnd(tmp.getVal());
			}			
			tmp=tmp.next();
		}
		return i;
	}
    public StringList hasSubstring(String substring){
		IterativeStringList i=new IterativeStringList();
		IterativeNode tmp=head;
		while(tmp!=null){
			if(tmp.getVal().indexOf(substring)!=-1){
				i.addToEnd(tmp.getVal());
			}			
			tmp=tmp.next();
		}
		return i;
	}
}