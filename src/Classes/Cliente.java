package Classes;
import java.util.Random;

public class Cliente extends Thread{
	private final Banco banco;
	private String nome;
	private Conta conta = new Conta(1000, this.nome);
	private Loja loja1;
	private Loja loja2;
	
	public Cliente(String nome, Loja[] lojas, Banco banco) {
		this.banco = banco;
		this.loja1 = lojas[0];
		this.loja2 = lojas[1];
		this.nome = nome;
	}
	
	public void run() {
		comprar();
	}
	
	public synchronized void comprar() {
		boolean alternar = true;

		while(conta.getSaldo() >= 0) {
			int valor = new Random().nextInt(2);
			double resultado = (valor == 0) ? 100 : 200;
			if (this.conta.getSaldo() == 100) {
				resultado = 100;
			}
			if (alternar){
				banco.transferir(this.conta, loja1.conta, resultado);
				System.out.print("compra de "+resultado+" na loja1\n");
			}else {
				banco.transferir(this.conta, loja2.conta, resultado);
				System.out.print("compra de "+resultado+" na loja2\n");
			}
			System.out.print("saldo na conta do cliente "+this.nome+": "+this.conta.getSaldo()+"\n");
			alternar = !alternar;
		}
	}

	public String getNome() {
		return nome;
	}

}
