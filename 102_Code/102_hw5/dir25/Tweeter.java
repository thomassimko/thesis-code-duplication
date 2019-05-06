import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Tweeter 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		final FeedReader reader = new Read();
		// TODO Auto-generated method stub		
		JFrame gui = new JFrame();
		gui.setSize(650, 750);
		gui.setResizable(false);
		JPanel guipanel = (JPanel)gui.getContentPane();
		guipanel.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		JLabel url = new JLabel("Source:");
		north.add(url);
		final JTextField urlField = new JTextField(20);
		north.add(urlField);
		JButton urlButton = new JButton("Add");
		north.add(urlButton);

		guipanel.add(north, BorderLayout.NORTH);
		JPanel east = new JPanel();
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		JButton refresh = new JButton("Refresh");
		JButton badSources = new JButton("Bad Sources");
		JButton cleanSources = new JButton("Clean Sources");
		east.add(refresh);
		east.add(badSources);
		east.add(cleanSources);

		guipanel.add(east, BorderLayout.EAST);
		JPanel center = new JPanel();

		JPanel item = new JPanel();
		item.setLayout(new BorderLayout());
		JLabel rss = new JLabel("RSS Items");
		item.add(rss,BorderLayout.NORTH);

		final JTextArea itemArea = new JTextArea(30, 40);
		itemArea.setEditable(false);
		JScrollPane itemScroll = new JScrollPane(itemArea);
		itemScroll.createVerticalScrollBar();
		item.add(itemScroll, BorderLayout.SOUTH);

		JPanel sourcesCenter = new JPanel();
		sourcesCenter.setLayout(new BorderLayout());
		JLabel sourcesItem = new JLabel("Sources");
		sourcesCenter.add(sourcesItem, BorderLayout.NORTH);

		final JTextArea sourcesArea = new JTextArea(7, 40);
		sourcesArea.setEditable(false);
		JScrollPane sourcesScroll = new JScrollPane(sourcesArea);
		sourcesScroll.createVerticalScrollBar();
		sourcesCenter.add(sourcesScroll, BorderLayout.SOUTH);

		center.add(item);
		center.add(sourcesCenter);

		guipanel.add(center, BorderLayout.CENTER);

		////////////Action Listeners/////////////////
		urlButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String source = urlField.getText();

				reader.addSource(source);
				sourcesArea.setText("");
				for (int i = 0; i < reader.getSources().size(); i++)
				{
					sourcesArea.append(reader.getSources().get(i)+"\n");
				}
				urlField.setText("");
				
				DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
				itemArea.setText(" ");
				for(RSSItem rssitem : reader.retrieveFeedItems())
				{
					itemArea.append(rssitem.getTitle()+"\n");
					itemArea.append("   "+dateformat.format(rssitem.getDate().getTime())+"\n");
					itemArea.append("   "+rssitem.getLink()+"\n");
					itemArea.append("\n");
				}

			}
		});

		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
				itemArea.setText(" ");
				for(RSSItem rssitem : reader.retrieveFeedItems())
				{
					itemArea.append(rssitem.getTitle()+"\n");
					itemArea.append("   "+dateformat.format(rssitem.getDate().getTime())+"\n");
					itemArea.append("   "+rssitem.getLink()+"\n");
					itemArea.append("\n");
				}
			}
		} );


		badSources.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				sourcesArea.setText("");
				for (int i = 0; i < reader.getBadSources().size(); i++)
				{
					sourcesArea.append(reader.getBadSources().get(i)+"\n");
				}
			}

		});
		cleanSources.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				reader.removeBadSources();
				sourcesArea.setText("");
				for (int i = 0; i < reader.getSources().size(); i++)
				{
					sourcesArea.append(reader.getSources().get(i)+"\n");
				}


			}

		});

		

		gui.setVisible(true);
		
		
		
		/**
		FeedReader reader = new Read();
		reader.addSource("http://search.twitter.com/search.rss?q=from:keen_csc102");
		reader.addSource("http://search.twitter.com/search.rss?q=from:michael");
		reader.addSource("http://search.twitter.com/search.rs");
		reader.retrieveFeedItems();
		for ( int i =0 ; i < reader.retrieveFeedItems().size(); i++)
		{
			System.err.println(reader.retrieveFeedItems().get(i).getTitle());
			System.err.println(reader.retrieveFeedItems().get(i).getDate().toString());
			System.err.println(reader.retrieveFeedItems().get(i).getLink());
		}
		/**
		System.err.println(reader.getBadSources().toString());
		System.err.println(reader.getSources().toString());
		reader.removeBadSources();
		System.err.println(reader.getSources().toString());
		**/
		 
	}

}
