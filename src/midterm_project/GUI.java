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
import javax.swing.JMenuBar;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;

public class GUI extends JFrame {

	// private JPanel contentPane;
	private JSplitPane contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					// frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		buttonArea.setMinimumSize(new Dimension(200, 10));
		JLayeredPane canvasArea = new JLayeredPane();
		contentPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonArea, canvasArea);
		contentPane.setEnabled(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setIcon(new ImageIcon("D:\\Codes\\java_learn\\ObjectOriented\\midterm_project\\src\\image\\class_object.png"));
		lblNewLabel.setBounds(165, 254, 100, 110);
		canvasArea.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Codes\\java_learn\\ObjectOriented\\midterm_project\\src\\image\\class_object.png"));
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(225, 283, 100, 110);
		canvasArea.add(lblNewLabel_2);
		buttonArea.setLayout(new BoxLayout(buttonArea, BoxLayout.Y_AXIS));
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setMaximumSize(new Dimension(32767, 23));
		tglbtnNewToggleButton.setPreferredSize(new Dimension(200, 23));
		tglbtnNewToggleButton.setMinimumSize(new Dimension(200, 23));
		buttonArea.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("New toggle button");
		tglbtnNewToggleButton_1.setMinimumSize(new Dimension(200, 23));
		tglbtnNewToggleButton_1.setMaximumSize(new Dimension(32767, 23));
		tglbtnNewToggleButton_1.setPreferredSize(new Dimension(200, 23));
		buttonArea.add(tglbtnNewToggleButton_1);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		
		
		// contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// Button Area 
		
		
		
		// JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, , );
		// splitPane.setOneTouchExpandable(true);
		// contentPane.add(splitPane);
//		box.add(label3);
	}
}
