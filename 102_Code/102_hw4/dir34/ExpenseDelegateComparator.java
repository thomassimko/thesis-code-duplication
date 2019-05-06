import java.util.Comparator;
public class ExpenseDelegateComparator
implements Comparator
{
	private Comparator comp;
	private Comparator comp2;
	public ExpenseDelegateComparator(Comparator c, Comparator c2)
	{
		comp = c;
		comp2 = c2;
	}
	public int compare(Object o1, Object o2)
	{
		int i = comp.compare(o1, o2);
		if(i == 0)
		{
			i = comp2.compare(o1, o2);
		}
		return i;
	}

}
