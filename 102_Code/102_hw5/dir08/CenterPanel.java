import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CenterPanel
   extends JPanel
{
   private JPanel itemPanel, sourcePanel;
   private JTextArea itemText, sourceText;
   private JScrollPane itemScroll, sourceScroll;
   
   public CenterPanel()
   {
      itemPanel = new JPanel(new BorderLayout());
      
      itemPanel.add(new JLabel("RSS Items"), BorderLayout.NORTH);

      itemText = new JTextArea(30, 40);
      itemScroll = new JScrollPane(itemText);
      itemText.setEditable(false);
      itemPanel.add(itemScroll, BorderLayout.CENTER);

      sourcePanel = new JPanel(new BorderLayout());
      
      sourcePanel.add(new JLabel("Sources"), BorderLayout.NORTH);
      
      sourceText = new JTextArea(7, 40);
      sourceScroll = new JScrollPane(sourceText);
      sourceText.setEditable(false);
      sourcePanel.add(sourceScroll, BorderLayout.CENTER);
      
      add(itemPanel);
      add(sourcePanel);
   }
   
   public JTextArea getItemTextArea()
   {
      return itemText;
   }
   
   public JTextArea getSourceTextArea()
   {
      return sourceText;
   }
}