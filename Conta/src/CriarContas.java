import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class CriarContas extends JFrame {

	private JLabel mensagem1;
	
	public CriarContas() {
		super("Criar Conta");
		setLayout(new FlowLayout());
		mensagem1= new JLabel("");
		mensagem1.setText("Escolha o tipo de conta:");
		mensagem1.setToolTipText("TESTE");
		add(mensagem1);
	
		
		
	}

}

