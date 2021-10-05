package engsoft.prova4;

import junit.framework.TestCase;

public class AssocDiretaTest extends TestCase {

	public void testAD() {
	    Companhia c = new Companhia();
	    Pessoa a = new Pessoa();
	    a.emprega(c, 1000.00);
	    c.emprega(a, 1000.00);
	    assertEquals(1000.00, a.getSalario());
	    assertEquals(1000.00, c.custoTotal());
	}
}
