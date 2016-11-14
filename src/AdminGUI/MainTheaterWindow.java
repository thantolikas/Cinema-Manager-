package AdminGUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import logic.DramaTheater;
import logic.MovieTheater;
import logic.Theater;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/**
 * Diplays a list of the theaters and the availabe options.
 * @author Thanasis Tolikas
 *
 */
public class MainTheaterWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JList<Theater> list;
	private DefaultListModel<Theater> model;


	public MainTheaterWindow() {
		setTitle("Cinema Manager - Manage Theaters");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilterTheaters = new JLabel("Show filter:");
		lblFilterTheaters.setBounds(10, 11, 95, 14);
		contentPane.add(lblFilterTheaters);
		
		comboBox = new JComboBox<>();
		comboBox.addItem("Movie Theaters");
		comboBox.addItem("Drama Theaters");
		comboBox.setBounds(77, 8, 113, 20);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				refresh();
			}
		});
		contentPane.add(comboBox);
		
		
		model = new DefaultListModel<Theater>();
		list = new JList<>();
		list.setBounds(10, 36, 397, 504);
		list.setModel(model);
		contentPane.add(list);
		refresh();
		
		JButton btnEditTheater = new JButton("Edit Theater");
		btnEditTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editTheater();
			}
		});
		btnEditTheater.setBounds(417, 33, 128, 34);
		contentPane.add(btnEditTheater);
		
		JButton btnDeleteTheater = new JButton("Delete Theater");
		btnDeleteTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTheater();
			}
		});
		btnDeleteTheater.setBounds(417, 78, 128, 34);
		contentPane.add(btnDeleteTheater);
		
		JButton btnAddNewTheater = new JButton("Add New Theater");
		btnAddNewTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTheater();
			}
		});
		btnAddNewTheater.setBounds(417, 162, 128, 54);
		contentPane.add(btnAddNewTheater);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnClose.setBounds(414, 517, 131, 23);
		contentPane.add(btnClose);
	}
	/**
	 * Launches a EditTheaterWindow
	 */
	protected void editTheater() {
		// TODO Auto-generated method stub
		if (list.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this, "Please choose a show first!", "Error",JOptionPane.WARNING_MESSAGE);
		}
		else {
			EditTheaterWindow win = new EditTheaterWindow(list.getSelectedValue());
			win.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					super.windowClosed(e);
					refresh();
				}

			});
			win.setVisible(true);
		}
	}
	/**
	 * Deletes the selected screening.
	 */
	protected void deleteTheater() {
		// TODO Auto-generated method stub
		if (!list.isSelectionEmpty()){
		int index = list.getSelectedIndex();
		if (comboBox.getSelectedIndex() == 0) {
			AdminActions.cinema.removeMovieTheater(index);
		} else {
			AdminActions.cinema.removeDramaTheater(index);
		}
		refresh();
		}
		else {
			JOptionPane.showMessageDialog(this, (String) "No item is selected", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Refreshes the list.
	 */
	private void refresh() {
		// TODO Auto-generated method stub
		model.removeAllElements();
		if (comboBox.getSelectedIndex() == 0) {
			for (MovieTheater m : AdminActions.cinema.getMovieTheaters()) {
				model.addElement(m);
			}
		} else {
			for (DramaTheater d : AdminActions.cinema.getDramaTheaters()) {
				model.addElement(d);
			}
		}

	}
	/**
	 * Launches a AddTheaterWindow
	 */

	protected void addTheater() {
		// TODO Auto-generated method stub
		AddTheaterWindow win = new AddTheaterWindow();
		win.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
				refresh();
			}

		});
		win.setVisible(true);
	}

	protected void close() {
		// TODO Auto-generated method stub
		dispose();
	}

}
