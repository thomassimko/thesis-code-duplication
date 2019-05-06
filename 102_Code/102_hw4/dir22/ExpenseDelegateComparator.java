//programmed by Michael Olivarez
import java.util.*;
public class ExpenseDelegateComparator
  implements Comparator<Expense>
{
    private Comparator<Expense> comp1;
    private Comparator<Expense> comp2;
    public ExpenseDelegateComparator(Comparator<Expense> c1, Comparator<Expense> c2)
    {
	//c1 for comparison, c2 for delegation
       this.comp1 = c1;
       this.comp2 = c2;
    }
    public ExpenseDelegateComparator()
    {}
    public int compare(Expense lft, Expense rht)
    {
    // return comp1.compare(lft, rht) == 0 ? comp2.compare(lft, rht) : comp1.compare(lft, rht);
       if(comp1.compare(lft,rht) == 0)
       {
         return comp2.compare(lft,rht);
       }
       else
       {
         return comp1.compare(lft,rht);
       }
    }
}
