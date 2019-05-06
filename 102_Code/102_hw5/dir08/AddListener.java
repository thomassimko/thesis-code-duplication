import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class AddListener
   implements ActionListener
{
   private FeedReader r;
   private JTextField t;
   private JTextArea i, s;
   private List<RSSItem> list;
   private List<String> sources;
   
   public AddListener(FeedReader r, JTextField t, JTextArea i, JTextArea s)
   {
      this.r = r;
      this.t = t;
      this.i = i;
      this.s = s;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      r.addSource(t.getText());
      t.setText("");
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
