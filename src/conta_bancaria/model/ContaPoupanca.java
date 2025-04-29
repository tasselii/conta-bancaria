package conta_bancaria.model;

import java.text.NumberFormat;

import conta_bancaria.util.Cores;

public class ContaPoupanca extends Conta {

	private float limite;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
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
			
		if ((this.getSaldo() + this.limite) >= valor) {
		    this.setSaldo(this.getSaldo() - valor); 
		    
		        System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "╔══════════════════════════════════════╗");
		        System.out.println(Cores.TEXT_CYAN + "║" + Cores.TEXT_GREEN + "             Saque realizado " + Cores.TEXT_CYAN + "         ║");
		        System.out.println("╚══════════════════════════════════════╝");
		        return true; 
		    }
			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "╔══════════════════════════════════════╗");
	        System.out.println(Cores.TEXT_CYAN + "║" + Cores.TEXT_RED + "        O saldo é insuficiente " + Cores.TEXT_CYAN + "       ║");
	        System.out.println("╚══════════════════════════════════════╝");
			return false;
		}
	
	@Override
	public void visualizar() {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		super.visualizar();
		System.out.println("Limite da conta " + nfMoeda.format(this.limite));
	}
}
