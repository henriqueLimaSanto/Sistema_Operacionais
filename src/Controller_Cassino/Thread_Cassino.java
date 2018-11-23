package Controller_Cassino;


import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Thread_Cassino extends Thread{
	private JTextField textnumero;
	private JButton btnIniciar;
	private int rodadas;
	private static int pontos ;
	
	public Thread_Cassino(JTextField textNum01,JButton btnIniciar,int rodadas) {
		// TODO Auto-generated constructor stub
		this.textnumero = textNum01;
		this.btnIniciar = btnIniciar;
		this.rodadas = rodadas;
	}

	@Override
	public void run() {
		jogo();
	}
	public void jogo() {
		pontos =0;
		btnIniciar.setVisible(false);
		try {
		    for(int i=0;i<=rodadas;i++) {
		    	String valor ="";
			 Random rand = new Random();
			 valor = String.valueOf((int)rand.nextInt(6)+1);
			   textnumero.setText(valor);
			
				Thread.sleep(10);
				if(i==rodadas) {
					pontos++;
					   if(pontos == 3) {
					    	btnIniciar.setVisible(true);
					    }
					
					
				}
			   
		        }
		    
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	

}
