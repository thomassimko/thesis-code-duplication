
public class ROONode implements RecursiveOONode {
	private String string;
    private RecursiveOONode next;
    
    public ROONode(String string, RecursiveOONode next){
         this.string = string;
         this.next = next;
    }

    @Override
	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String getString() {
		return this.string;
	}

	@Override
	public void setNext(RecursiveOONode next) {
		this.next = next;
		
	}

	@Override
	public RecursiveOONode getNext() {
		return this.next;
	}

	@Override
	public RecursiveOONode addToEnd(String element) {
		next = next.addToEnd(element);
		return this;
	}

	@Override
	public void add(int index, String element) {
		if(index == 0){
			next = new ROONode(element,next);
		}else{
			next.add(index - 1, element);
		}
	}

	@Override
	public void remove(int index) {
		if(index == 0){
			string = next.getString();
			next = next.getNext();
		}else{
			next.remove(index - 1);
		}
	}

	@Override
	public String get(int index) {
		if(index == 0){
			return string;
		}else{
			return next.get(index - 1);
		}
	}

	@Override
	public int indexOf(String element) {
		if(string.equals(element)){
			return 0;
		}else{
			int index = next.indexOf(element);
			if(index == -1){
				return -1;
			}
			return index + 1;
		}
	}

	@Override
	public int size() {
		return next.size() + 1;
	}

	@Override
	public RecursiveOONode toLowerCase() {
		
		return new ROONode(string.toLowerCase(),next.toLowerCase());
	}

	@Override
	public RecursiveOONode toUpperCase() {
		return new ROONode(string.toLowerCase(),next);
	}

	@Override
	public RecursiveOONode startsWith(String prefix) {
		if(string.startsWith(prefix)){
			return new ROONode(string,next.startsWith(prefix));
		}
		return next.startsWith(prefix);
	}

	@Override
	public RecursiveOONode hasSubstring(String substring) {
		if(string.contains(substring)){
			return new ROONode(string,next.startsWith(substring));
		}
		return next.hasSubstring(substring);
	}
}
