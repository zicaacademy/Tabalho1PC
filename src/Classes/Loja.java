package Classes;

public class Loja {
	boolean funcionario1Pago = false;
	Banco banco;
	Conta conta;
	Funcionario funcionario1;
	Funcionario funcionario2;
	
	public Loja(Funcionario funcionario1,Funcionario funcionario2) {
		this.funcionario1 = funcionario1;
		this.funcionario2 = funcionario2;
	}
	
	public void pagamentoDosFuncionarios(){
		while (true) {
			if (this.conta.getSaldo() >= 1400){
				if (funcionario1Pago) {
					this.funcionario1.contaSalario.deposito(1400);
					this.conta.debitar(1400);
					break;
				}else {
					this.funcionario1.contaSalario.deposito(1400);
					this.conta.debitar(1400);
					funcionario1Pago = true;
					break;
				}
			}
		}
	}
}
