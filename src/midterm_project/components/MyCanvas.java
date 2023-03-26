package midterm_project.components;

import static java.awt.geom.AffineTransform.*;
import java.awt.geom.AffineTransform;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import UMLObject.UMLObject;
import UMLObject.BasicObject;
import UMLObject.Port;
import UMLObject.ConnectionLine;
import UMLObject.ConnectionType;

public class MyCanvas extends JPanel {
	/**
	 * I don't know why I need this, but compiler suggested
	 */
	private static final long serialVersionUID = 6701031330107974482L;
	
	// check which Objects are selected 
	public List<UMLObject> objectList;
	private List<ConnectionLine> connectionLines; 
	
	public MyCanvas() {
		connectionLines = new ArrayList<>();
		objectList = new ArrayList<>();
		// absolute layout
		setLayout(null);
	}
	
	public void deSelectAllObject() {
		for (UMLObject temp: objectList) {
			temp.setSelected(false);
		}
	}
	
	public void addConnection(ConnectionType type, UMLObject o1, Port p1, UMLObject o2, Port p2) {
		if (o1.getConnectable() && o2.getConnectable()) {
			connectionLines.add(new ConnectionLine(type, (BasicObject) o1, p1, (BasicObject)o2, p2));
		}
	}
	
    public void drawArrow(Graphics g1, double x1, double y1, double x2, double y2, ConnectionType type) {
    	int ARR_SIZE = 10;
        Graphics2D g = (Graphics2D) g1.create();
        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        switch(type) {
	      case Association:
	        g.drawLine(0, 0, len, 0);
	        g.drawPolyline(new int[] {len - ARR_SIZE, len, len - ARR_SIZE}, 
	        		new int[] {-ARR_SIZE, 0, ARR_SIZE}, 3);
	        break;
	      case Generalization:
	        g.drawLine(0, 0, len - ARR_SIZE, 0);
	        g.drawPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
	        		new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
	        break;
	      case Composition:
	        g.drawLine(0, 0, len - 2 * ARR_SIZE, 0);
	        g.drawPolygon(new int[] {len, len-ARR_SIZE, len - 2 * ARR_SIZE, len-ARR_SIZE, len},
	          		new int[] {0, -ARR_SIZE, 0, ARR_SIZE, 0}, 5);
	    	break;
	      default:
	    	break;
        }
        g.dispose();
    }
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        for (ConnectionLine connection : connectionLines) {
            Point parentPoint = connection.obj_1.getPortPoint(connection.port_1);
            Point childPoint = connection.obj_2.getPortPoint(connection.port_2);
            drawArrow(g, parentPoint.getX(), parentPoint.getY(), 
            		childPoint.getX(), childPoint.getY(), connection.type);
            System.out.println( " " + parentPoint.getX() + " " +  parentPoint.getY() + 
            		" " + childPoint.getX() + " " + childPoint.getY());
        }
        g2d.dispose();
    }
	
}