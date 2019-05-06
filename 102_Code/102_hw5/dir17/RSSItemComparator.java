public class RSSItemComparator
  implements java.util.Comparator<RSSItem>
{
  public int compare( RSSItem first, RSSItem second )
  {
    return second.getDate().compareTo( first.getDate() );
  }
}
