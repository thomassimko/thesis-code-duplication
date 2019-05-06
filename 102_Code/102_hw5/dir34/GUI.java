import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;


public class GUI
{
	private static final int WIDTH = 650;
    private static final int HEIGHT = 750;
    private static final String TITLE = "RSS Items";
	private static final int X = 20;
	private static final int X2 = 7;
	private static final int Y = 40;
	private final static String newLine = "\n";
	private JTextField text;
	private JTextArea textArea;
	private JTextArea textArea2;
	private String src;
    private FeedReader f;
    
    public GUI()
    {
    	f = new FeedReaderClass();
       JFrame frame = createFrame();
       JPanel mainPanel = new JPanel();
       mainPanel.setLayout(new BorderLayout());
       
       //NORTH
       JPanel top = new JPanel();
       top.setLayout(new FlowLayout());
       JLabel source = new JLabel("Source: ");
       text = new JTextField(20);
       
       mainPanel.add(top, BorderLayout.NORTH);
       
       top.add(source);
       top.add(text);
       
       JButton add = new JButton("Add");
       add.setPreferredSize(new Dimension(75, 25));
       
       top.add(add);
       
       //EAST
       JPanel right = new JPanel();
       right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
       mainPanel.add(right, BorderLayout.EAST);
       
       JButton refresh = new JButton("Refresh");
       JButton badSources = new JButton("Bad Sources");
       JButton cleanSources = new JButton("Clean Sources");
       
       right.add(Box.createRigidArea(new Dimension(0, 40)));
       right.add(refresh);
       right.add(Box.createRigidArea(new Dimension (0, 20)));
       right.add(badSources);
       right.add(Box.createRigidArea(new Dimension(0,20)));
       right.add(cleanSources);
          
       //CENTER
       JPanel center = new JPanel(); 
       center.setLayout(new FlowLayout());
       mainPanel.add(center, BorderLayout.CENTER);
       
       JPanel itemPanel = new JPanel();
       itemPanel.setLayout(new BorderLayout());
       center.add(itemPanel);
         
       JLabel RSSItem = new JLabel("RSS Item ");
       itemPanel.add(RSSItem, BorderLayout.NORTH);
       textArea = new JTextArea(X, Y);
       textArea.setEditable(false);
       JScrollPane scrollPane = new JScrollPane(textArea);
       itemPanel.add(scrollPane, BorderLayout.CENTER);

       JPanel sourcePanel = new JPanel();
       sourcePanel.setLayout(new BorderLayout());
       center.add(sourcePanel);
       
       JLabel sources = new JLabel("Sources ");

       sourcePanel.add(sources, BorderLayout.CENTER);
       textArea2 = new JTextArea(X2, Y);
       JScrollPane scrollPane2 = new JScrollPane(textArea2);
       textArea2.setEditable(false);
       sourcePanel.add(scrollPane2, BorderLayout.SOUTH);
       
       
       //ACTIONLISTENERS
   
       add.addActionListener(AddListener);
       
       refresh.addActionListener(RefreshListener);
       badSources.addActionListener(BadSourcesListener);      
       cleanSources.addActionListener(CleanSourcesListener);

       
       frame.add(mainPanel);
       frame.setVisible(true);
       source.setOpaque(true);
       RSSItem.setOpaque(true);
       scrollPane.setVisible(true);
       sources.setOpaque(true);
       scrollPane2.setVisible(true);
       
    }
    
	private JFrame createFrame()
	{
		JFrame frame = new JFrame();
	    frame.setSize(WIDTH, HEIGHT);
	    frame.setTitle(TITLE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    return frame;
	}
	
	
	ActionListener RefreshListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			f.retrieveFeedItems();
			List<String> l = f.getGoodList();
			
			Sort<String> s = new Sort<String>();
			l = s.sort(l, new StringComparator());

			showSourceList(l, textArea2);
			
			List<RSSItem> l2 = f.retrieveFeedItems();
			
			Sort<RSSItem> s2 = new Sort<RSSItem>();
			l2 = s2.sort(l2, new DateComparator());

			showRSSList(l2, textArea);
		}
	};
	ActionListener BadSourcesListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			f.retrieveFeedItems();
			List <String> badList= f.getBadSources();
			textArea.setText("");
			
			showSourceList(badList, textArea2);
		}
	};
	
	ActionListener CleanSourcesListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			f.retrieveFeedItems();
			f.removeBadSources();
			List<String> l = f.getGoodList();
			
			Sort<String> s = new Sort<String>();
			l = s.sort(l, new StringComparator());
			
			showSourceList(l, textArea2);
		}
	};
	
	ActionListener AddListener = new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			src = text.getText();
			text.setText("");
			f.addSource(src);
			List<RSSItem> l2 = f.retrieveFeedItems();
			List<String> l = f.getGoodList();
			
			Sort<String> s = new Sort<String>();
			l = s.sort(l, new StringComparator());
			
			showSourceList(l, textArea2);
			
			Sort<RSSItem> s2 = new Sort<RSSItem>();
			l2 = s2.sort(l2, new DateComparator());
			
			showRSSList(l2, textArea);
		}
	};
	
	
	public void showSourceList(List<String> l , JTextComponent o)
	{
		int size = l.size();
		String temp = "";
		for(int i =0; i < size; i++)
		{
			temp= temp + l.get(i) + newLine ;
		}
		o.setText(temp);
		
	}
	public void showRSSList(List<RSSItem> l2, JTextComponent o)
	{
		String temp2 = "";
		int size2 = l2.size();
		for( int i =0; i < size2; i++)
		{
			temp2 = temp2 + l2.get(i).print() + newLine + newLine;
		}
		o.setText(temp2 + newLine);
	}
}
