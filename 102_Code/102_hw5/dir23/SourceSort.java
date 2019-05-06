import java.util.*;

public class SourceSort<String> {
	
	public List<String> sourceSort(List<String> list, Comparator<String> c) {
		int size = list.size();
		List<String> newList = new LinkedList<String>();
		List<String> tempList = new LinkedList<String>();
		for(int i=0; i<size; i++) {
			tempList.add(list.get(i));
		}
		for(int i=0; i<size; i++) {
			int index = findAlphaOrder(list, c, 0);
			newList.add(0, list.remove(index));
		}
		for(int i=0; i<size; i++) {
			list.add(tempList.get(i));
		}
		return newList;
	}
	
	public int findAlphaOrder(List<String> l, Comparator<String> c, int start) {
		int index = start;
		int size = l.size();
		String elementIndex = l.get(start);
		for(int i=start+1; i<size; i++) {
			String elementI = l.get(i);
			if(c.compare(elementIndex, elementI) < 0) {
				index = i;
				elementIndex = elementI;
			}
		}
		return index;
	}
}
