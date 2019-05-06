import java.util.Comparator;


public class ExpensePayeeComparator implements Comparator<Payment> {

	@Override
	public int compare(Payment o1, Payment o2) {
		// TODO Auto-generated method stub
		return o1.name().compareTo(o2.name());
	}

}
