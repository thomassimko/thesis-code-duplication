import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.text.*;
import java.util.*;
import javax.xml.xpath.XPathExpressionException;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Container;

public class tweetGUI
	extends JFrame
{
	JFrame mainFrame = new JFrame("RSS Feed");
	Container pane = mainFrame.getContentPane();

	JPanel sourcePanel = new JPanel(); //top
	JPanel feedPanel = new JPanel(); //mid
	JPanel buttonPanel = new JPanel(); //right

	JPanel itemPanel = new JPanel(); //nested in mid
	JPanel sources = new JPanel(); //nested in mid

	JLabel Source = new JLabel("Source:");
	JTextField sourceText = new JTextField(20);
	JButton sourceButton = new JButton("Add");

	JButton refresh = new JButton("Refresh");
	JButton badsrc = new JButton("Bad Sources");
	JButton cleansrc = new JButton("Clean Sources");

	JLabel RSSItems = new JLabel("RSS Items");
	JTextArea textArea = new JTextArea(30,40);
	JScrollPane scroll = new JScrollPane(textArea);

	JLabel srcs = new JLabel("Sources");
	JTextArea srcText = new JTextArea(7,40);
	JScrollPane sourceScroll = new JScrollPane(srcText);

	FeedReader feeder = new Reader();
		
	public void GUI()
	{
		srcText.setEditable(false);
		textArea.setEditable(false);
		sourceButton.addActionListener(new ButtonAction());
		refresh.addActionListener(new ButtonAction());
		badsrc.addActionListener(new ButtonAction());
		cleansrc.addActionListener(new ButtonAction());

		mainFrame.setSize(650,750);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout border1 = new BorderLayout(10,10);
		BorderLayout border2 = new BorderLayout(10,10);
		BorderLayout border3 = new BorderLayout(10,10);
		FlowLayout flow1 = new FlowLayout();
		FlowLayout flow2 = new FlowLayout();
		BoxLayout box = new BoxLayout(buttonPanel,BoxLayout.Y_AXIS);

		pane.setLayout(border1);
		sourcePanel.setLayout(flow1);
		buttonPanel.setLayout(box);
		feedPanel.setLayout(flow2);
		itemPanel.setLayout(border2);
		sources.setLayout(border3);
		
		pane.add(sourcePanel,border1.NORTH);
		pane.add(feedPanel,border1.CENTER);
		pane.add(buttonPanel,border1.EAST);

		feedPanel.add(itemPanel);
		feedPanel.add(sources);

		sourcePanel.add(Source);
		sourcePanel.add(sourceText);
		sourcePanel.add(sourceButton);

		buttonPanel.add(refresh);
		buttonPanel.add(badsrc);
		buttonPanel.add(cleansrc);

		itemPanel.add(RSSItems,border2.NORTH);
		itemPanel.add(scroll,border2.CENTER);

		sources.add(srcs,border3.NORTH);
		sources.add(sourceScroll,border3.CENTER);
		mainFrame.setVisible(true);
	}

	public class ButtonAction
		implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			if (a.getActionCommand().equals("Add"))
			{
				textArea.setText("");
				feeder.addSource(sourceText.getText());
				List<RSSItem> list = feeder.retrieveFeedItems();
				List<String> srcList = feeder.getSources();
				Collections.sort(list,new TweetComp());
				int size = list.size();
				int srcSize = srcList.size();
				for (int i = 0; i < size; i++)
				{
					try
					{
						textArea.append(list.get(i).getTitle() + "\n");
						textArea.append("   " + list.get(i).dateString() + "\n");
						textArea.append("   " + list.get(i).getLink() + "\n\n");
					}
					catch (ParseException e)
					{
						System.out.println("Parse Exception");
					}
				}
				srcText.setText("");
				Collections.sort(srcList,new AlphaComp());
				for (int j = 0; j < srcSize; j++)
				{
					srcText.append(srcList.get(j) + "\n");
				}
				list.clear();
			}
			else if (a.getActionCommand().equals("Refresh"))
			{
				textArea.setText("");
				List<RSSItem> list = feeder.retrieveFeedItems();
				List<String> srcList = feeder.getSources();
				Collections.sort(list,new TweetComp());
				int size = list.size();
				int srcSize = srcList.size();
				for (int i = 0; i < size; i++)
				{
					try
					{
						textArea.append(list.get(i).getTitle() + "\n");
						textArea.append("   " + list.get(i).dateString() + "\n");
						textArea.append("   " + list.get(i).getLink() + "\n\n");
					}
					catch (ParseException e)
					{
						System.out.println("Parse Exception");
					}
				}
				srcText.setText("");
				Collections.sort(srcList,new AlphaComp());
				for (int j = 0; j < srcSize; j++)
				{
					srcText.append(srcList.get(j) + "\n");
				}
				list.clear();
			}
			else if (a.getActionCommand().equals("Bad Sources"))
			{
				srcText.setText("");
				List<String> badSrc = feeder.getBadSources();
				int size = badSrc.size();
				for (int i = 0; i < size; i++)
				{
					srcText.append(badSrc.get(i) + "\n");
				}
			}
			else if (a.getActionCommand().equals("Clean Sources"))
			{
				feeder.removeBadSources();
				textArea.setText("");
				List<RSSItem> list = feeder.retrieveFeedItems();
				List<String> srcList = feeder.getSources();
				Collections.sort(list,new TweetComp());
				int size = list.size();
				int srcSize = srcList.size();
				for (int i = 0; i < size; i++)
				{
					try
					{
						textArea.append(list.get(i).getTitle() + "\n");
						textArea.append("   " + list.get(i).dateString() + "\n");
						textArea.append("   " + list.get(i).getLink() + "\n\n");
					}
					catch (ParseException e)
					{
						System.out.println("Parse Exception");
					}
				}
				srcText.setText("");
				Collections.sort(srcList,new AlphaComp());
				for (int j = 0; j < srcSize; j++)
				{
					srcText.append(srcList.get(j) + "\n");
				}
				list.clear();
			}
		}
	}
	
		







}
