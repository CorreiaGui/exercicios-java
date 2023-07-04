package model.service;

import java.time.Duration;

import model.entidade.AluguelCarro;
import model.entidade.Fatura;

public class AluguelCarroService {

	private double precoPorHora;

	private double precoPorDia;

	private TaxaServico taxaServico;

	public AluguelCarroService(double precoPorHora, double precoPorDia, TaxaServico taxaServico) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.taxaServico = taxaServico;
	}
	
	

	public void geradorDeFatura(AluguelCarro aluguelCarro) {

		double minutos = Duration.between(aluguelCarro.getDataEntrada(), aluguelCarro.getDataRetirada()).toMinutes();
		double horas = minutos / 60;

		double pagamentoBasico;

		if (horas <= 12) {

			pagamentoBasico = precoPorHora * Math.ceil(horas);

		} else {
			pagamentoBasico = precoPorDia * Math.ceil(horas / 24);
		}

		double taxa = taxaServico.taxaServico(pagamentoBasico);

		aluguelCarro.setFatura(new Fatura(pagamentoBasico, taxa));

	}
}
