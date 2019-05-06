import java.util.Comparator;
import java.lang.Integer;

@SuppressWarnings("unchecked")
public class ExpenseAmountDelegateComparator implements Comparator<Expense>{
	private Comparator next;
	public ExpenseAmountDelegateComparator(Comparator<Expense> n){
		next=n;
	}	
	public int compare(Expense e1,Expense e2){
		int d1=Integer.parseInt(e1.getDollars());
		int d2=Integer.parseInt(e2.getDollars());
		int c1=Integer.parseInt(e1.getCents());
		int c2=Integer.parseInt(e2.getCents());
		if(d1>d2){
			return 1;
		}
		else if(d2>d1){
			return -1;
		}
		else{
			if(c1>c2){
				return 1;
			}
			else if(c2>c1){
				return -1;
			}
			else{
				return next.compare(e1,e2);
			}
		}
	}
}