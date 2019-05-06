import java.util.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;


public class TwitterGuiFeed extends javax.swing.JFrame{
	private static TwitterFeedReader tweets;
	
	public TwitterGuiFeed() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout());
		setTitle("Twitter Gui Feed");
		setSize(650,750);
		final JTextArea feedFill=new JTextArea(30,40);
		final JTextArea sourceFill=new JTextArea(7,40);
		
		//North stuff
		JPanel panelN = new JPanel();
		panelN.setLayout(new FlowLayout());
		final JTextField addField=new JTextField(20);
		JButton addButton=new JButton("Add");
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tweets.addSource(addField.getText());
				addField.setText("");
				sourceFill.setText(refreshSources());
			}
		});
		panelN.add(new JLabel("Source: "));
		panelN.add(addField);
		panelN.add(addButton);
		
		//East stuff
		JPanel panelE = new JPanel();
		panelE.setLayout(new BoxLayout(panelE,BoxLayout.Y_AXIS));
		JButton refreshButton=new JButton("Refresh");
		refreshButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				feedFill.setText(refreshFeeds());
			}
		});
		JButton badSourcesButton=new JButton("Bad Sources");
		badSourcesButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> bad=tweets.getBadSources();
				String badOut="";
				for(String b:bad){
					badOut+=b+"\n";
				}
				sourceFill.setText(badOut);
			}
		});
		JButton cleanSourcesButton=new JButton("Clean Sources");
		cleanSourcesButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tweets.removeBadSources();
				sourceFill.setText(refreshSources());
			}
		});
		panelE.add(refreshButton);
		panelE.add(badSourcesButton);
		panelE.add(cleanSourcesButton);
		
		//Center stuff
		JPanel panelC = new JPanel();
		JPanel panelItem = new JPanel();
		JPanel panelSource = new JPanel();
		panelItem.setLayout(new BorderLayout());
		panelSource.setLayout(new BorderLayout());
		
		
		JScrollPane feedScroll=new JScrollPane(feedFill);
		feedFill.setEditable(false);
		panelItem.add(new JLabel("RSS Items"),BorderLayout.NORTH);
		panelItem.add(feedScroll,BorderLayout.CENTER);
		
		JScrollPane sourceScroll=new JScrollPane(sourceFill);
		sourceFill.setEditable(false);
		panelSource.add(new JLabel("Sources"),BorderLayout.NORTH);
		panelSource.add(sourceScroll,BorderLayout.CENTER);
		
		panelC.add(panelItem);
		panelC.add(panelSource);
		
		panel.add(panelN,BorderLayout.NORTH);
		panel.add(panelE,BorderLayout.EAST);
		panel.add(panelC,BorderLayout.CENTER);
	
		
		//new BoxLayout(getContentPane(),BoxLayout)
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	public static String refreshFeeds(){
		List<RSSItem> stuff=tweets.retrieveFeedItems();
		String feedsOutput="";
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy kk:mm:ss");
		for(RSSItem r:stuff){
			feedsOutput+=r.getTitle()+"\n    "+formatter.format(r.getDate())+"\n    "+r.getLink()+"\n \n";
		}
		return feedsOutput;
	}
	public static String refreshSources(){
		List<String> stuff=tweets.getSources();
		String sourcesOutput="";
		for(String s:stuff){
			sourcesOutput+=s+"\n";
		}
		return sourcesOutput;
	}
	public static void main(String [] args){
		TwitterGuiFeed window = new TwitterGuiFeed();
		window.setVisible(true);
		
		tweets=new TwitterFeedReader();
	}
}