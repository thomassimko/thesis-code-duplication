import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class GUI
   extends JFrame
{
   private static final long serialVersionUID = 1L;
   private static final int WIDTH = 650;
   private static final int HEIGHT = 750;
   private static final int SOURCE_ADD_LENGTH = 20;
   private static final int ITEMS_WIDTH = 30;
   private static final int SOURCES_WIDTH = 7;
   private static final int ITEMS_SOURCES_HEIGHT = 40;
   private FeedReader sources = new Sources();
   
   public GUI()
   {
      JFrame frame = createFrame();
      Container pane = frame.getContentPane();
      pane.setLayout(new BorderLayout());
      
      //Creates center's top JPanel
      JPanel top = new JPanel();
      top.setLayout(new BorderLayout());
      JLabel itemLabel = new JLabel("RSS Items");
      final JTextArea itemText = new JTextArea(ITEMS_WIDTH, ITEMS_SOURCES_HEIGHT);
      itemText.setEditable(false);
      JScrollPane itemBox = new JScrollPane(itemText);
      top.add(itemLabel, BorderLayout.NORTH);
      top.add(itemBox, BorderLayout.CENTER);
      
      //Creates center's bottom JPanel
      JPanel bottom = new JPanel();
      bottom.setLayout(new BorderLayout());
      JLabel sourceLabel = new JLabel("Sources");
      final JTextArea sourceText = new JTextArea(SOURCES_WIDTH, ITEMS_SOURCES_HEIGHT);
      sourceText.setEditable(false);
      JScrollPane sourceBox = new JScrollPane(sourceText);
      bottom.add(sourceLabel, BorderLayout.NORTH);
      bottom.add(sourceBox, BorderLayout.CENTER);
      
      //Creates center JPanel
      JPanel center = new JPanel();
      center.add(top);
      center.add(bottom);
      
      //Creates north JPanel and its ActionListeners
      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      JLabel sourceLabelText = new JLabel("Source: ");
      final JTextField sourceField = new JTextField(SOURCE_ADD_LENGTH);
      JButton addButton = new JButton("Add");
      addButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            sources.addSource(sourceField.getText());
            sourceField.setText("");
            String itemsString = "";
            String sourcesString = "";
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            for(String src : sources.getSources())
            {
               sourcesString = sourcesString + src + "\n";
            }
            sourceText.setText(sourcesString);
            for(RSSItem item : sources.retrieveFeedItems())
            {
               itemsString = itemsString + item.getTitle() + "\n" + "   " + df.format(item.getDate().getTime()) + "\n" + "   " + item.getLink() +"\n\n";
            }
            itemText.setText(itemsString);
         }
      });
      north.add(sourceLabelText);
      north.add(sourceField);
      north.add(addButton);
      
      //Creates east JPanel and its ActionListeners
      JPanel east = new JPanel();
      east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
      JButton refreshButton = new JButton("Refresh");
      refreshButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            String itemsString = "";
            String sourcesString = "";
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            for(String src : sources.getSources())
            {
               sourcesString = sourcesString + src + "\n";
            }
            for(RSSItem item : sources.retrieveFeedItems())
            {
               itemsString = itemsString + item.getTitle() + "\n" + "   " + df.format(item.getDate().getTime()) + "\n" + "   " + item.getLink() +"\n\n";
            }
            sourceText.setText(sourcesString);
            itemText.setText(itemsString);
         }
      });
      JButton badSourcesButton = new JButton("Bad Sources");
      badSourcesButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            String badSourcesString = "";
            for(String src : sources.getBadSources())
            {
               badSourcesString = badSourcesString + src + "\n";
            }
            sourceText.setText(badSourcesString);
         }
      });
      JButton cleanSourcesButton = new JButton("Clean Sources");
      cleanSourcesButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            sources.removeBadSources();
            String sourcesString = "";
            for(String src : sources.getSources())
            {
               sourcesString = sourcesString + src + "\n";
            }
            sourceText.setText(sourcesString);
         }
      });
      east.add(refreshButton);
      east.add(badSourcesButton);
      east.add(cleanSourcesButton);

      //Creates main JFrame
      pane.add(north, BorderLayout.NORTH);
      pane.add(east, BorderLayout.EAST);
      pane.add(center, BorderLayout.CENTER);
      frame.setVisible(true);
   }
   
   private JFrame createFrame()
   {
      JFrame frame = new JFrame("Tweeter");
      frame.setSize(WIDTH, HEIGHT);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      return frame;
   }
}