package concursantes;

import java.util.Calendar;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audiencia {
	public void sentarse() {
		System.out.println("El show est� por comenzar, favor de tomar asiento...");
	}

	public void apagarCelulares() {
		System.out.println("Favor de apagar celulares...");
	}

	public void aplaudir() {
		System.out.println("El show ha termiado, clap clap clap");
	}

	public void devolucion() {
		System.out.println("El show fue terrible, se devolver�n las entradas");
	}
	
	@Pointcut("execution(* concursantes.IConcursante.ejecutar(..))")
	public void ejecutarShow(){				
	}
	
	@Around("ejecutarShow()")
	public void monitorearShow(ProceedingJoinPoint point){
		try{
			
			//parte del before
			System.out.println("El show va iniciar por favor guardar silencio y apagar telefonos");
			java.util.Date fecha = new Date();
			System.out.println("Hora de inicio:" + fecha.toString());
			
			//metodo que se ejecuta
			point.proceed();
			
			//parte del after
			fecha = new Date();			
			System.out.println("El show termino " + fecha.toString());
			
		}catch(Throwable e){
			System.err.println("El show fue terrible, pedir devolucion de dinero:" + e.getMessage());
		}
	}
}
