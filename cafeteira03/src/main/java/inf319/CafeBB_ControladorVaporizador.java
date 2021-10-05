package inf319;

/**
 * Esta classe implementa a interface para o hardware do vaporizador da
 * cafeteira CafeBemBrasileiro.
 */
public class CafeBB_ControladorVaporizador implements ControladorVaporizador {
    
    private Hardware cafeteiraCafeBB;

    public CafeBB_ControladorVaporizador(Hardware oHardware) {
        cafeteiraCafeBB = oHardware;
        cafeteiraCafeBB.atuValvulaPressao(EstadoHardware.valvulaFechada);
    }
    
    public void inicia() {
    	    cafeteiraCafeBB.atuEstadoElementoEbulidor(EstadoHardware.ebulidorDesligado);
    		cafeteiraCafeBB.atuValvulaPressao(EstadoHardware.valvulaFechada);
    }

    public void jogaAgua() {
        cafeteiraCafeBB.atuEstadoElementoEbulidor(EstadoHardware.ebulidorLigado);
        cafeteiraCafeBB.atuValvulaPressao(EstadoHardware.valvulaFechada);
    }

    public void naoJogaAgua() {
        cafeteiraCafeBB.atuEstadoElementoEbulidor(
                EstadoHardware.ebulidorDesligado);
        cafeteiraCafeBB.atuValvulaPressao(EstadoHardware.valvulaAberta);
    }

    public boolean temAgua() {
        return cafeteiraCafeBB.leEstadoEbulidor().equals(
                EstadoHardware.ebulidorNaoVazio);
    }
}
