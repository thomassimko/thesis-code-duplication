import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TwitGUIBuilder 
{
	  
	   public static void buildGUI(final FeedReader reader)
	   {
		   BorderLayout bLay = new BorderLayout();
		   JFrame frame = new JFrame();
		   frame.setSize(650, 750);
		   frame.setResizable(false);
		   JPanel mainPanel = (JPanel) frame.getContentPane();
		   mainPanel.setLayout(bLay);
		   final JTextField sourceTextField = new JTextField(20);	   
		   JButton addButton = new JButton("Add");    
		   addButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e)
			   {
				   String text = sourceTextField.getText();		
				   reader.addSource(text);
			   }
		   });
		   
		   final JTextArea textAreaItem = new JTextArea(30, 40);
		   final JTextArea textAreaSource = new JTextArea(7, 40);
		   JButton refresh = new JButton("Refresh");
		   refresh.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e)
			   {
				   List<String> sourceList = reader.getSources();
				   List<RSSItem> itemList = reader.retrieveFeedItems();
				   textAreaSource.setText(sourcePrintString(sourceList));
				   textAreaItem.setText(itemPrintString(itemList));			   
			   }
		   });
		   
		   JButton badSources = new JButton("Bad Sources");
		   badSources.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e)
			   {
				   String badSources = badSourcesString(reader);
				   textAreaSource.setText(badSources);
			   }
		   });
		   
		   JButton cleanSources = new JButton("Clean Sources");
		   cleanSources.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e)
			   {
				   String cleanSources = cleanSourcesString(reader);
				   textAreaSource.setText(cleanSources);		   
			   }
		   });
	   
		   JPanel CENTERPanel = buildCenterPanel(textAreaItem, textAreaSource);
		   JPanel NORTHPanel = buildNorthPanel(sourceTextField, addButton);   	   
		   JPanel EASTPanel = buildEastPanel(refresh, badSources, cleanSources);   
		   bLay.addLayoutComponent(NORTHPanel, BorderLayout.NORTH);
		   bLay.addLayoutComponent(EASTPanel, BorderLayout.EAST);
		   bLay.addLayoutComponent(CENTERPanel, BorderLayout.CENTER);
		   mainPanel.add(NORTHPanel);
		   mainPanel.add(EASTPanel);
		   mainPanel.add(CENTERPanel);             
		   frame.setVisible(true);	   
	   }
	   
	   private static String cleanSourcesString(FeedReader reader)
	   {
		   reader.removeBadSources();
		   List<String> sourceList = reader.getSources();
		   String sourcesToPrint = "";
		   for(String s : sourceList)
		   {
			   sourcesToPrint = sourcesToPrint + s + "\n";
		   }
		   return sourcesToPrint;
	   }
	   private static String badSourcesString(FeedReader reader)
	   {
		   List<String> badSourceList = reader.getBadSources();
		   String sourcesToPrint = "";
		   if(badSourceList.size() != 0)
		   {
			   sourcesToPrint = sourcePrintString(badSourceList);
		   }
		   else
		   {
			   sourcesToPrint = "";
		   }
		   return sourcesToPrint;
	   }

	   private static String itemPrintString(List<RSSItem> itemList)
	   {
		   String printStr = "";
		   Calendar date;
		   String titleToPrint = "";
		   String linkToPrint = "";
		   for(RSSItem item : itemList)
		   {
				   titleToPrint = item.getTitle();
				   date = item.getDate();
				   String dateToPrint = String.format("%1$tm/%<2td/%tY ", date);
				   linkToPrint = item.getLink();
				   printStr = printStr + titleToPrint + "\n" + "   " 
						   + dateToPrint + "\n" + "   " 
						   + linkToPrint + "\n\n";
		   }
		   return printStr;
	   }
	   
	   private static String sourcePrintString(List<String> sourceList)
	   {
		   String sourcesToPrint = "";
		   for(String s : sourceList)
		   {
			   sourcesToPrint = sourcesToPrint + s + "\n";
		   }
		   return sourcesToPrint;
	   }
	    
	   private static JPanel buildEastPanel(JButton refresh, JButton badSources, JButton cleanSources)
	   {
		   JPanel EASTPanel = new JPanel();
		   EASTPanel.setLayout(new BoxLayout(EASTPanel, BoxLayout.Y_AXIS));
		   EASTPanel.add(refresh);
		   EASTPanel.add(badSources);
		   EASTPanel.add(cleanSources);
		   return EASTPanel;
	   }
	   private static JPanel buildNorthPanel(JTextField sourceTextField, JButton addButton)
	   {
		   JPanel NORTHPanel = new JPanel();
		   JLabel source = new JLabel("Source:");
		   NORTHPanel.add(source);
		   NORTHPanel.add(sourceTextField);
		   NORTHPanel.add(addButton);
		   return NORTHPanel;
	   }
	   private static JPanel buildCenterPanel(JTextArea textAreaItem, JTextArea textAreaSource)
	   {
		   JPanel CENTERPanel = new JPanel();  
		   JPanel itemPanel = new JPanel();
		   JPanel sourcePanel = new JPanel();	   
		   BorderLayout bLay2 = new BorderLayout();
		   BorderLayout bLay3 = new BorderLayout();	   
		   itemPanel.setLayout(bLay2);
		   sourcePanel.setLayout(bLay3);	   
		   JLabel itemLabel = new JLabel("RSS Items");
		   JLabel sourceLabel = new JLabel("Sources");	   
		   JScrollPane scrollPaneItem = new JScrollPane(textAreaItem);
		   JScrollPane scrollPaneSource = new JScrollPane(textAreaSource);    	   
		   textAreaSource.setEditable(false);
		   textAreaItem.setEditable(false);  
		   itemPanel.add(itemLabel);
		   itemPanel.add(scrollPaneItem);   
		   sourcePanel.add(sourceLabel);
		   sourcePanel.add(scrollPaneSource);	   	   
		   CENTERPanel.add(itemPanel);
		   CENTERPanel.add(sourcePanel);  
		   bLay2.addLayoutComponent(itemLabel, BorderLayout.NORTH);
		   bLay2.addLayoutComponent(scrollPaneItem, BorderLayout.CENTER);	   
		   bLay3.addLayoutComponent(sourceLabel, BorderLayout.NORTH);
		   bLay3.addLayoutComponent(scrollPaneSource, BorderLayout.CENTER);
		   return CENTERPanel;
	   }
}
