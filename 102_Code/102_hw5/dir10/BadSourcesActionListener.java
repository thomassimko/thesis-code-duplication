import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BadSourcesActionListener implements ActionListener {
	private TweeterFeedReader feed;
	private JTextArea srcFeed;
	
	public BadSourcesActionListener (TweeterFeedReader feed, JTextArea srcFeed) {
		this.feed = feed;
		this.srcFeed = srcFeed;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		srcFeed.setText("");
		List<String> newList = feed.getBadSources();
		for (int i = 0; i < newList.size(); i++) {
			srcFeed.append(newList.get(i));
			srcFeed.append("\n");
		}
	}
}
