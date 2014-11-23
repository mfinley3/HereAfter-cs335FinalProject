package model;

/**
 * Enum file for AI difficulty. Will be used when creating the enemy mobs and
 * putting them on the map, and while creating them map. Called by the GUI,
 * used in the controller.
 *
 */

public enum Difficulty {
	EASY(1.0), MEDIUM(2.0), HARD(3.0);
	
	private double d;
	
	Difficulty(Double d){
		this.d = d;
	}
	
	public double getValue(){
		return d;
	}
}
