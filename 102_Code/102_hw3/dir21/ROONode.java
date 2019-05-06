public class ROONode implements RecursiveOONode{
	private String value;
	private RecursiveOONode nextLink;
	public ROONode(String val){
		value=val;
		nextLink=new ROOEmpty();
	}
	public void linkNext(RecursiveOONode r){
		nextLink=r;
	}
	public RecursiveOONode next(){
		return nextLink;
	}
	public String getVal(){
		return value;
	}
	public void addToEnd(String element) {
		if(nextLink instanceof ROOEmpty){
			nextLink=new ROONode(element);
		}
		else{
			nextLink.addToEnd(element);
		}
    }
    public void add(int index, String element){
		if(index==0&&!(nextLink instanceof ROOEmpty)){
			RecursiveOONode tmp=nextLink;
			nextLink=new ROONode(element);
			nextLink.linkNext(tmp);
		}
		else{
			if(nextLink instanceof ROOEmpty){
				nextLink=new ROONode(element);
			}
			else{
				nextLink.add(index-1,element);
			}
		}
	}
    public void remove(int index){
		if(index==0){
			nextLink=nextLink.next();
		}
		else{
			nextLink.remove(index-1);
		}
	}
    public String get(int index){
		if(index==0){
			return value;
		}
		else{
			return nextLink.get(index-1);
		}
	}
    public int indexOf(String element){
		if(value.equals(element)){
			return 1;
		}
		else{
			return nextLink.indexOf(element)+1;
		}
	}
    public int size(){
		return nextLink.size()+1;
	}
    public StringList toLowerCase(){
		StringList s=nextLink.toLowerCase();
		s.add(0,value.toLowerCase());
		return s;
	}
    public StringList toUpperCase(){
		StringList s=nextLink.toUpperCase();
		s.add(0,value.toUpperCase());
		return s;
	}
    public StringList startsWith(String prefix){
		StringList s=nextLink.startsWith(prefix);
		if(value.indexOf(prefix)==0){
			s.add(0,value);
			return s;
		}
		else{
			return s;
		}
	}
    public StringList hasSubstring(String substring){
		StringList s=nextLink.hasSubstring(substring);
		if(value.indexOf(substring)!=-1){
			s.add(0,substring);
			return s;
		}
		else{
			return  s;
		}
	}
}