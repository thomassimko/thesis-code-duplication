import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class Tweeter extends JFrame implements ActionListener
{
	private JButton button1, button2, button3, button4;
	private JPanel panel1, panel2, panel3, panel4, panel5;
	private JLabel label1, label2, label3;
	private TextField text;
	private JTextArea textArea1, textArea2;
	private FeedReader reader = new Reader();
	
	public Tweeter()
	{
		super("Tweeter");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);

		setLayout(new BorderLayout());
		
		panel1 = new JPanel(new FlowLayout());
		text = new TextField(20);
		label1 = new JLabel("Source");
		button1 = new JButton("Add");
		button1.addActionListener(this);
		panel1.add(label1);
		panel1.add(text);
		panel1.add(button1);
		add(panel1, BorderLayout.NORTH);
	
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		button2 = new JButton("Refresh");
		button3 = new JButton("Bad Sources");
		button4 = new JButton("Clean Sources");
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		add(panel2,BorderLayout.EAST);
		
		panel3 = new JPanel(new BorderLayout());
		panel4 = new JPanel(new BorderLayout());
		label2 = new JLabel("RSS Items");
		textArea1 = new JTextArea(30,40);
		textArea1.setEditable(false);
		JScrollPane scrollPane1 = new JScrollPane(textArea1);
		scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel4.add(label2, BorderLayout.NORTH);
		panel4.add(scrollPane1, BorderLayout.CENTER);
		panel3.add(panel4, BorderLayout.NORTH);
		
		panel5 = new JPanel(new BorderLayout());
		label3 = new JLabel("Sources");
		textArea2 = new JTextArea(7,40);
		textArea2.setEditable(false);
		JScrollPane scrollPane2 = new JScrollPane(textArea2);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel5.add(label3, BorderLayout.NORTH);
		panel5.add(scrollPane2);
		panel3.add(panel5, BorderLayout.CENTER);
		
		add(panel3, BorderLayout.CENTER);
		
		setSize(650,750);
		setVisible(true);
		
	}
	
	public static void main(String[] args)
	{	
		@SuppressWarnings("unused")
		Tweeter tweets = new Tweeter();
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == button1)
		{
			String src = text.getText();
			reader.addSource(src);
			List<RSSItem> items = reader.retrieveFeedItems();
			textArea1.setText("");
			for(int i = 0; i < items.size(); i++)
			{
				textArea1.append(items.get(i).getTitle() + "\n");
				textArea1.append("   " +String.format("%1$2tm/%<2td/%<tY %<tH:%<tM", items.get(i).getDate()) + "\n");
				textArea1.append("   " +items.get(i).getLink() + "\n");
				textArea1.append("\n");	
			}
			List<String> goodSource = reader.getSources();
			textArea2.setText("");
			for(int j = 0; j < goodSource.size(); j++)
			{
				textArea2.append(goodSource.get(j) + "\n");
			}
		}
		if(event.getSource() == button2)
		{
			List<RSSItem> items = reader.retrieveFeedItems();
			textArea1.setText("");
			for(int i = 0; i < items.size(); i++)
			{
				textArea1.append(items.get(i).getTitle() + "\n");
				textArea1.append("   " +String.format("%1$2tm/%<2td/%<tY %<tH:%<tM", items.get(i).getDate()) + "\n");
				textArea1.append("   " +items.get(i).getLink() + "\n");
				textArea1.append("\n");	
			}
			List<String> goodSource = reader.getSources();
			textArea2.setText("");
			for(int j = 0; j < goodSource.size(); j++)
			{
				textArea2.append(goodSource.get(j) + "\n");
			}
		}
		if(event.getSource() == button3)
		{
			List<String> badSource = reader.getBadSources();
			textArea2.setText("");
			for(int i = 0; i < badSource.size(); i++)
			{
				textArea2.append(badSource.get(i) + "\n");
			}
		}
		if(event.getSource() == button4)
		{
			List<String> goodSource = reader.getSources();
			textArea2.setText("");
			reader.removeBadSources();
			for(int j = 0; j < goodSource.size(); j++)
			{
				textArea2.append(goodSource.get(j) + "\n");
			}
		}
		
		
	}

	
}
		/*FeedReader read1 = new Reader();
		read1.addSource("http://search.twitter.com/search.rss?q=from:Battlefield");
		read1.addSource("http://twitter.com");
		read1.addSource("http://search.twitter.com/search.rss?q=from:BioWare");
		List<RSSItem> items = read1.retrieveFeedItems();
		for(int i = 0; i < items.size(); i++)
		{
			System.out.println();
			System.out.println(String.format("%1$2tm/%<2td/%<tY %<tH:%<tM", items.get(i).getDate()));
			System.out.println(items.get(i).getTitle());
			System.out.println(items.get(i).getLink());
			
		}
		List<String> goodSource = read1.getSources();
		List<String> badSource = read1.getBadSources();
		System.out.println("-----------------");
		for(int j = 0; j < goodSource.size(); j++)
		{
			System.out.println(goodSource.get(j));
		}
		System.out.println("-----------------");
		for(int i = 0; i < badSource.size(); i++)
		{
			System.out.println(badSource.get(i));
		}
		read1.removeBadSources();
		System.out.println("-----------------");
		for(int j = 0; j < goodSource.size(); j++)
		{
			System.out.println(goodSource.get(j));
		}
		System.out.println("-----------------");
		for(int i = 0; i < badSource.size(); i++)
		{
			System.out.println(badSource.get(i));
		}
		*/
		
	


