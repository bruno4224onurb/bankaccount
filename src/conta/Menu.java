package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaPoupanca;
import conta.util.Cores;
import conta.model.ContaCorrente;

public class Menu {
	public static void main(String[] args) {
		
		// teste classe ContaCorrente
		ContaCorrente cc1 = new ContaCorrente(000003, 0001, 1, 00.00f, "José Manuel Ferreira", 100.00f);

		cc1.visualizar();
		cc1.setLimite(200.00f);
		cc1.depositar(4000.00f);
		System.out.println("Você recebeu um depósito, seu novo saldo: " + cc1.getSaldo());
		boolean saque1 = cc1.sacar(100.00f);
		if (saque1) {
			System.out.println("Você realizou um saque, seu novo saldo:" + cc1.getSaldo());
		}
		cc1.visualizar();

		// teste classe ContaPoupanca
		ContaPoupanca cp1 = new ContaPoupanca(000004, 0001, 2, 00.00f, "Jorge Ferreira", 0);

		cp1.visualizar();
		cp1.setNiver(1);
		cp1.visualizar();
		// menu

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND
					+ "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++"
					+ "\n                                                     "
					+ "\n                       BBANK                         "
					+ "\n                                                     "
					+ "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++"
					+ "\n                                                     "
					+ "\n            1 - Criar Conta                          "
					+ "\n            2 - Listar todas as Contas               "
					+ "\n            3 - Buscar Conta por Numero              "
					+ "\n            4 - Atualizar Dados da Conta             "
					+ "\n            5 - Apagar Conta                         "
					+ "\n            6 - Sacar                                "
					+ "\n            7 - Depositar                            "
					+ "\n            8 - Transferir valores entre Contas      "
					+ "\n            9 - Sair                                 "
					+ "\n                                                     "
					+ "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++"
					+ "\nEntre com a opção desejada:                          "
					+ "\n                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_RED + "\nBBank, inovação e tecnologia!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED + "\nOpção Inválida!\n");
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND
				+ "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++"
				+ "\n     Projeto Desenvolvido por: Bruno S. Franchi" + "\n              github.com/bruno4224onurb"
				+ "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
