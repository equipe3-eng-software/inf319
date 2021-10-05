package inf319;

/**
 * Esta classe implementa a cafeteira CafeBemBrasileiro.
 */ 

public class CafeBB_Cafeteira {
    public static void main(String[] args) {
        // Cria os componentes da cafeteira
        Hardware oHardware = new Hardware();
        Cafeteira aCafeteira = new Cafeteira();

        CafeBB_ControladorAquecedor controladorAquecedor =
            new CafeBB_ControladorAquecedor(oHardware);
        CafeBB_ControladorVaporizador controladorVaporizador =
            new CafeBB_ControladorVaporizador(oHardware);
        CafeBB_ControladorIHC controladorIHC =
            new CafeBB_ControladorIHC(oHardware);

        CafeBB_Aquecedor aquecedor = 
            new CafeBB_Aquecedor(controladorAquecedor, aCafeteira);
        CafeBB_Vaporizador vaporizador =
            new CafeBB_Vaporizador(controladorVaporizador, aCafeteira);
        CafeBB_IHC ihc = new CafeBB_IHC(controladorIHC, aCafeteira);

        // Liga os componentes ao modulo de controle
        aCafeteira.ajustaIHC(ihc);
        aCafeteira.ajustaVaporizador(vaporizador);
        aCafeteira.ajustaAquecedor(aquecedor);

        
        //////////////////////////////////////////////////////////////////
        // Executa a cafeteira

        // Inicia o hardware
        oHardware.iniciar();

        // Executa o software de controle
        while (true) {
        	    try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}       	    
            ihc.verifica();
            vaporizador.verifica();
            aquecedor.verifica();
        }
    }
}
