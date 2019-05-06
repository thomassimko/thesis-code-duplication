
public class TestCases {
	
	public static void testExpenseTrackingProgram() {
		Check.check(ExpenseTrackingProgram.convertToDollars("65.11"), 65);
		Check.check(ExpenseTrackingProgram.convertToDollars("1.00"), 1);
		Check.check(ExpenseTrackingProgram.convertToCents("65.11"), 11);
		Check.check(ExpenseTrackingProgram.convertToCents("1.00"), 0);
	}
	public static void main (String [] args) {
		testExpenseTrackingProgram();
	}
}

/*
in-full
07/26/1992 
food
Subway
10.0
0.00
partial
10/11/0012 
entertainment
Mini Golf Land
15.11
10.0
partial
08/12/1993 
food
SevenEleven
5.55
3.33
*/