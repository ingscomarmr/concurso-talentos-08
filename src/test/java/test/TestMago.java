package test;

import static org.junit.Assert.assertEquals;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import concursantes.IAdivinador;
import concursantes.IPensador;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContex.xml" })
public class TestMago {
	private static Log logger = LogFactory.getLog("TestMago");
	@Autowired
	private IPensador voluntario;
	@Autowired
	private IAdivinador mago;

	@Test
	public void testMagoAdivinador() {
		logger.info("Inicio de la adivinacion");
		String pensamiento = "Hoy ganare la loteria jejejej, chisme no gane solo es un pensamiento.";
		voluntario.pensarEnAlgo(pensamiento);
		assertEquals(pensamiento, mago.getPensamientos());
		logger.info("Fin de Adivinacion");
	}
	
	@Test
	public void testMagoAdivinador2() {
		logger.info("Inicio de la adivinacion");
		String pensamiento = "Eres muy mal mago.";
		voluntario.pensarEnAlgo(pensamiento);
		assertEquals(pensamiento, mago.getPensamientos());
		logger.info("Fin de Adivinacion");
	}
	
}