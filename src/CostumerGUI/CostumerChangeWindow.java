package CostumerGUI;


import logic.Screening;
/**
 * This window is used for changing costumer's reservation.  
 * @author Thanasis Tolikas
 *
 */
public class CostumerChangeWindow extends CostumerCancel {

	private static final long serialVersionUID = 1L;

	public CostumerChangeWindow() {
		super();
		btnNewButton_1.setText("Change Reservation");
	}

	/**
	 * Executes when the change reservation button is pushed.
	 *
	 */
	@Override
	protected void button() {
		Screening s = CostumerActions.cinema.findCostumer(tfTel.getText()).getReservedScreeningInfo();
		CostumerActions.cinema.cancelCostumerReservation(tfTel.getText());
		CostumerSeatChooser win = new CostumerSeatChooser (s);
		win.setVisible(true);
	}
}
