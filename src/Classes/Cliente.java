package Classes;
import java.util.Random;

public class Cliente extends Thread{
	String nome;
	Conta conta = new Conta(1000, this.nome);
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public void run(Loja loja1, Loja loja2) {
		comprar(loja2, loja2);
	}
	
	public void comprar(Loja loja1, Loja loja2) {
		boolean alternar = true;

		while(conta.saldo != 0) {
			int valor = new Random().nextInt(2);
			double resultado = (valor == 0) ? 100 : 200;
			if (this.conta.saldo == 100) {
				resultado = 100;
			}
			if (alternar){
				loja1.conta.saldo += resultado;
				System.out.print("compra de "+resultado+" na loja "+loja1.nome+"\n");
			}else {
				loja2.conta.saldo += resultado;
				System.out.print("compra de "+resultado+" na loja "+loja2.nome+"\n");
			}
			this.conta.saldo -= resultado;
			System.out.print("saldo na conta do cliente "+this.nome+": "+this.conta.saldo+"\n");
			alternar = !alternar;
		}
	}


}
