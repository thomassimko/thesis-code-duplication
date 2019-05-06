import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTextArea;


public class BadSourcesListener implements ActionListener 
{

	private JTextArea sourceTextArea;
	private FeedReader reader;
	
	public BadSourcesListener(JTextArea sourceTextArea, FeedReader reader)
	{
		this.sourceTextArea = sourceTextArea;
		this.reader = reader;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		sourceTextArea.setText("");
		List<String> badSources = reader.getBadSources();
		Comparator<String> comp = new SourcesComparator();
		Collections.sort(badSources, comp);
		for (int i = 0; i< badSources.size(); i++)
		{
			sourceTextArea.append(badSources.get(i) + "\n");
		}
	}

}
