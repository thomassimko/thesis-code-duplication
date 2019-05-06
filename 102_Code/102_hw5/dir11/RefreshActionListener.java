import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;


public class RefreshActionListener implements ActionListener
{
	private FeedReader feed;
	private JTextArea feedItems;

	public RefreshActionListener(FeedReader feed, JTextArea feedItems)
	{
		this.feed = feed;
		this.feedItems = feedItems;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		feedItems.setText("");
		
		List<RSSItem> itemList = feed.retrieveFeedItems();
		Collections.sort(itemList, new DateComparator());
		
		for(RSSItem i : itemList)
		{
			feedItems.append(i.getTitle() + "\n");
			feedItems.append("   " + dateToString(i.getDate()) + "\n");
			feedItems.append("   " + i.getLink() + "\n\n");
		}
	}
	
	private static String dateToString(Calendar c)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		return dateFormat.format(c.getTime());
	}

}
