import java.util.Date;

public class TwitterRSSItem implements RSSItem{
	private String title,link;
	private Date date;
   
	public TwitterRSSItem(String t,Date d,String l){
		title=t;
		date=d;
		link=l;
	}
	public String getTitle(){
		return title;
	}
	public Date getDate(){
		return date;
	}
	public String getLink(){
		return link;
	}
}
