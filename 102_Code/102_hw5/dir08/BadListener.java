import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BadListener
   implements ActionListener
{
   private FeedReader r;
   private JTextArea s;
   private List<String> list;
   
   public BadListener(FeedReader r, JTextArea s)
   {
      this.r = r;
      this.s = s;
   }
   
   public void actionPerformed(ActionEvent e)
   {
      s.setText("");
      
      list = r.getBadSources();
      
      for (String k : list)
      {
         s.append(k + "\n");
      }
   }
}