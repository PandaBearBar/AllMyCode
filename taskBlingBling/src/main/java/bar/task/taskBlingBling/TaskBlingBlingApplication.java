package bar.task.taskBlingBling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskBlingBlingApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskBlingBlingApplication.class, args);
	}

}
