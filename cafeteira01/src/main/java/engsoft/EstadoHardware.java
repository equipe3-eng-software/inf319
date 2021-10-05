package engsoft;

/**
 * Classe que engloba os estados dos componentes de hardware.
 */
public class EstadoHardware {
    
    public static final EstadoHardware ehJarraNaoVazia =          new EstadoHardware(0);
    public static final EstadoHardware ehJarraVazia =             new EstadoHardware(1);
    public static final EstadoHardware ehPlacaVazia =             new EstadoHardware(2);
    public static final EstadoHardware ehEbulidorVazio =          new EstadoHardware(3);
    public static final EstadoHardware ehEbulidorNaoVazio =       new EstadoHardware(4);
    public static final EstadoHardware ehInterruptorPressionado = new EstadoHardware(5);
    public static final EstadoHardware ehInterruptorSolto =       new EstadoHardware(6);
    public static final EstadoHardware ehEbulidorLigado =         new EstadoHardware(7);
    public static final EstadoHardware ehEbulidorDesligado =      new EstadoHardware(8);
    public static final EstadoHardware ehAquecedorLigado =        new EstadoHardware(9);
    public static final EstadoHardware ehAquecedorDesligado =     new EstadoHardware(10);
    public static final EstadoHardware ehIndicadoraLigada =       new EstadoHardware(11);
    public static final EstadoHardware ehIndicadoraDesligada =    new EstadoHardware(12);
    public static final EstadoHardware ehValvulaAberta =          new EstadoHardware(13);
    public static final EstadoHardware ehValvulaFechada =         new EstadoHardware(14);

    private int id;

    private EstadoHardware(int id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        return (obj != null) && (obj instanceof EstadoHardware)
                && ((EstadoHardware) obj).id == id;
    }
}
