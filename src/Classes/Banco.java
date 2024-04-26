package Classes;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	private static Lock lock = new ReentrantLock();
	
	public Banco() {
		// TODO Auto-generated constructor stub
	}

	public void transferir(Conta origem, Conta destino, double valor){
		lock.lock();
		try {
			if (origem.getSaldo() >= valor) {
				destino.deposito(valor);
				origem.debitar(valor);
				System.out.print("Transferencia no valor de "+valor+"$ de "+origem.getNome()+" para "+destino.getNome()+"\n");
			}else {
				System.out.print("Não foi possivel tranferir o valor de "+valor+"$ pois o saldo é insuficinte\n");

			}
		}finally {
			lock.unlock();
		}
	}
}
