public class Tweeter
{
    public static void main(String [] args)
    {
	GUI UI = new GUI();
	FeedReader reader = new FeedReaderClass();
	UI.initialize(reader);
    }
}