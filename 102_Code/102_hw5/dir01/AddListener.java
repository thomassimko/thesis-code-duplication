import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddListener implements ActionListener {

	private Reeder reeder;
	private JTextField text;
	private JTextArea source;

	public AddListener(Reeder r, JTextField topInPut, JTextArea sourceText) {
		this.reeder = r;
		this.text = topInPut;
		this.source = sourceText;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!this.text.getText().equals("")) {
			this.reeder.addSource(this.text.getText());
			String str = "";
			List<String> listy = this.reeder.getSources();
			Collections.sort(listy);
			for (int i = 0; i < listy.size(); i++) {
				str = str + listy.get(i) + "\n";
			}
			this.source.setText(str);
			this.text.setText("");
		}
	}

}
