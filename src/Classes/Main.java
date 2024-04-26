package Classes;

public class Main {

	public static void main(String[] args) {
		System.out.print("foi");
		Banco banco = new Banco();
		
		Funcionario[] funcionarios = new Funcionario[3];
		funcionarios[0] = new Funcionario("Ricardo", banco);
		funcionarios[1] = new Funcionario("Fernanda", banco);
		funcionarios[0] = new Funcionario("Julio", banco);
		funcionarios[1] = new Funcionario("Aline", banco);
		
		Loja[] lojas = new Loja[1];
		lojas[0] = new Loja(funcionarios[0], funcionarios[1], "Casas Bahia", banco);
		lojas[1] = new Loja(funcionarios[2], funcionarios[3], "Amazon", banco);
		
		Cliente[] clientes = new Cliente[4];
		clientes[0] = new Cliente("Felipe", lojas, banco);
		clientes[1] = new Cliente("Ana", lojas, banco);
		clientes[2] = new Cliente("Alana", lojas, banco);
		clientes[3] = new Cliente("Jonas", lojas, banco);
		clientes[4] = new Cliente("Pedro", lojas, banco);

		
		
		
		
	}

}
