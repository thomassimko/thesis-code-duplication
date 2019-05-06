import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddActionListener implements ActionListener {
	private JTextField srcText;
	private TweeterFeedReader feed;
	private JTextArea tweeterFeed;
	private JTextArea srcFeed;
	
	public AddActionListener (JTextField srcText, TweeterFeedReader feed, JTextArea tweeterFeed, JTextArea srcFeed) {
		this.srcText = srcText;
		this.feed = feed;
		this.tweeterFeed = tweeterFeed;
		this.srcFeed = srcFeed;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		tweeterFeed.setText("");
		srcFeed.setText("");
		String source = srcText.getText();
		//System.out.println(source);
		feed.addSource(source);
		//System.out.println("Feed.getSources' size: " + feed.getSources().size());
		List<RSSItem> newList = new LinkedList<RSSItem>();
		newList = feed.retrieveFeedItems();
		Comparator<RSSItem> itemCompare = new RSSItemComparator();
		Collections.sort(newList, itemCompare);
		List<String> newSrcList = feed.getSources();
		//System.out.println("Feed.getSources' size: " + feed.getSources().size());
		//System.out.println("newSourceList's size is: " + newSrcList.size());
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
			//System.out.println(newSrcList.get(j));
		}
	}

}
