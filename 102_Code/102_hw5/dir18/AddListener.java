import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Comparator;
import java.util.Collections;

public class AddListener
    implements ActionListener 
{
    private JTextField textField;
    private FeedReader reader;
    private JTextArea textArea;
    public AddListener(JTextField textField, FeedReader reader, JTextArea textArea)
    {
	this.reader = reader;
	this.textField = textField;
	this.textArea = textArea;
    }
    public void actionPerformed(ActionEvent e)
    {
	String str;
	str = textField.getText();
	reader.getSources().add(str);
	textField.setText("");
	textArea.setText("");
	Comparator compare = new SourceComparator();
	Collections.sort(reader.getSources(), compare);
	int size = reader.getSources().size();
	for(int i = 0; i < size; i++){
	    textArea.append(reader.getSources().get(i) + "\n");
	}
    }
}