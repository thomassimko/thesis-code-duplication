import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.text.*;
import java.util.*;
import javax.xml.xpath.XPathExpressionException;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.*;

public class GUI
   extends JFrame
{
   private JFrame frame;

   public void start()
   {
      frame.setVisible(true);      
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public GUI()
   {
      this.frame = new JFrame();

      frame.setSize(650, 750);

      FeedReader feed = new FeedReaderData(); 

      /* Search bar */
      JLabel label = new JLabel("Source:");
      JTextField text = new JTextField(20);
      JButton add = new JButton("Add");

      JPanel frameSearch = new JPanel();
      frameSearch.setLayout(new FlowLayout());

      frameSearch.add(label);
      frameSearch.add(text);
      frameSearch.add(add);

      /* Buttons */
      JButton refresh = new JButton("Refresh");
      JButton badSources = new JButton("Bad Sources");
      JButton cleanSources = new JButton("Clean Sources");

      JPanel frameButtons = new JPanel();
      frameButtons.setLayout(new BoxLayout(frameButtons, BoxLayout.Y_AXIS));

      frameButtons.add(refresh);
      frameButtons.add(badSources);
      frameButtons.add(cleanSources);

      /* Text Areas */
      JTextArea textArea = new JTextArea(30, 40);
      JTextArea textAreaSmall = new JTextArea(7, 40);

      textArea.setEditable(false);
      textAreaSmall.setEditable(false);

      JPanel centerPanel = new JPanel();
      centerPanel.setLayout(new FlowLayout());

      JLabel RSSItems = new JLabel("RSS Items");
      JLabel sources = new JLabel("Sources");

      JScrollPane pane = new JScrollPane(textArea);
      JScrollPane smallPane = new JScrollPane(textAreaSmall);

      JPanel sourcePanel = new JPanel();
      sourcePanel.setLayout(new BorderLayout());
      sourcePanel.add(smallPane, BorderLayout.CENTER);
      sourcePanel.add(sources, BorderLayout.NORTH);

      JPanel itemPanel = new JPanel();
      itemPanel.setLayout(new BorderLayout());
      itemPanel.add(pane, BorderLayout.CENTER);
      itemPanel.add(RSSItems, BorderLayout.NORTH);

      centerPanel.add(itemPanel);
      centerPanel.add(sourcePanel);

      frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
      frame.getContentPane().add(frameSearch, BorderLayout.NORTH);
      frame.getContentPane().add(frameButtons, BorderLayout.EAST);

      add.addActionListener(new AddButtonListener(feed, text, textArea, textAreaSmall));
      refresh.addActionListener(new RefreshButtonListener(feed, textArea, textAreaSmall));      
      badSources.addActionListener(new BadSourcesButtonListener(feed, textAreaSmall));      
      cleanSources.addActionListener(new CleanSourcesButtonListener(feed, textArea, textAreaSmall));  
   }
   
   public class AddButtonListener
      extends PrintSources implements ActionListener 
   {
      private FeedReader feed;
      private JTextField text;
      private JTextArea textArea;
      private JTextArea textAreaSmall;

      public AddButtonListener(FeedReader feed, JTextField text, JTextArea textArea, JTextArea textAreaSmall)
      {
         this.feed = feed;
         this.text = text;
         this.textArea = textArea;
         this.textAreaSmall = textAreaSmall;
      }

      public void actionPerformed(ActionEvent e)
      {
         feed.addSource(text.getText());

         List<RSSItem> list = feed.retrieveFeedItems();
         feed.sortSource();

         print(feed, list, textArea, textAreaSmall);

         list.clear();      
      }
   }

   public class RefreshButtonListener
      extends PrintSources implements ActionListener 
   {
      private FeedReader feed;
      private JTextArea textArea;
      private JTextArea textAreaSmall;

      public RefreshButtonListener(FeedReader feed, JTextArea textArea, JTextArea textAreaSmall)
      {
         this.feed = feed;
         this.textArea = textArea;
         this.textAreaSmall = textAreaSmall;
      }
      public void actionPerformed(ActionEvent e)
      {
         List<RSSItem> list = feed.retrieveFeedItems();

         textArea.setText("");

         print(feed, list, textArea, textAreaSmall);

         list.clear();         
      }
   }

   public class BadSourcesButtonListener
      extends PrintSources implements ActionListener 
   {
      private FeedReader feed;
      private JTextArea textAreaSmall;

      public BadSourcesButtonListener(FeedReader feed, JTextArea textAreaSmall)
      {
         this.feed = feed;
         this.textAreaSmall = textAreaSmall;
      }

      public void actionPerformed(ActionEvent e)
      {
         List<String> list = feed.getBadSources();
         
         textAreaSmall.setText("");

         for (int j = 0; j < list.size(); j++)
         {
            textAreaSmall.append(list.get(j) + "\n");                              
         }
      }
   }

   public class CleanSourcesButtonListener
      extends PrintSources implements ActionListener 
   {
      private FeedReader feed;
      private JTextArea textArea;
      private JTextArea textAreaSmall;

      public CleanSourcesButtonListener(FeedReader feed, JTextArea textArea, JTextArea textAreaSmall)
      {
         this.feed = feed;
         this.textArea = textArea;
         this.textAreaSmall = textAreaSmall;
      }

      public void actionPerformed(ActionEvent e)
      {
         feed.removeBadSources();

         textArea.setText("");
         List<RSSItem> list = feed.retrieveFeedItems();

         print(feed, list, textArea, textAreaSmall);

         list.clear();
      }
   }

   public class PrintSources
   {
      public void print(FeedReader feed, List<RSSItem> list, JTextArea textArea, JTextArea textAreaSmall)
      {
         feed.sortDate();
         textArea.setText("");   

         for (int i = 0; i < list.size(); i++)
         {
            try
            {
               textArea.append(list.get(i).getTitle() + "\n");
               textArea.append("   " + list.get(i).calendarToString() + "\n");
               textArea.append("   " + list.get(i).getLink() + "\n\n");
            }
            catch (ParseException l)
            {
               System.err.println("Parse Exception!");
            }
         }

         List<String> newList = feed.getSources();

         textAreaSmall.setText("");

         for (int j = 0; j < newList.size(); j++)
         {
            textAreaSmall.append(newList.get(j) + "\n");                            
         }
      }
   }
}
