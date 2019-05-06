import java.util.Date;

public class partial implements Expenses{
String type = "partial";
Date date;
String category;
String payee;
Money amount;
Money remaining;


public String getType()
{
	return "partial";
}
public Date getDate()
{
	return date;
}
public String getCategory()
{
	return category;
}
public String getPayee()
{
	return payee;
}
public Money getAmount()
{
	return amount;
}
public Money getRemaining()
{
	return remaining;
}
public void setType(String type)
{
	this.type = type;
}
public void setDate(Date date)
{
	this.date = date;
}
public void setCategory(String category)
{
	this.category = category;
}
public void setPayee(String payee)
{
	this.payee = payee;
}
public void setAmount(Money amount)
{
	this.amount = amount;
}
public void setRemaining(Money remaining)
{
	this.remaining = remaining;
}
@Override
public String getExpense() {
	// TODO Auto-generated method stub
	return String.format("%1$2tm/%<2td/%<tY ", date)
			+ String.format("%-15.15s %10s (%s) [%s]",
			payee, amount.getMoney(), remaining.getMoney(), category);
}

}
