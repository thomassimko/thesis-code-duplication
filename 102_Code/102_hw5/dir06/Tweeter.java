
public class Tweeter 
{
	public static void main(String[] args)
	{
		FeedReader reader = new FeedList();
		GUI gui = new GUI(reader);
		gui.launchGUI();
	}
}
