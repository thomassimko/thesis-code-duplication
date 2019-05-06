import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;

public class RefreshListener implements ActionListener {

	private Reeder reeder;
	private JTextArea item;

	public RefreshListener(Reeder reeder, JTextArea itemText) {
		this.reeder = reeder;
		this.item = itemText;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		List<RSSItem> dispitem;
		dispitem = this.reeder.retrieveFeedItems();
		String str = "";
		Collections.sort(dispitem, new RSSItemComparator());
		for (int i = 0; i < dispitem.size(); i++) {
			str = str + dispitem.get(i).getTitle() + "\n";
			str = str + "    " + caltoread(dispitem.get(i).getDate()) + "\n";
			str = str + "    " + dispitem.get(i).getLink() + "\n";
			str = str + "\n";
		}
		this.item.setText(str);
	}

	private static String caltoread(Calendar cal) {
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("dd/MM/yyyy HH:mm");
		return df.format(cal.getTime());
	}

}
