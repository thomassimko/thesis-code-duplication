import java.util.Scanner;


public class Money
{
	private int d;
	private int c;
	
	public Money(String m)
	{
		Scanner scanMoney = new Scanner(m);
		String sAmount = scanMoney.next();
		String sDollar = sAmount.substring(0, sAmount.indexOf("."));
		String sCent = sAmount.substring(sAmount.indexOf(".") + 1, sAmount.length());
		this.d = Integer.parseInt(sDollar);
		this.c = Integer.parseInt(sCent);
	}
	
	@Override
	public String toString()
	{
		String s = "" + d + ".";
		if(c < 10)
		{
			s = s + "0" + c;
		}
		else
		{
			s = s + c;
		}
		return s;
	}
	
	public int getDollar()
	{
		return this.d;
	}
	
	public int getCent()
	{
		return this.c;
	}
}
