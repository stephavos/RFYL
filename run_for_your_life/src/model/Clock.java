package model;
/**
 * 
 * @author Sutibun
 *
 */
public class Clock implements IClock{
	private double clock;
	
	public Clock(){
		clock=0;
	}
	
	/* (non-Javadoc)
	 * @see model.IClock#start()
	 */
	public void start() {
		this.clock=System.currentTimeMillis();
	}
	
	/* (non-Javadoc)
	 * @see model.IClock#stop()
	 */
	public void stop() {
		this.clock=(System.currentTimeMillis()-clock)/1000;
	}

	/* (non-Javadoc)
	 * @see model.IClock#getTime()
	 */
	public double getTime() {
		return this.clock;
	}
	
}