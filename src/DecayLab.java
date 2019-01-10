public class DecayLab {
	public int size;
	public int numParticles;
	public int aliveParticles;
	public double decayRate;
	public boolean[] particles;
	
	public static void main(String[] args) {
		new DecayLab(1000, .1);
	}
	
	public void print() {
		System.out.println(aliveParticles + " " + (numParticles - aliveParticles));
		//System.out.println(Arrays.toString(particles));
	}
	
	public DecayLab(int size, double decayRate) {
		this.size = size;
		this.numParticles = size*size;
		this.decayRate = decayRate;
		reset();
	}
	
	public void reset() {
		this.aliveParticles = numParticles;
		particles = new boolean[numParticles];
	}
	
	public boolean isAlive(int x, int y) {
		return isAlive(y*size + x);
	}
	
	public boolean isAlive(int x) {
		return !particles[x];
	}
	
	public void tick() {
		if (aliveParticles <= 0) return;
		for (int i = 0; i < numParticles; i++) {
			if (!particles[i] && Math.random() < decayRate) {
				particles[i] = true;
				aliveParticles--;
			}
		}
	}
}
