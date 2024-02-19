package conta;

import conta.model.Conta;

public class Menu {
	public static void main(String[] args) {
		Conta c1 = new Conta(000001, 0001, 1, 00.00f, "Maria da Silva");
		Conta c2 = new Conta(000002, 0001, 2, 00.00f, "José Ferreira");

		c1.visualizar();
		c1.setTitular("Maria Ramona da Silva");
		c1.depositar(4000.00f);
		System.out.println("Você recebeu um depósito, seu novo saldo: " + c1.getSaldo());
		boolean saque = c1.sacar(100.00f);
		if (saque) {
			System.out.println("Você realizou um saque, seu novo saldo:" + c1.getSaldo());
		} else {
			System.out.println("Você não possui saldo para realizar este saque!");
		}
		c1.visualizar();
		c2.visualizar();
	}
}
