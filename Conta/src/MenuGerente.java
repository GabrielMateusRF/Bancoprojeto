import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;



public class MenuGerente extends JFrame{
	
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	
	
	public MenuGerente(){
		super("Menu gerente:");
		setLayout(new FlowLayout());
		
		b1 = new JButton("Verificar o nom...");
		b1.setToolTipText("Verificar o nome de seus clientes e quais s�o suas respectivas contas.");
		add(b1);
		
		b2 = new JButton("Visualizar info...");
		b2.setToolTipText("Visualizar informa��es da conta.");
		add(b2);
		
		b3 = new JButton("Faz uma aplica�...");
		b3.setToolTipText("Faz uma aplica��o de dinheiro para um cliente espec�fico.");
		add(b3);
		
		b4 = new JButton("Faz transfer�nc...");
		b4.setToolTipText("Faz transfer�ncia de dinheiro entre contas espec�ficas de clientes diferentes.");
		add(b4);
		
		b5 = new JButton("Faz retiradas m...");
		b5.setToolTipText("Faz retiradas maiores de R$ 110.000,00 de contas de seus clientes.");
		add(b5);
		
		b6 = new JButton("Cadastra/Edita ...");
		b6.setToolTipText("Cadastra/Edita os limites de retiradas negativas e tamb�m da taxa de juros da poupan�a.");
		add(b6);
		
		b7 = new JButton("Cadastrar outro...");
		b7.setToolTipText("Cadastrar outros usu�rios (gerentes e clientes).");
		add(b7);
		
		b8 = new JButton("Alterar senha");
		b8.setToolTipText("Alterar senha.");
		add(b8);
				
		ButtonHandler handler = new ButtonHandler();
				
		b1.addActionListener(handler);
		b2.addActionListener(handler);
		b3.addActionListener(handler);
		b4.addActionListener(handler);
		b5.addActionListener(handler);
		b6.addActionListener(handler);
		b7.addActionListener(handler);
		b8.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			
		}
	}
}
