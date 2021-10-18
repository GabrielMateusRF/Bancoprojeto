import java.util.Scanner;
import java.awt.FlowLayout;
import javax.swing.*;

import javax.swing.UIManager.*;





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
	
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		Tipodeusuario.Variaveis.i=0;
		Tipodeusuario.Variaveis.ig=1;
		
		Tipodeusuario.Variaveis.Contag[0] = new Contagerente();
		Tipodeusuario.Variaveis.Contag[0].setNumeroConta(400);
		Tipodeusuario.Variaveis.Contag[0].alterarSenha("default", "400");
		
		int mkey, key, loop, escolha, numconta, jurosoulimite, contaGerenteAtiva; 
		int temp;
		String senha, senhatemp;
		
		
		
		///teste
		/*
		String firstNumber = JOptionPane.showInputDialog("Ola");
		String sNumber = JOptionPane.showInputDialog("konami");
		int n1= Integer.parseInt(firstNumber);
		int n2= Integer.parseInt(sNumber);
		int sum = n1+n2;
		JOptionPane.showMessageDialog(null, "SOMA CARAI: " + sum, "Soma", JOptionPane.PLAIN_MESSAGE);*/
	   
		
		
		
		//gerente default
		/*Contag[0] = new Contagerente();
		Contag[0].setNumeroConta(400);
		Contag[0].alterarSenha("default", "400");*/
		
		Tipodeusuario be = new Tipodeusuario();
		be.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		be.setSize(400,600);
		be.setVisible(true);
		
		
		do {	
			do {
				//bEscolherUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//bEscolherUsuario.setSize(300,300);
				//bEscolherUsuario.setVisible(true);
				mkey=1;
				System.out.printf("AAAAAAAAAAAAAAAAAAAAAA");
				if((mkey<0)||(mkey>2)) 
				{
					System.out.println("Numero digitado inválido");
				}
			}while((mkey<0)||(mkey>2));
			
			
			/*if(mkey==1) {
				System.out.printf("Digite no número da conta Gerente:");
				key=input.nextInt();
				contaGerenteAtiva=acharConta(Contag, key, Variaveis.ig);
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
							case 1:///MARCELO
								
								break;
							case 2://ok
								System.out.printf("Deseja: \n1)Imprimir lista de clientes\n2)Imprimir dados de uma conta especifica\n");
								key=input.nextInt();
								if(key==1){
									for(temp=0; temp<Variaveis.i; temp++) {
										imprimirDado(Cconta[temp]);
								
									}
								}
								else { 
									if(key==2) {
									System.out.printf("Digite o numero da conta: ");
									key=input.nextInt();
									key=acharConta(Cconta, key, i);
										if(key!=99) {
											imprimirDado(Cconta[key]);
										}else {
											System.out.println("Conta não encontrada");
										}
									}
								}
								
								break;
							case 3:///Copiei só o aplicar
								System.out.printf("Digite no número da conta na qual deseja aplicar dinheiro:");
								key=input.nextInt();
								key=acharConta(Cconta, key, i);
								if(key!=99) {
									aplicarDinheiro(Cconta[key]);
								}else {
									System.out.println("Conta não encontrada");
								}
								break;
							case 4:///Transferir ok
								System.out.printf("Digite no número da conta da qual sairá o dinheiro:");
								key=input.nextInt();
								key=acharConta(Cconta, key, i);
								temp=key;
								if(key!=99) {
									System.out.printf("Digite no número da conta na qual o dinheiro será transferido:");
									key=input.nextInt();
									key=acharConta(Cconta, key, i);
									if((key!=99) && (temp!=key)){
										transferirDinheiro(Cconta[temp], Cconta[key]);
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
								key=acharConta(Cconta, key, i);
								if(key!=99) {
									mudarLimJuros(Cconta[key]);
								}else {
									System.out.println("Conta não encontrada");
								}
								
								break;
							case 7:///cadastrar outros usuarios MARCELO
								break;
							case 8:///mudar senha
								mudarSenha(Contag[contaGerenteAtiva]);
								break;
							}
							
						}while(loop!=0);
					}
					
				}
				
				
				
			}*/
				/*else {
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
			}*/
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

	private static Object temp(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

}
