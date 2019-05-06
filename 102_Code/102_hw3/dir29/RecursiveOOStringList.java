
public class RecursiveOOStringList implements StringList {
	RecursiveOONode first = new ROOEmpty();
	
	public RecursiveOOStringList(){
		
	}
	
	public RecursiveOOStringList(RecursiveOONode first){
		this.first = first;
	}
	
	@Override
	public void addToEnd(String element) {
		first = first.addToEnd(element);
	}

	@Override
	public void add(int index, String element) {
		first.add(index, element);
	}

	@Override
	public void remove(int index) {
		first.remove(index);
	}

	@Override
	public String get(int index) {
		return first.get(index);
	}

	@Override
	public int indexOf(String element) {
		return first.indexOf(element);
	}

	@Override
	public int size() {
		return first.size();
	}

	@Override
	public StringList toLowerCase() {
		return new RecursiveOOStringList(first.toLowerCase());
	}

	@Override
	public StringList toUpperCase() {
		return new RecursiveOOStringList(first.toUpperCase());
	}

	@Override
	public StringList startsWith(String prefix) {
		return new RecursiveOOStringList(first.startsWith(prefix));
	}

	@Override
	public StringList hasSubstring(String substring) {
		return new RecursiveOOStringList(first.hasSubstring(substring));
	}

}
