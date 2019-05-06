public class ROOEmpty implements RecursiveOONode{
	public RecursiveOONode next(){
		throw new UnsupportedOperationException();
	}
	public String getVal(){
		throw new UnsupportedOperationException();
	}
	public void linkNext(RecursiveOONode r){
		throw new UnsupportedOperationException();
	}
	public void addToEnd(String element) {
		throw new UnsupportedOperationException();
    }
    public void add(int index, String element){
		throw new IndexOutOfBoundsException();
	}
    public void remove(int index){
		return;
	}
    public String get(int index){
		return "a";
	}
    public int indexOf(String element){
		return -1;
	}
    public int size(){
		return 0;
	}
	public StringList toLowerCase(){ 
		return new RecursiveOOStringList();
	}
    public StringList toUpperCase(){
		return new RecursiveOOStringList();
	}
    public StringList startsWith(String prefix){
		return new RecursiveOOStringList();
	}
    public StringList hasSubstring(String substring){
		return new RecursiveOOStringList();
	}
}