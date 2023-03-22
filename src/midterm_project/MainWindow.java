package midterm_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 644);
		
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
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// temp
		
		JLabel label3 = new JLabel("hello", new ImageIcon("D:\\Codes\\java_learn\\ObjectOriented\\midterm_project\\src\\image\\class_object.png"), SwingConstants.CENTER);
		label3.setEnabled(false);
		label3.setFont(new Font("新細明體", Font.BOLD, 16));
		label3.setBounds(433, 304, 100, 110);
		// contentPane.add(label3);
		label3.setText("Order");
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 241, 577);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.GREEN);
		panel.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setIcon(new ImageIcon("D:\\Codes\\java_learn\\ObjectOriented\\midterm_project\\src\\images\\Use_Case_icon.png"));
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setIcon(new ImageIcon("D:\\Codes\\java_learn\\ObjectOriented\\midterm_project\\src\\images\\select.png"));
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("");
		rdbtnNewRadioButton_1_1.setIcon(new ImageIcon("D:\\Codes\\java_learn\\ObjectOriented\\midterm_project\\src\\images\\Generalization_Line.png"));
		panel.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("");
		rdbtnNewRadioButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		panel.add(tglbtnNewToggleButton);
		rdbtnNewRadioButton_1_2.setIcon(new ImageIcon("D:\\Codes\\java_learn\\ObjectOriented\\midterm_project\\src\\images\\Composition_Line.png"));
		panel.add(rdbtnNewRadioButton_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(374, 0, 468, 577);
		contentPane.add(panel_1);
	}
}
