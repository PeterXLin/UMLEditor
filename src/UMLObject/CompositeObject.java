package UMLObject;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class CompositeObject extends UMLObject{
	static final boolean connectable = false;
	JPanel pane;
	
	CompositeObject (){
		pane = new JPanel();
	}
	
	
	@Override
	public Component getObject() {
		return pane;
	}
	
	@Override
	public boolean getConnectable() {
		return connectable;
	}


	@Override
	public Rectangle getBounds() {
		return pane.getBounds();
	}
}
