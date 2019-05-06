import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TweeterUI
	extends JFrame
{
	public TweeterUI()
	{
		FeedReader reader = new Reader();
		JFrame frame = new JFrame();
		frame.setSize(650, 750);
		
		JPanel panel1 = new JPanel(new BorderLayout());
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel items = new JPanel(new BorderLayout());
		JPanel sources = new JPanel(new BorderLayout());
		JButton addSource = new JButton("Add");
		JButton refresh = new JButton("Refresh");
		JButton badSource = new JButton("Bad Sources");
		JButton cleanSource = new JButton("Clean Sources");
		JTextField textField = new JTextField(20);
		
		//North Text Field
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		panel2.add(new JLabel("Source:"));
		panel2.add(textField);
		panel2.add(addSource);
		
		//East Buttons
		panel3.add(refresh);
		panel3.add(badSource);
		panel3.add(cleanSource);
		
		//RSS Items and Sources Text Area
		JTextArea rssItems = new JTextArea(30, 40);
		rssItems.setEditable(false);
		JTextArea source = new JTextArea(7, 40);
		source.setEditable(false);
		items.add(new JLabel("RSS Items"), BorderLayout.NORTH);
		items.add(new JScrollPane(rssItems), BorderLayout.CENTER);
		sources.add(new JLabel("Sources"), BorderLayout.NORTH);
		sources.add(new JScrollPane(source), BorderLayout.CENTER);
		
		//Add Source Button functionality
		ActionListener adder = new AddListener(reader, textField);
		addSource.addActionListener(adder);
		
		//Refresh Button functionality
		ActionListener refresher = new RefreshListener(reader, rssItems, source);
		refresh.addActionListener(refresher);
		
		//Bad Sources functionality
		ActionListener badListen = new BadListener(reader, source);
		badSource.addActionListener(badListen);
		
		//Clean Sources Button Functionality
		ActionListener cleanListen = new CleanListener(reader, source);
		cleanSource.addActionListener(cleanListen);
		
		//Put 'em all in the main panel and into the frame
		panel1.add(panel2, BorderLayout.NORTH);
		panel1.add(panel3, BorderLayout.EAST);
		panel1.add(items, BorderLayout.CENTER);
		items.add(sources, BorderLayout.SOUTH);
		frame.getContentPane().add(panel1);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
}