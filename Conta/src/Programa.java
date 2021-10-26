import java.util.Scanner;

import javax.swing.JFrame;


public class Programa {
	
	public static void selecModo() {	///Chama MenuPrincipal			
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.setLocation(500,300);
		menuPrincipal.setSize(350,100);
		menuPrincipal.setVisible(true);
	}

	
	
	public static void main(String[] args) {
		
		///Numero da conta ADM default: 400
		///Senha: admin
		selecModo();

		
		System.out.println("Programa terminado");
		
		
		

	}



}
