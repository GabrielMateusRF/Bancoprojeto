import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class CriarContas extends JFrame {

	private JLabel mensagem1;
	private JLabel mensagem2;
	private JTextField conta;
	private JTextField senha;
	private JButton concluido;
	String contaDigitada;
	String senhaDigitada;
	
	public CriarContas() {
		super("Criar Conta");
		setLayout(new FlowLayout());
		mensagem1= new JLabel("");
		mensagem1.setText("Digite seu nome: ");
		add(mensagem1);
		
		conta = new JTextField("Digite aqui");
		add(conta);
		mensagem2= new JLabel("");
		mensagem2.setText("Digite uma senha: ");
		add(mensagem2);
		
		senha = new JTextField("Digite aqui");
		add(senha);
		
		concluido = new JButton("Concluido");
		add(concluido);
	
		TextFieldHandler handler = new TextFieldHandler();
		conta.addActionListener(handler);
		senha.addActionListener(handler);
		concluido.addActionListener(handler);
		
	}
		private class TextFieldHandler implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				if(event.getSource()==conta) {
					contaDigitada=event.getActionCommand();
				}else if(event.getSource()==senha){
					contaDigitada=event.getActionCommand();
				}else if(event.getSource()==concluido){
					
					JOptionPane.showMessageDialog(null, "Registro Concluido");;
				}
			}
		}

}

