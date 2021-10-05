package inf319;

/** 
 * Interface para o dispositivo que vaporiza água e a joga sobre o pó
 * de café em uma cafeteira. Um vaporizador pode ser instruído a fazer
 * duas coisas: jogar água ou não jogar água. Um vaporizador também pode
 * informar se existe água para ser vaporizada.
 */
public interface ControladorVaporizador {
	public void inicia();
    public void jogaAgua();
    public void naoJogaAgua();
    public boolean temAgua();
}
