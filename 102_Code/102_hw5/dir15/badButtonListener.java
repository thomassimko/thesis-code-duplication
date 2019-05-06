import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextArea;


public class badButtonListener 
	implements ActionListener 
{
	private FeedReader feed;
	private JTextArea sourceTextArea;
	
	public badButtonListener(FeedReader feed, JTextArea sourceTextArea)
	{
		this.feed = feed;
		this.sourceTextArea = sourceTextArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		List<String> tmp = feed.getBadSources();
		int size = tmp.size();
		
		sourceTextArea.setText("");
		
		for(int i=0; i<size; i++)
		{
			sourceTextArea.append(tmp.get(i));
			sourceTextArea.append("\n");
		}

	}

}
