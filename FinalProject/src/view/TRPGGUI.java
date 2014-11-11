package view;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Difficulty;
import model.GameController;
import model.Map;

/**
 * 
 * Sets up the GUI. Starts with the options of "New Game", "Continue" or "Quit"
 * and dynamically changes while buttons are selected.
 * 
 * 
 * @author Katelyn
 * 
 */

public class TRPGGUI extends JFrame {
	// Random serial number
	private static final long serialVersionUID = -703102129384036053L;

	private JLabel background;
	private boolean firstPage;
	private boolean secondPage;
	private JTabbedPane views;
	
	private JPanel panel;
	
	private JPanel text = new TextView();
	private JPanel graphical = new GraphicalView(); 
	private GameController controller;

	public static void main(String[] args) {
		new TRPGGUI().setVisible(true);
	}

	public TRPGGUI() {
		
		//Create a controller
		//controller = new GameController();
		
		panel =  new JPanel();
		firstPage = true;
		secondPage = false;

		setTitle("HereAfter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(990, 660);
		this.setVisible(true);
		this.setLocation(100, 0);

		this.setLayout(new BorderLayout());

		//Start up page
		ImageIcon image = new ImageIcon("FinalStartScreenBackground.png");
		background = new JLabel(image);
		panel.add(background);
		
		this.add(panel);

		registerListeners();

	}
	
	private void actualMap() {

		views = new JTabbedPane();
		views.add(graphical, "Graphical");
		views.add(text, "Text");
		panel.add(views, BorderLayout.CENTER);
		System.out.println("what");
		
		JButton sd = new JButton("yes");
		panel.add(sd);
		this.add(panel);
		revalidate();
		repaint();
		
	}

	private void registerListeners() {

		MouseListener listener = new ListenToMouse();
		MouseMotionListener motionListener = new ListenToMouse();

		panel.addMouseMotionListener(motionListener);
		panel.addMouseListener(listener);

	}

	/**
	 * Adds a listener to the mouse.
	 */
	private class ListenToMouse implements MouseMotionListener, MouseListener {

		/**
		 * Event were a mouse button is clicked, Is not used.
		 * 
		 * @param evt
		 *            Takes in a clicked event
		 */
		public void mouseClicked(MouseEvent evt) {
			int clickX = evt.getX();
			int clickY = evt.getY();

			if (firstPage) {

				if (clickX > 685 && clickX < 875 && clickY > 150 && clickY < 190) {
					//190x40
					
					// This means there is a new game
					// go to the second page with the level options
					ImageIcon image2 = new ImageIcon("FinalStartScreenBackgroundDifficulty.png");
					background.setIcon(image2);
					firstPage = false;
					secondPage = true;
				} else if(clickX > 645 && clickX < 925 && clickY > 210 && clickY < 250) {
					//This means they want to continue their game
					//280x40
					
					
					firstPage = false;
				} else if(clickX > 740 && clickX < 830 && clickY > 270 && clickY < 310) {
					//This means they want to quit the game
					//90x40
					
					System.exit(0);
				}
			} else if(secondPage){
				if (clickX > 740 && clickX < 840 && clickY > 235 && clickY < 275) {
					// This means the difficulty is easy
					//map = new Map(Difficulty.EASY);
					
				System.out.println("easy");
					
					
				} else if(clickX > 715 && clickX < 860 && clickY > 290 && clickY < 325) {
					//This means the difficulty is medium
					//map = new Map(Difficulty.MEDIUM);
					System.out.println("medium");
				} else if(clickX > 740 && clickX < 840 && clickY > 340 && clickY < 380) {
					//This means the difficulty is hard
					//map = new Map(Difficulty.HARD);
					System.out.println("hard");
				} 
				panel.remove(background);
				repaint();
				actualMap();
				secondPage = false;
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		@Override
		public void mouseDragged(MouseEvent e) {

		}

		@Override
		public void mouseMoved(MouseEvent e) {

		}

	}

}