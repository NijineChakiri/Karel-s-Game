package lab1.Command;
import java.util.ArrayList;
import java.util.List;
import lab1.Map.*;
import lab1.MapObject.*;

public class GameHelper extends Command{
	private ArrayList<MapObject> rockList;
	
	public GameHelper(Map map, Avatar avatar) {
		super(map, avatar);
	}
	
	static class Grid {
		public int x, y;
		public int f, g, h;
		public Grid parent;
		public Grid(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void initGrid(Grid parent, Grid end) {
			this.parent = parent;
			if(parent != null) {
				this.g = parent.g + 1;
			} else {
				this.g = 1;
			}
			this.h = getManhattanDistance(this.x, end.x, this.y, end.y);
			this.f = this.g +this.h;		
		}
	}
	
	public MapObject getNearestRock() {
		int minDistance;
		MapObject nearestRock = rockList.get(0);
		minDistance = getManhattanDistance(avatar.getxCoor(), nearestRock.getxCoor(), avatar.getyCoor(), nearestRock.getyCoor());
		for (MapObject rock : rockList) {
		    if(minDistance > getManhattanDistance(avatar.getxCoor(), rock.getxCoor(), avatar.getyCoor(), rock.getyCoor())) {
		    	nearestRock = rock;
		    	minDistance = getManhattanDistance(avatar.getxCoor(), nearestRock.getxCoor(), avatar.getyCoor(), nearestRock.getyCoor());
		    } 
		}
		return nearestRock;
	}
	
	private static boolean containGrid(List<Grid> grids, int x, int y) {
		for(Grid n : grids) {
			if((n.x == x) && (n.y == y)) {
				return true;
			}
		}
		return false;
	}
	
	private static Grid findMinGird(ArrayList<Grid> openList) {
		Grid tempGrid = openList.get(0);
		for(Grid grid: openList) {
			if(grid.f < tempGrid.f) {
				tempGrid = grid;
			}
		}
		return tempGrid;
	}
	
	private boolean isValidGrid(int x, int y, List<Grid> openList, List<Grid> closeList) {
		if(x < 0 || x >= map.getLength() || y < 0 || y >= map.getWidth()) {
			return false;
		}		
		if(map.getMap()[x][y] != '●' && !map.getWalkableTiles().contains(map.getMap()[x][y])) {
			return false;
		}	
		if(containGrid(openList, x, y)) {
			return false;
		}			
		if(containGrid(closeList, x, y)) {
			return false;
		}		
		return true;
	}
	
	private ArrayList<Grid> findNeighbors(Grid grid, List<Grid> openList, List<Grid> closeList){
		ArrayList<Grid> gridList = new ArrayList<Grid>();
		if(isValidGrid(grid.x, grid.y-1, openList, closeList)) {
			gridList.add(new Grid(grid.x, grid.y-1));
		}
		if(isValidGrid(grid.x, grid.y+1, openList, closeList)) {
			gridList.add(new Grid(grid.x, grid.y+1));
		}
		if(isValidGrid(grid.x-1, grid.y, openList, closeList)) {
			gridList.add(new Grid(grid.x-1, grid.y));
		}
		if(isValidGrid(grid.x+1, grid.y, openList, closeList)) {
			gridList.add(new Grid(grid.x+1, grid.y));
		}
		return gridList;
	}
	
	public Grid aStarSearch(Grid start, Grid end) {
		ArrayList<Grid> openList = new ArrayList<Grid>();
		ArrayList<Grid> closeList = new ArrayList<Grid>();
		openList.add(start);
		
		while(openList.size() > 0) {
			Grid currentGrid = findMinGird(openList);
			openList.remove(currentGrid);
			closeList.add(currentGrid);
			List<Grid> neighbors = findNeighbors(currentGrid, openList, closeList);
			
			for(Grid grid : neighbors) {
				if(!openList.contains(grid)) {
					grid.initGrid(currentGrid, end);
					openList.add(grid);
				}
			}
			for(Grid grid : openList) {
				if((grid.x == end.x) && (grid.y == end.y)) {
					return grid;
				}
			}
		}
		return null;
	}
	
	public void addPath(Grid resultGrid, ArrayList<MapObject> pathList) {
		ArrayList<Grid> pathGrid = new ArrayList<Grid>();
		while(resultGrid != null) {
			pathGrid.add(new Grid(resultGrid.x, resultGrid.y));
			resultGrid = resultGrid.parent;
		}
		for(Grid grid : pathGrid) {
			MapObject path = new Path(grid.x, grid.y);
			pathList.add(path);
		}
		if(pathList.size() > 0) {

			//System.out.println("Follow the '*' and you will find the rock.");
			pathList.remove(0);
		} 
			//System.out.println("No way to get to the rock!");
	}
	
	public ArrayList<MapObject> findPath(){
		ArrayList<MapObject> pathList = new ArrayList<MapObject>();
		rockList = map.getRockList();
		Grid avatarGrid = new Grid(avatar.getxCoor(), avatar.getyCoor());
		
		Grid endGrid = new Grid(getNearestRock().getxCoor(), getNearestRock().getyCoor());
		rockList.remove(getNearestRock());
		
		Grid result1 = aStarSearch(avatarGrid, endGrid);		
		addPath(result1, pathList);
		Grid resultGrid = result1;
		while(rockList.size() > 0) {
			Grid end = new Grid(getNearestRock().getxCoor(), getNearestRock().getyCoor());
			rockList.remove(getNearestRock());
			resultGrid = aStarSearch(resultGrid, end);
			addPath(resultGrid, pathList);
		}		
		return pathList;
	}
	
	public void checkPath() {
	}
	
	public boolean execute(String[] args) {	
		
		return true;
	}
}