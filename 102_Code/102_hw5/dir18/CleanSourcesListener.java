import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class CleanSourcesListener
    implements ActionListener
{
    private FeedReader reader;
    private JTextArea textArea;
    public CleanSourcesListener(FeedReader reader, JTextArea textArea)
    {
	this.reader = reader;
	this.textArea = textArea;
    }
    public void actionPerformed(ActionEvent e)
    {
	textArea.setText("");
	reader.removeBadSources();
	//int size = reader.getSources().size();
	/*	for(int i = 0; i < size; i++){
	    textArea.append(reader.getSources().get(i));
	    }*/
    }
}