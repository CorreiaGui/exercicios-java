package aplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entidade.AluguelCarro;
import model.entidade.Carro;
import model.service.AluguelCarroService;
import model.service.TaxaServicoBrasil;

public class Aplication {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm");
		
		System.out.println("Entre com os dados do aluguel: ");
		System.out.println();
		
		System.out.print("Modelo do carro: ");
		String modeloCarro = sc.next();
		
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime dataRetirada = LocalDateTime.parse(sc.next(), fmt);
		
		System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime dataRetorno = LocalDateTime.parse(sc.next(), fmt);
		
		AluguelCarro alugaCarro = new AluguelCarro(new Carro(modeloCarro), dataRetirada, dataRetorno);
		
		System.out.print("Entre com o preço por hora: ");
		double precoHora = sc.nextDouble();
		
		System.out.print("Entre com o preço por dia: ");
		double precoDia = sc.nextDouble();
		
		AluguelCarroService aluguelService =  new AluguelCarroService(precoHora, precoDia, new TaxaServicoBrasil());
		
		aluguelService.geradorDeFatura(alugaCarro);
		
		System.out.print("FATURA: ");
		System.out.println();
		System.out.println("Pagamento basico: " + alugaCarro.getFatura().getPagamentoBasico());
		System.out.println("Imposto: " + alugaCarro.getFatura().getTaxa());
		System.out.println("Pagamento total: " + alugaCarro.getFatura().getTotalPagamento());
		
		sc.close();
	}
}
