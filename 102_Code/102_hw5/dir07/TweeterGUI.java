import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.text.SimpleDateFormat;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.*;


public class TweeterGUI
	extends javax.swing.JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FeedReader reader;
	
	public TweeterGUI(FeedReader reader)
	{
		this.reader = reader;
		
		JFrame frame= new JFrame("Tweeter");
		frame.setSize(650, 750);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JTextArea items = new JTextArea(30, 40);
		JTextArea sources = new JTextArea(7, 40);
		
		Container pane = frame.getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(north(items, sources), BorderLayout.NORTH);
		pane.add(east(items, sources), BorderLayout.EAST);
		pane.add(center(items, sources), BorderLayout.CENTER);

		frame.setVisible(true);
	}
	
	public JPanel north(JTextArea itemTextArea, JTextArea sourcesTextArea)
	{
		JPanel north = new JPanel(new FlowLayout());
		JLabel sourceLabel = new JLabel("Source: ");
		JTextField sourceTextField = new JTextField(20);
		JButton sourceButton = new JButton("Add");
		sourceButton.addActionListener(new AddSourceListener(reader, sourceTextField, itemTextArea, sourcesTextArea));
		north.add(sourceLabel);
		north.add(sourceTextField);
		north.add(sourceButton);
		return north;
	}
	
	public JPanel east(JTextArea itemTextArea, JTextArea sourcesTextArea)
	{
		JPanel east = new JPanel();
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new RefreshListener(reader, itemTextArea, sourcesTextArea));
		JButton badSourcesButton = new JButton("Bad Sources");
		badSourcesButton.addActionListener(new BadSourcesListener(reader, sourcesTextArea));
		JButton cleanSourcesButton = new JButton("Clean Sources");
		cleanSourcesButton.addActionListener(new CleanSourcesListener(reader, sourcesTextArea));
		east.add(refreshButton);
		east.add(badSourcesButton);
		east.add(cleanSourcesButton);
		return east;
	}
	
	public JPanel center(JTextArea items, JTextArea sources)
	{
		JPanel center = new JPanel();
		center.add(centerRSSItems(items));
		center.add(centerSources(sources));
		return center;
	}
	
	public JPanel centerRSSItems(JTextArea itemTextArea)
	{
		JPanel centerRSSItemList = new JPanel();
		centerRSSItemList.setLayout(new BorderLayout());
		JLabel itemLabel = new JLabel("RSS Items");
		itemTextArea.setEditable(false);
		JScrollPane itemPane = new JScrollPane(itemTextArea);
		centerRSSItemList.add(itemLabel, BorderLayout.NORTH);
		centerRSSItemList.add(itemPane, BorderLayout.CENTER);
		return centerRSSItemList;
	}
	
	public JPanel centerSources(JTextArea sourceTextArea)
	{
		JPanel centerSourceList = new JPanel();
		centerSourceList.setLayout(new BorderLayout());
		JLabel sourceLabel = new JLabel("Sources");
		sourceTextArea.setEditable(false);
		JScrollPane sourcePane = new JScrollPane(sourceTextArea);
		centerSourceList.add(sourceLabel, BorderLayout.NORTH);
		centerSourceList.add(sourcePane, BorderLayout.CENTER);
		return centerSourceList;
	}
}

class DisplayItems
{
	private FeedReader reader;
	private JTextArea itemTextArea;
		
	public DisplayItems(FeedReader reader, JTextArea itemTextArea)
	{
		this.reader = reader;
		this.itemTextArea = itemTextArea;
	}
	
	public void display()
	{
		itemTextArea.setText("");
		
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		int numItems = reader.retrieveFeedItems().size();
		List<RSSItem> items = reader.retrieveFeedItems();
		Comparator<RSSItem> dateComp = new RSSItemComparator();
		Collections.sort(items, dateComp);
				
		for(int i=0; i<=numItems; i++)
		{
			itemTextArea.append(items.get(i).getTitle()+"\n");		
			itemTextArea.append("   "+df.format(items.get(i).getDate().getTime())+"\n");
			itemTextArea.append("   "+items.get(i).getLink()+"\n");
			itemTextArea.append("\n");		
		}
	}	
}	

	
class DisplaySources
{
	private List<String> sources;
	private JTextArea sourcesTextArea;
	
	public DisplaySources(List<String> sources, JTextArea sourcesTextArea)
	{
		this.sources = sources;
		Collections.sort(this.sources);
		this.sourcesTextArea = sourcesTextArea;
	}
	
	public void display()
	{
		sourcesTextArea.setText("");
		int numSources = sources.size();
		for(int i=0; i<numSources; i++)
		{
			sourcesTextArea.append(sources.get(i)+"\n");
		}
	}
}

class AddSourceListener
	implements ActionListener
{
	private FeedReader reader;
	private JTextField sourceTextField;
	private JTextArea itemTextArea;
	private JTextArea sourcesTextArea;
	
	public AddSourceListener(FeedReader reader, JTextField sourceTextField, 
								   	JTextArea itemTextArea, JTextArea sourcesTextArea)
	{
		this.reader = reader;
		this.sourceTextField = sourceTextField;
		this.itemTextArea = itemTextArea;
		this.sourcesTextArea = sourcesTextArea;
	}
	public void actionPerformed(ActionEvent e)
	{
		reader.addSource(sourceTextField.getText());
		sourceTextField.setText("");
		
		sourcesTextArea.append("Sources");
		new DisplaySources(reader.getSources(), sourcesTextArea).display();

		new DisplayItems(reader, itemTextArea).display();
	}
}

class RefreshListener
	implements ActionListener
{
	private FeedReader reader;
	private JTextArea itemTextArea;
	private JTextArea sourcesTextArea;
	
	public RefreshListener(FeedReader reader,	JTextArea itemTextArea, JTextArea sourcesTextArea)
	{
		this.reader = reader;
		this.itemTextArea = itemTextArea;
		this.sourcesTextArea = sourcesTextArea;
	}
	public void actionPerformed(ActionEvent e)
	{
		new DisplayItems(reader, itemTextArea).display();
		new DisplaySources(reader.getSources(), sourcesTextArea).display();
	}
}

class BadSourcesListener
		implements ActionListener
{
	private FeedReader reader;
	private JTextArea sourcesTextArea;
	
	public BadSourcesListener(FeedReader reader, JTextArea sourcesTextArea)
	{
		this.reader = reader;
		this.sourcesTextArea = sourcesTextArea;
	}
	public void actionPerformed(ActionEvent e)
	{
		new DisplaySources(reader.getBadSources(), sourcesTextArea).display();
	}
}

class CleanSourcesListener
	implements ActionListener
{
	private FeedReader reader;
	private JTextArea sourcesTextArea;

	public CleanSourcesListener(FeedReader reader, JTextArea sourcesTextArea)
	{	
		this.reader = reader;
		this.sourcesTextArea = sourcesTextArea;
	}
	public void actionPerformed(ActionEvent e)
	{
		reader.removeBadSources();
		new DisplaySources(reader.getSources(), sourcesTextArea).display();
	}
}
