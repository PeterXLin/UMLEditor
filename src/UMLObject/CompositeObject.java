package UMLObject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import midterm_project.components.MyCanvas;

public class CompositeObject extends UMLObject{
	static final boolean connectable = false;
	private MyCanvas pane;
//	public List<UMLObject> objectList;
//	public List<ConnectionLine> connectionLines; 
	
	public CompositeObject (List<UMLObject> objectList, List<ConnectionLine> connectionLines,
			int leftUpX, int leftUpY, int rightDownX, int rightDownY){
		pane = new MyCanvas();		
		pane.setBounds(leftUpX, leftUpY, rightDownX - leftUpX, rightDownY - leftUpY);
		pane.setLayout(null);
		// pane.setBackground(Color.WHITE);
		pane.setBorder(BorderFactory.createLineBorder(Color.black));
		
		pane.objectList = objectList;
		// this.objectList = objectList;
		pane.connectionLines = connectionLines;
		// this.connectionLines = connectionLines;
		
		for (UMLObject temp: objectList) {
			int oldX = temp.getObject().getX();
			int oldY = temp.getObject().getY();
			temp.getObject().setLocation(oldX - leftUpX, oldY - leftUpY);
			pane.add(temp.getObject(), 0);
		}
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
