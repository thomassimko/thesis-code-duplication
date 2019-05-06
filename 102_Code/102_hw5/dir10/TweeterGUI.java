import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.List;
import java.util.LinkedList;

public class TweeterGUI extends JFrame {
	
	private TweeterFeedReader feed = new TweeterFeedReader();
	
	public TweeterGUI (TweeterFeedReader feed) {
		this.feed = feed;
	}
	
	public void GUIDisplay () {
		//Initializes frame
		JFrame f = new JFrame("Tweeter");
		f.setSize(650,750);
		f.setResizable(false);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pan = (JPanel)f.getContentPane();
		pan.setLayout(new BorderLayout());
		
		//Initializes North Panel
		JPanel norPan = new JPanel();
		norPan.setLayout(new FlowLayout());
		JLabel norLabel = new JLabel("Source:");
		JTextField norText = new JTextField(20);
		JButton norButton = new JButton("Add");
		norPan.add(norLabel);
		norPan.add(norText);
		norPan.add(norButton);
		pan.add(norPan, BorderLayout.NORTH);
		
		//Initializes East Panel
		JPanel eastPan = new JPanel();
		eastPan.setLayout(new BoxLayout(eastPan, BoxLayout.Y_AXIS));
		JButton eastButRefresh = new JButton("Refresh");
		JButton eastButBadSrc = new JButton("Bad Sources");
		JButton eastButCleanSrc = new JButton("Clean Sources");
		eastPan.add(eastButRefresh);
		eastPan.add(eastButBadSrc);
		eastPan.add(eastButCleanSrc);
		pan.add(eastPan, BorderLayout.EAST);
		
		//Initializes Center Panel
		JPanel centPan = new JPanel();
		JPanel itemPan = new JPanel();
		JPanel sourcePan = new JPanel();
		itemPan.setLayout(new BorderLayout());
		JLabel itemPanLabel = new JLabel("RSS Items");
		itemPan.add(itemPanLabel, BorderLayout.NORTH);
		JTextArea tweetArea = new JTextArea(30, 40);
		tweetArea.setEditable(false);
		JScrollPane tweetPane = new JScrollPane(tweetArea);
		itemPan.add(tweetPane, BorderLayout.CENTER);
		sourcePan.setLayout(new BorderLayout());
		JLabel sourcePanLabel = new JLabel("Sources");
		sourcePan.add(sourcePanLabel, BorderLayout.NORTH);
		JTextArea srcArea = new JTextArea(7, 40);
		srcArea.setEditable(false);
		JScrollPane srcPane = new JScrollPane(srcArea);
		sourcePan.add(srcPane, BorderLayout.CENTER);
		centPan.add(itemPan);
		centPan.add(sourcePan);
		pan.add(centPan, BorderLayout.CENTER);
		
		//Gives Buttons Functionality
		AddActionListener addFunctionality = new AddActionListener(norText, feed, tweetArea, srcArea);
		norButton.addActionListener(addFunctionality);
		RefreshActionListener refreshFunctionality = new  RefreshActionListener(feed, tweetArea, srcArea);
		eastButRefresh.addActionListener(refreshFunctionality);
		BadSourcesActionListener badSourcesFunctionality = new BadSourcesActionListener(feed, srcArea);
		eastButBadSrc.addActionListener(badSourcesFunctionality);
		CleanSourcesActionListener cleanSourcesFunctionality = new CleanSourcesActionListener(feed, srcArea);
		eastButCleanSrc.addActionListener(cleanSourcesFunctionality);
		
		//Let's user see frame
		f.setVisible(true);
		
	}
}
