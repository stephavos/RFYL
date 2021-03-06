package model;

import java.util.ArrayList;
/**
 * 
 * @author Sutibun
 *
 */
public interface ILvl {
	public ArrayList<ITile> getMap();
	public int getPixels();
	public int getWidth();
	public int getHeight();
	public IRunner getrunner();
	public IClock getClock();
	public IClock getTimer();
	public void save(String scr);
}