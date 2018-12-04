package model;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import model.dao.Datamanager;

/**
 * @author Sutibun
 *
 */
public class Lvl implements ILvl{
	public IRunner runner;
	private int width = 30;
	private int height = 20;
	private int pixels = 30;
	private IClock clock = new Clock();
	private Datamanager db = new Datamanager();
	public IRunner getrunner() {
		return runner;
	}
	
	public Lvl() {
		this.generate();
		this.placerunner();
	}

	private ArrayList<ITile> map;
	
	public void generate() {
		setMap(new ArrayList<ITile>());
		for(int posx = 0 ; posx < width ; posx ++) {
			for(int posy = 0 ; posy < height ; posy ++ ) {
				if(posx == 0 || posx == width-1 || posy == 0 || posy == height-1)
					
					getMap().add( new Tile(posx,posy,Color.black));
				else {
					Random rand = new Random();
					int  r = rand.nextInt(100);
					if(r>85) {
						getMap().add(new Tile(posx,posy,Color.black));
					}
					else {
						getMap().add(new Tile(posx,posy,Color.GRAY));
					}
				}
			}
		}
	}
	
	public void placerunner() {
		boolean validate = false;
		do {
			Random rand = new Random();
			int  posx = rand.nextInt(width);
			rand = new Random();
			int  posy = rand.nextInt(height);
			
			for (ITile element : getMap()) {
				if(posx == element.getX() && posy ==element.getY() && element.getColor()==Color.GRAY)
					validate=true;
					runner = new runner(posx, posy,this);
			}
		}while(!validate);

	}

	/* (non-Javadoc)
	 * @see model.ILvl#getMap()
	 */
	public ArrayList<ITile> getMap() {
		return map;
	}

	/**
	 * @param map
	 */
	public void setMap(ArrayList<ITile> map) {
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see model.ILvl#getPixels()
	 */
	public int getPixels() {
		return pixels;
	}

	/**
	 * @param pixels
	 */
	public void setPixels(int pixels) {
		this.pixels = pixels;
	}
	
	/* (non-Javadoc)
	 * @see model.ILvl#getWidth()
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/* (non-Javadoc)
	 * @see model.ILvl#getHeight()
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/* (non-Javadoc)
	 * @see model.ILvl#getClock()
	 */
	public IClock getClock() {
		return clock;
	}

	/**
	 * @param Clock
	 */
	public void setClock(IClock Clock) {
		this.clock = Clock;
	}
	
	/**
	 * @return
	 */
	public Datamanager getDb() {
		return db;
	}

	/**
	 * @param db
	 */
	public void setDb(Datamanager db) {
		this.db = db;
	}

	/* (non-Javadoc)
	 * @see model.ILvl#getTimer()
	 */
	public IClock getTimer() {
		return clock;
	}

	/* (non-Javadoc)
	 * @see model.ILvl#save(java.lang.String)
	 */
	public void save(String scr) {

	}
	
}