package inf319;

/**
 * Esta classe implementa a interface ControladorAquecedor
 * para o hardware específico da cafeteira CafeBemBrasileiro.
 */ 
public class CafeBB_ControladorAquecedor implements ControladorAquecedor {
    
    private Hardware cafeteiraCafeBB;

    public CafeBB_ControladorAquecedor(Hardware oHardware) {
        cafeteiraCafeBB = oHardware;
    }

    public void ligaAquecedor() {
        cafeteiraCafeBB.atuElementoAquecedor(EstadoHardware.aquecedorLigado);
    }

    public void desligaAquecedor() {
        cafeteiraCafeBB.atuElementoAquecedor(EstadoHardware.aquecedorDesligado);
    }

    public EstadoHardware estadoAquecedor() {
        return cafeteiraCafeBB.leEstadoAquecedor();
    }
}
