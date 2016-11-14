package AdminGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
/**
 * Displays the available actions for the admin.
 * @author Thanasis Tolikas
 *
 */
public class AdminActions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static Cinema cinema = new Cinema();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminActions frame = new AdminActions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public AdminActions()  {
		read();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				save();
			}
		});
		
		
		
		setResizable(false);
		setTitle("Cinema Manager - Admin");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Manage Shows");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainShowWindow msw = new MainShowWindow();
				msw.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 230, 86);
		contentPane.add(btnNewButton);
		
		JButton btnManageTheaters = new JButton("Manage Theaters");
		btnManageTheaters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainTheaterWindow mtw = new MainTheaterWindow();
				mtw.setVisible(true);
			}
		});
		btnManageTheaters.setBounds(10, 108, 230, 86);
		contentPane.add(btnManageTheaters);
		
		JButton btnManageScreenings = new JButton("Manage Screenings");
		btnManageScreenings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainScreeningWindow msw = new MainScreeningWindow();
				msw.setVisible(true);
			}
		});
		btnManageScreenings.setBounds(10, 205, 230, 86);
		contentPane.add(btnManageScreenings);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnClose.setBounds(151, 319, 89, 23);
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

	private void exit() {
		save();
		dispose();
	}
}
