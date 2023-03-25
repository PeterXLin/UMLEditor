package UMLObject;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BasicObject extends UMLObject{
	static final boolean connectable = true;
	protected JLabel label;
	
	BasicObject(){
		label = new JLabel("default");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
	};
	
	public JLabel getObject() {
		return this.label;
	}
	

}
