import java.util.Date;


public interface Expenses {
	public String getType();
	
	public Date getDate();
	
	public String getCategory();
	
	public String getPayee();
	
	public Money getAmount();
	
	public Money getRemaining();
	
	public void setType(String type);
	
	public void setDate(Date date);
	
	public void setCategory(String category);
	
	public void setPayee(String payee);
	
	public void setAmount(Money amount);
	
	public void setRemaining(Money remaining);

	public String getExpense();
	
		
	

	}

