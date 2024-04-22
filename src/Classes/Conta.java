package Classes;

public class Conta {
	private double saldo;
	String nome;

	public Conta(double saldo, String nome) {
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public void deposito(double valor) {
		saldo += valor;
	}
	
	public void debitar(double valor) {
		saldo -= valor;
	}
	
	public double getSaldo() {
		return saldo;
	}

}
