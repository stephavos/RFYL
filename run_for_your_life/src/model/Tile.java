package model;

import java.awt.Color;

/**
 * @author Sutibun
 *
 */
public class Tile extends Element implements ITile{

	/**
	 * @param x
	 * @param y
	 * @param color
	 */
	public Tile(int x, int y , Color color) {
		super(x, y);
		this.setColor(color);
		if(color == Color.BLACK) {
			this.counter = 0;
		}
		else {this.counter=500;}
	}
	
	private boolean activated = false;
	private int counter;

	/* (non-Javadoc)
	 * @see model.ITile#reduce()
	 */
	public void reduce() {
		if(activated) {
			this.counter --;
			this.setColor(Color.RED);
			this.setChanged();
			this.notifyObservers();
		}
		if(counter<=0)
			this.setColor(Color.BLACK);
	}
	
	/* (non-Javadoc)
	 * @see model.ITile#getCounter()
	 */
	public int getCounter() {
		return this.counter;
	}

	/**
	 * @return
	 */
	public boolean isActivated() {
		return activated;
	}

	/* (non-Javadoc)
	 * @see model.ITile#setActivated(boolean)
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
}