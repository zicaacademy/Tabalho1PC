package Classes;

public class Funcionario extends Thread{
	Conta contaSalario;
	Conta contaInvestimento;

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
}
