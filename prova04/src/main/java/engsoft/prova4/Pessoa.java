package engsoft.prova4;

public class Pessoa {

    private Companhia emprego;
    private double salario;

    public Pessoa() {
        demite();
    }
    
    public Companhia getEmprego() {
        return emprego;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setEmprego(Companhia emprego) {
	this.emprego = emprego;
    }
    
    public void setSalario(double salario) {
	this.salario = salario;
    }

   public void emprega(Companhia novoEmprego, double novoSalario) {
        emprego = novoEmprego;
        salario = novoSalario;
    }
    
    public void demite() {
        emprego = null;
        salario = 0;
    }
}
