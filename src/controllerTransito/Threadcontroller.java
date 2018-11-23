package controllerTransito;

import java.awt.Rectangle;
import java.util.concurrent.Semaphore;

import javax.swing.JLabel;

public class Threadcontroller extends Thread{
	private JLabel carro;
	private int chegada;
	private int posAtual;
	private Semaphore semaforo;
	private int lado;
	
	 public Threadcontroller(JLabel carro,int chegada,Semaphore semaforo,int lado) {
		this.carro = carro;
		this.chegada = chegada;
		//this.posAtual = posAtual;
		this.semaforo = semaforo;
		this.lado = lado;
		
	
	 }
      @Override
    public void run() {
       largada();
       
       try {
		semaforo.acquire();
	       saidaDoSemaforo();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		semaforo.release();
	}
      
    }

  	private void largada()  {
  		// TODO Auto-generated method stub
  		Rectangle valor = carro.getBounds();
  		
  		
  		while(chegada!= posAtual) {
  			
  			
  		
  			switch(lado) {
  			
  		
  			
  			case 1:
  				valor.y+=10;
  				posAtual = valor.y;
  				carro.setBounds(valor);
  				break;
  			case 2:
  				valor.x-=10;
  				posAtual = valor.x;
  				carro.setBounds(valor);
  				break;
  			case 3:
  				valor.y-=10;
  				
  				posAtual = valor.y;
  				carro.setBounds(valor);
  				System.out.println(posAtual+"  "+chegada);
  				break;
  			case 4:
  				valor.x+=10;
  				posAtual = valor.x;
  				carro.setBounds(valor);
  				break;
  			}
  			try {
  				Thread.sleep(100);
  			
  			} catch (InterruptedException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  			
  		}
		
	}
	private void saidaDoSemaforo() {
		// TODO Auto-generated method stub
		Rectangle valor = carro.getBounds();
		int carroAnda = 20;
		while(carroAnda<100) {
		switch(lado) {
		
  	
		
		case 1:
			valor.y+=carroAnda;
			posAtual = valor.y;
			carro.setBounds(valor);
			break;
		case 2:
			valor.x-=carroAnda;
			posAtual = valor.x;
			carro.setBounds(valor);
			break;
		case 3:
			valor.y-=carroAnda;
			posAtual = valor.y;
			carro.setBounds(valor);
			break;
		case 4:
			valor.x+=carroAnda;
			posAtual = valor.x;
			carro.setBounds(valor);
			break;
  		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carroAnda+=20;
		}
	}
	

	
	
}
