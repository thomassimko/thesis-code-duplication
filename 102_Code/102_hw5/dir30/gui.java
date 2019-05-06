import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class gui extends JFrame 
{
	FeedReaderClass feedReader;
	JTextField sourceField;
	JTextArea itemArea;
	JTextArea sourceArea;
	
	public gui()
	{
		feedReader = new FeedReaderClass();
		createFrame();
		editLayout();
		this.setVisible(true);

	}
	
	public void createFrame()
	{
		this.setSize(650, 750);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void editLayout()
	{
		setCenter();
		setNorth();
		setEast();
	}

	private void setNorth() 
	{
		JPanel p = (JPanel) this.getContentPane();
		Panel north = new Panel();
		LayoutManager flowLayout = new FlowLayout();
		
		JLabel source = new JLabel("Source: ");
		sourceField = new JTextField(20);
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new addSourceButtonListener(feedReader, sourceField, itemArea, sourceArea));
		north.setLayout(flowLayout);
		
		north.add(source);
		north.add(sourceField);
		north.add(addButton);
		
		p.add(north, BorderLayout.NORTH);
		
		source.setVisible(true);
		sourceField.setVisible(true);
		sourceField.setVisible(true);
		
		north.setVisible(true);
	}
	
	private void setEast()
	{
		JPanel p = (JPanel) this.getContentPane();
		Panel east = new Panel();
		LayoutManager boxLayout = new BoxLayout(east, BoxLayout.Y_AXIS);
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new refreshButtonListener(feedReader, itemArea, sourceArea));
		JButton badSources = new JButton("Bad Sources");
		badSources.addActionListener(new badSourcesButtonListener(feedReader, sourceArea));
		JButton cleanSources = new JButton("Clean Sources");
		cleanSources.addActionListener(new cleanBadSourcesButtonListener(feedReader, sourceArea));
		
		east.setLayout(boxLayout);
		
		east.add(refreshButton);
		east.add(badSources);
		east.add(cleanSources);
		
		p.add(east, BorderLayout.EAST);
		
		refreshButton.setVisible(true);
		badSources.setVisible(true);
		cleanSources.setVisible(true);
		
		east.setVisible(true);
	}
	
	private void setCenter()
	{
		JPanel p = (JPanel) this.getContentPane();
		Panel itemPanel = new Panel();
		Panel sourcePanel = new Panel();
		LayoutManager borderLayout1 = new BorderLayout();
		LayoutManager borderLayout2 = new BorderLayout();
		
		JLabel itemLabel = new JLabel("RSS Items");
		itemArea = new JTextArea(30, 40);
		JScrollPane itemScrollArea = new JScrollPane(itemArea);
		
		itemPanel.setLayout(borderLayout1);
		
		itemPanel.add(itemLabel, BorderLayout.NORTH);
		itemPanel.add(itemScrollArea, BorderLayout.CENTER);
		
		JLabel sourceLabel = new JLabel("Sources");
		sourceArea = new JTextArea(7, 40);
		JScrollPane sourceScrollArea = new JScrollPane(sourceArea);
		
		sourcePanel.setLayout(borderLayout2);
		
		sourcePanel.add(sourceLabel, BorderLayout.NORTH);
		sourcePanel.add(sourceScrollArea, BorderLayout.CENTER);
		
		p.add(itemPanel, BorderLayout.CENTER);
		p.add(sourcePanel, BorderLayout.SOUTH);
		
		itemLabel.setVisible(true);
		itemArea.setVisible(true);
		itemScrollArea.setVisible(true);
		sourceLabel.setVisible(true);
		sourceArea.setVisible(true);
		sourceScrollArea.setVisible(true);
		
		itemPanel.setVisible(true);
		sourcePanel.setVisible(true);
	}
}
