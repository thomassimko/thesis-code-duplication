import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;


public class addButtonListener 
	implements ActionListener 
{
	private FeedReader feed;
	private JTextField src;
	private JTextArea sourceTextArea;
	
	public addButtonListener(FeedReader feed, JTextField searchText, JTextArea sourceTextArea)
	{
		this.feed = feed;
		this.src = searchText;
		this.sourceTextArea = sourceTextArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String source = src.getText();
		feed.addSource(source);
		src.setText("");
		int size = feed.getSources().size();
		
		sourceTextArea.setText("");
		
		for(int i=0; i<size; i++)
		{
			sourceTextArea.append(feed.getSources().get(i));
			sourceTextArea.append("\n");
		}
		
	}
}
