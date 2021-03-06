package drawing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint implements Observer {
	
	private JFrame frame;
	private JButton clearButton;
	private JButton circleButton;
	private JButton rectangleButton;
	private JButton duplicate;
	private JPanel buttonPanel;
	private JPanel mainPanel;
	private Drawing drawing;
	private JPanel statusPanel;
	private JPanel southPanel;
	private JLabel status;
	private JLabel select;
	private JButton undo;
	private JButton redo;
	private JButton text;
	
	public void run(){
		frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel(new BorderLayout());
		southPanel = new JPanel(new BorderLayout());
		
		drawing = new Drawing();
		drawing.setBackground(Color.WHITE);
		drawing.addObserver(this);
		clearButton = new JButton("Clear");
		circleButton = new JButton("Circle");
		rectangleButton = new JButton("Rectangle");
		duplicate= new JButton("Duplicate");
		
		// text
		text = new JButton("Text");
		
		//undo / redo
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		
		buttonPanel = new JPanel();
		buttonPanel.add(clearButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(rectangleButton);
		buttonPanel.add(duplicate);
		buttonPanel.add(undo);
		buttonPanel.add(redo);
		buttonPanel.add(text);
		
		//select
		select = new JLabel("");
		
		//status
		status = new JLabel("Status");
		
		//statusPanel
		statusPanel = new JPanel();
		statusPanel.setBorder(new EtchedBorder (EtchedBorder.LOWERED));
		statusPanel.add(status);	
		statusPanel.add(select);	
		
		//southPanel
		southPanel.add(buttonPanel, BorderLayout.NORTH);
		southPanel.add(statusPanel, BorderLayout.SOUTH);		
		
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(drawing, BorderLayout.CENTER);
		
		//listeners pour les boutons
		clearButton.addActionListener(new ClearButtonListener(drawing));
		circleButton.addActionListener(new CircleButtonListener(drawing));
		rectangleButton.addActionListener(new RectangleButtonListener(drawing));
		duplicate.addActionListener(new Duplication(drawing));
		text.addActionListener(new TextButtonListener(drawing));
		
		//listeners pour la zone de dessin
		DrawingMouseListener l = new DrawingMouseListener(drawing);
		drawing.addMouseListener(l);
		drawing.addMouseMotionListener(l);

		frame.getContentPane().add(mainPanel);
		frame.setSize(640,480);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args){
		Paint app = new Paint();
		app.run();
	}


	@Override
	public void update(Observable o) {
		int nb = ((Drawing)o).counterShapes();
		status.setText(nb + " Shapes");
		String isSelect = ((Drawing)o).getIsSelect();
		select.setText(" /  " + isSelect);
	}
}