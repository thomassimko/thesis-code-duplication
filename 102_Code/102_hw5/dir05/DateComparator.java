import java.util.Comparator;
import java.util.Calendar;

public class DateComparator
   implements Comparator<RSSItem>
{
   public int compare(RSSItem one, RSSItem two)
   {
      return one.getDate().compareTo(two.getDate());
   }
}