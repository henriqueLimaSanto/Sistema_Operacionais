package Controller_Pista;


import java.util.concurrent.Semaphore;

import View_Pista.Scuderia;



public class ThreadPista extends Thread{
	
	private String scuderia;
	private String carro;
	private long tempo;
	private Semaphore semaforo;
	private Semaphore semaforoPista = new Semaphore(5);
	private Semaphore semaforoOrdenacao = new Semaphore(1);
	private int saidaDoBox;
	private int voltas;
	private static int i = -1;
	static Scuderia equipe[] =  new Scuderia[12];
	 static  Scuderia aux;

	

	
	public ThreadPista(String scuderia, String carro,long tempo, Semaphore semaforo,int saidaDoBox ) {
		// TODO Auto-generated constructor stub
		this.scuderia =scuderia;
		this.carro = carro;
		this.tempo = tempo;
		this.semaforo = semaforo;
		this.saidaDoBox = saidaDoBox;
	}
	
	  public void iniciaVetor() {
		  for(int i= 0; i<equipe.length;i++) {
			  equipe[i] = new Scuderia();
			 
		  }
	  }
		public void run() {
			iniciaVetor();
			carroIndo();
			try {
				semaforo.acquire();
				semaforoPista.acquire();
				carroNapista();
				
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				semaforoPista.release();
				semaforo.release();
				
			}
			
			try {
				semaforoOrdenacao.acquire();
				ordenar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforoOrdenacao.release();
			}
			
			
			
			
		}
		private void ordenar() {
			// TODO Auto-generated method stub
			int tempoParado = (int)(Math.random()*2001+1000);
			 try {
					Thread.sleep(tempoParado);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				  i++;
			
				   equipe[i].setNome(scuderia);
				   equipe[i].setTempo(tempo);
				   System.out.println(equipe[i].getNome() +"  "+equipe[i].getTempo()+"   "+i+"   ooordena");
				 
		
				  
		
			if(i==11) {
				ordenarPosicoes();
			}
		}

		private void carroNapista() {
			System.out.println("O carro "+carro+" da scuderia "+scuderia+" Entrou na pista+++++++++++++++++++++++++++++");
			saidaDoBox = 0;
			tempo=0;
			while(voltas<3) {
				long tempo1 = System.nanoTime();
				
				saidaDoBox+=25;
				System.out.println("O carro "+carro+" da scuderia "+scuderia+" andou"+saidaDoBox +" 88888888888888888");
				
				
				if(saidaDoBox == 100) {
					long tempo2 = System.nanoTime();
					saidaDoBox = 0;
					voltas++;
					tempo2= tempo2 - tempo1;
					if(tempo ==0 || tempo<tempo2) {
						tempo = tempo2;
					}
					System.out.println(tempo);
				}
					
				}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		
			
			
		}

		private void ordenarPosicoes() {
			// TODO Auto-generated method stub
			
			for(int i = 0;i<equipe.length-1;i++) {
				for(int j=i+1;j<equipe.length;j++) {
					if(equipe[i].getTempo()>equipe[j].getTempo()) {
						aux = equipe[i];
						equipe[i] = equipe[j];
						equipe[j] =aux;
					}
				}
			}
			for(int i = 0;i<=11;i++) {
				System.out.println((i+1)+"o Lugar "+ equipe[i].getNome() + " tempo " + equipe[i].getTempo());
			}
		}
		private void carroIndo() {
			
			while(saidaDoBox < 300) {
				saidaDoBox+=25;
				System.out.println("O carro "+carro+" da scuderia "+scuderia+" andou"+saidaDoBox);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("O carro "+carro+" da scuderia "+scuderia+" na entrada da pista");
			
		}
	

}
