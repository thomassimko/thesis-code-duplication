import javax.swing.JFrame;


public class Tweeter 
{
	public static void main(String[] args) 
	{
		FeedReader feedReader = new FeedReaderClass();
		JFrame frame = new GUI(feedReader);
	}
}
