package Classes;

public class Funcionario extends Thread {
	private final Banco banco;
	private String nome;
	Conta contaSalario;
	Conta contaInvestimento;

	Object lock;

	public Funcionario(String nome, Banco banco, Object lock) {
		this.banco = banco;
		this.nome = nome;
		this.contaInvestimento = new Conta("conta de investimentos de " + nome);
		this.contaSalario = new Conta(nome);
		this.lock = lock;
	}

	public void run() {
		investir();
	}

	public void investir() {
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (this.contaSalario.getSaldo() >= 1400) {
				double valorAInvestir = this.contaSalario.getSaldo() * 0.20;
				System.out.print("\t saldo na conta de " + this.nome+ " : " + this.contaSalario.getSaldo() + "\n\n");
				banco.transferir(contaSalario, contaInvestimento, valorAInvestir);
				System.out.print("\t saldo na conta de " + this.nome +" : "+ this.contaSalario.getSaldo() + "\n\n");
				System.out.print("\t saldo na conta de investimentos de " + this.nome
						+ " : " + this.contaInvestimento.getSaldo() + "\n\n");
			}
		}
	}

	public String getNome() {
		return nome;
	}
}
