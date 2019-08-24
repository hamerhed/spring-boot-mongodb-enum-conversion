package pl.psnc.hamerhed.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.psnc.hamerhed.mongodb.model.Gender;
import pl.psnc.hamerhed.mongodb.model.Organization;
import pl.psnc.hamerhed.mongodb.model.User;
import pl.psnc.hamerhed.mongodb.persistance.UserRepository;

@SpringBootApplication
public class SpringBootPersistenceApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
    public static void main(String ... args) {
        SpringApplication.run(SpringBootPersistenceApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		System.out.println("to moj program");
		
		User user = new User(Gender.FEMALE, Organization.X);
		//userRepository.save(user);
		
		user = userRepository.findById("5d5f9c6fa0389114edda1d1a").get();
		System.out.println("user id " + user + user.getGender());
	}

}
