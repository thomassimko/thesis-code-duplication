
public class RecursiveIOStringList implements StringList {
	RecursiveIONode first = new RIOEmpty();
	
	public RecursiveIOStringList(){
		
	}
	
	public RecursiveIOStringList(RecursiveIONode first){
		this.first = first;
	}
	
	@Override
	public void addToEnd(String element) {
		addToEndHelper(first,element);
	}

	@Override
	public void add(int index, String element) {
		addHelper(first,index,element);
	}

	@Override
	public void remove(int index) {
		if(index == 0 ){
			first = first.getNext();
		}else{
			removeHelper(first,index);
		}
	}

	@Override
	public String get(int index) {
		return getHelper(first,index);
	}

	@Override
	public int indexOf(String element) {
		return indexOfHelper(first,element);
	}

	@Override
	public int size() {
		return sizeHelper(first);
	}

	@Override
	public StringList toLowerCase() {
		return new RecursiveIOStringList(lowercaseHelper(first));
	}

	@Override
	public StringList toUpperCase() {
		return new RecursiveIOStringList(uppercaseHelper(first));
	}

	@Override
	public StringList startsWith(String prefix) {
		return new RecursiveIOStringList(startsWithHelper(first,prefix));
	}

	@Override
	public StringList hasSubstring(String substring) {
		return new RecursiveIOStringList(substringHelper(first,substring));
	}
	
	private void addToEndHelper(RecursiveIONode cur, String element){
		if(cur instanceof RIOEmpty){
			 first = new RIONode(element,cur);;
		}else{
			if(cur.getNext() instanceof RIONode){
				addToEndHelper(cur.getNext(),element);
			}else{
				cur.setNext(new RIONode(element,cur.getNext()));
			}
		}		
	}
	
	private void addHelper(RecursiveIONode cur, int index, String element){
		if(cur.getNext() instanceof RIONode){
			if(index == 0){
				cur.setString(element);
				cur.setNext(cur.getNext());
			}else{
				addHelper(cur.getNext(),index - 1,element);
			}
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	
	private void removeHelper(RecursiveIONode cur, int index){
		if(cur.getNext() instanceof RIONode){
			if(index == 1){
				cur.setNext(cur.getNext().getNext());
			}else{
				removeHelper(cur.getNext(),index - 1);
			}
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	
	private String getHelper(RecursiveIONode cur, int index){
		if(cur instanceof RIOEmpty)
			throw new IndexOutOfBoundsException();
		
		if(index == 0){
			return cur.getString();
		}
		return getHelper(cur.getNext(),index - 1);
	}

	private int indexOfHelper(RecursiveIONode cur,String element){
		if(cur instanceof RIOEmpty)
			return -1;
		
		if(cur.getString().equals(element)){
			return 0;
		}
		if(indexOfHelper(cur.getNext(),element) == -1){
			return -1;
		}
		return indexOfHelper(cur.getNext(),element) + 1;
	}
	
	private int sizeHelper(RecursiveIONode cur){
		if(cur instanceof RIOEmpty)
			return 0;
		return sizeHelper(cur.getNext()) + 1;
	}
	
	private RecursiveIONode lowercaseHelper(RecursiveIONode cur){
		if(cur instanceof RIOEmpty)
			return new RIOEmpty();
		return new RIONode(cur.getString().toLowerCase() , lowercaseHelper(cur.getNext()));
	}
	
	private RecursiveIONode uppercaseHelper(RecursiveIONode cur){
		if(cur instanceof RIOEmpty)
			return new RIOEmpty();
		return new RIONode(cur.getString().toUpperCase() , uppercaseHelper(cur.getNext()));
	}
	
	private RecursiveIONode substringHelper(RecursiveIONode cur, String substring){
		if(cur instanceof RIOEmpty)
			return new RIOEmpty();
		if(cur.getString().contains(substring))
			return new RIONode(cur.getString(), substringHelper(cur.getNext(),substring));
		return substringHelper(cur.getNext(),substring);
	}
	
	private RecursiveIONode startsWithHelper(RecursiveIONode cur, String start){
		if(cur instanceof RIOEmpty)
			return new RIOEmpty();
		if(cur.getString().startsWith(start))
			return new RIONode(cur.getString(), substringHelper(cur.getNext(),start));
		return substringHelper(cur.getNext(),start);
	}
}
