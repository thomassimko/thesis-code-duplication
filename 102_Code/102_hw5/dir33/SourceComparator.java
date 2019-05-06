import java.util.Comparator;

public class SourceComparator
   implements Comparator<String>
{
   public int compare(String one, String two)
   {
      return one.compareTo(two);
   }
}
