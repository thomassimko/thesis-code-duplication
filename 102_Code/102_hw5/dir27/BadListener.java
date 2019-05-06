import java.awt.event.*;
import java.util.List;
import java.util.Calendar;
import javax.swing.*;

public class BadListener
	implements ActionListener
{
	FeedReader reader;
	JTextArea text;
	List<RSSItem> rss;
	public BadListener(FeedReader reader, JTextArea text)
	{
		this.reader = reader;
		this.text = text;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		text.setText("");
		List<String> bads = reader.getBadSources();
		int size = bads.size();
		for (int i=0; i<size; i++)
		{
			text.append(bads.get(i)+"\n");
		}
	}
}