package conta_bancaria.model;

import java.text.NumberFormat;

import conta_bancaria.util.Cores;

public abstract class Conta {

	// Atributos
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	
	// Método Construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public Conta() {
	}

	// Métodos Get e Set
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getAgencia() {
		return agencia;
	}


	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public float getSaldo() {
		return saldo;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	// Métodos Bancários
	
	public boolean sacar(float valor) {
		
		if (this.saldo >= valor) {
	        this.saldo -= valor; 
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
	
	public void depositar(float valor) {
		this.saldo += valor; 
	}
	
	protected String linhaLimite() {
	    return "";
	}
	
	protected String linhaLimiteCP() {
	    return "";
	}

	public void visualizar() {
	    NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

	    String tipoStr = switch (this.tipo) {
	        case 1 -> "Conta Corrente";
	        case 2 -> "Conta Poupança";
	        default -> "Inválido";
	    };

	    String saldoFormatado = null;

	    if (saldo > 0) 
	        saldoFormatado = Cores.TEXT_GREEN + nfMoeda.format(this.saldo);
	    else if (saldo < 0)
	        saldoFormatado = Cores.TEXT_RED + nfMoeda.format(this.saldo);
	    else
	        saldoFormatado = nfMoeda.format(this.saldo); // Para saldo zero

	    System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND);
	    System.out.println("╔══════════════════════════════════════╗");
	    System.out.println("║          📋 " + Cores.TEXT_WHITE + "DADOS DA CONTA" + Cores.TEXT_CYAN + "           ║");
	    System.out.println("╠══════════════════════════════════════╣");
	    System.out.println("║" + Cores.TEXT_WHITE + " Número da Conta: " + Cores.TEXT_YELLOW + String.format("%-20s", this.numero)  + Cores.TEXT_CYAN + "║");
	    System.out.println("║" + Cores.TEXT_WHITE + " Agência:         " + Cores.TEXT_YELLOW + String.format("%-20s", this.agencia) + Cores.TEXT_CYAN + "║");
	    System.out.println("║" + Cores.TEXT_WHITE + " Tipo de Conta:   " + Cores.TEXT_YELLOW + String.format("%-20s", tipoStr)    + Cores.TEXT_CYAN + "║");
	    System.out.println("║" + Cores.TEXT_WHITE + " Titular:         " + Cores.TEXT_YELLOW + String.format("%-20s", this.titular)  + Cores.TEXT_CYAN + "║");
	    System.out.println("║" + Cores.TEXT_WHITE + " Saldo:           " + Cores.TEXT_YELLOW + String.format("%-25s", saldoFormatado) + Cores.TEXT_CYAN + "║");

	    // Inclui a linha do limite se houver (para conta corrente)
	    String limiteLinha = linhaLimite();
	    String limiteLinhaCP = linhaLimiteCP();
	    
	    if (!limiteLinha.isEmpty()) {
	        System.out.println(limiteLinha);
	    } 
	    
	    if (!limiteLinhaCP.isEmpty()) {
	        System.out.println(limiteLinhaCP);
	    }
	    
	    System.out.println("╚══════════════════════════════════════╝" + Cores.TEXT_RESET);
	}
}
