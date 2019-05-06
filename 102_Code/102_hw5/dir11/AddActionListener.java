import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AddActionListener implements ActionListener
{
	private FeedReader feed;
	private JTextField tF;
	private JTextArea sources;
	List<String> feedList = new LinkedList<String>();
	
	public AddActionListener(FeedReader feed, JTextField tF, JTextArea sources)
	{
		this.tF = tF;
		this.feed = feed;
		this.sources = sources;
		this.feedList = feed.getSources();
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{	
		feedList.add(tF.getText());
		
		sources.setText("");
		
		Collections.sort(feedList, new SourceComparator());
		
		for(String f : feedList)
		{
			sources.append(f + "\n");
		}
	}

}
