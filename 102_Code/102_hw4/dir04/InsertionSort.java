import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class InsertionSort <T>
{
	private ArrayList<T> sortedList = new ArrayList<T>();
	
	public ArrayList<T> Sort(ArrayList<T> list, Comparator<T> Comparator)
	{
		for(int i = 0; i < list.size(); i++)
		{
			int index = comp(list,Comparator, list.get(i));
			addToList(list, index, i);
		}
		
		return sortedList;
	}

	private int comp(List<T> list, Comparator<T> Comparator, T element)
	{ 
		int i;
		for(i = 0; i < sortedList.size(); i++)
		{
			if(Comparator.compare(sortedList.get(i), element) > 0)
			{
				break;
			}
		}
		return i;
	}

	private void addToList(List<T> list, int ind, int i)
	{
		T add = list.get(i);
		this.sortedList.add(ind, add);
	}	
}
