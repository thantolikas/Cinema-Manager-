package AdminGUI;

import javax.swing.JOptionPane;

import logic.Drama;
import logic.DramaScreening;
import logic.DramaTheater;
import logic.Movie;
import logic.MovieScreening;
import logic.MovieTheater;
import logic.Screening;
/**
 * Extends AddScreeningWindow and used for editing a screening.
 * @author Thanasis Tolikas
 *
 */
public class EditScreeningWindow extends AddScreeningWindow {

	private static final long serialVersionUID = 1L;
	private Screening s;
	public EditScreeningWindow(Screening s) {
		super();
		this.s = s;
		
		btnAdd.setText("Edit Screening");
		if (s instanceof MovieScreening) {
			cbType.setSelectedIndex(1);
			tfDate.setText(s.getDate());
			tfHour.setText(s.getHour());
			tfMins.setText(s.getMinutes());
			cbShow.setSelectedItem(((MovieScreening)s).getShow());
			cbTheater.setSelectedItem(((MovieScreening)s).getTheater());
		}
		else {
			cbType.setSelectedIndex(2);
			tfDate.setText(s.getDate());
			tfHour.setText(s.getHour());
			tfMins.setText(s.getMinutes());
			cbShow.setSelectedItem(((DramaScreening)s).getShow());
			cbTheater.setSelectedItem(((DramaScreening)s).getTheater());
		}
	}

	/**
	 * Updates the screening that was being edited.
	 */
	@Override
	protected void addScreening() {
		if (cbType.getSelectedIndex() == 1) {
			String[] date = tfDate.getText().split("/");
			s.setDate(date[0], date[1], date[2]);
			s.setTime(tfHour.getText(), tfMins.getText());
			((MovieScreening)s).setTheater((MovieTheater) cbTheater.getSelectedItem());
			((MovieScreening)s).setShow((Movie) cbShow.getSelectedItem());
			JOptionPane.showMessageDialog(this,
					(String) "Screening edit successfully!", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} else if (cbType.getSelectedIndex() == 2) {
			String[] date = tfDate.getText().split("/");
			s.setDate(date[0], date[1], date[2]);
			s.setTime(tfHour.getText(), tfMins.getText());
			((DramaScreening)s).setTheater((DramaTheater) cbTheater.getSelectedItem());
			((DramaScreening)s).setShow((Drama) cbShow.getSelectedItem());
			JOptionPane.showMessageDialog(this,
					(String) "Screening edit successfully!", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}
}
