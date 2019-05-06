import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Tweeter extends JFrame{
	
	public Tweeter(){
		super();
		TweetReader tweetReader = new TweetReader();
		JPanel window = new JPanel();
		setSize(650, 750);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setLayout(new BorderLayout());
		
		Panel topPanel = new Panel();
		topPanel.setLayout(new FlowLayout());
		topPanel.add(new JLabel("Source:"));
		JTextField newSourceField = new JTextField("",20);
		topPanel.add(newSourceField);
		JButton addBtn = new JButton("Add");
		topPanel.add(addBtn);
		window.add(topPanel, BorderLayout.NORTH);
		
		Panel rightPanel = new Panel();
		rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
		JButton refreshBtn = new JButton("Refresh"); 
		rightPanel.add(refreshBtn);
		JButton badSourcesBtn = new JButton("Bad Sources"); 
		rightPanel.add(badSourcesBtn);
		JButton cleanBadSourcesBtn = new JButton("Clean Sources"); 
		rightPanel.add(cleanBadSourcesBtn);
		window.add(rightPanel,BorderLayout.EAST);
		
		Panel leftPanel = new Panel();
		
		Panel rssPanel = new Panel();
		rssPanel.setLayout(new BorderLayout());
		rssPanel.add(new JLabel("RSS Items"),BorderLayout.NORTH);
		JTextArea itemArea = new JTextArea(30,40);
		JScrollPane rssPane = new JScrollPane(itemArea);
		rssPanel.add(rssPane,BorderLayout.SOUTH);
		leftPanel.add(rssPanel);
		
		Panel sourcePanel = new Panel();
		sourcePanel.setLayout(new BorderLayout());
		sourcePanel.add(new JLabel("Sources"),BorderLayout.NORTH);
		JTextArea sourcesArea = new JTextArea(7,40);
		JScrollPane sourcePane = new JScrollPane(sourcesArea);
		sourcePanel.add(sourcePane,BorderLayout.SOUTH);
		leftPanel.add(sourcePanel);
		
		window.add(leftPanel,BorderLayout.CENTER);
		
		addBtn.addActionListener(new AddTweetListener(tweetReader,newSourceField,sourcesArea,itemArea));
		refreshBtn.addActionListener(new RefreshListener(tweetReader,itemArea));
		badSourcesBtn.addActionListener(new BadSourcesListener(tweetReader,sourcesArea));
		cleanBadSourcesBtn.addActionListener(new ClearBadSourcesListener(tweetReader,sourcesArea));
		
		setVisible(true);
		setContentPane(window);
	}
	
	public static void main(String[] args) {
		new Tweeter();
	}

}
class AddTweetListener implements ActionListener {
	private TweetReader reader;
	private JTextField newSourceField;
	private JTextArea sourcesArea;
	private JTextArea itemArea;
	
	public AddTweetListener(TweetReader reader,JTextField newSourceField, JTextArea sourcesArea, JTextArea itemArea){
		this.reader = reader;
		this.newSourceField = newSourceField;
		this.sourcesArea = sourcesArea;
		this.itemArea = itemArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sourcesArea.setText("");
		itemArea.setText("");
		reader.addSource(newSourceField.getText());
		List<RSSItem> tweetList = reader.retrieveFeedItems();
		for(RSSItem tweet : tweetList){
			itemArea.append(tweet.getTitle() + "\n");
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			String date = sdf.format(tweet.getDate().getTime());
			itemArea.append("   " + date + "\n");
			itemArea.append("   " + tweet.getLink() + "\n\n");
		}
		List<String> sources = reader.getSources();
		for(String source : sources){
			sourcesArea.append(source + "\n");
		}
		newSourceField.setText("");
	}
}

class RefreshListener implements ActionListener {
	private TweetReader reader;
	private JTextArea itemArea;
	public RefreshListener(TweetReader reader, JTextArea itemArea){
		this.reader = reader;
		this.itemArea = itemArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		itemArea.setText("");
		List<RSSItem> tweetList = reader.retrieveFeedItems();
		for(RSSItem tweet : tweetList){
			itemArea.append(tweet.getTitle() + "\n");
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm");
			String date = sdf.format(tweet.getDate().getTime());
			itemArea.append("   " + date + "\n");
			itemArea.append("   " + tweet.getLink() + "\n\n");
		}
	}
}

class BadSourcesListener implements ActionListener {
	private TweetReader reader;
	private JTextArea sourcesArea;
	public BadSourcesListener(TweetReader reader, JTextArea sourcesArea){
		this.reader = reader;
		this.sourcesArea = sourcesArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sourcesArea.setText("");
		List<String> badSources = reader.getBadSources();
		for(String badSource : badSources){
			sourcesArea.append(badSource + "\n");
		}			
	}
}

class ClearBadSourcesListener implements ActionListener {
	private TweetReader reader;
	private JTextArea sourcesArea;
	public ClearBadSourcesListener(TweetReader reader, JTextArea sourcesArea){
		this.reader = reader;
		this.sourcesArea = sourcesArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sourcesArea.setText("");
		reader.removeBadSources();
		List<String> sources = reader.getSources();
		for(String source : sources){
			sourcesArea.append(source + "\n");
		}
	}
}


