package inf319;

/**
 * Esta classe implementa a interface ControladorIHC para
 * o hardware da cafeteira CafeBemBrasileiro.
 */
public class CafeBB_ControladorIHC implements ControladorIHC {
    
    private Hardware cafeteiraCafeBB;

    public CafeBB_ControladorIHC(Hardware oHardware) {
        cafeteiraCafeBB = oHardware;
    }

    public void indicaFim() {
        cafeteiraCafeBB.atuLuzIndicadora(EstadoHardware.indicadoraLigada);
    }

    public void indicaPronto() {
        cafeteiraCafeBB.atuLuzIndicadora(EstadoHardware.indicadoraDesligada);
    }

    public boolean checaInicio() {
        return cafeteiraCafeBB.leEstadoInterruptor().equals(
                EstadoHardware.interruptorPressionado);
    }
}
