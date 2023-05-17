package mode;
import java.awt.event.MouseEvent;
import java.util.List;

import midterm_project.components.MyCanvas;
import UMLObject.*;

public class CanvasClassMode implements CanvasMode{
	public CanvasClassMode() {
		
	}

	@Override
	public void mouseClicked(MyCanvas canvas,MouseEvent e) {
//		System.out.println("clicked on: " + e.getPoint().toString());
		ClassObject tmp = new ClassObject(e.getPoint());
		canvas.add(tmp.getObject(), 0);
		canvas.objectList.add(tmp);
		canvas.repaint();
	}

	@Override
	public void mousePressed(MyCanvas canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MyCanvas canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MyCanvas canvas, MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
