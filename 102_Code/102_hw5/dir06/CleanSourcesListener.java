import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTextArea;


public class CleanSourcesListener implements ActionListener 
{

	private JTextArea sourceTextArea;
	private FeedReader reader;
	
	public CleanSourcesListener(JTextArea sourceTextArea, FeedReader reader)
	{
		this.sourceTextArea = sourceTextArea;
		this.reader = reader;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		sourceTextArea.setText("");
		reader.removeBadSources();
		List<String> sources = reader.getSources();
		Comparator<String> comp = new SourcesComparator();
		Collections.sort(sources, comp);
		for (int i = 0; i < sources.size(); i++)
		{
			sourceTextArea.append(sources.get(i) + "\n");
		}
	}

}
