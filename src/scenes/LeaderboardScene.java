package scenes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import observer_pattern.GameOverObserver;
import states.MenuState;

public class LeaderboardScene extends AbstractScene {

	private JTable table;
	private DefaultTableModel tm;
	
	private String fileName = "Leaderboard";
	
	private TableRowSorter<TableModel> tableSorter;
	
	public LeaderboardScene() {
		setupLeaderboard();
		setupTableSorter();
	}

	private void setupLeaderboard() {
		this.setLayout(new BorderLayout(0, 0));
		JLabel title = new JLabel("Leaderboard");
		title.setFont(new Font("Calibri", Font.PLAIN, 40));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		table = new JTable();
		
		Vector<String> columnIdentifiers = new Vector();
		columnIdentifiers.add("Points");
		columnIdentifiers.add("Player name");
		columnIdentifiers.add("Playmode");
		
		
		tm = new DefaultTableModel(new Object[][] {},
				new String[] {"Points", "Player name", "Playmode"}) {
			Class[] columnTypes = new Class[] {
					Integer.class,
					String.class,
					String.class
				};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		table.setModel(tm);
		
		JScrollPane sp = new JScrollPane(table);
		
		try(FileInputStream fs = new FileInputStream(fileName);
				ObjectInputStream os = new ObjectInputStream(fs);) {
			tm.setDataVector((Vector <Vector>)os.readObject(), columnIdentifiers);
		} catch (IOException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				informiereUeberAenderung(MenuState.Main);
			}
		});
		
		this.add(title, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		this.add(ok, BorderLayout.SOUTH);
	}
	
	private void setupTableSorter() {
		tableSorter = new TableRowSorter<>(tm);
		table.setRowSorter(tableSorter);
		
		ArrayList<SortKey> keys = new ArrayList<>();
		keys.add(new SortKey(0, SortOrder.DESCENDING));
		
		tableSorter.setSortKeys(keys);
	}

	public DefaultTableModel getTM() {
		return tm;
	}
	
	public void setupObserverPattern(GameOverScene goScene) {
		goScene.registriereBeobachter(new GameOverObserver() {

			@Override
			public void reagiereAufAenderung(int score, String playerName,
					String gameMode) {
				addPlayer(score, playerName, gameMode);
			}
		});
	}
	
	private void addPlayer(int score, String playerName, String gameMode) {
		tm.addRow(new Object[] {score, playerName, gameMode});
		tableSorter.sort();
		saveLeaderboard();
	}

	private void saveLeaderboard() {
		try(FileOutputStream fs = new FileOutputStream(fileName);
				ObjectOutputStream os = new ObjectOutputStream(fs);) {
			os.writeObject(tm.getDataVector());
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
	}
}
