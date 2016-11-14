package AdminGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import logic.DramaTheater;
import logic.MovieTheater;
import logic.Row;
/**
 * Used for adding a new theater.
 * @author Thanasis Tolikas
 *
 */
public class AddTheaterWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JTextField tfName;
	protected JTextField tfCap;
	protected JTextField tfPrice;
	protected JTextField tfScreen;
	protected JTextField tfDress;
	protected JTextField tfSeats;
	protected JComboBox<String> comboBox;
	protected JCheckBox chckb3D;
	protected JComboBox<String> cbSoundS;
	protected JList<Row> list;
	protected DefaultListModel<Row> model;
	protected JButton btnNewButton_1;
	private JScrollPane pane;

	
	public AddTheaterWindow() {
		setTitle("Cinema Manager - Add Theater");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsage = new JLabel("Usage:");
		lblUsage.setBounds(10, 20, 65, 14);
		contentPane.add(lblUsage);

		comboBox = new JComboBox<>();
		comboBox.addItem("");
		comboBox.addItem("Movie");
		comboBox.addItem("Drama");
		comboBox.setBounds(116, 14, 113, 20);
		contentPane.add(comboBox);

		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(10, 42, 65, 14);
		contentPane.add(lblName);

		tfName = new JTextField();
		tfName.setBounds(116, 39, 113, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);

		JLabel lblNewLabel = new JLabel("Capacity:");
		lblNewLabel.setBounds(10, 65, 96, 14);
		contentPane.add(lblNewLabel);

		tfCap = new JTextField();
		tfCap.setColumns(10);
		tfCap.setBounds(116, 62, 113, 20);
		contentPane.add(tfCap);

		JLabel lblTicketPrice = new JLabel("Ticket Price: ");
		lblTicketPrice.setBounds(10, 90, 130, 14);
		contentPane.add(lblTicketPrice);

		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(116, 88, 34, 20);
		contentPane.add(tfPrice);

		JLabel lblSoundSystem = new JLabel("Sound System:");
		lblSoundSystem.setBounds(10, 115, 96, 14);
		contentPane.add(lblSoundSystem);

		cbSoundS = new JComboBox<String>();
		cbSoundS.addItem("Dolby Digital");
		cbSoundS.addItem("Dolby Digital Surround");
		cbSoundS.addItem("Dolby Digital Live");
		cbSoundS.addItem("Dolby Digital Plus");
		cbSoundS.addItem("Dolby TrueHD");
		cbSoundS.setBounds(116, 112, 145, 20);
		contentPane.add(cbSoundS);

		JLabel lblScreen = new JLabel("Screen:");
		lblScreen.setBounds(10, 140, 46, 14);
		contentPane.add(lblScreen);

		tfScreen = new JTextField();
		tfScreen.setColumns(10);
		tfScreen.setBounds(116, 138, 34, 20);
		contentPane.add(tfScreen);

		JLabel lblInches = new JLabel("inches - ");
		lblInches.setBounds(157, 143, 56, 14);
		contentPane.add(lblInches);

		chckb3D = new JCheckBox("");
		chckb3D.setBounds(232, 139, 21, 23);
		contentPane.add(chckb3D);

		JLabel lbld = new JLabel("3D");
		lbld.setBounds(215, 143, 21, 14);
		contentPane.add(lbld);

		JLabel lblDressingRoom = new JLabel("Dressing Room #:");
		lblDressingRoom.setBounds(10, 165, 113, 14);
		contentPane.add(lblDressingRoom);

		tfDress = new JTextField();
		tfDress.setColumns(10);
		tfDress.setBounds(116, 164, 34, 20);
		contentPane.add(tfDress);

		JLabel lblTheaterRowsOf = new JLabel("Theater Rows of seats:");
		lblTheaterRowsOf.setBounds(10, 190, 219, 14);
		contentPane.add(lblTheaterRowsOf);

		
		model = new DefaultListModel<Row>();
		list = new JList<>();
		list.setModel(model);
		list.setBounds(10, 209, 219, 165);
		pane = new JScrollPane(list);
		pane.setBounds(10, 209, 219, 165);
		contentPane.add(pane);

		JButton btnNewButton = new JButton("Add Row");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addRow();
			}
		});
		btnNewButton.setBounds(232, 270, 89, 40);
		contentPane.add(btnNewButton);

		tfSeats = new JTextField();
		tfSeats.setBounds(332, 206, 34, 23);
		contentPane.add(tfSeats);
		tfSeats.setColumns(10);

		JLabel lblNumberOfSeats = new JLabel("Number of seats:");
		lblNumberOfSeats.setBounds(232, 210, 105, 14);
		contentPane.add(lblNumberOfSeats);

		btnNewButton_1 = new JButton("Add Theater");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addTheater();
			}
		});
		btnNewButton_1.setBounds(10, 385, 251, 40);
		contentPane.add(btnNewButton_1);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(271, 402, 89, 23);

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				enableItems();
			}
		});
		disableItems();

		contentPane.add(btnClose);
	}

	/**
	 * Adds a theater to the mainlist.
	 */
	protected void addTheater() {
		// TODO Auto-generated method stub
		boolean good =checkContent();
		if (good == false) {
			JOptionPane.showMessageDialog(this, (String) "Please fill in all fields!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
		}
		else if (comboBox.getSelectedIndex() == 1) {
			try {
				MovieTheater mt = new MovieTheater(tfName.getText(),
						Integer.parseInt(tfCap.getText()),
						Double.parseDouble(tfScreen.getText()),
						chckb3D.isSelected(),
						(String) cbSoundS.getSelectedItem());
				for (int i = 1; i < model.getSize(); i++) {
					mt.addRow(model.getElementAt(i));
				}
				AdminActions.cinema.addMovieTheater(mt);
				JOptionPane.showMessageDialog(this,
						(String) "Movie Theater added successfully!",
						"Movie Theater", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,
						(String) "Make sure your input is correct.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (comboBox.getSelectedIndex() == 2) {
			try {
				DramaTheater dt = new DramaTheater(tfName.getText(),
						Integer.parseInt(tfCap.getText()),
						Integer.parseInt(tfDress.getText()));
				for (int i = 1; i < model.getSize(); i++) {
					dt.addRow(model.getElementAt(i));
				}
				AdminActions.cinema.addDramaTheater(dt);
				JOptionPane.showMessageDialog(this,
						(String) "Drama Theater added successfully!",
						"Drama Theater", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,
						(String) "Make sure your input is correct.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Adds a row in the list.
	 */
	protected void addRow() {
		// TODO Auto-generated method stub
		if (tfSeats.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					(String) "Please fill in the number of seats the row has!",
					"Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int seats;
			try {
				seats = Integer.parseInt(tfSeats.getText());
				Row row = new Row(model.getSize() + 1, seats);
				model.addElement(row);
			} catch (NumberFormatException e) {
				JOptionPane
						.showMessageDialog(
								this,
								(String) "The value of number of seats is wrong! Make sure it's an integer.",
								"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Disables all the components.
	 */
	private void disableItems() {
		// TODO Auto-generated method stub
		tfCap.setEnabled(false);
		tfDress.setEnabled(false);
		tfName.setEnabled(false);
		tfPrice.setEnabled(false);
		tfScreen.setEnabled(false);
		chckb3D.setEnabled(false);
		tfSeats.setEnabled(false);
		cbSoundS.setEnabled(false);
	}
	/**
	 * Enables the necessary components based on the combobox index.
	 */
	protected void enableItems() {
		// TODO Auto-generated method stub
		disableItems();
		if (comboBox.getSelectedIndex() == 1) {
			tfCap.setEnabled(true);
			tfName.setEnabled(true);
			tfPrice.setEnabled(true);
			tfScreen.setEnabled(true);
			chckb3D.setEnabled(true);
			tfSeats.setEnabled(true);
			cbSoundS.setEnabled(true);
		} else if (comboBox.getSelectedIndex() == 2) {
			tfName.setEnabled(true);
			tfCap.setEnabled(true);
			tfSeats.setEnabled(true);
			tfDress.setEnabled(true);
		}
	}
	/**
	 * Checks if the necessary fields are filled in.
	 * @return
	 */
	protected boolean checkContent() {
		// TODO Auto-generated method stub
		boolean good = true;
		if (tfName.getText().isEmpty() || tfCap.getText().isEmpty() || (tfDress.getText().isEmpty() && comboBox.getSelectedIndex() == 2) || (tfPrice.getText().isEmpty() && comboBox.getSelectedIndex() == 1)
				|| (tfScreen.getText().isEmpty() && comboBox.getSelectedIndex() == 1)) {
			good = false;
		}
		
		return good;
	}
}
