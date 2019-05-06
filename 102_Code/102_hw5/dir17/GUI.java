import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI
  extends javax.swing.JFrame
{
  private JTextField topText;
  private JButton addButton;
  private JButton refreshButton;
  private JButton badSourcesButton;
  private JButton cleanSourcesButton;
  private JTextArea rssItemText;
  private JTextArea sourcesText;

  private FeedReader reader;
  private GUI gui = this;

  public GUI( FeedReader reader )
  {
    this.reader = reader;

    this.setSize( 650, 750 );
    this.setResizable( false );
    this.setDefaultCloseOperation( this.EXIT_ON_CLOSE );
    this.setTitle("");

    JPanel panel = setMain();

    this.setVisible( true );
  }

  private JPanel setMain()
  {
    JPanel panel = (JPanel)this.getContentPane();
    JPanel top = setTop();
    JPanel rht = setRight();
    JPanel cntr = setCenter();

    panel.add( top, BorderLayout.NORTH );
    panel.add( rht, BorderLayout.EAST );
    panel.add( new JPanel(), BorderLayout.WEST );
    panel.add( cntr, BorderLayout.CENTER );

    return panel;
  }

  private JPanel setTop()
  {
    JPanel top = new JPanel(new FlowLayout());

    JLabel topLabel = new JLabel("Source:");
    JTextField topText = new JTextField(20);
    JButton topButton = new JButton("Add");

    topButton.addActionListener( new ActionListener()
    {
      public void actionPerformed( ActionEvent e )
      {
        gui.invokeAddButton();
      }
    } );

    this.addButton = topButton;
    this.topText = topText;

    top.add(topLabel);
    top.add(topText);
    top.add(topButton);

    return top;
  }

  private JPanel setRight()
  {
    JPanel rht = new JPanel();
    rht.setLayout(new BoxLayout(rht, BoxLayout.Y_AXIS));

    JButton rhtRefreshButton = new JButton("Refresh");
    JButton rhtBadSourcesButton = new JButton("Bad Sources");
    JButton rhtCleanSourcesButton = new JButton("Clean Sources");

    this.refreshButton = rhtRefreshButton;
    this.badSourcesButton = rhtBadSourcesButton;
    this.cleanSourcesButton = rhtCleanSourcesButton;

    addRefreshButtonActionListener(refreshButton);
    addBadSourcesButtonActionListener(badSourcesButton);
    addCleanSourcesButtonActionListener(cleanSourcesButton);

    rht.add(rhtRefreshButton);
    rht.add(rhtBadSourcesButton);
    rht.add(rhtCleanSourcesButton);

    return rht;
  }

  private void addRefreshButtonActionListener(JButton button)
  {
    button.addActionListener( new ActionListener()
    {
      public void actionPerformed( ActionEvent e )
      {
        gui.invokeRefreshButton();
      }
    } );
  }

  private void addCleanSourcesButtonActionListener(JButton button)
  {
    button.addActionListener( new ActionListener()
    {
      public void actionPerformed( ActionEvent e )
      {
        gui.invokeCleanSourcesButton();
      }
    } );
  }

  private void addBadSourcesButtonActionListener(JButton button)
  {
    button.addActionListener( new ActionListener()
    {
      public void actionPerformed( ActionEvent e )
      {
        gui.invokeBadSourcesButton();
      }
    } );
  }

  private JPanel setCenter()
  {
    JPanel cntr = new JPanel();

    JPanel itemPanel = setCenterPanel("RSS Item", 30);
    JPanel sourcePanel = setCenterPanel("Sources", 7);

    cntr.add(itemPanel);
    cntr.add(sourcePanel);

    return cntr;
  }

  private JPanel setCenterPanel(String label, int rowCount)
  {
    JPanel panel = new JPanel(new BorderLayout());
    JTextArea textArea = new JTextArea(rowCount, 40);
    textArea.setEditable( false );

    if( label.equals("RSS Item") )
      this.rssItemText = textArea;
    else if( label.equals("Sources") )
      this.sourcesText = textArea;

    JLabel jLabel = new JLabel(label);
    JScrollPane scrollPane = new JScrollPane(textArea);

    panel.add(jLabel, BorderLayout.NORTH);
    panel.add(scrollPane, BorderLayout.CENTER);

    return panel;
  }

  public void invokeAddButton()
  {
    String src = topText.getText();

    topText.setText("");
    reader.addSource(src);
    sourcesText.append(src + "\n");

    invokeRefreshButton();
  }

  public void invokeRefreshButton()
  {
    rssItemText.setText("");
    List<RSSItem> items = reader.retrieveFeedItems();
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");

    Comparator<RSSItem> comp = new RSSItemComparator();
    Collections.sort( items, comp );

    for( RSSItem i : items )
    {
      rssItemText.append(i.getTitle() + "\n");
      rssItemText.append("   " + df.format(i.getDate().getTime()) + "\n");
      rssItemText.append("   " + i.getLink() + "\n\n");
    }
  }

  public void invokeCleanSourcesButton()
  {
    reader.removeBadSources();
    displaySources(reader.getSources());
  }

  public void invokeBadSourcesButton()
  {
    displaySources(reader.getBadSources());
  }

  private void displaySources(List<String> sources)
  {
    sourcesText.setText("");
    Collections.sort(sources);

    for( String s : sources )
    {
      sourcesText.append(s + "\n");
    }
  }

  public JButton getAddButton()
  {
    return this.addButton;
  }

  public JButton getRefreshButton()
  {
    return this.refreshButton;
  }

  public JButton getBadSourcesButton()
  {
    return this.badSourcesButton;
  }

  public JButton getCleanSourcesButton()
  {
    return this.cleanSourcesButton;
  }

  public JTextField getTopText()
  {
    return this.topText;
  }

  public JTextArea getRSSItemText()
  {
    return this.rssItemText;
  }

  public JTextArea getSourcesText()
  {
    return this.sourcesText;
  }
}
