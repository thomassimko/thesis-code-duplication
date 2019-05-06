import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RefreshListener
   implements ActionListener
{
   private FeedReader r;
   private JTextArea i, s;
   private List<RSSItem> list;
   private List<String> sources;
   
   public RefreshListener(FeedReader r, JTextArea i, JTextArea s)
   {
      this.r = r;
      this.i = i;
      this.s = s;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      i.setText("");
      s.setText("");
      
      list = r.retrieveFeedItems();
      sources = r.getSources();
      
      for (RSSItem m : list)
      {
         i.insert(m.toString(), 0); 
      }
      
      for (String k : sources)
      {
         s.append(k + "\n");
      }
   }
}
