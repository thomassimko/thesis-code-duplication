
public class IterativeStringList implements StringList{

	private IterativeNode first;

	public IterativeStringList(){

	}

	public IterativeStringList(String firstString){
		first=new IterativeNode(firstString);
	}

	@Override
	public void addToEnd(String element) {
		if(first==null)
			first=new IterativeNode(element);
		else{
			IterativeNode i = first;
			while(i.getNext()!=null){
				i=i.getNext();
			}
			i.setNext(new IterativeNode(element));
		}
	}

	@Override
	public void add(int index, String element) {
		if(index<0||index>this.size())
			throw new IndexOutOfBoundsException();
		if(index==0)
			first=new IterativeNode(element,first);
		else{
			IterativeNode cur=first;
			for(int i=1;i<index;i++){
				cur=cur.getNext();
			}
			cur.setNext(new IterativeNode(element,cur.getNext()));
		}
	}

	@Override
	public String remove(int index) {
		if(first==null||index<0||index>this.size()-1)
			throw new IndexOutOfBoundsException();
		if(index==0){
			String remove=first.getNode();
			first=first.getNext();
			return remove;
		}
		else{
			IterativeNode cur=first;
			for(int i=1;i<index;i++){
				cur=cur.getNext();
			}
			String remove=cur.getNext().getNode();
			cur.setNext(cur.getNext().getNext());
			return remove;
		}
	}

	@Override
	public String get(int index) {
		if(index<0||index>this.size()-1)
			throw new IndexOutOfBoundsException();
		IterativeNode node=first;
		for(int i=0;i<index;i++){
			node=node.getNext();
		}
		return node.getNode();
	}

	@Override
	public int indexOf(String element) {
		if(first==null)
			return -1;
		IterativeNode cur=first;
		int i=0;
		while(!cur.getNode().equals(element)){
			if((cur=cur.getNext())==null)
				return -1;
			i++;
		}
		return i;
	}

	@Override
	public int size() {
		IterativeNode node=first;
		int i=0;
		while(node!=null){
			node=node.getNext();
			i++;
		}
		return i;
	}

	@Override
	public StringList toLowerCase() {
		IterativeNode cur=first;
		StringList newList=new IterativeStringList();
		while(cur!=null){
			newList.addToEnd(cur.getNode().toLowerCase());
			cur=cur.getNext();
		}
		return newList;
	}

	@Override
	public StringList toUpperCase() {
		IterativeNode cur=first;
		StringList newList=new IterativeStringList();
		while(cur!=null){
			newList.addToEnd(cur.getNode().toUpperCase());
			cur=cur.getNext();
		}
		return newList;
	}

	@Override
	public StringList startsWith(String prefix) {
		IterativeNode cur=first;
		StringList newList=new IterativeStringList();
		while(cur!=null){
			if(cur.getNode().startsWith(prefix))
				newList.addToEnd(cur.getNode());
			cur=cur.getNext();
		}
		return newList;
	}

	@Override
	public StringList hasSubstring(String substring) {
		IterativeNode cur=first;
		StringList newList=new IterativeStringList();
		while(cur!=null){
			if(cur.getNode().contains(substring))
				newList.addToEnd(cur.getNode());
			cur=cur.getNext();
		}
		return newList;
	}
}
