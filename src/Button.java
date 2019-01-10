import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton {			
	public Button(String text, ActionListener al) {
		super();
		this.setText(text);
		this.addActionListener(al);
	}
}