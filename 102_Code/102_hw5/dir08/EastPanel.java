import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EastPanel
   extends JPanel
{
   private JTextArea itemText, sourceText;
   private JButton refreshButton, badButton, cleanButton;
   private FeedReader reader;
   
   public EastPanel(FeedReader r, JTextArea i, JTextArea s)
   {
      reader = r;
      itemText = i;
      sourceText = s;
      
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      refreshButton = new JButton("Refresh");
      refreshButton.addActionListener(new RefreshListener(reader, itemText, sourceText));
      
      badButton = new JButton("Bad Sources");
      badButton.addActionListener(new BadListener(reader, sourceText));
      
      cleanButton = new JButton("Clean Sources");
      cleanButton.addActionListener(new CleanListener(reader, sourceText));
      
      add(refreshButton);
      add(badButton);
      add(cleanButton);
   }
}