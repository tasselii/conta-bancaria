package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
     
		        Scanner scan = new Scanner(System.in);
				
				int opcao;
						
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
					case 1 -> System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
					case 2 -> System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
					case 3 -> System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
					case 4 -> System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
					case 5 -> System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
					case 6 -> System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
					case 7 -> System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
					case 8 -> System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
					default -> System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
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
}
