package model;

import java.awt.Color;
import java.util.Observable;

/**
 * @author Sutibun
 *
 */
public abstract class Element extends Observable{
	
	protected int x;
	protected int y;
	private Color color;
	
	/**
	 * @param x
	 * @param y
	 */
	public Element(int x, int y) {
		this.x=x;
		this.y=y;
		
	}
	
	/**
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

}