package mode;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import UMLObject.BasicObject;
import UMLObject.ConnectionLine;
import UMLObject.ConnectionType;
import UMLObject.Port;
import UMLObject.UMLObject;
import midterm_project.components.MyCanvas;

public class CanvasConnectionLineMode implements CanvasMode{
	UMLObject startObject, endObject;
	Port startPort, endPort;
	Point startPoint = null;
	Boolean mouseDragged = false;
	private ConnectionType type = null;
	
	public CanvasConnectionLineMode() {
		this(ConnectionType.Association);
	}
	
	public CanvasConnectionLineMode(ConnectionType type) {
		this.type = type;
	}

	@Override
	public void mouseClicked(MyCanvas canvas, MouseEvent e) {
		// do nothing
	}

	@Override
	public void mousePressed(MyCanvas canvas, MouseEvent e) {
		Component start = canvas.getComponentAt(e.getPoint());
		// must click on some Component except itself
		if (start == null || start == canvas) {
			startObject = null;
			startPort = null;
			startPoint = null;
		} else {
			// match UMLObject and java.awt.Component
			for (UMLObject temp: canvas.objectList) {
				if (temp.getObject() == start) {
					startObject = temp;
				}
			}
			
			// must be basic object 
			if (startObject.getConnectable()) {
				BasicObject tempObj = (BasicObject) startObject;
				startPort = tempObj.getPort(e.getPoint());
				startPoint = e.getPoint();
			} else {
				startObject = null;
			}
		}
	}

	@Override
	public void mouseReleased(MyCanvas canvas, MouseEvent e) {
		// the first clicked object must be a basic object
		if (startObject != null) {
			// System.out.println(startObject);
			Component end = canvas.getComponentAt(e.getPoint());
			
			// the location mouse released must be some component except canvas
			// System.out.println(end);
			if (end != null && end != canvas) {
				// match UMLObject and java.awt.Component
				for (UMLObject temp: canvas.objectList) {
					if (temp.getObject() == end) {
						endObject = temp;
					}
				}
				
				// the object that mouse released on must be a basic object
				if (endObject.getConnectable()) {
					// avoid click
					if (endObject != startObject) {
						BasicObject tempObj = (BasicObject) endObject;
						endPort = tempObj.getPort(e.getPoint());
						canvas.addConnection(this.type, startObject, startPort, 
								endObject, endPort);
					}
				}

			}
			
//			startObject = null;
//			startPort = null;
//			startPoint = null;
//			endObject = null;
//			endPort = null;
		}
		startObject = null;
		startPort = null;
		startPoint = null;
		endObject = null;
		endPort = null;
		canvas.repaint();
	}

	
	@Override
	public void mouseDragged(MyCanvas canvas, MouseEvent e) {
		if (startPoint != null && startObject != null) {
			mouseDragged = true;
			canvas.setTempConnectionLine(
					new ConnectionLine(this.type, (BasicObject) startObject, startPort, null, null), 
					e.getPoint());
			canvas.repaint();
		}
	}
}
