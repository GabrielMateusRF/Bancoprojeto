import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class ClienteOpcoes extends JFrame {

	
	public int choice;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;	
	private JButton bSair;
	private JLabel mensagem1;
	
	
	
	
	int escolha;
	Scanner input = new Scanner(System.in);
	
	int mkey, key, loop, numconta, jurosoulimite,  contaGerenteAtiva; 
	int temp;
	String senha, senhatemp;
	CriarContas Criarconta = new CriarContas();
	
	
	public ClienteOpcoes(){
		super("Menu Cliente");
		setLayout(new FlowLayout());
		mensagem1= new JLabel("");
		mensagem1.setText("Menu de Cliente");
		mensagem1.setToolTipText("TESTE");
		b1 = new JButton("Abrir Conta");
		add(b1);
		
		b2 = new JButton("Aplicar Dinheiro");
		add(b2);
		
		b3 = new JButton("Retirar Dinheiro");
		add(b3);
		
		b4 = new JButton("Saldo");
		add(b4);
		
		b5 = new JButton("Verificar Extratos");
		add(b5);
		
		b6 = new JButton("Alterar senha");
		add(b6);
		
		bSair = new JButton("Sair");
		add(bSair);
		
		
		
		ButtonHandler handler = new ButtonHandler();
		b1.addActionListener(handler);
		b2.addActionListener(handler);
		b3.addActionListener(handler);
		b4.addActionListener(handler);
		b5.addActionListener(handler);
		b6.addActionListener(handler);
		bSair.addActionListener(handler);
		
	}
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand()== "Abrir Conta") {
				Criarconta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Criarconta.setSize(500,600);
				Criarconta.setVisible(true);
				///dispose();
			}else {
				dispose();
			}
		}
	}
	
	
	
}