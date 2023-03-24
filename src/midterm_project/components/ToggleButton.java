package midterm_project.components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import midterm_project.Mode;

public class ToggleButton extends GUIComponent{
	private JToggleButton btn;
	// private boolean isClicked = false;
	private Mode myMode;
	
	public ToggleButton() {
		this(Mode.SelectMode);
	}
	
	public ToggleButton(Mode tmpMode) {
		btn = new JToggleButton("");
		btn.setIcon(new ImageIcon(tmpMode.getImgPath()));
		// set button size
		btn.setMaximumSize(new Dimension(32767, 200));
		btn.setPreferredSize(new Dimension(100, 100));
		btn.setMinimumSize(new Dimension(100, 100));
		
		btn.setActionCommand(tmpMode.getBtnString());
		btn.setBackground(Color.WHITE);
		this.myMode = tmpMode;
		
		// set button selected black
		btn.setUI(new MetalToggleButtonUI() {
		    @Override
		    protected Color getSelectColor() {
		        return Color.GRAY;
		    }
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentMode = myMode;
				System.out.println(currentMode.toString());
			}
		});
	
	}
	
	public JToggleButton getBtn() {
		return btn;
	}
}
