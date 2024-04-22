package Classes;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	private static Lock lock = new ReentrantLock();
	
	Cliente[] clientes = new Cliente[4];
	Loja[] lojas = new Loja[1];

	public Banco(Cliente[] clientes, Loja[] lojas) {
		System.out.print("iniciando");
		this.clientes = clientes;
		this.lojas = lojas;
	}
	
	public void transferir(Conta origem, Conta destino, double valor){
		lock.lock();
		try {
			if (origem.getSaldo() >= valor) {
				destino.deposito(valor);
				origem.debitar(valor);
				System.out.print("Transferencia no valor de "+valor+"$ de "+origem.nome+" para "+destino.nome+"\n");
			}else {
				System.out.print("Não foi possivel tranferir o valor de "+valor+"$ pois o saldo é insuficinte\n");

			}
		}finally {
			lock.unlock();
		}
	}
}
