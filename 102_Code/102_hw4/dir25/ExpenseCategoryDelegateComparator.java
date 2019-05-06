import java.util.Comparator;


public class ExpenseCategoryDelegateComparator implements Comparator<Expenses> {
	Comparator<Expenses> next;
	public ExpenseCategoryDelegateComparator (Comparator<Expenses> next)
	{
		this.next = next;
	}
	@Override
	public int compare(Expenses e1, Expenses e2) {
		// TODO Auto-generated method stub
	    String o1 = e1.getCategory();
	    String o2 = e2.getCategory();
		int compare = o1.compareTo(o2);
		return compare==0?next.compare(e1, e2):compare;
	}

}
