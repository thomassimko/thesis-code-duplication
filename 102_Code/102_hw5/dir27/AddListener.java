import java.awt.event.*;
import java.util.List;
import java.util.Calendar;
import javax.swing.*;

public class AddListener
	implements ActionListener
{
	FeedReader reader;
	JTextField textField;
	List<RSSItem> rss;
	public AddListener(FeedReader reader, JTextField textField)
	{
		this.reader = reader;
		this.textField = textField;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		reader.addSource(textField.getText());
		textField.setText("");
	}
}