package AdminGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Drama;
import logic.Movie;
import logic.Show;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/**
 * Diplays a list of the shows and the availabe options.
 * @author Thanasis Tolikas
 *
 */
public class MainShowWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<Show> model;
	JList<Show> list;
	private JComboBox<Object> comboBox;

	public MainShowWindow() {

		setTitle("Cinema Manager - Manage Shows");
		this.setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblShowType = new JLabel("Show type:");
		lblShowType.setBounds(10, 11, 83, 14);
		contentPane.add(lblShowType);

		comboBox = new JComboBox<>();
		comboBox.addItem("Movies");
		comboBox.addItem("Dramas");
		comboBox.setBounds(80, 8, 109, 20);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				refresh();
			}
		});
		contentPane.add(comboBox);

		model = new DefaultListModel<Show>();
		list = new JList<>();
		list.setModel(model);
		refresh();

		list.setBounds(10, 36, 382, 457);
		contentPane.add(list);

		JButton btnAddShow = new JButton("Add New Show");
		btnAddShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addShow();
			}
		});
		btnAddShow.setBounds(402, 165, 121, 67);
		contentPane.add(btnAddShow);

		JButton btnEditShow = new JButton("Edit Show");
		btnEditShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editShow();
			}
		});
		btnEditShow.setBounds(402, 36, 121, 37);
		contentPane.add(btnEditShow);

		JButton btnDeleteShow = new JButton("Delete Show");
		btnDeleteShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteShow();
			}
		});
		btnDeleteShow.setBounds(402, 84, 121, 37);
		contentPane.add(btnDeleteShow);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(402, 470, 121, 23);
		contentPane.add(btnClose);
	}

	/**
	 * Launches a EditShowWindow
	 */
	protected void editShow() {
		// TODO Auto-generated method stub
		if (list.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this, "Please choose a show first!", "Error",JOptionPane.WARNING_MESSAGE);
		}
		else {
			EditShowWindow win = new EditShowWindow(list.getSelectedValue());
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
	protected void deleteShow() {
		// TODO Auto-generated method stub
		int index = list.getSelectedIndex();
		if (comboBox.getSelectedIndex() == 0) {
			AdminActions.cinema.removeMovie(index);
		} else {
			AdminActions.cinema.removeDrama(index);
		}
		refresh();
	}	
	
	/**
	 * Launches a AddScreeningWindow
	 */

	protected void addShow() {
		// TODO Auto-generated method stub
		AddShowWindow win = new AddShowWindow();
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
	private void refresh() {
		model.removeAllElements();
		if (comboBox.getSelectedIndex() == 0) {
			for (Movie m : AdminActions.cinema.getMovies()) {
				model.addElement(m);
			}
		} else {
			for (Drama d : AdminActions.cinema.getDramas()) {
				model.addElement(d);
			}
		}

	}
}
