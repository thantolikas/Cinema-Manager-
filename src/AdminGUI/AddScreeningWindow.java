package AdminGUI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Drama;
import logic.DramaScreening;
import logic.DramaTheater;
import logic.Movie;
import logic.MovieScreening;
import logic.MovieTheater;
import logic.Show;
import logic.Theater;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


/**
 * Used for adding a new screening.
 * @author Thanasis Tolikas
 *
 */
public class AddScreeningWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JFormattedTextField tfDate;
	protected JTextField tfHour;
	protected JTextField tfMins;
	protected JComboBox<String> cbType;
	protected JComboBox<Show> cbShow;
	protected JComboBox<Theater> cbTheater;
	protected DefaultComboBoxModel<Show> showModel;
	protected DefaultComboBoxModel<Theater> theaterModel;
	protected JButton btnAdd;



	public AddScreeningWindow() {
		setTitle("Cinema Manager - Add Screening");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblChooseShowType = new JLabel("Choose Show Type:");
		lblChooseShowType.setBounds(10, 11, 128, 14);
		contentPane.add(lblChooseShowType);

		cbType = new JComboBox<String>();
		cbType.addItem("");
		cbType.addItem("Movie Screening");
		cbType.addItem("Drama Screening");
		cbType.setBounds(148, 11, 113, 20);
		contentPane.add(cbType);

		JLabel lblDate = new JLabel("Date: ");
		lblDate.setBounds(10, 39, 91, 14);
		contentPane.add(lblDate);

		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		tfDate = new JFormattedTextField(df);
		tfDate.setBounds(148, 39, 113, 20);
		contentPane.add(tfDate);
		tfDate.setColumns(10);

		JLabel lblNewLabel = new JLabel("(dd/mm/yyyy)");
		lblNewLabel.setBounds(148, 58, 91, 14);
		contentPane.add(lblNewLabel);

		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(10, 78, 46, 14);
		contentPane.add(lblTime);

		JLabel label = new JLabel(":");
		label.setBounds(176, 85, 46, 14);
		contentPane.add(label);

		tfHour = new JTextField();
		tfHour.setBounds(148, 83, 24, 17);
		contentPane.add(tfHour);
		tfHour.setColumns(10);

		tfMins = new JTextField();
		tfMins.setColumns(10);
		tfMins.setBounds(183, 83, 24, 17);
		contentPane.add(tfMins);

		JLabel lblTheater = new JLabel("Theater:");
		lblTheater.setBounds(10, 152, 91, 14);
		contentPane.add(lblTheater);

		cbShow = new JComboBox<Show>();
		showModel = new DefaultComboBoxModel<Show>();
		cbShow.setBounds(148, 110, 175, 20);
		cbShow.setModel(showModel);
		contentPane.add(cbShow);

		JLabel lblShow = new JLabel("Show: ");
		lblShow.setBounds(10, 113, 46, 14);
		contentPane.add(lblShow);

		theaterModel = new DefaultComboBoxModel<Theater>();
		cbTheater = new JComboBox<Theater>();
		cbTheater.setBounds(148, 149, 175, 20);
		cbTheater.setModel(theaterModel);
		contentPane.add(cbTheater);

		btnAdd = new JButton("Add Screening");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScreening();
			}
		});
		btnAdd.setBounds(203, 207, 120, 53);
		contentPane.add(btnAdd);

		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(233, 270, 89, 23);
		contentPane.add(btnNewButton_1);

		cbType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				enableItems();
			}
		});

		disableItems();
	}

	/**
	 * Adds the screening to the main list. 
	 */
	protected void addScreening() {
		// TODO Auto-generated method stub
		if (cbType.getSelectedIndex() == 1) {
			String[] date = tfDate.getText().split("/");
			MovieScreening ms = new MovieScreening(date[0], date[1], date[2],
					tfHour.getText(), tfMins.getText());
			ms.setTheater((MovieTheater) cbTheater.getSelectedItem());
			ms.setShow((Movie) cbShow.getSelectedItem());
			AdminActions.cinema.addMovieScreening(ms);
			JOptionPane.showMessageDialog(this,
					(String) "Movie Screening added successfully!", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} else if (cbType.getSelectedIndex() == 2) {
			String[] date = tfDate.getText().split("/");
			DramaScreening ds = new DramaScreening(date[0], date[1], date[2],
					tfHour.getText(), tfMins.getText());
			ds.setTheater((DramaTheater) cbTheater.getSelectedItem());
			ds.setShow((Drama) cbShow.getSelectedItem());
			AdminActions.cinema.addDramaScreening(ds);
			JOptionPane.showMessageDialog(this,
					(String) "Drama Screening added successfully!", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}

	/**
	 * Disables all the components.
	 */
	private void disableItems() {
		tfDate.setEnabled(false);
		tfHour.setEnabled(false);
		tfMins.setEnabled(false);
		cbTheater.setEnabled(false);
		cbShow.setEnabled(false);
	}

	/**
	 * Enables the necessary components based on the combobox index.
	 */
	private void enableItems() {
		if (cbType.getSelectedIndex() == 0)
			disableItems();
		else {
			tfDate.setEnabled(true);
			tfHour.setEnabled(true);
			tfMins.setEnabled(true);
			cbTheater.setEnabled(true);
			cbShow.setEnabled(true);
			updateCombo();
		}
	}

	/**
	 * Updates the comboboxes of the shows and theaters.
	 */
	private void updateCombo() {
		// TODO Auto-generated method stub
		showModel.removeAllElements();
		theaterModel.removeAllElements();
		if (cbType.getSelectedIndex() == 1) {
			for (Movie m : AdminActions.cinema.getMovies()){
				showModel.addElement(m);
			}
			
			for (MovieTheater mt : AdminActions.cinema.getMovieTheaters()) {
				theaterModel.addElement(mt);
			}
			
		} else if (cbType.getSelectedIndex() == 2) {
			for (Drama d: AdminActions.cinema.getDramas()) {
				showModel.addElement(d);			}
			
			for (DramaTheater dt : AdminActions.cinema.getDramaTheaters()) {
				theaterModel.addElement(dt);
			}
		}
		
	}
}
