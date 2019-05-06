import java.util.*;

public interface RSSItem
{
   String getTitle();
   Calendar getDate();
   String getLink();
	String dateToString();
	Date getTime();
}
