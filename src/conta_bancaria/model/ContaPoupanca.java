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
	
	protected String linhaLimiteCP() {
	    // Definindo o texto da linha do aniversário
	    String label = " Aniv. da conta:  ";
	    
	    // Convertendo o aniversário para string
	    String aniversarioStr = String.valueOf(this.aniversario);
	    
	    // Total de caracteres da linha (incluindo bordas)
	    int larguraTotal = 40; // Total de largura da linha
	    int larguraConteudo = label.length() + aniversarioStr.length(); // Largura do conteúdo
	    int espacosDireita = larguraTotal - 2 - larguraConteudo; // Espaços à direita para preencher a linha

	    // Montando a linha
	    String linha = Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "║" + // Borda esquerda
	                   Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + label + // Texto do aniversário
	                   Cores.TEXT_YELLOW + aniversarioStr + // Aniversário formatado
	                   Cores.ANSI_BLACK_BACKGROUND + " ".repeat(espacosDireita) + // Espaços à direita
	                   Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "║"; // Borda direita

	    return linha;
	}
}
