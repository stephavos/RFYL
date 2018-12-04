package model;

/**
 * @author Sutibun
 *
 */
public interface ITile extends IElement{
	public void reduce();
	public int getCounter();
	public void setActivated(boolean activated);
}