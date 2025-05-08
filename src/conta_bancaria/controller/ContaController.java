package conta_bancaria.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;
import conta_bancaria.util.Cores;

public class ContaController implements ContaRepository{

	// Criar a Collection ArrayList
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	// Variável para controlar os números das contas
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent())
			conta.get().visualizar();
		else
			System.out.printf("\nA Conta %d não foi encontrado", numero);
	}

	@Override
	public void listarTodas() {
		listaContas.forEach(Conta::visualizar);
	}
	
	@Override
	public void listarPorTitular(String titular) {
	
		List<Conta> listaTitulares = listaContas.stream()
				.filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());

				if(listaTitulares.isEmpty())
				System.out.printf("\nNenhuma conta foi encontrada com base no critério: %s", titular);

				listaTitulares.forEach(c -> c.visualizar());
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println(Cores.TEXT_GREEN+"\nA Conta foi criada com sucesso! ✅"); 
	}

	@Override
	public void atualizar(Conta conta) {
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println(Cores.TEXT_RED+"\nDados Anteriores:");
			buscaConta.get().visualizar();
			System.out.println(Cores.TEXT_GREEN+"\nDados Atualizados:");
			procurarPorNumero(buscaConta.get().getNumero());
			System.out.printf(Cores.TEXT_GREEN+"\nA Conta número %d foi atualizada com sucesso!", conta.getNumero());
		}
	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			if(listaContas.remove(conta.get()) == true) 
				System.out.printf(Cores.TEXT_GREEN+"\nA Conta numero %d foi excluída com sucesso!", numero); 
		}else
				System.out.printf(Cores.TEXT_RED+"\nA Conta %d não foi encontrado", numero);
	}
	

	@Override
	public void sacar(int numero, float valor) {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			if(conta.get().sacar(valor) == true) {
				System.out.printf(Cores.TEXT_GREEN+"\nO Saque no valor de %s\nfoi efetuado com sucesso na conta número %d",nfMoeda.format(valor), numero);
			}
		}else 
			System.out.printf(Cores.TEXT_RED+"\nA Conta %d não foi encontrado", numero);
	}

	@Override
	public void depositar(int numero, float valor) {
		
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if(conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.printf(Cores.TEXT_GREEN+"\nO Depósito no valor de R$ %.2f\nfoi efetuado com sucesso na conta número %d",valor, numero);
		}else
			System.out.printf(Cores.TEXT_RED+"\nA Conta %d não foi encontrado", numero);
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem.isPresent() && contaDestino.isPresent()) {
			if(contaOrigem.get().sacar(valor) == true) {
			contaDestino.get().depositar(valor);
			System.out.printf(Cores.TEXT_GREEN+"\nA tranferência no valor de R$ %.2f da conta \nnúmero %d para Conta número %d foi efetuada com sucesso!",valor, numeroOrigem, numeroDestino);
			}
		}else
			System.out.printf(Cores.TEXT_RED+"\nA Conta %d não foi encontrado", numero);
		
	}
	
	// Métodos Auxiliares
	
	public int gerarNumero() {
		return ++ numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {
	    return listaContas.stream()
	                      .filter(conta -> conta.getNumero() == numero)
	                      .findFirst();
	}

}
