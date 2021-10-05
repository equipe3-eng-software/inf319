package inf319;

/**
 * Esta classe implementa o controle da IHC da cafeteira CafeBemBrasileiro.
 */
public class CafeBB_IHC extends IHC {
    
    private EstadoIHC estado;

    public CafeBB_IHC(ControladorIHC oControlador, ClienteIHC oCliente) {
        super(oControlador, oCliente);
        estado = EstadoIHC.naoFazendo;
        pegaControlador().indicaPronto();
    }

    
    // Estímulos externos
    public void cafeFeito() {
        if (estado.equals(EstadoIHC.verificandoProntidao))
            estado = EstadoIHC.naoFazendo;
        else if (estado.equals(EstadoIHC.fazendo)) {
            estado = EstadoIHC.cafeFeito;
            pegaControlador().indicaFim();
        }
    }
    
    public void cicloCompleto() {
        if (estado.equals(EstadoIHC.verificandoProntidao))
            estado = EstadoIHC.naoFazendo;
        else if (estado.equals(EstadoIHC.fazendo))
            estado = EstadoIHC.naoFazendo;
        else if (estado.equals(EstadoIHC.cafeFeito)) {
            estado = EstadoIHC.naoFazendo;
            pegaControlador().indicaPronto();
        }
    }
    

    // Eventos da máquina de estados
    public void inicio() {
        if (estado.equals(EstadoIHC.naoFazendo)) {
            estado = EstadoIHC.verificandoProntidao;
            verificaPronto();
        }
    }

    public void pronto() {
        if (estado.equals(EstadoIHC.verificandoProntidao)) {
            estado = EstadoIHC.fazendo;
            pegaCliente().fazerCafe();
        }
    }

    public void naoPronto() {
        if (estado.equals(EstadoIHC.verificandoProntidao)) {
            estado = EstadoIHC.naoFazendo;
        }
    }

    // Método auxiliar
    private void verificaPronto() {
        if (pegaCliente().checaPronto()) {
            pronto();
        } else {
            naoPronto();
        }
    }
    
    
    // Ligação ao programa principal
    public void verifica() {
        if ((estado.equals(EstadoIHC.naoFazendo))
                && (pegaControlador().checaInicio())) {
            inicio();
        }
    }
}

class EstadoIHC {
    
    // Estados da máquina de estados da IHC
    public static final EstadoIHC naoFazendo=           new EstadoIHC(0); 
    public static final EstadoIHC fazendo=              new EstadoIHC(1); 
    public static final EstadoIHC verificandoProntidao= new EstadoIHC(2); 
    public static final EstadoIHC cafeFeito=            new EstadoIHC(3);
    
    private int id;

    private EstadoIHC(int id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        return (obj != null) && (obj instanceof EstadoIHC)
                && ((EstadoIHC) obj).id == id;
    }
}
