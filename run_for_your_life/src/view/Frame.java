package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ILvl;

/**
 * @author Sutibun
 *
 */
public class Frame extends JFrame implements KeyListener, IView {
	
	private static final long serialVersionUID = -7393744101067014109L;
	private int width;
	private int height;
	private Display display;
	private ILvl Lvl;
	
	/**
	 * @param Lvl
	 */
	public Frame(ILvl Lvl) {
		this.setTitle("Run-for-your-life");
		this.Lvl = Lvl;
		this.width=Lvl.getWidth()*Lvl.getPixels();
		this.height=(Lvl.getHeight()+1)*Lvl.getPixels();
		this.display = new Display(this.Lvl);
	    this.setContentPane(this.display);
	    this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.addKeyListener(this);
		this.setVisible(true);
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
  	
  	switch(keyEvent.getKeyCode()) {
	  	case KeyEvent.VK_RIGHT: Lvl.getrunner().moveRIGHT();break;
	  	case KeyEvent.VK_LEFT: Lvl.getrunner().moveLEFT();break;
	  	case KeyEvent.VK_UP: Lvl.getrunner().moveUP();break;
	  	case KeyEvent.VK_DOWN: Lvl.getrunner().moveDOWN();break;
	  	default:break; 		  	
  		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public final void keyTyped(final KeyEvent keyEvent) {
		this.keyCodeToUserOrder(keyEvent.getKeyCode());
	}
	    
	/**
	 * @param keyCode
	 */
	private void keyCodeToUserOrder(int keyCode) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#repaint()
	 */
	public void repaint() {
		this.display.repaint();
	}

	/**
	 * @return
	 */
	public Display getDisplay() {
		return display;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#getWidth()
	 */
	public int getWidth() {
		return width;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#getHeight()
	 */
	public int getHeight() {
		return height;
	}	
	
	/* (non-Javadoc)
	 * @see view.IView#setDisplay(view.Display)
	 */
	public void setDisplay(Display Display) {
		this.display = Display;	
	}
	
	/* (non-Javadoc)
	 * @see view.IView#setWidth(int)
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/* (non-Javadoc)
	 * @see view.IView#setHeight(int)
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/* (non-Javadoc)
	 * @see view.IView#displayMessage(java.lang.String)
	 */
	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));	
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}