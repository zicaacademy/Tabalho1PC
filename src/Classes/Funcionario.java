package Classes;

public class Funcionario extends Thread{
	private String nome;
	Conta contaSalario;
	Conta contaInvestimento;
	
	public Funcionario (String nome, Conta contaInvestimento, Conta contaSalario) {
		this.nome = nome;
		this.contaInvestimento = contaInvestimento;
		this.contaSalario = contaSalario;
	}
	
	public void run() {
		investir();
	}
	
	public synchronized void investir(){
		while(true) {
			if (this.contaSalario.getSaldo()>= 1400) {
				double valorAInvestir = this.contaSalario.getSaldo() * 0.20;
				contaSalario.debitar(valorAInvestir);
				contaInvestimento.deposito(valorAInvestir);
				break;
			}
		}
	}
	
	public String getNome() {
		return nome;
	}
}
