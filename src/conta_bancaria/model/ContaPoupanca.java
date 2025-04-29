package conta_bancaria.model;

import conta_bancaria.util.Cores;

public class ContaPoupanca extends Conta {

	private int aniversario;
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int diaAniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = diaAniversario;
	}
	
	public int getDiaAniversario() {
		return aniversario;
	}

	public void setDiaAniversario(int diaAniversario) {
		this.aniversario = diaAniversario;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "╔══════════════════════════════════════╗");
        System.out.println(Cores.TEXT_CYAN + "║" + Cores.TEXT_YELLOW + "       Aniversário da conta: " + this.aniversario + Cores.TEXT_CYAN + "       ║");
        System.out.println("╚══════════════════════════════════════╝");
	}
}
