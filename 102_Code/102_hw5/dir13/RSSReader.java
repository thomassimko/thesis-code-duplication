import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RSSReader extends JFrame {
	Tweeter core = new Tweeter();
	JPanel north = new JPanel();
	JLabel sourceH = new JLabel("Source: ");
	JTextField enter = new JTextField(20);
	JButton add = new JButton("Add");
	JPanel east = new JPanel();
	JButton refresh = new JButton("Refresh");
	JButton badSource = new JButton("Bad Sources");
	JButton cleanSource = new JButton("Clean Sources");
	JPanel center = new JPanel();
	JPanel itemP = new JPanel();
	JLabel rssL = new JLabel("RSS Items");
	JScrollPane rss = new JScrollPane();
	JTextArea list = new JTextArea(30,40);
	JPanel sourceP = new JPanel();
	JLabel sourceL = new JLabel("Sources");
	JScrollPane source = new JScrollPane();
	JTextArea sources = new JTextArea(7,40);
	
	public RSSReader() {
		this.setSize(650, 750);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		north.setLayout(new FlowLayout());
		north.add(sourceH);
		north.add(enter);
		north.add(add);
		this.add(north, BorderLayout.NORTH);		
		
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.add(refresh);
		east.add(badSource);
		east.add(cleanSource);
		this.add(east, BorderLayout.EAST);
		
		itemP.setLayout(new BorderLayout());
		itemP.add(rssL, BorderLayout.NORTH);
		rss.getViewport().add(list);
		list.setEditable(false);
		itemP.add(rss, BorderLayout.CENTER);
		center.add(itemP);
		sourceP.setLayout(new BorderLayout());
		sourceP.add(sourceL, BorderLayout.NORTH);
		source.getViewport().add(sources);
		sources.setEditable(false);
		sourceP.add(source, BorderLayout.CENTER);
		center.add(sourceP);
		this.add(center, BorderLayout.CENTER);
		
		add.addActionListener(new Listener(0, enter, core));
		refresh.addActionListener(new Listener(1, list, sources, core));
		badSource.addActionListener(new Listener(2, sources, core));
		cleanSource.addActionListener(new Listener(3, sources, core));
	}
}

class Listener  implements ActionListener {
	Component panel;
	int level;
	Tweeter fp;
	Component panel2;
	
	public Listener(int i, Component panel, Tweeter fp) {
		this.panel = panel;
		this.fp = fp;
		level = i;
	}
	
	public Listener(int i, Component panel1, Component panel2, Tweeter fp) {
		this.panel = panel1;
		this.fp = fp;
		level = i;
		this.panel2 = panel2;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (level) {
			case 0: //add
				fp.addSource(((JTextField) panel).getText());
				((JTextField) panel).setText("");
				break;
			case 1: //refresh
				String str1 = "";
				List<RSSItem> rss = fp.retrieveFeedItems();
				for (int i = 0; i < rss.size(); i++) {
					str1 += rss.get(i).getTitle() + "\n   ";
					str1 += String.format("%1$tm/%1$td/%1$tY %1$tH:%1$tM", rss.get(i).getDate()) + "\n   ";
					str1 += rss.get(i).getLink() + "\n\n";
				}
				((JTextArea) panel).setText("");
				((JTextArea) panel).setText(str1);
				str1 = "";
				for (String source: fp.getSources())
					str1 += source + "\n";
				((JTextArea) panel2).setText("");
				((JTextArea) panel2).setText(str1);
				break;
			case 2: //bad sources
				String str2 = "";
				for (String bs: fp.getBadSources())
					str2 += bs + "\n";
				((JTextArea) panel).setText("");
				((JTextArea) panel).setText(str2);
				break;
			case 3: //clean sources
				fp.removeBadSources();
				String str3 = "";
				for (String source: fp.getSources())
					str3 += source + "\n";
				((JTextArea) panel).setText("");
				((JTextArea) panel).setText(str3);
				break;
		}
	}
}

class run {
	public static void main(String[] args) {
		RSSReader test = new RSSReader();
		test.setVisible(true);
	}
}