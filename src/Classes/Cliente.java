package Classes;
import java.util.Random;

public class Cliente extends Thread{
	String nome;
	Conta conta = new Conta(1000, this.nome);
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public void run(Loja loja1, Loja loja2) {
		boolean alternar = true;
		
		while(conta.saldo != 0) {
			int valor = new Random().nextInt(2);
			double resultado = (valor == 0) ? 100 : 200;
			if (alternar){
				loja1.conta.saldo += resultado;
			}else {
				loja2.conta.saldo += resultado;
			}
			this.conta.saldo -= resultado;
			alternar = !alternar;
		}
	}


}
