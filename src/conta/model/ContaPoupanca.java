package conta.model;

public class ContaPoupanca extends Conta {

	private int niver;

	public ContaPoupanca(int numeroConta, int agencia, int tipoConta, float saldo, String titular, int niver) {
		super(numeroConta, agencia, tipoConta, saldo, titular);
		this.setNiver(niver);
	}

	public int getNiver() {
		return niver;
	}

	public void setNiver(int niver) {
		this.niver = niver;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário da Conta: " + this.niver);
	}

	// TODO add rendimento mensal

}
