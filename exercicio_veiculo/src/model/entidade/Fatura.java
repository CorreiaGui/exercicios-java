package model.entidade;

public class Fatura {
	
	private double pagamentoBasico;
	
	private double taxa;
	
	public Fatura() {
		
	}
	
	public Fatura(double pagamentoBasio, double taxa) {
		this.pagamentoBasico = pagamentoBasio;
		this.taxa = taxa;
	}

	public double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public double getTotalPagamento() {
		return pagamentoBasico + taxa;
	}
}
