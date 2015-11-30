package drawing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextButtonListener implements ActionListener {
	Drawing drawing;
	JFrame frame;
	JPanel panel;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel buttonPanel;
	private JTextField nameField;
	private JPanel namePanel;
	
	public TextButtonListener(Drawing drawing){
		this.drawing = drawing;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(drawing.selected.size()!=0){
			frame = new JFrame();
			frame.setTitle("Text :");
			frame.setSize(400, 100);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			panel = new JPanel();
			panel.setLayout(new BorderLayout());
			
			okButton = new JButton("OK");
			cancelButton = new JButton("Cancel");
			nameField = new JTextField();
			 
			buttonPanel = new JPanel();
			buttonPanel.add(okButton);
			buttonPanel.add(cancelButton);
			
			okButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 drawing.textShapes(nameField.getText());
		        	 frame.dispose();
		         }
			});
			
			cancelButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 frame.dispose();
		         }
			});
			
			namePanel = new JPanel();
			namePanel.setLayout(new BorderLayout());
			namePanel.add(nameField,BorderLayout.CENTER);
			
			panel.add(buttonPanel, BorderLayout.SOUTH);
			panel.add(namePanel, BorderLayout.CENTER);
			
			frame.setContentPane(panel);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}
