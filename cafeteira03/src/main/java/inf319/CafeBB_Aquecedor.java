package inf319;

/**
 * Esta classe implementa o controle do sistema do aquecedor
 * da cafeteira CafeBemBrasileiro.
 */
public class CafeBB_Aquecedor extends Aquecedor {

    private EstadoAquecedor estado;
    
    public CafeBB_Aquecedor(ControladorAquecedor oControlador,
                            ClienteAquecedor oCliente) {
        super(oControlador, oCliente);
        estado = EstadoAquecedor.naoFazendo;
        pegaControlador().desligaAquecedor();
    }

    
    // Estímulos externos
    public void fazerCafe() {
        if (estado.equals(EstadoAquecedor.naoFazendo)) {
            estado = EstadoAquecedor.fazendoJarVazia;
        }
    }

    public void cafeFeito() {
        if (estado.equals(EstadoAquecedor.fazendoJarVazia)) {
            estado = EstadoAquecedor.naoFazendo;
            pegaCliente().cicloCompleto();
        } else if (estado.equals(EstadoAquecedor.fazendoAquecendo)) {
            estado = EstadoAquecedor.cafeFeito;
        } else if (estado.equals(EstadoAquecedor.jarVaziaRemovida)) {
            estado = EstadoAquecedor.naoFazendo;
            pegaCliente().cicloCompleto();
        } else if (estado.equals(EstadoAquecedor.jarCheiaRemovida)) {
            estado = EstadoAquecedor.feitoJarRemovida;
        }
    }

    public boolean checaPronto() {
        return pegaControlador().estadoAquecedor().equals(EstadoHardware.jarraVazia);
    }
    

    // Eventos da máquina de estados
    public void jarraVazia() {
        if (estado.equals(EstadoAquecedor.fazendoAquecendo)) {
            estado = EstadoAquecedor.fazendoJarVazia;
            pegaControlador().desligaAquecedor();
        } else if (estado.equals(EstadoAquecedor.jarVaziaRemovida)
                || estado.equals(EstadoAquecedor.jarCheiaRemovida)) {
            estado = EstadoAquecedor.fazendoJarVazia;
            pegaCliente().jarra();
        } else if (estado.equals(EstadoAquecedor.cafeFeito)) {
            estado = EstadoAquecedor.naoFazendo;
            pegaControlador().desligaAquecedor();
            pegaCliente().cicloCompleto();
        } else if (estado.equals(EstadoAquecedor.feitoJarRemovida)) {
            estado = EstadoAquecedor.naoFazendo;
            pegaCliente().cicloCompleto();
        }
    }

    public void jarraNaoVazia() {
        if (estado.equals(EstadoAquecedor.fazendoJarVazia)) {
            estado = EstadoAquecedor.fazendoAquecendo;
            pegaControlador().ligaAquecedor();
        } else if (estado.equals(EstadoAquecedor.jarVaziaRemovida)
                || estado.equals(EstadoAquecedor.jarCheiaRemovida)) {
            estado = EstadoAquecedor.fazendoAquecendo;
            pegaControlador().ligaAquecedor();
            pegaCliente().jarra();
        } else if (estado.equals(EstadoAquecedor.feitoJarRemovida)) {
            estado = EstadoAquecedor.cafeFeito;
            pegaControlador().ligaAquecedor();
        }
    }

    public void placaVazia() {
        if (estado.equals(EstadoAquecedor.fazendoJarVazia)) {
            estado = EstadoAquecedor.jarVaziaRemovida;
            pegaCliente().semJarra();
        } else if (estado.equals(EstadoAquecedor.fazendoAquecendo)) {
            estado = EstadoAquecedor.jarCheiaRemovida;
            pegaCliente().semJarra();
            pegaControlador().desligaAquecedor();
        } else if (estado.equals(EstadoAquecedor.cafeFeito)) {
            estado = EstadoAquecedor.feitoJarRemovida;
            pegaControlador().desligaAquecedor();
        }
    }
    

    // Ligação ao programa principal
    public void verifica() {
        if (pegaControlador().estadoAquecedor().equals(EstadoHardware.placaVazia)) {
            placaVazia();
        } else if (pegaControlador().estadoAquecedor().equals(
                EstadoHardware.jarraVazia)) {
            jarraVazia();
        } else if (pegaControlador().estadoAquecedor().equals(
                EstadoHardware.jarraNaoVazia)) {
            jarraNaoVazia();
        }
    }
}

class EstadoAquecedor {
    
    // Estados da máquina de estados do aquecedor
    public static final EstadoAquecedor naoFazendo=      new EstadoAquecedor(0); 
    public static final EstadoAquecedor fazendoJarVazia= new EstadoAquecedor(1); 
    public static final EstadoAquecedor fazendoAquecendo=new EstadoAquecedor(2); 
    public static final EstadoAquecedor jarVaziaRemovida=new EstadoAquecedor(3);
    public static final EstadoAquecedor jarCheiaRemovida=new EstadoAquecedor(4); 
    public static final EstadoAquecedor cafeFeito=       new EstadoAquecedor(5); 
    public static final EstadoAquecedor feitoJarRemovida=new EstadoAquecedor(6); 
    
    private int id;
    
    private EstadoAquecedor(int id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        return (obj != null) && (obj instanceof EstadoAquecedor)
                && ((EstadoAquecedor) obj).id == id;
    }
}
