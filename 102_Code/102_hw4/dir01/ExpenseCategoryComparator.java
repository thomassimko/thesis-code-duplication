import java.util.Comparator;


public class ExpenseCategoryComparator implements Comparator<Payment> {

	@Override
	public int compare(Payment o1, Payment o2) {
		// TODO Auto-generated method stub
		return o1.Catagory().compareTo(o2.Catagory());
	}

}
