
public class Tweeter {
	
	public static void main (String [] args) {
		TweeterFeedReader feed = new TweeterFeedReader();
		TweeterGUI userInterface = new TweeterGUI(feed);
		userInterface.GUIDisplay();
	}
}
