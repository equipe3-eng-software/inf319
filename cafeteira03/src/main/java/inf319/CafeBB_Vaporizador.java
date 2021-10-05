package inf319;

/**
 * Esta classe implementa o modelo de controle do vaporizador
 * da cafeteira CafeBemBrasileiro.
 */
public class CafeBB_Vaporizador extends Vaporizador {
    
    private EstadoVaporizador estado;

    public CafeBB_Vaporizador(ControladorVaporizador oControlador, 
                              ClienteVaporizador oCliente) {
        super(oControlador, oCliente);
        estado = EstadoVaporizador.naoFazendo;
        pegaControlador().inicia();
    }

    
    // Estímulos externos
    public boolean checaPronto() {
        return pegaControlador().temAgua();
    }

    public void jarra() {
        if (estado.equals(EstadoVaporizador.fazendoJarRemovida)) {
            estado = EstadoVaporizador.vaporizando;
            pegaControlador().jogaAgua();
        }
    }

    public void semJarra() {
        if (estado.equals(EstadoVaporizador.vaporizando)) {
            estado = EstadoVaporizador.fazendoJarRemovida;
            pegaControlador().naoJogaAgua();
        }
    }

    public void fazerCafe() {
        if (estado.equals(EstadoVaporizador.naoFazendo)) {
            estado = EstadoVaporizador.vaporizando;
            pegaControlador().jogaAgua();
        }
    }
    

    // Eventos da máquina de estados
    public void cafeFeito() {
        if (estado.equals(EstadoVaporizador.vaporizando)) {
            estado = EstadoVaporizador.naoFazendo;
            pegaControlador().naoJogaAgua();
            pegaCliente().cafeFeito();
        } else if (estado.equals(EstadoVaporizador.fazendoJarRemovida)) {
            estado = EstadoVaporizador.naoFazendo;
            pegaCliente().cafeFeito();
        } 
    }

    
    // Ligação ao programa principal
    public void verifica() {
    	if (!pegaControlador().temAgua()) {
            cafeFeito();
        }
    }
}

class EstadoVaporizador {
 
    // Estados da máquina de estados do vaporizador
    public static final EstadoVaporizador naoFazendo= 
        new EstadoVaporizador(0);
    public static final EstadoVaporizador vaporizando=
        new EstadoVaporizador(1);
    public static final EstadoVaporizador fazendoJarRemovida= 
        new EstadoVaporizador(2);
    
    private int id;
    
    private EstadoVaporizador(int id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        return (obj != null) && (obj instanceof EstadoVaporizador)
                && ((EstadoVaporizador) obj).id == id;
    }
}
