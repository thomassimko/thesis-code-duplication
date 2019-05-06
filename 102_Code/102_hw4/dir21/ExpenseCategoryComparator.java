import java.util.Comparator;

@SuppressWarnings("unchecked")
public class ExpenseCategoryComparator implements Comparator<Expense>{
	public int compare(Expense e1,Expense e2){
		int val=(e1.getCategory()).compareTo(e2.getCategory());
		if(val>0){
			return 1;
		}
		else if(val<0){
			return -1;
		}
		else{
			return 0;
		}
	}
}