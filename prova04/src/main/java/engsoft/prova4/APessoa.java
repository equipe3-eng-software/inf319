package engsoft.prova4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class APessoa {

    private ContratosDeTrabalho contratos;
    
    public APessoa(ContratosDeTrabalho contratos) {
        this.contratos = contratos;
    }
    
    public Set<ACompanhia> getEmpregos() {
        Set<ACompanhia> empregos = new HashSet<ACompanhia>();
        for (Iterator i = contratos.getEmpregadores(this).iterator(); i.hasNext(); ) {
            Contrato contrato = (Contrato) i.next();
            empregos.add(contrato.getEmpregador());
        }
        return empregos;
    }
    
    public double getSalarioTotal() {
        double salario = 0;
        for (Iterator i = contratos.getEmpregadores(this).iterator(); i.hasNext(); ) {
            Contrato contrato = (Contrato) i.next();
            salario += contrato.getSalario();
        }
        return salario;
    }
}
