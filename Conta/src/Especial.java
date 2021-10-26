
public class Especial extends ContaCliente{
	private double limite;
	
	public void setLimite(double limitedado) {
		limite=limitedado;
	}
	
	public double getLimite() {
		return limite;
	}
	
	public void sacar(double valor) 
	{
		if(saldo+limite==0) 
		{///Caso conta nao tenha dinheiro
			
		}else 
		{
			if(valor>=saldo+saldo) 
			{///Caso valor seja maior que o que tem na conta
				
			}else ///Caso o saque aconteca
			{
				saldo-=valor;
			}
		}
	}
	
}
