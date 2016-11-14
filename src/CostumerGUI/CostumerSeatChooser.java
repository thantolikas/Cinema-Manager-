package CostumerGUI;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import logic.Costumer;
import logic.DramaScreening;
import logic.MovieScreening;
import logic.Screening;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Displays the seats to the user. and makes the reservation.
 * @author Thanasis Tolikas
 *
 */
public class CostumerSeatChooser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Screening s;
	private JTextField tfName;
	private JTextField tfTel;
	private final JButton btnNewButton = new JButton("Cancel");
	private ArrayList<JLabel> seatChosen = new ArrayList<JLabel>();
	private JTextArea taSeats;
	private JScrollPane p;

	/**
	 * Create the frame.
	 */
	public CostumerSeatChooser(Screening s) {
		this.s = s;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1094, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel seatPanel = new JPanel();
		seatPanel.setBounds(0, 0, 706, 702);
		contentPane.add(seatPanel);
		seatPanel.setLayout(null);

		// JLabel lblNewLabel4 = new JLabel("1");
		// lblNewLabel4.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseClicked(MouseEvent arg0) {
		// }
		// });
		// lblNewLabel4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		// lblNewLabel4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// lblNewLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		// lblNewLabel4.setBounds(26, 0, 20, 20);
		//
		// seatPanel.add(lblNewLabel4);

		JPanel infoPane = new JPanel();
		infoPane.setBounds(706, 0, 372, 702);
		contentPane.add(infoPane);
		infoPane.setLayout(null);

		JLabel lblShow = new JLabel("Show: ");
		lblShow.setBounds(10, 40, 46, 14);
		infoPane.add(lblShow);

		JLabel lblScreeningInformation = new JLabel("Screening Information");
		lblScreeningInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScreeningInformation.setBounds(89, 11, 193, 22);
		infoPane.add(lblScreeningInformation);

		JLabel lblShowIn = new JLabel();
		lblShowIn.setBounds(53, 40, 299, 14);
		infoPane.add(lblShowIn);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 65, 46, 14);
		infoPane.add(lblDate);

		JLabel lblDateIn = new JLabel(s.getDate());
		lblDateIn.setBounds(53, 65, 299, 14);
		infoPane.add(lblDateIn);

		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(10, 90, 46, 14);
		infoPane.add(lblTime);

		JLabel lblTimeIn = new JLabel(s.getTime());
		lblTimeIn.setBounds(53, 90, 299, 14);
		infoPane.add(lblTimeIn);

		JLabel lblCostumerInformation = new JLabel("Costumer Information");
		lblCostumerInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCostumerInformation.setBounds(89, 150, 193, 22);
		infoPane.add(lblCostumerInformation);

		JLabel lblFullName = new JLabel("Full Name: ");
		lblFullName.setBounds(10, 203, 88, 14);
		infoPane.add(lblFullName);

		tfName = new JTextField();
		tfName.setBounds(83, 200, 269, 20);
		infoPane.add(tfName);
		tfName.setColumns(10);

		JLabel lblTelephoneNumber = new JLabel("Telephone:");
		lblTelephoneNumber.setBounds(10, 242, 102, 14);
		infoPane.add(lblTelephoneNumber);

		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(83, 239, 269, 20);
		infoPane.add(tfTel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(242, 660, 120, 31);
		infoPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Buy/Book Tickets");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buyticket();
			}
		});
		btnNewButton_1.setBounds(131, 464, 139, 91);
		infoPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Theater:");
		lblNewLabel_1.setBounds(10, 118, 88, 14);
		infoPane.add(lblNewLabel_1);

		JLabel lblTheaterIn = new JLabel("");
		lblTheaterIn.setBounds(63, 115, 299, 24);
		infoPane.add(lblTheaterIn);

		if (s instanceof MovieScreening) {
			lblTheaterIn.setText(((MovieScreening) s).getTheater().getName());
			lblShowIn.setText(((MovieScreening) s).getShow().getName());
		} else {
			lblTheaterIn.setText(((DramaScreening) s).getTheater().getName());
			lblShowIn.setText(((DramaScreening) s).getShow().getName());
		}

		taSeats = new JTextArea();
		taSeats.setBounds(10, 292, 352, 130);
		taSeats.setEditable(false);
		p = new JScrollPane(taSeats);
		p.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p.setBounds(10, 292, 352, 130);
		infoPane.add(p);

		JLabel lblYouHaveChosen = new JLabel(
				"You have chosen the following seats:");
		lblYouHaveChosen.setBounds(10, 277, 245, 14);
		infoPane.add(lblYouHaveChosen);

		if (s instanceof MovieScreening) {
			for (int i = 0; i < ((MovieScreening) s).getTheater()
					.getNumOfRows(); i++) {
				for (int j = 0; j < ((MovieScreening) s).getTheater().getRows()
						.get(i).getNumOfSeats(); j++) {
					JLabel lblNewLabel = new JLabel("" + (j + 1));
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
					lblNewLabel.setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setBounds(j * 20, i * 20, 20, 20);
					lblNewLabel.setOpaque(true);
					
					if (((MovieScreening) s).getTheater().getRows()
						.get(i).getSeatAt(j).isAvailable()) {
						lblNewLabel.setBackground(Color.YELLOW);
						lblNewLabel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if (((JLabel) arg0.getComponent()).getBackground() == Color.YELLOW) {
									((JLabel) arg0.getComponent())
											.setBackground(Color.GREEN);
									((JLabel) arg0.getComponent()).repaint();
									seatChosen.add(((JLabel) arg0.getComponent()));
									inform();
								} else {
									seatChosen.remove(((JLabel) arg0.getComponent()));
									((JLabel) arg0.getComponent())
											.setBackground(Color.YELLOW);
									inform();
								}

							}
						});
					}
					else {
						lblNewLabel.setBackground(Color.RED);
						lblNewLabel.setEnabled(false);
					}
					seatPanel.add(lblNewLabel);
				}
			}
		} else {
			for (int i = 0; i < ((DramaScreening) s).getTheater()
					.getNumOfRows(); i++) {
				for (int j = 0; j < ((DramaScreening) s).getTheater().getRows()
						.get(i).getNumOfSeats(); j++) {
					JLabel lblNewLabel = new JLabel("" + (j + 1));
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
					lblNewLabel.setBorder(BorderFactory
							.createLineBorder(Color.BLACK));
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setBounds(j * 20, i * 20, 20, 20);
					lblNewLabel.setOpaque(true);
					
					if (((DramaScreening) s).getTheater().getRows()
						.get(i).getSeatAt(j).isAvailable()) {
						lblNewLabel.setBackground(Color.YELLOW);
						lblNewLabel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if (((JLabel) arg0.getComponent()).getBackground() == Color.YELLOW) {
									((JLabel) arg0.getComponent())
											.setBackground(Color.GREEN);
									((JLabel) arg0.getComponent()).repaint();
									seatChosen.add(((JLabel) arg0.getComponent()));
									inform();
								} else {
									seatChosen.remove(((JLabel) arg0.getComponent()));
									((JLabel) arg0.getComponent())
											.setBackground(Color.YELLOW);
									inform();
								}

							}
						});
					}
					else {
						lblNewLabel.setBackground(Color.RED);
						lblNewLabel.setEnabled(false);
					}
					seatPanel.add(lblNewLabel);
				}
			}
		}
	}

	/**
	 * Executes when the buy tickets button is pushed. 
	 * @author Thanasis Tolikas
	 *
	 */
	protected void buyticket() {
		// TODO Auto-generated method stub
		if (!tfName.getText().isEmpty() && !tfTel.getText().isEmpty()) {
			Costumer c = new Costumer(tfName.getText(), tfTel.getText(), s);
			if (s instanceof MovieScreening) {
				for (JLabel l : seatChosen) {
					int row = l.getY() / 20;
					int seat = l.getX() / 20; 
					((MovieScreening) s).getTheater().getRows().get(row).getSeatAt(seat).setAvailability(false);
					((MovieScreening) s).getTheater().getRows().get(row).getSeatAt(seat).setCostumer(c);

				}
			}
			else {
				for (JLabel l : seatChosen) {
					int row = l.getY() / 20;
					int seat = l.getX() / 20; 
					((DramaScreening) s).getTheater().getRows().get(row).getSeatAt(seat).setAvailability(false);
					((DramaScreening) s).getTheater().getRows().get(row).getSeatAt(seat).setCostumer(c);

				}
			}
			CostumerActions.cinema.addCostumer(c);
			JOptionPane.showMessageDialog(this, "Seats booked!", "Sucess", JOptionPane.PLAIN_MESSAGE);
			dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "Please fill in the required fields!","Error",JOptionPane.OK_OPTION);
		}
		
	}

	/**
	 * Refreshes the content of the text area used for displaying the choosen seats.
	 */
	protected void inform() {
		// TODO Auto-generated method stub
		taSeats.setText("");
		for (JLabel l : seatChosen) {
			int row = l.getY() / 20;
			int seat = l.getX() / 20;
			taSeats.append("Row: " + (row + 1) + " Seat: " + (seat + 1) + "\n");
		}
		p.revalidate();
		p.repaint();
	}
}
