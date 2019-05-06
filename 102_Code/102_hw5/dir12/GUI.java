	import javax.swing.*;

	import java.awt.*;
	import java.awt.event.*;
import java.util.*;
import java.util.List;
	
public class GUI extends javax.swing.JFrame{

	private static final int WIDTH = 650;
	private static final int HEIGHT = 750;
	private JButton addBtn = new JButton("Add");
	private JTextField linkText = new JTextField(20);
	private JButton rfrshBtn = new JButton("Refresh");
	private JButton bsBtn = new JButton("Bad Sources");
	private JButton csBtn = new JButton("Clean Sources");
	private JTextArea display = new JTextArea(30,40);
	private JScrollPane items = new JScrollPane(display);
	private JTextArea srcs = new JTextArea(7,40);
	private JScrollPane sources = new JScrollPane(srcs);
	private FeedReader reader = new FeedRead();
	
	private ActionListener addListen = new addListener(reader, srcs, linkText, display);
	private ActionListener refreshListen = new RefreshListener(reader, display, srcs);
	private ActionListener listBadListen = new BadSrcListener(reader, srcs);
	private ActionListener removeBadListen = new removeListener(reader, srcs);
	   
	public GUI(){
		addBtn.addActionListener(addListen);
		rfrshBtn.addActionListener(refreshListen);
		bsBtn.addActionListener(listBadListen);
		csBtn.addActionListener(removeBadListen);
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel mainPanel = (JPanel) frame.getContentPane();
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel east = new JPanel();
		JPanel itemPanel = new JPanel();
		JPanel srcPanel = new JPanel();
		
		mainPanel.add(north,BorderLayout.NORTH);
		mainPanel.add(center,BorderLayout.CENTER);
		mainPanel.add(east,BorderLayout.EAST);
		
		
		north.setLayout(new FlowLayout());
		north.add(new JLabel("Source: "));
		north.add(linkText);
		north.add(addBtn);
		
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.add(rfrshBtn);
		east.add(bsBtn);
		east.add(csBtn);
		
		center.add(itemPanel);
		center.add(srcPanel);
		
		itemPanel.setLayout(new BorderLayout());
		itemPanel.add(new JLabel("RSS Items"),BorderLayout.NORTH);
		itemPanel.add(items,BorderLayout.CENTER);
		
		srcPanel.setLayout(new BorderLayout());
		srcPanel.add(new JLabel("Sources"),BorderLayout.NORTH);
		srcPanel.add(sources,BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}

class BadSrcListener implements ActionListener{
	
	private FeedReader reader;
	private JTextArea srcs;
	
	public BadSrcListener(FeedReader read, JTextArea sources){
		this.reader = read;
		this.srcs = sources;
		
	}

	public void actionPerformed(ActionEvent e) {
		
		srcs.setText("");
		
		List<String> badSources = reader.getBadSources();
		
		for(int j = 0; j < badSources.size(); j++)
		{
			srcs.append(badSources.get(j) + "\n");
		}
		
	}
}

class RefreshListener implements ActionListener{
	
	private FeedReader reader;
	private JTextArea items;
	private JTextArea srcs;

	public RefreshListener(FeedReader read, JTextArea items, JTextArea sources) 
	{
		this.reader = read;
		this.items = items;
		this.srcs = sources;
	}

	public void actionPerformed(ActionEvent e) {
		
		
		List<RSSItem> tweeters = reader.retrieveFeedItems();
		List<String> sources = reader.getSources();
	
		items.setText("");
		srcs.setText("");

		for(int j = 0; j < sources.size(); j++)
		{
			srcs.append(sources.get(j) + "\n");
		}
		
		for (int i=0;i<tweeters.size();i++){
			items.append( tweeters.get(i).getTitle()+"\n");
			items.append("   "+String.format("%1$2tm/%<2td/%<tY %<tH:%<tm", tweeters.get(i).getDate())+"\n");
			items.append("   "+tweeters.get(i).getLink()+"\n");
		}
	}
}

class removeListener implements ActionListener{
	
	private FeedReader reader;
	private JTextArea srcs;
	
	public removeListener(FeedReader read, JTextArea sources){
		this.reader = read;
		this.srcs = sources;
	}

	public void actionPerformed(ActionEvent e) {
		
		reader.removeBadSources();
		List<String> sources = reader.getSources();
	
		srcs.setText("");

		for(int j = 0; j < sources.size(); j++)
		{
			srcs.append(sources.get(j) + "\n");
		}

	}
	
}

class addListener implements ActionListener
{
	private FeedReader reader;
	private JTextArea srcs;
	private JTextField getSource;
	private JTextArea items;

	public addListener( FeedReader read, JTextArea sources,JTextField addText, JTextArea items) 
	{
		this.reader = read;
		this.srcs = sources;
		this.getSource = addText;
		this.items = items;
	}

	public void actionPerformed(ActionEvent e) 
	{
		String Src = getSource.getText();
		reader.addSource(Src);
		
		List<RSSItem> tweeters = reader.retrieveFeedItems();
		List<String> sources = reader.getSources();
	
		srcs.setText("");
		items.setText("");
		
		for(int j = 0; j < sources.size(); j++){
			srcs.append(sources.get(j)+"\n");
		}
		
		for (int i=0;i<tweeters.size();i++){
			items.append( tweeters.get(i).getTitle() + "\n");
			items.append("   "+String.format("%1$2tm/%<2td/%<tY %<tH:%<tm", tweeters.get(i).getDate()) + "\n");
			items.append("   "+tweeters.get(i).getLink()+"\n");
		}	
	}
}

