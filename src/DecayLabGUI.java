import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class DecayLabGUI {
	private JFrame frame;
	private ParticleWidget pw1;
	private ParticleWidget pw2;
	
	public static void main(String[] args) {
		new DecayLabGUI();
	}
	
	public DecayLabGUI() {
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		
		pw1 = new ParticleWidget(500, 1./6, 1000);
		pw2 = new ParticleWidget(500, 1./300, 20);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));
		
		panel.add(new Button("Start", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pw1.start();
				pw2.start();
			}
		}));
		
		panel.add(new Button("Pause", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pw1.stop();
				pw2.stop();
			}
		}));
		
		panel.add(new Button("Reset", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pw1.stop();
				pw1.reset();
				pw1.repaint();
				pw2.stop();
				pw2.reset();
				pw2.repaint();
			}
		}));
		
		frame.add(pw1);
		frame.add(panel);
		frame.add(pw2);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
	}
	
}
