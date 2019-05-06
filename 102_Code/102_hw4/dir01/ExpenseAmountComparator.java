import java.util.Comparator;


public class ExpenseAmountComparator implements Comparator<Payment> {

	@Override
	public int compare(Payment o1, Payment o2) {
		// TODO Auto-generated method stub
		if (o1.amount()>o2.amount())
		{
			return 1;
		}
		else if(o1.amount()<o2.amount())
		{
			return -1;
		}
		return 0;
	}

}
