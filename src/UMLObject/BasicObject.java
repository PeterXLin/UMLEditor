package UMLObject;

import java.awt.Font;
import java.awt.Point;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

public class BasicObject extends UMLObject{
	static final boolean connectable = true;
	protected JLabel label;
	
	BasicObject(){
		label = new JLabel("");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
	};
	
	
	boolean onLineLeft(Point a, Point b, Point c) {
		// 與正常的結果相反，因為java swing 用的y軸是相反的
		return (a.getX() - c.getX())*(b.getY() - c.getY()) 
				- (a.getY() - c.getY())*(b.getX() - c.getX()) >= 0 ? false : true;
	}
	
	public Port getPort(Point p) {
		int x = label.getX(), y = label.getY(), width = label.getWidth(), height = label.getHeight();
		boolean northEast = onLineLeft(label.getLocation(), 
				new Point(x + width, y + height), p);
		
		boolean northWest = onLineLeft(new Point(x, y + height), new Point(x + width, y), p);
//		System.out.println("northEast: " + northEast);
//		System.out.println("northWest: " + northWest);
		if (northEast && northWest) {
			return Port.North;
		} else if (northEast && !northWest) {
			return Port.East;
		} else if (!northEast && northWest) {
			return Port.West;
		} else {
			return Port.South;
		}
	}
	
	
	public Point getPortPoint(Port p, int offsetX, int offsetY) {
		int imgOffsetX = 10, imgOffsetY = 10;
		int pX = label.getX() + offsetX;
		int pY = label.getY() + offsetY;
		// System.out.println("label offset: " + pX + " " + pY);
		
		Point portPoint = null;
		switch (p) {
			case North:
				portPoint = new Point(pX + label.getWidth() / 2,
						pY + imgOffsetY);
				break;
			case East:
				portPoint = new Point(pX + label.getWidth() - imgOffsetX,
						pY + label.getHeight() / 2);
				break;
			case South:
				portPoint = new Point(pX + label.getWidth() / 2,
						pY + label.getHeight() - imgOffsetY);
				break;
			case West:
				portPoint = new Point(pX + imgOffsetX,
						pY + label.getHeight() / 2);
				break;
			default:
				break;
		}
		return portPoint;
	}
	
	
	@Override
	public Component getObject() {
		return this.label;
	}

	@Override
	public Rectangle getBounds() {
		return label.getBounds();
	}

	@Override
	public boolean getConnectable() {
		// TODO Auto-generated method stub
		return connectable;
	}
	
}


