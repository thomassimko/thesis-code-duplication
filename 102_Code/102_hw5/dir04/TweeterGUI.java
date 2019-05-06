import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class TweeterGUI 
	extends javax.swing.JFrame
{
	FeedReader read = new readFeed();
	
	private final int WIDTH = 650;
	private final int HEIGHT = 750;
	
	// Frames, Panels, Panes, etc.
	private JFrame frame = new JFrame();
	private JPanel panel;
	private JPanel north = new JPanel(); 
	private JPanel east = new JPanel();
	private JPanel center = new JPanel();
	private JPanel centerItem = new JPanel();
	private JPanel centerSrc = new JPanel();
		
	private JTextArea itemTextArea = new JTextArea(30,40);
	private JTextArea srcTextArea = new JTextArea(7, 40);
	private JScrollPane items = new JScrollPane(itemTextArea);
	private JScrollPane srcsScrPn = new JScrollPane(srcTextArea);
	private JTextField northText = new JTextField(20);
	
	// Buttons and Labels
	private JButton rfrsh = new JButton("Refresh");
	private JButton badSrcs = new JButton("Bad Sources");
	private JButton clnSrcs = new JButton("Clean Sources");
	private JButton add = new JButton("Add");
	
	private JLabel src = new JLabel("Source");
	private JLabel rssItems = new JLabel("RSS Items");
	private JLabel sources = new JLabel("Sources");
	
	public TweeterGUI()
	{
		createFrame();
		adjustPanels();
		makeButtonsWork();
	}
	
	public void createFrame()
	{
		//Create Frame
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void adjustPanels()
	{
		//Adjust Panels
		panel = (JPanel) frame.getContentPane(); //Has BorderLayout
		panel.add(north, BorderLayout.NORTH);
		panel.add(east, BorderLayout.EAST);
		panel.add(center, BorderLayout.CENTER);
		center.add(centerItem);
		center.add(centerSrc);
				
		//Adjust North Panel 
		north.setLayout(new FlowLayout());
		north.add(src); //label
		north.add(northText); //textField
		north.add(add); //button
				
		//Adjust East Panel (buttons)
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.add(rfrsh);
		east.add(badSrcs);
		east.add(clnSrcs);
				
		//Adjust Center Panel (panels)
		center.add(centerItem);
		center.add(centerSrc);
			
		//Adjust CenterItem Panel
		centerItem.setLayout(new BorderLayout());
		centerItem.add(rssItems, BorderLayout.NORTH); //label
		centerItem.add(items, BorderLayout.CENTER); //text area
		itemTextArea.setEditable(false);
				
		//Adjust CenterSrc Panel
		centerSrc.setLayout(new BorderLayout());
		centerSrc.add(sources, BorderLayout.NORTH); //label
		centerSrc.add(srcsScrPn, BorderLayout.CENTER); //text area
		srcTextArea.setEditable(false);
	}
	
	public void makeButtonsWork()
	{
		ActionListener reflisten = new refreshListener(read,itemTextArea,srcTextArea);
		rfrsh.addActionListener(reflisten);
		
		ActionListener bdSrcListen = new badSourcesListener(read, srcTextArea);
		badSrcs.addActionListener(bdSrcListen);
		
		ActionListener clnSrcsListen = new cleanSourcesListener(read, srcTextArea);
		clnSrcs.addActionListener(clnSrcsListen);
		
		ActionListener addListen = new addListener(northText, read, itemTextArea, srcTextArea);
		add.addActionListener(addListen);
	}
}

class refreshListener
	implements ActionListener
{
	FeedReader read;
	JTextArea items;
	JTextArea srcs;
	
	public refreshListener(FeedReader read, JTextArea itemTextArea, JTextArea srcTextArea) 
	{
		this.read = read;
		this.items = itemTextArea;
		this.srcs = srcTextArea;
	}

	public void actionPerformed(ActionEvent e) 
	{
		/*This one retrieves feeds from sources and 
		 * GUI updates to display sources and items*/
		
		List<RSSItem> tweets = read.retrieveFeedItems();
		List<String> sources = read.getSortSource();

		items.setText("");
		srcs.setText("");
		for(int i = 0; i < tweets.size(); i++)
		{
			items.append(tweets.get(i).getTitle() +  "\n");
			items.append("   " + tweets.get(i).strDate() + "\n");
			items.append("   " + tweets.get(i).getLink() + "\n\n");
		}
		
		for(int j = 0; j < sources.size(); j++)
		{
			srcs.append(sources.get(j) + "\n");
		}
	}
}

class badSourcesListener
	implements ActionListener
{
	FeedReader read;
	JTextArea srcs;
	
	public badSourcesListener(FeedReader read, JTextArea srcTextArea)
	{
		this.read = read;
		this.srcs = srcTextArea;
	}

	public void actionPerformed(ActionEvent e) 
	{
		/*list of bad sources are displayed in sources text box*/		
		List<String> badSrcs = read.getBadSources();
		
		srcs.setText("");
		for(int i = 0; i < badSrcs.size(); i++)
		{
			srcs.append(badSrcs.get(i) + "\n");
		}
		
	}
}

class cleanSourcesListener
	implements ActionListener
{
	FeedReader read;
	JTextArea srcs;
	
	public cleanSourcesListener(FeedReader read, JTextArea srcTextArea) 
	{
		this.read = read;
		this.srcs = srcTextArea;
	}

	public void actionPerformed(ActionEvent e) 
	{
		/*bad sources are removed from FeedReader sources 
		 * text update to all current sources in sourceTextArea*/
		
		read.removeBadSources();
		
		List<String> sources = read.getSources();

		srcs.setText("");
		for(int j = 0; j < sources.size(); j++)
		{
			srcs.append(sources.get(j) + "\n");
		}
			
	}
}

class addListener
	implements ActionListener
{
	JTextField getSource;
	FeedReader read;
	JTextArea srcs;
	JTextArea items;
	
	public addListener(JTextField northText, FeedReader read, JTextArea itemTextArea, JTextArea srcTextArea) 
	{
		this.getSource = northText;
		this.read = read;
		this.items = itemTextArea;
		this.srcs = srcTextArea;
	}

	public void actionPerformed(ActionEvent e) 
	{
		/*Add a sources to list of sources in feed reader
		 * display list of sources and feed items*/
		String newSrc = getSource.getText();
		
		read.addSource(newSrc);
		
		List<RSSItem> tweets = read.retrieveFeedItems();
		List<String> sources = read.getSortSource();

		items.setText("");
		srcs.setText("");
		for(int i = 0; i < tweets.size(); i++)
		{
			items.append(tweets.get(i).getTitle() +  "\n");
			items.append("   " + tweets.get(i).strDate() + "\n");
			items.append("   " + tweets.get(i).getLink() + "\n\n");
		}
		
		for(int j = 0; j < sources.size(); j++)
		{
			srcs.append(sources.get(j) + "\n");
		}
	}
}
