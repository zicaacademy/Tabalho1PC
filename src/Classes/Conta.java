package Classes;

public class Conta {
	private double saldo;
	private String nome;

	public Conta(String nome) {
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}
}
