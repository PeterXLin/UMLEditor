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
		label = new JLabel("default");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
	};
	
	
	public Point getPortPoint(Port p) {
		int offsetX = 10, offsetY = 10;
		
		Point portPoint = null;
		switch (p) {
			case North:
				portPoint = new Point(label.getX() + label.getWidth() / 2,
						label.getY() + offsetY);
				break;
			case East:
				portPoint = new Point(label.getX() + label.getWidth() + offsetX,
						label.getY() + label.getHeight() / 2);
				break;
			case South:
				portPoint = new Point(label.getX() + label.getWidth() / 2,
						label.getY() + label.getHeight() - offsetY);
				break;
			case West:
				portPoint = new Point(label.getX() - offsetX,
						label.getY() + label.getHeight() / 2);
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


