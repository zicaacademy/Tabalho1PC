package Classes;

public class Main {

	public static void main(String[] args) {
		
        Object lock = new Object();

		Banco banco = new Banco();

		Funcionario[] funcionarios = new Funcionario[4];
		funcionarios[0] = new Funcionario("Ricardo", banco, lock);
		funcionarios[1] = new Funcionario("Fernanda", banco, lock);
		funcionarios[2] = new Funcionario("Julio", banco, lock);
		funcionarios[3] = new Funcionario("Aline", banco, lock);

		Loja[] lojas = new Loja[2];
		lojas[0] = new Loja(funcionarios[0], funcionarios[1], "Casas Bahia", banco, lock);
		lojas[1] = new Loja(funcionarios[2], funcionarios[3], "Amazon", banco, lock);

		Cliente[] clientes = new Cliente[5];
		clientes[0] = new Cliente("Felipe", lojas, banco);
		clientes[1] = new Cliente("Ana", lojas, banco);
		clientes[2] = new Cliente("Alana", lojas, banco);
		clientes[3] = new Cliente("Jonas", lojas, banco);
		clientes[4] = new Cliente("Pedro", lojas, banco);

		for (int i = 0; i < 4; i++) {
			funcionarios[i].start();
		}

		for (int i = 0; i < 5; i++) {
			System.out.print("saldo na conta" + clientes[i].conta.getNome() + ": " + clientes[i].conta.getSaldo());
			clientes[i].start();
			try {
				clientes[i].join();
			} catch (InterruptedException e) {
				System.out.print("erro no join");
			}
		}

		for (int i = 0; i < 2; i++) {
			lojas[i].pagamentoDosFuncionarios();
		}

	}

}
