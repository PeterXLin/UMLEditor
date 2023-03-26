package UMLObject;
import java.awt.Component;
import java.awt.Rectangle;

public abstract class UMLObject {
	protected boolean isSelected;
	
	public boolean getSelected() {
		return isSelected;
	}
	
	public void setSelected(boolean temp) {
		this.isSelected = temp;
	}
	
	public abstract Component getObject();
	
	public abstract Rectangle getBounds();
	
	public abstract boolean getConnectable();
}