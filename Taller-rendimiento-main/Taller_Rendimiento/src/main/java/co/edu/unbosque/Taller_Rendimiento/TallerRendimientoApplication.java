package co.edu.unbosque.Taller_Rendimiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching 
@OpenAPIDefinition(info = @Info(title = "Taller Rendimiento API", version = "1.0", description = "API para gestionar el rendimiento de pedidos"))
public class TallerRendimientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerRendimientoApplication.class, args);
	}

}
