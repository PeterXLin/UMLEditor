package mode;
import java.awt.Point;
import java.awt.event.MouseEvent;

public interface CanvasMode {
	// select (object)
	public abstract void mouseClicked(MouseEvent e);
	
	// select (background & object move), line
	public abstract void mousePressed(MouseEvent e);
	
	// select (background & object move), line
	public abstract void mouseReleased(MouseEvent e);

	// select (object move), line
	public abstract void mouseDragged(MouseEvent e);
}
