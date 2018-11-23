package View_Cassino;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller_Cassino.Thread_Cassino;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Main_Cassino extends JFrame {

	private JPanel contentPane;
	private JTextField textNum01;
	private JTextField textNum02;
	private JTextField textNum03;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Cassino frame = new Main_Cassino();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_Cassino() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNum01 = new JTextField();
		textNum01.setEnabled(false);
		textNum01.setFont(new Font("Microsoft Himalaya", Font.BOLD, 94));
		textNum01.setHorizontalAlignment(SwingConstants.CENTER);
		textNum01.setText("0");
		textNum01.setBounds(55, 59, 86, 87);
		contentPane.add(textNum01);
		textNum01.setColumns(10);
		
		textNum02 = new JTextField();
		textNum02.setEnabled(false);
		textNum02.setFont(new Font("Microsoft Himalaya", Font.BOLD, 94));
		textNum02.setHorizontalAlignment(SwingConstants.CENTER);
		textNum02.setText("0");
		textNum02.setBounds(178, 59, 86, 87);
		contentPane.add(textNum02);
		textNum02.setColumns(10);
		
		textNum03 = new JTextField();
		textNum03.setEnabled(false);
		textNum03.setHorizontalAlignment(SwingConstants.CENTER);
		textNum03.setText("0");
		textNum03.setFont(new Font("Microsoft Himalaya", Font.BOLD, 94));
		textNum03.setBounds(297, 59, 86, 87);
		contentPane.add(textNum03);
		textNum03.setColumns(10);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rand = new Random();
			
				int n1=0,n2=0,n3=0;
				n1 =rand.nextInt(150)+1;
				Thread jogo1 = new Thread_Cassino(textNum01,btnIniciar, n1);
				n2 =rand.nextInt(150)+1;
				Thread jogo2 = new Thread_Cassino(textNum02, btnIniciar,n2);
				n3 =rand.nextInt(150)+1;
				Thread jogo3= new Thread_Cassino(textNum03, btnIniciar,n3);
				jogo1.start();
				jogo2.start();
				jogo3.start();
				
                
			
			}
		});
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIniciar.setBounds(37, 203, 89, 32);
		contentPane.add(btnIniciar);
	}
}
