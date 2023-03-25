package mode;

import java.awt.event.MouseEvent;
import midterm_project.components.MyCanvas;

public interface CanvasMode {
	// select (object)
	public abstract void mouseClicked(MyCanvas canvas, MouseEvent e);
	
	// select (background & object move), line
	public abstract void mousePressed(MyCanvas canvas, MouseEvent e);
	
	// select (background & object move), line
	public abstract void mouseReleased(MyCanvas canvas, MouseEvent e);

	// select (object move), line
	public abstract void mouseDragged(MyCanvas canvas, MouseEvent e);
}
