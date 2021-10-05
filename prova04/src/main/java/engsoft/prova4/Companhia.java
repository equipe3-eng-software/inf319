package engsoft.prova4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Companhia {
    
    private Set<Pessoa> empregados;
    
    public Companhia() {
        empregados = new HashSet<Pessoa>();
    }
    
    public void emprega(Pessoa empregado, double salario) {
        empregado.emprega(this, salario);
        empregados.add(empregado);
    }
    
    public void demite(Pessoa empregado) {
        empregado.demite();
        empregados.remove(empregado);
    }

    public double custoTotal() {
        double custo = 0;
        for (Iterator<Pessoa> i = empregados.iterator(); i.hasNext(); ) {
            Pessoa empregado = i.next();
            custo += empregado.getSalario();
        }
        return custo;
    }
}
