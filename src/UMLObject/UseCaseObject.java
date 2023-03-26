package UMLObject;

import java.awt.Point;

import javax.swing.ImageIcon;

public class UseCaseObject extends BasicObject{
	public UseCaseObject() {
		this(new Point(0, 0));
	};
	
	public UseCaseObject (Point p) {
		super();
		label.setIcon(new ImageIcon(".\\src\\images\\use_case.png"));
		label.setBounds(0, 0, 143, 89);
		label.setLocation(p);
	}
	
	public void setSelected(boolean temp){
		this.isSelected = temp;
		label.setIcon(new ImageIcon(temp ? ".\\src\\images\\use_case_selected.png" 
				: ".\\src\\images\\use_case.png"));
	}
 }
