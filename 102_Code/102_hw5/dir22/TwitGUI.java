import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.List;

import javax.swing.*;
public class TwitGUI extends javax.swing.JFrame
{
  private TwitFeedReader TFR; 
  private JTextField SrcTextBox;
  private JTextArea ItemText;
  private JTextArea ItemText2;
  public TwitGUI(TwitFeedReader TFR)
  {
	this.TFR = TFR;
    this.setSize(650, 750);
    this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    
    JButton buttonAdd = new JButton("Add");
    JButton buttonOpen = new JButton("Refresh");
    JButton buttonBS = new JButton("Bad Sources");
    JButton buttonCS = new JButton("Clean Sources");
    JLabel Src = new JLabel("Source:");
    this.SrcTextBox = new JTextField(20);
    //North Panel
    setLayout(new BorderLayout()); 
    JPanel NorPan = new JPanel();
    NorPan.add(Src);
    NorPan.add(SrcTextBox);
    NorPan.add(buttonAdd);
    //East Panel
    JPanel EasPan = new JPanel();
    BoxLayout BL = new BoxLayout(EasPan, BoxLayout.Y_AXIS);
    EasPan.setLayout(BL);
    EasPan.add(buttonOpen);
    EasPan.add(buttonBS);
    EasPan.add(buttonCS);
    //Center Panel
    JPanel CenPan = new JPanel(new BorderLayout());
      //creating the RSSItem panel
      JPanel ItemPanel = new JPanel(new BorderLayout()); 
        JLabel ItemLabel = new JLabel("RSS Items");
        this.ItemText = new JTextArea(30,40);
        this.ItemText.setEditable(false);
        JScrollPane ScrPan = new JScrollPane(ItemText);
      ItemPanel.add(ItemLabel,BorderLayout.NORTH);
      ItemPanel.add(ScrPan,BorderLayout.CENTER);

      //creating the Source panel
      JPanel SourcePanel = new JPanel(new BorderLayout());
        JLabel SrcLabel = new JLabel("Sources");
           this.ItemText2 = new JTextArea(7,40);
           this.ItemText2.setEditable(false);
        JScrollPane ScrPan2 = new JScrollPane(ItemText2);
      SourcePanel.add(SrcLabel,BorderLayout.NORTH);
      SourcePanel.add(ScrPan2,BorderLayout.CENTER);
   
    //Main Panel
    JPanel MainPan = new JPanel();
    MainPan.setLayout(new BorderLayout());
    MainPan.add(NorPan, BorderLayout.NORTH);
    MainPan.add(EasPan, BorderLayout.EAST);
     CenPan.add(ItemPanel, BorderLayout.CENTER);
     CenPan.add(SourcePanel, BorderLayout.SOUTH);
    MainPan.add(CenPan, BorderLayout.CENTER);    

     add(MainPan);
     this.setVisible(true);
     
     
    //Adding actions to the buttons
    ActionListener AddAction = new AddButtonAction();
    buttonAdd.addActionListener(AddAction);
    
    ActionListener RefAction = new RefreshButtonAction();
    buttonOpen.addActionListener(RefAction);
    
    ActionListener BadSrcAction = new BadSourcesButtonAction();
    buttonBS.addActionListener(BadSrcAction);
    
    ActionListener ClnSrcAction = new CleanSourcesButtonAction();
    buttonCS.addActionListener(ClnSrcAction);
  }
  
  private class AddButtonAction implements ActionListener 
  {
  	@Override
  	public void actionPerformed(ActionEvent arg0) 
  	{
       String source = SrcTextBox.getText();  
  	   TFR.addSource(source);
  	   List<String> SourceList = TFR.getSources();
  	   List<RSSItem> ItemList = TFR.retrieveFeedItems();
  	   //JTextArea Itemtext for RSSItems and  Itemtext2 for sources
  	   for(int i = 0; i < SourceList.size(); i++)
  	   {
  		   ItemText2.append(SourceList.get(i) + "\n");
  	   }
  	   for(int j = 0; j < ItemList.size(); j++)
  	   {
  		   int month = ItemList.get(j).getDate().get(Calendar.MONTH) + 1;
  		   int day = ItemList.get(j).getDate().get(Calendar.DAY_OF_MONTH);
  		   int year = ItemList.get(j).getDate().get(Calendar.YEAR);
  		   int hour = ItemList.get(j).getDate().get(Calendar.HOUR_OF_DAY);
  		   int minute = ItemList.get(j).getDate().get(Calendar.MINUTE);
  		   ItemText.append(ItemList.get(j).getTitle() + "\n");
  		   ItemText.append("   "+ month + "/" + day + "/" + year + " " + hour + ":" + minute + "\n");
  		   ItemText.append("   " + ItemList.get(j).getLink() + "\n\n");
  		   
  	   }
  	   
  	}

  }
  private class RefreshButtonAction implements ActionListener 
  {
  	@Override
  	public void actionPerformed(ActionEvent arg0) 
  	{
       //retrieve feeds from list of sources
  	   List<String> SourceList = TFR.getSources();
  	   List<RSSItem> ItemList = TFR.retrieveFeedItems();
  	   //JTextArea Itemtext for RSSItems and  Itemtext2 for sources
  	   //must clear JTextAreas first
  	   ItemText.setText("");
  	   ItemText2.setText("");
  	   for(int i = 0; i < SourceList.size(); i++)
  	   {
  		   ItemText2.append(SourceList.get(i) + "\n");
  	   }
  	   for(int j = 0; j < ItemList.size(); j++)
  	   {
  		   int month = ItemList.get(j).getDate().get(Calendar.MONTH) + 1;
  		   int day = ItemList.get(j).getDate().get(Calendar.DAY_OF_MONTH);
  		   int year = ItemList.get(j).getDate().get(Calendar.YEAR);
  		   int hour = ItemList.get(j).getDate().get(Calendar.HOUR_OF_DAY);
  		   int minute = ItemList.get(j).getDate().get(Calendar.MINUTE);
  		   ItemText.append(ItemList.get(j).getTitle() + "\n");
  		   ItemText.append("   "+ month + "/" + day + "/" + year + " " + hour + ":" + minute + "\n");
  		   ItemText.append("   " + ItemList.get(j).getLink() + "\n\n");
  		   
  	   }
  		
  	}

  }
  private class BadSourcesButtonAction implements ActionListener 
  {
  	@Override
  	public void actionPerformed(ActionEvent arg0) 
  	{
  		// display bad sources in sources JTextField
        List<String> BadSourceList = TFR.getBadSources();
        ItemText2.setText("");
        for(int i = 0; i < BadSourceList.size(); i++)
        {
        	ItemText2.append(BadSourceList.get(i));
        }
  	}

  }
  private class CleanSourcesButtonAction implements ActionListener 
  {
  	@Override
  	public void actionPerformed(ActionEvent arg0) 
  	{
       //remove the bad sources and update sources JTextField      
  		TFR.removeBadSources();
  		List<String> SourceList =  TFR.getSources();
  		
  		ItemText2.setText("");
  		for(int i = 0; i < SourceList.size(); i++)
  		{
  			ItemText2.append(SourceList.get(i) + "\n");
  		}
  	}

  }
    
}
