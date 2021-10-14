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
		System.out.println("1. Verificar o nome de seus clientes e quais são suas respectivas contas");
		System.out.println("2. Visualizar informções da conta");
		System.out.println("3. Faz uma aplicação de dinheiro para um cliente específico");
		System.out.println("4. Faz transferência de dinheiro entre contas específicas de clientes diferentes");
		System.out.println("5. Faz retiradas maiores de R$ 110.000,00 de contas de seus clientes");
		System.out.println("6. Cadastra/Edita os limites de retiradas negativas e também da taxa de juros da poupança");
		System.out.println("7. Cadastrar outros usuários (gerentes e clientes)");
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
		Cconta.setNumeroConta(i+200);
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
		Cconta.setNumeroConta(i+200);
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
		Scanner input = new Scanner(System.in);
		System.out.printf("Conta numero: %d \nCliente: %s\nDigite a senha: ", Cconta.getNumeroConta(), Cconta.getNome());
		senha=input.next();
		if(Cconta.conferirSenha(senha)==1) {
			System.out.printf("Quando deseja sacar?: ");
			((Corrente) Cconta).sacar(input.nextFloat());
			System.out.printf("Saldo atual: %.2f\n", Cconta.getSaldo());
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
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int mkey, key, loop, escolha, numconta, jurosoulimite, i=0, ig=1, contaGerenteAtiva;
		String senha, senhatemp;
		Contagerente[] Contag = new Contagerente[10];
		Conta[] Cconta = new Conta[10];
		
		//gerente default
		Contag[0] = new Contagerente();
		Contag[0].setNumeroConta(401);
		Contag[0].alterarSenha("default", "401");
		
		do {	
			do {
				mkey = selecModo();
				if((mkey<0)||(mkey>2)) 
				{
					System.out.println("Numero digitado inválido");
				}
			}while((mkey<0)||(mkey>2));
			
			
			if(mkey==1) {
				System.out.printf("Digite no número da conta Gerente:");
				key=input.nextInt();
				contaGerenteAtiva=acharConta(Contag, key, ig);
				if(contaGerenteAtiva==99) {
					System.out.println("Conta Gerente não encontrada");
					
				}else {
					System.out.printf("Digite a senha da conta: ");
					senha=input.next();
					if(Contag[contaGerenteAtiva].conferirSenha(senha)==0) {
						System.out.println("Senha errada");
					}
					else {
						do {
							System.out.println("Conta Gerente");
							loop=contaGerente();
							switch(loop) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
							case 5:
								break;
							case 6:///Cadastrar/editar limites
								break;
							case 7:///cadastrar outros usuarios 
								break;
							case 8:///mudar senha
								mudarSenha(Contag[contaGerenteAtiva]);
								break;
							}
							
						}while(loop!=0);
					}
					
				}
				
				
				
			}
				else {
					if(mkey==2) {///Conta cliente
					do {
						System.out.println("Conta Cliente");
						loop=contaCliente();
						switch (loop) {
							case 1:///criar conta OK
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
							case 2:///Aplicar dinheiro OK
								System.out.printf("Digite no número da conta na qual deseja aplicar dinheiro:");
								key=input.nextInt();
								key=acharConta(Cconta, key, i);
								if(key!=99) {
									aplicarDinheiro(Cconta[key]);
								}else {
									System.out.println("Conta não encontrada");
								}
								break;
							case 3:///Retirar Dinheiro NÃO FINALIZADO, FALTA CARA CARACTERISTICA
								System.out.printf("Digite no número da conta na qual deseja retirar dinheiro:");
								key=input.nextInt();
								key=acharConta(Cconta, key, i);
								if(key!=99) {
									retirarDinheiro(Cconta[key]);
								}else {
									System.out.println("Conta não encontrada");
								}
								break;
							case 4:///Saldo OK
								System.out.printf("Digite no número da conta na qual deseja Consultar o saldo:");
								key=input.nextInt();
								key=acharConta(Cconta, key, i);
								if(key!=99) {
									consultarSaldo(Cconta[key]);
								}else {
									System.out.println("Conta não encontrada");
								}
								break;
							case 5:///verificar extratos NÃO FEITO
								break;
							case 6:///alterar senha OK
								System.out.printf("Digite no número da conta na qual deseja Mudar a senha:");
								key=input.nextInt();
								key=acharConta(Cconta, key, i);
								if(key!=99) {
									mudarSenha(Cconta[key]);
								}else {
									System.out.println("Conta não encontrada");
								}
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
