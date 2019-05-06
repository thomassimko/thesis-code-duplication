import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI
	extends javax.swing.JFrame
{
	private static FeedReader feed;
	
	public GUI(FeedReader feed)
	{	
		this.feed = feed;
		
		JTextArea feedItems = new JTextArea();
		JTextArea sources = new JTextArea();
		
		super.setLayout(new BorderLayout());
		super.setSize(650, 750);
		super.setResizable(false);
		
		super.add(createTop(sources), BorderLayout.NORTH);
		super.add(createRight(feedItems, sources), BorderLayout.EAST);
		super.add(createCenter(feedItems, sources), BorderLayout.CENTER);
		
		super.setVisible(true);
	}
	
	private static JPanel createTop(JTextArea sources)
	{
		ActionListener addAction;
		JButton addButton = new JButton("Add");
		JTextField tF = new JTextField(20);
		
		addAction = new AddActionListener(feed, tF, sources);
		addButton.addActionListener(addAction);
		
		JPanel top = new JPanel();
		top.add(new JLabel("Source"));
		top.add(tF);
		top.add(addButton);
		return top;
	}
	
	private static JPanel createRight(JTextArea feedItems, JTextArea sources)
	{
		JPanel right = new JPanel();
		JPanel buttonPane = new JPanel();
		
		ActionListener refreshAction = new RefreshActionListener(feed, feedItems);
		ActionListener sourcesAction = new CleanActionListener(feed, sources);
		ActionListener badAction = new BadActionListener(feed, sources);
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(refreshAction);
		JButton badSourcesButton = new JButton("Bad Sources");
		badSourcesButton.addActionListener(badAction);
		JButton cleanSourcesButton = new JButton("Clean Sources");
		cleanSourcesButton.addActionListener(sourcesAction);
		
		
		buttonPane.add(refreshButton);
		buttonPane.add(badSourcesButton);
		buttonPane.add(cleanSourcesButton);
		
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
		right.add(buttonPane);
		
		return right;
	}
	
	private static JPanel createCenter(JTextArea feedItems, JTextArea sources)
	{
		JPanel container = new JPanel();
		JPanel itemPanel = new JPanel();
		JPanel sourcePanel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(feedItems);
		JScrollPane sourcePane = new JScrollPane(sources);

		sources.setRows(7);
		sources.setColumns(40);
		sources.setEditable(false);
		
		feedItems.setRows(30);
		feedItems.setColumns(40);
		feedItems.setEditable(false);
		
		itemPanel.setLayout(new BorderLayout());
		itemPanel.add(new JLabel("RSS Items"), BorderLayout.NORTH);
		itemPanel.add(scrollPane, BorderLayout.CENTER);
		
		sourcePanel.setLayout(new BorderLayout());
		sourcePanel.add(new JLabel("Sources"), BorderLayout.NORTH);
		sourcePanel.add(sourcePane, BorderLayout.CENTER);
		
		container.add(itemPanel);
		container.add(sourcePanel);
		
		return container;
	}
}
