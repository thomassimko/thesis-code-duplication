import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;

public class CleanSourcesListener implements ActionListener {
	private Reeder reeder;
	private JTextArea source;

	public CleanSourcesListener(Reeder bookworm, JTextArea sourceText) {
		// TODO Auto-generated constructor stub
		this.reeder = bookworm;
		this.source = sourceText;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.reeder.removeBadSources();
		String str = "";
		List<String> listy = this.reeder.getSources();
		Collections.sort(listy);
		for (int i = 0; i < listy.size(); i++) {
			str = str + listy.get(i) + "\n";
		}
		this.source.setText(str);
	}

}
