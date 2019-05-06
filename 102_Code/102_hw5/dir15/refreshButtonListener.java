import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;


public class refreshButtonListener implements ActionListener 
{
	private FeedReader feed;
	private JTextArea itemTextArea;
	private JTextArea sourceTextArea;
	
	public refreshButtonListener(FeedReader feed, JTextArea itemTextArea, JTextArea sourceTextArea)
	{
		this.feed = feed;
		this.itemTextArea = itemTextArea;
		this.sourceTextArea = sourceTextArea;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		List<RSSItem> tmp = feed.retrieveFeedItems();
		Collections.sort(tmp, new DateComparator());
		int size = tmp.size();
		
		itemTextArea.setText("");
		
		for(int i=0; i<size; i++)
		{
			itemTextArea.append(tmp.get(i).getTitle());
			itemTextArea.append("\n");
			itemTextArea.append("   " + tmp.get(i).getStringDate());
			itemTextArea.append("\n");
			itemTextArea.append("   " + tmp.get(i).getLink());
			itemTextArea.append("\n");
			itemTextArea.append("\n");
		}
		
		sourceTextArea.setText("");
		int sizeSource = feed.getSources().size();
		
		sourceTextArea.setText("");
		
		for(int i=0; i<sizeSource; i++)
		{
			sourceTextArea.append(feed.getSources().get(i));
			sourceTextArea.append("\n");
		}
		
	}

}
