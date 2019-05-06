import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTextArea;

public class CleanSourcesActionListener implements ActionListener {
	private TweeterFeedReader feed;
	private JTextArea srcFeed;
	
	public CleanSourcesActionListener (TweeterFeedReader feed, JTextArea srcFeed) {
		this.feed = feed;
		this.srcFeed = srcFeed;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		srcFeed.setText("");
		feed.removeBadSources();
		List<String> newList = feed.getSources();
		Comparator<String> srcCompare = new SourceComparator();
		Collections.sort(newList, srcCompare);
		for (int i = 0; i < newList.size(); i++) {
			srcFeed.append(newList.get(i));
			srcFeed.append("\n");
		}
	}
}
