
public class Money {
int dollar;
int cents;
public Money( int dollar, int cents)
{
	this.dollar = dollar;
	this.cents = cents;
}
public int getDollar()
{
	return this.dollar;
}
public int getCents()
{
	return this.cents;
}
public String getMoney()
{
	if (cents == 0)
	{
		return dollar+".00";
	}
	return dollar+"."+cents;
}
public void setDollar(int dollar)
{
	this.dollar = dollar;
}
public void setCents(int cents)
{
	this.cents = cents;
}
}
