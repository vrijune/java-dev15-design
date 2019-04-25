package ictgradschool.industry.designpatterns.ex02;

import ictgradschool.industry.designpatterns.ex01.DynamicRectangleShape;
import ictgradschool.industry.designpatterns.ex01.GemShape;
import ictgradschool.industry.designpatterns.ex01.GraphicsPainter;
import ictgradschool.industry.designpatterns.ex01.ImageShape;
import ictgradschool.industry.designpatterns.ex01.NestingShape;
import ictgradschool.industry.designpatterns.ex01.OvalShape;
import ictgradschool.industry.designpatterns.ex01.Painter;
import ictgradschool.industry.designpatterns.ex01.RectangleShape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Simple GUI program to show an animation of shapes. Class ictgradschool.industry.designpatterns.ex01.AnimationViewer is a
 * special kind of GUI component (JPanel), and as such an instance of ictgradschool.industry.designpatterns.ex01.AnimationViewer
 * can be added to a JFrame object. A JFrame object is a window that can be closed, minimised, and maximised. The state
 * of a ictgradschool.industry.designpatterns.ex01.AnimationViewer object comprises a list of Shapes and a Timer object. An
 * ictgradschool.industry.designpatterns.ex01.AnimationViewer instance subscribes to events that are published by a Timer. In
 * response to receiving an event from the Timer, the ictgradschool.industry.designpatterns.ex01.AnimationViewer iterates through
 * a list of Shapes requesting that each ictgradschool.industry.designpatterns.ex01.Shape paints and moves itself.
 * 
 * @author Ian Warren
 */
public class Ex02AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds to generate ActionEvents.
	private final int DELAY = 20;

	private NestingShape root;

	private Timer timer = new Timer(DELAY, this);

	/**
	 * Creates an ictgradschool.industry.designpatterns.ex01.AnimationViewer instance with a list of
	 * ictgradschool.industry.designpatterns.ex01.Shape objects and starts the animation.
	 */
	public Ex02AnimationViewer(JTree treeView) {

		root = new NestingShape(0, 0, 0, 0, 499, 499);

		// Populate the list of Shapes.
		root.add(new RectangleShape(0, 0, 2, 3));
		root.add(new RectangleShape(10, 10, 5, 7));

		// Add some basic shapes
		root.add(new OvalShape(15, 50, 3, 2, 40, 40));
		root.add(new GemShape(100, 200, 3, 2, 100, 40));
		root.add(new GemShape(200, 100, 4, 5, 40, 40));
		root.add(new DynamicRectangleShape(300, 200, 5, 7, 30, 50, Color.red));

		NestingShape topLevelNest = new NestingShape(0, 0, 2, 2, 200, 200);
		NestingShape midLevelNest = new NestingShape(0, 0, 2, 2, 100, 100);
		NestingShape bottomLevelNest = new NestingShape(5, 5, 2, 2, 75, 75);
		ImageShape tRex = new ImageShape(20, 20, 3, 4, "TRex.png", 0.2);
		RectangleShape simpleShape = new RectangleShape(1, 1, 1, 1, 5, 5);

		midLevelNest.add(bottomLevelNest);
		midLevelNest.add(tRex);
		topLevelNest.add(midLevelNest);
		bottomLevelNest.add(simpleShape);

		root.add(topLevelNest);

		// TODO Display the root shape in the provided JTree.
		// HINT: Use the adapter pattern as shown in lectures.

		// Start the animation.
		timer.start();
	}

	/**
	 * Called by the Swing framework whenever this ictgradschool.industry.designpatterns.ex01.AnimationViewer object should be
	 * repainted. This can happen, for example, after an explicit repaint() call or after the window that contains this
	 * ictgradschool.industry.designpatterns.ex01.AnimationViewer object has been exposed after being hidden by another window.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);

		// Create a ictgradschool.industry.designpatterns.ex01.GraphicsPainter that ictgradschool.industry.designpatterns.ex01.Shape
		// objects will use for drawing.
		// The ictgradschool.industry.designpatterns.ex01.GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);

		// Draw all shapes
		root.paint(painter);

	}

	/**
	 * Notifies this ictgradschool.industry.designpatterns.ex01.AnimationViewer object of an ActionEvent.
	 */
	public void actionPerformed(ActionEvent e) {

		// Calculate bounds of animation screen area.
		int width = getWidth();
		int height = getHeight();

		// Move all shapes
		root.move(width, height);

		// Request that we redraw ourselves.
		repaint();
	}

	/**
	 * Main program method to create an ictgradschool.industry.designpatterns.ex01.AnimationViewer object and display this within
	 * a JFrame window.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame("Animation viewer");

				JPanel contentPane = new JPanel();
				contentPane.setLayout(new BorderLayout());

				JTree treeView = new JTree();
				treeView.setPreferredSize(new Dimension(300, 0));
				contentPane.add(treeView, BorderLayout.WEST);

				Ex02AnimationViewer animationViewer = new Ex02AnimationViewer(treeView);
				animationViewer.setPreferredSize(new Dimension(500, 500));
				contentPane.add(animationViewer, BorderLayout.CENTER);

				// Set window properties.
				frame.setContentPane(contentPane);
				frame.setResizable(false);
				frame.pack();
				frame.setLocationRelativeTo(null); // Center in screen
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}
