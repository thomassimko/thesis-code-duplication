import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;


public class cleanBadSourcesButtonListener implements ActionListener 
{	
	private FeedReaderClass feedReader;
	JTextArea sourceArea;
	
	public cleanBadSourcesButtonListener(FeedReaderClass feedReader, JTextArea sourceArea)
	{
		this.feedReader = feedReader;
		this.sourceArea = sourceArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		cleanSources();
		displayListOfSources();
	}
		
	private void cleanSources() 
	{
		feedReader.removeBadSources();
	}

	private void displayListOfSources()
	{
		sourceArea.setText("");
		
		List<String> srcList = feedReader.getSources();
		int srcListSize = srcList.size();
		
		Collections.sort(srcList);
		
		for(int i = 0; i < srcListSize; i++)
		{
			sourceArea.append(srcList.get(i));
			sourceArea.append("\n");
		}
	}
}
