package engsoft.prova4;

public class Contrato {

    private ACompanhia empregador;
    private APessoa empregado;
    private double salario;
    
    public Contrato(ACompanhia empregador, APessoa empregado, double salario) {
        this.empregador = empregador;
        this.empregado = empregado;
        this.salario = salario;
    }
    
    public ACompanhia getEmpregador() {
        return empregador;
    }
    
    public APessoa getEmpregado() {
        return empregado;
    }

    public double getSalario() {
        return salario;
    }

}
