package CostumerGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Drama;
import logic.DramaScreening;
import logic.Movie;
import logic.MovieScreening;
import logic.Screening;
import logic.Show;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
/**
 * This windows is used for the user to choose show and screening and lunches a CostumerSeatChooser window.
 * @author Thanasis Tolikas
 *
 */
public class CostumerShowChooser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pane;
	private JList<Show> listShow;
	private JList<Screening> listScr;
	private JComboBox<String> cbType;
	private DefaultListModel<Show> showModel;
	private DefaultListModel<Screening> scrModel;


	public CostumerShowChooser() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 498);
		pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		pane.setLayout(null);
		
		JLabel lblIWantTo = new JLabel("I want to buy tickets for:");
		lblIWantTo.setBounds(10, 11, 152, 14);
		pane.add(lblIWantTo);
		
		cbType = new JComboBox<>();
		cbType.addItem("");
		cbType.addItem("Movie");
		cbType.addItem("Drama");
		cbType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				refresh();
			}
		});
		cbType.setBounds(172, 8, 106, 20);
		pane.add(cbType);
		
		JLabel lblChooseMoviedrama = new JLabel("Choose Movie/Drama");
		lblChooseMoviedrama.setBounds(30, 50, 141, 14);
		pane.add(lblChooseMoviedrama);
		
		showModel = new DefaultListModel<Show>();
		listShow = new JList<>();
		listShow.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				 showDates();
			}
		});
		listShow.setModel(showModel);
		listShow.setBounds(10, 75, 141, 374);
		pane.add(listShow);
		
		JLabel lblChooseDate = new JLabel("Choose Screening");
		lblChooseDate.setBounds(251, 50, 109, 14);
		pane.add(lblChooseDate);
		
		scrModel = new DefaultListModel<Screening>();
		listScr = new JList<>();
		listScr.setModel(scrModel);
		listScr.setBounds(161, 75, 292, 374);
		pane.add(listScr);
		
		
		JButton btnChooseSeats = new JButton("Choose seats");
		btnChooseSeats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CostumerSeatChooser seatC = new CostumerSeatChooser(listScr.getSelectedValue());
				seatC.setVisible(true);
			}
		});
		btnChooseSeats.setBounds(463, 346, 158, 69);
		pane.add(btnChooseSeats);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(463, 426, 161, 23);
		pane.add(btnNewButton);
	}


	/**
	 * Displays the available screening dates on the list.
	 *
	 */
	protected void showDates() {
		// TODO Auto-generated method stub
		scrModel.removeAllElements();
		if (cbType.getSelectedIndex() == 1 ) {
			Movie m = (Movie) listShow.getSelectedValue();
			for (MovieScreening s : CostumerActions.cinema.getMovieScreenings()) {
				if (s.getShow().equals(m)) scrModel.addElement(s);
			}
		}
		else if (cbType.getSelectedIndex() == 2) {
			Drama d = (Drama) listShow.getSelectedValue();

			for (DramaScreening s : CostumerActions.cinema.getDramaScreenings()) {
				if (s.getShow().equals(d)) scrModel.addElement(s);

			}

		}
	}

/**
 * Refreshes the content of the list that displays the shows based on the selected combobox index.
 */
	protected void refresh() {
		// TODO Auto-generated method stub
		showModel.removeAllElements();
		if (cbType.getSelectedIndex() == 1 ) {
			for (Movie m : CostumerActions.cinema.getMovies()) {
				showModel.addElement(m);
			}
		}
		else if (cbType.getSelectedIndex() == 2) {
			for (Drama d : CostumerActions.cinema.getDramas()) {
				showModel.addElement(d);
			}
		}
	}
}
