import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;


public class badSourcesButtonListener implements ActionListener 
{	
	private FeedReaderClass feedReader;
	JTextArea sourceArea;
	
	public badSourcesButtonListener(FeedReaderClass feedReader, JTextArea sourceArea)
	{
		this.feedReader = feedReader;
		this.sourceArea = sourceArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		displayListOfBadSources();
	}
		
	private void displayListOfBadSources()
	{
		sourceArea.setText("");
		
		List<String> badSrcList = feedReader.getBadSources();
		int badSrcListSize = badSrcList.size();
		
		Collections.sort(badSrcList);
		
		for(int i = 0; i < badSrcListSize; i++)
		{
			sourceArea.append(badSrcList.get(i));
			sourceArea.append("\n");
		}
	}
}
