package mode;

import java.awt.event.MouseEvent;
import java.util.List;

import UMLObject.UseCaseObject;
import UMLObject.UMLObject;
import midterm_project.components.MyCanvas;

public class CanvasUseCaseMode implements CanvasMode{
	public CanvasUseCaseMode() {
		
	}

	@Override
	public void mouseClicked(MyCanvas canvas, MouseEvent e) {
		UseCaseObject tmp = new UseCaseObject(e.getPoint());
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