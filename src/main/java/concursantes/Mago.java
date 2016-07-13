package concursantes;

/**
 * IMPLEMENTAR AOP CON PARAMETROS
 * SE LEEN LOS PARAMETROS DEL METODO QUE SE ESTA MONETOREANDO INCLUSO ANTES DE QUE SE EJECUTE
 * 
 * */
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Mago implements IAdivinador {
	private String pensamientos;

	@Pointcut("execution(* concursantes.IPensador.pensarEnAlgo(String)) && args(pensamientos)") //se le indica en el pointcut que metodo es el que monitorea
	public void pensar(String pensamientos) {
	}
	
	@Before("pensar(pensamientos)") //se ejecutara antes de la llamada al metodo
	public void interceptarPensamientos(String pensamientos) {
		System.out.println("Mago:Magia....");
		System.out.println("Mago:Estos son los pensamientos del voluntario: " + pensamientos);
		this.pensamientos = pensamientos;
	}

	@After("pensar(pensamientos)") //se ejecuta despues de la ejecusion el metodo
	public void terminodeAdivinar(String pensamientos){
		System.out.println("Mago:Ese fue el pensamiento de la persona");
	}
	
	public String getPensamientos() {
		return this.pensamientos;
	}
}
