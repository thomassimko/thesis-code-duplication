import java.util.Comparator;


public class ExpenseDateComparator implements Comparator<Payment> {

	@Override
	public int compare(Payment arg0, Payment arg1) {
		// TODO Auto-generated method stub
		if (arg0.before(arg1))
		{
			return -1;
		}
		else if(arg0.after(arg1))
		{
			return 1;
		}
		return 0;
	}

}
