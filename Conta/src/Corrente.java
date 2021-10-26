
public class Corrente extends ContaCliente {

	
	public void sacar(double valor) 
	{
		if(saldo==0) 
		{///Caso conta nao tenha dinheiro
		
		}else 
		{
			if(valor>=saldo) 
			{///Caso valor seja maior que o que tem na conta
				
			}else ///Caso o saque aconteca
			{
				saldo-=valor;
			}
		}
	}
}
