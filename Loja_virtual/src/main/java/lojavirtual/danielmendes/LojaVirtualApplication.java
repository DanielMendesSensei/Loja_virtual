package lojavirtual.danielmendes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages = "nome_do_projeto.model") assim você consegue forçar o programa a chamar
//as classes criadas, normalmente precisa em versões diferentes do SpringBoot
public class LojaVirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualApplication.class, args);
	}

}
