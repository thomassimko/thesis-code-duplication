import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;

public class BadSourceListener implements ActionListener {

	private Reeder reeder;
	private JTextArea source;

	public BadSourceListener(Reeder bookworm, JTextArea sourceText) {
		// TODO Auto-generated constructor stub
		this.reeder = bookworm;
		this.source = sourceText;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = "";
		List<String> listy = this.reeder.getBadSources();
		Collections.sort(listy);
		for (int i = 0; i < reeder.getBadSources().size(); i++) {
			str = str + reeder.getBadSources().get(i) + "\n";
		}
		this.source.setText(str);
	}
}
