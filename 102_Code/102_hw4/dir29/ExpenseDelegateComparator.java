import java.util.Comparator;


public class ExpenseDelegateComparator implements Comparator<FullExpense> {
	
	Comparator<FullExpense> comp1, comp2;
	
	public ExpenseDelegateComparator(Comparator<FullExpense> comp1, Comparator<FullExpense> comp2) {
		this.comp1 = comp1;
		this.comp2 = comp2;
	}

	@Override
	public int compare(FullExpense o1, FullExpense o2) {
		int firstComparison = comp1.compare(o1, o2);
		if(firstComparison == 0){
			return comp2.compare(o1, o2);
		}
		return firstComparison;
	}


}
