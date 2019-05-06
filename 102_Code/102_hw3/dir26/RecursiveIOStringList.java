
public class RecursiveIOStringList implements StringList {
	
	private RecursiveIONode first=new RIOEmpty();
	
	public RecursiveIOStringList(){
	}
	
	public RecursiveIOStringList(RecursiveIONode first){
		this.first=first;
	}

	@Override
	public void addToEnd(String element) {
		if(first instanceof RIOEmpty)
			first=new RIONode(element,first);
		else
			mAddToEnd(first,element);
	}
	
	private void mAddToEnd(RecursiveIONode r,String element){
		if(r.getNext() instanceof RIOEmpty)
			r.setNext(new RIONode(element,r.getNext()));
		else
			mAddToEnd(r.getNext(),element);
	}
	
	@Override
	public void add(int index, String element) {
		if(index>size()||index<0)
			throw new IndexOutOfBoundsException();
		mAdd(index,element,first);
	}
	
	private void mAdd(int index,String element,RecursiveIONode r){
		if(index==0){
			r.setNext(new RIONode(r.getValue(),r.getNext()));
			r.setValue(element);
		}else{
			mAdd(index-1,element,r.getNext());
		}
	}

	@Override
	public String remove(int index) {
		if(index<0||index>=size())
			throw new IndexOutOfBoundsException();
		if(index==0){
			String remove=first.getValue();
			first=first.getNext();
			return remove;
		}
		else
			return mRemove(index,first);
	}
	
	private String mRemove(int index,RecursiveIONode r){
		if(index==1){
			String remove=r.getNext().getValue();
			r.setNext(r.getNext().getNext());
			return remove;
		}
		return mRemove(index-1,r.getNext());
	}

	@Override
	public String get(int index) {
		if(index<0||index>=size())
			throw new IndexOutOfBoundsException();
		return mGet(index,first);
	}
	
	private String mGet(int index, RecursiveIONode r) {
		if(index==0)
			return r.getValue();
		return mGet(index-1,r.getNext());
	}

	@Override
	public int indexOf(String element) {
		return mIndexOf(element,first);
	}

	private int mIndexOf(String element, RecursiveIONode r) {
		if(r instanceof RIOEmpty)
			return -1;
		if(r.getValue().equals(element))
			return 0;
		int index=mIndexOf(element,r.getNext());
		return index==-1?-1:index+1;
	}

	@Override
	public int size() {
		return mSize(first);
	}

	private int mSize(RecursiveIONode r) {
		if(r instanceof RIOEmpty)
			return 0;
		return mSize(r.getNext())+1;
	}

	@Override
	public StringList toLowerCase() {
		return new RecursiveIOStringList(mToLowerCase(first));
	}

	private RecursiveIONode mToLowerCase(RecursiveIONode r) {
		if(r instanceof RIOEmpty)
			return new RIOEmpty();
		return new RIONode(r.getValue().toLowerCase(),mToLowerCase(r.getNext()));
	}

	@Override
	public StringList toUpperCase() {
		return new RecursiveIOStringList(mToUpperCase(first));
	}

	private RecursiveIONode mToUpperCase(RecursiveIONode r) {
		if(r instanceof RIOEmpty)
			return new RIOEmpty();
		return new RIONode(r.getValue().toUpperCase(),mToUpperCase(r.getNext()));
	}

	@Override
	public StringList startsWith(String prefix) {
		return new RecursiveIOStringList(mStartsWith(first,prefix));
	}

	private RecursiveIONode mStartsWith(RecursiveIONode r,String prefix) {
		if(r instanceof RIOEmpty)
			return new RIOEmpty();
		return r.getValue().startsWith(prefix)?
				new RIONode(r.getValue(),mStartsWith(r.getNext(),prefix)):
					mStartsWith(r.getNext(),prefix);
	}

	@Override
	public StringList hasSubstring(String substring) {
		return new RecursiveIOStringList(mHasSubstring(first,substring));
	}

	private RecursiveIONode mHasSubstring(RecursiveIONode r,
			String substring) {
		if(r instanceof RIOEmpty)
			return new RIOEmpty();
		return r.getValue().contains(substring)?
				new RIONode(r.getValue(),mHasSubstring(r.getNext(),substring)):
					mHasSubstring(r.getNext(),substring);
	}

}
