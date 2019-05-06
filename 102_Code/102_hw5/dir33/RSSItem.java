import java.util.Calendar;
import java.text.ParseException;

public interface RSSItem
{
   String getTitle();
   Calendar getDate();
   String getLink();
   String calendarToString() throws ParseException;
}
