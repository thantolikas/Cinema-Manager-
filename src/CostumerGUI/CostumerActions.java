package CostumerGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logic.Cinema;
import logic.Costumer;
import logic.Drama;
import logic.DramaScreening;
import logic.DramaTheater;
import logic.Movie;
import logic.MovieScreening;
import logic.MovieTheater;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Displays the available actions for the costumer and lunches the necessary windows.
 * @author Thanasis Tolikas
 *
 */
public class CostumerActions extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static Cinema cinema = new Cinema();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostumerActions frame = new CostumerActions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CostumerActions() throws ClassNotFoundException {
		read();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				save();
			}
		});
		
		
	
		setTitle("Cinema Manager - Costumer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CostumerShowChooser showC = new CostumerShowChooser();
				showC.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 36, 260, 70);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CostumerCancel cc = new CostumerCancel();
				cc.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(10, 139, 260, 70);
		contentPane.add(btnCancel);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CostumerChangeWindow win = new CostumerChangeWindow();
				win.setVisible(true);
				
			}
		});
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChange.setBounds(10, 251, 260, 70);
		contentPane.add(btnChange);
		
		JLabel lblBuyTickets = new JLabel("Buy tickets");
		lblBuyTickets.setBounds(10, 11, 75, 14);
		contentPane.add(lblBuyTickets);
		
		JLabel lblCancelAReservation = new JLabel("Cancel your reservation");
		lblCancelAReservation.setBounds(10, 117, 199, 14);
		contentPane.add(lblCancelAReservation);
		
		JLabel lblChangeYourReservation = new JLabel("Change your reservation");
		lblChangeYourReservation.setBounds(10, 226, 142, 14);
		contentPane.add(lblChangeYourReservation);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(181, 345, 89, 23);
		contentPane.add(btnClose);
	}

	private void read() {
		// TODO Auto-generated method stub
		ObjectInputStream in;
		FileInputStream fis;
		try {
			fis = new FileInputStream("data\\movies.txt");
			in = new ObjectInputStream(fis);
			while (true) {
				cinema.addMovie((Movie)in.readObject());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}catch (ClassNotFoundException e ){
			//e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream("data\\dramas.txt");
			in = new ObjectInputStream(fis);
			while (true) {
				cinema.addDrama((Drama)in.readObject());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}catch (ClassNotFoundException e ){
			//e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream("data\\movietheaters.txt");
			in = new ObjectInputStream(fis);
			while (true) {
				cinema.addMovieTheater((MovieTheater)in.readObject());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}catch (ClassNotFoundException e ){
			//e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream("data\\dramatheaters.txt");
			in = new ObjectInputStream(fis);
			while (true) {
				cinema.addDramaTheater((DramaTheater)in.readObject());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}catch (ClassNotFoundException e ){
			//e.printStackTrace();
		}
		
		
		try {
			fis = new FileInputStream("data\\moviescreenings.txt");
			in = new ObjectInputStream(fis);
			while (true) {
				cinema.addMovieScreening((MovieScreening)in.readObject());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}catch (ClassNotFoundException e ){
			//e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream("data\\dramascreenings.txt");
			in = new ObjectInputStream(fis);
			while (true) {
				cinema.addDramaScreening((DramaScreening)in.readObject());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}catch (ClassNotFoundException e ){
			//e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream("data\\costumers.txt");
			in = new ObjectInputStream(fis);
			while (true) {
				cinema.addCostumer((Costumer)in.readObject());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}catch (ClassNotFoundException e ){
			//e.printStackTrace();
		}
		
	}

	protected void save() {
		// TODO Auto-generated method stub
		
		ObjectOutputStream out;
		FileOutputStream fis;
		for (Movie m : cinema.getMovies()) {
			try {
				fis = new FileOutputStream("data\\movies.txt");
				out = new ObjectOutputStream(fis);
				out.writeObject(m);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				//e.printStackTrace();
			}
		}
			
		for (Drama d : cinema.getDramas()) {
			try {
				fis = new FileOutputStream("data\\dramas.txt");
				out = new ObjectOutputStream(fis);
				out.writeObject(d);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				//e.printStackTrace();
			}
		}
		
		for (MovieTheater mt : cinema.getMovieTheaters()) {
			try {
				fis = new FileOutputStream("data\\movietheaters.txt");
				out = new ObjectOutputStream(fis);
				out.writeObject(mt);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				//e.printStackTrace();
			}
		}
		
		for (DramaTheater dt : cinema.getDramaTheaters()) {
			try {
				fis = new FileOutputStream("data\\dramatheaters.txt");
				out = new ObjectOutputStream(fis);
				out.writeObject(dt);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
			//	e.printStackTrace();
			}
		}
		
		for (MovieScreening ms : cinema.getMovieScreenings()) {
			try {
				fis = new FileOutputStream("data\\moviescreenings.txt");
				out = new ObjectOutputStream(fis);
				out.writeObject(ms);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				//e.printStackTrace();
			}
		}
		
		for (DramaScreening ds : cinema.getDramaScreenings()) {
			try {
				fis = new FileOutputStream("data\\dramascreenings.txt");
				out = new ObjectOutputStream(fis);
				out.writeObject(ds);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				//e.printStackTrace();
			}
		}
		
		for (Costumer c : cinema.getCostumers()) {
			try {
				fis = new FileOutputStream("data\\costumers.txt");
				out = new ObjectOutputStream(fis);
				out.writeObject(c);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				//e.printStackTrace();
			}
		}
	}
}
