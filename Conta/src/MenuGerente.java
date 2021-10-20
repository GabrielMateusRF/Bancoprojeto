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
		super("Menu do Gerente");
		
		b1 = new JButton("Verificar o nom...");
		b2 = new JButton("Visualizar info...");
		b3 = new JButton("Faz uma aplicaç...");
		b4 = new JButton("Faz transferênc...");
		b5 = new JButton("Faz retiradas m...");
		b6 = new JButton("Cadastra/Edita ...");
		b7 = new JButton("Cadastrar outro...");
		b8 = new JButton("Alterar senha");
		
		add (b1);
		add (b2);
		add (b3);
		add (b4);
		add (b5);
		add (b6);
		add (b7);
		add (b8);
		
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
