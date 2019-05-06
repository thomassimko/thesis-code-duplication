import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class DateSort<RSSItem> {
	
	public List<RSSItem> dateSort(List<RSSItem> list, Comparator<RSSItem> c) {
		int size = list.size();
		List<RSSItem> newList = new LinkedList<RSSItem>();
		List<RSSItem> tempList = new LinkedList<RSSItem>();
		for(int i=0; i<size; i++) {
			tempList.add(list.get(i));
		}
		for(int i=0; i<size; i++) {
			int index = findDateOrder(list, c, 0);
			newList.add(0, list.remove(index));
		}
		for(int i=0; i<size; i++) {
			list.add(tempList.get(i));
		}
		return newList;
	}
	
	public int findDateOrder(List<RSSItem> l, Comparator<RSSItem> c, int start) {
		int index = start;
		int size = l.size();
		RSSItem elementIndex = l.get(start);
		for(int i=start+1; i<size; i++) {
			RSSItem elementI = l.get(i);
			if(c.compare(elementIndex, elementI) > 0) {
				index = i;
				elementIndex = elementI;
			}
		}
		return index;
	}
}
