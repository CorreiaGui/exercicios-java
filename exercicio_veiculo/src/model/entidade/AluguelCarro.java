package model.entidade;

import java.time.LocalDateTime;

public class AluguelCarro {
	
	private Carro carro;
	
	private LocalDateTime dataEntrada;
	
	private LocalDateTime dataRetirada;
	
	private Fatura fatura;

	public AluguelCarro(Carro carro, LocalDateTime dataEntrada, LocalDateTime dataRetirada) {
		this.carro = carro;
		this.dataEntrada = dataEntrada;
		this.dataRetirada = dataRetirada;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDateTime dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
}
