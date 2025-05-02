package conta_bancaria;

import java.io.IOException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
     
		        Scanner scan = new Scanner(System.in);
				
		        ContaController contas = new ContaController();
		        
				int opcao, numero, agencia, tipo, aniversario;
				String titular;
				float saldo, limite;
				
				// Dados para teste
				
				ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);

				contas.cadastrar(cc1);

				ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);

				contas.cadastrar(cp1);
				
				System.out.println();
				
				while(true) {
					System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND);
					System.out.println("╔══════════════════════════════════════╗");
					System.out.println("║" + Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "         ███  " + Cores.TEXT_WHITE + "🏦 BANCO Z " + Cores.TEXT_CYAN + " ███         " + Cores.TEXT_CYAN + "║");
					System.out.println("╠══════════════════════════════════════╣");
					System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 1 - Criar Conta                      " + Cores.TEXT_CYAN + "║");
					System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 2 - Listar Contas                    " + Cores.TEXT_CYAN + "║");
					System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 3 - Buscar Conta                     " + Cores.TEXT_CYAN + "║");
					System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 4 - Atualizar Conta                  " + Cores.TEXT_CYAN + "║");
					System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 5 - Apagar Conta                     " + Cores.TEXT_CYAN + "║");
					System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 6 - Sacar                            " + Cores.TEXT_CYAN + "║");
					System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 7 - Depositar                        " + Cores.TEXT_CYAN + "║");
					System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + " 8 - Transferir                       " + Cores.TEXT_CYAN + "║");
					System.out.println("║" + Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW +" 9 - Sair                             " + Cores.TEXT_CYAN + "║");
					System.out.println("╚══════════════════════════════════════╝" + Cores.TEXT_RESET);

					opcao = scan.nextInt();
						
					if (opcao == 9) {
						System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
						sobre();
						scan.close();
						System.exit(0);
					}
					
						
					switch (opcao) {
					case 1: System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n"); 
							
							System.out.println("Digite o número da agencia: ");
							agencia = scan.nextInt();
							
							System.out.println("Digite o nome do Titular: ");
							scan.nextLine();
							titular = scan.nextLine();
							
							System.out.println("Digite o tipo da conta (1 - CC | 2 - CP: ");
							tipo = scan.nextInt();
							
							System.out.println("Digite o Saldo inicial da conta: ");
							saldo = scan.nextFloat();
							
							switch(tipo) {
							case 1 -> {
										System.out.println("Digite o limite da conta: ");
										limite = scan.nextFloat();
										contas.cadastrar(
												new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
									 }
							case 2 -> {
										System.out.println("Digite o dia do aniversário da conta: ");
										aniversario = scan.nextInt();
										contas.cadastrar(
												new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
									}
							}
					
							keyPress();
							break;
					case 2: System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n"); 
							contas.listarTodas();
							keyPress();
							break;
					case 3: System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n"); 
							System.out.println("Digite o número da conta: ");
							numero = scan.nextInt();
					
							contas.procurarPorNumero(numero);
							keyPress();
							break;
					case 4: System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n"); 
							keyPress();
							break;
					case 5: System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n"); 
							keyPress();
							break;
					case 6: System.out.println(Cores.TEXT_WHITE + "Saque\n\n"); 
							keyPress();
							break;
					case 7: System.out.println(Cores.TEXT_WHITE + "Depósito\n\n"); 
							keyPress();
							break;
					case 8: System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n"); 
							keyPress();
							break;
					default: System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					}
				}
		   }
	
	public static void sobre() {
		System.out.println(Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND +
			    Cores.TEXT_CYAN + "\n╔════════════════════════════════════════════════════╗");
			System.out.println("║" + Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "  Projeto Desenvolvido por:                        " + Cores.TEXT_CYAN + " ║");
			System.out.println("║" + Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "  Thiago Tasseli - " +
			    Cores.TEXT_BLUE_UNDERLINED + Cores.ANSI_BLACK_BACKGROUND + "tasselii.dev@outlook.com.br" +
			    Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "     " + Cores.TEXT_CYAN + " ║");
			System.out.println("║  " + Cores.TEXT_BLUE_UNDERLINED + Cores.ANSI_BLACK_BACKGROUND +
			    "github.com/tasselii" + Cores.TEXT_WHITE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "                              " + Cores.TEXT_CYAN + " ║");
			System.out.println("╚════════════════════════════════════════════════════╝" + Cores.TEXT_RESET);

	}
	public static void keyPress() {
		 
		try {
 
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
 
		} catch (IOException e) {
 
			System.err.println("Ocorreu um erro ao tentar ler o teclado");
 
		}
	}
}

