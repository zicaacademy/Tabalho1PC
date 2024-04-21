package Classes;

public class Loja {
	String nome;
	String nomeFuncionario1;
	String nomeFuncionario2;
	boolean funcionario1Pago = false;
	Conta conta = new Conta(0, nome);
	Funcionario funcionario1 = new Funcionario(nomeFuncionario1);
	Funcionario funcionario2 = new Funcionario(nomeFuncionario2);
	
	public Loja(String nome,String nomeFuncionario1,String nomeFuncionario2) {
		this.nome = nome;
		this.nomeFuncionario1 = nomeFuncionario1;
		this.nomeFuncionario2 = nomeFuncionario2;
		pagamentoDosFuncionarios();
	}
	
	public void pagamentoDosFuncionarios(){
		if (this.conta.saldo >= 1400){
			if (funcionario1Pago) {
				this.funcionario1.contaSalario.saldo += 1400;
				this.conta.saldo -= 1400;
			}else {
				this.funcionario1.contaSalario.saldo += 1400;
				this.conta.saldo -= 1400;
				funcionario1Pago = true;
			}
		}
	}
}
