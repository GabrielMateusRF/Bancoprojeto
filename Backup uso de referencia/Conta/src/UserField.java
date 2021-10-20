import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class UserField extends JFrame{
	
	
	public static int acharConta(Conta Cconta[], int numConta, int i) {///funcao generica que devolve a posicao vetorial da conta
		int a;
		for(a=0; a<i; a++) {
			if(Cconta[a].getNumeroConta()==numConta) {
				return a;
			}
		}
		return 99;
	}
	
	
	
	Tipodeusuario enviatexto;
	private JTextField usuario;
	private JPasswordField senha;
	private int userkey;
	private int password;
	private JButton Enter;
	
	Gerenteopcoes Ger = new Gerenteopcoes();
	ClienteOpcoes Cer = new ClienteOpcoes();
	
	
	public class Variaveis{
		public static int i;
		public static int ig;
		public static Contagerente[] Contag = new Contagerente[10];
		public static Conta[] Cconta = new Conta[10];
	}
	
	Scanner input = new Scanner(System.in);
	
	int mkey, key, loop, escolha, numconta, jurosoulimite, contaGerenteAtiva; 
	int temp;
	String senhatemp;

	
	public UserField()
	{
		super("Digite onumero da conta e a senha de sua conta:");
		setLayout(new FlowLayout());
		
		Variaveis.Contag[0] = new Contagerente();
		Variaveis.Contag[0].setNumeroConta(400);
		Variaveis.Contag[0].alterarSenha("default", "400");
		
		usuario = new JTextField("Número da conta");
		add(usuario);
		
		senha = new JPasswordField("Senha da conta");
		add(senha);
		
		Enter = new JButton("Enter");
		add(Enter);
		
		TextFieldHandler handler = new TextFieldHandler();
		usuario.addActionListener(handler);
		senha.addActionListener(handler);
		Enter.addActionListener(handler);
		
		
	}
	

	private class TextFieldHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == Enter) {
				String useraux = event.getActionCommand();
				userkey = Integer.parseInt(useraux);
				contaGerenteAtiva=acharConta(Variaveis.Contag, key, Variaveis.ig);
				
				if(contaGerenteAtiva==99) {			
					JOptionPane.showMessageDialog(null, "Conta não encontrada");
				}else {
					String sSenha = JOptionPane.showInputDialog("Coloque sua senha: ");
					senha=sSenha;
					if(Variaveis.Contag[contaGerenteAtiva].conferirSenha(senha)==0) {
						JOptionPane.showMessageDialog(null, "Senha incorreta");
					}
					else {
						do {
							
							//Gerenteopcoes Ger = new Gerenteopcoes();
							//Ger.setIg(ig);
							
							//ig=Ger.getIg();
							Ger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							Ger.setSize(500,600);
							Ger.setVisible(true);
							
							
							
							
		
							
							switch(loop) {
							case 1:///MARCELO
								
								break;
							case 2://ok
								System.out.printf("Deseja: \n1)Imprimir lista de clientes\n2)Imprimir dados de uma conta especifica\n");
								key=input.nextInt();
								if(key==1){
									for(temp=0; temp<Variaveis.i; temp++) {
										///imprimirDado(Cconta[temp]);
								
									}
								}
								else { 
									if(key==2) {
									System.out.printf("Digite o numero da conta: ");
									key=input.nextInt();
									key=acharConta(Variaveis.Cconta, key, Variaveis.i);
										if(key!=99) {
											///imprimirDado(Cconta[key]);
										}else {
											System.out.println("Conta não encontrada");
										}
									}
								}
								
								break;
							case 3:///Copiei só o aplicar
								System.out.printf("Digite no número da conta na qual deseja aplicar dinheiro:");
								key=input.nextInt();
								key=acharConta(Variaveis.Cconta, key, Variaveis.i);
								if(key!=99) {
									///aplicarDinheiro(Cconta[key]);
								}else {
									System.out.println("Conta não encontrada");
								}
								break;
							case 4:///Transferir ok
								System.out.printf("Digite no número da conta da qual sairá o dinheiro:");
								key=input.nextInt();
								key=acharConta(Variaveis.Cconta, key, Variaveis.i);
								temp=key;
								if(key!=99) {
									System.out.printf("Digite no número da conta na qual o dinheiro será transferido:");
									key=input.nextInt();
									key=acharConta(Variaveis.Cconta, key, Variaveis.i);
									if((key!=99) && (temp!=key)){
										///transferirDinheiro(Cconta[temp], Cconta[key]);
									}else {
										if(temp==key){
											System.out.println("Você não pode transferir dinheiro para a mesma conta");
										}else {
											System.out.println("Conta não encontrada");
										}
									}
								}else {
									System.out.println("Conta não encontrada");
								}
								
								
								break;
							case 5:///MARCELO
								break;
							case 6:///Cadastrar/editar limites
								System.out.printf("Digite no número da conta na qual deseja mudar o limite se for especial ou a taxa de juros se for poupança:");
								key=input.nextInt();
								key=acharConta(Variaveis.Cconta, key, Variaveis.i);
								if(key!=99) {
									///mudarLimJuros(Cconta[key]);
								}else {
									System.out.println("Conta não encontrada");
								}
								
								break;
							case 7:///cadastrar outros 	
								break;
							case 8:///mudar senha
								///mudarSenha(Contag[contaGerenteAtiva]);
								break;
							}
							
						}while(loop!=0);
					}
					
				}
				
				
				

				///dispose();
				///System.exit(0);
			}else {
				String passwordaux = event.getActionCommand();
				password = Integer.parseInt(passwordaux);
			}
		}
	}
}
