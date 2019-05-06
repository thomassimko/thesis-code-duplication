import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextArea;


public class clearButtonListener 
	implements ActionListener 
{
	private FeedReader feed;
	private JTextArea sourceTextArea;
	
	public clearButtonListener(FeedReader feed, JTextArea sourceTextArea)
	{
		this.feed = feed;
		this.sourceTextArea = sourceTextArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		feed.removeBadSources();
		sourceTextArea.setText("");
	}

}