package dev.marvin.studentmanagement;

import com.github.javafaker.Faker;
import dev.marvin.studentmanagement.domain.Student;
import dev.marvin.studentmanagement.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			Faker faker = new Faker();

			for (int i = 0; i < 15; i++) {
				Student student = new Student();
				var firstName = faker.name().firstName();
				var lastName = faker.name().lastName();

				student.setFirstName(firstName);
				student.setLastName(lastName);

				student.setEmail(firstName.toLowerCase() + lastName.toLowerCase() + "@example.com");
				student.setPhone(faker.phoneNumber().cellPhone());
				student.setAddress(faker.address().fullAddress());
				student.setCourse(faker.educator().course());
				studentRepository.save(student);
			}
		};
	}

	@Bean
	WebMvcConfigurer corsConfig(){
		return new WebMvcConfigurer() {
			@SuppressWarnings("NullableProblems")
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedOrigins("http://localhost:4200");

			}
		};
	}

}
