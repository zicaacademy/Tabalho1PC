package Classes;
import java.util.Random;

public class Cliente extends Thread{
	String nome;
	Conta conta = new Conta(1000, this.nome);
	Loja loja1;
	Loja loja2;
	
	public Cliente(String nome, Loja loja1,Loja loja2) {
		this.loja1 = loja1;
		this.loja2 = loja2;
		this.nome = nome;
	}
	
	public void run() {
		comprar();
	}
	
	public synchronized void comprar() {
		boolean alternar = true;

		while(conta.getSaldo() != 0) {
			int valor = new Random().nextInt(2);
			double resultado = (valor == 0) ? 100 : 200;
			if (this.conta.getSaldo() == 100) {
				resultado = 100;
			}
			if (alternar){
				loja1.conta.deposito(resultado);
				System.out.print("compra de "+resultado+" na loja1\n");
			}else {
				loja2.conta.deposito(resultado);
				System.out.print("compra de "+resultado+" na loja2\n");
			}
			this.conta.debitar(resultado);
			System.out.print("saldo na conta do cliente "+this.nome+": "+this.conta.getSaldo()+"\n");
			alternar = !alternar;
		}
	}


}
