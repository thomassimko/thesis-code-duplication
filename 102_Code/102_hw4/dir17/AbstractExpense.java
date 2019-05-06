import java.util.Calendar;

public abstract class AbstractExpense
  implements Expense
{
  private Calendar date;
  private Payment paid;
  private Payment unpaid;
  private String paidTo;
  private String description;

  public AbstractExpense( Calendar date, String category, String paidTo,
    Payment amount, Payment remainingAmount )
  {
    this.date = date;
    this.description = category;
    this.paidTo = paidTo;
    this.paid = amount;
    this.unpaid = remainingAmount;
  }

  public AbstractExpense( Calendar date, String category, String paidTo,
    Payment amount )
  {
    this.date = date;
    this.description = category;
    this.paidTo = paidTo;
    this.paid = amount;
  }

  public abstract boolean isFull();

  public Calendar getDate()
  {
    return this.date;
  }

  public String getDescription()
  {
    return this.description;
  }

  public String getPaidTo()
  {
    return this.paidTo;
  }

  public Payment getAmount()
  {
    return this.paid;
  }

  public Payment getRemainingAmount()
  {
    return this.unpaid;
  }
}
