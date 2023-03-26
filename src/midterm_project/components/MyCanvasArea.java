package midterm_project.components;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;

import java.util.List;
import java.util.ArrayList;

import mode.*;
import UMLObject.*;


public class MyCanvasArea extends GUIComponent{	
	private MyCanvas canvas;
	
	public MyCanvasArea() {
		canvas = new MyCanvas();
		
		CanvasMode[] allCanvasModes = {new CanvasSelectMode(), new CanvasConnectionLineMode(ConnectionType.Association), 
				new CanvasConnectionLineMode(ConnectionType.Generalization), new CanvasConnectionLineMode(ConnectionType.Composition),
				new CanvasClassMode(), new CanvasUseCaseMode()};
		
		// System.out.println("default layout: " + canvas.getLayout().toString());
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mouseClicked(canvas, e);
				// canvas.revalidate();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mousePressed(canvas, e);
				// canvas.repaint();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mouseReleased(canvas, e);
				// canvas.repaint();

			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mouseDragged(canvas, e);
				// canvas.repaint();
			}
		};
		
		canvas.addMouseListener(ma);
		canvas.addMouseMotionListener(ma);
	}
	
	public MyCanvas getMyCanvas() {
		return this.canvas;
	}
}




