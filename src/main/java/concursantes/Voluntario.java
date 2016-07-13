package concursantes;

/**
 * OBJETO QUE SE ESTARA MONITOREANDO POR EL ASPECT
 * SE MONITOREA EL METODO pensarEnAlgo
 * */
import org.springframework.stereotype.Component;

@Component
public class Voluntario implements IPensador {
	private String pensamientos;

	//funcion que estara siendo monitoreada por el aspect de aop
	public void pensarEnAlgo(String pensamientos) {
		this.pensamientos = pensamientos;
		System.out.println("Voluntario:Ya pense en algo");
	}

	public String getPensamientos() {
		return this.pensamientos;
	}
}
