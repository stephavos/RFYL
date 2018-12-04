package view;

/**
 * @author Sutibun
 *
 */
public interface IView {
    void displayMessage(String message);
	void setDisplay(Display Display);
	void setHeight(int height);
	void setWidth(int width);
}