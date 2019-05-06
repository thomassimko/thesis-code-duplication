import java.util.Comparator;

public class DateComparator
   implements Comparator<RSSItem>
{
   public int compare(RSSItem one, RSSItem two)
   {
      return two.getDate().compareTo(one.getDate());
   }
}
