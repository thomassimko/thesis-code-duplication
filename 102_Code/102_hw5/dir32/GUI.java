import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.text.*;
import java.io.*;
import java.util.*;
public class GUI
   extends JFrame
{
   private JButton addbutton = new JButton("Add");
   private JButton refreshbutton = new JButton("Refresh");
   private JButton badsourcesbutton = new JButton("Bad Sources");
   private JButton cleansourcesbutton = new JButton("Clean Sources");
   private JPanel panelMain = (JPanel) getContentPane();
   private JPanel panelNorth = new JPanel();
   private JPanel panelCenter = new JPanel(new BorderLayout());
   private JPanel panelEast = new JPanel();
   private JLabel northlabel = new JLabel("Source:");
   private JLabel centerlabel1 = new JLabel("RSS Items");
   private JLabel centerlabel2 = new JLabel("Sources");
   private JTextField northField = new JTextField(20);
   private JTextArea textarea = new JTextArea(30, 40);   
   private JTextArea textarea2 = new JTextArea(7, 40);
   private JScrollPane scrollpane = new JScrollPane(textarea);
   private JScrollPane scrollpane2 = new JScrollPane(textarea2);
   public Feeder feeder = new Feeder();
   public GUI()
   {  
      this.setSize(650, 750);
      this.setResizable(false);
      this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
      textarea.setEditable(false);
      textarea2.setEditable(false);
      panelMain.setLayout(new BorderLayout());
      panelCenter.setLayout(new BorderLayout());
      panelNorth.setLayout(new FlowLayout());
      panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.Y_AXIS));
      panelMain.add(panelNorth, BorderLayout.NORTH);
      panelMain.add(panelCenter, BorderLayout.CENTER);
      panelMain.add(panelEast, BorderLayout.EAST);	  

      addbutton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
            textarea2.setText("");
            northField.setText("");
            textarea.setText("");
            String src = northField.getText();
            feeder.addSource(src);
            List<RSSItem> itemlist = feeder.retrieveFeedItems();
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            Collections.sort(itemlist, new ItemCompare());
            for(RSSItem rssitem : itemlist)
            {
               String title = rssitem.getTitle();
               textarea.append(title + "\n");
               String date = df.format(rssitem.getDate());
               textarea.append("   " + date + "\n");
               String link = rssitem.getLink();
               textarea.append("   " + link + "\n\n");
            }
            List<String> sources = feeder.getSources();
            Collections.sort(sources);
            for(String line : sources)
            {
               textarea2.append(sources + "\n");
            }
         }});

      refreshbutton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e)
         {
            northField.setText("");
            List<RSSItem> itemlist = feeder.retrieveFeedItems();
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");

            for(RSSItem rssitem : itemlist)
            {
               String title = rssitem.getTitle();
               textarea.append(title + "\n");
               String date = df.format(rssitem.getDate());
               textarea.append("   " + date + "\n");
               String link = rssitem.getLink();
               textarea.append("   " + link + "\n\n");
            }           

         }});

      badsourcesbutton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e)
          {
             textarea2.setText("");
             List<String> badsources = feeder.getBadSources();
             for(String badsource : badsources)
             {
                textarea2.append(badsource + "\n");
             }
 
          }});

      cleansourcesbutton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e)
          {
             textarea2.setText("");
             feeder.removeBadSources();
             List<String> sources = feeder.getSources();
             Collections.sort(sources);
             for(String line : sources)
             {
                textarea2.append(sources + "\n");
             }

          }});
       panelNorth.add(northlabel);
       panelNorth.add(northField);
       panelNorth.add(addbutton);

       panelEast.add(refreshbutton);
       panelEast.add(badsourcesbutton);
       panelEast.add(cleansourcesbutton);

       JPanel pawnall = new JPanel(new BorderLayout());
       JPanel pawnall2 = new JPanel(new BorderLayout()); 
       pawnall.add(centerlabel1, BorderLayout.NORTH);
       pawnall.add(scrollpane, BorderLayout.CENTER);
       pawnall2.add(centerlabel2, BorderLayout.NORTH);
       pawnall2.add(scrollpane2, BorderLayout.CENTER);
     
       panelCenter.add(pawnall, BorderLayout.NORTH);
       panelCenter.add(pawnall2, BorderLayout.SOUTH);
       this.setVisible(true);
   }
   
}
