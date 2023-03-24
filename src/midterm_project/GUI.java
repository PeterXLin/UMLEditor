package midterm_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import java.awt.Rectangle;
import java.awt.Insets;

import midterm_project.components.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class GUI extends JFrame {
	// private JPanel contentPane;
	private JSplitPane contentPane;
	
	private Mode[] allModes = {Mode.SelectMode, Mode.AssociationlineMode, Mode.GeneralizationLineMode, Mode.CompositionLineMode
			, Mode.ClassMode, Mode.UseCaseMode};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		
		JPanel buttonArea = new JPanel();
		buttonArea.setMinimumSize(new Dimension(100, 10));
		// JLayeredPane canvasArea = new JLayeredPane();
		MyCanvasArea canvasArea = new MyCanvasArea();
		
		contentPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonArea, canvasArea.getMyCanvas());
		contentPane.setEnabled(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// menu area
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem GroupButton = new JMenuItem("Group");
		GroupButton.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu_1.add(GroupButton);
		
		JMenuItem UngroupButton = new JMenuItem("Ungroup");
		UngroupButton.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu_1.add(UngroupButton);
		
		JMenuItem mntmChangeObjectName = new JMenuItem("Change Object Name");
		mntmChangeObjectName.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu_1.add(mntmChangeObjectName);
		
		buttonArea.setLayout(new BoxLayout(buttonArea, BoxLayout.Y_AXIS));	
		
		
		// button area
		ButtonGroup btnGroup = new ButtonGroup();
		ToggleButton[] buttons = new ToggleButton[6];
		for (int i = 0; i < allModes.length; i++) {
			buttons[i] = new ToggleButton(allModes[i]);
			btnGroup.add(buttons[i].getBtn());
			buttonArea.add(buttons[i].getBtn());
		};
	}
}
