import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FeedGUI
   extends JFrame
{
   private FeedReader feed = new Feed();
   private JPanel NPanel = new JPanel();
   private JPanel EPanel = new JPanel();
   private JPanel CPanel = new JPanel();
   private JTextField addText = new JTextField(20);
   private JPanel itemPanel = new JPanel();
   private JTextArea RSSArea = new JTextArea(30, 40);
   private JPanel sourcePanel = new JPanel();
   private JTextArea sourceArea = new JTextArea(7, 40);
	
   public FeedGUI()
   {
      super();
      setSize(650, 750);
      setResizable(false);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
      NPanel.add(new JLabel("Source:"));
      NPanel.add(addText);
      JButton add = new JButton("Add");   
      NPanel.add(add);
		
      EPanel.setLayout(new BoxLayout(EPanel, BoxLayout.Y_AXIS));
      JButton refresh = new JButton("Refresh");
      JButton badSources = new JButton("Bad Sources");
      JButton cleanSources = new JButton("Clean Sources");
      EPanel.add(refresh);
      EPanel.add(badSources);
      EPanel.add(cleanSources);
		
      itemPanel.setLayout(new BorderLayout());
      RSSArea.setEditable(false);
      itemPanel.add(new JLabel("RSS Items"), BorderLayout.NORTH);
      itemPanel.add(new JScrollPane(RSSArea), BorderLayout.CENTER);
      sourcePanel.setLayout(new BorderLayout());
      sourceArea.setEditable(false);
      sourcePanel.add(new JLabel("Sources"), BorderLayout.NORTH);
      sourcePanel.add(new JScrollPane(sourceArea), BorderLayout.CENTER);
      CPanel.add(itemPanel);
      CPanel.add(sourcePanel);
		
      add.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
	      {
            String source = addText.getText();
	         feed.addSource(source);
	         displaySources();
	         displayFeedItems();
	      }
      });
		
      refresh.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
	      {
	         displaySources();
	         displayFeedItems();
	      }
      });
		
      badSources.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
	         sourceArea.setText("");
	         Collections.sort(feed.getBadSources());
	         int size = feed.getBadSources().size();
	         for(int i=0;i<size;i++)
	         {
	            sourceArea.append(feed.getBadSources().get(i) + "\n");
	         }
	      }
      });
		
      cleanSources.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
	         feed.removeBadSources();
	         sourceArea.setText("");
	         Collections.sort(feed.getSources());
	         int size = feed.getSources().size();
	         for(int i=0;i<size;i++)
	         {
               sourceArea.append(feed.getSources().get(i) + "\n");
	         }
         }
      });
		
      this.getContentPane().setLayout(new BorderLayout());
      this.getContentPane().add(NPanel, BorderLayout.NORTH);
      this.getContentPane().add(EPanel, BorderLayout.EAST);
      this.getContentPane().add(CPanel, BorderLayout.CENTER);
   }
	
   private void displaySources()
   {
      sourceArea.setText("");
      java.util.List<String> sources = feed.getSources();
      Collections.sort(sources);
      int size = sources.size();
      for(int i=0;i<size;i++)
      {
         sourceArea.append(sources.get(i) + "\n");
      }
   }
	
   private void displayFeedItems()
   {
      int test = feed.getBadSources().size();
      java.util.List<RSSItem> feedItems = feed.retrieveFeedItems();
		Collections.sort(feedItems, new RSSDateComparator());
      int size = feedItems.size();
		if(test == feed.getBadSources().size())
      {
		   RSSArea.setText("");
         for(int i=0;i<size;i++)
         {
	         RSSArea.append(feedItems.get(i).getTitle() + "\n");
	         RSSArea.append("   " + feedItems.get(i).dateToString() + "\n");
            RSSArea.append("   " + feedItems.get(i).getLink() + "\n\n");
			}
      }
   }
}
