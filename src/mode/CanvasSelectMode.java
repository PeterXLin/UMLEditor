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
	
	public CanvasSelectMode() {
	}

	@Override
	public void mouseClicked(MyCanvas canvas,  MouseEvent e) {
		Component clickedObj = canvas.getComponentAt(e.getPoint());
		canvas.deSelectAllObject();
		if (clickedObj == null || clickedObj == canvas) {
			// startPoint = e.getPoint();
		} else {
			for (UMLObject temp: canvas.objectList) {
				if (clickedObj == temp.getObject()) {
					temp.setSelected(true);
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
		startPoint = canvas.getComponentAt(e.getPoint()) == canvas ? e.getPoint(): null;
		if (startPoint != null) canvas.deSelectAllObject();
		canvas.revalidate();
	}

	@Override
	public void mouseReleased(MyCanvas canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		if (startPoint == null) return;
		
		Boolean someObjSelected = false;
		Point endPoint = e.getPoint();
		Point leftUp = startPoint.getX() < endPoint.getX() ? startPoint: endPoint;
		Point rightDown = startPoint.getX() > endPoint.getX() ? startPoint: endPoint;
		for (UMLObject temp: canvas.objectList) {
			// for basic object 
			if (temp.getConnectable()) {
				Rectangle tempP = temp.getBounds();
				// if in region
				if ((leftUp.getX() <= tempP.x && leftUp.getY() <= tempP.y) &&
						(rightDown.getX() >= tempP.x+tempP.width && rightDown.getY() >= tempP.getY() + tempP.height)) {
					temp.setSelected(true);
					someObjSelected = true;
				}
			}
		}
		
		if (!someObjSelected) canvas.deSelectAllObject();
		canvas.revalidate();
	}

	@Override
	public void mouseDragged(MyCanvas canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
