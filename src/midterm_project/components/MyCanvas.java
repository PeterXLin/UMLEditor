package midterm_project.components;

import static java.awt.geom.AffineTransform.*;
import java.awt.geom.AffineTransform;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;
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
	// private static final long serialVersionUID = 6701031330107974482L;
	
	// check which Objects are selected 
	public List<UMLObject> objectList;
	public List<ConnectionLine> connectionLines; 
	
	// for connection line preview
	private ConnectionLine tempConnection = null;
	private Point tempMousePoint = null;
	
	public MyCanvas() {
		connectionLines = new ArrayList<>();
		objectList = new ArrayList<>();
		// absolute layout
		setLayout(null);
		// TODO
		// setOpaque(false);
	}
	
	public void deSelectAllObject() {
		for (UMLObject temp: objectList) {
			temp.setSelected(false);
		}
	}
	
	public void add(UMLObject o) {
		add(o.getObject(), 0);
		this.objectList.add(o);
		revalidate();
		repaint();
	}
	
	
	public void addConnection(ConnectionType type, UMLObject o1, Port p1, UMLObject o2, Port p2) {
		if (o1.getConnectable() && o2.getConnectable()) {
			connectionLines.add(new ConnectionLine(type, (BasicObject) o1, p1, (BasicObject)o2, p2));
		}
	}
	
	public void setTempConnectionLine(ConnectionLine tempLine, Point tempPoint) {
		this.tempConnection = tempLine;
		this.tempMousePoint = tempPoint;
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
        	
        	// add offset for composite object ======
//        	int pOffsetX = 0, pOffsetY = 0, cOffsetX = 0, cOffsetY = 0;
//        	Component temp = connection.obj_1.getObject().getParent();
//        	while(temp != this) {
//        		pOffsetX += temp.getX();
//        		pOffsetY += temp.getY();
//        		temp = temp.getParent();
//        	}
//        	temp = connection.obj_2.getObject().getParent();
//        	while(temp != this) {
//        		cOffsetX += temp.getX();
//        		cOffsetY += temp.getY();
//        		temp = temp.getParent();
//        	}
        	// ======================================
        	
        	
//        	System.out.println("p offset: " + pOffsetX + ", " + pOffsetY);
//        	System.out.println("c offset: " + cOffsetX + ", " + cOffsetY);
//            Point parentPoint = connection.obj_1.getPortPoint(connection.port_1, pOffsetX, pOffsetY);
//            Point childPoint = connection.obj_2.getPortPoint(connection.port_2, cOffsetX, cOffsetY);
//        	System.out.println("start point: " + parentPoint.getX() + ", " + parentPoint.getY());
//        	System.out.println("end offset: " + childPoint.getX() + ", " + childPoint.getY());
          Point parentPoint = connection.obj_1.getPortPoint(connection.port_1, 0, 0);
          Point childPoint = connection.obj_2.getPortPoint(connection.port_2, 0, 0);
            drawArrow(g, parentPoint.getX(), parentPoint.getY(), 
            		childPoint.getX(), childPoint.getY(), connection.type);
//            System.out.println( " " + parentPoint.getX() + " " +  parentPoint.getY() + 
//            		", " + childPoint.getX() + " " + childPoint.getY());
//            System.out.println(connection.port_1.toString());
//            System.out.println(connection.port_2.toString());
        }
        
        
        // for connection mode preview connection line
        if (tempConnection != null && tempMousePoint != null) {
        	Point parentPoint = tempConnection.obj_1.getPortPoint(tempConnection.port_1, 0, 0);
        	 drawArrow(g, parentPoint.getX(), parentPoint.getY(), 
             		tempMousePoint.getX(), tempMousePoint.getY(), tempConnection.type);
             tempConnection = null;
             tempMousePoint = null;
        }

        g2d.dispose();
    }
	
}