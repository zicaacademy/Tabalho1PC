package Classes;

public class Loja {
	private boolean funcionario1Pago = false;
	private String nome;
	private final Banco banco;
	Conta conta = new Conta(0, nome);
	Funcionario funcionario1;
	Funcionario funcionario2;
	
	public Loja(Funcionario funcionario1,Funcionario funcionario2,String nome, Banco banco) {
		this.banco = banco;
		this.nome = nome;
		this.funcionario1 = funcionario1;
		this.funcionario2 = funcionario2;
	}
	
	public void pagamentoDosFuncionarios(){
		while (true) {
			if (this.conta.getSaldo() >= 1400){
				if (funcionario1Pago) {
					banco.transferir(this.conta, funcionario2.contaSalario, 1400);
					break;
				}else {
					banco.transferir(this.conta, funcionario1.contaSalario, 1400);
					funcionario1Pago = true;
					break;
				}
			}
		}
	}
	
	public String getNome(){
		return nome;
	}
}
