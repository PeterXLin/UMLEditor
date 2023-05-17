package mode;

import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import UMLObject.UMLObject;
import midterm_project.components.MyCanvas;

public class CanvasSelectMode implements CanvasMode{
	Point startPoint;
	Component dragComponent;
	Point dragOffset;
	
	public CanvasSelectMode() {
	}

	@Override
	public void mouseClicked(MyCanvas canvas,  MouseEvent e) {
		Component clickedObj = canvas.getComponentAt(e.getPoint());
		canvas.deSelectAllObject();
		if (clickedObj == null || clickedObj == canvas) {
			// startPoint = e.getPoint();
			// System.out.println(clickedObj.getClass());
		} else {
			for (UMLObject temp: canvas.objectList) {
				if (clickedObj == temp.getObject()) {
					temp.setSelected(true);
					System.out.println(temp.getObject().getClass());
					// System.out.println("change select state");
				}
			}
		}
		// only clean up the region that layout manager think it's dirty
		canvas.revalidate();
		// System.out.println(canvas.getLayout().toString());
	}

	@Override
	public void mousePressed(MyCanvas canvas, MouseEvent e) {
		// start point == null -> user not click on obj  
		if (canvas.getComponentAt(e.getPoint()) == canvas) { // for group select 
			startPoint = e.getPoint();
			canvas.deSelectAllObject();
			canvas.revalidate();
		} else { // for object move
			dragComponent = canvas.getComponentAt(e.getPoint());
			dragOffset = new Point(e.getX() - dragComponent.getX(),
					e.getY() - dragComponent.getY());
		}
	}

	@Override
	public void mouseReleased(MyCanvas canvas, MouseEvent e) {
		dragComponent = null;
		dragOffset = null;
		if (startPoint == null) return;
		
		Boolean someObjSelected = false;
		Point endPoint = e.getPoint();
		Point leftUp = startPoint.getX() < endPoint.getX() ? startPoint: endPoint;
		Point rightDown = startPoint.getX() > endPoint.getX() ? startPoint: endPoint;
		for (UMLObject temp: canvas.objectList) {
//			// only basic object can be group select
//			if (temp.getConnectable()) {
				Rectangle tempP = temp.getBounds();
				// if in region
				if ((leftUp.getX() <= tempP.x && leftUp.getY() <= tempP.y) &&
						(rightDown.getX() >= tempP.x+tempP.width && rightDown.getY() >= tempP.getY() + tempP.height)) {
					temp.setSelected(true);
					someObjSelected = true;
				}
//			}
		}
		
		if (!someObjSelected) canvas.deSelectAllObject();
		canvas.revalidate();
		
		startPoint = null;
	}

	@Override
	public void mouseDragged(MyCanvas canvas, MouseEvent e) {
		if (dragComponent != null && dragOffset != null) {
			int deltaX = (int) (e.getX() - dragOffset.getX());
			int deltaY = (int) (e.getY() - dragOffset.getY());
			dragComponent.setLocation(deltaX, deltaY);
			System.out.println("mouse dragged repaint");
			canvas.repaint();
		}
	}

}
