package engsoft;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

public class TestHardware {
	
	private static Hardware h;
	
	
	@BeforeClass
	public static void setUpHardware() {
		h = new Hardware(false);
		h.iniciar();
	}

    @Test
    public void testHardware() {

    	testHardwareInitialState();
    	
    	h.atuEstadoElementoEbulidor(EstadoHardware.ehEbulidorLigado);

}
    
    private void testHardwareInitialState() {
    	// Verify the hardware initial state
    	
        assertEquals(EstadoHardware.ehJarraVazia,h.leEstadoAquecedor());
        assertEquals(EstadoHardware.ehEbulidorVazio,h.leEstadoEbulidor());
        assertEquals(EstadoHardware.ehAquecedorDesligado,h.leEstadoElementoAquecedor());
        assertEquals(EstadoHardware.ehEbulidorDesligado,h.leEstadoElementoEbulidor());
        assertEquals(EstadoHardware.ehInterruptorSolto,h.leEstadoInterruptor());
        assertEquals(EstadoHardware.ehIndicadoraLigada,h.leEstadoLuzIndicadora());
        assertEquals(EstadoHardware.ehValvulaFechada,h.leEstadoValvulaPressao());

        assertEquals(0, h.pegaNivelDeAgua());
        assertEquals(0, h.pegaNivelDeCafe());
    	
    }
    
    @AfterClass
    public static void tearDownHardware() {
    	h = null;
    }

}
