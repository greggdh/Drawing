package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * JPanel pouvant afficher des objets de type Shape
 */
public class Drawing extends JPanel implements Iterable<Shape>, Observable{

	private static final long serialVersionUID = 1L;
	
	String isSelect = "unselected";
	ArrayList<Shape> shapes;
	ArrayList<Shape> selected;
	private Collection<Observer> observers = new ArrayList<Observer>() ;
	
	
	public Drawing(){
		super();
		shapes = new ArrayList<Shape>();
		selected = new ArrayList<Shape>();
	}
	
	public void setIsSelect(String info){
		this.isSelect = info;
		this.notifyObservers();
	}
	
	public String getIsSelect(){
		return isSelect;
	}
	
	public int getSelectedShapeSize(){
		return selected.size();
	}
	
	public ArrayList<Shape> getSelectedShapes(){
		return selected;
	}
	
	public void clearSelectedShapes(){
		selected.clear();
	}
			
	public void addSelectedShape(Shape s){
		selected.add(s);
	}
	
	/**
	 * Implementation de l'interface Iterable<Shape>
	 */
	public Iterator<Shape> iterator(){
		return shapes.iterator();
	}
	
	/**
	 * Ajoute une forme au dessin et redessine
	 */
	public void addShape(Shape s){
		shapes.add(s);
		this.repaint();
		this.notifyObservers();
	}
	
	/** 
	 * Redefinition de la methode paintComponent() de JComponent
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : shapes){
			s.paint(g);
		}
	}
	
	/**
	 * Enleve toutes les formes et redessine
	 */
	public void clear(){
		shapes.clear();
		this.repaint();
		this.notifyObservers();
	}

	public int counterShapes() {
		return shapes.size();
	}
	
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer obs : observers)
            obs.update(this);
	}
	
	
	public void duplicate(){
		if (selected.size() != 0){
			for (Shape s: selected){
				Point p = new Point(s.getOrigin());
				p.y += 100;	
				if (s instanceof Rectangle){
					Rectangle r = (Rectangle) s;
					shapes.add(new Rectangle(p, r.getWidth(), r.getHeight(), r.getColor()));
				}
						
				if (s instanceof Circle){
					Circle c = (Circle) s;
					shapes.add(new Circle(p, c.getRadius(), c.getColor()));
				}
			}	
			selected.clear();
			this.setIsSelect("unselected");
			this.repaint();
		}
	}
	
}
