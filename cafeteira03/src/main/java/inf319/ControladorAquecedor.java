package inf319;

/** 
 * Interface genérica para o controlador de hardware do aquecedor de uma
 * cafeteira. O aquecedor pode ser ligado ou desligado. Ele também pode
 * informar se a jarra está presente e o seu estado.
 */
public interface ControladorAquecedor {
    public void ligaAquecedor();
    public void desligaAquecedor();
    public EstadoHardware estadoAquecedor();
}
