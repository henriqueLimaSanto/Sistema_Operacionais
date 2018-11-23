package view_ThreadCar;

import java.util.concurrent.Semaphore;

import controller_ThreadCar.ThreadCar;


public class MainThreadCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int permissao =3;
		Semaphore semaforo = new Semaphore(permissao);
		
		
		for(int i =1;i<=100;i++){
			Thread  tcarro = new ThreadCar(i, semaforo);
			tcarro.start();
		}

	}

}
