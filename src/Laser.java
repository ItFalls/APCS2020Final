/*
 * Authors: Ethan Ling, Kevin Chu
 * Period: 4
 * Date: 5/15/2019
 * MonkeyDefence Capstone Project
 * Class: Banana
 */

// This class extends Weapon, and it is the weakest version of weapon, banana
public class Laser extends Weapon {
    // FIELDS:
    public static final int DAMAGE = 9;
    public static final double SPEED = 0.1;

    // CONSTRUCTOR:
    public Laser(int xPos, int yPos, int targetX, int targetY) {
    	super(Laser.class.getResource("/assets/Banana.png"), DAMAGE, SPEED, xPos, yPos, targetX, targetY);
    }

}
