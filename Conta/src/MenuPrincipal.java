import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class MenuPrincipal extends JFrame {
	
	public static int acharConta(Conta Cconta[], int numConta, int i) {///funcao generica que devolve a posicao vetorial da conta
		int a;
		for(a=0; a<i; a++) {
			if(Cconta[a].getNumeroConta()==numConta) {
				return a;
			}
		}
		return 99;
	}
	

	///PECADO COMEÇO, MARCELO É ATEU, ENTÃO ELE ARRUMA
	
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
	
	
	public static void criarContaC(Conta Cconta, int nCCliente, int gerente, String nome, String senha) {///Cria conta Corrente
		///Menu CriarConta
	
			Cconta.setNumeroConta(100+nCCliente);///ERRO AQUI
			Cconta.setNome(nome);
			Cconta.alterarSenha("default", senha);
			Cconta.setgQueCadastrou(gerente);
			System.out.println("Conta Criada");
		
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
	
	
	
	
	
	
	///PECADO FIM
	
	
	private JButton bGerente;
	private JButton bCliente;
	private JLabel msgEscolha;
	
	int key, contaKey, contaGerenteAtiva, nCCliente=0, nCGerente=1, opcao, opcao2, temp;
	String senha;
	
	///Validacao
	JPanel validacao = new JPanel();
	JLabel labelLogin = new JLabel("Login: ");
	JLabel labelSenha = new JLabel("Senha: ");
	JTextField numConta = new JTextField(10);
	JPasswordField senhaConta = new JPasswordField(10);
	String[] opcoes = new String[]{"Confirmar", "Cancelar"};
	
	
	///Menu Gerente
	JPanel menuGerentePainel = new JPanel();
	String[] opcoesMenuGerente = new String[] {"Selecione uma opção","Verificar o nom...","Visualizar info...", "Faz uma aplicaç...", 
												"Faz transferênc...", "Faz retiradas m...", "Cadastra/Edita ...",
												"Cadastrar outro...", "Alterar Senha"};
	
	JComboBox menuGerente = new JComboBox(opcoesMenuGerente);
	
	
	///Menu Cliente
	JPanel menuClientePainel = new JPanel();
	String[] opcoesMenuCliente = new String[] {"Selecione uma opção","Abrir Conta","Aplicar Dinheiro", "Retirar Dinheiro", 
												"Saldo", "Verificar Extratos", "Alterar senha"};
	
	JComboBox menuCliente = new JComboBox(opcoesMenuCliente);
	
	///Criar Conta
	JPanel menuCriarContaPainel = new JPanel();
	JLabel labelNome = new JLabel("Nome: ");
	JTextField txtNome = new JTextField(10);
	JPasswordField senhaConta2 = new JPasswordField(10);
	String[] tipodeconta = new String[] {"Selecione o tipo de Conta","Corrente", "Poupança", "Especial"};
	JComboBox comboBoxTipodeConta = new JComboBox(tipodeconta);

	
	//Alocacao
	Contagerente[] Contag = new Contagerente[10];
	Conta[] Cconta = new Conta[10];

	
	
	
	public MenuPrincipal() {
		super("Banco da PUC");
		setLayout(new FlowLayout());
		
		
		msgEscolha = new JLabel("Por favor, escolha o tipo de conta que deseja acessar");
		add(msgEscolha);
		
		bGerente = new JButton("Gerente");
		add(bGerente);
		
		bCliente = new JButton("Cliente");
		add(bCliente);
		
		
		
		ButtonHandler handler = new ButtonHandler();
		bGerente.addActionListener(handler);
		bCliente.addActionListener(handler);
		
		
		


	}
	
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			///Se código não funcionar, mudar isto
			
			
			Contag[0] = new Contagerente();
			Contag[0].setNumeroConta(400);
			Contag[0].alterarSenha("default", "400");
			Contag[0].setgQueCadastrou(0);
			///Testando
			
			///validacaoAdd
			validacao.add(labelLogin);
			validacao.add(numConta);
			validacao.add(labelSenha);
			validacao.add(senhaConta);
			
			
			
			if(event.getActionCommand()== "Gerente"){
				opcao = JOptionPane.showOptionDialog(null, validacao, "Tela de Login", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
				
					if(opcao==0) {
						///NUMERO DA CONTA
						contaKey = Integer.parseInt(numConta.getText());
						
						contaGerenteAtiva=acharConta(Contag, contaKey, nCGerente);
						if(contaGerenteAtiva==99) {
							JOptionPane.showMessageDialog(null, "Conta não encontrada");
							
						}else {
							///SENHA 
							senha = String.valueOf(senhaConta.getPassword());
							
							if(Contag[contaGerenteAtiva].conferirSenha(senha)==0) {
								JOptionPane.showMessageDialog(null, "Senha incorreta");
							}
							else {
								
								
								///GERENTE VALIDADO
						
								menuGerentePainel.add(menuGerente);
								
								opcao = JOptionPane.showOptionDialog(null, menuGerentePainel, "Menu Gerente", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
								opcao2 = menuGerente.getSelectedIndex();
								if(opcao==0){
									switch(opcao2) {
									case 1:
										///Vai precisar de alteracao no loop
										for(temp=0; temp<nCCliente; temp++) {
											if(contaGerenteAtiva==Cconta[temp].getgQueCadastrou()){
												imprimirDado(Cconta[temp]);
											}
										}
										
										for(temp=0; temp<nCGerente; temp++) {
											if(contaGerenteAtiva==Contag[temp].getgQueCadastrou()){
												imprimirDado(Contag[temp]);
											}
										}
										break;
									case 2://ok
										System.out.printf("Deseja: \n1)Imprimir lista de clientes\n2)Imprimir dados de uma conta especifica\n");
										//key=input.nextInt();
										if(key==1){
											for(temp=0; temp<nCCliente; temp++) {
												imprimirDado(Cconta[temp]);
										
											}
										}
										else { 
											if(key==2) {
											System.out.printf("Digite o numero da conta: ");
											//key=input.nextInt();
											key=acharConta(Cconta, key, nCCliente);
												if(key!=99) {
													imprimirDado(Cconta[key]);
												}else {
													System.out.println("Conta não encontrada");
												}
											}
										}
										
										break;
									case 3:///igual ao aplicar
										System.out.printf("Digite no número da conta na qual deseja aplicar dinheiro:");
										///key=input.nextInt();
										key=acharConta(Cconta, key, nCCliente);
										if(key!=99) {
											aplicarDinheiro(Cconta[key]);
										}else {
											System.out.println("Conta não encontrada");
										}
										break;
									case 4:///Transferir ok
										System.out.printf("Digite no número da conta da qual sairá o dinheiro:");
										///key=input.nextInt();
										key=acharConta(Cconta, key, nCCliente);
										temp=key;
										if(key!=99) {
											System.out.printf("Digite no número da conta na qual o dinheiro será transferido:");
											///key=input.nextInt();
											key=acharConta(Cconta, key, nCCliente);
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
									case 5:///ok
										System.out.printf("Digite no número da conta na qual deseja retirar dinheiro:");
										///key=input.nextInt();
										key=acharConta(Cconta, key, nCCliente);
										if(key!=99) {
											retirarDinheirog(Cconta[key], contaGerenteAtiva);
										}else {
											System.out.println("Conta não encontrada");
										}
										break;
									case 6:///Cadastrar/editar limites
										System.out.printf("Digite no número da conta na qual deseja mudar o limite se for especial ou a taxa de juros se for poupança:");
										///key=input.nextInt();
										key=acharConta(Cconta, key, nCCliente);
										if(key!=99) {
											mudarLimJuros(Cconta[key]);
										}else {
											System.out.println("Conta não encontrada");
										}
										
										break;
									case 7:///cadastrar outros usuarios
										/*escolha=mensagemCriarContaG();
										if(escolha==1) {///Corrente
											Cconta[nCCliente] = new Corrente();
											criarContaC(Cconta[nCCliente], nCCliente, contaGerenteAtiva);
											infoConta(Cconta[nCCliente]);
											nCCliente++;
										
										}
										if(escolha==2) {///Poupanca
											Cconta[nCCliente] = new Poupanca();
											criarContaP(Cconta[nCCliente], nCCliente, contaGerenteAtiva);
											infoConta(Cconta[nCCliente]);
											nCCliente++;
										}
										if(escolha==3) {///Especial
											Cconta[nCCliente] = new Especial();
											criarContaE(Cconta[nCCliente], nCCliente, contaGerenteAtiva);
											infoConta(Cconta[nCCliente]);
											nCCliente++;
											
										}
										if(escolha==4) {///Especial
											Contag[nCGerente] = new Contagerente();
											criarContaG(Contag[nCGerente], nCGerente, contaGerenteAtiva);
											infoConta(Contag[nCGerente]);
											nCGerente++;
										}*/
										
										
										break;
									case 8:///mudar senha
										mudarSenha(Contag[contaGerenteAtiva]);
										break;
									}
								}
							}
						}
					}
	
					
				
			}
			
			else{
				///MENU CLIENTE
				menuClientePainel.add(menuCliente);
				
				opcao = JOptionPane.showOptionDialog(null, menuClientePainel, "Menu Cliente", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,  opcoes, opcoes[1]);
				opcao2 = menuCliente.getSelectedIndex();
				if(opcao==0){
					switch (opcao2) {
					case 1:///criar conta OK
						System.out.printf("Konami\n");
						
						menuCriarContaPainel.add(labelNome);
						menuCriarContaPainel.add(txtNome);
						menuCriarContaPainel.add(labelSenha);
						menuCriarContaPainel.add(senhaConta2);
						menuCriarContaPainel.add(comboBoxTipodeConta);
						
						opcao = JOptionPane.showOptionDialog(null, menuCriarContaPainel, "Criar Conta", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
						opcao2 = comboBoxTipodeConta.getSelectedIndex();
						if(opcao==0) {
							
							///CASO A PESSOA NÃO COLQOUE NADA OU 1, ELA IRÁ CRIAR UMA CONTA CORRENTE
							if(opcao2==3){///Especial
								///Default do set de limite será 500 reais
								
								Cconta[nCCliente] = new Especial();
								((Especial) Cconta[nCCliente]).setLimite(500);
							}else {
								if(opcao2==2) {///Poupanca
									///Default do set juros será 5%
									
									Cconta[nCCliente] = new Poupanca();
									((Poupanca) Cconta[nCCliente]).setJuros(5);
								}
								///Corrente
								Cconta[nCCliente] = new Corrente();
							}
							
						criarContaC(Cconta[nCCliente], nCCliente, 0, String.valueOf(txtNome.getText()),String.valueOf(senhaConta2.getPassword()));
						System.out.printf("\n %d \n", Cconta[nCCliente].getNumeroConta());
						System.out.printf("\n %s \n", Cconta[nCCliente].getNome());
						
						nCCliente++;
						}
					
					
					break;
					case 2:///Aplicar dinheiro OK
						System.out.printf("Digite no número da conta na qual deseja aplicar dinheiro:");
						///key=input.nextInt();
						key=acharConta(Cconta, key, nCCliente);
						if(key!=99) {
							aplicarDinheiro(Cconta[key]);
						}else {
							System.out.println("Conta não encontrada");
						}
						break;
					case 3:///Retirar Dinheiro NÃO FINALIZADO, FALTA CARA CARACTERISTICA
						System.out.printf("Digite no número da conta na qual deseja retirar dinheiro:");
						///key=input.nextInt();
						key=acharConta(Cconta, key, nCCliente);
						if(key!=99) {
							retirarDinheiro(Cconta[key]);
						}else {
							System.out.println("Conta não encontrada");
						}
						break;
					case 4:///Saldo OK
						System.out.printf("Digite no número da conta na qual deseja Consultar o saldo:");
						///key=input.nextInt();
						key=acharConta(Cconta, key, nCCliente);
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
						///key=input.nextInt();
						key=acharConta(Cconta, key, nCCliente);
						if(key!=99) {
							mudarSenha(Cconta[key]);
						}else {
							System.out.println("Conta não encontrada");
						}
						break;
					default:
						break;
					}	
					
				}
				/*validacao.setTipoUsuario(2); //2=Cliente.
				validacao.setLocationRelativeTo(getFocusOwner());
				validacao.setSize(350,100);
				validacao.setVisible(true);*/
			}
		}
	}
	

}
