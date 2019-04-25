package ictgradschool.industry.designpatterns.ex01;

import java.awt.*;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Ian Warren
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);

	/**
	 * Sets the color of this ictgradschool.industry.designpatterns.ex01.Painter to the given value.
	 */
	public void setColor(Color color);

	/**
	 * Gets the current color of this ictgradschool.industry.designpatterns.ex01.Painter.
	 */
	public Color getColor();

    /**
     * Draws a polygon.
     *
     * @param polygon
     */
    public void drawPolygon(Polygon polygon);

    /**
     * Draws a filled rectangle.
     */
    public void fillRect(int x, int y, int width, int height);

    /**
     * Draws the given Image at the given co-ordinates with the given size.
     */
    public void drawImage(Image img, int x, int y, int width, int height);

    /**
     * Translates the co-ordinate system by adding the given x and y amounts. For example:
     *
     * <p>If you call <code>drawRect(10, 10, 20, 20)</code>, a rectangle with width and height of 20 will be drawn
     * at position (10, 10).</p>
     *
     * <p>If you call <code>translate(5, 5), followed by drawRect(10, 10, 20, 20), a rectangle with width and height
     * of 20 will be drawn at position (15, 15).</code></p>
     *
     * <p>If you call <code>translate(5, 5), followed by translate(3, 3), followed by drawRect(10, 10, 20, 20),
     * a rectangle with width and height of 20 will be drawn at position (18, 18).</code></p>
     *
     * <p>Calling translate with negative values will shift the translation backwards, allowing you to undo the translation.</p>
     */
	public void translate(int x, int y);
}
