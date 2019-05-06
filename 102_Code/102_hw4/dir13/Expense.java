import java.util.Calendar;


public abstract class Expense {
	String category, paidTo;
	Calendar date;
	int amountd;
	int amountc;
	int remainingd;
	int remainingc;
	boolean type; //true=in-full, false=partial
	
	public boolean type() {
		return type;
	}

	public Calendar getDate() {
		return date;
	}

	public String getPayee() {
		return paidTo;
	}

	public String getPaid() {
		String cents;
		cents = (amountc < 10) ? "0" + amountc : "" + amountc;
		return "" + amountd + "." + cents;
	}

	public String getCategory() {
		return category;
	}

	public String getRemaining() {
		String cents;
		cents = (remainingc < 10) ? "0" + remainingc : "" + remainingc;
		return "" + remainingd + "." + cents;
	}
	
	public int getDollars() {
		return amountd;
	}
	
	public int getCents() {
		return amountc;
	}
}
