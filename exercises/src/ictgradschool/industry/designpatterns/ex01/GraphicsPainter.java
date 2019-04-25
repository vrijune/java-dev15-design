package ictgradschool.industry.designpatterns.ex01;

import java.awt.*;

/**
 * Implementation of the ictgradschool.industry.designpatterns.ex01.Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Ian Warren
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics g;

	/**
	 * Creates a ictgradschool.industry.designpatterns.ex01.GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this.g = g;
	}


	@Override
	public void drawRect(int x, int y, int width, int height) {
		g.drawRect(x, y, width, height);
	}


	@Override
	public void drawOval(int x, int y, int width, int height) {
		g.drawOval(x, y, width, height);
	}


	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		g.drawLine(x1, y1, x2, y2);
	}


	@Override
	public void setColor(Color color) {
		g.setColor(color);
	}


	@Override
	public Color getColor() {
		return g.getColor();
	}

    @Override
    public void drawPolygon(Polygon polygon) {
        g.drawPolygon(polygon);
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        g.fillRect(x, y, width, height);
    }

    @Override
    public void drawImage(Image img, int x, int y, int width, int height) {
	    g.drawImage(img, x, y, width, height, null);
    }

	@Override
	public void translate(int x, int y) {
		g.translate(x, y);
	}
}
