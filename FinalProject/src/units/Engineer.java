package units;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import item.*;

/**
 * The Engineer is a controllable {@link Unit} for the player. Has a high
 * defense and two mines, but doesn't do a lot of damage or move very fast.
 * Created upon start of a new game, controlled by the human player.
 */
public class Engineer extends Unit {

	transient private BufferedImage engGen, engSelect, engCantMove, eng;

	/**
	 * Instantiates a new engineer.
	 *
	 * @param difficulty
	 *            the difficulty
	 */
	public Engineer(double difficulty) {
		// Unit Type, Given Item, Attack, Defense, Health, Movement, Range,
		// Difficulty multiplier

		// Defense is doubled at creation so Defense is actually 50
		super("Engineer", new Item("Homemade Armor Suit", ItemType.DEF), 20,
				25, 100, 4, 2, difficulty);
		this.addItem(new UsableItem("Salvaged Mine", ItemType.MINE));
		this.addItem(new UsableItem("Homemade Mine", ItemType.MINE));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see units.Unit#drawUnit(java.awt.Graphics)
	 */
	@Override
	public void drawUnit(Graphics g) {
		if (eng == null) {
			try {
				engSelect = ImageIO.read(new File("Engineer1Selected.png"));
				engCantMove = ImageIO.read(new File("Engineer1CantMove.png"));
				engGen = ImageIO.read(new File("Engineer1.png"));
				eng = engGen;
			} catch (IOException e) {
				System.out.println("Could not find picture file");
			}
		}
		if (super.isSelected)
			eng = engSelect;
		else if (!super.canMove()) // If the soldier cannot move
			eng = engCantMove;
		else
			eng = engGen;
		g.drawImage(eng, super.currentY * 100, super.currentX * 100, null);
	}

} // end of Engineer