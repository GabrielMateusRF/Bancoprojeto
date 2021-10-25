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
	

	///PECADO COME�O, MARCELO � ATEU, ENT�O ELE ARRUMA
	
	public static int mensagemCriarConta() {
		Scanner input = new Scanner(System.in);
		System.out.println("Que tipo de conta deseja criar?");
		System.out.println("1. Corrente");
		System.out.println("2. Poupan�a");
		System.out.println("3. Especial");
		return input.nextInt();
	}
	
	public static int mensagemCriarContaG() {
		Scanner input = new Scanner(System.in);
		System.out.println("Que tipo de conta deseja criar?");
		System.out.println("1. Corrente");
		System.out.println("2. Poupan�a");
		System.out.println("3. Especial");
		System.out.println("4. Gerente");
		return input.nextInt();
	}

	public static void infoConta(Conta Cconta) {
		System.out.printf("\n Informa��es da conta \n");
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
				System.out.println("Senhas n�o coicidem");
			}
		}while(!senhatemp.equals(senha));
		Contag.setNumeroConta(i+400);
		Contag.alterarSenha("default", senha);
		Contag.setgQueCadastrou(gerente);
	}
	
	public static void aplicarDinheiro(Conta Cconta[], int nCCliente) {///Em banco para inserir dinheiro nao precisa de senha, certo?
        JPanel menuAplicar = new JPanel();
        JLabel labelNumConta = new JLabel("Digite o n�mero da conta que deseja aplicar Dinheiro: ");
        JTextField numConta = new JTextField(10);
        JLabel labelValor = new JLabel("Digite o quanto Deseja Aplicar R$:");
        JTextField infoValor = new JTextField(10);
        String[] opcoes = new String[]{"Confirmar", "Fechar"};
        
        menuAplicar.add(labelNumConta);
        menuAplicar.add(numConta);
        menuAplicar.add(labelValor);
        menuAplicar.add(infoValor);
        
        JOptionPane.showOptionDialog(null, menuAplicar,  "Aplicar Dinheiro ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
        
        int nConta= (Integer.parseInt(numConta.getText()));
        System.out.printf("/n %d /n", nConta);
        System.out.printf("/n %d /n", nCCliente);
        int key= acharConta(Cconta, nConta, nCCliente);
        if(key==99) {
            JOptionPane.showMessageDialog(null, "Conta n�o encontrada");
        }else {
            Cconta[key].depositar(Double.parseDouble(infoValor.getText()));
        }
        /*System.out.printf("Conta numero: %d \nCliente: %s\nDigite o valor inserido: ", Cconta.getNumeroConta(), Cconta.getNome());
        Cconta.depositar(input.nextDouble());
        System.out.printf("Saldo atual: %.2f\n", Cconta.getSaldo());*/
    }
	
	public static void retirarDinheiro(Conta Cconta[], int nCCliente) {///Precisa de senha
        JPanel menuRetirar = new JPanel();
        JLabel labelNumConta = new JLabel("Digite o n�mero da conta que deseja aplicar Dinheiro: ");
        JTextField numConta = new JTextField(10);
        JLabel labelSenha = new JLabel("Digite a Senha: ");
        JPasswordField senhaInfo = new JPasswordField(10);
        JLabel labelValor = new JLabel("Digite o quanto Deseja Retirar R$:");
        JTextField infoValor = new JTextField(10);
        String[] opcoes = new String[]{"Confirmar", "Fechar"};
        
        menuRetirar.add(labelNumConta);
        menuRetirar.add(numConta);
        menuRetirar.add(labelSenha);
        menuRetirar.add(senhaInfo);
        menuRetirar.add(labelValor);
        menuRetirar.add(infoValor);
        
        JOptionPane.showOptionDialog(null, menuRetirar,  "Retirar Dinheiro ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
        
        int nConta= (Integer.parseInt(numConta.getText()));
        System.out.printf("/n %d /n", nConta);
        System.out.printf("/n %d /n", nCCliente);
        int key= acharConta(Cconta, nConta, nCCliente);
        if(key==99) {
            JOptionPane.showMessageDialog(null, "Conta n�o encontrada");
        }else {
            if(Cconta[key].conferirSenha(String.valueOf(senhaInfo.getPassword()))==0) {
                JOptionPane.showMessageDialog(null, "Senha incorreta");
            }
            else{
                double saque=(Double.parseDouble(infoValor.getText()));
                if(Cconta[key] instanceof Especial) {
                      ((Especial) Cconta[key]).sacar(saque);
                      if(Cconta[key].getSaldo()+ ((Especial) Cconta[key]).getLimite() -saque>=0) {
                          ((Especial) Cconta[key]).sacar(saque);
                      }else {
                          JOptionPane.showMessageDialog(null, "Saldo + limite insuficiente");
                      }
                  }else if(Cconta[key] instanceof Corrente){
                      if(Cconta[key].getSaldo()-saque>=0) {
                          ((Corrente) Cconta[key]).sacar(saque);
                        
                      }else {
                          JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                
                      }
                  }else {
                      if(Cconta[key].getSaldo()-saque>0) {
                          ((Poupanca) Cconta[key]).sacar(saque);
                  
                      }else {
                          JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                      }
           
                  }
            }
            
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
            System.out.println("Voc� n�o � o gerente desse cliente\n");
        }
    }
	
	public static void consultarSaldo(Conta Cconta[],int key, int nCCliente) {///Consultar saldo tbm precisa de senha? Yup
		JPanel menuConsultarSaldo = new JPanel();
		JLabel labelLogin = new JLabel("N�mero da conta que deseja Consultar o saldo:");
		JLabel labelSenha = new JLabel("Senha: ");
		JTextField txtNome = new JTextField(10);
		JPasswordField senhaConta = new JPasswordField(10);
		
		JLabel labelInfos1 = new JLabel("Conta numero: " + Cconta[key].getNumeroConta());
		JLabel labelInfos2 = new JLabel("Cliente: " + Cconta[key].getNome());
		JLabel labelInfos3 = new JLabel("Saldo atual: " + Cconta[key].getSaldo());
		
		String[] opcoes = new String[]{"Confirmar", "Fechar"};
		int opcao;
		
		menuConsultarSaldo.add(labelLogin);
		menuConsultarSaldo.add(txtNome);
		menuConsultarSaldo.add(labelSenha);
		menuConsultarSaldo.add(senhaConta);
		
		opcao = JOptionPane.showOptionDialog(null, menuConsultarSaldo, "Saldo", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
		
		key=Integer.parseInt(String.valueOf(txtNome.getText()));
		key=acharConta(Cconta, key, nCCliente);
		while(opcao ==0) {
			if(key!=99) {
				String senha;
				System.out.printf("Conta numero: %d \nCliente: %s\nDigite a senha: ", Cconta[key].getNumeroConta(), Cconta[key].getNome());
				menuConsultarSaldo.add(labelInfos1);
				menuConsultarSaldo.add(labelInfos2);
				
				senha=String.valueOf(senhaConta.getPassword());
				if(Cconta[key].conferirSenha(senha)==1) {
					menuConsultarSaldo.add(labelInfos3);
					opcao = JOptionPane.showOptionDialog(null, menuConsultarSaldo, "Saldo", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
				}else {
					JOptionPane.showMessageDialog(null, "Senha errada");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Conta n�o encontrada");
			}
		}
	}
		
	public static void mudarSenha(Conta Cconta[], int key,int nCCliente) {///Consultar saldo tbm precisa de senha? Yup
		JPanel menuAlterarSenhaPainel = new JPanel();
		JLabel labelLogin = new JLabel("N�mero da conta que deseja alterar a senha: ");
		JLabel labelSenha = new JLabel("Senha antiga: ");
		JLabel labelSenha2 = new JLabel("Nova senha: ");
		JTextField txtNome = new JTextField(10);
		JPasswordField senhaConta = new JPasswordField(10);
		JPasswordField senhaConta2 = new JPasswordField(10);
		String[] opcoes = new String[]{"Confirmar", "Fechar"};
		int opcao;
		
		
		menuAlterarSenhaPainel.add(labelLogin);
		menuAlterarSenhaPainel.add(txtNome);
		menuAlterarSenhaPainel.add(labelSenha);
		menuAlterarSenhaPainel.add(senhaConta);
		menuAlterarSenhaPainel.add(labelSenha2);
		menuAlterarSenhaPainel.add(senhaConta2);
		
		opcao = JOptionPane.showOptionDialog(null, menuAlterarSenhaPainel, "Alterar Senha", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
		

		
		if(opcao == 0) {
			key=Integer.parseInt(txtNome.getText());
			key=acharConta(Cconta, key, nCCliente);
			if(key!=99) {
				Cconta[key].alterarSenha(String.valueOf(senhaConta.getPassword()), String.valueOf(senhaConta2.getPassword()));
			}else {
				JOptionPane.showMessageDialog(null, "Conta n�o encontrada");
			}
		}
	}
	
	public static void imprimirDado(Conta Cconta) {///Consultar saldo tbm precisa de senha? Yup
        Scanner input = new Scanner(System.in);
        
        
        JPanel menuImpDados = new JPanel();
        JLabel labelNome = new JLabel("Nome: ");
        JLabel nomeInfo = new JLabel(Cconta.getNome());
        JLabel labelNumero = new JLabel("Conta N�:");
        JLabel numeroInfo = new JLabel(Integer.toString(Cconta.getNumeroConta()));
        JLabel labelSaldo = new JLabel("Saldo Atual R$:");
        JLabel saldoInfo = new JLabel(Double.toString(Cconta.getSaldo()));
        JLabel labelTipo = new JLabel("Tipo De Conta: ");
        
        String[] opcoes = new String[]{"Continuar", "Fechar"};
        
        //JOptionPane.showOptionDialog(null, menuClientePainel, "Menu Cliente", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,  opcoes, opcoes[1]);
        
        
        
        menuImpDados.add(labelNome);
        menuImpDados.add(nomeInfo);
        menuImpDados.add(labelNumero);
        menuImpDados.add(numeroInfo);
        menuImpDados.add(labelSaldo);
        menuImpDados.add(saldoInfo);
        menuImpDados.add(labelTipo);
        if(Cconta instanceof Especial) {
            JLabel tipoInfo = new JLabel("Especial");
            JLabel labelExtra = new JLabel("Limite: ");
            JLabel infoExtra = new JLabel(Double.toString(((Especial) Cconta).getLimite()));
            menuImpDados.add(tipoInfo);
            menuImpDados.add(labelExtra);
            menuImpDados.add(infoExtra);
        }else if(Cconta instanceof Corrente){
            JLabel tipoInfo = new JLabel("Corrente");
            menuImpDados.add(tipoInfo);
        }else if (Cconta instanceof Poupanca){
            JLabel tipoInfo = new JLabel("Poupan�a");
            JLabel labelExtra = new JLabel("Juros: ");
            JLabel infoExtra = new JLabel(Double.toString(((Poupanca)Cconta).getJuros()));
            menuImpDados.add(tipoInfo);
            menuImpDados.add(labelExtra);
            menuImpDados.add(infoExtra);
        }else if(Cconta instanceof Contagerente) {
            System.out.printf("Tipo de conta: Gerente\n");
        }
        JOptionPane.showOptionDialog(null, menuImpDados,  "Dados da conta ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
        
        System.out.printf("\nDADOS DA CONTA");
        System.out.printf("\n--------------\n");
        System.out.printf("Nome:           %s\n", Cconta.getNome());
        System.out.printf("Numero:         %d\n", Cconta.getNumeroConta());
        System.out.printf("Saldo atual: %.2f\n", Cconta.getSaldo());
        
         
    }
	
	
	public static void transferirDinheiro(Conta Cconta[], int nCCliente) {///Em banco para inserir dinheiro nao precisa de senha, certo?
        JPanel menuAplicar = new JPanel();
        JLabel labelNumConta1 = new JLabel("Digite o n�mero da conta que deseja Remover o dinheiro: ");
        JTextField numConta1 = new JTextField(10);
        JLabel labelNumConta2 = new JLabel("Digite o n�mero da conta que deseja Depositar o dinheiro: ");
        JTextField numConta2 = new JTextField(10);
        JLabel labelValor = new JLabel("Digite o quanto Deseja Transferir R$:");
        JTextField infoValor = new JTextField(10);
        String[] opcoes = new String[]{"Confirmar", "Fechar"};
        
        menuAplicar.add(labelNumConta1);
        menuAplicar.add(numConta1);
        menuAplicar.add(labelNumConta2);
        menuAplicar.add(numConta2);
        menuAplicar.add(labelValor);
        menuAplicar.add(infoValor);
        
        JOptionPane.showOptionDialog(null, menuAplicar,  "Transferir Dinheiro ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
        
        int nConta1= (Integer.parseInt(numConta1.getText()));
        int nConta2= (Integer.parseInt(numConta2.getText()));
        int key= acharConta(Cconta, nConta1, nCCliente);
        if(key==99) {
            JOptionPane.showMessageDialog(null, "Conta Originaria n�o encontrada");
        }else {
            int key2= acharConta(Cconta, nConta2, nCCliente);
            if(key2==99) {
                JOptionPane.showMessageDialog(null, "Conta Destinada n�o encontrada");
            }else {
            
                ///Cconta[nConta2].depositar(Double.parseDouble(infoValor.getText()));
                ///PARA NO��ES DE COMPREEN��O (Double.parseDouble(infoValor.getText())) IRA SER SAQUE
                double saque=(Double.parseDouble(infoValor.getText()));
                if(Cconta[key] instanceof Especial) {
                      ((Especial) Cconta[key]).sacar(saque);
                      if(Cconta[key].getSaldo()+ ((Especial) Cconta[nConta1]).getLimite() -saque>=0) {
                          ((Especial) Cconta[key]).sacar(saque);
                          Cconta[key2].depositar(saque);
                      }else {
                          JOptionPane.showMessageDialog(null, "Saldo + limite insuficiente");
                      }
                  }else if(Cconta[key] instanceof Corrente){
                      if(Cconta[key].getSaldo()-saque>=0) {
                          ((Corrente) Cconta[key]).sacar(saque);
                          Cconta[key2].depositar(saque);
                      }else {
                          JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                
                      }
                  }else {
                      if(Cconta[key].getSaldo()-saque>0) {
                          ((Poupanca) Cconta[key]).sacar(saque);
                          Cconta[key2].depositar(saque);
                      }else {
                          JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                      }
           
                  }
                
                
            }
        }
            
            
        
    }
	
	public static void mudarLimJuros(Conta Cconta[], int nCCliente) {///Consultar saldo tbm precisa de senha? Yup
        JPanel menuMudarLimJuros = new JPanel();
        JLabel labelNumConta1 = new JLabel("Digite o n�mero da Conta: ");
        JTextField numConta1 = new JTextField(10);
        JLabel labalLimJuros = new JLabel("Digite o Limite ou a porcentagem de Juros que deseja Alterar");
        JTextField infoLimJuros = new JTextField(10);
        String[] opcoes = new String[]{"Confirmar", "Fechar"};
        
        menuMudarLimJuros.add(labelNumConta1);
        menuMudarLimJuros.add(numConta1);

        menuMudarLimJuros.add(labalLimJuros);
        menuMudarLimJuros.add(infoLimJuros);
        
        JOptionPane.showOptionDialog(null, menuMudarLimJuros,  "Alterar ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
        
        int nConta1= (Integer.parseInt(numConta1.getText()));
        int key= acharConta(Cconta, nConta1, nCCliente);
        if(key==99) {
            JOptionPane.showMessageDialog(null, "Conta n�o encontrada");
        }else {
            
            if(Cconta[key] instanceof Especial) {
                 ((Especial) Cconta[key]).setLimite((Double.parseDouble(infoLimJuros.getText())));
                 JOptionPane.showMessageDialog(null, "Limite Atualizado");
              }else if(Cconta[key] instanceof Corrente){
                  JOptionPane.showMessageDialog(null, "Conta Corrente n�o tem Limite ou Juros");
              }else {
                  ((Poupanca) Cconta[key]).setJuros((Double.parseDouble(infoLimJuros.getText())));
                  JOptionPane.showMessageDialog(null, "Juros Atualizado");
              }
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
	String[] opcoesMenuGerente = new String[] {"Selecione uma op��o","Verificar o nom...","Visualizar info...", "Faz uma aplica�...", 
												"Faz transfer�nc...", "Faz retiradas m...", "Cadastra/Edita ...",
												"Cadastrar outro...", "Alterar Senha"};
	
	JComboBox menuGerente = new JComboBox(opcoesMenuGerente);
	
	
	///Menu Cliente
	JPanel menuClientePainel = new JPanel();
	String[] opcoesMenuCliente = new String[] {"Selecione uma op��o","Abrir Conta","Aplicar Dinheiro", "Retirar Dinheiro", 
												"Saldo", "Verificar Extratos", "Alterar senha"};
	
	JComboBox menuCliente = new JComboBox(opcoesMenuCliente);
	
	///Criar Conta
	JPanel menuCriarContaPainel = new JPanel();
	JLabel labelNome = new JLabel("Nome: ");
	JTextField txtNome = new JTextField(10);
	JPasswordField senhaConta2 = new JPasswordField(10);
	String[] tipodeconta = new String[] {"Selecione o tipo de Conta","Corrente", "Poupan�a", "Especial"};
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
			///Se c�digo n�o funcionar, mudar isto
			
			
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
							JOptionPane.showMessageDialog(null, "Conta n�o encontrada");
							
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
													System.out.println("Conta n�o encontrada");
												}
											}
										}
										
										break;
										
									case 3:///igual ao aplicar
										aplicarDinheiro(Cconta, nCCliente);
										break;
										
									case 4:///Transferir ok
										transferirDinheiro(Cconta, nCCliente);
										break;
										
									case 5:///ok
										retirarDinheiro(Cconta, nCCliente);
										break;
										
									case 6:///Cadastrar/editar limites
										mudarLimJuros(Cconta, nCCliente);
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
										mudarSenha(Cconta, key, nCCliente);
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
						
						menuCriarContaPainel.add(labelNome);
						menuCriarContaPainel.add(txtNome);
						menuCriarContaPainel.add(labelSenha);
						menuCriarContaPainel.add(senhaConta2);
						menuCriarContaPainel.add(comboBoxTipodeConta);
						
						opcao = JOptionPane.showOptionDialog(null, menuCriarContaPainel, "Criar Conta", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
						opcao2 = comboBoxTipodeConta.getSelectedIndex();
						if(opcao==0) {
							
							///CASO A PESSOA N�O COLQOUE NADA OU 1, ELA IR� CRIAR UMA CONTA CORRENTE
							if(opcao2==3){///Especial
								///Default do set de limite ser� 500 reais
								
								Cconta[nCCliente] = new Especial();
								((Especial) Cconta[nCCliente]).setLimite(500);
							}else {
								if(opcao2==2) {///Poupanca
									///Default do set juros ser� 5%
									
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
						aplicarDinheiro(Cconta, nCCliente);
						break;
						
					case 3:///Retirar Dinheiro N�O FINALIZADO, FALTA CARA CARACTERISTICA
						retirarDinheiro(Cconta, nCCliente);
						break;
						
					case 4:///Saldo OK
						
						consultarSaldo(Cconta,key,nCCliente);
						break;
						
					case 5:///verificar extratos N�O FEITO
						break;
						
					case 6:///alterar senha OK
						mudarSenha(Cconta, key, nCCliente);
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
