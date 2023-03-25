package mode;

import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Point;
import java.util.List;

import UMLObject.UMLObject;
import midterm_project.components.MyCanvas;

public class CanvasSelectMode implements CanvasMode{
	Point startPoint;
	
	public CanvasSelectMode() {
	}

	@Override
	public void mouseClicked(MyCanvas canvas,  MouseEvent e) {
		Component temp = canvas.getComponentAt(e.getPoint());
		canvas.deSelectAllObject();
		if (temp == null || temp == canvas) {
			startPoint = e.getPoint();
		} else {
			
		}
	}

	@Override
	public void mousePressed(MyCanvas canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MyCanvas canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MyCanvas canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
