import java.awt.event.*;
import java.util.List;
import java.util.Calendar;
import javax.swing.*;
import java.util.Collections;

public class CleanListener
	implements ActionListener
{
	FeedReader reader;
	JTextArea text;
	List<RSSItem> rss;
	public CleanListener(FeedReader reader, JTextArea text)
	{
		this.reader = reader;
		this.text = text;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		text.setText("");
		reader.removeBadSources();
		List<String> srcs = reader.getSources();
		Collections.sort(srcs);
		int size = srcs.size();
		for (int i=0; i<size; i++)
		{
			text.append(srcs.get(i)+"\n");
		}
	}
}