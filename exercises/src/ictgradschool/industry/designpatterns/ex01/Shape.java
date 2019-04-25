package ictgradschool.industry.designpatterns.ex01;

/**
 * Abstract superclass to represent the general concept of a ictgradschool.industry.designpatterns.ex01.Shape. This class
 * defines state common to all special kinds of ictgradschool.industry.designpatterns.ex01.Shape instances and implements
 * a common movement algorithm. ictgradschool.industry.designpatterns.ex01.Shape subclasses must override method paint()
 * to handle shape-specific painting.
 * 
 * @author Ian Warren
 *
 */
public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;
	
	protected static final int DEFAULT_Y_POS = 0;
	
	protected static final int DEFAULT_DELTA_X = 5;
	
	protected static final int DEFAULT_DELTA_Y = 5;
	
	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;
	// ===

	// === Instance variables, accessible by subclasses.
	protected int fX;

	protected int fY;

	protected int fDeltaX;

	protected int fDeltaY;

	protected int fWidth;

	protected int fHeight;
	// ===

	/**
	 * Creates a ictgradschool.industry.designpatterns.ex01.Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a ictgradschool.industry.designpatterns.ex01.Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a ictgradschool.industry.designpatterns.ex01.Shape instance with specified x, y, deltaX and deltaY values.
	 * The ictgradschool.industry.designpatterns.ex01.Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a ictgradschool.industry.designpatterns.ex01.Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		fX = x;
		fY = y;
		fDeltaX = deltaX;
		fDeltaY = deltaY;
		fWidth = width;
		fHeight = height;
	}
	
	/**
	 * Moves this ictgradschool.industry.designpatterns.ex01.Shape object within the specified bounds. On hitting a
	 * boundary the ictgradschool.industry.designpatterns.ex01.Shape instance bounces off and back into the two-
	 * dimensional world. 
	 * @param width width of two-dimensional world.
	 * @param height height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = fX + fDeltaX;
		int nextY = fY + fDeltaY;

		if (nextX <= 0) {
			nextX = 0;
			fDeltaX = -fDeltaX;
		} else if (nextX + fWidth >= width) {
			nextX = width - fWidth;
			fDeltaX = -fDeltaX;
		}

		if (nextY <= 0) {
			nextY = 0;
			fDeltaY = -fDeltaY;
		} else if (nextY + fHeight >= height) {
			nextY = height - fHeight;
			fDeltaY = -fDeltaY;
		}

		fX = nextX;
		fY = nextY;
	}

	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * @param painter the ictgradschool.industry.designpatterns.ex01.Painter object used for drawing.
	 */
	public abstract void paint(Painter painter);

	/**
	 * Returns this ictgradschool.industry.designpatterns.ex01.Shape object's x position.
	 */
	public int getX() {
		return fX;
	}
	
	/**
	 * Returns this ictgradschool.industry.designpatterns.ex01.Shape object's y position.
	 */
	public int getY() {
		return fY;
	}
	
	/**
	 * Returns this ictgradschool.industry.designpatterns.ex01.Shape object's speed and direction.
	 */
	public int getDeltaX() {
		return fDeltaX;
	}
	
	/**
	 * Returns this ictgradschool.industry.designpatterns.ex01.Shape object's speed and direction.
	 */
	public int getDeltaY() {
		return fDeltaY;
	}
	
	/**
	 * Returns this ictgradschool.industry.designpatterns.ex01.Shape's width.
	 */
	public int getWidth() {
		return fWidth;
	}
	
	/**
	 * Returns this ictgradschool.industry.designpatterns.ex01.Shape's height.
	 */
	public int getHeight() {
		return fHeight;
	}
	
	/**
	 * Returns a String whose value is the name of this class, not including the package name.
	 * <p>To include the package name, use getName() instead of getSimpleName().</p>
	 */
	public String toString() {
		return getClass().getSimpleName();
	}
}
