import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class Gerenteopcoes extends JFrame {

	
	public int choice;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton bSair;
	

	Scanner input = new Scanner(System.in);
	
	int mkey, key, loop, escolha, numconta, jurosoulimite, i=0, ig=1, contaGerenteAtiva; 
	int temp;
	String senha, senhatemp;
	
	
	public Gerenteopcoes(){
		super("Menu Gerente");
		setLayout(new FlowLayout());
		
		b1 = new JButton("Verificar o nome de seus clientes e quais são suas respectivas contas");
		add(b1);
		
		b2 = new JButton("Visualizar informções da conta");
		add(b2);
		
		b3 = new JButton("Faz uma aplicação de dinheiro para um cliente específico");
		add(b3);
		
		b4 = new JButton("Faz transferência de dinheiro entre contas específicas de clientes diferentes");
		add(b4);
		
		b5 = new JButton(" Faz retiradas maiores de R$ 110.000,00 de contas de seus clientes");
		add(b5);
		
		b6 = new JButton("Cadastra/Edita os limites de retiradas negativas e também da taxa de juros da poupança");
		add(b6);
		
		b7 = new JButton("Cadastrar outros usuários (gerentes e clientes)");
		add(b7);
		
		b8 = new JButton("Alterar senha");
		add(b8);
		
		bSair = new JButton("Sair");
		add(bSair);
		
		
		
		ButtonHandler handler = new ButtonHandler();
		b1.addActionListener(handler);
		b2.addActionListener(handler);
		b3.addActionListener(handler);
		b4.addActionListener(handler);
		b5.addActionListener(handler);
		b6.addActionListener(handler);
		b7.addActionListener(handler);
		b8.addActionListener(handler);
		bSair.addActionListener(handler);
		
	}
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			
		}
	}
	
	
	
}
