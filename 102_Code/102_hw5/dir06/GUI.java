import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private FeedReader reader;
	private JTextArea itemTextArea;
	private JTextArea sourceTextArea;
	
	public GUI(FeedReader reader)
	{
		super();
		this.reader = reader;		
	}
	
	public void launchGUI()
	{
		setPanels();
		initializeGUI();
	}
	
	private void initializeGUI()
	{
		setSize(650, 750);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	private void setPanels()
	{
		JPanel mainPanel = (JPanel)getContentPane();
		JPanel centerPanel = setCenterPanel();
		JPanel northPanel = setNorthPanel();
		JPanel eastPanel = setEastPanel();
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
	}
	
	private JPanel setNorthPanel()
	{
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		JLabel northLabel = new JLabel("Source:");
		JTextField northText = new JTextField(20);
		JButton northButton = new JButton("Add");
		northPanel.add(northLabel);
		northPanel.add(northText);
		northPanel.add(northButton);
		ActionListener buttonListener = new NorthButtonListener(northText, reader, itemTextArea, sourceTextArea);
		northButton.addActionListener(buttonListener);	
		return northPanel;
	}
	
	private JPanel setEastPanel()
	{
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		
		JButton refreshButton = new JButton("Refresh");
		ActionListener refreshListener = new RefreshButtonListener(itemTextArea, sourceTextArea, reader);
		refreshButton.addActionListener(refreshListener);
		
		JButton badSourcesButton = new JButton("Bad Sources");
		ActionListener badSourcesListener = new BadSourcesListener(sourceTextArea, reader);
		badSourcesButton.addActionListener(badSourcesListener);
		
		JButton cleanSourcesButton = new JButton("Clean Sources");
		ActionListener cleanSourcesListener = new CleanSourcesListener(sourceTextArea, reader);
		cleanSourcesButton.addActionListener(cleanSourcesListener);
		
		eastPanel.add(refreshButton);
		eastPanel.add(badSourcesButton);
		eastPanel.add(cleanSourcesButton);
		return eastPanel;
	}
	
	private JPanel setCenterPanel()
	{
		JPanel centerPanel = new JPanel();
		JPanel itemPanel = new JPanel();
		itemPanel.setLayout(new BorderLayout());
		JPanel sourcePanel = new JPanel();
		sourcePanel.setLayout(new BorderLayout());
		
		JLabel rssItemsLabel = new JLabel("RSS Items");
		itemPanel.add(rssItemsLabel, BorderLayout.NORTH);
		
		itemTextArea = new JTextArea(30, 40);
		itemTextArea.setEditable(false);
		JScrollPane itemScroll = new JScrollPane(itemTextArea);
		itemPanel.add(itemScroll, BorderLayout.CENTER);
		centerPanel.add(itemPanel, BorderLayout.NORTH);
		
		JLabel sourcesLabel = new JLabel("Sources");
		sourcePanel.add(sourcesLabel, BorderLayout.NORTH);
		
		sourceTextArea = new JTextArea(7, 40);
		sourceTextArea.setEditable(false);
		JScrollPane sourceScroll = new JScrollPane(sourceTextArea);
		sourcePanel.add(sourceScroll, BorderLayout.CENTER);
		centerPanel.add(sourcePanel, BorderLayout.CENTER);
		return centerPanel;
		
	}
}
