
public abstract class Conta {

	private String nome;
	private int numConta;
	public double saldo=0;
	private String senha;
	
	
	
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
	

	/*public void sacar(double valor) 
	{
		if(saldo==0) 
		{///Caso conta nao tenha dinheiro
			System.out.printf("\n Conta sem dinheiro\n");
		}else 
		{
			if(valor>=saldo) 
			{///Caso valor seja maior que o que tem na conta
				System.out.printf("\nValor requerido maior que o que tem na conta\n");
			}else ///Caso o saque aconteca
			{
				saldo-=valor;
			}
		}
	}*/
	
	public void depositar (double valor)///deposita
	{
		saldo=valor;
		System.out.printf("\n Depositado com sucesso!\n");
	}
	
	public void alterarSenha (String senhaAntiga, String senhaNova) 
	{
		if(senhaAntiga==senha)
		{
			senha=senhaNova;
			if (senhaAntiga!=null){
				System.out.printf("\n Senha alterada com sucesso\n");
			}
			
		}else
		{
			System.out.printf("\n Senha antiga incorreta\n");
		}
	}
	
	public int conferirSenha(String senhadada) {
		if(senha.equals(senhadada)) {
			return 1;
		}else {
			System.out.printf("SENHA: %s \n", senha);
			System.out.printf("SENHA DIGITADO: %s \n", senhadada);
			return 0;
		}
	}
	


}
