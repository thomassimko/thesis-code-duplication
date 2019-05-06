import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Tweeter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reeder bookworm = new Reeder();
		// bookworm.addSource("http://search.twitter.com/search.rss?q=from:GuildWars2");
		// bookworm.addSource("http://search.twitter.com/search.rss?q=from:GW2Guru");
		// printy(bookworm);

		JFrame frame = new JFrame("");
		frame.setSize(650, 750);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout mainmgr = new BorderLayout();
		Container ctrpane = frame.getContentPane();
		ctrpane.setLayout(mainmgr);

		FlowLayout topmgr = new FlowLayout();
		Container topContainer = new Container();
		topContainer.setLayout(topmgr);
		JTextField topInPut = new JTextField(20);
		JButton topAdd = new JButton("add");
		topContainer.add(new JLabel("Source: "));
		topContainer.add(topInPut);
		topContainer.add(topAdd);

		Container eastContainer = new Container();
		BoxLayout eastMgr = new BoxLayout(eastContainer, BoxLayout.Y_AXIS);
		eastContainer.setLayout(eastMgr);
		JButton refresh = new JButton("Refresh");
		JButton badSource = new JButton("Bad Sources");
		JButton cleanSources = new JButton("Clean Sources");
		eastContainer.add(refresh);
		eastContainer.add(badSource);
		eastContainer.add(cleanSources);

		Container centerContainer = new Container();
		BoxLayout centermgr = new BoxLayout(centerContainer, BoxLayout.Y_AXIS);
		centerContainer.setLayout(centermgr);
		JPanel itemPanel = new JPanel();// north
		JPanel sourcePanel = new JPanel();// center

		JTextArea itemText = new JTextArea(30, 40);
		itemText.setEditable(false);
		JLabel itemLabel = new JLabel("RSS Items");
		JScrollPane itemScroll = new JScrollPane(itemText);
		itemScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// itemScroll.add(itemText);

		JTextArea sourceText = new JTextArea(7, 40);
		sourceText.setEditable(false);
		JLabel sourceLabel = new JLabel("Sources");
		JScrollPane sourceScroll = new JScrollPane(sourceText);
		sourceScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// sourceScroll.add(sourceText);

		BorderLayout itemMgr = new BorderLayout();
		BorderLayout sourceMgr = new BorderLayout();
		itemPanel.setLayout(itemMgr);
		sourcePanel.setLayout(sourceMgr);

		itemPanel.add(itemLabel, BorderLayout.NORTH);
		itemPanel.add(itemScroll, BorderLayout.CENTER);
		sourcePanel.add(sourceLabel, BorderLayout.NORTH);
		sourcePanel.add(sourceScroll, BorderLayout.CENTER);

		centerContainer.add(itemPanel);
		centerContainer.add(sourcePanel);

		ctrpane.add(topContainer, BorderLayout.NORTH);
		ctrpane.add(eastContainer, BorderLayout.EAST);
		ctrpane.add(centerContainer, BorderLayout.CENTER);

		topAdd.addActionListener(new AddListener(bookworm, topInPut, sourceText));
		refresh.addActionListener(new RefreshListener(bookworm, itemText));
		badSource
				.addActionListener(new BadSourceListener(bookworm, sourceText));
		cleanSources.addActionListener(new CleanSourcesListener(bookworm,
				sourceText));

		frame.validate();
		frame.setVisible(true);
	}

	private static void printy(Reeder r) {
		// TODO Auto-generated method stub
		System.out.println("obtaining from following areas:");
		for (int i = 0; i < r.getSources().size(); i++)
			System.out.println(r.getSources().get(i));
		System.out.println();
		System.out.println("prnting items:");
		r.retrieveFeedItems();
		for (int i = 0; i < r.OList().size(); i++) {
			System.out.println("The Title: " + r.OList().get(i).getTitle());
			System.out.println("The  Link: " + r.OList().get(i).getLink());
			System.out.println("The  Date: "
					+ caltoread(r.OList().get(i).getDate()));
			System.out.println();
		}
		// System.out.println(r.retrieveFeedItems().get(0).getDate().toString());
		// System.out.println(r.retrieveFeedItems().get(1).getDate().toString());
	}

	private static String caltoread(Calendar cal) {
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("dd/MM/yyyy HH:mm");
		return df.format(cal.getTime());
	}
}
