import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public abstract class DynamicLabel extends JLabel {
	public DynamicLabel() {
		super();
		this.setText(getNewText());
		this.setBorder(new CompoundBorder(
				new LineBorder(Color.BLACK),
				new EmptyBorder(0,3,0,3)
				));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		this.setText(getNewText());
		super.paintComponent(g);
	}

	protected abstract String getNewText();
}
