package lab1.Map;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import lab1.MapObject.*;

public abstract class Map{
	private int length, width;

	char [][] map;
	int [][] rockLocation = null;
	int [][] wallLocation = null;
	ArrayList<MapObject> rockList;
	ArrayList<MapObject> wallList;
	ArrayList<MapObject> pathList;
	ArrayList<MapObject> trapList;
	
	private int initX, initY, initDirection;
	
	List<Character> walkableTiles = Arrays.asList('·', '*', '×');

	public Map() {
		rockList = new ArrayList<MapObject>();
		wallList = new ArrayList<MapObject>();
		pathList = new ArrayList<MapObject>();
		trapList = new ArrayList<MapObject>();
	}
	
	public void loadConfig(String filename) {
		Properties props = new Properties();
	    InputStream inputStream = null;
	    
	    try {
	        inputStream = getClass().getClassLoader().getResourceAsStream(filename);
	        props.load(inputStream);
	        
	        String[] mapSize = props.getProperty("mapSize").split(",");
	        setMapSize(Integer.parseInt(mapSize[0]), Integer.parseInt(mapSize[1]));
	        
	        String[] avatarLocation = props.getProperty("avatarLocation").split(",");
	        setInitX(Integer.parseInt(avatarLocation[0]));
	        setInitY(Integer.parseInt(avatarLocation[1]));
	        
	        String avatarDirection = props.getProperty("avatarDirection");
	        setInitDirection(Integer.parseInt(avatarDirection));
	        
	        if(props.getProperty("rockLocation") != null) {
	        	String[] rockLocation = props.getProperty("rockLocation").split("\\|");
	        	for (String rockString : rockLocation) {
		            String[] coor = rockString.split(",");
		            MapObject rock = new Rock(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
		            rockList.add(rock);	
		        }   
	        }
	        
	        if(props.getProperty("wallLocation") != null){
	        	String[] wallLocation = props.getProperty("wallLocation").split("\\|");	        
	        	for (String wallString : wallLocation) {
		            String[] coor = wallString.split(",");
		            MapObject wall = new Wall(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
		            wallList.add(wall);	
	        	}   	        
	        }
	                
	        if(props.getProperty("trapLocation") != null){
	        	String[] trapLocation = props.getProperty("trapLocation").split("\\|");
	        	for (String trapString : trapLocation) {
		            String[] coor = trapString.split(",");
		            MapObject trap = new Trap(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
		            trapList.add(trap);	
		        }        
	        }	        
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (inputStream != null) {
	            try {
	                inputStream.close();
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	}
	
	public void fillMap(MapObject avatar) {
		for (char[] row : map) {
		    Arrays.fill(row, '·');
		}
		if(!rockList.isEmpty()) {
			for(MapObject rock : rockList) {
				rock.placeObject(this);
			}
		}
		if(!wallList.isEmpty()) {
			for(MapObject wall : wallList) {
				wall.placeObject(this);
			}
		}		
		if(!pathList.isEmpty()) {
			for(MapObject path : pathList) {
				path.placeObject(this);
			}
		}
		if(!trapList.isEmpty()) {
			for(MapObject trap : trapList) {
				trap.placeObject(this);
			}
		}
		avatar.placeObject(this);
	}
	
	public void printMap() {
		for (char[] row : map) {
		    for (char c : row) {
		        System.out.print(c + " ");
		    }
		    System.out.println();
		}
	}
	
	public void reloadMap(MapObject avatar) {	
		fillMap(avatar);	
		printMap();
	}
	
	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}
	
	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}

	public ArrayList<MapObject> getRockList() {
		return rockList;
	}

	public void setRockList(ArrayList<MapObject> rockList) {
		this.rockList = rockList;
	}

	public ArrayList<MapObject> getWallList() {
		return wallList;
	}

	public void setWallList(ArrayList<MapObject> wallList) {
		this.wallList = wallList;
	}
	
	public void setPathList(ArrayList<MapObject> pathList) {
		this.pathList = pathList;
	}

	public ArrayList<MapObject> getTrapList() {
		return trapList;
	}

	public void setTrapList(ArrayList<MapObject> trapList) {
		this.trapList = trapList;
	}

	public int getInitX() {
		return initX;
	}

	public void setInitX(int initX) {
		this.initX = initX;
	}

	public int getInitY() {
		return initY;
	}

	public void setInitY(int initY) {
		this.initY = initY;
	}

	public int getInitDirection() {
		return initDirection;
	}

	public void setInitDirection(int initDirection) {
		this.initDirection = initDirection;
	}
	
	public void setMapSize(int length, int width) {			
		this.length = length;
		this.width = width;
		this.map = new char[length][width];
	}
	
	public List<Character> getWalkableTiles() {
		return walkableTiles;
	}
}