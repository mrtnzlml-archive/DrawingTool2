import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <strong>DrawingTool2</strong> 
 * is designed for drawing simple graphic objects or animations.<br>
 * This public class creates and displays centered drawing area and 
 * offers public methods for drawing that implements DrawingArea class.
 * <p>
 * Changes from last version:
 * <ul>
 * <li><strong>drawArc</strong>(int x, int y, int width, int height, int start_angle, int end_angle);
 * <li><strong>drawLine</strong>(int x1, int y1, int x2, int y2);
 * <li><strong>drawPolyline</strong>(int[] array1, int[] array2);
 * <li><strong>drawCircle</strong>(int x, int y, int width);
 * <li><strong>drawOval</strong>(int x, int y, int width, int height);
 * <li><strong>drawPolygon</strong>(int[] array1, int[] array2);
 * <li><strong>drawRect</strong>(int x, int y, int width, int height);
 * <li><strong>drawString</strong>(String text, int x, int y);
 * <li><strong>fillPolygon</strong>(int[] array1, int[] array2);
 * <li><strong>fillRect</strong>(int x, int y, int width, int height, boolean option);
 * <li><strong>fillArc</strong>(int x, int y, int width, int height, int start_angle, int end_angle);
 * <li><strong>fillCircle</strong>(int x, int y, int width);
 * <li><strong>fillOval</strong>(int x, int y, int width, int height);<ul><li>and more...</ul>
 * </ul>
 *
 * Doplnìno za úèelem semestrální práce studenta Martin Zlámal A11B0544P.<br>
 * Pøípadné zmìny odsouhlasil pùvodní autor tohoto projektu Roman Tesar<br>
 * 
 * @author Roman Tesar  (romant@kiv.zcu.cz) - remake by Martin Zlámal A11B0544P (<a href="http://www.zeminem.cz/">web</a>)
 * <br>Czech Republic - Pilsen, March 2005 (November 2011)
 * <br>PLEASE SEND ME REPORTS OF ANY BUGS OR SUGGESTIONS YOU HAVE FOR IMPROVEMENT.
 * @version  1.2
 */ 
public class DrawingTool2 extends JFrame {	
	private static final long serialVersionUID = 31979591836948245L;

	/** Represents area for drawing */
	private DrawingArea drawingArea;

	/**
	 * DrawingTool2 constructor.
	 * @param width   the drawing area width
	 * @param height  the drawing area height
	 */ 
	public DrawingTool2(int width, int height){ this(width, height, Color.WHITE, false); }

	/**  
	 * DrawingTool2 constructor.
	 * @param width    the drawing area width
	 * @param height   the drawing area height
	 * @param bgColor  the background color of drawing area 
	 */
	public DrawingTool2(int width, int height, Color bgColor){ this(width, height, bgColor, false); }

	/**  
	 * DrawingTool2 constructor.
	 * @param width         the drawing area width
	 * @param height        the drawing area height
	 * @param antialiasing  antialiasing on/off
	 */
	public DrawingTool2(int width, int height, boolean antialiasing) { this(width, height, Color.WHITE, antialiasing); }

	/**
	 * DrawingTool2 constructor.
	 * @param width         the drawing area width
	 * @param height        the drawing area height
	 * @param bgColor       the background color of drawing area
	 * @param antialiasing  antialiasing on/off
	 */
	public DrawingTool2(int width, int height, Color bgColor, boolean antialiasing){
		if(width < 116) drawingArea = new DrawingArea(new Dimension(116, height), bgColor, antialiasing);
		else drawingArea = new DrawingArea(new Dimension(width, height), bgColor, antialiasing);
		Container content = this.getContentPane();
		content.setLayout(new BorderLayout());
		content.add(drawingArea, BorderLayout.PAGE_START);//BorderLayout.CENTER
		this.setTitle("Martin Zlámal A11B0544P - (" + width + "x" + height + ") - Semestrální práce");
		this.setBackground(bgColor);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width-this.getSize().width)/2, (screen.height-this.getSize().height)/2);
		this.setVisible(true);
	}

	/**
	 * Draw arc.
	 * @param x     starting line position (coordinate x) 
	 * @param y     starting line position (coordinate y)
	 * @param width width of the oval
	 * @param height height of the oval
	 * @param start_angle start angle of the arc
	 * @param end_angle end angle of the arc
	 */
	public void drawArc(int x, int y, int width, int height, int start_angle, int end_angle){
		drawingArea.drawArc(new Point(x, y), new Point(width, height), new Point(start_angle, end_angle));
	}
	
	/**
	 * Draw circle.
	 * @param x     starting line position (coordinate x) 
	 * @param y     starting line position (coordinate y)
	 * @param width width of the circle
	 */
	public void drawCircle(int x, int y, int width){
		drawingArea.drawOval(new Point(x, y), new Point(width, width));
	}

	/**
	 * Draw line.
	 * @param x1     starting line position (coordinate x) 
	 * @param y1     starting line position (coordinate y)
	 * @param x2     ending line position  (coordinate x)
	 * @param y2     ending line position  (coordinate y)
	 */
	public void drawLine(int x1, int y1, int x2, int y2){
		drawingArea.drawLine(new Point(x1, y1), new Point(x2, y2));
	}
	
	/**
	 * Draw polyline.
	 * @param array1 array of points (coordinate x) 
	 * @param array2 array of points (coordinate y)
	 */
	public void drawPolyline(int[] array1, int[] array2){
		drawingArea.drawPolyline(array1, array2, array1.length);
	}
	
	/**
	 * Draw oval.
	 * @param x     starting line position (coordinate x) 
	 * @param y     starting line position (coordinate y)
	 * @param width width of the oval
	 * @param height height of the oval
	 */
	public void drawOval(int x, int y, int width, int height){
		drawingArea.drawOval(new Point(x, y), new Point(width, height));
	}
	
	/**
	 * Draw polygon.
	 * @param array1 array of points (coordinate x) 
	 * @param array2 array of points (coordinate y) 
	 */
	public void drawPolygon(int[] array1, int[] array2){
		drawingArea.drawPolygon(array1, array2, array1.length);
	}
	
	/**
	 * Draw rect.
	 * @param x     starting line position (coordinate x) 
	 * @param y     starting line position (coordinate y)
	 * @param width width of the rect
	 * @param height height of the rect
	 */
	public void drawRect(int x, int y, int width, int height){
		drawingArea.drawRect(new Point(x, y), new Point(width, height));
	}
	
	/**
	 * Draw string.
	 * @param text     string of text
	 * @param x     starting line position (coordinate x) 
	 * @param y     starting line position (coordinate y)
	 */
	public void drawString(String text, int x, int y){
		drawingArea.drawString(text, new Point(x, y));
	}
	
	/**
	 * Fill arc.
	 * @param x     starting line position (coordinate x) 
	 * @param y     starting line position (coordinate y)
	 * @param width width of the oval
	 * @param height height of the oval
	 * @param start_angle start angle of the arc
	 * @param end_angle end angle of the arc
	 */
	public void fillArc(int x, int y, int width, int height, int start_angle, int end_angle){
		drawingArea.fillArc(new Point(x, y), new Point(width, height), new Point(start_angle, end_angle));
	}
	
	/**
	 * Fill circle.
	 * @param x     starting line position (coordinate x) 
	 * @param y     starting line position (coordinate y)
	 * @param width width of the circle
	 */
	public void fillCircle(int x, int y, int width){
		drawingArea.fillOval(new Point(x, y), new Point(width, width));
	}
	
	/**
	 * Fill oval.
	 * @param x     starting line position (coordinate x) 
	 * @param y     starting line position (coordinate y)
	 * @param width width of the oval
	 * @param height height of the oval
	 */
	public void fillOval(int x, int y, int width, int height){
		drawingArea.fillOval(new Point(x, y), new Point(width, height));
	}	

	/**
	 * Fill polygon.
	 * @param array1 array of points (coordinate x) 
	 * @param array2 array of points (coordinate y) 
	 */
	public void fillPolygon(int[] array1, int[] array2){
		drawingArea.fillPolygon(array1, array2, array1.length);
	}
	
	/**
	 * Fill rect.
	 * @param x     starting line position (coordinate x) 
	 * @param y     starting line position (coordinate y)
	 * @param width width of the rect
	 * @param height height of the rect
	 */
	public void fillRect(int x, int y, int width, int height){
		drawingArea.fillRect(new Point(x, y), new Point(width, height));
	}
	
	
	
	/**
	 * Clear drawing area.
	 */
	public void clear(){
		drawingArea.clear();
	}

	/**
	 * Set foreground color of drawing area.
	 * @param fgColor  the foreground color of drawing area
	 */
	public void setColor(Color fgColor){
		drawingArea.setColor(fgColor);
	}

	/**
	 * Disable displaying of drawing area updates.
	 */
	public void stopUpdate(){
		drawingArea.stopUpdate();
	}

	/**
	 * Enable displaying of drawing area updates.
	 */
	public void startUpdate(){
		drawingArea.startUpdate();
	}
}

/**
 * This inner class represents drawing area and implements methods for drawing 
 * available from DrawingTool2 class. Double buffering is used to get rid of the
 * flickering problem.
 * 
 * @author Roman Tesar  (romant@kiv.zcu.cz) - remake by Martin Zlámal A11B0544P (<a href="http://www.zeminem.cz/">web</a>)
 * <br>Czech Republic - Pilsen, March 2005 (November 2011)
 * <br>PLEASE SEND ME REPORTS OF ANY BUGS OR SUGGESTIONS YOU HAVE FOR IMPROVEMENT.
 * @version  1.2
 */
class DrawingArea extends JPanel {
	private static final long serialVersionUID = 12152324293031344L;
	
	/** dimension of drawing area */
	private Dimension dimension;
	/** back buffer */
	private BufferedImage image = null;
	/** graphic context of the back buffer */
	private Graphics2D gcImage = null;
	/** antialiasing on/off */
	private boolean antialiasing; 
	/** drawing to screen on/off */
	private boolean invalidate = false;
	
	/**
	 * DrawingArea constructor.
	 * @param dimension     the drawing area dimension
	 * @param bgColor       the background color of drawing area
	 * @param antialiasing  antialiasing on/off
	 */
	public DrawingArea(Dimension dimension, Color bgColor, boolean antialiasing) {
		this.dimension = dimension;
		this.setBackground(bgColor);
		this.antialiasing = antialiasing;
		setPreferredSize(dimension);
		this.setVisible(true);
	}


	/**
	 * Initialize back buffer.
	 */
	private void init() {
		if (image == null) {
	        image = (BufferedImage)(this.createImage(dimension.width, dimension.height));
	        gcImage = image.createGraphics();
	        gcImage.setBackground(this.getBackground());
	        gcImage.clearRect(0, 0, dimension.width, dimension.height);
	        if (antialiasing) {
	        	gcImage.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			gcImage.setRenderingHint(RenderingHints.KEY_RENDERING,	RenderingHints.VALUE_RENDER_QUALITY);
	        }
		}
	}
	
	/**
	 * Draw back buffer to screen when the JPanel component is repainted.
	 * <br>See JavaDoc JPanel classs for details.
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (invalidate == false && image != null) 
			((Graphics2D) g).drawImage(image, null, 0, 0);
	}

	/**
	 * Draw back buffer to screen.
	 */
	private void drawOnScreen() {
		if (invalidate == false) 
			((Graphics2D) this.getGraphics()).drawImage(image, null, 0, 0);
	}
	
	/**
	 * Draw arc.
	 * @param startPoint  starting line point (x,y)
	 * @param size           width and height
	 * @param angle         angle of the arc
	 */
	public void drawArc(Point startPoint, Point size, Point angle){
		init();
		gcImage.drawArc(startPoint.x, startPoint.y, size.x, size.y, angle.x, angle.y);
		drawOnScreen();
	}

	/**
	 * Draw line.
	 * @param startPoint  starting line point (x,y)
	 * @param endPoint     ending line point (x,y)
	 */
	public void drawLine(Point startPoint, Point endPoint) {
		init();
		gcImage.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		drawOnScreen();
	}
	
	/**
	 * Draw polyline.
	 * @param array1 array of points (coordinate x) 
	 * @param array2 array of points (coordinate y)
	 * @param points number of points
	 */
	public void drawPolyline(int[] array1, int[] array2, int points){
		init();
		gcImage.drawPolyline(array1, array2, points);
		drawOnScreen();
	}
	
	/**
	 * Draw oval.
	 * @param startPoint  starting line point (x,y)
	 * @param endPoint    width and height
	 */
	public void drawOval(Point startPoint, Point endPoint) {
		init();
		gcImage.drawOval(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		drawOnScreen();
	}
	
	/**
	 * Draw polygon.
	 * @param array1 array of points (coordinate x) 
	 * @param array2 array of points (coordinate y) 
	 * @param points number of points
	 */
	public void drawPolygon(int[] array1, int[] array2, int points) {
		init();
		gcImage.drawPolygon(array1 , array2, points);
		drawOnScreen();
	}
	
	/**
	 * Draw 3D rect.
	 * @param startPoint  starting line point (x,y)
	 * @param endPoint     width and height
	 * @param option        pressed
	 */
	public void drawRect(Point startPoint, Point endPoint) {
		init();
		gcImage.drawRect(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		drawOnScreen();
	}
	
	/**
	 * Draw string.
	 * @param text     string of text
	 * @param point    starting line point (x,y)
	 */
	public void drawString(String text, Point point){
		init();
		gcImage.drawString(text, point.x, point.y);
		drawOnScreen();
	}
	
	/**
	 * Draw arc.
	 * @param startPoint  starting line point (x,y)
	 * @param size           width and height
	 * @param angle         angle of the arc
	 */
	public void fillArc(Point startPoint, Point size, Point angle){
		init();
		gcImage.fillArc(startPoint.x, startPoint.y, size.x, size.y, angle.x, angle.y);
		drawOnScreen();
	}
	
	/**
	 * Fill polygon.
	 * @param array1 array of points (coordinate x) 
	 * @param array2 array of points (coordinate y) 
	 * @param points number of points
	 */
	public void fillPolygon(int[] array1, int[] array2, int points) {
		init();
		gcImage.fillPolygon(array1, array2, points);
		drawOnScreen();
	}
	
	/**
	 * Fill rect.
	 * @param x     starting line position (coordinate x) 
	 * @param y     starting line position (coordinate y)
	 * @param width width of the rect
	 * @param height height of the rect
	 */
	public void fillRect(Point startPoint, Point size){
		init();
		gcImage.fillRect(startPoint.x, startPoint.y, size.x, size.y);
		drawOnScreen();
	}
	
	/**
	 * Fill oval.
	 * @param startPoint  starting line point (x,y)
	 * @param endPoint    width and height
	 */
	public void fillOval(Point startPoint, Point endPoint) {
		init();
		gcImage.fillOval(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		drawOnScreen();
	}

	/**
	 * Set foreground color of drawing area.
	 * @param fgColor  the foreground color of drawing area
	 */
	public void setColor(Color fgColor) {
		init();
		gcImage.setColor(fgColor);
	}

	/**
	 * Clear drawing area.
	 */
	public void clear() {
		init();
		gcImage.clearRect(0, 0, dimension.width, dimension.height);
		drawOnScreen();
	}

	/**
	 * Disable displaying of drawing area updates.
	 */
	public void stopUpdate() {
		init();
		invalidate = true;
	}

	/**
	 * Enable displaying of drawing area updates.
	 */
	public void startUpdate() {
		init();
		invalidate = false;
		drawOnScreen();
	}
}