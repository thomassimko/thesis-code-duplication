import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class TwitterGUI
   extends javax.swing.JFrame

{



   public TwitterGUI() 
	{
      JFrame mframe = new JFrame();
	   mframe.setSize(650, 750);
	   mframe.setResizable(false);
	   mframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	   Container panel = mframe.getContentPane();
	   panel.setLayout(new BorderLayout());
	   
	   // Northern Panel
	   JPanel flowN = new JPanel();
	   
	   flowN.setLayout( new FlowLayout());
	   JLabel labelNorth = new JLabel("Source:");
	   JTextField fieldNorth = new JTextField(20);
	   JButton buttonNorth = new JButton("Add");
	   
	   flowN.add(labelNorth);
	   flowN.add(fieldNorth);
	   flowN.add(buttonNorth);
	   
	   panel.add(flowN, BorderLayout.NORTH);	
	   
	   // Eastern Panel
	   JPanel boxE = new JPanel();
	   
	   boxE.setLayout( new BoxLayout(boxE, BoxLayout.Y_AXIS));
	   JButton buttonRef = new JButton("Refresh");
	   JButton buttonBad = new JButton("Bad Sources");
	   JButton buttonClean = new JButton("Clean Sources");
	   
	   boxE.add(buttonRef);
	   boxE.add(buttonBad);
	   boxE.add(buttonClean);
	   
	   panel.add(boxE, BorderLayout.EAST);	   
	   
	   // Center Panel
	   
	   JPanel itemPanel = new JPanel();
	   itemPanel.setLayout(new BorderLayout());
	   panel.add(itemPanel, BorderLayout.CENTER);
	   
	   JLabel itemLabel = new JLabel("RSS Items");
	   JTextArea itemArea = new JTextArea(30, 40);
	   itemArea.setEditable(false);
	   itemArea.setLineWrap(true);
	   JScrollPane itemScroll = new JScrollPane(itemArea);
	   
	   itemPanel.add(itemLabel, BorderLayout.NORTH);
	   itemPanel.add(itemArea, BorderLayout.CENTER);
	  
	   mframe.setVisible(true);
	}

}