import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Validacao extends JFrame{
	
	int tipoUsuario=0; //1=Gerente. 2=Cliente.
	private JTextField usuarioField;
	private JPasswordField senhaField;
	private JButton bEnter;
	private JButton bCancel;
	private JLabel msg;
	
	public void setTipoUsuario(int tipo) {
		tipoUsuario = tipo;
	}
	
	public static int acharConta(Conta Cconta[], int numConta, int i) {///funcao generica que devolve a posicao vetorial da conta
		int a;
		for(a=0; a<i; a++) {
			if(Cconta[a].getNumeroConta()==numConta) {
				return a;
			}
		}
		return 99;
	}
	
	public Validacao()
	{
		super("Valide sua conta");
		setLayout(new FlowLayout());
		
		msg = new JLabel("Entre com seu usu�rio e senha:");
		add(msg);
		
		usuarioField = new JTextField(10);
		add(usuarioField);
		
		senhaField = new JPasswordField(10);
		add(senhaField);
		
		bEnter = new JButton("Entrar");
		add(bEnter);
		
		bCancel = new JButton("Cancelar");
		add(bCancel);
		
		TextFieldHandler handler = new TextFieldHandler();
		usuarioField.addActionListener(handler);
		senhaField.addActionListener(handler);
		bEnter.addActionListener(handler);
		bCancel.addActionListener(handler);
		
		
	}
	

	private class TextFieldHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			int mkey, key = 0, loop, escolha, numconta, jurosoulimite, i=0, ig=1, contaGerenteAtiva; 
			int temp;
			String senha = null, senhatemp, stringAux;
			char charConversor[];
			Contagerente[] Contag = new Contagerente[10];
			Conta[] Cconta = new Conta[10];
			
			MenuGerente menuGerente = new MenuGerente();
			
			
			//gerente default
			Contag[0] = new Contagerente();
			Contag[0].setNumeroConta(400);
			Contag[0].alterarSenha("default", "400");
			Contag[0].setgQueCadastrou(0);
			
			if(event.getSource() == bCancel) {
				dispose();
			}
			
			
		}
	}
}
