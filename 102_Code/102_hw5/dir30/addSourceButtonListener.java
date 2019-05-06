import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class addSourceButtonListener implements ActionListener 
{	
	private FeedReaderClass feedReader;
	JTextField sourceField;
	JTextArea itemArea;
	JTextArea sourceArea;
	
	public addSourceButtonListener(FeedReaderClass feedReader, JTextField sourceField, JTextArea itemArea, JTextArea sourceArea)
	{
		this.feedReader = feedReader;
		this.sourceField = sourceField;
		this.itemArea = itemArea;
		this.sourceArea = sourceArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		getSource();
		displayFeeds();
		displayListOfSources();
	}
	
	private void getSource()
	{
		String source = sourceField.getText();
		feedReader.addSource(source);
		sourceField.setText("");
	}
	
	private void displayListOfSources()
	{
		sourceArea.setText("");
		
		List<String> srcList = feedReader.getSources();
		int srcListSize = srcList.size();
		
		Collections.sort(srcList);
		
		for(int i = 0; i < srcListSize; i++)
		{
			sourceArea.append(srcList.get(i));
			sourceArea.append("\n");
		}
	}
	
	private void displayFeeds()
	{
		itemArea.setText("");
		
		Comparator<RSSItem> dateComparator = new dateComparator();
		
		List<RSSItem> feedItems = feedReader.retrieveFeedItems();
		
		Collections.sort(feedItems, dateComparator);
		
		for(int j = 0; j < feedItems.size(); j++)
		{
			RSSItem feedItem = feedItems.get(j);
			
			itemArea.append(feedItem.getTitle());
			itemArea.append("\n");
			Calendar c = feedItem.getDate();	
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			int year = c.get(Calendar.YEAR);
			int hour = c.get(Calendar.HOUR);
			int minute = c.get(Calendar.MINUTE);
			
			if(hour == 0)
			{
				hour = 12;
			}
			
			if(minute < 10)
			{
				itemArea.append("   " + month + "/" + day + "/" + year + " " + hour + ":0" + minute);
			}
			else
			{
				itemArea.append("   " + month + "/" + day + "/" + year + " " + hour + ":" + minute);
			}

			itemArea.append("\n");
			itemArea.append("   " + feedItem.getLink());
			itemArea.append("\n");
			itemArea.append("\n");
		}

	}
}
