package ep2.View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TrianguloDraw extends JPanel {
	private double ang;
	public TrianguloDraw(double ang) {
		this.ang = ang;
	}
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
    	g.drawLine(getWidth()/2, 0, getWidth()/2, getWidth());
    	if(ang > 0) {
    		g.setColor(Color.RED);
    		g.drawLine(getWidth()/2,getHeight()/2, getWidth()/2+getWidth()/4, getHeight()/4);
    		g.setColor(Color.GREEN);
    		g.drawLine(getWidth()/2+getWidth()/4, getHeight()/4, getWidth()/2+getWidth()/4, getHeight()/2);
    		g.setColor(Color.BLUE);
    		g.drawLine(getWidth()/2+getWidth()/4, getHeight()/2, getWidth()/2,getHeight()/2);
    	}
    	else if(ang == 0){
    		g.setColor(Color.BLUE);
    		g.drawLine(getWidth()/2,getHeight()/2, getWidth()/2+getWidth()/3, getHeight()/2);
    		g.setColor(Color.RED);
    		g.drawLine(getWidth()/2,getHeight()/2, getWidth()/2+getWidth()/4, getHeight()/2);
    	}
    	else {
    		g.setColor(Color.RED);
    		g.drawLine(getWidth()/2,getHeight()/2, getWidth()/2+getWidth()/4,getHeight()/2+getHeight()/4);
    		g.setColor(Color.GREEN);
    		g.drawLine(getWidth()/2+getWidth()/4,getHeight()/2+getHeight()/4, getWidth()/2+getWidth()/4, getHeight()/2);
    		g.setColor(Color.BLUE);
    		g.drawLine(getWidth()/2+getWidth()/4, getHeight()/2,getWidth()/2,getHeight()/2);
    		
    	}
    }
    
    public void refazTriangulo(double ang) {
		this.ang = ang;
        invalidate();
        this.repaint();
    }
	
}
