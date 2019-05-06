import java.awt.event.*;
import java.util.List;
import java.util.Calendar;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class RefreshListener
	implements ActionListener
{
	FeedReader reader;
	JTextArea text;
	JTextArea source;
	List<RSSItem> rss;
	public RefreshListener(FeedReader reader, JTextArea text, JTextArea source)
	{
		this.reader = reader;
		this.text = text;
		this.source = source;
	}
	public void actionPerformed(ActionEvent e)
	{
		text.setText("");
		source.setText("");
		Comparator<RSSItem> comp = new DateComparator<RSSItem>();
		List<RSSItem> rss = reader.retrieveFeedItems();
		List<String> sources = reader.getSources();
		int size = rss.size();
		RSSItem item;
		Collections.sort(rss, comp);
		for (int i=0; i<size; i++)
		{
			item = rss.get(i);
			text.append(item.getTitle()+"\n");
			text.append("   "+item.getDateString()+"\n");
			text.append("   "+item.getLink()+"\n");
			text.append("\n");
		}
		Collections.sort(sources);
		for (String string : sources)
		{
			source.append(string+"\n");
		}
	}
}