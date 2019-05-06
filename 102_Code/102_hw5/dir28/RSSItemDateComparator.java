import java.util.Comparator;

public class RSSItemDateComparator
   implements Comparator<RSSItem>
{
   public int compare(RSSItem i1, RSSItem i2)
   {
      if(i1.getDate().getTime().after(i2.getDate().getTime()))
      {
         return -1;
      }
      else if(i1.getDate().getTime().before(i2.getDate().getTime()))
      {
         return 1;
      }
      else
      {
         return 0;
      }
   }
}