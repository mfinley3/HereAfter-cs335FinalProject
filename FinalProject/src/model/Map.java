package model;

import java.util.List;
import java.util.Stack;

import space.Space;
import space.WasteLandSpace;
import units.Unit;

public class Map {
	
	private Space[][] map;
	private Unit[][] unitsOnMap;
	
	public Map(double difficulty) {
		
			map = new Space[25][25];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = new WasteLandSpace(); // Map of empty spaces
				}
			if(difficulty == .5){
				//make the easy map
			}
			if(difficulty == 1){
				//make the medium map
			}
			if(difficulty == 2){
				//make the hard map
			}				
				
			}		
	}
	
	public void addUnitsToMap(List<Unit> unitList){
		
		unitList = new Stack<Unit>();
		unitsOnMap = new Unit[25][25];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = new WasteLandSpace(); // Map of empty spaces
			}
			
		int k = 0;
		int r = 2;
		
		while(!unitList.isEmpty()){
			unitsOnMap[k][r] = ((Stack<Unit>) unitList).pop();
			
			
			
		}
		
		
		
		
	}
	
}
