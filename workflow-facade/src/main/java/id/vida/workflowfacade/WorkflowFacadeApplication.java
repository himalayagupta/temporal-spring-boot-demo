package id.vida.workflowfacade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WorkflowFacadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowFacadeApplication.class, args);
	}

}
