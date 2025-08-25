package kickstart;

import kickstart.domain.DomainRole;
import kickstart.domain.User;
import kickstart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

@SpringBootApplication()
public class VocabApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(VocabApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createUser();
    }

    private void updateUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            var user = userRepository.findById(userId).get();
            user.setUserName("ArAstyle");
            userRepository.update(user);
        }
    }

    private void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private void getContactById(Long id) {
        if(userRepository.findById(id).isPresent()) {
            System.out.println(userRepository.findById(id).get());
        } else {
            System.out.println("User not found");
        }
    }

    private void listUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);
    }

    private void createUser() {
        User user = new User(Long.valueOf("-5703379327513563915"), "BattleStyle", "123");
        userRepository.save(user);
    }
}
