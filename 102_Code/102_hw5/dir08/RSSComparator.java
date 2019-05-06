import java.util.*;

public class RSSComparator
   implements Comparator
{
   public int compare(Object r1, Object r2)
   {
      Calendar c1 = ((RSSItem)r1).getDate();
      Calendar c2 = ((RSSItem)r2).getDate();
      
      return (int)Math.signum(c1.compareTo(c2));
   }
}
