import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SierpinskiTriangle {
    private Point left;
    private Point middle;
    private Point right;
    private JPanel panel;
    int SIZE = 1000;

    public static void main(String[] args) {
        SierpinskiTriangle triangle = new SierpinskiTriangle();
        triangle.display();
    }

    /*
        Zeichnet das JFrame und Panel der größe SIZE 1000 und ruft zum ersten mal paintSierpinskiTriangle() auf.
        Hier kann außerdem im Paramter dieser Methode die Anzahl der rekursiven Aufrufe erstellt werden. Bei
        recursionLevel = 1 wird z.B. nur 1 Dreieck gezeichnet und bei 2 drei Stück.

        Creates the JFrame and calls the recursive method paintSierpinskiTriangle().
        The recursionLevel states how many triangles are gonna be drawn on the JPanel.
     */
    @SuppressWarnings("serial")
    public void display() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                /*
                 * Hier werden die Punkte für ein gleichseitiges Dreieck berechnet
                 * es wird getSize() benutzt, damit das entstandene Dreieck auch responsive ist.
                 *
                 * calculates a equilateral triangle using getSize()
                 */
                if(getSize().height>=getSize().width){
                	int height = (int) Math.round(getSize().width * Math.sqrt(3) / 2);
                	left = new Point(0, height);
                	middle = new Point(getSize().width / 2, 0);
                	right = new Point(getSize().width, height);
                }else{
                	int height = getSize().height;
                	int width = (int) (height/(Math.sqrt(3) / 2));
                	left = new Point(0, height);
                	middle = new Point(width / 2, 0);
                	right = new Point(width, height);
                }
                /*
                 * sozusagen Beginn der Rekursion, falls recursionLevel > 1 ist.
                 * Beginning of the recursion, if recursionLevel > 1
                 */
                paintSierpinskiTriangle(g,8, left, middle, right, 8);
            }
        };
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                panel.repaint();
            }
        });
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();

        frame.setSize(SIZE, SIZE);
        frame.setVisible(true);
    }

     /*
      *  Berechnet den Mittelpunkt der Dreiecksseite, welche durch den ersten und zweiten Punkt definiert wird.
      *  calculates the midpoint of a triangle side using two points.
      */
    private Point calculateMidPoint(Point first, Point second) {
        int x = (first.x + second.x) / 2;
        int y = (first.y + second.y) / 2;
        Point newMidPoint = new Point(x, y);
        return newMidPoint;
    }

    /*
     *  Zeichnet alle Dreiecke und wird auch rekursiv aufgerufen - Erster aufruf erfolgt in der display()-Methode
     */
    public void paintSierpinskiTriangle(Graphics g, int recursionLevel, Point left, Point middle, Point right, int color) {
        Graphics2D tri = (Graphics2D) g;
        if (recursionLevel == 1) {
        	switch(color){
        		case 8:
        			tri.setColor(Color.getHSBColor((float) (0.0), 1, 1));
        			break;
        		case 7:
        			tri.setColor(Color.getHSBColor((float) (0.05), 1, 1));
        			break;
        		case 6:
        			tri.setColor(Color.getHSBColor((float) (0.1), 1, 1));
        			break;
        		case 5:
        			tri.setColor(Color.getHSBColor((float) (0.15), 1, 1));
        			break;
        		case 4:
        			tri.setColor(Color.getHSBColor((float) (0.2), 1, 1));
        			break;
        		case 3:
        			tri.setColor(Color.getHSBColor((float) (0.25), 1, 1));
        			break;
        		case 2:
        			tri.setColor(Color.getHSBColor((float) (0.3), 1, 1));
        			break;
        		case 1:
        			tri.setColor(Color.black);
        			break;
        		default:
        			tri.setColor(Color.black);
        	}
            //Erstellt ein Dreieck anhand der im Parameter übergebenen Punkte und deren Koordinaten
            //creates a triangle based on the given points and their coordinates x,y
            int[] xPoints = {left.x, middle.x, right.x};
            int[] yPoints = {left.y, middle.y, right.y};
            tri.drawPolygon(xPoints, yPoints, 3);
            tri.fillPolygon(xPoints, yPoints, 3);

        } else {
            //Wenn das Level nicht 1 ist, werden zunächst die 3 Mittelpunkte jeder Seite berechnet
            //If the recursionLevel != 1 the midpoints are calculates
            Point newTriPoint1 = calculateMidPoint(left, middle);
            Point newTriPoint2 = calculateMidPoint(middle, right);
            Point newTriPoint3 = calculateMidPoint(left, right);

            //colorise inner Triangle
            paintSierpinskiTriangle(g, recursionLevel - 1, left, middle, right, color);
            paintSierpinskiTriangle(g, recursionLevel - 1, left, newTriPoint1, newTriPoint3, color-1);
            paintSierpinskiTriangle(g, recursionLevel - 1, newTriPoint1, middle, newTriPoint2, color-1);
            paintSierpinskiTriangle(g, recursionLevel - 1, newTriPoint3, newTriPoint2, right, color-1);
        }
    }
}
