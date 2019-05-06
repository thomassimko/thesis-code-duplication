import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class RSSGUI
   extends JFrame
{
   private JTextField addSource;
   private FeedReader feed;
   private JTextArea sourceText;
   private JTextArea itemText;
   private final static String newline = "\n";

   public RSSGUI()
   {
   }

   public void initialize()
   {
      feed = new RSSFeed();

      JFrame frame = new JFrame("Frame");
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.setSize(650, 750);
      frame.setResizable(false);
      JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());
      frame.getContentPane().add(panel);

      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      JLabel north_label = new JLabel("Source: ");
      addSource = new JTextField();
      addSource.setColumns(20);
      JButton addButton = new JButton("Add");
      north.add(north_label);
      north.add(addSource);
      north.add(addButton);

      JPanel east = new JPanel();
      east.setLayout(new BoxLayout(east, BoxLayout.PAGE_AXIS));
      JButton refresh = new JButton("Refresh");
      JButton bad = new JButton("Bad Sources");
      JButton clean = new JButton("Clean Sources");
      east.add(refresh);
      east.add(bad);
      east.add(clean);


      JPanel center = new JPanel();
      center.setLayout(new FlowLayout());
      
      JPanel itemPanel = new JPanel();
      itemPanel.setLayout(new BorderLayout());
      center.add(itemPanel);
      
      JLabel rss = new JLabel("RSS Items");
      itemPanel.add(rss, BorderLayout.NORTH);
      
      this.itemText = new JTextArea();
      itemText.setRows(30);
      itemText.setColumns(40);
      itemText.setEditable(false);
      
      JScrollPane scrollItem = new JScrollPane(itemText);
      itemPanel.add(scrollItem, BorderLayout.CENTER);

      JPanel sourcePanel = new JPanel();
      sourcePanel.setLayout(new BorderLayout());
      center.add(sourcePanel);
      
      JLabel sources = new JLabel("Sources");
      sourcePanel.add(sources, BorderLayout.NORTH);
      
      this.sourceText = new JTextArea();
      sourceText.setRows(7);
      sourceText.setColumns(40);
      sourceText.setEditable(false);
      
      JScrollPane scrollSource = new JScrollPane(sourceText);
      sourcePanel.add(scrollSource, BorderLayout.CENTER);


      addButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            String s = addSource.getText();
            feed.addSource(s);
            itemText.setText("");
            sourceText.setText("");
            List<RSSItem> items = feed.retrieveFeedItems();
            int length = items.size();
            List<String> sources = feed.getSources();
            for(int j = 0; j < items.size(); j++)
            {
               String title = items.get(j).getTitle();
               String date = null;
               String link = items.get(j).getLink();
               Calendar toDate = items.get(j).getDate();
               SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
               Date parseDate = toDate.getTime();
               date = df.format(parseDate);
               itemText.append(title + "\n");
               itemText.append("   " + date + "\n");
               itemText.append("   " + link + "\n" + "\n");
            }
            for(int i = 0; i < sources.size(); i++)
            {
               sourceText.append(sources.get(i) + "\n");
            }
         }
      });
      
      refresh.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            itemText.setText("");
            sourceText.setText("");
            List<RSSItem> items = feed.retrieveFeedItems();
            List<String> sources = feed.getSources();
            for(int j = 0; j < items.size(); j++)
            {
               String title = items.get(j).getTitle();
               String date = null;
               String link = items.get(j).getLink();
               Calendar toDate = items.get(j).getDate();
               SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
               Date parseDate = toDate.getTime();
               date = df.format(parseDate);
               itemText.append(title + "\n");
               itemText.append("   " + date + "\n");
               itemText.append("   " + link + "\n" + "\n");
            }
            for(int i = 0; i < sources.size(); i++)
            {
               sourceText.append(sources.get(i) + "\n");
            }
         }
      });
      
      bad.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            sourceText.setText("");
            List<String> badSources = feed.getBadSources();
            for(int i = 0; i < badSources.size(); i++)
            {
               String toAppend = badSources.get(i);
               sourceText.append(toAppend + "\n");
            }
         }
      });
      
      clean.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            feed.removeBadSources();
            sourceText.setText("");
            List<String> goodSources = feed.getSources();
            for(int i = 0; i < goodSources.size(); i++)
            {
               String toAppend = goodSources.get(i);
               sourceText.append(toAppend + "\n");
            }
         }
      });
      
      north.setVisible(true);
      panel.add(north, BorderLayout.NORTH);
      east.setVisible(true);
      panel.add(east, BorderLayout.EAST);
      center.setVisible(true);
      panel.add(center, BorderLayout.CENTER);
      frame.setVisible(true);
   }
}
