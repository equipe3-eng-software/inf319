package engsoft.prova4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ContratosDeTrabalho {

	private Map<APessoa, HashSet<Contrato>> contratosEmpregados;
	private Map<ACompanhia, HashSet<Contrato>> contratosEmpregadores;

	public ContratosDeTrabalho() {
		contratosEmpregados = new HashMap<APessoa, HashSet<Contrato>>();
		contratosEmpregadores = new HashMap<ACompanhia, HashSet<Contrato>>();
	}

	public Set<Contrato> getEmpregadores(APessoa empregado) {
		HashSet<Contrato> empregadores = contratosEmpregados.get(empregado);
		if (empregadores == null) {
			empregadores = new HashSet<Contrato>();
			contratosEmpregados.put(empregado, empregadores);
		}
		return empregadores;
	}

	public Set<Contrato> getEmpregados(ACompanhia empregador) {
		HashSet<Contrato> empregados = contratosEmpregadores.get(empregador);
		if (empregados == null) {
			empregados = new HashSet<Contrato>();
			contratosEmpregadores.put(empregador, empregados);
		}
		return empregados;
	}

	public void emprega(ACompanhia empregador, APessoa empregado, double salario) {
		Contrato contrato = new Contrato(empregador, empregado, salario);
		Set<Contrato> empregadores = getEmpregadores(empregado);
		empregadores.add(contrato);
		Set<Contrato> empregados = getEmpregados(empregador);
		empregados.add(contrato);
	}

	public void demite(ACompanhia empregador, APessoa empregado) {
		Set<Contrato> empregadores = getEmpregadores(empregado);
		Set<Contrato> empregados = getEmpregados(empregador);
		Contrato contrato = null;
		for (Iterator<Contrato> i = empregadores.iterator(); i.hasNext() && contrato == null;) {
			Contrato c = i.next();
			if (empregador.equals(c.getEmpregador())) {
				contrato = c;
			}
		}
		if (contrato != null) {
			empregadores.remove(contrato);
			empregados.remove(contrato);
		}
	}

	public double custoTotal(ACompanhia empregador) {
		double custoTotal = 0.0;
		return custoTotal;
	}

	public double salarioTotal(APessoa empregado) {
		return empregado.getSalarioTotal();
	}
}
