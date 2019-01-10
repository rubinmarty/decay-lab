import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ParticleWidget extends JPanel {
	private int size;
	private double decayRate;
	private DecayLab decayLab;
	private int interval;
	private Timer timer;
	
	private double score = 0;
	
	public ParticleWidget(int _size, double _decayRate, int _interval) {
		this.size = _size;
		this.decayRate = _decayRate;
		this.interval = _interval;
		this.decayLab = new DecayLab(size, decayRate);
		
		this.setLayout(new BorderLayout());
		
		this.add(new ParticleGrid(decayLab), BorderLayout.NORTH);
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		this.add(southPanel, BorderLayout.SOUTH);
		
		southPanel.add(new DynamicLabel() {
			@Override
			protected String getNewText() {
				DecimalFormat df = new DecimalFormat("#");
		        df.setMaximumFractionDigits(4);
		        df.setMinimumFractionDigits(4);
				
				return "<html>Percent Remaining:<br>" +
						df.format( 100.0 * decayLab.aliveParticles / decayLab.numParticles ) +
						"%</html>";
			}
		});
		
		southPanel.add(new DynamicLabel() {
			@Override
			protected String getNewText() {
				DecimalFormat df = new DecimalFormat("#");
		        df.setMaximumFractionDigits(4);
		        df.setMinimumFractionDigits(4);
		        df.setMinimumIntegerDigits(4);
				
				return "<html>Average Lifespan:<br>" + df.format(score) + " ms</html>";
			}
		});
		
		southPanel.add(new DynamicLabel() {
			@Override
			protected String getNewText() {				
				return "<html>Time Step:<br>" + interval + " ms<html>";
			}
		});
		
		southPanel.add(new DynamicLabel() {
			@Override
			protected String getNewText() {
				DecimalFormat df = new DecimalFormat("#");
		        df.setMaximumFractionDigits(8);
				
				return "<html>\u03bb = " + df.format(1000 * decayRate / interval) + " Hz<br>"
						+ "\u03c4 = " + df.format(interval / decayRate) + " ms<br>"
						+ "<html>";
			}
		});
		
		this.timer = new Timer(interval, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tick();
				repaint();
			}
		});
	}
	
	public void setDecayRate(double d) {
		this.decayRate = d;
	}
	
	public void start() {
		this.timer.start();
	}
	
	public void stop() {
		this.timer.stop();
	}
	

	public void reset() {
		decayLab.reset();
		score = 0;
	}
	
	public void tick() {
		score += (double) decayLab.aliveParticles * interval / decayLab.numParticles;
		decayLab.tick();
	}
	
	public class ParticleGrid extends JComponent {
		
		private DecayLab lab;
		private int size;
		
		public ParticleGrid(DecayLab lab) {
			this.lab = lab;
			size = lab.size;
		}
		
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, size, size);
			g.setColor(Color.GREEN);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (lab.isAlive(i, j)) g.drawLine(i, j, i, j);
				}
			}
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(size, size);
		}
	}
	
}

