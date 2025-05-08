package conta_bancaria.model;

import java.text.NumberFormat;

import conta_bancaria.util.Cores;

public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
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

			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND);
	        System.out.println("╔══════════════════════════════════════╗");
	        System.out.println("║" + Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "           Saque realizado            " + Cores.TEXT_CYAN + "║");
	        System.out.println("╚══════════════════════════════════════╝" + Cores.TEXT_RESET);
			return true;
		}
		System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND);
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║" + Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND + "       O saldo é insuficiente         " + Cores.TEXT_CYAN + "║");
        System.out.println("╚══════════════════════════════════════╝" + Cores.TEXT_RESET);
		return false;
	}

	protected String linhaLimite() {

		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		String limiteFormatado = nfMoeda.format(this.limite);

		// Definindo o texto da linha do limite
		String label = " Limite da conta: ";

		// Total de caracteres da linha (incluindo bordas)
		int larguraTotal = 40; // Total de largura da linha
		int larguraConteudo = label.length() + limiteFormatado.length(); // Largura do conteúdo
		int espacosDireita = larguraTotal - 2 - larguraConteudo; // Espaços à direita para preencher a linha

		if (limite > 0)
			limiteFormatado = Cores.TEXT_GREEN + nfMoeda.format(this.limite) + Cores.TEXT_RESET;
		else if (limite < 0)
			limiteFormatado = Cores.TEXT_RED + nfMoeda.format(this.limite) + Cores.TEXT_RESET;

		// Montando a linha
		String linha = Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "║" + // Borda esquerda
				Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + label + // Texto do limite
				limiteFormatado + // Limite formatado
				Cores.ANSI_BLACK_BACKGROUND + " ".repeat(espacosDireita) + // Espaços à direita
				Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "║"; // Borda direita

		return linha;
	}
}
