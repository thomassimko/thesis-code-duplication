import java.util.Comparator;

@SuppressWarnings("unchecked")
public class ExpenseCategoryDelegateComparator implements Comparator<Expense>{
	private Comparator next;
	public ExpenseCategoryDelegateComparator(Comparator<Expense> n){
		next=n;
	}
	public int compare(Expense e1,Expense e2){
		int val=(e1.getCategory()).compareTo(e2.getCategory());
		if(val>0){
			return 1;
		}
		else if(val<0){
			return -1;
		}
		else{
			return next.compare(e1,e2);
		}
	}
}