import javax.swing.JOptionPane;

public abstract class Conta {

	///NOTA, ainda h� senha aqui, pois gerente na� � um usuario, sendo assim � somente CONTA, tendo que ter senha
	//Todos as outras contas sempre que � pedido senha, se refere a senha do USUARIO
	private String nome;
	private int numConta;
	public double saldo=0;
	private String senha="default";
	public int gQueCadastrou;
	
	public void setNumeroConta(int numero)///NUMERO CONTA
	{
		numConta=numero;
	}
	
	public int getNumeroConta()
	{
		return numConta;
	}
	
	public void setNome(String nomeinserido)///NOME
	{
		nome=nomeinserido;
	}
	
	public String getNome()
	{
		return nome;
	}
		
	public double getSaldo()
	{
		return saldo;
	}
	
	public void setgQueCadastrou(int numconta) {
		gQueCadastrou=numconta;
	}
	
	public int getgQueCadastrou() {
		return gQueCadastrou;
	}
	

	
	public void depositar (double valor)///deposita
	{
		saldo+=valor;
		
		
	}
	
	public void alterarSenha (String senhaAntiga, String senhaNova) 
	{
		if(senhaAntiga.equals(senha))
		{
			if(!senha.equals("default")) {
				JOptionPane.showMessageDialog(null, "Senha alterada com socesso!");
			}
			senha=senhaNova;
			
			
		}else
		{
			JOptionPane.showMessageDialog(null, "Senha errada");
		}
	}
	
	public int conferirSenha(String senhadada) {
		if(senha.equals(senhadada)) {
			return 1;
		}else {
			return 0;
		}
	}
	
	


}
