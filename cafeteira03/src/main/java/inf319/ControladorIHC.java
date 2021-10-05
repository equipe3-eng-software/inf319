package inf319;

/**
 * Interface para todos os controladores de hardware da IHC. O hardware
 * da IHC pode ser comandado para mostrar ao usuário que o café está
 * pronto ou que a cafeteira esta pronta para fazer café. Ele também pode
 * descobrir se o usuário iniciou um ciclo de confecção de café.
 */
public interface ControladorIHC {
    public void indicaFim();
    public void indicaPronto();
    public boolean checaInicio();
}
