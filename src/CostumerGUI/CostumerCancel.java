package CostumerGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This window is used for canceling a costumer's reservation.  
 * @author Thanasis Tolikas
 *
 */
public class CostumerCancel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JTextField tfTel;
	protected JButton btnNewButton_1;


	public CostumerCancel() {
		setTitle("Cinema Manager - Costumer");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter your telephone number");
		lblNewLabel.setBounds(20, 11, 263, 14);
		contentPane.add(lblNewLabel);
		
		tfTel = new JTextField();
		tfTel.setBounds(20, 36, 175, 20);
		contentPane.add(tfTel);
		tfTel.setColumns(10);
		
		btnNewButton_1 = new JButton("Cancel Reservation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(20, 67, 175, 63);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(20, 141, 175, 23);
		contentPane.add(btnNewButton);
	}

	/**
	 * Executes if the cancel reservation button is pressed. Cancels the reservation.
	 */
	protected void button() {
		// TODO Auto-generated method stub
		if (CostumerActions.cinema.cancelCostumerReservation(tfTel.getText())) {
			JOptionPane.showConfirmDialog(this, "Success","Success", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(this, "There is not reservation made with this telephone number. Please make sure you have entered your telephone number correclty", "Error" , JOptionPane.ERROR_MESSAGE);
		}
	}
}
