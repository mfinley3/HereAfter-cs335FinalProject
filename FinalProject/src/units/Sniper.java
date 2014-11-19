package units;

import item.Item;
import item.ItemType;

/**
 * 
 * @author Chioke
 *
 */
public class Sniper extends Unit {

	public Sniper(double difficulty) {
		// unitType, their given item, attack, defense, health, movement, difficulty multiplier
		super("Sniper", new Item("MLG's Rifle of Quickscoping 9001", ItemType.ATK), 60, 10, 100, 5, difficulty);
		
	}

	@Override
	public int getRange() {
		// TODO Auto-generated method stub
		return 6;
	}
}
