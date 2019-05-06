import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JTextArea;


public class CleanActionListener implements ActionListener
{
	private FeedReader feed;
	private JTextArea sources;
	
	public CleanActionListener(FeedReader feed, JTextArea sources)
	{
		this.feed = feed;
		this.sources = sources;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		sources.setText("");
		feed.removeBadSources();
		Collections.sort(feed.getBadSources(), new SourceComparator());
		for(String f : feed.getSources())
		{
			sources.append(f);
		}
	}
}
