
package model;

import java.awt.Color;

/**
 * @author Sutibun
 *
 */
public class runner extends Element implements IRunner{
	private boolean alive = true;
	public Lvl level;
	private Lvl lvl;
	
	/**
	 * @param x
	 * @param y
	 * @param level
	 */
	public runner(int x, int y, Lvl level) {
		super(x, y);
		this.setColor(Color.BLUE);
		this.lvl = level;
	}
	
	
	/**
	 * @param x
	 * @param y
	 */
	public void moveToXY(int x , int y) {
		for (ITile elem : ((ILvl) lvl).getMap()) {
			if(elem.getX() == this.x && elem.getY()==this.y) {
				if(elem.getColor()==Color.BLACK) {
					this.setAlive(false);
					System.out.println("Vous �tes mort!");
				}
				elem.setActivated(true);
				
			}
			
		}
		
		this.x=x;
		this.y=y;
		this.setChanged();
		this.notifyObservers();

		for (ITile elem : ((ILvl) lvl).getMap()) {
			if(elem.getX() == this.x && elem.getY()==this.y) {
				if(elem.getColor()==Color.BLACK) {
					this.setAlive(false);
					System.out.println("Vous �tes mort!");
				}
				elem.setActivated(true);
				
			}
			
		}
	}
	public void moveUP()    {this.moveToXY(x, y-1);}
	public void moveDOWN()  {this.moveToXY(x, y+1);}
	public void moveLEFT()  {this.moveToXY(x-1, y);}
	public void moveRIGHT() {this.moveToXY(x+1, y);}
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}