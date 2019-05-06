import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class GUI
extends javax.swing.JFrame
{
	private FeedReader reader = new Reader();
	public GUI()
	{
		final JTextArea datalist = new JTextArea(30,40);
		datalist.setEditable(false);
		final JTextField source = new JTextField(20);
		final JTextArea sourcelist = new JTextArea(7,40);
		sourcelist.setEditable(false);
		JFrame frame = new JFrame();
		frame.setSize(650,750);
		frame.setResizable(false); 
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		Container pane=frame.getContentPane();
		pane.setLayout(new java.awt.BorderLayout());
		
		JPanel npanel=new JPanel();
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				reader.addSource(source.getText());
				List<String> sourceList = new ArrayList<String>();
				sourceList = reader.getSources();
				String sources = "";
				for(int j=0;j<sourceList.size();j++)
				{
					sources = (sources + sourceList.get(j)+"\n");
				}
				sourcelist.setText(sources);
				
				source.setText("");
				
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
				List<RSSinfo> feedList = new ArrayList<RSSinfo>();
				feedList = reader.retrieveFeedItems();
				String items = "";
				for(int i=0;i<feedList.size();i++)
				{
					items = (items + feedList.get(i).getTitle()+"\n   " + df.format(feedList.get(i).getDate().getTime())+"\n   " + feedList.get(i).getLink()+"\n\n");
				}
				datalist.setText(items);
			}
		});
		npanel.add(new JLabel("Source:"), FlowLayout.LEFT);
		npanel.add(source);
		npanel.add(add);
		pane.add(npanel, BorderLayout.NORTH);

		
		JPanel epanel=new JPanel();
		epanel.setLayout(new javax.swing.BoxLayout(epanel,BoxLayout.Y_AXIS));
		JButton refresh = new JButton("Refresh");
		refresh.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
				List<RSSinfo> feedList = new ArrayList<RSSinfo>();
				feedList = reader.retrieveFeedItems();
				String items = "";
				for(int i=0;i<feedList.size();i++)
				{
					items = (items + feedList.get(i).getTitle()+"\n   " + df.format(feedList.get(i).getDate().getTime())+"\n   " + feedList.get(i).getLink()+"\n\n");
				}
				datalist.setText(items);
			}
		});
		JButton bad = new JButton("Bad Sources");
		bad.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				List<String> badList = new ArrayList<String>();
				badList = reader.getBadSources();
				String bads = "";
				sourcelist.setText("");
				for(int j=0;j<badList.size();j++)
				{
					bads = (bads + badList.get(j)+"\n");
				}
				sourcelist.setText(bads);
			}
		});
		JButton clean = new JButton("Clean Sources");
		clean.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				reader.removeBadSources();
				List<String> cleanedList = new ArrayList<String>();
				cleanedList = reader.getSources();
				String cleaned = "";
				sourcelist.setText("");
				for(int j=0;j<cleanedList.size();j++)
				{
					cleaned = (cleaned + cleanedList.get(j)+"\n");
				}
				sourcelist.setText(cleaned);
			}
		});
		epanel.add(refresh);
		epanel.add(bad);
		epanel.add(clean);
		pane.add(epanel, BorderLayout.EAST);
		
		
		JPanel cpanel=new JPanel();
				
		JPanel itempanel = new JPanel();
		JPanel sourcepanel = new JPanel();
		
		itempanel.setLayout(new java.awt.BorderLayout());
		itempanel.add(new JLabel("RSS Items"), BorderLayout.NORTH);
		JScrollPane rssdata = new JScrollPane(datalist);
		
		itempanel.add(rssdata, BorderLayout.CENTER);
		
		sourcepanel.setLayout(new java.awt.BorderLayout());
		sourcepanel.add(new JLabel("Sources"), BorderLayout.NORTH);
		JScrollPane sourcedata = new JScrollPane(sourcelist);
		sourcepanel.add(sourcedata, BorderLayout.CENTER);
		
		cpanel.add(itempanel);
		cpanel.add(sourcepanel);
		
		pane.add(cpanel, BorderLayout.CENTER);
		
		
		frame.setVisible(true);
	}
}
