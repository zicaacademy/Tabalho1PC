package Classes;

public class Main {

	public static void main(String[] args) {
		System.out.print("foi");
		
		Cliente[] clientes = new Cliente[4];
		clientes[0] = new Cliente("Felipe");
		clientes[1] = new Cliente("Ana");
		clientes[2] = new Cliente("Alana");
		clientes[3] = new Cliente("Jonas");
		clientes[4] = new Cliente("Pedro");
		
		Loja[] lojas = new Loja[1];
		lojas[0] = new Loja("Apple", "Silvana", "Anderson");
		lojas[1] = new Loja("Microsoft", "Julio", "Erick");

		
		Banco banco = new Banco(clientes, lojas);
		
		banco.comecar();
	}

}
