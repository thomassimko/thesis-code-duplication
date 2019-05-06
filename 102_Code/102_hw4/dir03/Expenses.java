//import java.text.*;
import java.util.*;

public interface Expenses 
{
	Calendar getDate();
	int getAmtDollars();
	int getAmtCents();
	String getAmtString();
	String getPayee();
	String getCategory();
	int getBalDollars();
	int getBalCents();
	String getBalString();
}
