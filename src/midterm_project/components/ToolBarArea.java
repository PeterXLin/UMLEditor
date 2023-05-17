package midterm_project.components;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import UMLObject.CompositeObject;
import UMLObject.ConnectionLine;
import UMLObject.UMLObject;

public class ToolBarArea {
	private JMenuBar menuBar;
	public MyCanvas myCanvas;
	
	public ToolBarArea(MyCanvas myCanvas) {
		this.myCanvas = myCanvas;
		menuBar = new JMenuBar();
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu_1.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem GroupButton = new JMenuItem("Group");
		GroupButton.setHorizontalAlignment(SwingConstants.LEFT);
		GroupButton.setActionCommand("group");
		GroupButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "group") {
					int selectedObjectAmount = 0;
					int minX = 999999, minY = 999999, maxX = 0, maxY = 0;
					List<UMLObject> tempList = new ArrayList<>();;
					for (UMLObject temp: myCanvas.objectList) {
						if (temp.getSelected()) {
							selectedObjectAmount += 1;
							
							// calculate new composite object's bound
							int x = temp.getObject().getX();
							int y = temp.getObject().getY();
							int w = temp.getObject().getWidth();
							int h = temp.getObject().getHeight();
							minX = (x < minX) ? x : minX;
							minY = (y < minY) ? y : minY;
							maxX = (x + w > maxX) ? x + w : maxX;
							maxY = (y + h > maxY) ? y + h : maxY;
							tempList.add(temp);
						}
					}
					
					if (selectedObjectAmount > 1) {
						System.out.println("start select");
						
//						for (UMLObject temp: myCanvas.objectList) {
//							if (temp.getSelected()) {
//								tempList.add(temp);
//								
//							}
//						}
						
						// remove object from parent
						for (UMLObject temp: tempList) {
							myCanvas.remove(temp.getObject());
							myCanvas.objectList.remove(temp);
							temp.setSelected(false);
						}
						
						// remove connection 
						List<ConnectionLine> toRemain = new ArrayList<>();
						List<ConnectionLine> toRemove = new ArrayList<>();
						for (ConnectionLine line: myCanvas.connectionLines) {
							// check if both object on tempList
							int onGroupAmount = 0;
							for (UMLObject temp: tempList) {
								if (temp == line.obj_1) {
									onGroupAmount += 1;
									break;
								}
							}
							
							for (UMLObject temp: tempList) {
								if (temp == line.obj_2) {
									onGroupAmount += 1;
									break;			
								}
							}
							
							if (onGroupAmount == 2) {
								toRemain.add(line);
								toRemove.add(line);
							} else if (onGroupAmount == 2) {
								toRemove.add(line);
							}
							
						}
						
						// remove connection
						for (ConnectionLine line: toRemove) {
							myCanvas.connectionLines.remove(line);
						}
						
						
						CompositeObject newObject = new CompositeObject(tempList, toRemain,
								minX, minY, maxX, maxY);
						myCanvas.add(newObject);
						System.out.println("Composite object address: " + newObject.getObject().getBounds().toString());
//						for (UMLObject temp: newObject.objectList) {
//							System.out.println(temp.getObject().getClass());
//						}
						myCanvas.repaint();
					}
					
				}
			}
		});
		mnNewMenu_1.add(GroupButton);
		
		JMenuItem UngroupButton = new JMenuItem("Ungroup");
		UngroupButton.setHorizontalAlignment(SwingConstants.LEFT);
		UngroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedAmount = 0;
				CompositeObject compositeObj = null;
				for (UMLObject temp: myCanvas.objectList) {
					if (!temp.getConnectable() && temp.getSelected()) {
						selectedAmount += 1;
						compositeObj = (CompositeObject) temp;
					}
				}
				
				if (selectedAmount == 1 && compositeObj != null) {
					int offsetX = compositeObj.getObject().getX();
					int offsetY = compositeObj.getObject().getY();
					
					MyCanvas tempCanvas = (MyCanvas) compositeObj.getObject();
					for (UMLObject temp: tempCanvas.objectList) {
						int oldX = temp.getObject().getX();
						int oldY = temp.getObject().getY();
						temp.getObject().setLocation(oldX + offsetX, oldY + offsetY);
						
						myCanvas.add(temp.getObject());
						myCanvas.objectList.add(temp);
					}
					
					for (ConnectionLine temp: tempCanvas.connectionLines) {
						myCanvas.connectionLines.add(temp);
					}
					
					myCanvas.remove(compositeObj.getObject());
					myCanvas.objectList.remove(compositeObj);
				}
			}
			
		});
		
		
		
		mnNewMenu_1.add(UngroupButton);
		
		JMenuItem renameButton = new JMenuItem("rename");
		renameButton.setHorizontalAlignment(SwingConstants.LEFT);
		renameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedObjAmount = 0;
				UMLObject renameObj = null;
				for (UMLObject temp: myCanvas.objectList) {
					if (temp.getSelected() && temp.getConnectable()) {
						selectedObjAmount += 1;
						renameObj = temp;
					}
				}
				
				if (selectedObjAmount == 1) {
					String newName = JOptionPane.showInputDialog(myCanvas, "請輸入新名稱", "");
					JLabel temp = (JLabel) renameObj.getObject();
					if (newName != null) {
						System.out.println(newName);
						temp.setText(newName);
					}
					
					
				}
				
			}
		});
		
		mnNewMenu_1.add(renameButton);
	}
	
	public JMenuBar getMenu() {
		return menuBar;
	}
}
