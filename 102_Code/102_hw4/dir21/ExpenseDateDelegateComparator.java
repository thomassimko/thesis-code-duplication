import java.util.Comparator;
import java.util.Date;

@SuppressWarnings("unchecked")
public class ExpenseDateDelegateComparator implements Comparator<Expense>{
	private Comparator next;
	public ExpenseDateDelegateComparator(Comparator<Expense> n){
		next=n;
	}
	public int compare(Expense e1,Expense e2){
		if((e1.getDate()).after(e2.getDate())){
			return 1;
		}
		else if((e2.getDate()).after(e1.getDate())){
			return -1;
		}
		else{
			return next.compare(e1,e2);
		}
	}
}