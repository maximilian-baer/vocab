package kickstart;

import kickstart.domain.MessageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:5173")
public class MessageController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void receive(@RequestBody MessageRequest req) {
        // TODO: verarbeiten/speichern
        System.out.println("Got: " + req.getText());
        // keine Rückgabe -> 200 OK mit leerem Body
    }
}
