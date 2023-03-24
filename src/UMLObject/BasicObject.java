package UMLObject;

public class BasicObject extends UMLObject{
	private boolean isSelected;
	
	BasicObject(){};
	
	public boolean getSelected() {
		return isSelected;
	}
	
	public void setSelected(boolean temp) {
		this.isSelected = temp;
	}
}
