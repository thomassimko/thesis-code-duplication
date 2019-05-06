import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class BadSourceListener
    implements ActionListener
{
    private FeedReader reader;
    private JTextArea textArea;
    public BadSourceListener(FeedReader reader, JTextArea textArea)
    {
	this.reader = reader;
	this.textArea = textArea;
    }
    public void actionPerformed(ActionEvent e)
    {
	textArea.setText("");
	int size = reader.getBadSources().size();
	for(int i = 0; i < size; i++){
	    textArea.append(reader.getBadSources().get(i) + "\n");
	}
    }
}