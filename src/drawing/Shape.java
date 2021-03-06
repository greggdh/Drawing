package drawing;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Classe abstraite de type forme dessinable.
 */
public abstract class Shape {
	
	protected Point origin;
	
	public void setOrigin(Point p)
	{
		origin = p;
	}
	
	public Point getOrigin(){
		return origin;
	}
	
	/**
	 * dessine la forme sur un Graphics
	 */
	public abstract void paint(Graphics g);
	
	/**
	 * renvoie true si la forme occupe sur le point donn�
	 */
	public abstract boolean isOn(Point p);
	
	public abstract void setLabel(String label);
	public abstract String getLabel();
}
