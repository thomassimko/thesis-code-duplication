import java.util.Comparator;


public class ExpenseCategoryComparator implements Comparator<Expenses> {

	@Override
	public int compare(Expenses e1, Expenses e2) {
		// TODO Auto-generated method stub
	    String o1 = e1.getCategory();
	    String o2 = e2.getCategory();
	    return o1.compareTo(o2);
	
		
	}

	

}
