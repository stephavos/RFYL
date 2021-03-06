package model;

/**
 * @author Sutibun
 *
 */

public interface IRunner extends IElement{
	public void moveUP();
	public void moveDOWN();
	public void moveLEFT();
	public void moveRIGHT();
	/**
	 * @return
	 */
	public boolean isAlive();
	/**
	 * @param b
	 */
	public void setAlive(boolean b);
}