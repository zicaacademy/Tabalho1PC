package Classes;

public class Funcionario extends Thread{
	private final Banco banco;
	private String nome;
	Conta contaSalario = new Conta(0, nome);
	Conta contaInvestimento = new Conta(0, nome);
	
	public Funcionario (String nome, Banco banco) {
		this.banco = banco;
		this.nome = nome;
	}
	
	public void run() {
		investir();
	}
	
	public synchronized void investir(){
		while(true) {
			if (this.contaSalario.getSaldo()>= 1400) {
				double valorAInvestir = this.contaSalario.getSaldo() * 0.20;
				banco.transferir(contaSalario, contaInvestimento, valorAInvestir);
				break;
			}
		}
	}
	
	public String getNome() {
		return nome;
	}
}
