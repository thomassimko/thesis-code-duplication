import java.util.Comparator;


public class ExpenseDelegateComparator<T> implements Comparator<T> 
{
	private Comparator<T> comp1;
	private Comparator<T> comp2;
	
	public ExpenseDelegateComparator(Comparator<T> comp1, Comparator<T> comp2)
	{
		this.comp1 = comp1;
		this.comp2 = comp2;
	}

	@Override
	public int compare(T o1, T o2) 
	{
		if(comp1.compare(o1, o2) == 0)
		{
			return comp2.compare(o1, o2);
		}
		else
		{
			return comp1.compare(o1, o2);
		}
	}
}
