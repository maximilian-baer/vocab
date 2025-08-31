package kickstart;

import kickstart.domain.User;
import kickstart.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.random.RandomGenerator;

@Controller
public class PageController {

    private UserRepository userRepository;

    public PageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @PostMapping("/")
    public String post(@RequestParam String newUserName) {
        userRepository.save(
                new User(RandomGenerator.getDefault().nextLong(), newUserName, "12345")
        );
        return "redirect:/";
    }
}
