
public class ROONode implements RecursiveOONode {
	
	private String element;
	private RecursiveOONode next;
	
	public ROONode(String element, RecursiveOONode next) {
		this.element = element;
		this.next = next;
	}

	@Override
	public RecursiveOONode add(int index, String element) {
		// TODO Auto-generated method stub
		if(index == 0) {
			RecursiveOONode n = new ROONode(element, this);
			return n;
		}
		else {
			next = next.add(index-1, element);
			return this;
		}
	}

	@Override
	public RecursiveOONode addToEnd(String element) {
		// TODO Auto-generated method stub
		RecursiveOONode n = next.addToEnd(element);
		next = n;
		return this;
	}

	@Override
	public RecursiveOONode remove(int index) {
		// TODO Auto-generated method stub
		if(index == 0) {
			return next;
		}
		if(index > 0){
			next = next.remove(index-1);
			return this;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		if(index == 0) {
			return element;
		}
		if(index > 0) {
			String s = next.get(index-1);
			return s;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(String element) {
		// TODO Auto-generated method stub
		if(this.element.equals(element)) {
			return 0;
		}
		else {
			return 1 + next.indexOf(element);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return next.size() + 1;
	}

	@Override
	public RecursiveOONode toLowerCase() {
		// TODO Auto-generated method stub
		RecursiveOONode temp = next.toLowerCase();
		RecursiveOONode n = new ROONode(element.toLowerCase(), temp);
		return n;
	}

	@Override
	public RecursiveOONode toUpperCase() {
		// TODO Auto-generated method stub
		RecursiveOONode temp = next.toUpperCase();
		RecursiveOONode n = new ROONode(element.toUpperCase(), temp);
		return n;
	}

	@Override
	public RecursiveOONode startsWith(String prefix) {
		// TODO Auto-generated method stub
		RecursiveOONode n;
		if(element.startsWith(prefix)) {
			n = new ROONode(element, next.startsWith(prefix));
		}
		else {
			return next.startsWith(prefix);
		}
		return n;
	}

	@Override
	public RecursiveOONode hasSubstring(String substring) {
		// TODO Auto-generated method stub
		RecursiveOONode n;
		if(element.indexOf(substring) > 0) {
			n = new ROONode(element, next.hasSubstring(substring));
		}
		else {
			return next.hasSubstring(substring);
		}
		return n;
	}

}
