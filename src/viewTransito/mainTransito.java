package viewTransito;


import java.awt.EventQueue;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllerTransito.Threadcontroller;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class mainTransito extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private static JLabel lblOeste = new JLabel("CarroOeste");
	private static JLabel lblLeste = new JLabel("CarroLeste");
	private static JLabel lblNorte = new JLabel("");
	private static JLabel lblSul = new JLabel("");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainTransito frame = new mainTransito();
					frame.setVisible(true);
					metodos();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public mainTransito() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 585);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblOeste.setIcon(new ImageIcon(mainTransito.class.getResource("/viewTransito/oeste.jpg")));
		
	
		
		lblOeste.setText("CarroOeste");
		//lblNewLabel.setIcon(image);
		lblOeste.setBounds(100, 228, 72, 29);
		contentPane.add(lblOeste);
		lblLeste.setIcon(new ImageIcon(mainTransito.class.getResource("/viewTransito/leste.jpg")));

		
		lblLeste.setBackground(Color.BLACK);
		lblLeste.setBounds(480, 270, 72, 29);
		contentPane.add(lblLeste);
		lblNorte.setIcon(new ImageIcon(mainTransito.class.getResource("/viewTransito/norte.jpg")));
		
		
		
		lblNorte.setText("C\r\na\r\nr\r\nr\r\no\r\nN\r\no\r\nr\r\nt\r\ne");
		lblNorte.setBounds(340, 60, 37, 68);
		contentPane.add(lblNorte);
		lblSul.setIcon(new ImageIcon(mainTransito.class.getResource("/viewTransito/sul.jpg")));
      
	
		lblSul.setText("CarroSul");
		lblSul.setBounds(280, 400, 40, 73);
		contentPane.add(lblSul);
		
		textField = new JTextField();
		textField.setBackground(new Color(0, 255, 255));
		textField.setBounds(280, 228, 97, 71);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.enable(false);
		
		
	}
	public static void  metodos() {
		int permits = 1;
		Semaphore semaforo = new Semaphore(permits);
		
		Thread carro = new Threadcontroller(lblLeste, 380, semaforo, 2);
		Thread carro1 = new Threadcontroller(lblNorte, 160,  semaforo, 1);
		Thread carro2 = new Threadcontroller(lblOeste, 200, semaforo,4);
		Thread carro3 = new Threadcontroller(lblSul,300, semaforo, 3);
		
		
		carro.start();
		carro1.start();
		carro2.start();
		carro3.start();
		
		
	}
     
}
