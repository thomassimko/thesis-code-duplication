import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CleanListener
   implements ActionListener
{
   private FeedReader r;
   private JTextArea s;
   private List<String> list;
   
   public CleanListener(FeedReader r, JTextArea s)
   {
      this.r = r;
      this.s = s;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      s.setText("");
      
      r.removeBadSources();
      
      list = r.getSources();
      
      for (String k : list)
      {
         s.append(k + "\n");
      }
   }
}