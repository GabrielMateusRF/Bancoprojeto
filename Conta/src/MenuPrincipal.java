import java.awt.Dimension;
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
	
    public static int acharUsuario(Usuario CUsuario[], int numConta, int i) {///funcao generica que devolve a posicao vetorial da conta
        int a;
        for(a=0; a<i; a++) {
            if(CUsuario[a].getNum()==numConta) {
                return a;
            }
        }
        return 99;
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
	
	public static void criarContaC(Conta Cconta, int nCCliente, int gerente, String nome) {///Cria conta Corrente
		///Menu CriarConta
	
			Cconta.setNumeroConta(100+nCCliente);
			Cconta.setNome(nome);
			Cconta.setgQueCadastrou(gerente);
			System.out.println("Conta Criada");
			JOptionPane.showMessageDialog(null, "Número da Conta: " + Cconta.getNumeroConta() + ".  \nCadastro bem sucedido");
	}
	
	public static void criarContaG(Conta Cconta, int nCCliente, int gerente, String nome, String senha) {///Cria conta Corrente
		///Menu CriarConta
	
			Cconta.setNumeroConta(400+nCCliente);
			Cconta.setNome(nome);
			Cconta.alterarSenha("default", senha);
			Cconta.setgQueCadastrou(gerente);
			System.out.println("Conta Criada");
			JOptionPane.showMessageDialog(null, "Número da Conta: " + Cconta.getNumeroConta() + ".   \nCadastro bem sucedido");
	}

	public static void aplicarDinheiro(Conta Cconta[], int nCCliente) {///Em banco para inserir dinheiro nao precisa de senha, certo?
        JPanel menuAplicar = new JPanel();
        JLabel labelNumConta = new JLabel("Número da conta que deseja aplicar Dinheiro: ");
        JTextField numConta = new JTextField(10);
        JLabel labelValor = new JLabel("Digite o quanto Deseja Aplicar R$:");
        JTextField infoValor = new JTextField(10);
        String[] opcoes = new String[]{"Confirmar", "Fechar"};
        
        menuAplicar.add(labelNumConta);
        menuAplicar.add(numConta);
        menuAplicar.add(labelValor);
        menuAplicar.add(infoValor);
        menuAplicar.setPreferredSize(new Dimension(200,350));
        
        JOptionPane.showOptionDialog(null, menuAplicar,  "Aplicar Dinheiro ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
        
        int nConta= (Integer.parseInt(numConta.getText()));
        System.out.printf("/n %d /n", nConta);
        System.out.printf("/n %d /n", nCCliente);
        int key= acharConta(Cconta, nConta, nCCliente);
        if(key==99) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada");
        }else {
            Cconta[key].depositar(Double.parseDouble(infoValor.getText()));
        }
    }
	
	public static void retirarDinheiro(Conta Cconta[], int nCCliente, Usuario CUsuario) {///Precisa de senha
        JPanel menuRetirar = new JPanel();
        JLabel labelNumConta = new JLabel("Digite o número da conta que deseja Retirar Dinheiro: ");
        JTextField numConta = new JTextField(10);
        JLabel labelValor = new JLabel("Digite o quanto Deseja Retirar R$:");
        JTextField infoValor = new JTextField(10);
        String[] opcoes = new String[]{"Confirmar", "Fechar"};
        
        menuRetirar.add(labelNumConta);
        menuRetirar.add(numConta);
        menuRetirar.add(labelValor);
        menuRetirar.add(infoValor);
        menuRetirar.setPreferredSize(new Dimension(200,350));
        
        JOptionPane.showOptionDialog(null, menuRetirar,  "Retirar Dinheiro ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
        
        int nConta= (Integer.parseInt(numConta.getText()));
        System.out.printf("/n %d /n", nConta);
        System.out.printf("/n %d /n", nCCliente);
        int key2=0;
        int key= acharConta(Cconta, nConta, nCCliente);
        if(key!=99){
        	key2=CUsuario.getConta(Cconta[key].getNumeroConta());
        }
        if((key==99)||(key2!=Cconta[key].getNumeroConta())) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada");
        }else {
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
	
	public static void consultarSaldo(Conta Cconta[], int nCCliente, Usuario CUsuario) {///Consultar saldo tbm precisa de senha? Yup
		JPanel menuConsultarSaldo = new JPanel();
		JLabel labelLogin = new JLabel("Número da conta: ");
		JTextField txtNome = new JTextField(10);
		
		String[] opcoes = new String[]{"Confirmar", "Fechar"};
		String senha;
		int opcao;
		
		
		menuConsultarSaldo.add(labelLogin);
		menuConsultarSaldo.add(txtNome);
		menuConsultarSaldo.setPreferredSize(new Dimension(200,350));
		
		opcao = JOptionPane.showOptionDialog(null, menuConsultarSaldo, "Saldo", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
		
		while(opcao ==0) {
			int nConta= (Integer.parseInt(txtNome.getText()));
	        System.out.printf("/n %d /n", nConta);
	        System.out.printf("/n %d /n", nCCliente);
	        int key2=0;
	        int key= acharConta(Cconta, nConta, nCCliente);
	        if(key!=99){
	        	key2=CUsuario.getConta(Cconta[key].getNumeroConta());
	        }
	        if((key==99)||(key2!=Cconta[key].getNumeroConta())) {
	            JOptionPane.showMessageDialog(null, "Conta não encontrada");
	        	opcao=1;
	        }else {
	        	JLabel labelInfos1 = new JLabel("Conta número: " + Cconta[key].getNumeroConta());
	    		JLabel labelInfos2 = new JLabel("Cliente: " + Cconta[key].getNome());
	    		JLabel labelInfos3 = new JLabel("Saldo atual: " + Cconta[key].getSaldo());
	    		
	        	menuConsultarSaldo.add(labelInfos1);
				menuConsultarSaldo.add(labelInfos2);
				menuConsultarSaldo.add(labelInfos3);
				opcao = JOptionPane.showOptionDialog(null, menuConsultarSaldo, "Saldo", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
				
	            
	        }
	    }
		

	}
		
	public static void mudarSenha(Conta Cconta[], int key, int nCCliente) {///Consultar saldo tbm precisa de senha? Yup
		JPanel menuAlterarSenhaPainel = new JPanel();
		JLabel labelLogin = new JLabel("Número da conta: ");
		JLabel labelSenha = new JLabel("Senha: ");
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
		menuAlterarSenhaPainel.setPreferredSize(new Dimension(200,350));
		
		opcao = JOptionPane.showOptionDialog(null, menuAlterarSenhaPainel, "Alterar Senha", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
		
		if(opcao == 0) {
			key=Integer.parseInt(txtNome.getText());
			key=acharConta(Cconta, key, nCCliente);
			if(key!=99) {
				Cconta[key].alterarSenha(String.valueOf(senhaConta.getPassword()), String.valueOf(senhaConta2.getPassword()));
			}else {
				JOptionPane.showMessageDialog(null, "Conta não encontrada");
			}
		}
	}
	
	public static void imprimirDado(Conta Cconta[], int contaGerenteAtiva, int nCCliente) {///Consultar saldo tbm precisa de senha? Yup
        Scanner input = new Scanner(System.in);
        String[] opcoes = new String[]{"Fechar"};
        JPanel menuImpDados = new JPanel();
        
		for(int temp=0; temp<nCCliente; temp++) {
			if(contaGerenteAtiva==Cconta[temp].getgQueCadastrou()){
				
		        JLabel labelNome = new JLabel("Nome: ");
		        JLabel nomeInfo = new JLabel(Cconta[temp].getNome());
		        JLabel labelNumero = new JLabel("Conta Nº:");
		        JLabel numeroInfo = new JLabel(Integer.toString(Cconta[temp].getNumeroConta()));
		        JLabel labelSaldo = new JLabel("Saldo Atual R$:");
		        JLabel saldoInfo = new JLabel(Double.toString(Cconta[temp].getSaldo()));
		        JLabel labelTipo = new JLabel("Tipo De Conta: ");
		        JLabel labelDiv = new JLabel("________________________________");
		        
		        menuImpDados.add(labelDiv);
		        menuImpDados.add(labelNome);
		        menuImpDados.add(nomeInfo);
		        menuImpDados.add(labelNumero);
		        menuImpDados.add(numeroInfo);
		        menuImpDados.add(labelSaldo);
		        menuImpDados.add(saldoInfo);
		        menuImpDados.add(labelTipo);
		        menuImpDados.setPreferredSize(new Dimension(200,350));
		        menuImpDados.setMaximumSize(new Dimension(200,350));
		        menuImpDados.setAutoscrolls(true);
		        
		        if(Cconta[temp] instanceof Especial) {
		            JLabel tipoInfo = new JLabel("Especial");
		            JLabel labelExtra = new JLabel("Limite: ");
		            JLabel infoExtra = new JLabel(Double.toString(((Especial) Cconta[temp]).getLimite()));
		            menuImpDados.add(tipoInfo);
		            menuImpDados.add(labelExtra);
		            menuImpDados.add(infoExtra);
		        }else if(Cconta[temp] instanceof Corrente){
		            JLabel tipoInfo = new JLabel("Corrente");
		            menuImpDados.add(tipoInfo);
		        }else if (Cconta[temp] instanceof Poupanca){
		            JLabel tipoInfo = new JLabel("Poupança");
		            JLabel labelExtra = new JLabel("Juros: ");
		            JLabel infoExtra = new JLabel(Double.toString(((Poupanca)Cconta[temp]).getJuros()));
		            menuImpDados.add(tipoInfo);
		            menuImpDados.add(labelExtra);
		            menuImpDados.add(infoExtra);
		        }else if(Cconta[temp] instanceof Contagerente) {
		            System.out.printf("Tipo de conta: Gerente\n");
		        }
		        menuImpDados.add(labelDiv);
			}
		}
		
        JOptionPane.showOptionDialog(null, menuImpDados,  "Dados da conta ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
        
    }
	
	
	public static void imprimirUsuario(Usuario CUsuario[], int contaGerenteAtiva, int i) {///Consultar saldo tbm precisa de senha? Yup
        Scanner input = new Scanner(System.in);
        String[] opcoes = new String[]{"Fechar"};
        JPanel menuImpDados = new JPanel();
        
		for(int temp=0; temp<i; temp++) {
			if(contaGerenteAtiva==CUsuario[temp].getGerente()){
				
		        JLabel labelNome = new JLabel("Nome: ");
		        JLabel nomeInfo = new JLabel(CUsuario[temp].getNome());
		        JLabel labelNumero = new JLabel("Conta Nº:");
		        JLabel numeroInfo = new JLabel(Integer.toString(CUsuario[temp].getNum()));
		        
		        JLabel labelDiv = new JLabel("________________________________");
		        
		        menuImpDados.add(labelDiv);
		        menuImpDados.add(labelNome);
		        menuImpDados.add(nomeInfo);
		        menuImpDados.add(labelNumero);
		        menuImpDados.add(numeroInfo);
		        menuImpDados.setPreferredSize(new Dimension(200,350));
		        menuImpDados.setMaximumSize(new Dimension(200,350));
		        menuImpDados.setAutoscrolls(true);
		        menuImpDados.add(labelDiv);
			}
		}
		        
		
        JOptionPane.showOptionDialog(null, menuImpDados,  "Dados da conta ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
        
    }
	
	public static void transferirDinheiro(Conta Cconta[], int nCCliente) {///Em banco para inserir dinheiro nao precisa de senha, certo?
        JPanel menuAplicar = new JPanel();
        JLabel labelNumConta1 = new JLabel("Digite o número da conta que deseja Remover o dinheiro: ");
        JTextField numConta1 = new JTextField(10);
        JLabel labelNumConta2 = new JLabel("Digite o número da conta que deseja Depositar o dinheiro: ");
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
        menuAplicar.setPreferredSize(new Dimension(200,350));
        
        JOptionPane.showOptionDialog(null, menuAplicar,  "Transferir Dinheiro ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
        
        int nConta1= (Integer.parseInt(numConta1.getText()));
        int nConta2= (Integer.parseInt(numConta2.getText()));
        int key= acharConta(Cconta, nConta1, nCCliente);
        if(key==99) {
            JOptionPane.showMessageDialog(null, "Conta Originaria não encontrada");
        }else {
            int key2= acharConta(Cconta, nConta2, nCCliente);
            if(key2==99) {
                JOptionPane.showMessageDialog(null, "Conta Destinada não encontrada");
            }else {
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
        JLabel labelNumConta1 = new JLabel("Digite o número da Conta: ");
        JTextField numConta1 = new JTextField(10);
        JLabel labalLimJuros = new JLabel("Digite o Limite ou a porcentagem de Juros que deseja Alterar");
        JTextField infoLimJuros = new JTextField(10);
        String[] opcoes = new String[]{"Confirmar", "Fechar"};
        
        menuMudarLimJuros.add(labelNumConta1);
        menuMudarLimJuros.add(numConta1);

        menuMudarLimJuros.add(labalLimJuros);
        menuMudarLimJuros.add(infoLimJuros);
        menuMudarLimJuros.setPreferredSize(new Dimension(200,350));
        
        JOptionPane.showOptionDialog(null, menuMudarLimJuros,  "Alterar ", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
        
        int nConta1= (Integer.parseInt(numConta1.getText()));
        int key= acharConta(Cconta, nConta1, nCCliente);
        if(key==99) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada");
        }else {
            
            if(Cconta[key] instanceof Especial) {
                 ((Especial) Cconta[key]).setLimite((Double.parseDouble(infoLimJuros.getText())));
                 JOptionPane.showMessageDialog(null, "Limite Atualizado");
              }else if(Cconta[key] instanceof Corrente){
                  JOptionPane.showMessageDialog(null, "Conta Corrente não tem Limite ou Juros");
              }else {
                  ((Poupanca) Cconta[key]).setJuros((Double.parseDouble(infoLimJuros.getText())));
                  JOptionPane.showMessageDialog(null, "Juros Atualizado");
              }
        }
    }
	
	private JButton bGerente;
	private JButton bCliente;
	private JLabel msgEscolha;
	
	int key, contaKey, contaGerenteAtiva, contaUsuarioAtiva, nCCliente=0, nCGerente=1, nUsuario=0, opcao, opcao2, temp;

	String senha;
	
	///Validacao
	JPanel validacao = new JPanel();
	JLabel labelLogin = new JLabel("Login: ");
	JLabel labelSenha = new JLabel("Senha: ");
	JTextField numConta = new JTextField(10);
	JPasswordField senhaConta = new JPasswordField(10);
	String[] opcoes = new String[]{"Confirmar", "Cancelar"};
	
	///Validacao
	JPanel validacao2 = new JPanel();
	JTextField numConta2 = new JTextField(10);
	JPasswordField senhaConta3 = new JPasswordField(10);
	
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
	JLabel labelNome = new JLabel("Nome de Usuário: ");
	JTextField txtNome = new JTextField(10);
	JPasswordField senhaConta2 = new JPasswordField(10);
	String[] tipodeconta = new String[] {"Selecione o tipo de Conta","Corrente", "Poupança", "Especial"};
	JComboBox comboBoxTipodeConta = new JComboBox(tipodeconta);
	///Criar Conta Extra de Gerente
	///Criar Conta Só dos gerentes
	JPanel menuCriarContaPainel2 = new JPanel();
	String[] tipodecontaG = new String[] {"Selecione o tipo de Conta","Cliente", "Gerente"};
	JComboBox comboBoxTipodeContaG = new JComboBox(tipodecontaG);
	
	
	//Alocacao
	Contagerente[] Contag = new Contagerente[20];
    Usuario[] CUsuario = new Usuario[20];
    Conta[] Cconta = new Conta[20];
	
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

			Contag[0] = new Contagerente();
			Contag[0].setNumeroConta(400);
			Contag[0].alterarSenha("default", "admin");
			Contag[0].setgQueCadastrou(0);
			Contag[0].setNome("admin");
		
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
										imprimirUsuario(CUsuario, contaGerenteAtiva, nUsuario);
										imprimirDado(Cconta, contaGerenteAtiva, nCCliente);
										imprimirDado(Contag, contaGerenteAtiva, nCGerente);
										break;
										
									case 2://ok
										System.out.printf("Deseja: \n1)Imprimir lista de clientes\n2)Imprimir dados de uma conta especifica\n");
										//key=input.nextInt();
										if(key==1){
											for(temp=0; temp<nCCliente; temp++) {
												imprimirDado(Cconta, contaGerenteAtiva, temp);
											}
										}
										else { 
											if(key==2) {
											System.out.printf("Digite o numero da conta: ");
											//key=input.nextInt();
											key=acharConta(Cconta, key, nCCliente);
												if(key!=99) {
													imprimirDado(Cconta, contaGerenteAtiva, nCCliente);
												}else {
													System.out.println("Conta não encontrada");
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
										///retirarDinheiro(Cconta, nCCliente);
										break;
										
									case 6:///Cadastrar/editar limites
										mudarLimJuros(Cconta, nCCliente);
										break;
										
case 7:///cadastrar outros usuarios
                                        
                                        
                                        menuCriarContaPainel2.add(labelNome);
                                        menuCriarContaPainel2.add(txtNome);
                                        menuCriarContaPainel2.add(labelSenha);
                                        menuCriarContaPainel2.add(senhaConta2);
                                        menuCriarContaPainel2.add(comboBoxTipodeContaG);

                                        opcao = JOptionPane.showOptionDialog(null, menuCriarContaPainel2, "Criar Conta", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
                                        opcao2 = comboBoxTipodeContaG.getSelectedIndex();
                                       
                                            ///CASO A PESSOA NÃO COLQOUE NADA, ELA IRÁ CRIAR UMA CONTA normal
                                            if(opcao2==2){///Gerente
                                                
                                                Contag[nCGerente] = new Contagerente();
                                            }else {///Especial
                                                CUsuario[nUsuario]= new Usuario();
                                                CUsuario[nUsuario].setNome(String.valueOf(txtNome.getText()));
                                                CUsuario[nUsuario].setNum(nUsuario+800);
                                                CUsuario[nUsuario].setGerente(contaGerenteAtiva);
                                                CUsuario[nUsuario].alterarSenha("default", String.valueOf(senhaConta2.getPassword()));
                                                JOptionPane.showMessageDialog(null, "Número da Conta: " + CUsuario[nUsuario].getNum() + ".  \nCadastro bem sucedido");
                                                nUsuario++;
                                            }
                                            
                                            if(opcao2==2) {
                                                criarContaG(Contag[nCGerente], nCGerente, contaGerenteAtiva, String.valueOf(txtNome.getText()),String.valueOf(senhaConta2.getPassword()));
                                                System.out.printf("\n %d \n", Contag[nCGerente].getNumeroConta());
                                                System.out.printf("\n %s \n", Contag[nCGerente].getNome());
                                                nCGerente++;
                                            }
                                        
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
						validacao2.add(labelLogin);
						validacao2.add(numConta2);
						validacao2.add(labelSenha);
						validacao2.add(senhaConta3);
						opcao = JOptionPane.showOptionDialog(null, validacao2, "Tela de Login", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
						
						if(opcao==0) {
							///NUMERO DA CONTA
							
							contaKey = Integer.parseInt(numConta2.getText());
							contaUsuarioAtiva=acharUsuario(CUsuario, contaKey, nUsuario);
							
							if(contaUsuarioAtiva==99) {
								JOptionPane.showMessageDialog(null, "Conta não encontrada");
								
							}else {
								///SENHA
								
								senha = String.valueOf(senhaConta3.getPassword());
								
								if(CUsuario[contaUsuarioAtiva].conferirSenha(senha)==0) {
									JOptionPane.showMessageDialog(null, "Senha incorreta");
								}
								else {
									///CLIENTE VALIDADO
									menuCriarContaPainel.add(labelNome);
									menuCriarContaPainel.add(txtNome);
									menuCriarContaPainel.add(comboBoxTipodeConta);
									menuCriarContaPainel.setPreferredSize(new Dimension(200,350));
									
									opcao = JOptionPane.showOptionDialog(null, menuCriarContaPainel, "Criar Conta", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
									opcao2 = comboBoxTipodeConta.getSelectedIndex();
									if(opcao==0) {
										
										///CASO A PESSOA NÃO COLQOUE NADA, ELA IRÁ CRIAR UMA CONTA CORRENTE
										if(opcao2==3){///Especial
											///Default do set de limite será 500 reais
											
											Cconta[nCCliente] = new Especial();
											((Especial) Cconta[nCCliente]).setLimite(500);
										}else {
											if(opcao2==2) {///Poupanca
												///Default do set juros será 5%
												
												Cconta[nCCliente] = new Poupanca();
												((Poupanca) Cconta[nCCliente]).setJuros(5);
											}else {
											///Corrente
												Cconta[nCCliente] = new Corrente();
											}
										}
										
									criarContaC(Cconta[nCCliente], nCCliente, CUsuario[contaUsuarioAtiva].getGerente(), String.valueOf(txtNome.getText()));
									CUsuario[contaUsuarioAtiva].setContas(Cconta[nCCliente].getNumeroConta());
									nCCliente++;
									}
								}
							}
						}
						
					
					
					break;
					case 2:///Aplicar dinheiro OK
						aplicarDinheiro(Cconta, nCCliente);
						break;
						
					case 3:///
						
						validacao2.add(labelLogin);
						validacao2.add(numConta2);
						validacao2.add(labelSenha);
						validacao2.add(senhaConta3);
						opcao = JOptionPane.showOptionDialog(null, validacao2, "Tela de Login", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
						
						if(opcao==0) {
							///NUMERO DA CONTA
							
							contaKey = Integer.parseInt(numConta2.getText());
							contaUsuarioAtiva=acharUsuario(CUsuario, contaKey, nUsuario);
							
							if(contaUsuarioAtiva==99) {
								JOptionPane.showMessageDialog(null, "Conta não encontrada");
								
							}else {
								///SENHA
								
								senha = String.valueOf(senhaConta3.getPassword());
								
								if(CUsuario[contaUsuarioAtiva].conferirSenha(senha)==0) {
									JOptionPane.showMessageDialog(null, "Senha incorreta");
								}
								else {
									///CLIENTE VALIDADO
									retirarDinheiro(Cconta, nCCliente, CUsuario[contaUsuarioAtiva]);
								}
							}
						}
						
						break;
						
					case 4:///Saldo OK
						validacao2.add(labelLogin);
						validacao2.add(numConta2);
						validacao2.add(labelSenha);
						validacao2.add(senhaConta3);
						opcao = JOptionPane.showOptionDialog(null, validacao2, "Tela de Login", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[1]);
						
						if(opcao==0) {
							///NUMERO DA CONTA
							
							contaKey = Integer.parseInt(numConta2.getText());
							contaUsuarioAtiva=acharUsuario(CUsuario, contaKey, nUsuario);
							
							if(contaUsuarioAtiva==99) {
								JOptionPane.showMessageDialog(null, "Conta não encontrada");
								
							}else {
								///SENHA
								
								senha = String.valueOf(senhaConta3.getPassword());
								
								if(CUsuario[contaUsuarioAtiva].conferirSenha(senha)==0) {
									JOptionPane.showMessageDialog(null, "Senha incorreta");
								}
								else {
									///CLIENTE VALIDADO
									consultarSaldo(Cconta, nCCliente, CUsuario[contaUsuarioAtiva]);
								}
							}
						}
						
						
						break;
						
					case 5:///verificar extratos NÃO FEITO
						break;
						
					case 6:///alterar senha OK
						
						mudarSenha(Cconta, key, nCCliente);
						break;
						
					default:
						break;
					}	
				}
			}
		}
	}
}
