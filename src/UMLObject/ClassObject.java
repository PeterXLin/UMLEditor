package UMLObject;

import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ClassObject extends BasicObject{
	public ClassObject() {
		this(new Point(0, 0));
	};
	
	public ClassObject (Point p) {
		super();
		label.setIcon(new ImageIcon(".\\src\\images\\class_object.png"));
		label.setBounds(0, 0, 119, 131);
		label.setLocation(p);
	}
	
	public void setSelected(boolean temp) {
		this.isSelected = temp;
//		System.out.println(temp);
//		int x = label.getX(); 
//		int y = label.getY();
		label.setIcon(new ImageIcon(temp ? ".\\src\\images\\class_object_selected.png" 
				: ".\\src\\images\\class_object.png"));
//		label.setBounds(0, 0, 119, 131);
//		label.setLocation(x, y);
	}

}
