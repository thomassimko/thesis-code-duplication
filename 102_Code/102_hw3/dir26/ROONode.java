
public class ROONode implements RecursiveOONode {

	private String value;
	private RecursiveOONode next;

	public ROONode(){
	}

	public ROONode(String value){
		this.value=value;
	}

	public ROONode(String value,RecursiveOONode next){
		this.value=value;
		this.next=next;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public RecursiveOONode getNext() {
		return next;
	}

	@Override
	public void setNext(RecursiveOONode next) {
		this.next=next;
	}

	@Override
	public void setValue(String value) {
		this.value=value;
	}

	@Override
	public RecursiveOONode addToEnd(String element) {
		next=next.addToEnd(element);
		return this;
	}

	@Override
	public RecursiveOONode add(int index, String element) {
		if(index==0)
			return new ROONode(element,this);
		next=next.add(index-1, element);
		return this;
	}

	@Override
	public String get(int index) {
		if(index==0)
			return value;
		return next.get(index-1);
	}

	@Override
	public int indexOf(String element) {
		if(value.equals(element))
			return 0;
		int index=next.indexOf(element);
		return index==-1?-1:index+1;
	}

	@Override
	public int size() {
		return next.size()+1;
	}

	@Override
	public RecursiveOONode toLowerCase() {
		return new ROONode(value.toLowerCase(),next.toLowerCase());
	}

	@Override
	public RecursiveOONode toUpperCase() {
		return new ROONode(value.toUpperCase(),next.toUpperCase());
	}

	@Override
	public RecursiveOONode startsWith(String prefix) {
		if(value.startsWith(prefix))
			return new ROONode(value,next.startsWith(prefix));
		return next.startsWith(prefix);
	}

	@Override
	public RecursiveOONode hasSubstring(String substring) {
		if(value.contains(substring))
			return new ROONode(value,next.hasSubstring(substring));
		return next.hasSubstring(substring);
	}

	@Override
	public RecursiveOONode remove(int index) {
		if(index==0)
			return next;
		next=next.remove(index-1);
		return this;
	}
}
