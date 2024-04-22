package Classes;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	//ArrayList<String> historicoTransacoes = new ArrayList<>();
	private static Lock lock = new ReentrantLock();
	
	Cliente[] clientes = new Cliente[4];
	Loja[] lojas = new Loja[1];

	public Banco(Cliente[] clientes, Loja[] lojas) {
		System.out.print("iniciando");
		this.clientes = clientes;
		this.lojas = lojas;
	}
	
	public void comecar(){
		System.out.print("iniciando");
		lock.lock();
		for (int i=0; i <= clientes.length;i++) {
			try {
				clientes[i].start();
			}finally {
				lock.unlock();
			}
		}
	}
}
