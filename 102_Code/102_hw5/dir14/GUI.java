import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class GUI 
   extends javax.swing.JFrame
{
	public GUI gui = this;
	private FeedReader feedReader;
	private JTextField source;
	private JTextArea data;
	private JTextArea sources;
	
	//setting up the frame and giving the feed reader so the useful parts can be displayed
	public GUI(FeedReader feedReader)
	{
		this.feedReader = feedReader;

		this.setSize(650, 750);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		createContainer();

		this.setVisible(true);
	}

	//divides the frame into 3 sections (North, East and Center)	
	public void createContainer()
	{
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(north(), BorderLayout.NORTH);
		container.add(east(), BorderLayout.EAST);
		container.add(center(), BorderLayout.CENTER);
	}
	
	//creates the north panel where the source text will be entered and where the add button is
	public JPanel north()
	{
		JLabel sourceLabel = new JLabel("Source:");
		JTextField source = new JTextField(20);
		this.source = source;
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		
		JButton addButton = new JButton("Add");

		northPanel.add(sourceLabel);
		northPanel.add(source);
		northPanel.add(addButton);

		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addAction();
			}
		});
		
		return northPanel;
	}
	
	//method that take care of the adding of a source 
	public void addAction()
	{
		sources.setText("");
		data.setText("");
		List<String> sourceList = new ArrayList<String>();
		List<RSSItem> items = new ArrayList<RSSItem>();
		String src = source.getText();
		source.setText("");
		feedReader.addSource(src);
		sourceList = feedReader.getSources();
		items = feedReader.retrieveFeedItems();
		
		for(int i = 0; i < items.size(); i++)
		{
			String title = items.get(i).getTitle();
			String date = items.get(i).getStringDate();
			String link = items.get(i).getLink();
			data.append(title + "\n");
			data.append(date + "\n");
			data.append(link + "\n\n");
		}
		
		Collections.sort(sourceList);
		for(String s : sourceList)
		{
			sources.append(s + "\n");
		}
	}
	
	//creates the right side panel where the refresh, bad sources, and clean sources buttons go
	public JPanel east()
	{
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		
		JButton refreshButton = new JButton("Refresh");
		JButton badSourcesButton = new JButton("Bad Sources");
		JButton cleanSourcesButton = new JButton("Clean Sources");

		eastPanel.add(refreshButton);
		eastPanel.add(badSourcesButton);
		eastPanel.add(cleanSourcesButton);

		refreshButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				refreshAction();
			}
		});

		badSourcesButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				badSourcesAction();
			}
		});

		cleanSourcesButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cleanSourcesAction();
			}
		});
		
		return eastPanel;
	}
	
	//performs the refresh operation by adding any new tweets to the data field
	public void refreshAction()
	{
		data.setText("");
		List<RSSItem> items = new ArrayList<RSSItem>();
		items = feedReader.retrieveFeedItems();
		for(int i = 0; i < items.size(); i++)
		{
			String title = items.get(i).getTitle();
			String date = items.get(i).getStringDate();
			String link = items.get(i).getLink();
			data.append(title + "\n");
			data.append(date + "\n");
			data.append(link + "\n\n");
		}
	}
	
	//performs the bad sources operation by displaying only the bad sources when the button is clicked
	public void badSourcesAction()
	{
		List<String> badSources = feedReader.getBadSources();
		sources.setText("");
		for(int i = 0; i < badSources.size(); i++)
		{
			sources.setText(badSources.get(i));
		}
	}
	
	//performs the clean sources operation by removing the bad sources and printing out only the clean sources
	public void cleanSourcesAction()
	{
		List<String> sourceList = new ArrayList<String>();
		feedReader.removeBadSources();
		sourceList = feedReader.getSources();
		Collections.sort(sourceList);
		sources.setText("");
		for(String s : sourceList)
		{
			sources.append(s + "\n");
		}
	}
	
	//creates a new border layout for the center section of the frame with 2 parts a north and center part
	public JPanel center()
	{
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(centerNorth(), BorderLayout.NORTH);
		centerPanel.add(centerCenter(), BorderLayout.CENTER);
		return centerPanel;
	}

	//creates a new border layout where the RSS Items label is and the tweets appear
	public JPanel centerNorth()
	{
		JPanel centerNorth = new JPanel();
		centerNorth.setLayout(new BorderLayout());
		centerNorth.add(northTextArea(), BorderLayout.NORTH);
		centerNorth.add(centerTextArea(), BorderLayout.CENTER);

		return centerNorth;
	}
	
	//the RSS Items label for the text box
	public JPanel northTextArea()
	{
		JPanel northLabel = new JPanel();
		JLabel dataLabel = new JLabel("RSS Items");
		northLabel.add(dataLabel);
		return northLabel;
	}
	
	//the text box that holds the tweets, date and link
	public JPanel centerTextArea()
	{
		JPanel centerTextArea = new JPanel();
		JTextArea data = new JTextArea(30, 40);
		this.data = data;
		JScrollPane scroll = new JScrollPane(data);
		data.setEditable(false);
		centerTextArea.add(scroll);
		
		return centerTextArea;
	}
	
	//creates a new border layout with a north and center area for source's title and the sources text field
	public JPanel centerCenter()
	{
		JPanel centerCenter = new JPanel();
		centerCenter.setLayout(new BorderLayout());
		centerCenter.add(northSources(), BorderLayout.NORTH);
		centerCenter.add(centerSources(), BorderLayout.CENTER);
		return centerCenter;
	}

	//creates the label for the sources box
	public JPanel northSources()
	{
		JPanel northSources = new JPanel();
		JLabel sourcesLabel = new JLabel("Sources");
		northSources.add(sourcesLabel);
		return northSources;		
	}

	//creates the text box for the sources
	public JPanel centerSources()
	{
		JPanel centerSources = new JPanel();
		JTextArea sources = new JTextArea(7, 40);
		this.sources = sources;
		JScrollPane scroll = new JScrollPane(sources);
		sources.setEditable(false);
		centerSources.add(scroll);
		return centerSources;
	}
}
