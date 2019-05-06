import java.util.Comparator;


public class ExpenseDelegateComparator implements Comparator<Payment> {
	
	Comparator<Payment> c1;
	Comparator<Payment> c2;
	public ExpenseDelegateComparator (Comparator<Payment> c1,Comparator<Payment> c2)
	{
		this.c1 = c1;
		this.c2 = c2;
	}
	@Override
	public int compare(Payment o1, Payment o2) {
		// TODO Auto-generated method stub
		if(c1.compare(o1, o2)!=0)
		{
			return c1.compare(o1, o2);
		}
		if(c2 == null)
		{
			return 0;
		}
		return c2.compare(o1, o2);
	}

}
