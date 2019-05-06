import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;


public class BadActionListener implements ActionListener
{
	private FeedReader feed;
	private JTextArea sources;
	
	public BadActionListener(FeedReader feed, JTextArea sources)
	{
		this.feed = feed;
		this.sources = sources;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		sources.setText("");
		List<String> badList = feed.getBadSources();
		Collections.sort(feed.getBadSources(), new SourceComparator());
		for(String f : badList)
		{
			sources.append(f  + "\n");
		}
	}

}
