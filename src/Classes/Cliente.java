package Classes;
import java.util.Random;

public class Cliente extends Thread{
	String nome;
	Conta conta = new Conta(1000, this.nome);
	Loja loja1 = new Loja("Aplle", "Maria", "Jonas");
	Loja loja2 = new Loja("Microsoft", "Jose", "Luciana");
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public void run() {
		comprar();
	}
	
	public synchronized void comprar() {
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
