package co.edu.unbosque.Taller_Rendimiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching 
public class TallerRendimientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerRendimientoApplication.class, args);
	}

}
