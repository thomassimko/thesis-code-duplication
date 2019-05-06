import javax.swing.*;

public class Tweeter
{
   public static void main(String [] args)
	{
	   FeedReader reader = new Feed();
		JFrame GUI = new FeedGUI();
		GUI.show();
   }
}
 
