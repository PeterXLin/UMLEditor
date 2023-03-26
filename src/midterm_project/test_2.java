package midterm_project;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class test_2 {

    public static void main(String[] args) {
        new test_2();
    }

    public test_2() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                GroupPane parent = new GroupPane("Parent", Color.RED);
                GroupPane child1 = new GroupPane("Child 1", Color.BLUE);
                GroupPane child2 = new GroupPane("Child 2", Color.CYAN);

                parent.setBounds(10, 10, 100, 100);
                child1.setBounds(10, 150, 100, 100);
                child2.setBounds(150, 150, 100, 100);

                ConnectionPane connectionPane = new ConnectionPane();
                connectionPane.add(parent, child1);
                connectionPane.add(parent, child2);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(connectionPane);
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    // just an object 
    public class GroupPane extends JPanel {

        public GroupPane(String name, Color background) {
            setLayout(new GridBagLayout());
            add(new JLabel(name));
            setBackground(background);
        }

    }

    // in OOAD Project, this is canvas area
    public class ConnectionPane extends JLayeredPane {

        private List<Component[]> connections;

        // constructor
        public ConnectionPane() {
            connections = new ArrayList<>();

            MouseAdapter ma = new MouseAdapter() {
                private Component dragComponent;
                private Point clickPoint;
                private Point offset;

                // move object
                @Override
                public void mousePressed(MouseEvent e) {
                    Component component = getComponentAt(e.getPoint());
                    if (component != ConnectionPane.this && component != null) {
                        dragComponent = component;
                        clickPoint = e.getPoint();
                        // 紀錄點擊的點與左上角差多少
                        int deltaX = clickPoint.x - dragComponent.getX();
                        int deltaY = clickPoint.y - dragComponent.getY();
                        offset = new Point(deltaX, deltaY);
                    }
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();

                    int xDelta = mouseX - offset.x;
                    int yDelta = mouseY - offset.y;
                    dragComponent.setLocation(xDelta, yDelta);

                    repaint();
                }

            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        // overload 
        public void add(Component parent, Component child) {
            // if not in this panel
            if (parent.getParent() != this) {
                add(parent);
            }
            if (child.getParent() != this) {
                add(child);
            }
            connections.add(new Component[]{parent, child});
        }

        
        void drawArrow(Graphics g1, double x1, double y1, double x2, double y2) {
        	int ARR_SIZE = 10;
        	
            Graphics2D g = (Graphics2D) g1.create();
            double dx = x2 - x1, dy = y2 - y1;
            double angle = Math.atan2(dy, dx);
            int len = (int) Math.sqrt(dx*dx + dy*dy);
            AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
            at.concatenate(AffineTransform.getRotateInstance(angle));

            g.transform(at);

            // Draw horizontal arrow starting in (0, 0)

//            // generalization line
//            g.drawLine(0, 0, len - ARR_SIZE, 0);
//            g.drawPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
//            new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);

            
            // association line
//            g.drawLine(0, 0, len, 0);
//            g.drawPolyline(new int[] {len - ARR_SIZE, len, len - ARR_SIZE}, 
//            		new int[] {-ARR_SIZE, 0, ARR_SIZE}, 3);
            
            
          g.drawLine(0, 0, len - 2 * ARR_SIZE, 0);
          g.drawPolygon(new int[] {len, len-ARR_SIZE, len - 2 * ARR_SIZE, len-ARR_SIZE, len},
          new int[] {0, -ARR_SIZE, 0, ARR_SIZE, 0}, 5);
            
            g.dispose();
        }
        
        // the function which paint 
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (Component[] connection : connections) {
                Rectangle parent = connection[0].getBounds();
                Rectangle child = connection[1].getBounds();
                drawArrow(g, parent.getX(), parent.getY(), child.getX(), child.getY());
            }
            g2d.dispose();
        }
        
        

    }

}
