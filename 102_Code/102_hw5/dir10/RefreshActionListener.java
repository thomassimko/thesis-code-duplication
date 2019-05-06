import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RefreshActionListener implements ActionListener {;
	private TweeterFeedReader feed;
	private JTextArea tweeterFeed;
	private JTextArea srcFeed;
	
	public RefreshActionListener (TweeterFeedReader feed, JTextArea tweeterFeed, JTextArea srcFeed) {
		this.feed = feed;
		this.tweeterFeed = tweeterFeed;
		this.srcFeed = srcFeed;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		tweeterFeed.setText("");
		srcFeed.setText("");
		List<RSSItem> newList = new LinkedList<RSSItem>();
		List<String> newSrcList = feed.getSources();
		newList = feed.retrieveFeedItems();
		Comparator<RSSItem> itemCompare = new RSSItemComparator();
		Collections.sort(newList, itemCompare);
		Comparator<String> srcCompare = new SourceComparator();
		Collections.sort(newSrcList, srcCompare);
		for (int i = 0; i < newList.size(); i++) {
			tweeterFeed.append(newList.get(i).getTitle());
			tweeterFeed.append("\n   ");
			String dateString;
			dateString = String.format("%1$2tm/%<2td/%<tY %<tH:%<tm", newList.get(i).getDate());
			tweeterFeed.append(dateString);
			tweeterFeed.append("\n   ");
			tweeterFeed.append(newList.get(i).getLink());
			tweeterFeed.append("\n");
			tweeterFeed.append("\n");
		}
		for (int j = 0; j < newSrcList.size(); j++) {
			srcFeed.append(newSrcList.get(j));
			srcFeed.append("\n");
		}

	}

}
