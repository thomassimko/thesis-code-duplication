import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private FeedReader fr = new FeedReaderClass();
	SimpleDateFormat sdf = new SimpleDateFormat();

	private JTextArea sourcesTextArea, itemTextArea;
	private JTextField sourceTextField;

	public MainFrame() {
		super();

		// set up the main panel
		setSize(650, 750);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		// set up north panel
		JPanel northPanel = new JPanel();
		northPanel.add(new JLabel("Source:"));
		sourceTextField = new JTextField(20);
		northPanel.add(sourceTextField);
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = sourceTextField.getText();
				if (!text.isEmpty()) {
					fr.addSource(sourceTextField.getText());
					sourceTextField.setText("");
					refreshItemsList();
					refreshSourcesList();
				}
			}
		});
		northPanel.add(addButton);

		// set up item panel
		JPanel itemPanel = new JPanel();
		itemPanel.setLayout(new BorderLayout());
		itemPanel.add(new JLabel("RSS Items"), BorderLayout.NORTH);
		itemTextArea = new JTextArea(30, 40);
		itemTextArea.setEditable(false);
		JScrollPane itemScrollPane = new JScrollPane(itemTextArea);
		itemPanel.add(itemScrollPane, BorderLayout.CENTER);

		// set up source panel
		JPanel sourcePanel = new JPanel();
		sourcePanel.setLayout(new BorderLayout());
		sourcePanel.add(new JLabel("Sources"), BorderLayout.NORTH);
		sourcesTextArea = new JTextArea(7, 40);
		sourcesTextArea.setEditable(false);
		JScrollPane sourceScrollPane = new JScrollPane(sourcesTextArea);
		sourcePanel.add(sourceScrollPane, BorderLayout.CENTER);

		// set up east panel
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		JButton refreshButton = new JButton("refresh");
		JButton badSourcesButton = new JButton("bad sources");
		JButton cleanSourcesButton = new JButton("clean sources");
		sdf.applyPattern("MM/dd/yyy HH:mm");
		refreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshItemsList();
			}
		});
		badSourcesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sources = "";
				for (String s : fr.getBadSources())
					sources += s + "\n";
				sourcesTextArea.setText(sources);
			}
		});
		cleanSourcesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fr.removeBadSources();
				refreshSourcesList();
			}
		});
		eastPanel.add(refreshButton);
		eastPanel.add(badSourcesButton);
		eastPanel.add(cleanSourcesButton);

		// set up center panel
		JPanel centerPanel = new JPanel();
		centerPanel.add(itemPanel);
		centerPanel.add(sourcePanel);

		// add all the panels to the main panel
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		setContentPane(mainPanel);
		setVisible(true);
	}

	private void refreshSourcesList() {
		String sources = "";
		for (String s : fr.getSources())
			sources += s + "\n";
		sourcesTextArea.setText(sources);
	}

	private void refreshItemsList() {
		String itemList = "";
		for (RSSItem r : fr.retrieveFeedItems()) {
			itemList += r.getTitle() + "\n   "
					+ sdf.format(r.getDate().getTime()) + "\n   " + r.getLink()
					+ "\n\n";
		}
		itemTextArea.setText(itemList);

	}
}