package scenes;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.UserInput;
import observer_pattern.ObservableSubwerkzeugInterface;
import observer_pattern.SubwerkzeugObserver;

public abstract class AbstractScene extends JPanel implements ObservableSubwerkzeugInterface{
	
	private List<JComponent> componentList;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	private Set<SubwerkzeugObserver> _alleBeobachter;
	
	public AbstractScene() {
		componentList = new ArrayList<>();
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.setLayout(gbl);
	}
	
	protected void setupComponent(JComponent component, int x, int y, int width, int height, UserInput input) {
		setupComponent(component, x, y, width, height, input, null);
	}
	
	protected void setupComponent(JComponent component, int x, int y, int width, int height, UserInput input, String string) {
		if(component instanceof JLabel) {
			component = new JLabel(string);
			component.setFont(new Font("Calibri", Font.PLAIN, 40));
		}
		else if(component instanceof JButton) {
			component = new JButton(string);
			((JButton) component).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					input.execute();
				}
			});
		}
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
	
		this.add(component, gbc);
		componentList.add(component);
	}
	
	@Override
	public void registriereBeobachter(SubwerkzeugObserver beobachter) {
		_alleBeobachter = new HashSet<SubwerkzeugObserver>();
	}

	@Override
	public void entferneBeobachter(SubwerkzeugObserver beobachter) {
		_alleBeobachter.remove(beobachter);
		
	}

	@Override
	public void informiereUeberAenderung() {
		for (SubwerkzeugObserver beobachter : _alleBeobachter)
        {
            beobachter.reagiereAufAenderung();
        }
	}
	
	
}
