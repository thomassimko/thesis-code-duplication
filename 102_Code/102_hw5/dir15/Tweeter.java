import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tweeter
	extends javax.swing.JFrame
{	
	public static void main(String[] args)
	{
		FeedParser MasterParse = new FeedParser();
		
		JFrame frame = new JFrame("RSS Reader");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		frame.setSize(650, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().add(panel);
		
		JPanel NorthPanel = new JPanel();
		JLabel sourceText = new JLabel("Source:");
		JButton addButton = new JButton("Add");
		JTextField searchText = new JTextField(20);
		
		panel.add(NorthPanel, BorderLayout.NORTH);
		NorthPanel.add(sourceText);
		NorthPanel.add(searchText);
		NorthPanel.add(addButton);
		
		JPanel EastPanel = new JPanel();
		EastPanel.setLayout(new BoxLayout(EastPanel, BoxLayout.Y_AXIS));
		JButton refreshButton = new JButton("Refresh");
		JButton badButton = new JButton("Bad Sources");
		JButton cleanButton = new JButton("Clean Sources");
		
		panel.add(EastPanel, BorderLayout.EAST);
		EastPanel.add(refreshButton);
		EastPanel.add(badButton);
		EastPanel.add(cleanButton);
		
		JPanel CenterPanel = new JPanel();
		JPanel itemPanel = new JPanel();
		itemPanel.setLayout(new BorderLayout());
		JPanel sourcePanel = new JPanel();
		sourcePanel.setLayout(new BorderLayout());
		
		JLabel itemText = new JLabel("RSS Items");
		JLabel sourceTextBottom = new JLabel("Sources");
		JTextArea itemTextArea = new JTextArea(30, 40);
		JTextArea sourceTextArea = new JTextArea(7, 40);
		itemTextArea.setEditable(false);
		sourceTextArea.setEditable(false);
		
		JScrollPane bottomScroll = new JScrollPane(sourceTextArea);
		JScrollPane centerScroll = new JScrollPane(itemTextArea);
		
		
		itemPanel.add(itemText, BorderLayout.NORTH);
		itemPanel.add(centerScroll, BorderLayout.CENTER);
		
		sourcePanel.add(sourceTextBottom, BorderLayout.NORTH);
		sourcePanel.add(bottomScroll, BorderLayout.CENTER);
		
		CenterPanel.add(itemPanel, BorderLayout.NORTH);
		CenterPanel.add(sourcePanel, BorderLayout.SOUTH);
		
		panel.add(CenterPanel, BorderLayout.CENTER);
		
		ActionListener addListener = new addButtonListener(MasterParse, searchText, sourceTextArea);
		addButton.addActionListener(addListener);
		
		ActionListener refreshListener = new refreshButtonListener(MasterParse, itemTextArea, sourceTextArea);
		refreshButton.addActionListener(refreshListener);
		
		ActionListener badListener = new badButtonListener(MasterParse, sourceTextArea);
		badButton.addActionListener(badListener);
		
		ActionListener clearListener = new clearButtonListener(MasterParse, sourceTextArea);
		cleanButton.addActionListener(clearListener);
		
		frame.show();
	}

}
