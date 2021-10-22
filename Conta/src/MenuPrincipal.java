import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class MenuPrincipal extends JFrame {
	
	private JButton bGerente;
	private JButton bCliente;
	private JLabel msgEscolha;
	
	int userKey;
	
	public MenuPrincipal() {
		super("Banco da PUC");
		setLayout(new FlowLayout());
		
		
		msgEscolha = new JLabel("Por favor, escolha o tipo de conta que deseja acessar");
		add(msgEscolha);
		
		bGerente = new JButton("Gerente");
		add(bGerente);
		
		bCliente = new JButton("Cliente");
		add(bCliente);
		
		ButtonHandler handler = new ButtonHandler();
		bGerente.addActionListener(handler);
		bCliente.addActionListener(handler);

	}
	
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			Validacao validacao = new Validacao();
			
			
			if(event.getActionCommand()== "Gerente"){
				validacao.setTipoUsuario(1); //1=Gerente.
				validacao.setLocationRelativeTo(getFocusOwner());
				validacao.setSize(350,100);
				validacao.setVisible(true);
			}
			
			else{
				validacao.setTipoUsuario(2); //2=Cliente.
				validacao.setLocationRelativeTo(getFocusOwner());
				validacao.setSize(350,100);
				validacao.setVisible(true);
			}
		}
	}
	
	public int getUserKey() {
		return userKey;
	}
}
