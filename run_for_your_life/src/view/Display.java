package view;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.ILvl;
import model.ITile;

/**
 * @author Sutibun
 *
 */
public class Display extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private ILvl Lvl;
	
	/**
	 * @param Lvl
	 */
	public Display(ILvl Lvl) {
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		System.out.println("Affichage");
		this.Lvl = Lvl;
		
		for (ITile tile : Lvl.getMap()) {
			((Observable) tile).addObserver(this);
		}
		((Observable) Lvl.getrunner()).addObserver(this);
		
	}
	
	/**
	 * @param g
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void drawGrid(Graphics g)throws IOException, InterruptedException {
		for (ITile tile : Lvl.getMap()) {
			g.setColor(tile.getColor());
			g.fillRect(
					tile.getX()*Lvl.getPixels(),
					tile.getY()*Lvl.getPixels(),
					Lvl.getPixels(),
					Lvl.getPixels()
					);
		}
		
		g.setColor(Lvl.getrunner().getColor());
		g.fillRect(
			Lvl.getrunner().getX()*Lvl.getPixels(),
			Lvl.getrunner().getY()*Lvl.getPixels(),
			Lvl.getPixels(),
			Lvl.getPixels());
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			 try {
				drawGrid(g);
			} 
			 catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
	     
	}
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}

}