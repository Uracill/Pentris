package scenes;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class AbstractScene extends JPanel{
	
	public AbstractScene() {
		
	}
	
	private void setupComponent(JComponent component, int x, int y, int width, int height) {
		if(component instanceof JLabel) {
			component = new JLabel();
		}
		else if(component instanceof JButton) {
			component = new JButton();
		}
		component.setBounds(x, y, width, height);
	}
	
	private void setupButton(JButton button, int width, int height) {
		
	}
}
