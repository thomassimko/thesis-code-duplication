import java.awt.*;
import javax.swing.*;

public class Tweeter
{
   private static void makeGUI()
   {
      FeedReader reader = new TweetReader();
      
      JFrame frame = new JFrame("Tweeter");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CenterPanel c = new CenterPanel();
      frame.getContentPane().add(c, BorderLayout.CENTER);
      JTextArea itemText = c.getItemTextArea();
      JTextArea sourceText = c.getSourceTextArea();
      frame.getContentPane().add(new NorthPanel(reader, itemText, sourceText), BorderLayout.NORTH); 
      frame.getContentPane().add(new EastPanel(reader, itemText, sourceText), BorderLayout.EAST); 
           
      frame.setSize(650, 750);
      frame.setResizable(false);
      frame.setVisible(true);
   }
   
   public static void main(String[] args)
   {
      makeGUI();
   }
}
