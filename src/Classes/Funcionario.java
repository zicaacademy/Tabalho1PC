package Classes;

public class Funcionario extends Thread{
	String nome;
	Conta contaSalario = new Conta(0, nome);
	Conta contaInvestimento = new Conta(0, nome);
	
	public Funcionario (String nome) {
		this.nome = nome;
	}
	
	public void run() {
		investir();
	}
	
	public void investir(){
		if (this.contaSalario.saldo >= 1400) {
			double valorAInvestir = (this.contaSalario.saldo*20)/100;
			this.contaInvestimento.saldo += valorAInvestir;
			this.contaSalario.saldo -= valorAInvestir;
		}
	}
}
