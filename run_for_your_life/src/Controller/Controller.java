package Controller;

import java.awt.Color;
import java.util.Scanner;
import model.ILvl;
import model.ITile;
import view.IView;
/**
 * 
 * @author Sutibun
 *
 */
public class Controller implements IController{
	
	public ILvl lvl;
	public IView view;
	int countgrey;
	private Scanner sc;
/**
 * 
 * @param lvl
 * @param view
 */
	public  Controller(ILvl lvl, IView view) {
		this.view= view;
		this.lvl=lvl;
	}
	/**
	 * Start game
	 */
	/* (non-Javadoc)
	 * @see Controller.IController#play()
	 */
	public void play() {
		lvl.getTimer().start();
		System.out.println("Play");
		while(lvl.getrunner().isAlive() && countgrey!=1){
		
		countgrey=0;	
		for (ITile tile : lvl.getMap()) {
			tile.reduce();
			countgrey +=(tile.getColor()==Color.GRAY)?1:0;
			if(tile.getX()==lvl.getrunner().getX()&& tile.getY()==lvl.getrunner().getY() && tile.getColor()==Color.BLACK) {
				lvl.getrunner().setAlive(false);
			}
		}
		try {
			Thread.sleep(10);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
		lvl.getTimer().stop();

		/**
		 * If player Win
		 */
		if(countgrey==1){

			sc = new Scanner(System.in);
			System.out.println("Veuillez saisir votre nom :");
			String scr = sc.nextLine();
			lvl.save(scr);
			this.view.displayMessage("Vous avez gagn�! Bravo vous avez r�ussi le jeu en : " + lvl.getTimer().getTime());
			System.out.println("Saved");
		}
		/**
		 * If player loose
		 */
		else{
			System.out.println("Veuillez saisir votre nom :");
			this.view.displayMessage("Vous avez perdu! D�soler vous avez surv�cu pendant : " + lvl.getTimer().getTime());

		}
	}
}
