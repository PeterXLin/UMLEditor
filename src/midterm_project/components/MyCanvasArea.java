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
	private List<UMLObject> allUMLObject;
	
	public MyCanvasArea() {
		canvas = new MyCanvas();
		allUMLObject = new ArrayList<>();

		CanvasMode[] allCanvasModes = {new CanvasSelectMode(), new CanvasAssociationLineMode(), new CanvasGeneralizationLineMode(),
				new CanvasCompositionLineMode(), new CanvasClassMode(), new CanvasUseCaseMode()};
		
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mouseClicked(canvas, e);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mousePressed(canvas, e);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mouseReleased(canvas, e);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mouseDragged(canvas, e);
			}
		};
		
		canvas.addMouseListener(ma);
		canvas.addMouseMotionListener(ma);
	}
	
	public MyCanvas getMyCanvas() {
		return this.canvas;
	}
}




