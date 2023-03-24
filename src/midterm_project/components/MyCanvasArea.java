package midterm_project.components;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;

import java.util.List;
import java.util.ArrayList;

import mode.*;


public class MyCanvasArea extends GUIComponent{	
	private MyCanvas canvas;
	
	public MyCanvasArea() {
		canvas = new MyCanvas();

		CanvasMode[] allCanvasModes = {new CanvasSelectMode(), new CanvasAssociationLineMode(), new CanvasGeneralizationLineMode(),
				new CanvasCompositionLineMode(), new CanvasClassMode(), new CanvasUseCaseMode()};
		
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mouseClicked(e);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mousePressed(e);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mouseReleased(e);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				allCanvasModes[currentMode.ordinal()].mouseDragged(e);
			}
		};
		
		canvas.addMouseListener(ma);
		canvas.addMouseMotionListener(ma);
	}
	
	public MyCanvas getMyCanvas() {
		return this.canvas;
	}
}



class MyCanvas extends JPanel {
	/**
	 * I don't know why I need this, but compiler suggested
	 */
	private static final long serialVersionUID = 6701031330107974482L;
	
	private List<Component[]> associationLine; 
	private List<Component[]> compositionLine;
	private List<Component[]> generalizationLine;
	
	public MyCanvas() {
		associationLine = new ArrayList<>();
		compositionLine = new ArrayList<>();
		generalizationLine = new ArrayList<>();
	}
	
}
