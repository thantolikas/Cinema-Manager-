package AdminGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Drama;
import logic.Movie;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/**
 * Used for addinf a new show.
 * @author Thanasis Tolikas
 *
 */
public class AddShowWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JTextField tfName;
	protected JTextField tfDir;
	protected JTextField tfDur;
	protected JTextField tfPrice;
	protected JComboBox<String> comboBox;
	protected JTextArea taActors;
	protected JTextArea taDesc;
	protected JButton btnAddShow;

	/**
	 * Create the frame.
	 */
	public AddShowWindow() {
		setTitle("Cinema Manager - Add Show");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setBounds(100, 100, 281, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseShowType = new JLabel("Choose Show Type:");
		lblChooseShowType.setBounds(10, 13, 96, 14);
		contentPane.add(lblChooseShowType);
		
		comboBox = new JComboBox<>();
		
		comboBox.setBounds(116, 10, 101, 20);
		comboBox.addItem("");
		comboBox.addItem("Movie");
		comboBox.addItem("Drama");
		contentPane.add(comboBox);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 38, 46, 14);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(116, 35, 136, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(10, 63, 46, 14);
		contentPane.add(lblDirector);
		
		tfDir = new JTextField();
		tfDir.setColumns(10);
		tfDir.setBounds(116, 61, 136, 20);
		contentPane.add(tfDir);
		
		JLabel lblDuration = new JLabel("Duration: ");
		lblDuration.setBounds(10, 88, 71, 14);
		contentPane.add(lblDuration);
		
		tfDur = new JTextField();
		tfDur.setColumns(10);
		tfDur.setBounds(116, 87, 86, 20);
		contentPane.add(tfDur);
		
		JLabel lblMinutes = new JLabel("minutes");
		lblMinutes.setBounds(206, 92, 46, 14);
		contentPane.add(lblMinutes);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 113, 46, 14);
		contentPane.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(116, 113, 86, 20);
		contentPane.add(tfPrice);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(10, 138, 71, 14);
		contentPane.add(lblDescription);
		
		taDesc = new JTextArea();
		taDesc.setBounds(10, 163, 242, 120);
		contentPane.add(taDesc);
		
		JLabel lblListOfActorsactresses = new JLabel("List of Actors/Actresses:");
		lblListOfActorsactresses.setBounds(10, 294, 169, 14);
		contentPane.add(lblListOfActorsactresses);
		
		taActors = new JTextArea();
		taActors.setBounds(10, 319, 242, 62);
		contentPane.add(taActors);
		
		btnAddShow = new JButton("Add Show");
		btnAddShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addShow();
			}
			
		});
		btnAddShow.setBounds(143, 392, 109, 44);
		contentPane.add(btnAddShow);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				enableItems();
			}
		});
		disableItems();
	}

	/**
	 * Enables the necessary components based on the combobox index.
	 */
	protected void enableItems() {
		// TODO Auto-generated method stub
		if (comboBox.getSelectedIndex() == 0 ) {
			disableItems();
		}
		else if (comboBox.getSelectedIndex() ==  1) {
			disableItems();
			tfName.setEnabled(true);
			tfDir.setEnabled(true);
			tfDur.setEnabled(true);
			taDesc.setEnabled(true);
			taActors.setEnabled(true);
		}
		else {
			disableItems();
			tfName.setEnabled(true);
			tfDir.setEnabled(true);
			tfPrice.setEnabled(true);
			taDesc.setEnabled(true);
			taActors.setEnabled(true);
		}
	}
	/**
	 * Disables all the components.
	 */
	private void disableItems() {
		// TODO Auto-generated method stub
		tfName.setEnabled(false);
		tfDir.setEnabled(false);
		tfDur.setEnabled(false);
		tfPrice.setEnabled(false);
		taDesc.setEnabled(false);
		taActors.setEnabled(false);
	}

	/**
	 * Adds a show to the main list.
	 */
	
	protected void addShow() {
		// TODO Auto-generated method stub
		boolean good =checkContent();
		if (good == false) {
			JOptionPane.showMessageDialog(this, (String) "Please fill in all fields!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
		}
		else if (comboBox.getSelectedIndex() == 1) {
			Movie movie = new Movie(tfName.getText(), taDesc.getText(), tfDir.getText());
			movie.changeDuration(Integer.parseInt(tfDur.getText()));
			String[] actors = taActors.getText().split(" ");
			for (String a : actors) {
				movie.addActor(a);
			}
			AdminActions.cinema.addMovie(movie);
			JOptionPane.showMessageDialog(this, (String) "Movie added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();

			
		}
		else if (comboBox.getSelectedIndex() == 2) {
			Drama drama = new Drama(tfName.getText(), taDesc.getText(), tfDir.getText());
			drama.setPrice(Double.parseDouble(tfPrice.getText()));
			String[] actors = taActors.getText().split(" ");
			for (String a : actors) {
				drama.addActor(a);
			}
			AdminActions.cinema.addDrama(drama);
			JOptionPane.showMessageDialog(this, (String) "Drama added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();

		}
		
	}

	/**
	 * Checks if the necessary fields are filled in.
	 * @return
	 */
	protected boolean checkContent() {
		// TODO Auto-generated method stub
		boolean good = true;
		if (tfName.getText().isEmpty() || tfDir.getText().isEmpty() || (tfDur.getText().isEmpty() && comboBox.getSelectedIndex()==1) || (tfPrice.getText().isEmpty() && comboBox.getSelectedIndex()==2) || taDesc.getText().isEmpty()) {
			good = false;
		}
		
		return good;
	}
}
