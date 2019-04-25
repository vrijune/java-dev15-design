package ictgradschool.industry.designpatterns.ex01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases to test classes ictgradschool.industry.designpatterns.ex01.Shape/ictgradschool.industry.designpatterns.ex01.RectangleShape.
 * 
 * @author Ian Warren
 */
public class TestShape  {
	private MockPainter painter;

	@Before
	public void setUp() {
		painter = new MockPainter();
	}

	@Test
	public void testSimpleMove() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(painter);
		shape.move(500, 500);
		shape.paint(painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)", 
				painter.toString());
	}

    @Test
	public void testShapeMoveWithBounceOffRight() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(painter);
		shape.move(135, 10000);
		shape.paint(painter);
		shape.move(135, 10000);
		shape.paint(painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 110,35,25,35)"
				+ "(rectangle 98,50,25,35)", painter.toString());
	}

    @Test
	public void testShapeMoveWithBounceOffLeft() {
		RectangleShape shape = new RectangleShape(10, 20, -12, 15);
		shape.paint(painter);
		shape.move(10000, 10000);
		shape.paint(painter);
		shape.move(10000, 10000);
		shape.paint(painter);
		assertEquals("(rectangle 10,20,25,35)(rectangle 0,35,25,35)"
				+ "(rectangle 12,50,25,35)", painter.toString());
	}

    @Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		RectangleShape shape = new RectangleShape(10, 90, -12, 15);
		shape.paint(painter);
		shape.move(125, 135);
		shape.paint(painter);
		shape.move(125, 135);
		shape.paint(painter);
		assertEquals("(rectangle 10,90,25,35)(rectangle 0,100,25,35)"
				+ "(rectangle 12,85,25,35)", painter.toString());
	}
}
