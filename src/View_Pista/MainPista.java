package View_Pista;

import java.util.concurrent.Semaphore;

import Controller_Pista.ThreadPista;

public class MainPista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] escuderia = new String[7];
		escuderia[0] ="Ferrari";
		escuderia[1] ="Lamborghini";
		escuderia[2] ="Porsche";
		escuderia[3] ="Mercedes";
		escuderia[4] ="MacLaren";
		escuderia[5] ="Red Bull Rancing";
		String carro1 =" carro 1";
		String carro2 =" carro 2";
		
		for(int i =0;i<=5;i++) {
			
			long tempo = 0;
			int saidaDoBox = 0;
			Semaphore semaforo = new Semaphore(1);
			Thread scuderia = new ThreadPista(escuderia[i], carro1, tempo, semaforo, saidaDoBox);
			Thread scuderia1 = new ThreadPista(escuderia[i], carro2, tempo, semaforo, saidaDoBox);
			
			scuderia.start();
			scuderia1.start();
			
		}
	
	

	}

}
