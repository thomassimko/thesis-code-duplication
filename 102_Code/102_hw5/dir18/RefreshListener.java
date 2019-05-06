import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.util.Collections;
import java.util.Comparator;
import java.text.SimpleDateFormat;

 public class RefreshListener
    implements ActionListener
{
    private FeedReader reader;
    private JTextArea textArea, sourceTextArea;
    public RefreshListener(FeedReader reader, JTextArea textArea, JTextArea sourceTextArea)
    {
	this.reader = reader;
	this.textArea = textArea;
	this.sourceTextArea = sourceTextArea;
    }
    public void actionPerformed(ActionEvent e)
    {
	textArea.setText("");
	sourceTextArea.setText("");
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	int size = reader.retrieveFeedItems().size();
	Comparator compare = new DateComparator();
	Collections.sort(reader.retrieveFeedItems(), compare);
	for(int i = 0; i < size; i++){
	    textArea.append(reader.retrieveFeedItems().get(i).getTitle() + "\n");
	    textArea.append("   " + df.format(reader.retrieveFeedItems().get(i).getDate().getTime()) + "\n");
	    textArea.append("   " + reader.retrieveFeedItems().get(i).getLink() + "\n\n");
	}
	int sizeB = reader.getSources().size();
	for(int i = 0; i < sizeB; i++){
	    sourceTextArea.append(reader.getSources().get(i) + "\n");
	}
    }
}