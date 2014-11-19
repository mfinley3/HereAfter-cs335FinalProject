package model;

import java.util.LinkedList;
import java.util.List;

import units.*;;

/**
 * The Player class. Contains all of the player's units (although
 * not their locations on the field), their stats, if they're alive
 * or dead
 * 
 * @author Brian Seaman
 *
 */
public class Player {
	private int gamesFinished;
	private int livingTeam;
	private List<Unit> livingUnits;
	private List<Unit> allUnits;
	private String id;
	
	public Player(String id){
		this.setID(id);
		livingUnits = new LinkedList<Unit>();
		allUnits = new LinkedList<Unit>();
		gamesFinished= livingTeam = 0;
	}

	public String getTeamStats() {
		// TODO Auto-generated method stub
		String temp = "";
		for(Unit i: allUnits)
			temp = temp + i.getStats() + "<br>";
		temp = temp + "<br>";
		
		
		return temp;
	}
	
	public List<Unit> getTeam(){
		return livingUnits;
	}
	
	public boolean everyonesDeadDave(){
		return livingUnits.isEmpty();
	}

	public List<Unit> allAliveUnits() {
		// TODO Auto-generated method stub
		return livingUnits;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}
	
	public void addUnits(Unit toAdd){
		livingUnits.add(toAdd);
		allUnits.add(toAdd);
		livingTeam++;
	}
	
	public int getAliveNum(){
		return livingTeam;
	}
	
	public void unitKilled(Unit dead){
		livingUnits.remove(dead);
		livingTeam--;
	}

	public int getGamesFinished() {
		// TODO Auto-generated method stub
		return gamesFinished;
	}

	public void gameFinished() {
		// TODO Auto-generated method stub
		gamesFinished++;
	}
}