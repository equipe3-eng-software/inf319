package engsoft.prova4;

import java.util.Iterator;

public class ACompanhia {
    
    private ContratosDeTrabalho contratos;
    
    public ACompanhia(ContratosDeTrabalho contratos) {
        this.contratos = contratos;
    }
    
    public void emprega(APessoa empregado, double salario) {
        contratos.emprega(this, empregado, salario);
    }
    
    public void demite(APessoa empregado) {
        contratos.demite(this, empregado);
    }

    public double custoTotal() {
        double custo = 0;
        for (Iterator i = contratos.getEmpregados(this).iterator(); i.hasNext(); ) {
            Contrato contrato = (Contrato) i.next();
            custo += contrato.getSalario();
        }
        return custo;
    }
}
