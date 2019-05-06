import javax.swing.JFrame;


public class Tweeter
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		FeedReader reader = new Reader();
		@SuppressWarnings("unused")
		JFrame tweeter = new TweeterGUI(reader);
	}
	
}
