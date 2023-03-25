package midterm_project.components;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import UMLObject.UMLObject;

public class MyCanvas extends JPanel {
	/**
	 * I don't know why I need this, but compiler suggested
	 */
	private static final long serialVersionUID = 6701031330107974482L;
	
	// check which Objects are selected 
	public List<UMLObject> objectList;
	private List<Component[]> associationLine; 
	private List<Component[]> compositionLine;
	private List<Component[]> generalizationLine;
	
	public MyCanvas() {
		associationLine = new ArrayList<>();
		compositionLine = new ArrayList<>();
		generalizationLine = new ArrayList<>();
		objectList = new ArrayList<>();
	}
	
	public void deSelectAllObject() {
		for (UMLObject temp: objectList) {
			temp.setSelected(false);
		}
	}
	
}