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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import audio.AudioOptions;
import listeners.UserInput;
import observer_pattern.GameModeObserver;
import observer_pattern.ObservableSubwerkzeugInterface;
import observer_pattern.ObserverInterface;
import observer_pattern.SubwerkzeugObserver;
import states.MenuState;

public abstract class AbstractScene extends JPanel implements ObservableSubwerkzeugInterface{
	
	private List<JComponent> componentList;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	
	private Set<ObserverInterface> alleBeobachter;
	
	public AbstractScene() {
		this.componentList = new ArrayList<JComponent>();
		this.gbl = new GridBagLayout();
		this.gbc = new GridBagConstraints();
		this.alleBeobachter = new HashSet<ObserverInterface>();
		
		this.gbc.fill = GridBagConstraints.BOTH;
		this.gbc.insets = new Insets(10, 10, 10, 10);
		this.setLayout(gbl);
	}
	
	protected void setupComponent(JComponent component, int x, int y, int width, int height, UserInput input, int font) {
		setupComponent(component, x, y, width, height, input, null, font);
	}
	
	protected void setupComponent(JComponent component, int x, int y, int width, int height, UserInput input, String string, int font) {
		if(component instanceof JLabel) {
			component = new JLabel(string);
			if(font > 0) {
				component.setFont(new Font("Calibri", Font.PLAIN, font));
			}
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
		else if(component instanceof JTextField) {
			component = new JTextField();
			((JTextField) component).setFont(new Font("Calibri", Font.PLAIN, font));
			//((JFormattedTextField) component).
			//TODO: Set RegEx
		}
		else if(component instanceof JSlider) {
			component = new JSlider(0, 0, 10, 10);
			((JSlider) component).addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
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
	public void registriereBeobachter(ObserverInterface beobachter) {
		alleBeobachter.add(beobachter);
	}

	@Override
	public void entferneBeobachter(ObserverInterface beobachter) {
		alleBeobachter.remove(beobachter);
		
	}

	@Override
	public void informiereUeberAenderung(MenuState newState) {
		for (ObserverInterface beobachter : alleBeobachter) {
			if(beobachter instanceof SubwerkzeugObserver) {
				((SubwerkzeugObserver)beobachter).reagiereAufAenderung(newState);
			}
        }
	}
	
	protected void informiereUeberAenderung(boolean newState) {
		for (ObserverInterface beobachter : getBeobachter()) {
			if(beobachter instanceof GameModeObserver) {
				((GameModeObserver)beobachter).reagiereAufAenderung(newState);
			}
        }
	}
	
	protected List<JComponent> getComponentList() {
		return componentList;
	}
	
	protected Set<ObserverInterface> getBeobachter() {
		return alleBeobachter;
	}
}
