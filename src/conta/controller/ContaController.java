package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaArray(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA conta número " + numero + " não existe na nossa base de dados!");

	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta número " + conta.getNumeroConta() + " foi criada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaArray(conta.getNumeroConta());

		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("A conta de número " + conta.getNumeroConta() + "foi atualizada com sucesso!");
		}

		else {
			System.out.println("\nA conta número " + conta.getNumeroConta() + " não existe na nossa base de dados!");
		}

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaArray(numero);

		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.println("A conta de número " + numero + "foi excluida com sucesso!");
			}
		} else {
			System.out.println("\nA conta número " + numero + " não existe na nossa base de dados!");
		}

	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaArray(numero);

		if (conta != null) {
			if (conta.sacar(valor) == true) {
				System.out.println("\nO saque na conta número " + numero + " foi efetuado com sucesso!");
			}
		} else {
			System.out.println("\nA conta número " + numero + " não existe na nossa base de dados!");
		}

	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaArray(numero);

		if (conta != null) {
			conta.depositar(valor);
			System.out.println("\nO Depósito na conta número " + numero + "foi efetuado com sucesso!");
		} else {
			System.out.println("\nA conta" + numero + " não existe na nossa base de dados!");
		}

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaArray(numeroOrigem);
		var contaDestino = buscarNaArray(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {
			if (contaOrigem.sacar(valor) == true);
			contaDestino.depositar(valor);
			System.out.println("Transferência concluída!");
		}else {
			System.out.println("\nA conta de origem e/ou destino não foram encontradas!");
		}

	}

	int numero = 0;

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaArray(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumeroConta() == numero) {
				return conta;
			}
		}

		return null;
	}

}
