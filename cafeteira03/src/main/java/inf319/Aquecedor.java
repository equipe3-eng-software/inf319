package inf319;

/**
 * Classe abstrata que apresenta a interface de um aquecedor de uma
 * cafeteira. O aquecedor informa se está pronto para começar a fazer
 * café e é informado que a confecção do café terminou.
 */
public abstract class Aquecedor {
    
    private ControladorAquecedor controlador;
    private ClienteAquecedor     cliente;

    public Aquecedor(ControladorAquecedor oControlador, 
		     ClienteAquecedor oCliente) {
	controlador = oControlador;
        cliente = oCliente;
    }

    // Estimulos externos
    public abstract void fazerCafe();
    public abstract void cafeFeito();
    public abstract boolean checaPronto();

    // Interface para as subclasses
    protected ControladorAquecedor pegaControlador() {
        return controlador;
    }

    protected ClienteAquecedor pegaCliente() {
        return cliente;
    }
}
