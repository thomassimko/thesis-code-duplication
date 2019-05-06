import java.util.Comparator;

public class ExpenseDelegateComparator
   implements Comparator<Expenses>
{

   private Comparator<Expenses> eComp;
	private Comparator<Expenses> eDelegate;

   public ExpenseDelegateComparator(Comparator<Expenses> eComp,Comparator<Expenses> eDelegate)
	{
	   this.eComp = eComp;
		this.eDelegate = eDelegate;
	}

   public int compare(Expenses left, Expenses right)
	{
	   int v = this.eComp.compare(left, right);
		
		if(v == 0)
		{
		  v = this.eDelegate.compare(left, right);
		}
		
		return v;
	}

}