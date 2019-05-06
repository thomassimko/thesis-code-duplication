import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI
    extends JFrame
{
    private JTextArea textArea = new JTextArea(30, 40);
    private JTextArea sourceTextArea = new JTextArea(7, 40);
    public void initialize(FeedReader reader)
    {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	frame.setSize(650, 750);
	frame.setResizable(false);
	JPanel panel = new JPanel();
	sourceTextArea.setEditable(false);
	textArea.setEditable(false);
	Container pane = frame.getContentPane();
	pane.setLayout(new BorderLayout());
	pane.add(northPanel(reader), BorderLayout.NORTH);
	pane.add(eastPanel(reader), BorderLayout.EAST);
	pane.add(centerPanel(reader), BorderLayout.CENTER);
	frame.setVisible(true);	
    }
    private JPanel northPanel(FeedReader reader)
    {
	JPanel north = new JPanel();
	north.setLayout(new FlowLayout());
	JLabel northLabel = new JLabel("Source:");
	JTextField addText = new JTextField();
	addText.setColumns(20);
	JButton addButton = new JButton("Add");
	addButton.addActionListener(new AddListener(addText, reader, sourceTextArea));
	north.add(northLabel);
	north.add(addText);
	north.add(addButton);
	return north;
    }
    private JPanel eastPanel(FeedReader reader)
    {
	JPanel east = new JPanel();
	east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
	JButton refreshButton = new JButton("Refresh");
      	refreshButton.addActionListener(new RefreshListener(reader, textArea, sourceTextArea));
	JButton badSourcesButton = new JButton("Bad Sources");
	badSourcesButton.addActionListener(new BadSourceListener(reader, sourceTextArea));
	JButton cleanSourcesButton = new JButton("Clean Sources");
	cleanSourcesButton.addActionListener(new CleanSourcesListener(reader, sourceTextArea));
	east.add(refreshButton);
	east.add(badSourcesButton);
	east.add(cleanSourcesButton);
	return east;
    }
    private JPanel centerPanel(FeedReader reader)
    {
	JPanel center = new JPanel();
	center.setLayout(new FlowLayout());

	JPanel itemPanel = new JPanel();
	itemPanel.setLayout(new BorderLayout());
	JLabel centerLabel = new JLabel("RSS Items");
	JScrollPane scrollPane = new JScrollPane(textArea);
	itemPanel.add(centerLabel, BorderLayout.NORTH);
	itemPanel.add(scrollPane, BorderLayout.CENTER);
	center.add(itemPanel);

	JPanel sourcePanel = new JPanel();
	sourcePanel.setLayout(new BorderLayout());
	JLabel sourcesLabel = new JLabel("Sources");
	JScrollPane sourceScrollPane = new JScrollPane(sourceTextArea);
	sourcePanel.add(sourcesLabel, BorderLayout.NORTH);
	sourcePanel.add(sourceScrollPane, BorderLayout.CENTER);
	center.add(sourcePanel);

       	itemPanel.setVisible(true);
 
	return center;
    }
}