package servico;

import java.time.LocalDate;

import entidades.Contrato;
import entidades.Prestacao;

public class ContratoService {

	private ServicoPagamento servicoPagamento;

	public ContratoService(ServicoPagamento servicoPagamento) {
		this.servicoPagamento = servicoPagamento;
	}

	public void contractProcess(Contrato contrato, int meses) {

		double mediaParcelas = contrato.getValor() / meses;

		for (int i = 1; i <= meses; i++) {

			LocalDate dataVencimento = contrato.getData().plusMonths(i);

			double juros = servicoPagamento.juros(mediaParcelas, i);

			double taxa = servicoPagamento.taxaPagemento(mediaParcelas + juros);
			
			double valorDaParcela = mediaParcelas + taxa + juros;
			
			contrato.getPrestacoes().add(new Prestacao(dataVencimento, valorDaParcela));
		}
	}
}
