import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.*;



public class Tipodeusuario extends JFrame {
	
	
	public static int mensagemCriarConta() {
		Scanner input = new Scanner(System.in);
		System.out.println("Que tipo de conta deseja criar?");
		System.out.println("1. Corrente");
		System.out.println("2. Poupança");
		System.out.println("3. Especial");
		return input.nextInt();
	}
	
	public static void infoConta(Conta Cconta) {
		System.out.printf("\n Informações da conta \n");
		System.out.printf("\nNome do cliente: %s\n", Cconta.getNome());
		System.out.printf("Numero da conta: %d\n", Cconta.getNumeroConta());
		System.out.println("Agradecemos a escolha de criar uma conta conosco.");	
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
				System.out.println("Senhas não coicidem");
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
				System.out.println("Senhas não coicidem");
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
				System.out.println("Senhas não coicidem");
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
             System.out.printf("Tipo de conta: Poupança\n");
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
           
            System.out.printf("Conta Não Especial ou Poupança");
        }
	}
	
	
	
	public int choice;
	private JButton bGerente;
	private JButton bCliente;
	private JButton bSair;
	private JLabel Mensagem1;


	Scanner input = new Scanner(System.in);
	
	int mkey, key, loop, escolha, numconta, jurosoulimite, contaGerenteAtiva; 
	int temp;
	String senha, senhatemp;
	///Contagerente[] Contag = new Contagerente[10];
	///Conta[] Cconta = new Conta[10];
	

	
	public Tipodeusuario(){
		
		
		super("TIPO DE CONTA");
		
		
		setLayout(new FlowLayout());
		Mensagem1= new JLabel("");
		Mensagem1.setText("Por favor, escolha o tipo de conta que deseja acessar");
		Mensagem1.setToolTipText("TESTE");
		add(Mensagem1);
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
		
		ButtonHandler handlser = new ButtonHandler();

		bSair.addActionListener(handlser);
		
	}
	
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand()== "Gerente"){
				
				UserField userField = new UserField();
				userField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				userField.setSize(350,100);
				userField.setVisible(true);
	
			}else {
				if(event.getActionCommand()== "Cliente") {
					///ig=Ger.getIg();
					
					
					Cer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Cer.setSize(500,600);
					Cer.setVisible(true);
					
				}else {
					
					///dispose();
					System.exit(0);
				}
			}
		}
	}
	
}

