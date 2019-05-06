import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;


public class GUI {
	public void setGUI() {
		final FeedReaderClass feedReader = new FeedReaderClass();
		final List<RSSItem> rssList = new LinkedList<RSSItem>();
		
//		GUI
		JFrame mainFrame = new JFrame();
		JPanel initialPanel = (JPanel) mainFrame.getContentPane();
		BorderLayout initialLayout = new BorderLayout();
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(650, 750);
		initialPanel.setLayout(initialLayout);
		
//		NORTH
		JPanel northPanel = new JPanel();
		FlowLayout northLayout = new FlowLayout();
		JLabel sourceLabel = new JLabel("Source:");
		final JTextField northTextField = new JTextField(20);
		JButton addSourceButton = new JButton("Add");	
		northPanel.setLayout(northLayout);
		northPanel.add(sourceLabel, BorderLayout.NORTH);
		northPanel.add(northTextField, BorderLayout.NORTH);
		northPanel.add(addSourceButton, BorderLayout.NORTH);
		initialPanel.add(northPanel, BorderLayout.NORTH);
		
//		EAST
		JPanel eastPanel = new JPanel();
		BoxLayout eastLayout = new BoxLayout(eastPanel, BoxLayout.Y_AXIS);
		JButton refreshButton = new JButton("Refresh");		
		JButton badSourcesButton = new JButton("Bad Sources");		
		JButton cleanSourcesButton = new JButton("Clean Sources");
		eastPanel.setLayout(eastLayout);
		eastPanel.add(refreshButton, BorderLayout.EAST);
		eastPanel.add(badSourcesButton, BorderLayout.EAST);
		eastPanel.add(cleanSourcesButton, BorderLayout.EAST);
		initialPanel.add(eastPanel, BorderLayout.EAST);

//		CENTER
		JPanel centerPanel = new JPanel();
		BorderLayout centerLayout = new BorderLayout();
		centerPanel.setLayout(centerLayout);
		
//		CENTER ITEM PANEL
		JPanel itemPanel = new JPanel();
		BorderLayout itemLayout = new BorderLayout();
		itemPanel.setLayout(itemLayout);
		JLabel itemLabel = new JLabel("RSS Items");
		itemPanel.add(itemLabel, BorderLayout.NORTH);
		final JTextArea itemTextArea = new JTextArea(30, 40);
		itemTextArea.setEditable(false);
		JScrollPane itemScrollPane = new JScrollPane(itemTextArea);
		itemPanel.add(itemScrollPane, BorderLayout.CENTER);
		
//		CENTER SOURCE PANEL
		JPanel sourcePanel = new JPanel();
		BorderLayout sourceLayout = new BorderLayout();
		sourcePanel.setLayout(sourceLayout);
		JLabel sourceListLabel = new JLabel("Sources");
		sourcePanel.add(sourceListLabel, BorderLayout.NORTH);
		final JTextArea sourceListTextArea = new JTextArea(7, 40);
		sourceListTextArea.setEditable(false);
		JScrollPane sourceListScrollPane = new JScrollPane(sourceListTextArea);
		sourcePanel.add(sourceListScrollPane, BorderLayout.CENTER);
		centerPanel.add(itemPanel, BorderLayout.NORTH);
		centerPanel.add(sourcePanel, BorderLayout.CENTER);
		initialPanel.add(centerPanel, BorderLayout.CENTER);
		
//		ACTION LISTENERS
		addSourceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
   		   sourceListTextArea.setText("");
      		itemTextArea.setText("");
      		feedReader.addSource(northTextField.getText());
      		SourceSort<String> sourceSorter = new SourceSort<String>();
      		SourceComparator sourceComparator = new SourceComparator();
      		List<String> newSourceList = sourceSorter.sourceSort(feedReader.getSources(), sourceComparator);
      		int newSize = newSourceList.size();
      		for(int i=0; i<newSize; i++) {
      			sourceListTextArea.append(newSourceList.get(i) + "\n");
      		}
      		northTextField.setText("");
      		List<RSSItem> rssList = feedReader.retrieveFeedItems();
      		SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
      		DateSort<RSSItem> dateSorter = new DateSort<RSSItem>();
      		DateComparator dateComparator = new DateComparator();
      		List<RSSItem> newRssList = dateSorter.dateSort(rssList, dateComparator);
      		int newRssSize = newRssList.size();
      		for(int i=0; i<newRssSize; i++) {
      			itemTextArea.append(newRssList.get(i).getTitle() + "\n");
      			String formattedDate = df2.format(newRssList.get(i).getDate().getTime());
      			itemTextArea.append("   " + formattedDate + "\n");
      			itemTextArea.append("   " + newRssList.get(i).getLink() + "\n\n");
      		}
      	}
      });
		
		refreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
      		itemTextArea.setText("");
      		sourceListTextArea.setText("");
	      	List<RSSItem> rssList = feedReader.retrieveFeedItems();
      		SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
      		DateSort<RSSItem> dateSorter = new DateSort<RSSItem>();
      		DateComparator dateComparator = new DateComparator();
      		List<RSSItem> newRssList = dateSorter.dateSort(rssList, dateComparator);
      		int newRssSize = newRssList.size();
      		for(int i=0; i<newRssSize; i++) {
      			itemTextArea.append(newRssList.get(i).getTitle() + "\n");
      			String formattedDate = df2.format(newRssList.get(i).getDate().getTime());
      			itemTextArea.append("   " + formattedDate + "\n");
      			itemTextArea.append("   " + newRssList.get(i).getLink() + "\n\n");
      		}
      		SourceSort<String> sourceSorter = new SourceSort<String>();
      		SourceComparator sourceComparator = new SourceComparator();
      		List<String> newSourceList = sourceSorter.sourceSort(feedReader.getSources(), sourceComparator);
      		int newSize = newSourceList.size();
      		for(int i=0; i<newSize; i++) {
      			sourceListTextArea.append(newSourceList.get(i) + "\n");
      		}
      	}
     	});
		
		badSourcesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
      		sourceListTextArea.setText("");
	      	List<String> badSourceList = feedReader.getBadSources();
      		int badSize = badSourceList.size();
		      for(int i=0; i<badSize; i++) {
		      	sourceListTextArea.append(badSourceList.get(i) + "\n");
		      }
		      itemTextArea.setText("");
		   }
		});
		
		cleanSourcesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
      		sourceListTextArea.setText("");
		      feedReader.removeBadSources();
		      int cleanedSize = feedReader.getSources().size();
		      for(int i=0; i<cleanedSize; i++) {
		      	sourceListTextArea.append(feedReader.getSources().get(i) + "\n");
		      }
		      itemTextArea.setText("");
		      List<RSSItem> rssList = feedReader.retrieveFeedItems();
		      SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		      DateSort<RSSItem> dateSorter = new DateSort<RSSItem>();
		      DateComparator dateComparator = new DateComparator();
		      List<RSSItem> newRssList = dateSorter.dateSort(rssList, dateComparator);
		      int newRssSize = newRssList.size();
		      for(int i=0; i<newRssSize; i++) {
		      	itemTextArea.append(newRssList.get(i).getTitle() + "\n");
		      	String formattedDate = df2.format(newRssList.get(i).getDate().getTime());
		      	itemTextArea.append("   " + formattedDate + "\n");
		      	itemTextArea.append("   " + newRssList.get(i).getLink() + "\n\n");
		      }
			}
		});
		
		mainFrame.setVisible(true);
	}
}
