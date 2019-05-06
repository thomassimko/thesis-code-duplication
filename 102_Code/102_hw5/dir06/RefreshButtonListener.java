import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTextArea;


public class RefreshButtonListener implements ActionListener 
{

	JTextArea itemTextArea;
	JTextArea sourceTextArea;
	FeedReader reader;
	
	public RefreshButtonListener(JTextArea itemTextArea, JTextArea sourceTextArea, FeedReader reader)
	{
		this.itemTextArea = itemTextArea;
		this.sourceTextArea = sourceTextArea;
		this.reader = reader;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		itemTextArea.setText("");
		sourceTextArea.setText("");
		List<RSSItem> itemList = reader.retrieveFeedItems();
		List<String> sourceList = reader.getSources();
		Comparator<RSSItem> itemComp = new RSSItemComparator();
		Comparator<String> sourceComp = new SourcesComparator();
		Collections.sort(itemList, itemComp);
		Collections.sort(sourceList, sourceComp);
		for (int i = itemList.size() - 1; i > -1; i--)
		{
			itemTextArea.append(itemList.get(i).getTitle() + "\n");
			String date = formatDate(itemList.get(i).getDate());
			itemTextArea.append("   " + date + "\n");
			itemTextArea.append("   " + itemList.get(i).getLink() + "\n" + "\n");

		}
		for (int j = 0; j < sourceList.size(); j++)
		{
			sourceTextArea.append(sourceList.get(j) + "\n");
		}
		
	}
	
	private String formatDate(Calendar date)
	{
		return String.format("%1$2tm/%<2td/%<tY %<tH:%<tm", date);
	}

}
