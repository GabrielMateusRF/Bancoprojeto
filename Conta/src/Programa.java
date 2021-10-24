import java.util.Scanner;

import javax.swing.JFrame;


public class Programa {
	
	public static void selecModo() {		
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.setLocation(500,300);
		menuPrincipal.setSize(350,100);
		menuPrincipal.setVisible(true);
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
	
	public static int mensagemCriarContaG() {
		Scanner input = new Scanner(System.in);
		System.out.println("Que tipo de conta deseja criar?");
		System.out.println("1. Corrente");
		System.out.println("2. Poupança");
		System.out.println("3. Especial");
		System.out.println("4. Gerente");
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
	
	public static void criarContaC(Conta Cconta, int i, int gerente) {///Cria conta Corrente
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
		Cconta.setgQueCadastrou(gerente);
	}

	public static void criarContaP(Conta Cconta, int i, int gerente) {///Cria conta Poupanca
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
		Cconta.setgQueCadastrou(gerente);
		System.out.printf("Digite a taxa de juros: ");
		jurosoulimite=input.nextInt();
		((Poupanca) Cconta).setJuros(jurosoulimite);
		
	}

	public static void criarContaE(Conta Cconta, int i, int gerente) {///Cria conta especial
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
		Cconta.setgQueCadastrou(gerente);
		System.out.printf("Digite o limite: ");
		jurosoulimite=input.nextInt();
		((Especial) Cconta).setLimite(jurosoulimite);
	}
	
	public static void criarContaG(Conta Contag, int i, int gerente) {///Cria conta Corrente
		Scanner input = new Scanner(System.in);
		String senha, senhatemp;
		System.out.print("Digite o nome do novo Gerente: ");
		Contag.setNome(input.next());
		do {
			System.out.print("Digite uma senha: ");
			senha=input.next();
			System.out.printf("Digite a senha novamente:");
			senhatemp=input.next();
			if((!senhatemp.equals(senha))){
				System.out.println("Senhas não coicidem");
			}
		}while(!senhatemp.equals(senha));
		Contag.setNumeroConta(i+400);
		Contag.alterarSenha("default", senha);
		Contag.setgQueCadastrou(gerente);
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
	
	
	public static void retirarDinheirog(Conta Cconta, int gerente) {///Precisa de senha
        String senha;
        float saque;
        Scanner input = new Scanner(System.in);
      
        if(Cconta.getgQueCadastrou()==gerente) {
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
            System.out.println("Você não é o gerente desse cliente\n");
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
        	 
         }else if (Cconta instanceof Poupanca){
             System.out.printf("Tipo de conta: Poupança\n");
             System.out.printf("juros: %.2f\n", ((Poupanca)Cconta).getJuros());
         }else if(Cconta instanceof Contagerente) {
        	 System.out.printf("Tipo de conta: Gerente\n");
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
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int mkey, key, loop, escolha, numconta, jurosoulimite, i=0, ig=1, contaGerenteAtiva; 
		int temp;
		String senha, senhatemp;
		////Contagerente[] Contag = new Contagerente[10];
		Conta[] Cconta = new Conta[10];
		
		selecModo();

					do {
						System.out.println("Conta Cliente");
						loop=contaCliente();
						switch (loop) {
							case 1:///criar conta OK
							escolha=mensagemCriarConta();
							if(escolha==1) {///Corrente
								Cconta[i] = new Corrente();
								criarContaC(Cconta[i], i, 0);
							
							}
							if(escolha==2) {///Poupanca
								Cconta[i] = new Poupanca();
								criarContaP(Cconta[i], i, 0);
							}
							if(escolha==3) {///Especial
								Cconta[i] = new Especial();
								criarContaE(Cconta[i], i, 0);
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

	private static Object temp(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

}
