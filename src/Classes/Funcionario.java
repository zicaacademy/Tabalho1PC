package Classes;

public class Funcionario extends Thread {
	private final Banco banco;
	private String nome;
	Conta contaSalario;
	Conta contaInvestimento;

	public Funcionario(String nome, Banco banco) {
		this.banco = banco;
		this.nome = nome;
		this.contaInvestimento = new Conta("conta de investimentos de " + nome);
		this.contaSalario = new Conta(nome);

	}

	public void run() {
		investir();
	}

	public void investir() {
		while (this.contaSalario.getSaldo() >= 1400) {
			double valorAInvestir = this.contaSalario.getSaldo() * 0.20;
			banco.transferir(contaSalario, contaInvestimento, valorAInvestir);
			break;

		}
	}

	public String getNome() {
		return nome;
	}
}
