import java.util.Calendar;
public class BadItem implements RSSItem 
{
	private String source;
    public BadItem(String source)
    {
    	this.source = source;
    }
	public String getTitle() 
	{
		throw new UnsupportedOperationException();
	}
	public Calendar getDate() 
	{
		throw new UnsupportedOperationException();
	}
	public String getLink()
	{
		return this.source;
	}
}
