package View_Sapo;


import controllerSapo.Thread_Sapo;

public class Main_Sapo {
  public static void main(String[]args) {
	

	
		Thread sapo1  =  new Thread_Sapo("Sapo1", 2);
		Thread sapo2  =  new Thread_Sapo("Sapo2", 3);
		Thread sapo3  =  new Thread_Sapo("Sapo3", 4);
		
		sapo1.start();

		sapo2.start();
		sapo3.start();
		
		
	}

	  
  }
	
	

