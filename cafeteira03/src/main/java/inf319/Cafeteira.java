package inf319;

/**
 * Esta classe é o centro da comunicação entre o aquecedor, vaporizador e
 * IHC. Ela implementa todas as três interfaces de clientes e direciona
 * as mensagens entre estas abstrações.
 */
public class Cafeteira 
        implements ClienteVaporizador, ClienteAquecedor, ClienteIHC {
    
    private IHC         suaIHC;
    private Aquecedor   seuAquecedor;
    private Vaporizador seuVaporizador;

    public Cafeteira() {
        suaIHC = null;
        seuAquecedor = null;
        seuVaporizador = null;
    }

    
    // ClienteIHC
    public boolean checaPronto() {
        return seuAquecedor.checaPronto() && seuVaporizador.checaPronto();
    }

    public void fazerCafe() {
        seuAquecedor.fazerCafe();
        seuVaporizador.fazerCafe();
    }
    
    
    // ClienteVaporizador
    public void cafeFeito() {
        suaIHC.cafeFeito();
        seuAquecedor.cafeFeito();
    } 


    // ClienteAquecedor
    public void jarra() {
        seuVaporizador.jarra();
    }

    public void semJarra() {
        seuVaporizador.semJarra();
    }

    public void cicloCompleto() {
        suaIHC.cicloCompleto();
    }

    
    // Métodos para 'montar' a cafeteira. 
    public void ajustaIHC(IHC aIHC) {
        suaIHC = aIHC;
    }

    public void ajustaAquecedor(Aquecedor oAquecedor) {
        seuAquecedor = oAquecedor;
    }

    public void ajustaVaporizador(Vaporizador oVaporizador) {
        seuVaporizador = oVaporizador;
    }
}
