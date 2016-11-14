package AdminGUI;


import javax.swing.JOptionPane;

import logic.Drama;
import logic.Movie;
import logic.Show;
/**
 * Extends AddScreeningWindow and used for editing a show.
 * @author Thanasis Tolikas
 *
 */
public class EditShowWindow extends AddShowWindow {

	Show show;


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public EditShowWindow(Show show) {
		super();
		this.show = show;
		btnAddShow.setText("Edit Show");
		if (show instanceof Movie) {
			comboBox.setSelectedIndex(1);
			tfName.setText(show.getName());
			tfDir.setText(show.getDirector());
			tfDur.setText("" +((Movie)show).getDuration());
			taDesc.setText(show.getDescription());
			for (String s : show.getActors()) {
				taActors.append(s + "\n");
			}
		}
		else {
			comboBox.setSelectedIndex(2);
			tfName.setText(show.getName());
			tfDir.setText(show.getDirector());
			taDesc.setText(show.getDescription());
			for (String s : show.getActors()) {
				taActors.append(s + "\n");
			}
			tfPrice.setText("" + ((Drama)show).getPrice());
		}
	}
	/**
	 * Updates the show that was being edited.
	 */
	@Override
	protected void addShow() {
		boolean good =checkContent();
		if (good == false) {
			JOptionPane.showMessageDialog(this, (String) "Please fill in all fields!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
		}
		else if (comboBox.getSelectedIndex() == 1) {
			show.changeName(tfName.getText());
			show.changeDirector(tfDir.getText());
			show.changeDescription(taDesc.getText());
			show.emptyActorsArray();
			String[] actors = taActors.getText().split(" ");
			for (String a : actors) {
				show.addActor(a);
			}
			((Movie) show).changeDuration(Integer.parseInt(tfDur.getText()));
			JOptionPane.showMessageDialog(this, (String) "Movie edit successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			
			this.dispose();
		}
		else if (comboBox.getSelectedIndex() == 2) {
			show.changeName(tfName.getText());
			show.changeDirector(tfDir.getText());
			show.changeDescription(taDesc.getText());
			show.emptyActorsArray();
			String[] actors = taActors.getText().split(" ");
			for (String a : actors) {
				show.addActor(a);
			}
			((Drama) show).setPrice(Double.parseDouble(tfDur.getText()));
			JOptionPane.showMessageDialog(this, (String) "Drama edit successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

}
