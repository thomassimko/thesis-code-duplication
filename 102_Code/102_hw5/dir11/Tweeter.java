import javax.swing.JFrame;


public class Tweeter
{
	public static void main(String [] args)
	{
		FeedReader feed = new Reader();
		
		JFrame UI = new GUI(feed);
	}
}
