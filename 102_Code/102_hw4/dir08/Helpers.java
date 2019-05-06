import java.util.*;
import java.io.*;
import java.text.*;

public class Helpers
{
   public static Calendar convertToDate(String s) throws Exception
   {
      Calendar c = Calendar.getInstance();

      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
      Date d = df.parse(s);
      c.setTime(d);

      return c;
   }
       
   public static Amount readAmount(String s) throws Exception 
   {
      String[] tokens = s.split("\\.");
      return new Amount(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
   }
}
