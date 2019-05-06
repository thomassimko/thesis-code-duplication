import java.util.Calendar;

public interface Expense
{
  public boolean isFull();
  public Calendar getDate();
  public String getDescription();
  public String getPaidTo();
  public Payment getAmount();
  public Payment getRemainingAmount();
}
