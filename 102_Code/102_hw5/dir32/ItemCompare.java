public class ItemCompare
   implements java.util.Comparator<RSSItem>
{
   public int compare(RSSItem taco, RSSItem burrito)
   {
      return burrito.getDate().compareTo(taco.getDate());
   }
}
