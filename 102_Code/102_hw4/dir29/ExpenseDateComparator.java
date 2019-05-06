import java.util.Comparator;


public class ExpenseDateComparator implements Comparator<FullExpense> {

	public ExpenseDateComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(FullExpense o1, FullExpense o2) {
		if( o1.getDate().after(o2.getDate())){
			return 1;
		}else if(o1.getDate().before(o2.getDate())){
			return -1;
		}
		return 0;
	}
}
