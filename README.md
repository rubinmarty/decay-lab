# decay-lab
A side-by-side comparison of different approximations of the exponential distribution.

Written for a freshman year physics class.

# About
When run, two boxes are displayed. Each pixel in each box represents a particle that has a 1/6 chance of decaying in a given second.

In the left box, particles decay only at the end of a second.
The probability of a particle decaying at the end of a given second is therefore 1/6.
Therefore, in each second, on average the fraction of the of the particles that will disappear is `1/6 = 0.167`.

In the right box, each partile has 50 chances to decay per second.
The probability of a particle decaying at the end of a given moment is therefore (1/50) * (1/6).
Therefore, in each second, on average the fraction of the particles that will disappear is `(1 - (1 - (1/300))^50) = 0.154`.

Although the two boxes appear to be acting quite differently, the average lifespan of a pixel in either box is the same (i.e. 6 seconds).
This result is both interesting and counterintuitive.

# Usage
Run the main method of the class DecayLabGUI.java

e.g. Navigate to the src folder, then execute `javac *.java && java DecayLabGUI`
