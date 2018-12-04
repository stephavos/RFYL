package main;

import Controller.Controller;

import model.ILvl;
import model.Lvl;
import view.Frame;
import view.IView;
/**
 * 
 * @author Sutibun
 *
 * Main class
 */
public abstract class Main {

    public static void main(final String[] args) {
    	    	
    	ILvl Lvl = new Lvl();
    	IView view = new Frame(Lvl);
    	
    	Controller controller = new Controller(Lvl , view);
    	controller.play();
    }

}