package conta.model;

public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numeroConta, int agencia, int tipoConta, float saldo, String titular, float limite) {
		super(numeroConta, agencia, tipoConta, saldo, titular);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {

		if (this.getLimite() < valor) {
			System.out.println("Você não possui limite de crédito para esse saque!");
			return false;
		} else if (this.getSaldo() < valor) {
			System.out.println("Você não possui saldo para esse saque!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de crédito: " + this.limite);
	}
	// TODO add taxa mensal
}
