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
	private JLabel Mensagem1;
	int ig=1;
	Scanner input = new Scanner(System.in);
	
	int mkey, key, loop, escolha, numconta, jurosoulimite, i=0,  contaGerenteAtiva; 
	int temp;
	String senha, senhatemp;
	
	public void setIg(int num){
		ig=num;
	}
	
	public int getIg() {
		return ig;
	}
	
	public Gerenteopcoes(){
		super("Menu Gerente");
		setLayout(new FlowLayout());
		Mensagem1= new JLabel("ddddddddddddddddddddddddddddddddddddddddd");
		Mensagem1.setText("Aqui você pode acessar várias funções de gerente");
		Mensagem1.setToolTipText("TESTE");
		b1 = new JButton("Verificar nomes");
		add(b1);
		b1.setToolTipText("Verificar o nome de seus clientes e quais são suas respectivas contas");
		
		b2 = new JButton("Visualizar infos");
		add(b2);
		b2.setToolTipText("Visualizar informações da conta");
		
		b3 = new JButton("Fazer aplicação");
		add(b3);
		b3.setToolTipText("Faz uma aplicação de dinheiro para um cliente específico");
		
		b4 = new JButton("Fazer transferencia");
		add(b4);
		b4.setToolTipText("Faz transferência de dinheiro entre contas específicas de clientes diferentes");
		
		b5 = new JButton("Fazer retirada");
		add(b5);
		b5.setToolTipText("Faz retiradas maiores de R$ 110.000,00 de contas de seus clientes");
		
		b6 = new JButton("Cadastrar/Editar limites");
		add(b6);
		b6.setToolTipText("Cadastra/Edita os limites de retiradas negativas e também da taxa de juros da poupança");
		
		b7 = new JButton("Cadastrar usuários");
		add(b7);
		b7.setToolTipText("Cadastrar outros usuários (gerentes e clientes)");
		
		b8 = new JButton("Alterar senha");
		add(b8);
		b8.setToolTipText("Alterar senha");
		
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
			if(event.getActionCommand()== "Verificar nomes") {
				ig++;
				
			}else {
				dispose();
			}
		}
	}
	
	
	
}
