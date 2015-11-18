package drawing;

import java.awt.event.*;

public class Duplication implements ActionListener {
	
	private Drawing drawing;
	
	public Duplication(Drawing drawing){
		this.drawing = drawing;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		drawing.duplicate();
	}

}
