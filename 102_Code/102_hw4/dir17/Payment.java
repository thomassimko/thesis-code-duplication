import java.util.Scanner;

public class Payment
{
  private int dollarsPaid;
  private int centsPaid;

  public Payment( String payment )
  {
    int index = payment.indexOf(".");

    if( index > 0 )
    {
      this.dollarsPaid = Integer.parseInt( payment.substring(0, index) );
      this.centsPaid = Integer.parseInt( payment.substring( index+1 ) );
    }
    else
    {
      this.dollarsPaid = Integer.parseInt( payment );
      this.centsPaid = 0;
    }
  }

  public String toString()
  {
    String dollarString = ( (Integer)dollarsPaid ).toString();
    String centString = ( (Integer)centsPaid ).toString();

    if( centsPaid < 10 )
    {
      centString = "0".concat(centString);
    }

    return dollarString + "." + centString;
  }

  public int getDollarsPaid()
  {
    return this.dollarsPaid;
  }

  public int getCentsPaid()
  {
    return this.centsPaid;
  }

  public int toCents()
  {
    return (this.dollarsPaid * 100) + this.centsPaid;
  }
}
