
public class Corrente extends ContaCliente {

	
	public void sacar(double valor) 
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
	}
}
