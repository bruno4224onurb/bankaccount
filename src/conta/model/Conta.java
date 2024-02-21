package conta.model;

public abstract class Conta {

	private int numeroConta;
	private int agencia;
	private int tipoConta;
	private double saldo;
	private String titular;
	public String tipo;

	public Conta(int numeroConta, int agencia, int tipoConta, float saldo, String titular) {
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
		this.titular = titular;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public float getSaldo() {
		return (float) saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public boolean sacar(float valor) {

		if (this.saldo < valor)
			return false;

		this.setSaldo(this.saldo - valor);
		return true;
	}

	public void depositar(float valor) {
		this.setSaldo(this.saldo + valor);
	}

	public void visualizar() {
		switch (getTipoConta()) {
		case 1:
			this.tipo = "Conta Corrente";
			break;
		case 2:
			this.tipo = "Conta Poupança";
			break;
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\nDADOS DA CONTA:"
				+ "\n+++++++++++++++++++++++++++++++++++++++++++++++++" + "\nNúmero da Conta: " + getNumeroConta()
				+ "\nNúmero da Agência: " + getAgencia() + "\nTipo da Conta: " + this.tipo + "\nTitular da Conta: "
				+ getTitular() + "\nSaldo: " + getSaldo());

	}
}
