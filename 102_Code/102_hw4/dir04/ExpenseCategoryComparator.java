import java.util.Comparator;


public class ExpenseCategoryComparator 
	implements Comparator<Expense>
{
	public int compare(Expense cat1, Expense cat2)//neg means cat1 comes first 
	{
		return cat1.getCat().compareTo(cat2.getCat());
	}
}
