import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class NorthButtonListener implements ActionListener 
{

	private JTextField textField;
	private FeedReader reader;
	private JTextArea sourceTextArea;
	private JTextArea itemTextArea;
	
	public NorthButtonListener(JTextField textField, FeedReader reader, JTextArea itemTextArea, JTextArea sourceTextArea)
	{
		this.textField = textField;
		this.reader = reader;
		this.sourceTextArea = sourceTextArea;
		this.itemTextArea = itemTextArea;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(textField.getText().equals(""))
		{
			
		}
		else
		{
			reader.addSource(textField.getText());
			textField.setText(null);
		}
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
