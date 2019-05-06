import java.util.Comparator;
import java.util.Date;

@SuppressWarnings("unchecked")
public class ExpenseDateComparator implements Comparator<Expense>{
		public int compare(Expense e1,Expense e2){
		if((e1.getDate()).after(e2.getDate())){
			return 1;
		}
		else if((e2.getDate()).after(e1.getDate())){
			return -1;
		}
		else{
			return 0;
		}
	}
}