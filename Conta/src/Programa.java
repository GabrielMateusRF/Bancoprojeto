import java.util.Scanner;


public class Programa {
	public static int selecModo() {
		Scanner input = new Scanner(System.in);
		System.out.println("Selecione o modo: ");
		System.out.println("1. Gerente");
		System.out.println("2. Cliente");
		System.out.println("0. Sair");
		return input.nextInt();
	}
	
	public static int contaGerente(){
		Scanner input = new Scanner(System.in);
		System.out.println("Selecione o modo: ");
		System.out.println("1. Criar Conta");
		System.out.println("2. Visualizar informções da conta");
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
	
	/*public static int acharConta(Conta Cconta[], String conta) {
		int a;
		for(a=0; Cconta[a]!=\null; a++) {
			
		}
	}*/
	
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
		Cconta.alterarSenha(null, senha);
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
		Cconta.setNumeroConta(i+200);
		Cconta.alterarSenha(null, senha);
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
		Cconta.setNumeroConta(i+200);
		Cconta.alterarSenha(null, senha);
		System.out.printf("Digite o limite: ");
		jurosoulimite=input.nextInt();
		((Especial) Cconta).setLimite(jurosoulimite);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int mkey, key, loop, escolha, numconta, jurosoulimite, i=0;
		String senha, senhatemp;
		Contagerente Contag = new Contagerente();
		
		Contag.setNumeroConta(401);
		Contag.alterarSenha(null, "401");
		Conta[] Cconta = new Conta[10];
		do {	
			do {
				mkey = selecModo();
				if((mkey<0)||(mkey>2)) 
				{
					System.out.println("Numero digitado inválido");
				}
			}while((mkey<0)||(mkey>2));
			
			
			if(mkey==1) {
				System.out.printf("Digite numero da conta: ");
				key=input.nextInt();
				if(key!=Contag.getNumeroConta()) {
					System.out.println("Conta Nao gerente");
		
				}
				System.out.printf("Digite a senha da conta: ");
				senha=input.next();
				if(Contag.conferirSenha(senha)==0) {
					System.out.println("Senha errada");
				}
				else {
					System.out.println("Conta Gerente");
					key=contaGerente();
				}
				
			}
				else {
					if(mkey==2) {///Conta cliente
					do {
						System.out.println("Conta Cliente");
						loop=contaCliente();
						switch (loop) {
							case 1:
							escolha=mensagemCriarConta();
							if(escolha==1) {///Corrente
								Cconta[i] = new Corrente();
								criarContaC(Cconta[i], i);
							
							}
							if(escolha==2) {///Poupanca
								Cconta[i] = new Poupanca();
								criarContaP(Cconta[i], i);
							}
							if(escolha==3) {///Especial
								Cconta[i] = new Especial();
								criarContaE(Cconta[i], i);
							}
							infoConta(Cconta[i]);
							i++;
							
							
							break;
							case 2:///Aplicar dinheiro
								System.out.println("Digite no número da conta na qual deseja aplicar dinheiro:");
								key=input.nextInt();
								break;
							case 3:///Retirar Dinheiro
								break;
							case 4:///Saldo
								break;
							case 5:///verificar extratos
								break;
							case 6:///alterar senha
								break;
							default:
								break;
							}	
					}while(loop!=0);
				}
			}
		}while(mkey!=0);
			
		
		System.out.println("Programa terminado");
		
		
		
		/*
		Conta Conta1 = new Conta();
		Conta1.setNomeCorrentista("Alexandre");
		Conta1.setNumeroConta(55);
		Conta1.setLim(1000);
		
		System.out.printf("Nome do cliente: %s\n", Conta1.getNomeCorrentista());
		System.out.printf("Número do cliente: %d\n", Conta1.getNumeroConta());
		Conta1.sacar(10000);
		System.out.printf("Saldo atual: %.2f\n", Conta1.getSaldo());
		Conta1.depositar(1000);
		System.out.printf("Saldo atual: %.2f\n", Conta1.getSaldo());
		Conta1.sacar(10000);
		System.out.printf("Saldo atual: %.2f\n", Conta1.getSaldo());
		Conta1.sacar(300);
		System.out.printf("Saldo atual: %.2f\n", Conta1.getSaldo());
		
		
		Conta1.alterarSenha(null, "123");
		*/
		
		

	}

}
