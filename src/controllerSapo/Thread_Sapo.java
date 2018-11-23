package controllerSapo;

import java.util.Random;





public class Thread_Sapo extends Thread {
	private String nome;
	private int salto;
	private static int chegada=1;
	
	boolean para =false;
	
	public Thread_Sapo(String nome,int salto) {
		 this.nome =nome;
		 this.salto =salto;
		
	}
	public void run() {
		corridasapo();
	}
	@SuppressWarnings("deprecation")
	public void corridasapo() {
		 int valor;
		Random rand = new Random();
		 
		 try {
			 while(true) {
				 valor  =(int) rand.nextInt((100)+1);
					System.out.println(this.nome +" Salto em metros : "+valor+"  " +salto );
					salto+=valor;
					
			         Thread.sleep(30);
			         if(salto>=3000) {
			        	
			        	 System.out.println(chegada+" Colocado  :   "+this.nome+" Distancia : "+salto );
			        	 chegada+=1;
			        	stop();
			        	// parar();
			         }
			         synchronized(this) {
			        	 while(para) ;
			        		
			        	 
			         }
			 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	public void parar() {
		this.para =true;
	}

}
