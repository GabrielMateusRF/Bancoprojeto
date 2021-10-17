import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;



public class Tipodeusuario extends JFrame {
	
	
	public static int contaGerente(){
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Selecione o modo: ");
		System.out.println("1. Verificar o nome de seus clientes e quais s�o suas respectivas contas");
		System.out.println("2. Visualizar inform��es da conta");
		System.out.println("3. Faz uma aplica��o de dinheiro para um cliente espec�fico");
		System.out.println("4. Faz transfer�ncia de dinheiro entre contas espec�ficas de clientes diferentes");
		System.out.println("5. Faz retiradas maiores de R$ 110.000,00 de contas de seus clientes");
		System.out.println("6. Cadastra/Edita os limites de retiradas negativas e tamb�m da taxa de juros da poupan�a");
		System.out.println("7. Cadastrar outros usu�rios (gerentes e clientes)");
		System.out.println("8. Alterar senha");
		System.out.println("0. Voltar");
		return input.nextInt();
	}
	
	public static int contaCliente(){
		Scanner input = new Scanner(System.in);
		System.out.println("Selecione o modo: ");
		System.out.println("1. Abrir Conta");
		System.out.println("2. Aplicar Dinheiro");
		System.out.println("3. Retirar Dinheiro");
		System.out.println("4. Saldo");
		System.out.println("5. Verificar Extratos");
		System.out.println("6. Alterar senha");
		System.out.println("0. Voltar");
		return input.nextInt();
	}
	
	public static int mensagemCriarConta() {
		Scanner input = new Scanner(System.in);
		System.out.println("Que tipo de conta deseja criar?");
		System.out.println("1. Corrente");
		System.out.println("2. Poupan�a");
		System.out.println("3. Especial");
		return input.nextInt();
	}
	
	public static void infoConta(Conta Cconta) {
		System.out.printf("\n Informa��es da conta \n");
		System.out.printf("\nNome do cliente: %s\n", Cconta.getNome());
		System.out.printf("Numero da conta: %d\n", Cconta.getNumeroConta());
		System.out.println("Agradecemos a escolha de criar uma conta conosco.");	
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
	
	public static void criarContaC(Conta Cconta, int i) {///Cria conta Corrente
		Scanner input = new Scanner(System.in);
		String senha, senhatemp;
		System.out.print("Digite o nome do novo cliente: ");
		Cconta.setNome(input.next());
		do {
			System.out.print("Digite uma senha: ");
			senha=input.next();
			System.out.printf("Digite a senha novamente:");
			senhatemp=input.next();
			if((!senhatemp.equals(senha))){
				System.out.println("Senhas n�o coicidem");
			}
		}while(!senhatemp.equals(senha));
		Cconta.setNumeroConta(i+100);
		Cconta.alterarSenha("default", senha);
	}

	public static void criarContaP(Conta Cconta, int i) {///Cria conta Poupanca
		Scanner input = new Scanner(System.in);
		String senha, senhatemp;
		int jurosoulimite=0;
		System.out.print("Digite o nome do novo cliente: ");
		Cconta.setNome(input.next());
		do {
			System.out.print("Digite uma senha: ");
			senha=input.next();
			System.out.printf("Digite a senha novamente:");
			senhatemp=input.next();
			if((!senhatemp.equals(senha))){
				System.out.println("Senhas n�o coicidem");
			}
		}while(!senhatemp.equals(senha));
		Cconta.setNumeroConta(i+100);
		Cconta.alterarSenha("default", senha);
		System.out.printf("Digite a taxa de juros: ");
		jurosoulimite=input.nextInt();
		((Poupanca) Cconta).setJuros(jurosoulimite);
		
	}


	public static void criarContaE(Conta Cconta, int i) {///Cria conta especial
		Scanner input = new Scanner(System.in);
		String senha, senhatemp;
		int jurosoulimite=0;
		System.out.print("Digite o nome do novo cliente: ");
		Cconta.setNome(input.next());
		do {
			System.out.print("Digite uma senha: ");
			senha=input.next();
			System.out.printf("Digite a senha novamente:");
			senhatemp=input.next();
			if((!senhatemp.equals(senha))){
				System.out.println("Senhas n�o coicidem");
			}
		}while(!senhatemp.equals(senha));
		Cconta.setNumeroConta(i+100);
		Cconta.alterarSenha("default", senha);
		System.out.printf("Digite o limite: ");
		jurosoulimite=input.nextInt();
		((Especial) Cconta).setLimite(jurosoulimite);
	}
	
	
	public static void aplicarDinheiro(Conta Cconta) {///Em banco para inserir dinheiro nao precisa de senha, certo?
		Scanner input = new Scanner(System.in);
		System.out.printf("Conta numero: %d \nCliente: %s\nDigite o valor inserido: ", Cconta.getNumeroConta(), Cconta.getNome());
		Cconta.depositar(input.nextDouble());
		System.out.printf("Saldo atual: %.2f\n", Cconta.getSaldo());
	}
	
	public static void retirarDinheiro(Conta Cconta) {///Precisa de senha
        String senha;
        float saque;
        Scanner input = new Scanner(System.in);
        System.out.printf("Conta numero: %d \nCliente: %s\nDigite a senha: ", Cconta.getNumeroConta(), Cconta.getNome());
        senha=input.next();
        if(Cconta.conferirSenha(senha)==1) {
            System.out.printf("Quanto deseja sacar?: ");
            saque = input.nextFloat();
            if(Cconta instanceof Especial) {
                ((Especial) Cconta).sacar(saque);
                System.out.printf("Saldo atual: %.2f\n", Cconta.getSaldo());
            }else if(Cconta instanceof Corrente){
                ((Corrente) Cconta).sacar(saque);
                System.out.printf("Saldo atual: %.2f\n", Cconta.getSaldo());
            }else {
                ((Poupanca) Cconta).sacar(saque);
                System.out.printf("Saldo atual: %.2f\n", Cconta.getSaldo());
            }
        }else {
            System.out.println("SENHA ERRADA");
        }
    }
	
	public static void consultarSaldo(Conta Cconta) {///Consultar saldo tbm precisa de senha? Yup
		String senha;
		Scanner input = new Scanner(System.in);
		System.out.printf("Conta numero: %d \nCliente: %s\nDigite a senha: ", Cconta.getNumeroConta(), Cconta.getNome());
		senha=input.next();
		if(Cconta.conferirSenha(senha)==1) {

			System.out.printf("Saldo atual: %.2f\n", Cconta.getSaldo());
		}else {
			System.out.println("SENHA ERRADA");
		}
	}
	
	
	public static void mudarSenha(Conta Cconta) {///Consultar saldo tbm precisa de senha? Yup
		String senha, senhaNova;
		Scanner input = new Scanner(System.in);
		System.out.printf("Conta numero: %d \nCliente: %s\nDigite a senha: ", Cconta.getNumeroConta(), Cconta.getNome());
		senha=input.next();
		if(Cconta.conferirSenha(senha)==1) {
			System.out.printf("Digite a nova senha: ");
			senhaNova=input.next();
			Cconta.alterarSenha(senha, senhaNova);
		}else {
			System.out.println("SENHA ERRADA");
		}
	}
	
	public static void imprimirDado(Conta Cconta) {///Consultar saldo tbm precisa de senha? Yup
		Scanner input = new Scanner(System.in);
		System.out.printf("\nDADOS DA CONTA");
		System.out.printf("\n--------------\n");
		System.out.printf("Nome:   		%s\n", Cconta.getNome());
		System.out.printf("Numero: 		%d\n", Cconta.getNumeroConta());
		System.out.printf("Saldo atual: %.2f\n", Cconta.getSaldo());
		
		 if(Cconta instanceof Especial) {
			 System.out.printf("Tipo de conta: Especial\n");
			 System.out.printf("Limite: %.2f\n", ((Especial)Cconta).getLimite());
         }else if(Cconta instanceof Corrente){
        	 System.out.printf("Tipo de conta: Corrente\n");
        	 
         }else {
             System.out.printf("Tipo de conta: Poupan�a\n");
             System.out.printf("juros: %.2f\n", ((Poupanca)Cconta).getJuros());
         }
	}
	
	
	public static void transferirDinheiro(Conta Cconta, Conta Cconta2) {///Em banco para inserir dinheiro nao precisa de senha, certo?
		Scanner input = new Scanner(System.in);
		double saque;
		System.out.printf("Conta Depositadora \nnumero: %d \nCliente: %s\nConta Transferidora \nnumero: %d \nCliente: %s\nDigite o valor a ser transferido: ", Cconta.getNumeroConta(), Cconta.getNome(),  Cconta2.getNumeroConta(), Cconta2.getNome());
		saque=input.nextDouble();
			if(Cconta instanceof Especial) {
              ((Especial) Cconta).sacar(saque);
              if(Cconta.getSaldo()+ ((Especial) Cconta).getLimite() -saque>=0) {
	              ((Especial) Cconta).sacar(saque);
	              Cconta2.depositar(saque);
        	  }else {
        		  System.out.println("Saldo + limite insuficiente");
        	  }
          }else if(Cconta instanceof Corrente){
        	  if(Cconta.getSaldo()-saque>=0) {
	              ((Corrente) Cconta).sacar(saque);
	              Cconta2.depositar(saque);
        	  }else {
        		  System.out.println("Saldo insuficiente");
        	  }
          }else {
              if(Cconta.getSaldo()-saque>0) {
            	  ((Poupanca) Cconta).sacar(saque);
                  Cconta2.depositar(saque);
        	  }else {
        		  System.out.println("Saldo insuficiente");
        	  }
          }
		
		
		System.out.printf("Saldo atual da conta : %.2f\n", Cconta.getSaldo());
	}
	
	public static void mudarLimJuros(Conta Cconta) {///Consultar saldo tbm precisa de senha? Yup
		Scanner input = new Scanner(System.in);
		if(Cconta instanceof Especial) {
			System.out.printf("Limite Atual: %.2f \n", ((Especial) Cconta).getLimite());
			System.out.println("Digite o limite novo:");
            ((Especial) Cconta).setLimite(input.nextDouble());
			
        }else if(Cconta instanceof Poupanca){
        	System.out.printf("Juros Atual: %.2f \n", ((Poupanca) Cconta).getJuros());
        	System.out.println("Digite o juros novo:");
        	 ((Poupanca) Cconta).setJuros(input.nextDouble());
        }else {
           
            System.out.printf("Conta N�o Especial ou Poupan�a");
        }
	}
	public int choice;
	private JButton bGerente;
	private JButton bCliente;
	private JButton bSair;
	

	
	private JButton A;
	private JButton B;
	private JButton C;
	Scanner input = new Scanner(System.in);
	
	int mkey, key, loop, escolha, numconta, jurosoulimite, i=0, ig=1, contaGerenteAtiva; 
	int temp;
	String senha, senhatemp;
	Contagerente[] Contag = new Contagerente[10];
	Conta[] Cconta = new Conta[10];
	
	
	public Tipodeusuario(){
		super("TIPO DE CONTA");
		setLayout(new FlowLayout());
		
		bGerente = new JButton("Gerente");
		add(bGerente);
		
		bCliente = new JButton("Cliente");
		add(bCliente);
		
		bSair = new JButton("Sair");
		add(bSair);

		ButtonHandler handler = new ButtonHandler();
		bGerente.addActionListener(handler);
		bCliente.addActionListener(handler);
		bSair.addActionListener(handler);
		
		
		Contag[0] = new Contagerente();
		Contag[0].setNumeroConta(400);
		Contag[0].alterarSenha("default", "400");
		
	}
	
	
	
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand()== "Gerente"){
				
				String fNumConta = JOptionPane.showInputDialog("Digite no n�mero da conta Gerente:");
				key = Integer.parseInt(fNumConta);
				contaGerenteAtiva=acharConta(Contag, key, ig);
				if(contaGerenteAtiva==99) {
					JOptionPane.showMessageDialog(null, "Conta n�o encontrada");
				}else {
					String sSenha = JOptionPane.showInputDialog("Coloque sua senha: ");
					senha=sSenha;
					if(Contag[contaGerenteAtiva].conferirSenha(senha)==0) {
						JOptionPane.showMessageDialog(null, "Senha incorreta");
					}
					else {
						do {
							
							Gerenteopcoes Ger = new Gerenteopcoes();
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
									for(temp=0; temp<i; temp++) {
										///imprimirDado(Cconta[temp]);
								
									}
								}
								else { 
									if(key==2) {
									System.out.printf("Digite o numero da conta: ");
									key=input.nextInt();
									key=acharConta(Cconta, key, i);
										if(key!=99) {
											///imprimirDado(Cconta[key]);
										}else {
											System.out.println("Conta n�o encontrada");
										}
									}
								}
								
								break;
							case 3:///Copiei s� o aplicar
								System.out.printf("Digite no n�mero da conta na qual deseja aplicar dinheiro:");
								key=input.nextInt();
								key=acharConta(Cconta, key, i);
								if(key!=99) {
									///aplicarDinheiro(Cconta[key]);
								}else {
									System.out.println("Conta n�o encontrada");
								}
								break;
							case 4:///Transferir ok
								System.out.printf("Digite no n�mero da conta da qual sair� o dinheiro:");
								key=input.nextInt();
								key=acharConta(Cconta, key, i);
								temp=key;
								if(key!=99) {
									System.out.printf("Digite no n�mero da conta na qual o dinheiro ser� transferido:");
									key=input.nextInt();
									key=acharConta(Cconta, key, i);
									if((key!=99) && (temp!=key)){
										///transferirDinheiro(Cconta[temp], Cconta[key]);
									}else {
										if(temp==key){
											System.out.println("Voc� n�o pode transferir dinheiro para a mesma conta");
										}else {
											System.out.println("Conta n�o encontrada");
										}
									}
								}else {
									System.out.println("Conta n�o encontrada");
								}
								
								
								break;
							case 5:///MARCELO
								break;
							case 6:///Cadastrar/editar limites
								System.out.printf("Digite no n�mero da conta na qual deseja mudar o limite se for especial ou a taxa de juros se for poupan�a:");
								key=input.nextInt();
								key=acharConta(Cconta, key, i);
								if(key!=99) {
									///mudarLimJuros(Cconta[key]);
								}else {
									System.out.println("Conta n�o encontrada");
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
				if(event.getActionCommand()== "Gerente") {
					
				}else {
					///dispose();
					System.exit(0);
				}
			}
		}
	}
	

	
	
}

