import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ExpenseSort<T>
{
	private List<T> p;
	public List<T> sort(List<T> list, Comparator<T> comp)
	{
		int size = list.size();
		List<T> newl = new LinkedList<T>();

		for(int i = 0; i < size; i++)
		{
			int index = findFirst(list, 0, comp);
			newl.add(0, list.remove(index));
		}
		return newl;
	}
	public int findFirst(List<T> list, int front, Comparator<T> comp)
	{
		int index = front;
		T elementIndex = list.get(index);
		int size = list.size();
		for(int i = front+1; i < size; i++)
		{
			T elementI = list.get(i);
			if((comp.compare(elementIndex, elementI)) < 0)
			{
				index = i;
				elementIndex = elementI;
			}
		}
		return index;
	}

}

