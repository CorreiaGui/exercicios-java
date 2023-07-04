package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Prestacao;
import servico.ContratoService;
import servico.PaypalService;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.err.println("Entre os dados do contrato: ");
		System.out.println(" ");
		System.out.print("Numero: ");
		Integer numero = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(sc.next(), fmt);
		
		System.out.print("Valor do contrato: ");
		Double valor = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valor);
		
		System.out.print("Entre com o numero de parcelas: ");
		Integer parcelas = sc.nextInt();
		
		System.out.println("Parcelas: ");
		
		ContratoService contratoService = new ContratoService(new PaypalService());
		
		contratoService.contractProcess(contrato, 3);
		
		for(Prestacao prestacao : contrato.getPrestacoes()) {
			System.out.println(prestacao);
		}
		
		sc.close();
	}
}
