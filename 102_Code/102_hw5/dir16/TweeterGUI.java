import java.awt.*;
import java.awt.event.*;
import java.util.Formatter;
import java.util.List;
import javax.swing.*;

public class TweeterGUI
	extends javax.swing.JFrame
{
	private static final int WIDTH = 650;
	private static final int HEIGHT = 750;

	private FeedReader reader;
	private JTextField source;
	private JTextArea itemTextArea, sourceTextArea;

	public TweeterGUI(FeedReader reader)
	{
		this.reader = reader;

		JFrame frame = createFrame();

		JPanel mainPanel = (JPanel)(frame.getContentPane());

		mainPanel.add(createAddPanel(), BorderLayout.NORTH);
		mainPanel.add(createSidePanel(), BorderLayout.EAST);
		mainPanel.add(createCenterPanel(), BorderLayout.CENTER);

		frame.setVisible(true);
	}

	private JFrame createFrame()
	{
		JFrame frame = new JFrame();

		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		return frame;
	}

	private JPanel createAddPanel()
	{
		JPanel addPanel = new JPanel();

		addPanel.add(new JLabel("Source:"));

		this.source = new JTextField(20);
		addPanel.add(source);

		JButton addButton = new JButton("Add");
		addButton.addActionListener(new AddListener());
		addPanel.add(addButton);

		return addPanel;
	}

	private JPanel createSidePanel()
	{
		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new RefreshListener());
		sidePanel.add(refreshButton);

		JButton badSourcesButton = new JButton("Bad Sources");
		badSourcesButton.addActionListener(new BadSourcesListener());
		sidePanel.add(badSourcesButton);

		JButton cleanSourcesButton = new JButton("Clean Sources");
		cleanSourcesButton.addActionListener(new CleanSourcesListener());
		sidePanel.add(cleanSourcesButton);

		return sidePanel;
	}

	private JPanel createCenterPanel()
	{
		// create item panel
		JPanel itemPanel = new JPanel(new BorderLayout());

		this.itemTextArea = new JTextArea(30, 40);
		itemTextArea.setEditable(false);

		itemPanel.add(new JLabel("RSS Items"), BorderLayout.NORTH);
		itemPanel.add(new JScrollPane(itemTextArea), BorderLayout.CENTER);

		// create source panel
		JPanel sourcePanel = new JPanel(new BorderLayout());

		this.sourceTextArea = new JTextArea(7, 40);
		sourceTextArea.setEditable(false);

		sourcePanel.add(new JLabel("Sources"), BorderLayout.NORTH);
		sourcePanel.add(new JScrollPane(sourceTextArea), BorderLayout.CENTER);

		// create center panel
		JPanel centerPanel = new JPanel();

		centerPanel.add(itemPanel);
		centerPanel.add(sourcePanel);

		return centerPanel;
	}

	// METHODS TO UPDATE GUI
	private static void updateSources(FeedReader reader, JTextArea sourceTextArea)
	{
		List<String> sources = reader.getSources();
		sourceTextArea.setText("");

		for(String src : sources)
		{
			sourceTextArea.append(src + "\n");
		}

		sourceTextArea.setCaretPosition(0);
	}

	private static void updateItems(FeedReader reader, JTextArea itemTextArea)
	{
		List<RSSItem> items = reader.retrieveFeedItems();
		itemTextArea.setText("");

		for(RSSItem item : items)
		{
			itemTextArea.append(
				String.format("%1$s\n   %2$tD %<tr\n   %3$s\n\n", 
				item.getTitle(), item.getDate(), item.getLink())
				);
		}

		itemTextArea.setCaretPosition(0);
	}

	private static void badSources(FeedReader reader, JTextArea sourceTextArea)
	{
		List<String> badSources = reader.getBadSources();
		sourceTextArea.setText("");

		for(String src : badSources)
		{
			sourceTextArea.append(src + "\n");
		}

		sourceTextArea.setCaretPosition(0);
	}

	// ACTION LISTENERS
	private class AddListener
		implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			reader.addSource(source.getText());
			TweeterGUI.updateSources(reader, sourceTextArea);
			TweeterGUI.updateItems(reader, itemTextArea);
		}
	}

	private class RefreshListener
		implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			TweeterGUI.updateSources(reader, sourceTextArea);
			TweeterGUI.updateItems(reader, itemTextArea);
		}
	}

	private class BadSourcesListener
		implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			TweeterGUI.badSources(reader, sourceTextArea);
		}
	}

	private class CleanSourcesListener
		implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			reader.removeBadSources();
			TweeterGUI.updateSources(reader, sourceTextArea);
		}
	}
}