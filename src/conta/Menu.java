package conta;

import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaPoupanca;
import conta.util.Cores;
import conta.model.ContaCorrente;

public class Menu {
	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner input = new Scanner(System.in);

		int opcao, numero, agencia, tipo, niver, numDestino;
		String titular, resposta = "";
		float saldo, limite, valor;

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
			try {
				opcao = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Favor digitar um número inteiro de 1 a 9!");
				input.nextLine();
				opcao = 0;
			}
			if (opcao == 9) {
				System.out.println(Cores.TEXT_RED + "\nBBank, inovação e tecnologia!");
				sobre();
				input.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				do {
					try {
						System.out.println("Digite o número da agência:\n");
						agencia = input.nextInt();
						if (agencia < 0) {
							System.out.println("Digite um número inteiro positivo!");
						}
					} catch (InputMismatchException e) {
						System.out.println("Favor digitar um número inteiro!");
						input.nextLine();
						agencia = -1;
					}
				} while (agencia < 0);

				System.out.println("\nDigite o nome do Titular:\n");
				titular = input.next();

				do {
					System.out.println("\nDeseja fazer um depósito inicial?(S/N)\n");
					resposta = input.next();
					if (resposta.equalsIgnoreCase("S") == false && resposta.equalsIgnoreCase("N") == false) {
						System.out.println("Opção Inválida! Tente novamente...");
					}
				} while (resposta.equalsIgnoreCase("S") == false && resposta.equalsIgnoreCase("N") == false);
				if (resposta.equalsIgnoreCase("S")) {
					System.out.println("\nDigite o valor para depósito inicial(R$):\n");
					saldo = input.nextFloat();
				} else {
					saldo = 0f;
				}

				do {
					try {
						System.out.println(
								"\nQual o tipo de conta?\nPara conta Corrente digite 1.\nPara Poupança digite 2.\n");
						tipo = input.nextInt();
						if (1 > tipo || 2 < tipo) {
							System.out.println("Opção Inválida! Tente novamente...");
							tipo = 0;
						}
					} catch (InputMismatchException e) {
						System.out.println("Favor digitar um número inteiro de 1 a 2!");
						input.nextLine();
						tipo = 0;
					}
				} while (1 > tipo || 2 < tipo);

				switch (tipo) {
				case 1:
					do {
						try {
							System.out.println("\nDigite o Limite de crédito:\n");
							limite = input.nextFloat();
							if (limite < 0) {
								System.out.println("Limite inválido! Tente novamente...");
							}
						} catch (InputMismatchException e) {
							System.out.println("Favor digitar um número real positivo!");
							input.nextLine();
							limite = -1;
						}
					} while (limite < 0);
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, saldo, titular, limite));
					break;

				case 2:
					do {
						try {
							System.out.println("\nDigite o dia do aniversário da Conta:\n");
							niver = input.nextInt();
							if (niver < 0 || niver > 31) {
								System.out.println("Favor digitar um número inteiro positivo de 1 a 31!");
							}
						} catch (InputMismatchException e) {
							System.out.println("Favor digitar um número inteiro positivo de 1 a 31!");
							input.nextLine();
							niver = -1;
						}
					} while (niver < 0 || niver > 31);
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, saldo, titular, niver));
					System.out.println("\nConta criada com sucesso!");
					break;
				}
				resposta = "";
				keyPress();
				break;

			case 2:

				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;

			case 3:

				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				do {
					try {
						System.out.println("Digite o número da conta que você deseja consultar:\n");
						numero = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Favor digitar um número inteiro positivo!");
						input.nextLine();
						numero = -1;
					}
				} while (numero < 0);
				contas.procurarPorNumero(numero);
				keyPress();

				break;
			case 4:

				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				System.out.println("Digite o Número da Conta:\n");
				numero = input.nextInt();
				
				var buscaConta = contas.buscarNaArray(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipoConta();
					
					System.out.println("Digite o novo Número da Agência: ");
					agencia = input.nextInt();
					System.out.println("Digite o novo Titular: ");
					titular = input.next();
					
					System.out.println("Digite o Saldo da conta (R$): ");
					saldo = input.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o novo Limite de Crédito (R$): ");
							limite = input.nextFloat();
							
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, saldo, titular, limite));
						}
						case 2 -> {
							System.out.println("Digite o novo dia do Aniversário da Conta: ");
							niver = input.nextInt();
							
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, saldo, titular, niver));
						}
						default -> {
							System.out.println("Tipo de conta inválido!");
						}
					}
					
				}else {
					System.out.println("Conta não encontrada!");
				}

				keyPress();

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				System.out.println("Digite o Número da Conta:\n");
				numero = input.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				System.out.println("Digite o número da conta: ");
				numero = input.nextInt();

				do {
					System.out.println("Digite o valor do Saque (R$): ");
					valor = input.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);

				keyPress();

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				System.out.println("Digite o número da conta: ");
				numero = input.nextInt();

				do {
					System.out.println("Digite o valor do depósito(R$):");
					valor = input.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				System.out.println("Digite o número da conta de origem: \n");
				numero = input.nextInt();
				System.out.println("Digite o número da conta de destino: \n");
				numDestino = input.nextInt();

				do {
					System.out.println("Digite o valor da transferência (R$): ");
					valor = input.nextFloat();
				} while (valor <= 0);
				
				contas.transferir(numero, numDestino, valor);

				keyPress();

				break;
			default:
				System.out.println(Cores.TEXT_RED + "\nOpção Inválida!\n");
				break;
			}
		}
	}

	private static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "Aperte a tecla enter para continuar.");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você apertou outra tecla! Por favor aperte enter da próxima vez.");
		}

	}

	public static void sobre() {
		System.out.println(
				Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND + "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++"
						+ "\n     Projeto Desenvolvido por: Bruno S. Franchi      "
						+ "\n              github.com/bruno4224onurb              "
						+ "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
