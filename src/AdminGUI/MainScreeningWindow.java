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

import logic.DramaScreening;
import logic.MovieScreening;
import logic.Screening;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/**
 * Diplays a list of the screenings and the availabe options.
 * @author Thanasis Tolikas
 *
 */
public class MainScreeningWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<Screening> list;
	private DefaultListModel<Screening> model;
	private JComboBox<String> comboBox;


	public MainScreeningWindow() {
		setTitle("Cinema Manager - Manage Screenings");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		model = new DefaultListModel<Screening>();
		list = new JList<Screening>();
		list.setModel(model);
		list.setBounds(10, 36, 397, 504);
		contentPane.add(list);

		JButton btnEditTheater = new JButton("Edit Screening");
		btnEditTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editScreening();
			}
		});
		btnEditTheater.setBounds(417, 33, 128, 34);
		contentPane.add(btnEditTheater);

		JButton btnDeleteTheater = new JButton("Delete Screening");
		btnDeleteTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDeleteTheater.setBounds(417, 78, 128, 34);
		contentPane.add(btnDeleteTheater);

		JButton btnAddNewTheater = new JButton("Add New Screening");
		btnAddNewTheater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScreening();
			}
		});
		btnAddNewTheater.setBounds(417, 162, 128, 54);
		contentPane.add(btnAddNewTheater);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(414, 517, 131, 23);
		contentPane.add(btnClose);

		JLabel lblNewLabel = new JLabel("Show Type:");
		lblNewLabel.setBounds(10, 11, 74, 14);
		contentPane.add(lblNewLabel);

		comboBox = new JComboBox<String>();

		comboBox.addItem("Movie Screenings");
		comboBox.addItem("Drama Screenings");
		comboBox.setBounds(77, 8, 105, 20);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				refresh();
			}
		});
		contentPane.add(comboBox);
		
		refresh();
	}

	/**
	 * Launches a EditScreeningWindow
	 */
	protected void editScreening() {
		// TODO Auto-generated method stub
		if (list.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this, "Please choose a show first!", "Error",JOptionPane.WARNING_MESSAGE);
		}
		else {
			EditScreeningWindow win = new EditScreeningWindow(list.getSelectedValue());
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
	protected void delete() {
		// TODO Auto-generated method stub
		int index = list.getSelectedIndex();
		if (comboBox.getSelectedIndex() == 0) {
			AdminActions.cinema.removeMovieScreening(index);
		} else {
			AdminActions.cinema.removeDramaScreening(index);
		}
		refresh();
	}
	/**
	 * Launches a AddScreeningWindow
	 */
	protected void addScreening() {
		// TODO Auto-generated method stub
		AddScreeningWindow win = new AddScreeningWindow();
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

	/**
	 * Refreshes the list.
	 */
	protected void refresh() {
		// TODO Auto-generated method stub
		model.removeAllElements();
		if (comboBox.getSelectedIndex() == 0) {
			for (MovieScreening scr : AdminActions.cinema.getMovieScreenings()) {
				model.addElement(scr);
			}
		} else {
			for (DramaScreening scr : AdminActions.cinema.getDramaScreenings()) {
				model.addElement(scr);
			}
		}

	}
}
