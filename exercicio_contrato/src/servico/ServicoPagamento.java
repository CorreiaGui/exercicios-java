package servico;

public interface ServicoPagamento {
	
	double taxaPagemento(double quantia);
	
	double juros(double quantia, int meses);
}
