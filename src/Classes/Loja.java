package Classes;

public class Loja {
	private boolean funcionario1Pago = false;
	private String nome;
	private final Banco banco;
	Conta conta;
	Funcionario funcionario1;
	Funcionario funcionario2;
	Object lock;

	public Loja(Funcionario funcionario1, Funcionario funcionario2, String nome, Banco banco, Object lock) {
		this.banco = banco;
		this.nome = nome;
		this.funcionario1 = funcionario1;
		this.funcionario2 = funcionario2;
		this.conta = new Conta(nome);
		this.lock = lock;
	}

	public void pagamentoDosFuncionarios() {
		while (this.conta.getSaldo() >= 1400) {
			if (funcionario1Pago) {
				banco.transferir(this.conta, funcionario2.contaSalario, 1400);
				System.out.print("\t\t" + this.nome + " pagou o funcionario " + this.funcionario2.getNome() + "\n\n");

			} else {
				banco.transferir(this.conta, funcionario1.contaSalario, 1400);
				funcionario1Pago = true;
				System.out.print("\t\t" + this.nome + " pagou o funcionario " + this.funcionario1.getNome() + "\n\n");

			}
			System.out.print("\t saldo da loja " + this.nome + ": " + this.conta.getSaldo() + "\n\n");
			
			synchronized (lock) {
	            lock.notifyAll();
	        }
		}
	}

	public String getNome() {
		return nome;
	}
}
