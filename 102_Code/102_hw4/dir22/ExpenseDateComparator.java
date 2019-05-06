//Programmed by Michael Olivarez
import java.util.*;
public class ExpenseDateComparator
  extends ExpenseDelegateComparator
{
  public int compare(Expense lft, Expense rht)
  {
    String lftDate = lft.getDate();
    String rhtDate = rht.getDate();

    Scanner lftDateScan = new Scanner(lftDate);
    lftDateScan.useDelimiter("/");
    int lftMonth = lftDateScan.nextInt();
    int lftDay = lftDateScan.nextInt();
    int lftYear = lftDateScan.nextInt();
    lftDateScan.close();
    
    Scanner rhtDateScan = new Scanner(rhtDate);
    rhtDateScan.useDelimiter("/");
    int rhtMonth = rhtDateScan.nextInt();
    int rhtDay = rhtDateScan.nextInt();
    int rhtYear = rhtDateScan.nextInt();
    rhtDateScan.close();
    
    if(lftYear != rhtYear)
    {
      return rhtYear - lftYear;
    }    
    else if(lftMonth != rhtMonth)
    {
      return rhtMonth - lftMonth;
    }
    else
    {
      return rhtDay - lftDay;
    }
  }
}
