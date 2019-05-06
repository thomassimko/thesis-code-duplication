import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleEditableText;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.List;

public class Tweeter
{
  public static void main( String[] args )
  {
    FeedReader reader = new FeedRetriever();
    GUI gui = new GUI(reader);
  }
}
