package drawing;

import java.awt.*;

public class Circle extends Shape{
	private Color color;
	String label;
	
	private double radius;
	
	public Circle(Point origin, double radius, Color color){
		this.origin = origin;
		this.radius = radius;
		this.color = color;
		this.label = null;
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval((int)(origin.getX()-radius), (int)(origin.getY()-radius), (int)(2*radius), (int)(2*radius));
		g.setColor(Color.BLACK);
		g.drawOval((int)(origin.getX()-radius), (int)(origin.getY()-radius), (int)(2*radius), (int)(2*radius));
		if(this.label!=null){
			final Font font = new Font("Courier", Font.BOLD, 20);
			g.setFont(font);
			g.setColor(Color.BLACK);          
			g.drawString(label, (int)(origin.x-(radius/2)+25), origin.y);   
		}
	}
	
	public boolean isOn(Point p) {
		return distanceToCenter(p)<radius;		
	}
	
	private double distanceToCenter(Point p){
		return this.origin.distance(p);
	}
	
	public double getRadius(){
			return radius;
	}
		
	public Color getColor(){
			return color;
		}
	public String getLabel(){
		return this.label;
	}
	public void setLabel(final String label){
		this.label = label;
	}

}
