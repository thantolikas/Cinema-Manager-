package AdminGUI;

import javax.swing.JOptionPane;

import logic.DramaTheater;
import logic.MovieTheater;
import logic.Row;
import logic.Theater;
/**
 * Extends AddScreeningWindow and used for editing a show.
 * @author Thanasis Tolikas
 *
 */


public class EditTheaterWindow extends AddTheaterWindow {

	Theater t;

	private static final long serialVersionUID = 1L;

	public EditTheaterWindow(Theater t) {
		super();
		this.t = t;
		btnNewButton_1.setText("Edit Theater");
		if (t instanceof MovieTheater) {
			comboBox.setSelectedIndex(1);;
			tfName.setText(t.getName());
			tfCap.setText("" + t.getCapacity());
			tfPrice.setText("" + ((MovieTheater)t).getTicketPrice());
			tfScreen.setText("" + ((MovieTheater) t).getScreenInfo().getSize());
			chckb3D.setSelected(((MovieTheater) t).getScreenInfo().is3dCapable());
			for (Row r : t.getRows()) {
				model.addElement(r);
			}
		}
		else {
			comboBox.setSelectedIndex(2);
			tfName.setText(t.getName());
			tfCap.setText("" + t.getCapacity());
			tfDress.setText(""+((DramaTheater)t).getNumOfDressingRooms());
			for (Row r : t.getRows()) {
				model.addElement(r);
			}
		}
		
	}

	/**
	 * Updates the screening that was being edited.
	 */
	@Override
	protected void addTheater() {
		boolean good =checkContent();
		if (good == false) {
			JOptionPane.showMessageDialog(this, (String) "Please fill in all fields!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
		}
		else if (comboBox.getSelectedIndex() == 1) {
			t.changeName(tfName.getText());
			t.changeCapacity(Integer.parseInt(tfCap.getText()));
			((MovieTheater)t).getScreenInfo().changeSize(Double.parseDouble(tfScreen.getText()));
			((MovieTheater)t).getScreenInfo().change3d(chckb3D.isSelected());
			((MovieTheater)t).setTicketPrice(Double.parseDouble(tfPrice.getText()));
			t.emptyRows();
			for (int i = 1; i < model.getSize(); i++) {
				t.addRow(model.getElementAt(i));
			}
			JOptionPane.showMessageDialog(this, (String) "Theater edit successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
		else if (comboBox.getSelectedIndex() == 2) {
			t.changeName(tfName.getText());
			t.changeCapacity(Integer.parseInt(tfCap.getText()));
			((DramaTheater)t).changeNoDR(Integer.parseInt(tfDress.getText()));
			t.emptyRows();
			for (int i = 1; i < model.getSize(); i++) {
				t.addRow(model.getElementAt(i));
			}
			JOptionPane.showMessageDialog(this, (String) "Theater edit successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}
}
