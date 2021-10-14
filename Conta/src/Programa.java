import java.util.Scanner;


public class Programa {
	
	public static int contaGerente(){
		Scanner input = new Scanner(System.in);
		System.out.println("Selecione o modo: ");
		System.out.println("1. Criar Conta");
		System.out.println("2. Visualizar inform��es da conta");
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


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int key, escolha, numconta, jurosoulimite, i=0;
		String senha, senhatemp;
		Contagerente Contag = new Contagerente();
		
		Contag.setNumeroConta(401);
		Contag.alterarSenha(null, "401");
		
		do {
			System.out.println("Selecione o modo: ");
			
			System.out.println("1. Gerente");
			System.out.println("2. Cliente");
			System.out.println("0. Sair");
			key=input.nextInt();
			if((key<0)||(key>2)) 
			{
				System.out.println("Numero digitado inv�lido");
			}
		}while((key<0)||(key>2));
		Conta[] Cconta = new Conta[10];
		
		switch(key) {
		case 1:
			System.out.printf("Digite numero da conta: ");
			key=input.nextInt();
			if(key!=Contag.getNumeroConta()) {
				System.out.println("Conta Nao gerente");
				break;
			}
			System.out.printf("Digite a senha da conta: ");
			senha=input.next();
			if(Contag.conferirSenha(senha)==0) {
				System.out.println("Senha errada");
				break;
			}
			
			
			System.out.println("Conta Gerente");
			key=contaGerente();
			
			
			break;
		case 2:
			System.out.println("Conta Cliente");
			key=contaCliente();
			if(key==1) {
				escolha=mensagemCriarConta();
				if(escolha==1) {///Corrente
					Cconta[i] = new Corrente();
					System.out.print("Digite o nome do novo cliente: ");
					Cconta[i].setNome(input.next());
					do {
						System.out.print("Digite uma senha: ");
						senha=input.next();
						System.out.printf("Digite a senha novamente:");
						senhatemp=input.next();
						if((!senhatemp.equals(senha))){
							System.out.println("Senhas n�o coicidem");
						}
					}while(!senhatemp.equals(senha));
					Cconta[i].setNumeroConta(i+100);
					Cconta[i].alterarSenha(null, senha);
				
				}
				if(escolha==2) {///Poupanca
					Cconta[i] = new Poupanca();
					System.out.print("Digite o nome do novo cliente: ");
					Cconta[i].setNome(input.next());
					do {
						System.out.print("Digite uma senha: ");
						senha=input.next();
						System.out.printf("Digite a senha novamente:");
						senhatemp=input.next();
						if((!senhatemp.equals(senha))){
							System.out.println("Senhas n�o coicidem");
						}
					}while(!senhatemp.equals(senha));
					Cconta[i].setNumeroConta(i+200);
					Cconta[i].alterarSenha(null, senha);
					System.out.printf("Digite a taxa de juros: ");
					jurosoulimite=input.nextInt();
					((Poupanca) Cconta[i]).setJuros(jurosoulimite);
				}
				if(escolha==3) {///Especial
					Cconta[i] = new Especial();
					System.out.print("Digite o nome do novo cliente: ");
					Cconta[i].setNome(input.next());
					do {
						System.out.print("Digite uma senha: ");
						senha=input.next();
						System.out.printf("Digite a senha novamente:");
						senhatemp=input.next();
						if((!senhatemp.equals(senha))){
							System.out.println("Senhas n�o coicidem");
						}
					}while(!senhatemp.equals(senha));
					Cconta[i].setNumeroConta(i+300);
					Cconta[i].alterarSenha(null, senha);
					System.out.printf("Digite o limite: ");
					jurosoulimite=input.nextInt();
					((Especial) Cconta[i]).setLimite(jurosoulimite);
				}
			}else
				if(key==2){
					System.out.println("Digite no n�mero da conta na qual deseja aplicar dinheiro:");
					numconta=input.nextInt();
					
					
				}
			
			
			break;
		default:
			break;
		}
		System.out.println("Programa terminado");
		
		
		
		/*
		Conta Conta1 = new Conta();
		Conta1.setNomeCorrentista("Alexandre");
		Conta1.setNumeroConta(55);
		Conta1.setLim(1000);
		
		System.out.printf("Nome do cliente: %s\n", Conta1.getNomeCorrentista());
		System.out.printf("N�mero do cliente: %d\n", Conta1.getNumeroConta());
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
