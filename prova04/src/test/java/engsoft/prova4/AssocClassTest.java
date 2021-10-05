package engsoft.prova4;

import junit.framework.TestCase;

public class AssocClassTest extends TestCase {
	ContratosDeTrabalho ct;
	ACompanhia ca, cb;
	APessoa a, b;

	public void testCompanhia() {
		ct = new ContratosDeTrabalho();
		ca = new ACompanhia(ct);
		cb = new ACompanhia(ct);
		a = new APessoa(ct);
		b = new APessoa(ct);
		ct.emprega(ca, a, 1000.00);
		ct.emprega(ca, b, 1000.00);
		ct.emprega(cb, a, 100.00);
		assertEquals(2000.00, ca.custoTotal());
		assertEquals(1100.00, a.getSalarioTotal());
	}
}
