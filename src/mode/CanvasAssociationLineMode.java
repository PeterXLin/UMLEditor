//package mode;
//import java.awt.event.MouseEvent;
//import java.awt.Component;
//import java.awt.Point;
//import java.util.List;
//
//
//import UMLObject.UMLObject;
//import UMLObject.Port;
//import UMLObject.ConnectionType;
//import midterm_project.components.MyCanvas;
//
//public class CanvasAssociationLineMode extends CanvasConnectionLineMode{
//	UMLObject startObject, endObject;
//	Port startPort, endPort;
//	Point startPoint = null;
//	
//	public CanvasAssociationLineMode() {
//		
//	}
//
//	@Override
//	public void mouseClicked(MyCanvas canvas, MouseEvent e) {
//		// do nothing
//	}
//
//	@Override
//	public void mousePressed(MyCanvas canvas, MouseEvent e) {
//		// TODO Auto-generated method stub
//		Component start = canvas.getComponentAt(e.getPoint());
//		if (start == null || start == canvas) {
//			startObject = null;
//			startPort = null;
//			startPoint = null;
//		} else {
//			// match UMLObject and java.awt.Component
//			for (UMLObject temp: canvas.objectList) {
//				if (temp.getObject() == start) {
//					startObject = temp;
//				}
//			}
//			
//			// TODO: get which port (based on click point)
//			startPort = Port.North;
//			startPoint = e.getPoint();
//		}
//	}
//
//	@Override
//	public void mouseReleased(MyCanvas canvas, MouseEvent e) {
//		if (startObject != null) {
//			Component end = canvas.getComponentAt(e.getPoint());
//			
//			if (end != null || end != canvas) {
//				// match UMLObject and java.awt.Component
//				for (UMLObject temp: canvas.objectList) {
//					if (temp.getObject() == end) {
//						endObject = temp;
//					}
//				}
//				
//				// TODO: get which port (based on click point) 
//				endPort = Port.North;
//				// avoid click
//				if (endObject != startObject) {
//					canvas.addConnection(ConnectionType.Association, startObject, startPort, 
//							endObject, endPort);
//				}
//
//
//			}
//			
//			startObject = null;
//			startPort = null;
//			endObject = null;
//			endPort = null;
//		}
//		canvas.repaint();
//	}
//
//	@Override
//	public void mouseDragged(MyCanvas canvas, MouseEvent e) {
//		if (startPoint != null) {
//			int mouseX = e.getX(), mouseY = e.getY();
//			
//			// TODO render line
//		}
//	}
//	
//}