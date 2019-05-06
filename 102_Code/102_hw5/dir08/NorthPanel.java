import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NorthPanel
   extends JPanel
{
   private JTextField textField;
   private JButton button;
   private FeedReader reader;
   private JTextArea itemText, sourceText;
   
   public NorthPanel(FeedReader r, JTextArea i, JTextArea s)
   {
      reader = r;
      itemText = i;
      sourceText = s;
      
      textField = new JTextField(20);
      textField.setEditable(true);
      
      button = new JButton("Add");
      button.addActionListener(new AddListener(reader, textField, itemText, sourceText));
      
      add(new JLabel("Source: "));
      add(textField);
      add(button);
   }
}