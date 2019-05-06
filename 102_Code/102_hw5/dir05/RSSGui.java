import javax.swing.*;
import javax.swing.event.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RSSGui extends JFrame
{   
   private JPanel northPanel = new JPanel();
   private JLabel northLabel = new JLabel("Source:");
   private JTextField northTextField = new JTextField(20);
   private JButton northButton = new JButton("Add");
   
   private JPanel eastPanel = new JPanel();
   private JButton refresh = new JButton("Refresh");
   private JButton badSources = new JButton("Bad Sources");
   private JButton cleanSources = new JButton("Clean Sources");
   
   private JPanel centerPanel = new JPanel();
   
   private JPanel item = new JPanel();
   private JLabel itemLabel = new JLabel("RSS Items");
   private JTextArea itemScrollText = new JTextArea(30, 40);
   private JScrollPane itemScroll = new JScrollPane(itemScrollText);
   
   private JPanel source = new JPanel();
   private JLabel sourceLabel = new JLabel("Sources");
   private JTextArea sourceScrollText = new JTextArea(7, 40);
   private JScrollPane sourceScroll = new JScrollPane(sourceScrollText);
   
   private FeedReader twit = new TwitterFeed();
   
   public RSSGui()
   {
      super.setSize(650, 750);
      
      northPanel.setLayout(new FlowLayout());
      northPanel.add(northLabel);
      northPanel.add(northTextField);
      northButton.addActionListener(new ButtonListener(twit));
      northPanel.add(northButton);
      
      eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
      refresh.addActionListener(new ButtonListener(twit));
      eastPanel.add(refresh);
      eastPanel.add(badSources);
      badSources.addActionListener(new ButtonListener(twit));
      eastPanel.add(cleanSources);
      cleanSources.addActionListener(new ButtonListener(twit));
      
      centerPanel.setLayout(new FlowLayout());
      
      item.setLayout(new BorderLayout());
      item.add(itemLabel, BorderLayout.NORTH);
      item.add(itemScroll, BorderLayout.CENTER);
      
      source.setLayout(new BorderLayout());
      source.add(sourceLabel, BorderLayout.NORTH);
      source.add(sourceScroll, BorderLayout.CENTER);
      
      centerPanel.add(item);
      centerPanel.add(source);
      
      super.getContentPane().add(northPanel, BorderLayout.NORTH);
      super.getContentPane().add(eastPanel, BorderLayout.EAST);
      super.getContentPane().add(centerPanel, BorderLayout.CENTER);
   }
   public void launchFrame()
   {
      super.setVisible(true);
      super.setResizable(false);
      super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public class ButtonListener implements ActionListener
   {
      private FeedReader twit;
      
      public ButtonListener(FeedReader twit)
      {
         this.twit = twit;
      }
      public void actionPerformed(ActionEvent e)
      {
         List<RSSItem> feed;
         List<RSSItem> list;
         List<String> sources;
         List<String> clearedSources;
         List<RSSItem> sorted;
         List<String> badSources;

         if(e.getActionCommand().equals("Add"))
         {
            twit.addSource(northTextField.getText());
            sources = twit.getSources();
            Collections.sort(sources);
            sourceScrollText.setText("");
            int sourceSize = sources.size();
            for(int k = 0; k < sourceSize; k++)
            {
               sourceScrollText.append(sources.get(k) + "\n");
            }
            northTextField.setText("");
            feed = twit.retrieveFeedItems();
            itemScrollText.setText("");
            int feedSize = feed.size();
            sorted = sort(feed, new DateComparator());
            for(int i = 0; i < feedSize; i++)
            {
               itemScrollText.append(sorted.get(i).getTitle() + "\n");
               itemScrollText.append("   " + sorted.get(i).calToString() + "\n");
               itemScrollText.append("   " + sorted.get(i).getLink() + "\n");
               itemScrollText.append("\n");
            }
         }
         else if(e.getActionCommand().equals("Refresh"))
         {
            list = twit.retrieveFeedItems();
            itemScrollText.setText("");
            sorted = sort(list, new DateComparator());
            int size = sorted.size();
            for(int i = 0; i < size; i++)
            {
               itemScrollText.append(sorted.get(i).getTitle() + "\n");
               itemScrollText.append("   " + sorted.get(i).calToString() + "\n");
               itemScrollText.append("   " + sorted.get(i).getLink() + "\n" + "\n");
            }
         }
         else if(e.getActionCommand().equals("Bad Sources"))
         {
            badSources = twit.getBadSources();
            int badSize = badSources.size();
            Collections.sort(badSources);
            sourceScrollText.setText("");
            for(int i = 0; i < badSize; i++)
            {
               sourceScrollText.append(badSources.get(i) + "\n");
            }
         }
         else if(e.getActionCommand().equals("Clean Sources"))
         {
            twit.retrieveFeedItems();
            twit.removeBadSources();
            clearedSources = twit.getSources();
            sourceScrollText.setText("");
            int clearedSize = clearedSources.size();
            for(int i = 0; i < clearedSize; i++)
            {
               sourceScrollText.append(clearedSources.get(i) + "\n");
            }
         }
      }
      private List<RSSItem> sort(List<RSSItem> l, Comparator<RSSItem> c)
      {
         int size = l.size();
         List<RSSItem> newlist = new ArrayList<RSSItem>();
         for(int i = 0; i < size; i++)
         {
            int index = sortHelper(l, c, 0);
            newlist.add(0, l.remove(index));
         }
         return newlist;
      }
      private int sortHelper(List<RSSItem> l, Comparator<RSSItem> c, int start)
      {
         RSSItem elementIndex = l.get(start);
         int index = start;
         int size = l.size();
         for(int i = start + 1; i< size; i++)
         {
            RSSItem elementI = l.get(i);
            if(c.compare(elementI, elementIndex) < 0)
            {
               elementIndex = elementI;
               index = i;
            }
         }
         return index;
      }
   }
}