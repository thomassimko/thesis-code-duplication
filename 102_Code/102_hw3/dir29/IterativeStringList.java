
public class IterativeStringList implements StringList {
	IterativeNode first = null;
	@Override
	public void addToEnd(String element) {
		IterativeNode end = new IterativeNode(element,null);
		if(first == null){
			first = end;
		}else{
			IterativeNode node = first;
			while(node.getNext() != null){
				node = node.getNext();
			}
			node.setNext(end);
		}
	}

	@Override
	public void add(int index, String element) {
		IterativeNode node = first;
		int i = 0;
		while(i < index && node.getNext() != null){
			node = node.getNext();
			i++;
		}
		if(i == index){
			IterativeNode next = node.getNext();
			node.setString(element);
			node.setNext(next);
		}else{
			throw new IndexOutOfBoundsException();
		}
		
	}

	@Override
	public void remove(int index) {
		IterativeNode node = first;
		int i = 0;
		if(index == 0){
			first = first.getNext();
		}else{
			while(i < index - 1 && node.getNext() != null){
				node = node.getNext();
				i++;
			}
			if(node.getNext() != null){
				IterativeNode next = node.getNext().getNext();
				node.setNext(next);	
			}else{
				throw new IndexOutOfBoundsException();
			}
		}	
	}

	@Override
	public String get(int index) {
		IterativeNode node = first;
		int i = 0;
		if(index == 0){
			return first.getString();
		}else{
			while(i < index && node.getNext() != null){
				node = node.getNext();
				i++;
			}
			if(node != null){
				return node.getString();
			}else{
				throw new IndexOutOfBoundsException();
			}
		}
		
	}

	@Override
	public int indexOf(String element) {
		IterativeNode node = first;
		int i = 0;
		while(node.getNext() != null && !node.getString().equals(element)){
			node = node.getNext();
			i++;
		}
		if(node.getString().equals(element)){
			return i;
		}else{
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		IterativeNode node = first;
		if(node != null){
			int i = 1;
			while(node.getNext() != null){
				node = node.getNext();
				i++;
			}
			return i;
		}else{
			return 0;
		}
	}

	@Override
	public StringList toLowerCase() {
		StringList strLst = new IterativeStringList();
		String tmp;
		for(int i = 0; i < this.size(); i++){
			tmp = this.get(i).toLowerCase();
			strLst.addToEnd(tmp);
		}
		return strLst;
	}

	@Override
	public StringList toUpperCase() {
		StringList strLst = new IterativeStringList();
		String tmp;
		for(int i = 0; i < this.size(); i++){
			tmp = this.get(i).toUpperCase();
			strLst.addToEnd(tmp);
		}
		return strLst;
	}

	@Override
	public StringList startsWith(String prefix) {
		StringList strLst = new IterativeStringList();
		String tmp;
		for(int i = 0; i < this.size(); i++){
			tmp = this.get(i);
			if(tmp.startsWith(prefix)){
				strLst.addToEnd(tmp);
			}	
		}
		return strLst;
	}

	@Override
	public StringList hasSubstring(String substring) {
		StringList strLst = new IterativeStringList();
		String tmp;
		for(int i = 0; i < this.size(); i++){
			tmp = this.get(i);
			if(tmp.contains(substring)){
				strLst.addToEnd(tmp);
			}	
		}
		return strLst;
	}

}
